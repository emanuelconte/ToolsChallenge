package dto;

public class PagamentoRequest {
	
	private TransacaoRequest transacao;

	public PagamentoRequest() {}

	public PagamentoRequest(TransacaoRequest transacao) {
		this.transacao = transacao;
	}

	public TransacaoRequest getTransacao() {
		return transacao;
	}

	public void setTransacao(TransacaoRequest transacao) {
		this.transacao = transacao;
	}
}
