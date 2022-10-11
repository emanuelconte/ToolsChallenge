package dto;

public class EstornoRequest {
	
	private TransacaoRequest transacao;

	public EstornoRequest() {}

	public EstornoRequest(TransacaoRequest transacao) {
		this.transacao = transacao;
	}

	public TransacaoRequest getTransacao() {
		return transacao;
	}

	public void setTransacao(TransacaoRequest transacao) {
		this.transacao = transacao;
	}
}
