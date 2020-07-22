
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario {
	Scanner teclado = new Scanner(System.in);
	String nome, cargo, funCadastrado;
	double salario;
	int res = 0, fun = 0;
	static List<Double> salarios = new ArrayList<Double>();
	static List<String> funcionarios = new ArrayList<String>();
	
	public void remover() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja remover? ");
			for(int c = 0; c < funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + funcionarios.get(c));
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
			if(Gratificacao.gratDeFuncionarios.size() != 0 && 
			Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(res)) != null) {
				Gratificacao.gratDeFuncionarios.remove(funcionarios.get(res));
			}
			funcionarios.remove(res);
			salarios.remove(res);
			System.out.println("FUNCIONARIO REMOVIDO COM SUCESSO!");
			Menu.menuInicial();
		}
	}

	public void cadastrar() {
		System.out.println("Digite o nome do funcionario: ");
		nome = teclado.nextLine();
		System.out.println("Qual o tipo do funcionario?");
		System.out.println("[1]Gerente");
		System.out.println("[2]Empregado");
		try {	
			res = teclado.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.err.println("Argumento invalido!");
			Menu.menuInicial();
		}
		if(res == 1) {
			cargo = "Gerente";
			salario = 4000.0;
		} else {
			cargo = "Empregado";
			salario = 2500.0;
		}
		funCadastrado = nome + " | " + cargo + " | "  + salario;
		if(funcionarios.contains(funCadastrado)) {
			System.out.println("Funcionario ja cadastrado");
			Menu.menuInicial();
		} else {
			funcionarios.add(funCadastrado);
			salarios.add(salario);
			System.out.println("FUNCIONARIO ADICIONADO COM SUCESSO!");
			Menu.menuInicial();
		}
	}

	public void atualizar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Qual funcionario voce deseja atualizar? ");
			for(int c = 0; c < funcionarios.size(); c++) {
				System.out.println("[" + c + "]" + funcionarios.get(c));
			}
			try {
				do {
					fun = teclado.nextInt();
					if(fun > (Funcionario.funcionarios.size() - 1) || fun < 0 ) {
						System.out.println("Opção invalida! Tente novamente: ");
					}
				} while(fun > (Funcionario.funcionarios.size() - 1) || fun < 0 );
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			System.out.println("Digite o novo nome: ");
			nome = teclado.next();
			System.out.println("Escolha o cargo:");
			System.out.println("[1]Gerente");
			System.out.println("[2]Empregado");
			try {	
				res = teclado.nextInt();
			} catch (java.util.InputMismatchException exception) {
				System.err.println("Argumento invalido!");
				Menu.menuInicial();
			}
			if(res == 1) {
				cargo = "Gerente";
				salario = 4000.0;
			} else {
				cargo = "Empregado";
				salario = 2500.0;
			}
			funCadastrado = nome + " | " + cargo + " | "  + salario;
			if(funcionarios.contains(funCadastrado)) {
				System.out.println("Funcionario ja cadastrado");
				Menu.menuInicial();
			} else {
				if(Gratificacao.gratDeFuncionarios.size() != 0 && 
				Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(fun)) != null) {
					Gratificacao.gratDeFuncionarios.remove(funcionarios.get(fun));
				}
				funcionarios.remove(fun);
				salarios.remove(fun);
				funcionarios.add(fun, funCadastrado);
				salarios.add(fun, salario);
				System.out.println("FUNCIONARIO ATUALIZADO COM SUCESSO!");
				Menu.menuInicial();
			}
		}
		
	}

	public void recuperar() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("LISTA DE EMPREGADOS");
			System.out.println("NOME  |  CARGO  |  SALÁRIO BASE");
			System.out.println();
			for(int c = 0; c < funcionarios.size(); c++) {
				System.out.println(funcionarios.get(c));
			}
			Menu.menuInicial();
		}
	}

}
