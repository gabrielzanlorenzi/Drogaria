package br.com.gabriel.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * Classe fabricante que representa uma tabela no banco de dados
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 01/02/2016
 */

@SuppressWarnings("serial")
@Entity
public class Fabricante extends GenericDomain {
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
