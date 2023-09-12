package Repositorio;

import Modelos.Produto;

public class RepoProduto {
	private Produto[] produtos;
	
	public RepoProduto() {
		produtos = new Produto[10];
	}
	

	public boolean inserir(Produto produto) {
		Produto prod = buscarPorNome(produto.getNome());
		if(prod != null) {
			if(prod.getStatus() == 0) {
				prod.setStatus(1);
				prod.setPreco(produto.getPreco());
				prod.setEstoque(produto.getEstoque());
				return true;
			}else {
				return false;
			}
			
		}else {
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] == null) {
					produtos[i] = new Produto(produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getEstoque());
					if(produtos[i].getNome() != null) {
						return true;
					}else {
						return false;
					}						
				}
			}
		}
		return false;
	}
	

	public boolean excluir(int cod) {
		Produto prod = buscarPorCodigo(cod);
		if(prod.getVendas() == 0) {
			int pos = -1;
			for (int i = 0; i < produtos.length; i++) {
				if (produtos[i] != null && cod == produtos[i].getCodigo()) {
					pos = i;
				}
			}
			if (pos != -1) {
				for (int i = pos + 1; i < produtos.length; i++) {
					if(produtos[i-1] != null) {
						produtos[i-1] = produtos[i];
					}				
				}
				return true;
			}
			return false;
		}else {
			prod.setStatus(0);
			return true;
		}
	}
	

	public boolean alterar(Produto produto) {
		int pos = -1;
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null) {
				if (produto.getCodigo() == produtos[i].getCodigo()) {
					pos = i;
				}
			}
		}
		if (pos != -1) {
			Produto p1 = new Produto(produto.getCodigo(), produto.getNome(), produto.getPreco(), produto.getEstoque());
			produtos[pos] = p1;
			return true;
		} else {
			return false;
		}
	}
	

	public Produto[] listar() {
		Produto[] produtosAux = new Produto[Produto.quantidade];
		int cont = 0;
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null && produtos[i].getStatus() == 1) {
				produtosAux[cont] = produtos[i];
				cont++;
			}
		}
		return produtosAux;
	}
	
	
	public Produto buscarPorNome(String nome) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null && nome != null) {
				if(produtos[i].getNome() != null) {
					if (nome.compareTo(produtos[i].getNome()) == 0) {
						return produtos[i];
					}
				}				
			}
		}
		return null;
	}
	
	public Produto buscarPorCodigo(int cod) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i] != null) {
				if (produtos[i].getCodigo() == cod && produtos[i].getStatus() == 1) {
					return produtos[i];
				}
			}
		}
		return null;
	}
}
