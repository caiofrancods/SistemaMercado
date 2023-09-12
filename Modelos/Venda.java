package Modelos;

import java.util.Date;
import java.util.Random;


public class Venda {
	private int codigo;
	private Date data;
	private Item[] itensVendidos = new Item[10];
	private String cliente;
	private double total;
	private Usuario atd;
	
	public static int quantidade = 0;
	
	public Venda(Carrinho car, String cliente, Usuario user) {
		if(car != null && cliente != null && cliente.length() > 3) {
			Item[] itens = car.listar();
			for(int i = 0; i < itens.length; i++) {
				if(itens[i] != null) {
					Produto prod = itens[i].getProduto();
					if(prod != null) {
						if(prod.getEstoque() - itens[i].getQuantidade() <= prod.getEstoque()) {
							prod.setEstoque(prod.getEstoque() - itens[i].getQuantidade());
							this.total += itens[i].getValor();
						}
					}	
				}
			}
			this.codigo = gerar_codigo();
			this.data = new Date();
			this.itensVendidos = car.listar();
			this.cliente = cliente;
			this.atd = user;
			quantidade += 1;
		}
	}
	
	int gerar_codigo() {
		Random rnd = new Random();
		return rnd.nextInt(1000, 9999);
	}

	public int getCodigo() {
		return codigo;
	}

	public Date getData() {
		return data;
	}

	public Item[] getItensVendidos() {
		return itensVendidos;
	}


	public String getCliente() {
		return cliente;
	}

	public double getTotal() {
		return total;
	}
	public Usuario getVendedor() {
		return atd;
	}
	
	
}
