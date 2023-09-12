package Repositorio;

import Modelos.Usuario;
import Modelos.Atendente;
import Modelos.Admin;

public class RepoUsuario {
	private Usuario[] usuarios;
	
	public RepoUsuario() {
		usuarios = new Usuario[50];
	}
	
	public boolean inserir(Usuario user) {
		if(user != null) {
			int control = 0;
			for(int i = 0; i < usuarios.length; i++) {
				if(usuarios[i] != null) {
				
					if(usuarios[i].getLogin() == user.getLogin()) {
						control = 1;
					}
				}
			}
			if(control == 0) {
				for(int i = 0; i < usuarios.length;i++) {
					if(usuarios[i] == null) {
						usuarios[i] = user;
						return true;
					}
				}
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean excluir(Usuario user) {
		int cod = -1;
		if(user != null) {
			for(int i = 0; i < usuarios.length; i++) {
				if(usuarios[i] != null) {
					if(usuarios[i].getCodigo() == user.getCodigo()) {
						cod = i;
					}
				}
			}
		}
		if(cod != -1) {
			usuarios[cod] = null;
			return true;
		}
		return false;
	}
	
	public Usuario[] listar() {
		Usuario[] usuariosAux = new Usuario[usuarios.length];
		int cont = 0;

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				usuariosAux[cont] = usuarios[i];
				cont++;
			}
		}
		return usuariosAux;
	}

	
	public Usuario buscarUsuario(String login) {
		if(login != null) {
			for(int i = 0; i < usuarios.length;i++) {
				if(usuarios[i] != null) {
					if(usuarios[i].getLogin().equals(login)) {
						return usuarios[i];
					}
				}
			}
		}		
		return null;
	}
	
	public int buscarUsuario(String login, String senha, int cargo) {
		if(login != null && senha != null) {
			if(cargo == 1) {
				for(int i = 0; i < usuarios.length;i++) {
					if(usuarios[i] != null) {
						if(usuarios[i].getLogin().equals(login) && usuarios[i].getSenha().equals(senha) && usuarios[i] instanceof Atendente){
							return 1;
						}
					}
				}
			}else if(cargo == 2){
				for(int i = 0; i < usuarios.length;i++) {
					if(usuarios[i] != null) {
						if(usuarios[i].getLogin().equals(login) && usuarios[i].getSenha().equals(senha) && usuarios[i] instanceof Admin){
							return 2;
						}
					}
				}
			}
			return 0;
		}
		return 0;

	}
}
