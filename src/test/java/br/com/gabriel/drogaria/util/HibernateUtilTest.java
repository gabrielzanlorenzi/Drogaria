package br.com.gabriel.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

/*
 * Classe para testar a classe HibernateUtil
 * @author Gabriel Zanlorenzi
 * @since Classe criada em 01/02/2016
 */

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessoes().close();
	}
}
