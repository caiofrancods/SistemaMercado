package View;

import java.util.Scanner;

import Modelos.Admin;
import Modelos.Atendente;
import Modelos.Usuario;

public class UsuarioView {
	
	static Scanner scn = new Scanner(System.in);

	public Usuario inserir(int cargo) {
			System.out.print("Insira o nome do usuário: ");
			String nome = scn.next();
			System.out.print("Insira o login do usuário: ");
			String login = scn.next();
			System.out.print("Insira a senha do usuário: ");
			String senha = scn.next();
			if(cargo == 1) {
				return (new Atendente(nome, login, senha));
			}else {
				return (new Admin(nome, login, senha));
			}
	}
	
	public String excluir(int cargo) {
		if(cargo == 1) {
			System.out.print("Insira o login do usuário que deseja remover: ");
			String remove = scn.next();
			if(remove != null) {
				return remove;
			}
		}else {
			System.out.print("Insira o login do usuário que deseja remover: ");
			String remove = scn.next();
			if(remove != null) {
				return remove;
			}
		}
		return null;
	}
	
	public void listar(Usuario[] users) {
		System.out.println("Insira o tamanho do espaço entre as colunas (Máx 200):");
		int espaco = scn.nextInt();
	    while(espaco > 200 || espaco < 1) {
	    	System.out.println("Valor inválido. Digite novamente: ");
	    	espaco = scn.nextInt();
	    }

		System.out.println("__ATENDENTES__");
		System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	            (espaco) + "s%-" + (espaco) + "s\n",
	            "CODIGO", "NOME", "LOGIN", "VENDAS");
		for (Usuario atendente : users) {
	        if (atendente != null && atendente instanceof Atendente) {
	            System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	                    (espaco) + "s%-" + (espaco) + "s\n",
	                    atendente.getCodigo(), atendente.getNome(), atendente.getLogin(),
	                    String.format("%.2f",((Atendente)atendente).getVendas()));
	        }
	    }
		System.out.println("__ADMINISTRADORES");
		System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	            (espaco) + "s%-" + (espaco) + "s\n",
	            "CODIGO", "NOME", "LOGIN", "UltimoLogin");
		for (Usuario admin : users) {
	        if (admin != null && admin instanceof Admin) {
	            System.out.printf("%-" + (espaco) + "s%-" + (espaco) + "s%-" +
	                    (espaco) + "s%-" + (espaco) + "s\n",
	                    admin.getCodigo(), admin.getNome(), admin.getLogin(), ((Admin)admin).getUltimoLogin());							                   ;
	        }
	    }
	}
}
