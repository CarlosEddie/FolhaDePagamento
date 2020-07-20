

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
			System.out.println("N�o a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja dar uma gratifica��o? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {	
				res = teclado.nextInt();
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				do {
					System.out.println("Qual o tipo da Gratifica��o?");
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
					System.out.println("GRATIFICA��O ADICIONADA COM SUCESSO!");
					System.out.println("Deseja adicionar mais uma gratfica��o? [1]Sim  [2]N�o");
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
				System.out.println("Gratifica��es ja cadastradas");
				Menu.menuInicial();
			}
		}
	}

	public void remover() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("N�o a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja remover as gratifica��es? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {	
				res = teclado.nextInt();
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				System.out.println("N�o a gratifica��es cadastradas");
				Menu.menuInicial();
			} else {
				gratDeFuncionarios.remove(Funcionario.funcionarios.get(res)); 
				System.out.println("GRATIFICA��ES REMOVIDAS COM SUCESSO!");
				Menu.menuInicial();
			}
		}
	}

	public void atualizar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("N�o a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja atualizar as gratifica��es ? ");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + Funcionario.funcionarios.get(c));
			}
			try {	
				res = teclado.nextInt();
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(	Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) == null) {
				System.out.println("N�o a gratifica��es cadastradas");
				Menu.menuInicial();
				
			} else {
				do {
					System.out.println("Qual o tipo da Gratifica��o?");
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
					System.out.println("GRATIFICA��O ATUALIZADA COM SUCESSO!");
					System.out.println("Deseja adicionar mais uma gratfica��o? [1]Sim  [2]N�o");
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
			System.out.println("N�o a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("LISTA DE GRATIFICA��ES");
			System.out.println("QTDE. DE GRATIFICA��ES  |  VALOR DAS GRATIFICA��ES  |  VENCIMENTO MENSAL");
			System.out.println();
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println(Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(c)));
			}
			Menu.menuInicial();
		}
	}

}
