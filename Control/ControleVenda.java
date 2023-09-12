package Control;

import Repositorio.RepoVenda;
import View.VendaView;
import Modelos.Venda;
import Modelos.Item;
import Modelos.Usuario;
import Modelos.Produto;
import Modelos.Atendente;
import Modelos.Carrinho;

public class ControleVenda {
	private VendaView vendaView;
	private RepoVenda repoVenda;
	private Carrinho car;
	private Usuario login;
	
	public ControleVenda() {
		vendaView = new VendaView();
		repoVenda = new RepoVenda();
	}
	
	public void setLogin(Usuario login) {
		if(login != null) {
			this.login = login;
		}
	}
	
	public boolean abrirCarrinho() {
		this.car = new Carrinho();
		return true;
	}
	
	public int adicionarProdutoCarrinho() {
		int cod = vendaView.adicionarProdutoCarrinho();
		ControleProduto control = new ControleProduto();
		Produto prod = control.buscarPorCodigo(cod);
		if(prod == null) {
			return 1;
		}else {
			Item item = vendaView.adicionarProdutoCarrinho(prod);
			car.addItens(item);
		}
		return 2;
	}
	
	public void listarCarrinho() {
		vendaView.listarCarrinho(car.listar());
	}
	
	public boolean fecharCarrinho() {
		this.car = null;
		return true;
	}
	
	public boolean inserir() {
		String cliente = vendaView.finalizarVenda();
		Item[] itens = car.listar();
		if(itens[0] != null) {
			if(this.car != null) {
				Venda venda = new Venda(car, cliente, login);
				if(venda != null) {
					((Atendente)login).somarVenda(venda.getTotal());
					if(repoVenda.inserir(venda)) {
						return true;
					}				
					
				}		
			}	
		}
		return false;		
	}
	
	public boolean listarVendas(int espaco) {
		Venda[] vendas = repoVenda.listaVendas();
		if(vendas != null) {
			vendaView.listarVendas(vendas, espaco);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean listarVendasDia(int espaco, int dia, int mes, int ano) {
		Venda[] vendas = repoVenda.listaVendasDia(dia, mes, ano);
		if(vendas != null) {
			vendaView.listarVendasDia(vendas, espaco);
			return true;
		}else {
			return false;
		}
	}
	
	public int detalharVenda(int cod) {
		Venda result = repoVenda.buscar(cod);
		if(result == null) {
			return 404;
		}else {
			vendaView.detalharVenda(result);
			return 0;
		}
	}
	public void init(ControleProduto controlProd) {
		Carrinho car = new Carrinho();
		car.addItens(new Item(controlProd.buscarPorCodigo(1001), 2));
		car.addItens(new Item(controlProd.buscarPorCodigo(1002), 2));
		this.repoVenda.inserir(new Venda(car, "Fulano", login));
		Carrinho car2 = new Carrinho();
		car2.addItens(new Item(controlProd.buscarPorCodigo(1003), 2));
		car2.addItens(new Item(controlProd.buscarPorCodigo(1005), 2));
		this.repoVenda.inserir(new Venda(car2, "Cliente Tal", login));
	}
}
