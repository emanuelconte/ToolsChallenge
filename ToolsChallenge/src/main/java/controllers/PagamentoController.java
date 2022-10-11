package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.PagamentoRequest;
import dto.PagamentoResponse;
import services.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;

	@PostMapping
	public ResponseEntity<PagamentoResponse> pagamento(@RequestBody PagamentoRequest pagamentoRequest) {
		PagamentoResponse pagamentoResponse = pagamentoService.pagamento(pagamentoRequest);
		return ResponseEntity.ok(pagamentoResponse);
	}

	@GetMapping
	public ResponseEntity<List<PagamentoResponse>> findAll() {
		List<PagamentoResponse> pagamentos = pagamentoService.findAll();
		return ResponseEntity.ok(pagamentos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PagamentoResponse> findById(@PathVariable String id) {
		PagamentoResponse pagamentoResponse = pagamentoService.findById(id);
		return ResponseEntity.ok(pagamentoResponse);
	}
}