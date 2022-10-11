package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Enum.Status;

@Entity
public class Descricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String valor;
	private String dataHora;
	private String estabelecimento;
	private String nsu;
	private String codAutorizacao;
	private Status status;

	public Descricao() {}
	
	public Descricao(String id, String valor, String dataHora, String estabelecimento, String nsu,
			String codAutorizacao, Status status) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataHora = dataHora;
		this.estabelecimento = estabelecimento;
		this.nsu = nsu;
		this.codAutorizacao = codAutorizacao;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getNsu() {
		return nsu;
	}

	public void setNsu(String nsu) {
		this.nsu = nsu;
	}

	public String getCodAutorizacao() {
		return codAutorizacao;
	}

	public void setCodAutorizacao(String codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}
