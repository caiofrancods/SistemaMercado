package View;

import Modelos.Venda;
import Modelos.Item;
import Modelos.Produto;

import java.util.Scanner;

public class VendaView {
		
	static Scanner scn = new Scanner(System.in);
	
	public void listarCarrinho(Item[] list) {
		if(list[0] == null) {
			System.out.println("Não há produtos no carrinho");
		}else {
			System.out.println("");
			System.out.println("Itens no carrinho: ");
			for(int i = 0; i < list.length; i++) {
				if(list[i] != null) {
					System.out.println((i+1) + " - " + list[i].getProduto().getNome() + " (" + list[i].getQuantidade() + ") ");
				}								
			}
			System.out.println("");
		}
	}
	
	public int adicionarProdutoCarrinho() {
		System.out.print("Digite o código do produto: ");
		int cod = scn.nextInt();
		while(cod < 100 || cod > 999) {
			
		}
		return cod;
	}
	
	public Item adicionarProdutoCarrinho(Produto prod) {
		if(prod != null) {	
			System.out.print("Quantidade do produto: ");
			int quant = scn.nextInt();
			return new Item(prod, quant);
		}else {
			return null;
		}
	}
	
	
	public String finalizarVenda() {
		System.out.print("Insira o nome do cliente: ");
		String clienteNome = scn.next();
		while(clienteNome == null) {
			System.out.print("Inválido. Insira novamente o nome do cliente: ");
			clienteNome = scn.next();
		}
		return clienteNome;
	}
	
	public void listarVendas(Venda[] vendas, int espaco) {
		System.out.printf("%-" + espaco + "s%-" + espaco + "s%-" + espaco + "s%-" + espaco + "s\n",
				"CÓDIGO", "DATA", "CLIENTE", "TOTAL");
		for (int i = 0; i < vendas.length; i++) {
			if (vendas[i] != null) {
				System.out.printf("%-" + espaco + "s%-" + espaco + "s%-" + espaco + "s%-" + espaco + "s\n",
						vendas[i].getCodigo(), vendas[i].getData(), vendas[i].getCliente(),
						String.format("%.2f", vendas[i].getTotal()));
			}
		}
	}
	public void listarVendasDia(Venda[] vendas, int espaco) {
		System.out.printf("%-" + espaco + "s%-" + espaco + "s%-" + espaco + "s\n",
				"CÓDIGO", "DATA", "TOTAL");
		for (int i = 0; i < vendas.length; i++) {
			if (vendas[i] != null) {
				System.out.printf("%-" + espaco + "d%-" + espaco + "s%-" + espaco + "s\n",
						vendas[i].getCodigo(), vendas[i].getData(), String.format("%.2f", vendas[i].getTotal()));
			}
		}
	}
	
	public void detalharVenda(Venda vends) {
		if(vends != null) {
			System.out.println("");
			System.out.println("Código da Venda: " + vends.getCodigo());
			System.out.println("Data da Venda: "+ vends.getData());
			System.out.println("Nome do Cliente: " + vends.getCliente());
			System.out.println("Nome do Vendedor: " + vends.getVendedor());
			Item[] itens = vends.getItensVendidos();
			System.out.println("Produtos vendidos: ");
			for(int i = 0; i < itens.length; i++) {
				if(itens[i] != null) {
					System.out.println(itens[i].getProduto().getNome() + " (" + itens[i].getQuantidade() + ") ");
				}
			}
			System.out.println("Valor total: " + vends.getTotal());
		}
	}
}
