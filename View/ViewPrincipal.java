package View;

import java.util.Scanner;
import Control.ControleProduto;
import Control.ControleUsuario;
import Control.ControleVenda;

public class ViewPrincipal {
	
	static Scanner scn = new Scanner(System.in);
	
	private ControleProduto controlProduto;
	private ControleUsuario controlUsuario;
	private ControleVenda controlVenda;
	
	public ViewPrincipal() {
		controlProduto = new ControleProduto();
		controlUsuario = new ControleUsuario();
		controlVenda = new ControleVenda();
	}
	
	public void view() {
		controlUsuario.init();
		controlProduto.init();
		controlVenda.setLogin(controlUsuario.buscarUsuario("mari2022"));
		controlVenda.init(controlProduto);
		System.out.println("___Mercado___");
		System.out.println("1 - Módulo Atendente");
		System.out.println("2 - Módulo Administrador");
		System.out.println("3 - Sair");
		System.out.print("Escolha uma opção: ");
		int opc = scn.nextInt();
		opc = Lib.verifOpc(1,3,opc);
		while (opc != 3) {
			System.out.println("Insira o login: ");
			String log = scn.next();
			System.out.println("Insira a sua senha: ");
			String senha = scn.next();
			int login = controlUsuario.buscarUsuario(log, senha, opc);
			if(login == 1) {
				moduloAtendente(log);
			}else if(login == 2){
				moduloAdministrador(log);
			}else {
				System.out.println("Login inválido!");
			}
			System.out.println("___Mercado___");
			System.out.println("1 - Módulo Atendente");
			System.out.println("2 - Módulo Administrador");
			System.out.println("3 - Sair");
			System.out.print("Escolha uma opção: ");
			opc = scn.nextInt();
			opc = Lib.verifOpc(1,3,opc);
			login = -1;
		}
		System.out.println("Programa Finalizado!");
		scn.close();			
	}
	
	
	private void moduloAtendente(String log) {
		System.out.println("");
		System.out.println("___Atendente___");
		System.out.println("");
		System.out.println("1 - Abrir carrinho");
		System.out.println("2 - Sair");
		System.out.print("Escolha uma opção: ");
		int opc = scn.nextInt();
		opc = Lib.verifOpc(1,2,opc);
		while(opc == 1) {
			controlVenda.setLogin(controlUsuario.buscarUsuario(log));
			if(controlVenda.abrirCarrinho()) {
				System.out.println("Carrinho Aberto!");
				System.out.println("");
				System.out.println("1 - Inserir produto");
				System.out.println("2 - Listar carrinho");
				System.out.println("3 - Finalizar venda");
				System.out.println("4 - Cancelar venda");
				System.out.print("Escolha uma opção: ");
				int opc2 = scn.nextInt();
				opc2 = Lib.verifOpc(1,4,opc2);
				System.out.println("");
				while(opc2 != 4) {
					if(opc2 == 1) {
						int result = controlVenda.adicionarProdutoCarrinho();
						if(result == 1) {
							System.out.println("Produto não encontrado");
						}else {
							if(result == 2) {
								System.out.println("Falha ao adicionar produto");
							}else {
								System.out.println("Produto Adicionado!");
							}
						}
					}else {
						if(opc2 == 2) {
							controlVenda.listarCarrinho();
						}else {
							if(opc2 == 3) {
								if(controlVenda.inserir()) {
									System.out.println("Venda Finalizada!");
									opc2 = 5;
								}else {
									System.out.println("Falha ao Finalizar a Venda");
								}
							}else {
								if(opc2 == 4){
									if(controlVenda.fecharCarrinho()) {
										System.out.println("Venda Cancelada!");
									}
								}
							}
						}
					}
					if(opc2 != 5) {
						System.out.println("1 - Inserir produto");
						System.out.println("2 - Listar carrinho");
						System.out.println("3 - Finalizar venda");
						System.out.println("4 - Cancelar venda");
						System.out.print("Escolha uma opção: ");
						opc2 = scn.nextInt();
						opc2 = Lib.verifOpc(1,4,opc2);
						System.out.println("");
					}
				}	
			}
			
			
			System.out.println("1 - Abrir carrinho");
			System.out.println("2 - Sair");
			System.out.print("Escolha uma opção: ");
			opc = scn.nextInt();
			opc = Lib.verifOpc(1,2,opc);
		}
	}
	
	private void moduloAdministrador(String log) {
		System.out.println("");
		System.out.println("___Administrador___");
		System.out.println("");
		System.out.println("__Menu__");
		System.out.println("1 - Gerenciar Produto");
		System.out.println("2 - Listas");
		System.out.println("3 - Gerenciar Usuarios");
		System.out.println("4 - Sair");
		System.out.print("Escolha uma opção: ");
		int opc = scn.nextInt();
		opc = Lib.verifOpc(1,4,opc);
		controlVenda.setLogin(controlUsuario.buscarUsuario(log));
		while(opc != 4) {
			if(opc == 1) {
				System.out.println("_Gerenciar Produto_");
				System.out.println("1 - Inserir produto");
				System.out.println("2 - Excluir produto");
				System.out.println("3 - Alterar dados do produto");
				System.out.println("4 - Voltar");
				int opc2 = scn.nextInt();
				opc2 = Lib.verifOpc(1,4,opc2);
				switch (opc2) {
				case 1:
					if(controlProduto.inserir()) {
						System.out.println("Produto Inserido com Sucesso");
					}else {
						System.out.println("Falha ao inserir o produto");
					}
					break;
				case 2:
					if(controlProduto.excluir()) {
						System.out.println("Produto Excluído com Sucesso");
					}else {
						System.out.println("Falha ao excluir o produto");
					}
					break;
				case 3:
					if(controlProduto.alterar()) {
						System.out.println("Produto Alterado com Sucesso");
					}else {
						System.out.println("Falha ao alterar o produto");
					}
					break;
				case 4: 
					break;
				}
			}
				
			if(opc == 2) {
				//Listas
				System.out.println("_Listas_");
				System.out.println("Você deseja: ");
				System.out.println("1 - Listar produtos");
				System.out.println("2 - Listar vendas");
				System.out.println("3 - Listar vendas do dia");
				System.out.println("4 - Pesquisar Venda");
				System.out.print("Insira a opção escolhida: ");
				int opcao = scn.nextInt();
				opcao = Lib.verifOpc(1,4,opcao);
				int espaco = 30;
				if(opcao == 1 || opcao == 2 || opcao == 3) {
					System.out.println(" Deseja escolher o tamanho do espaço da tabela?");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					System.out.print("Opção: ");
					int opcs = scn.nextInt();
					opcs = Lib.verifOpc(1,2,opcs);									
					if(opcs == 1) {
						System.out.println("Insira o tamanho do espaço entre as colunas (Máx 200):");
						espaco = scn.nextInt();
					    while(espaco > 200 || espaco < 1) {
					    	System.out.println("Valor inválido. Digite novamente: ");
					    	espaco = scn.nextInt();
					    }
					}
				}
				switch (opcao) {
				case 1:
					controlProduto.listar(espaco);
					break;
				case 2:
					if(controlVenda.listarVendas(espaco) == false) {
						System.out.println("Não foi possível listar as vendas");
					}
					break;
				case 3:
					System.out.println("_Digite a data desejada_");
					System.out.println("Dia: ");
					int dia = scn.nextInt();
					System.out.println("Mês: ");
					int mes = scn.nextInt();
					System.out.println("Ano: ");
					int ano = scn.nextInt();
					if(controlVenda.listarVendasDia(espaco, dia, mes, ano) == false) {
						System.out.println("Não foi possível listar as vendas");
					}					
					break;
				case 4:
					System.out.println("");
					System.out.print("Insira o código da venda: ");
					int codigo = scn.nextInt();
					if(controlVenda.detalharVenda(codigo) == 404) {
						System.out.println("Venda não encontrada!");
					}else {
						System.out.println("Erro ao detalhar venda");
					}
				}
			}
			if(opc == 3) {
				System.out.println("_Gerenciar Usuários");
				System.out.println("1 - Cadastrar Usuário");
				System.out.println("2 - Remover Usuário");
				System.out.println("3 - Listar Usuários");
				System.out.println("4 - Sair");
				System.out.print("Escolha uma opção: ");
				int opcs = scn.nextInt();
				opcs = Lib.verifOpc(1,4,opcs);
				int cargo = 0;
				if(opcs == 1 || opcs == 2) {
					System.out.println("1 - Atendente");
					System.out.println("2 - Administrador");
					System.out.print("Cargo escolhido: ");
					cargo = scn.nextInt();
					cargo = Lib.verifOpc(1,2,cargo);
				}
				
				switch(opcs){
				case 1:
					if(controlUsuario.inserir(cargo)) {
						System.out.println("Usuario Inserido com Sucesso");
					}else {
						System.out.println("Falha ao inserir o usuario");
					}
					break;
				case 2:
					if(controlUsuario.excluir(cargo)) {
						System.out.println("Usuario Excluído com Sucesso");
					}else {
						System.out.println("Falha ao excluir o usuario");
					}
					break;
				case 3:
					controlUsuario.listar();
					break;
				case 4: 
					break;
						
				}
			}
			System.out.println("");
			System.out.println("__Menu__");
			System.out.println("1 - Gerenciar Produto");
			System.out.println("2 - Listas");
			System.out.println("3 - Gerenciar Usuarios");
			System.out.println("4 - Sair");
			System.out.print("Escolha uma opção: ");
			opc = scn.nextInt();
			opc = Lib.verifOpc(1,4,opc);
		}
	}
}

