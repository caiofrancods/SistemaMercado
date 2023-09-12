package Modelos;

public class Carrinho {
	private Item[] itens = new Item[10];
	
	public boolean addItens(Item item) {
		if(item != null && item.getProduto() != null) {
			int control = 1;
			for(int i = 0; i < itens.length; i++) {
				if(itens[i] != null) {
					if(itens[i].getProduto().getCodigo() == item.getProduto().getCodigo()) {
						itens[i].setQuantidade(itens[i].getQuantidade() + item.getQuantidade());
						control = 2;
						break;
					}
				}				
			}
			if(control == 1) {
				for(int i = 0; i < itens.length; i++) {
					if(itens[i] == null) {
						itens[i] = item;
						return true;
					}
				}
			}else {
				return true;
			}
		}		
		return false;
	}
	
	public Item[] listar() {
		Item[] list = new Item[10];
		int k = 0;
		for(int i = 0; i < itens.length; i++) {
			if(itens[i] != null) {
				list[k] = itens[i];
				k++;
			}
		}
		return list;
	}
}
