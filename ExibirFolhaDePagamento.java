
public class ExibirFolhaDePagamento {

	public void exibirFolha() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("N�o a funcionarios cadastrados");
			Menu.menuInicial();
		} else {
			System.out.println("Nome|Cargo|Sal�rio Base|Qtde. Gratifica��es|Valor das Grat.|"
					+ "Vencimento Mensal");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				System.out.println(Funcionario.funcionarios.get(c) + 
						Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(c)));
			}
			Menu.menuInicial();
		}
		
	}

}
