package services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Enum.Status;
import dto.EstornoRequest;
import dto.EstornoResponse;
import model.Descricao;
import model.Estorno;
import model.Transacao;
import repositores.DescricaoRepository;
import repositores.EstornoRepository;
import repositores.FormaPagamentoRepository;
import repositores.TransacaoRepository;
import services.exceptions.DataIntegrityException;
import services.exceptions.ObjectNotFoundException;

@Service
public class EstornoService {

	@Autowired
	private EstornoRepository estornoRepo;

	@Autowired
	private DescricaoRepository descricaoRepo;

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepo;

	@Autowired
	private TransacaoRepository transacaoRepo; 
	
	public static final String NSU = "1234567";
	public static final String CODIGO_AUTORIZACAO = "7654321";
	public static final String MSG_OBJECT_NOT_FOUND = "Não encontrado! Id: ";
	public static final String MSG_DATA_INTEGRITY = "Transação existente! Id ";
	
	public EstornoResponse estornar(EstornoRequest estornoRequest) {
		
		Estorno estorno = new ModelMapper().map(estornoRequest, Estorno.class);
		
		findByTransacao(estorno);
		
		Descricao descricao = estorno.getTransacao().getDescricao();
		descricao.setNsu(NSU);
		descricao.setCodAutorizacao(CODIGO_AUTORIZACAO);
		descricao.setStatus(Status.CANCELADO);

		estornoRepo.save(estorno);
		transacaoRepo.save(estorno.getTransacao());
		descricaoRepo.save(descricao);
		formaPagamentoRepo.save(estorno.getTransacao().getFormaPagamento());

		return new ModelMapper().map(estorno, EstornoResponse.class);

	}

	public EstornoResponse findById(String id) {
		Optional<Estorno> estorno = estornoRepo.findById(id);
		if (estorno.isEmpty()) {
			throw new ObjectNotFoundException(MSG_OBJECT_NOT_FOUND + id);
		}
		return new ModelMapper().map(estorno.get(), EstornoResponse.class);
	}
		
	private void findByTransacao(Estorno estorno) {
		Optional<Transacao> transacao = transacaoRepo.findById(estorno.getTransacao().getId());
		
		if(transacao.isPresent()) {
			throw new DataIntegrityException(MSG_DATA_INTEGRITY + transacao.get().getId());
		}
	}
}
