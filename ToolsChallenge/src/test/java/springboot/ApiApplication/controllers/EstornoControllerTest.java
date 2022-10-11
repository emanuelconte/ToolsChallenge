package springboot.ApiApplication.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import Enum.Status;
import controllers.EstornoController;
import dto.DescricaoRequest;
import dto.DescricaoResponse;
import dto.EstornoRequest;
import dto.EstornoResponse;
import dto.FormaPagamentoRequest;
import dto.FormaPagamentoResponse;
import dto.TransacaoRequest;
import dto.TransacaoResponse;
import services.EstornoService;

@SpringBootTest
public class EstornoControllerTest {

	@InjectMocks
	private EstornoController estornoController;

	@Mock
	private EstornoService estornoService;

	private TransacaoRequest transacaoReq;
	private DescricaoRequest descricaoReq;
	private FormaPagamentoRequest formaPagamentoReq;
	private EstornoRequest estornoReq;

	private TransacaoResponse transacaoRes;
	private DescricaoResponse descricaoRes;
	private FormaPagamentoResponse formaPagamentoRes;
	private EstornoResponse estornoRes;

	private String cartao = "1234567890123456";
	private String id = "1";
	private String valor = "900.00";
	private String dataHora = "09/10/2022 16:00:01";
	private String estabelecimento = "PetShop Mundo cão";
	private String nsu = "984654";
	private String codigoAutorizacao = "0123456";
	private Status status = Status.CANCELADO;
	private String tipo = "AVISTA";
	private String parcelas = "2";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		startEstorno();
	}

	@Test
	void receberUmEstornoRequesteERetornarUmEstornoResponse() {
		Mockito.when(estornoService.estornar((Mockito.any()))).thenReturn(estornoRes);
		ResponseEntity<EstornoResponse> response = estornoController.estornar(estornoReq);

		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(EstornoResponse.class, response.getBody().getClass());
	}

	@Test
	void buscarPorIdERetornarUmEstornoResponse() {
		Mockito.when(estornoService.findById(Mockito.anyString())).thenReturn(estornoRes);

		ResponseEntity<EstornoResponse> response = estornoController.findById("id");

		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(EstornoResponse.class, response.getBody().getClass());
	}

	private void startEstorno() {
		descricaoReq = new DescricaoRequest(valor, dataHora, estabelecimento);
		formaPagamentoReq = new FormaPagamentoRequest(tipo, parcelas);
		transacaoReq = new TransacaoRequest(cartao, id, descricaoReq, formaPagamentoReq);
		estornoReq = new EstornoRequest(transacaoReq);

		descricaoRes = new DescricaoResponse(valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status);
		formaPagamentoRes = new FormaPagamentoResponse(tipo, parcelas);
		transacaoRes = new TransacaoResponse(cartao, id, descricaoRes, formaPagamentoRes);
		estornoRes = new EstornoResponse(transacaoRes);
	}

}
