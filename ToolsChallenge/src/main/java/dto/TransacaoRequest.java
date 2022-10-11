package dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransacaoRequest implements Serializable {
	
	private String cartao;
	private String id;
	private DescricaoRequest descricao;
	private FormaPagamentoRequest formaPagamento;

	public TransacaoRequest() {}

	public TransacaoRequest(String cartao, String id, DescricaoRequest descricao,
			FormaPagamentoRequest formaPagamento) {
		this.cartao = cartao;
		this.id = id;
		this.descricao = descricao;
		this.formaPagamento = formaPagamento;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DescricaoRequest getDescricao() {
		return descricao;
	}

	public void setDescricao(DescricaoRequest descricao) {
		this.descricao = descricao;
	}

	public FormaPagamentoRequest getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoRequest formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
