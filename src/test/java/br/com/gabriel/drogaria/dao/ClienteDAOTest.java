package br.com.gabriel.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.gabriel.drogaria.domain.Cliente;
import br.com.gabriel.drogaria.domain.Pessoa;

/*
 * Classe ClienteDAOTest a fim de realizar testes de CRUD no banco de dados
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 05/03/2016
 */

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();

		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		clienteDAO.salvar(cliente);
		System.out.println("Salvo!");
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println("Código do Cliente: " + cliente.getCodigo());
			System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Cliente liberado?: " + cliente.getLiberado().toString());
			System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Código do Cliente: " + cliente.getCodigo());
			System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Cliente liberado?: " + cliente.getLiberado().toString());
			System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
		}
	}

	@Test
	//@Ignore
	public void excluir() {
		Long codigo = 3L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		clienteDAO.excluir(cliente);
		
		System.out.println("O cliente foi excluído!");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Cliente liberado?: " + cliente.getLiberado().toString());
		System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCliente = 3L;
		Long codigoPessoa = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("O cliente a ser editado!");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Cliente liberado?: " + cliente.getLiberado().toString());
		System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
		
		cliente.setLiberado(false);
		cliente.setDataCadastro(new Date());
		cliente.setPessoa(pessoa);
		
		clienteDAO.editar(cliente);
		
		System.out.println("O cliente foi editado!");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Cliente liberado?: " + cliente.getLiberado().toString());
		System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
	}

}
