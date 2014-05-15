package br.com.inf.estoque.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author thdurante
 * Classe criada para fornecer, uma única vez, um objeto EntityManager (uma vez que demanda tempo sua criação)
 * Outros objetos de outras classes requerem o EntityManager através do método get abaixo
 */

public class JPAUtil {
	
	private static EntityManagerFactory entityMF = Persistence.createEntityManagerFactory("ControleEstoque");
	
	/**
	 *@return EntityManager - retorna o EntityManager necessário 
	 */
	public EntityManager getEntityManager(){
		return entityMF.createEntityManager();
	}

}
