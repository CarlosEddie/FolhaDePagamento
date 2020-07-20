
public class ExibirFolhaDePagamento {

	public void exibirFolha() {
		if(Funcionario.funcionarios.size() == 0) {
			System.out.println("Não a funcionarios cadastrados");
		} else {
			System.out.println("Nome|Cargo|Salário Base|Qtde. Gratificações|Valor das Grat.|"
					+ "Vencimento Mensal");
			for(int c = 0; c < Funcionario.funcionarios.size(); c++) {
				if(Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(c)) == null) {
					System.out.println(Funcionario.funcionarios.get(c) + " | 0 | 0 |  " +
							Funcionario.salarios.get(c));
				} else {
					System.out.println(Funcionario.funcionarios.get(c) + 
							Gratificacao.gratDeFuncionarios.get(Funcionario.funcionarios.get(c)));
				}
			}
		}
		Menu.menuInicial();
	}

}
