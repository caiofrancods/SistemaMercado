package Control;

import Modelos.Produto;
import Repositorio.RepoProduto;
import View.ProdutoView;

public class ControleProduto {
	private ProdutoView produtoView;
	private RepoProduto repoProduto;
	
	public ControleProduto() {
		produtoView = new ProdutoView();
		repoProduto = new RepoProduto();
	}
	
	public boolean inserir() {
		Produto p = produtoView.inserir();
		if(p != null) {
			if(buscarPorNome(p.getNome())) {
				return false;
			}else {
				if(repoProduto.inserir(p)) {
					return true;
				}else {
					return false;
				}
			}
			
		}
		return false;
	}
	
	public boolean excluir() {
		int p = produtoView.excluir();
		if(p == -1 || p == -2) {
			return false;
		}else {
			if(repoProduto.excluir(p)) {
				return true;
			}else {
				return false;
			}	
		}
	}
	
	public boolean alterar() {
		int cod = produtoView.alterar();
		if(cod != -1) {
			Produto produto = buscarPorCodigo(cod);
			Produto alterar = produtoView.alterar(produto);
			if(buscarPorNome(alterar.getNome())) {
				return false;
			}else {
				if(repoProduto.alterar(alterar)) {
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void listar(int espaco) {
		produtoView.listar(repoProduto.listar(), espaco);
	}
	
	
	public int buscar(int cod) {
		Produto prod = repoProduto.buscarPorCodigo(cod);
		if(prod != null) {
			return prod.getCodigo();
		}else {
			return -1;
		}
	}
	
	public Produto buscarPorCodigo(int cod) {
		Produto prod = repoProduto.buscarPorCodigo(cod);
		if(prod != null) {
			return prod;
		}else {
			return null;
		}
	}
	
	public boolean buscarPorNome(String nome) {
		if(nome != null) {
			Produto prod = repoProduto.buscarPorNome(nome);
			if(prod != null) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	
	public void init() {
		repoProduto.inserir(new Produto(1001, "Arroz", 24.99, 5));
		repoProduto.inserir(new Produto(1002, "Feijão", 8.99, 15));
		repoProduto.inserir(new Produto(1003, "Macarrão", 5.99, 25));
		repoProduto.inserir(new Produto(1004, "Trigo", 6.99, 10));
		repoProduto.inserir(new Produto(1005, "Fubá", 3.99, 8));
	}

}
