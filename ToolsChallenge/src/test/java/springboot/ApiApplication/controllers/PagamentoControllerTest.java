package springboot.ApiApplication.controllers;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import Enum.Status;
import controllers.PagamentoController;
import dto.DescricaoRequest;
import dto.DescricaoResponse;
import dto.FormaPagamentoRequest;
import dto.FormaPagamentoResponse;
import dto.PagamentoRequest;
import dto.PagamentoResponse;
import dto.TransacaoRequest;
import dto.TransacaoResponse;
import services.PagamentoService;

public class PagamentoControllerTest {

	@InjectMocks
	private PagamentoController pagamentoController;

	@Mock
	private PagamentoService pagamentoService;

	private TransacaoRequest transacaoReq;
	private DescricaoRequest descricaoReq;
	private FormaPagamentoRequest formaPagamentoReq;
	private PagamentoRequest pagamentoReq;

	private TransacaoResponse transacaoRes;
	private DescricaoResponse descricaoRes;
	private FormaPagamentoResponse formaPagamentoRes;
	private PagamentoResponse pagamentoRes;

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
		startPagamentos();
	}

	@Test
	void receberUmPagamentoRequestERetornarUmPagamentoResponse() {
		Mockito.when(pagamentoService.pagamento((Mockito.any()))).thenReturn(pagamentoRes);
		ResponseEntity<PagamentoResponse> response = pagamentoController.pagamento(pagamentoReq);

		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(PagamentoResponse.class, response.getBody().getClass());
	}
	
	@Test
	void retornarUmaListaDePagamentosResponse() {
		Mockito.when(pagamentoService.findAll()).thenReturn(List.of(pagamentoRes));
		
		ResponseEntity<List<PagamentoResponse>> response = pagamentoController.findAll();
		
		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(PagamentoResponse.class, response.getBody().get(0).getClass());
	}
	@Test
	void buscarPorIdERetornarUmPagamentoResponse() {
		Mockito.when(pagamentoService.findById(Mockito.anyString())).thenReturn(pagamentoRes);

		ResponseEntity<PagamentoResponse> response = pagamentoController.findById("id");

		Assertions.assertNotNull(response);
		Assertions.assertNotNull(response.getBody());
		Assertions.assertEquals(ResponseEntity.class, response.getClass());
		Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assertions.assertEquals(PagamentoResponse.class, response.getBody().getClass());
	}

	private void startPagamentos() {

		descricaoReq = new DescricaoRequest(valor, dataHora, estabelecimento);
		formaPagamentoReq = new FormaPagamentoRequest(tipo, parcelas);
		transacaoReq = new TransacaoRequest(cartao, id, descricaoReq, formaPagamentoReq);
		pagamentoReq = new PagamentoRequest(transacaoReq);

		descricaoRes = new DescricaoResponse(valor, dataHora, estabelecimento, nsu, codigoAutorizacao, status);
		formaPagamentoRes = new FormaPagamentoResponse(tipo, parcelas);
		transacaoRes = new TransacaoResponse(cartao, id, descricaoRes, formaPagamentoRes);
		pagamentoRes = new PagamentoResponse(transacaoRes);

	}

}
