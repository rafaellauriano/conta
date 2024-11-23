package entidade;

public class Conta {
	
	private int numeroConta;
	private String nomeTitular;
	private double saldo;
	
	public Conta() {
		
	}
	
	public Conta(int numeroConta, String nomeTitular, double depositoInicial) {
		super();
		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
		depositar(depositoInicial);
	}

	public Conta(int numeroConta, String nomeTitular) {
		this.numeroConta = numeroConta;
		this.nomeTitular = nomeTitular;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public boolean sacar(double valor) {
		if(saldo < valor) {
			System.out.println("Saldo insulficiente!! Saque não realizado...");
			return false;
		}else {
			saldo -= valor ;
			System.out.println("Saque realiado com sucesso!!");
			return true;
		}
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public String toString() {
		return "Numero da Conta = " + numeroConta 
				+ ", Nome do Titular = " 
				+ nomeTitular + ", Saldo = $" 
				+ String.format("%.2f", saldo);
	}
	
}
