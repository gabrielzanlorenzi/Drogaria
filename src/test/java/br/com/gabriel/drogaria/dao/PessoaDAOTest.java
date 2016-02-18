package br.com.gabriel.drogaria.dao;

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
	public void salvar(){
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
	
}
