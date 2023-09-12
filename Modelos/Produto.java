package Modelos;


public class Produto {
	private int codigo;
	private String nome;
	private double preco;
	private double estoque;	
	private int vendas;
	private int status;
	
	public static int quantidade = 0;
	
	public Produto(int codigo, String nome, double preco, double quant) {
		if (nome != null && nome.length() >= 3 && codigo >= 100) {
			this.codigo = codigo;
			this.nome = nome;
			this.preco = preco;
			this.estoque = quant;
			this.vendas = 0;
			this.status = 1;
			quantidade += 1;			
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null && nome.length() > 3) {
			this.nome = nome;
		}
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if(preco >= 0) {
			this.preco = preco;
		}			
	}

	public double getEstoque() {
		return estoque;
	}

	public void setEstoque(double quantNoEstoque) {
		if(quantNoEstoque >= 0) {
			this.estoque = quantNoEstoque;
		}
	}
	
	public int getVendas() {
		return vendas;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		if(status == 1 || status == 0) {
			this.status = status;
		}
	}
}