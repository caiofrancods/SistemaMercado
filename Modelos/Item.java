package Modelos;

public class Item {
	private Produto produto;
	private double valor;
	private double quantidade;

	public Item(Produto produto, double quant){
		if(produto != null) {
			if(produto.getEstoque() >= quantidade && produto.getStatus() == 1) {
				this.produto = produto;
				this.valor = produto.getPreco()*quant;
				this.quantidade = quant;
			}			
		}
	}
	public double getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(double quant) {
		if(produto.getEstoque() >= quantidade) {
			this.quantidade = quant;
			this.valor = quant*produto.getPreco();
		}
	}
	
	public double getValor() {
		return valor;
	}
	
	public Produto getProduto() {
		return produto;
	}

}