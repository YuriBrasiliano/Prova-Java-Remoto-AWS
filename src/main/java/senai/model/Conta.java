package senai.model;

public class Conta {
	
	private String numConta;
	private Float saldoConta;
	private String tipodaConta;
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public Float getSaldoConta() {
		return saldoConta;
	}
	public void setSaldoConta(Float saldoConta) {
		this.saldoConta = saldoConta;
	}
	public String getTipodaConta() {
		return tipodaConta;
	}
	public void setTipodaConta(String tipodaConta) {
		this.tipodaConta = tipodaConta;
	}
	
	public Conta(String numConta, Float saldoConta, String tipodaConta) {
		super();
		this.numConta = numConta;
		this.saldoConta = saldoConta;
		this.tipodaConta = tipodaConta;
	}
	
	
	

}
