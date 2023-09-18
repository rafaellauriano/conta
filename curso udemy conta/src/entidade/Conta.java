package entidade;

public class Conta {
	
	private int numeroConta;
	private String titular;
	private double saldo;
	
	//construtores
	public Conta(int numero, String titular) {
		this.numeroConta = numero;
		this.titular = titular;
	}

	public Conta(int numero, String titular, double depositoInicial) {
		this.numeroConta = numero;
		this.titular = titular;
		depositar(depositoInicial);
	}
	
	
	//métodos acessores
	public int getNumero() {
		return numeroConta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	//métodos
	public void depositar(double valor) {
		saldo += valor;
	}
	
	public void sacar(double valor) {
		saldo -= valor + 5.0;
	}
	
	public String toString() {
		return "Conta "
				+ numeroConta
				+ ", titular: "
				+ titular
				+ ", saldo: $ "
				+ String.format("%.2f", saldo);
	}
	

}
