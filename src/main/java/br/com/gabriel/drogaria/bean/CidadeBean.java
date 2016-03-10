package br.com.gabriel.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.gabriel.drogaria.dao.CidadeDAO;
import br.com.gabriel.drogaria.domain.Cidade;

/*
 * Classe CidadeBean para se comunicar com a parte visual
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 04/03/2016
 */

@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cidade cidade;
	private List<Cidade> cidades;

	public void novo() {
		cidade = new Cidade();
	}

	public void salvar() {

		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);

			novo();
			listar();

			Messages.addGlobalInfo("Cidade foi salva!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar a cidade!");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Como se fosse um construtor (Chama automaticamente o
					// método listar)
	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as cidades!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");

			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			
			listar();

			Messages.addGlobalInfo("Cidade removida com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover a cidade!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
	}
	
	
	// Sessão de get / set

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
