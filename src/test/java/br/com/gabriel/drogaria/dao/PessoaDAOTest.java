package br.com.gabriel.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gabriel.drogaria.domain.Cidade;
import br.com.gabriel.drogaria.domain.Pessoa;

/*
 * Classe PessoaDAOTest a fim de realizar testes de CRUD no banco de dados
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 17/02/2016
 */

public class PessoaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(1L);

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Gabriel");
		pessoa.setCpf("123.456.789-66");
		pessoa.setRg("123456.6");
		pessoa.setRua("Rua Ezequiel");
		pessoa.setNumero((short) 9);
		pessoa.setBairro("Paineiras");
		pessoa.setCep("19910-212");
		pessoa.setComplemento("AP 11");
		pessoa.setTelefone("(14)3326-6492");
		pessoa.setCelular("(14)98765-4321");
		pessoa.setEmail("email@gmail.com");
		pessoa.setCidade(cidade);

		pessoaDAO.salvar(pessoa);
	}

	@Test
	//@Ignore
	public void listar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		for (Pessoa pessoa : resultado) {
			System.out.println("Código da pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da pessoa: " + pessoa.getNome());
			System.out.println("CPF da pessoa: " + pessoa.getCpf());
			System.out.println("RG da pessoa: " + pessoa.getRg());
			System.out.println("Cidade da pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 9L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Código da pessoa: " + pessoa.getCodigo());
			System.out.println("Nome da pessoa: " + pessoa.getNome());
			System.out.println("CPF da pessoa: " + pessoa.getCpf());
			System.out.println("RG da pessoa: " + pessoa.getRg());
			System.out.println("Cidade da pessoa: " + pessoa.getCidade().getNome());
			System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);
		
		pessoaDAO.excluir(pessoa);
		
		System.out.println("A pessoa foi excluída!");
		System.out.println("Código da pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da pessoa: " + pessoa.getNome());
		System.out.println("CPF da pessoa: " + pessoa.getCpf());
		System.out.println("RG da pessoa: " + pessoa.getRg());
		System.out.println("Cidade da pessoa: " + pessoa.getCidade().getNome());
		System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoPessoa = 2L;
		Long codigoCidade = 4L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigoCidade);
		
		System.out.println("A pessoa a se editada!");
		System.out.println("Código da pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da pessoa: " + pessoa.getNome());
		System.out.println("CPF da pessoa: " + pessoa.getCpf());
		System.out.println("RG da pessoa: " + pessoa.getRg());
		System.out.println("Cidade da pessoa: " + pessoa.getCidade().getNome());
		System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
		
		pessoa.setNome("nome Editar");
		pessoa.setEmail("EmailEditar@gmail.com");
		pessoa.setCidade(cidade);
		
		pessoaDAO.editar(pessoa);
		
		System.out.println("A pessoa foi editada!");
		System.out.println("Código da pessoa: " + pessoa.getCodigo());
		System.out.println("Nome da pessoa: " + pessoa.getNome());
		System.out.println("CPF da pessoa: " + pessoa.getCpf());
		System.out.println("RG da pessoa: " + pessoa.getRg());
		System.out.println("Cidade da pessoa: " + pessoa.getCidade().getNome());
		System.out.println("Estado da pessoa: " + pessoa.getCidade().getEstado().getNome());
	}

}
