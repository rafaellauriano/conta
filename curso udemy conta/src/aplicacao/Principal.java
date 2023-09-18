package aplicacao;

import java.util.Scanner;

import entidade.Conta;

public class Principal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Conta conta;
		
		System.out.print("Digite o número da conta: ");
		int numero = sc.nextInt();
		System.out.print("Digite o nome do titular: ");
		sc.nextLine();
		String nome = sc.nextLine();
		System.out.println("Tem depósito inicial (s/n): ");
		char resposta = sc.next().charAt(0);
		
		if(resposta == 's') {
			System.out.print("Digite o valor do deposito inicial: ");
			double depositoInicial = sc.nextDouble();
			conta = new Conta(numero, nome, depositoInicial);
		}else {
			conta = new Conta(numero, nome);
		}
		
		System.out.println();
		System.out.println("Dados atualizados:");
		System.out.println(conta);
		
		
		sc.close();

	}

}
