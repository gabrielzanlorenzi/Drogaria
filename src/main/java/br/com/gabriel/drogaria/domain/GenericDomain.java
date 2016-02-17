package br.com.gabriel.drogaria.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
 * Classe genérica do Domain que contém o cídigo
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 01/02/2016
 */

@SuppressWarnings("serial")
@MappedSuperclass
public class GenericDomain implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
