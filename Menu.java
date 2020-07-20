import java.util.Scanner;

public abstract class Menu{
	Scanner teclado = new Scanner(System.in);
	Funcionario funcionarios = new Funcionario();
	Gratificacao gratificacoes =  new Gratificacao();
	public static void menuInicial() {
		int escolha = 0;
		ExibirFolhaDePagamento mostrar = new ExibirFolhaDePagamento();
		SubMenuFuncionario escolherFunci = new SubMenuFuncionario();
		SubMenuGratificacao escolherGrat = new SubMenuGratificacao();
		Scanner teclado = new Scanner(System.in); 
		System.out.println("====MENU====");
		System.out.println("O que você deseja fazer?");
		System.out.println("[1]Modificar Funcionarios");
		System.out.println("[2]Modificar Gratificações");
		System.out.println("[3]Exibir folha de pagamento");
		System.out.println("[4]Sair do programa");
		try {	
			escolha = teclado.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Digite um numero por favor!");
			menuInicial();
		}
		
		if(escolha == 1) {
			escolherFunci.subMenu();
		} else if(escolha == 2) {
			escolherGrat.subMenu();
		} else if(escolha == 3) {
			mostrar.exibirFolha();
		} else if(escolha == 4) {
			System.out.println("Saindo...");
			System.exit(0);
		} else {
			System.out.println("ESCOLHA INVALIDA! TENTE NOVAMENTE");
			menuInicial();
		}
		teclado.close();
	}
	
	public void subMenu() {
		
	}
}
