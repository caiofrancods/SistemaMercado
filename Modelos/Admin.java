package Modelos;

import java.util.Date;

public class Admin extends Usuario{
	private Date ultimoLogin;
	
	public Admin(String nome, String login, String senha) {
		super(nome, login, senha);
		ultimoLogin = null;
	}
	
	public Date getUltimoLogin() {
		return this.ultimoLogin;
	}
	
	public void setLogin(Date log) {
		this.ultimoLogin = log;
	}
}
