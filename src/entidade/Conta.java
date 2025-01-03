package entidade;

import utilitarios.Utils;

public class Conta {
	
	private static int contador = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta(Pessoa pessoa) {
		this.numeroConta = contador;
		this.pessoa = pessoa;
		contador += 1;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public double getSaldo() {
		return saldo;
	}
	
	//Métodos
	public void depositar(double valor) {
		if(valor > 0) {
			saldo += valor;
			System.out.println("Deposito foi realizado com sucesso!");
		}else {
			System.out.println("Não foi possível depositar!");
		}
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
	
	public void transferirPara(Conta contaDestino, Double valor) {
		if(valor > saldo) {
			System.out.println("Saldo insulficiente!!");
		}else {
			 this.saldo -= valor;
		     contaDestino.saldo = contaDestino.getSaldo() + valor;
		     System.out.println("Transferência realizada com sucesso!");
		}
		
	}

	
	public String toString() {
		return "Numero da Conta = " + this.getNumeroConta() + 
				", Nome: " + pessoa.getNome() + 
				", CPF: " + pessoa.getCpf() +
				", Email: " + pessoa.getEmail()+
				", Saldo: " + Utils.doubleToString(this.getSaldo());
	}
	
}
