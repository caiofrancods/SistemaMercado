package Modelos;

public class Usuario {
	private int codigo;
	private String nome;
	private String login;
	private String senha;
	
	private static int quant;
	
	public Usuario(String nome, String login, String senha) {
		if(nome != null && login != null && senha.length()>=3) {
			this.codigo = quant;
			this.nome = nome;
			this.login = login;
			this.senha = senha;
			quant++;
		}
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getLogin() {
		return this.login;
	}
	public String getSenha() {
		return this.senha;
	}
	public int getCodigo() {
		return this.codigo;
	}
}
