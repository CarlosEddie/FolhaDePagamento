

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gratificacao {
	Scanner teclado = new Scanner(System.in);
	String gratCadastrada;
	double gratificacao = 0, vencimentomensal = 0;
	int hora = 0, res = 0, qtdgratificacao = 0, grat = 0, continuar = 0;
	static Map<String, String> gratDeFuncionarios = new HashMap<String, String>();
	

	public void cadastrar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja dar uma gratificação? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {
				do {
					res = teclado.nextInt();
					if(res > (Funcionario.funcionarios.size() - 1) || res < 0 ) {
						System.out.println("Opção invalida! Tente novamente: ");
					}
				} while(res > (Funcionario.funcionarios.size() - 1) || res < 0 );
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				do {
					System.out.println("Qual o tipo da Gratificação?");
					System.out.println("[1]Desempenho");
					System.out.println("[2]Hora Extra");
					try {	
						grat = teclado.nextInt();
					} catch (java.util.InputMismatchException exception) {
						System.out.println("Argumento invalido!");
						Menu.menuInicial();
					}
					if(grat == 1) {
						gratificacao += 0.05 * Funcionario.salarios.get(res);
						vencimentomensal = Funcionario.salarios.get(res) + gratificacao;
					} else {
						System.out.println("Quantos horas extras foram trabalhadas?");
						try {	
							hora = teclado.nextInt();
						} catch (java.util.InputMismatchException exception) {
							System.err.println("Argumento invalido!");
							Menu.menuInicial();
						}
						gratificacao += (0.001 * Funcionario.salarios.get(res)) * hora;
						vencimentomensal = Funcionario.salarios.get(res) + gratificacao;
					}
					qtdgratificacao += 1;
					System.out.println("GRATIFICAÇÃO ADICIONADA COM SUCESSO!");
					System.out.println("Deseja adicionar mais uma gratficação? [1]Sim  [2]Não");
					try {	
						continuar = teclado.nextInt();
					} catch (java.util.InputMismatchException exception) {
						System.err.println("Argumento invalido!");
						Menu.menuInicial();
					}
				} while(continuar != 2);
				gratCadastrada =  " | " + qtdgratificacao + " | " + gratificacao + " | "  + vencimentomensal; 
				gratDeFuncionarios.put(Funcionario.funcionarios.get(res), gratCadastrada);
				Menu.menuInicial();
			} else {
				System.out.println("Gratificações ja cadastradas");
				Menu.menuInicial();
			}
		}
	}

	public void remover() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja remover as gratificações? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {
				do {
					res = teclado.nextInt();
					if(res > (Funcionario.funcionarios.size() - 1) || res < 0 ) {
						System.out.println("Opção invalida! Tente novamente: ");
					}
				} while(res > (Funcionario.funcionarios.size() - 1) || res < 0 );
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				System.out.println("Não a gratificações cadastradas");
				Menu.menuInicial();
			} else {
				gratDeFuncionarios.remove(Funcionario.funcionarios.get(res)); 
				System.out.println("GRATIFICAÇÕES REMOVIDAS COM SUCESSO!");
				Menu.menuInicial();
			}
		}
	}

	public void atualizar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja atualizar as gratificações ? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {
				do {
					res = teclado.nextInt();
					if(res > (Funcionario.funcionarios.size() - 1) || res < 0 ) {
						System.out.println("Opção invalida! Tente novamente: ");
					}
				} while(res > (Funcionario.funcionarios.size() - 1) || res < 0 );
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				System.out.println("Não a gratificações cadastradas");
				Menu.menuInicial();
				
			} else {
				do {
					System.out.println("Qual o tipo da Gratificação?");
					System.out.println("[1]Desempenho");
					System.out.println("[2]Hora Extra");
					try {	
						grat = teclado.nextInt();
					} catch (java.util.InputMismatchException exception) {
						System.out.println("Digite um numero por favor!");
						atualizar();
					}
					if(grat == 1) {
						gratificacao += 0.05 * Funcionario.salarios.get(res);
						vencimentomensal = Funcionario.salarios.get(res) + gratificacao;
					} else {
						System.out.println("Quantos horas extras foram trabalhadas?");
						try {	
							hora = teclado.nextInt();
						} catch (java.util.InputMismatchException exception) {
							System.err.println("Argumento invalido!");
							Menu.menuInicial();
						}
						gratificacao += (0.001 * Funcionario.salarios.get(res)) * hora;
						vencimentomensal = Funcionario.salarios.get(res) + gratificacao;
					}
					qtdgratificacao += 1;
					System.out.println("GRATIFICAÇÃO ATUALIZADA COM SUCESSO!");
					System.out.println("Deseja adicionar mais uma gratficação? [1]Sim  [2]Não");
					try {	
						continuar = teclado.nextInt();
					} catch (java.util.InputMismatchException exception) {
						System.err.println("Argumento invalido!");
						Menu.menuInicial();
					}
				} while(continuar != 2);
				gratCadastrada =  "	| " + qtdgratificacao + " | " + gratificacao + " | "  + vencimentomensal; 
				gratDeFuncionarios.put(Funcionario.funcionarios.get(res), gratCadastrada);
				Menu.menuInicial();
			}
		}
		
	}

	public void recuperar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("LISTA DE GRATIFICAÇÕES");
			System.out.println("QTDE. DE GRATIFICAÇÕES  |  VALOR DAS GRATIFICAÇÕES  |  VENCIMENTO MENSAL");
			System.out.println();
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println(Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(c)));
			}
			Menu.menuInicial();
		}
	}

}
