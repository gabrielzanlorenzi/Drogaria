package br.com.gabriel.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gabriel.drogaria.domain.Funcionario;
import br.com.gabriel.drogaria.domain.Pessoa;

/*
 * Classe FuncionarioDAOTest a fim de realizar testes de CRUD no banco de dados
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 04/03/2016
 */

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Funcionario funcionario = new Funcionario();

		funcionario.setCarteiraTrabalho("345345");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);

		funcionarioDAO.salvar(funcionario);
		
		System.out.println("Funcionário salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		for (Funcionario funcionario : resultado) {
			System.out.println("Código do Funcionário: " + funcionario.getCodigo());
			System.out.println("Nome da pessoa: " + funcionario.getPessoa().getNome());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data da admimição: " + funcionario.getDataAdmissao());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Código do Funcionário: " + funcionario.getCodigo());
			System.out.println("Nome da pessoa: " + funcionario.getPessoa().getNome());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data da admimição: " + funcionario.getDataAdmissao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);
		
		funcionarioDAO.excluir(funcionario);
		
		System.out.println("O funcionário foi excluído!");
		System.out.println("Código do Funcionário: " + funcionario.getCodigo());
		System.out.println("Nome da pessoa: " + funcionario.getPessoa().getNome());
		System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data da admimição: " + funcionario.getDataAdmissao());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoFuncionario = 3L;
		Long codigoPessoa = 1L;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigoFuncionario);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("O funcionário a ser editado!");
		System.out.println("Código do Funcionário: " + funcionario.getCodigo());
		System.out.println("Nome da pessoa: " + funcionario.getPessoa().getNome());
		System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data da admimição: " + funcionario.getDataAdmissao());
		
		funcionario.setCarteiraTrabalho("99999999");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);
		
		funcionarioDAO.editar(funcionario);
		
		System.out.println("O Funcionário foi editado!");
		System.out.println("Código do Funcionário: " + funcionario.getCodigo());
		System.out.println("Nome da pessoa: " + funcionario.getPessoa().getNome());
		System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
		System.out.println("Data da admimição: " + funcionario.getDataAdmissao());
	}

}
