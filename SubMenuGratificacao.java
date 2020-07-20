
public class SubMenuGratificacao extends Menu{
	@Override
	public void subMenu() {
		System.out.println("====SUBMENU====");
		System.out.println("O que você deseja fazer?");
		System.out.println("[1]Cadastrar Gratificação");
		System.out.println("[2]Remover Gratificação");
		System.out.println("[3]Atualizar Gratificação");
		System.out.println("[4]Recuperar Gratificação");
		System.out.println("[5]Voltar ao Menu Principal");
		int escolha = 0;
		try {	
			escolha = teclado.nextInt();
		} catch (java.util.InputMismatchException exception) {
			System.out.println("Digite um numero por favor!");
			menuInicial();
		}
		if(escolha == 1) {
			gratificacoes.cadastrar();
		} else if(escolha == 2) {
			gratificacoes.remover();
		} else if(escolha == 3) {
			gratificacoes.atualizar();
		} else if(escolha == 4) {
			gratificacoes.recuperar();
		} else if(escolha == 5) {
			Menu.menuInicial();
		} else {
			System.out.println("ESCOLHA INVALIDA! TENTE NOVAMENTE");
			subMenu();
		}
	}
}
