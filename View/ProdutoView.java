package View;

import java.util.Random;
import java.util.Scanner;
import Modelos.Produto;

public class ProdutoView {
	
	static Scanner scn = new Scanner(System.in);
	
	public Produto inserir() {
		System.out.println("_Inserindo produto_");
		System.out.print("Insira o nome do produto: ");
		String nome = scn.next();
		System.out.print("Insira o preco do produto: ");
		double preco = scn.nextDouble();
		while (preco < 0) {
			System.out.println("Preço inválido. Insira novamente: ");
			preco = scn.nextDouble();
		}
		System.out.print("Insira a quantidade do produto em estoque: ");
		int estoque = scn.nextInt();
		while (estoque < 0) {
			System.out.println("Estoque inválido. Insira novamente: ");
			estoque = scn.nextInt();
		}
		int codigo = gerar_codigo();
		
		return new Produto(codigo, nome, preco, estoque);
	}
	
	public int excluir() {
		if(Produto.quantidade == 0) {
			System.out.println("Não há produtos cadastrados!");
		}else {
			System.out.print("Digite o código do produto que você deseja excluir: ");
			int cod = scn.nextInt();
			return cod;
		}
		return -2;
	}
	
	public int alterar() {
		if(Produto.quantidade == 0) {
			System.out.println("Não há produtos cadastrados!");
		}else {
			System.out.print("Digite o código do produto que você deseja alterar: ");
			int cod = scn.nextInt();
			return cod;
		}
		return -1;
	}
	
	public Produto alterar(Produto aux) {
			if (aux == null) {
				System.out.println("Produto não encontrado, tente novamente.");
			} else {
				int cod = aux.getCodigo();
				String nome = aux.getNome();
				double preco = aux.getPreco();
				double estoque = aux.getEstoque();
				System.out.println("_Alterando produto_");
				System.out.println("Opções: ");
				System.out.println("1 - Nome");
				System.out.println("2 - Preço");
				System.out.println("3 - Estoque");
				System.out.print("Digite qual dado deseja alterar: ");
				int opcs = scn.nextInt();
				opcs = Lib.verifOpc(1,3,opcs);
				if (opcs == 1) {
					System.out.print("Insira o novo nome do produto: ");
					nome = scn.next();
				} else {
					if (opcs == 2) {
						System.out.print("Insira o novo preco do produto: ");
						preco = scn.nextDouble();
						while (preco < 0) {
							System.out.println("Preço inválido. Insira novamente: ");
							preco = scn.nextDouble();
						}
					} else {
						if (opcs == 3) {
							System.out.print("Insira a nova quantidade do produto: ");
							estoque = scn.nextDouble();
							while (estoque < 0) {
								System.out.println("Estoque inválido. Insira novamente: ");
								estoque = scn.nextDouble();
							}
						}
					}
				}			
				return new Produto(cod, nome, preco, estoque);
			}
			return null;
		}
	
	public void listar(Produto[] produtos, int espaco) {
		System.out.println();
	    System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	            (espaco) + "s%-" + (espaco) + "s\n",
	            "CÓDIGO", "NOME", "PREÇO", "ESTOQUE");
	    for (Produto produto : produtos) {
	        if (produto != null) {
	            System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	                    (espaco) + "s%-" + (espaco) + "s\n",
	                    produto.getCodigo(), produto.getNome(), String.format("%.2f", produto.getPreco()),
	                    String.format("%.2f",produto.getEstoque()));
	        }
	    }
	    System.out.println();
	}
	
	public int gerar_codigo() {
		Random rnd = new Random();
		return rnd.nextInt(100, 999);
	}

}
