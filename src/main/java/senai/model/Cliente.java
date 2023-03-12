package senai.model;

import java.sql.Date;

public class Cliente {
	
	private String nomeCliente;
	private String DataNascimentoCliente;
	private String CPFCliente;
	private String EnderecoCliente;
	private int numContaCliente;
	private String senhaCliente;
	
	
	public Cliente(String nomeCliente, String dataNascimentoCliente, String cPFCliente, String enderecoCliente, String senhaCliente) {
		super();
		this.nomeCliente = nomeCliente;
		this.DataNascimentoCliente = dataNascimentoCliente;
		this.CPFCliente = cPFCliente;
		this.EnderecoCliente = enderecoCliente;
		this.senhaCliente = senhaCliente;
	}





	public Cliente() {
		// TODO Auto-generated constructor stub
	}





	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public String getDataNascimentoCliente() {
		return DataNascimentoCliente;
	}


	public void setDataNascimentoCliente(String dataNascimentoCliente) {
		DataNascimentoCliente = dataNascimentoCliente;
	}


	public String getCPFCliente() {
		return CPFCliente;
	}


	public void setCPFCliente(String cPFCliente) {
		CPFCliente = cPFCliente;
	}


	public String getEnderecoCliente() {
		return EnderecoCliente;
	}


	public void setEnderecoCliente(String enderecoCliente) {
		EnderecoCliente = enderecoCliente;
	}


	public int getNumContaCliente() {
		return numContaCliente;
	}


	public void setNumContaCliente(int numContaCliente) {
		this.numContaCliente = numContaCliente;
	}
	public String getSenhaCliente() {
		return senhaCliente;
	}
	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}
	
	

}
