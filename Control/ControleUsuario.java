package Control;

import Modelos.Usuario;
import Modelos.Admin;
import Modelos.Atendente;
import Repositorio.RepoUsuario;
import View.UsuarioView;

public class ControleUsuario {
	
	RepoUsuario repoUsuario;
	UsuarioView userView;
	
	public ControleUsuario(){
		repoUsuario = new RepoUsuario();
		userView = new UsuarioView();		
	}
	
	public boolean inserir(int cargo) {
		Usuario user = userView.inserir(cargo);
		if(user != null) {
			if(repoUsuario.inserir(user)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public boolean excluir(int cargo) {
		String login = userView.excluir(cargo);
		Usuario user = buscarUsuario(login);
		if(user != null) {
			if(repoUsuario.excluir(user)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public void listar() {
		userView.listar(repoUsuario.listar());
	}
	
	public int buscarUsuario(String login, String senha, int cargo) {
		if(login != null && senha != null) {
			return repoUsuario.buscarUsuario(login, senha, cargo);
		}
		return 0;

	}
	
	public Usuario buscarUsuario(String login) {
		return (repoUsuario.buscarUsuario(login));
	}
	
	public void init() {
		repoUsuario.inserir(new Admin("Luciano", "Lulu2023", "lulu123"));		
		repoUsuario.inserir(new Atendente("Mariana", "mari2022", "mari1232"));
		repoUsuario.inserir(new Atendente("João", "joaodelas", "jv123"));
	}

}
