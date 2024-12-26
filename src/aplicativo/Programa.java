package aplicativo;

import java.util.Scanner;

import entidade.Conta;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Conta conta;
		
		System.out.print("Digite o número da conta: ");
		int numero = sc.nextInt();
		System.out.print("Digite o nome do titular: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.print("Tem depósito inicial(s/n): ");
		char resposta = sc.next().charAt(0);
		
		if(resposta == 's') {
			System.out.print("Digite o valor do depósito inicial: ");
			double depositoInicial = sc.nextDouble();
			conta = new Conta(numero, nome, depositoInicial);
		}
		else {
			conta = new Conta(numero, nome);
		}
		
		System.out.println();
		System.out.println("Dados da conta");
		System.out.println(conta);
		
		System.out.println();
		System.out.print("Deseja fazer um depósito(s/n): ");
		resposta = sc.next().charAt(0);
		if(resposta == 's') {
			System.out.print("Digite o valor do deposito: ");
			double deposito = sc.nextDouble();
			conta.depositar(deposito);
			System.out.println("Dados da conta");
			System.out.println(conta);
		}
		
		System.out.println();
		System.out.print("Dejeja fazer um saque(s/n): ");
		resposta = sc.next().charAt(0);
		if(resposta == 's') {
			System.out.print("Digite o valor do saque: ");
			double saque = sc.nextDouble();
			conta.sacar(saque);
			System.out.println("Dados da conta");
			System.out.println(conta);
		}
		
		
		System.out.println();
		System.out.print("Dejeja fazer uma tranferência(s/n): ");
		resposta = sc.next().charAt(0);
		if(resposta == 's') {
			System.out.print("Digite o valor da transferência: ");
			double valor = sc.nextDouble();
			conta.transferirPara(conta, valor);
			System.out.println("Dados atualiados");
			System.out.println(conta);
		}
		
		sc.close();
		

	}

}
