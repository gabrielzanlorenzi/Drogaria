package br.com.gabriel.drogaria.bean;

import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;

/*
 * Classe EstadoBean para se comunicar com a parte visual
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 04/03/2016
 */

@ManagedBean
public class EstadoBean {

	public void salvar() {
//		System.out.println("Salvo!");
//		String texto = "Salvo!";
//		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
//
//		FacesContext contexto = FacesContext.getCurrentInstance();
//		contexto.addMessage(null, mensagem);
		
		Messages.addGlobalInfo("Estado Salvo!");
	}

}
