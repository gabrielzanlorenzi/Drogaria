package br.com.gabriel.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

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
			estadoDAO.merge(estado);

			novo();
			listar();

			Messages.addGlobalInfo("Estado foi salvo!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
			erro.printStackTrace();
		}
	}

	@PostConstruct // Como se fosse um construtor (Chama automaticamente o
					// método listar)
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os estados!");
			erro.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			listar();

			Messages.addGlobalInfo("Estado removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o estado!");
			erro.printStackTrace();
		}
		
	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
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
