import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FolhaDePagamentoTest {
	@Test
	public void VerificarCadastrarFuncionario() {
		// Dado que ...
		Funcionario a = new Funcionario();
		// Quando eu ...
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		Funcionario.funcionarios.add(a.funCadastrado);
		// Eu espero ...
		assertTrue(Funcionario.funcionarios.get(0) == a.funCadastrado);
		Funcionario.funcionarios.clear();
	}
	
	@Test
	public void VerificarRemoverFuncionario() {
		// Dado que ...
		Funcionario a = new Funcionario();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		Funcionario.funcionarios.add(a.funCadastrado);
		// Quando eu ...
		Funcionario.funcionarios.clear();
		// Eu espero ...
		assertFalse(Funcionario.funcionarios.contains(a.funCadastrado));
	}
	
	@Test
	public void VerificarAtualizarFuncionario() {
		// Dado que ...
		Funcionario a = new Funcionario();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		Funcionario.funcionarios.add(a.funCadastrado);
		// Quando eu ...
		Funcionario.funcionarios.remove(0);
		a.funCadastrado = "Eduardo | Empregado |   2500";
		Funcionario.funcionarios.add(0, "Eduardo | Empregado |   2500");
		// Eu espero ...
		assertTrue(Funcionario.funcionarios.get(0) == a.funCadastrado);
	}
	
	@Test
	public void VerificarRecuperarFuncionario() {
		// Dado que ...
		Funcionario a = new Funcionario();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		Funcionario.funcionarios.add(a.funCadastrado);
		// Quando eu ...
		Funcionario.funcionarios.add(0, "Eduardo | Empregado |   2500");
		// Eu espero ...
		assertTrue(Funcionario.funcionarios.get(0) == "Eduardo | Empregado |   2500");
	}
	
	@Test
	public void VerificarCadastrarGratificacao() {
		// Dado que ...
		Funcionario a =  new Funcionario();
		Gratificacao b = new Gratificacao();
		// Quando eu ...
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		b.gratCadastrada = "| 2 | 400 | 4400";
		Gratificacao.gratDeFuncionarios.put(a.funCadastrado, b.gratCadastrada );
		// Eu espero ...
		assertTrue(Gratificacao.gratDeFuncionarios.get(a.funCadastrado) == b.gratCadastrada );
	}
	
	@Test
	public void VerificarRemoverGratificacao() {
		// Dado que ...
		Funcionario a =  new Funcionario();
		Gratificacao b = new Gratificacao();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		b.gratCadastrada = "| 2 | 400 | 4400";
		Gratificacao.gratDeFuncionarios.put(a.funCadastrado, b.gratCadastrada );
		// Quando eu ...
		Gratificacao.gratDeFuncionarios.remove(a.funCadastrado);
		// Eu espero ...
		assertTrue(Gratificacao.gratDeFuncionarios.get(a.funCadastrado) == null);
	}
	
	@Test
	public void VerificarAtualizarGratificacao() {
		// Dado que ...
		Funcionario a =  new Funcionario();
		Gratificacao b = new Gratificacao();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		b.gratCadastrada = "| 2 | 400 | 4400";
		Gratificacao.gratDeFuncionarios.put(a.funCadastrado, b.gratCadastrada );
		// Quando eu ...
		Gratificacao.gratDeFuncionarios.remove(a.funCadastrado);
		b.gratCadastrada = "| 1 | 200 | 4200";
		Gratificacao.gratDeFuncionarios.put(a.funCadastrado, b.gratCadastrada);
		// Eu espero ...
		assertTrue(Gratificacao.gratDeFuncionarios.get(a.funCadastrado) == "| 1 | 200 | 4200");
	}
	
	@Test
	public void VerificarRecuperarGratificacao() {
		// Dado que ...
		Funcionario a =  new Funcionario();
		Gratificacao b = new Gratificacao();
		a.funCadastrado = "Carlos |  Gerente  |   4000";
		b.gratCadastrada = "| 2 | 400 | 4400";
		Gratificacao.gratDeFuncionarios.put(a.funCadastrado, b.gratCadastrada );
		// Eu espero ...
		assertTrue(Gratificacao.gratDeFuncionarios.get(a.funCadastrado) == "| 2 | 400 | 4400");
	}
	
}
