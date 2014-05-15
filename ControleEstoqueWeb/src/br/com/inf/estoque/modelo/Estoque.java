package br.com.inf.estoque.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.inf.estoque.util.JPAUtil;

public class Estoque { /** utiliza Hibernate para persistir os dados*/
	
	private EntityManager manager = new JPAUtil().getEntityManager(); // Pega o manager da classe JPAUtil
	
	public Estoque(){
		manager.getTransaction().begin();
	}
	
	
	/**
	 * @param Produto - recebe o produto a ser persistido
	 * @return void
	 * Adiciona um novo produto ao Estoque	 
	 */
	public void adiciona(Produto produto){
		manager.persist(produto);
	}
	
	/**
	 * @param Fornecedor - recebe o fornecedor a ser persistido
	 * @return void
	 * Adiciona um novo fornecedor ao Estoque	 
	 */
	public void adiciona(Fornecedor fornecedor){
		manager.persist(fornecedor);
	}
	
	/**
	 * @param Integer id - recebe o id do produto no DB a ser retornado
	 * @return Produto - retorna o item do BD que tiver o id passada como parâmetro
	 * Retorna o produto com o id passado
	 */
	public Produto procuraProdutoPorId(Integer id){
		return manager.find(Produto.class, id);
	}
	
	/**
	 * @param Integer id - recebe o id do fornecedor no DB a ser retornado
	 * @return Fornecedor - retorna o item do BD que tiver o id passada como parâmetro
	 * Retorna o fornecedor com o id passado
	 */
	public Fornecedor procuraFornecedorPorId(Integer id){
		return manager.find(Fornecedor.class, id);
	}
	
	/**
	 * @param Integer id - recebe o id do produto a ser removido
	 * @return void
	 * Remove o produto com o id passado
	 */
	public void remove(Integer id){
		Produto temp = manager.find(Produto.class, id);
		manager.remove(temp);
	}
	
	public Query realizaQuery(String string){
		Query query = manager.createQuery(string);
		return query;
	}
	
	public void commit(){
		manager.getTransaction().commit();
	}
	
	public void close(){
		manager.close();
	}
}
