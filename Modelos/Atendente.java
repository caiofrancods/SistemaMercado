package Modelos;

public class Atendente extends Usuario{
	private double totalValorVendas;
	
	public Atendente(String nome, String login, String senha) {
		super(nome, login, senha);
		totalValorVendas = 0;
	}
	
	public void somarVenda(double venda) {
		totalValorVendas += venda;
	}

	public double getVendas() {
		return this.totalValorVendas;
	}
}
