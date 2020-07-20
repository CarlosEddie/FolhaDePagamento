
public class SubMenuFuncionario extends Menu{
	
	@Override
	public void subMenu() {
		System.out.println("====SUBMENU====");
		System.out.println("O que você deseja fazer?");
		System.out.println("[1]Cadastrar Funcionario");
		System.out.println("[2]Remover Funcionario");
		System.out.println("[3]Atualizar Lista de Funcionarios");
		System.out.println("[4]Recuperar Lista de Funcionarios");
		System.out.println("[5]Voltar ao Menu Principal");
		int escolha = 0;
		try {	
			escolha = teclado.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Digite um numero por favor!");
			menuInicial();
		}
		if(escolha == 1) {
			funcionarios.cadastrar();
		} else if(escolha == 2) {
			funcionarios.remover();
		} else if(escolha == 3) {
			funcionarios.atualizar();
		} else if(escolha == 4) {
			funcionarios.recuperar();
		} else if(escolha == 5) {
			Menu.menuInicial();
		} else {
			System.out.println("ESCOLHA INVALIDA! TENTE NOVAMENTE");
			subMenu();
		}
	}
	
	
}
	