package dto;

public class FormaPagamentoRequest {
	
	private String tipo;
	private String parcelas;

	public FormaPagamentoRequest() {}

	public FormaPagamentoRequest(String tipo, String parcelas) {
		this.tipo = tipo;
		this.parcelas = parcelas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getParcelas() {
		return parcelas;
	}

	public void setParcelas(String parcelas) {
		this.parcelas = parcelas;
	}

}
