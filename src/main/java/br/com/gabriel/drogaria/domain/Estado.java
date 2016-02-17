package br.com.gabriel.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/*
 * Classe estado que representa uma tabela no banco de dados
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 01/02/2016
 */

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericDomain {
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
