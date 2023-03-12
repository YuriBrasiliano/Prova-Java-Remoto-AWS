package senai.model;

import java.sql.Date;

public class Transacoes {
	
	private int numContaCliente;
	private String TipoTransacao;
	private Date DataTransacao;
	private float valorTransacao;
	
	
	public Transacoes(int numContaCliente, String tipoTransacao, Date dataTransacao, float valorTransacao) {
		super();
		this.numContaCliente = numContaCliente;
		TipoTransacao = tipoTransacao;
		DataTransacao = dataTransacao;
		this.valorTransacao = valorTransacao;
	}
	
	public Transacoes() {

	}

	public int getNumContaCliente() {
		return numContaCliente;
	}

	public void setNumContaCliente(int numContaCliente) {
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

	public float getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(float valorTransacao) {
		this.valorTransacao = valorTransacao;
	}
	
	
	
	
}
