package br.com.gabriel.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.gabriel.drogaria.dao.EstadoDAO;
import br.com.gabriel.drogaria.domain.Estado;

/*
 * Classe EstadoBean para se comunicar com a parte visual
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 04/03/2016
 */

@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Estado estado;
	private List<Estado> estados;

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {

		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.salvar(estado);

			novo();

			Messages.addGlobalInfo("Estado foi salvo!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Como se fosse um construtor (Chama automaticamente o método listar)
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados");
			erro.printStackTrace();
		}
	}

	// Sessão de get / set

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
