package senai.model;

import java.sql.Date;

public class Transacoes {
	
	private String numContaCliente;
	private String TipoTransacao;
	private Date DataTransacao;
	private Float valorTransacao;
	
	
	public Transacoes(String numContaCliente, String tipoTransacao, Date dataTransacao, Float valorTransacao) {
		super();
		this.numContaCliente = numContaCliente;
		TipoTransacao = tipoTransacao;
		DataTransacao = dataTransacao;
		this.valorTransacao = valorTransacao;
	}
	
	public Transacoes() {

	}


	public String getNumContaCliente() {
		return numContaCliente;
	}

	public void setNumContaCliente(String numContaCliente) {
		this.numContaCliente = numContaCliente;
	}

	public String getTipoTransacao() {
		return TipoTransacao;
	}

	public void setTipoTransacao(String tipoTransacao) {
		TipoTransacao = tipoTransacao;
	}

	public Date getDataTransacao() {
		return DataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		DataTransacao = dataTransacao;
	}

	public Float getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(Float valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	
	
	
	
}
