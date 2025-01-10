package aplicativo;

import java.util.ArrayList;
import java.util.Scanner;

import entidade.Conta;
import entidade.Pessoa;

public class AgenciaBancaria {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	

	public static void main(String[] args) {
		
		contasBancarias =new ArrayList<Conta>();
		operacoes();
		
	}
	
	public static void operacoes() {
		int operacao = 0;
		
		while(operacao != 6) {
			System.out.println("------------------------------------------------------");
			System.out.println("--------------Bem vindos a nossa Agência--------------");
			System.out.println("------------------------------------------------------");
			System.out.println("***** Selecione uma operação que deseja realizar *****");
			System.out.println("------------------------------------------------------");
			System.out.println("|   Opção 1 - Criar conta   |");
			System.out.println("|   Opção 2 - Depositar     |");
			System.out.println("|   Opção 3 - Sacar         |");
			System.out.println("|   Opção 4 - Trânsferir    |");
			System.out.println("|   Opção 5 - Listar        |");
			System.out.println("|   Opção 6 - Sair          |");
			System.out.println();
			
			operacao = sc.nextInt();
			
			switch(operacao) {
			case 1:
				criarConta();
				break;
			case 2:
				depositar();
				break;
			case 3:
				sacar();
				break;
			case 4:
				transferir();
				break;
			case 5:
				listarContas();
				break;
			case 6:
				System.out.println("Obrigado por usar nossa agência");
				System.out.println();
				break;
				
			default:
				System.out.println("Opção inválida!");
				break;
			}
		
		}
	}
	
	public static void criarConta() {
		
		System.out.println("Criar conta!");
		
		System.out.print("Nome: ");
		String nome = sc.next();
		
		System.out.print("CPF: ");
		String cpf = sc.next();
		
		System.out.print("email: ");
		String email = sc.next();
		
		Pessoa pessoa = new Pessoa(nome, cpf, email);
		
		Conta conta = new Conta(pessoa);
		
		contasBancarias.add(conta);
		
		System.out.println("Conta criada com sucesso");
		System.out.println();
		
	}
	
	//método para encontrar uma conta existente
	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if(contasBancarias.size() > 0) {
			for(Conta c: contasBancarias) {
				if(c.getNumeroConta() == numeroConta) {
					conta = c;
				}	
			}
		}
		return conta;
	}
	
	public static void depositar() {
		System.out.println("Número da conta: ");
		int numeroConta = sc.nextInt();
		
		Conta conta = encontrarConta(numeroConta);//verificar se a conta exite
		
		if(conta != null) {
			System.out.print("Qual valor deseja depositar? ");
			Double valorDeposito = sc.nextDouble();
			conta.depositar(valorDeposito);
			System.out.print("Valor depositado com sucesso! ");
			System.out.println();
		}else {
			System.out.println("conta não encontrada! ");
		}
	}
	
	public static void sacar() {
		System.out.print("Número da conta: ");
		int numeroConta = sc.nextInt();
		
		Conta conta = encontrarConta(numeroConta);
		
		if(conta != null) {
			System.out.print("Qual o valor deseja sacar? ");
			Double valorSaque = sc.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Valor sacado com sucesso! ");
			System.out.println();
		}else {
			System.out.println("conta não encontrada!");
		}
		
	}
	
	public static void transferir() {
		System.out.println("Número da conta do remetente:");
		int numeroRemetente = sc.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Número da conta do destinatário:");
			int numerodestinatario = sc.nextInt();
			
			Conta contaDestinatario = encontrarConta(numerodestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor da transferência:");
				Double valor = sc.nextDouble();
				
				contaRemetente.transferirPara(contaDestinatario, valor);
			}
		}
		
	}
	
	public static void listarContas() {
		if(contasBancarias.size() > 0) {
			for(Conta conta: contasBancarias) {
				System.out.println(conta);
			}
		}else {
			System.out.println("Não há contas cadrastadas");
		}
		
	}
	

}

