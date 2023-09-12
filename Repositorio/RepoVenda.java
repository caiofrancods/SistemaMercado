package Repositorio;

import java.util.Calendar;

import Modelos.Venda;

public class RepoVenda {
	private Venda[] vendas;
	
	public RepoVenda() {
		vendas = new Venda[10];
	}
	
	public boolean inserir(Venda venda) {
		if(venda != null) {
			for(int i = 0; i < vendas.length; i++) {
				if(vendas[i] == null) {
					vendas[i] = venda;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean excluir(Venda venda) {
		if(venda != null) {
			for(int i = 0; i < vendas.length; i++) {
				if(vendas[i] == venda) {
					vendas[i] = null;
					return true;
				}
			}
		}
		return false;
	}
	
	
	public Venda[] listaVendas() {
		Venda[] vendasAux = new Venda[10];
		for (int i = 0; i < vendas.length; i++) {
			if (vendas[i] != null) {
				vendasAux[i] = vendas[i];
			}
		}
		return vendasAux;
	}
	
	public Venda[] listaVendasDia(int dia, int mes, int ano) {
		Venda[] vendasAux = new Venda[10];
		int k = 0;
		Calendar calendar = Calendar.getInstance();
		for (int i = 0; i < vendas.length; i++) {
			if(vendas[i] != null) {
				calendar.setTime(vendas[i].getData());
				int dia2 = calendar.get(Calendar.DAY_OF_MONTH);
		        int mes2 = calendar.get(Calendar.MONTH) + 1; 
		        int ano2 = calendar.get(Calendar.YEAR);
		        if(dia == dia2 && mes == mes2 && ano == ano2) {
		        	vendasAux[k] = vendas[i];
		        	k++;
		        }
			}			
		}
		return vendasAux;
	}
	
	public Venda buscar(int cod) {
		for(int i = 0; i < vendas.length; i++) {
			if(vendas[i] != null) {
				if(vendas[i].getCodigo() == cod){
					return vendas[i];
				}
			}
		}
		return null;
	}
}
