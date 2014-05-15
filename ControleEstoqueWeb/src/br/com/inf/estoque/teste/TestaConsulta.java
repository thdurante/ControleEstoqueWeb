package br.com.inf.estoque.teste;

import java.util.List;

import javax.persistence.Query;
import br.com.inf.estoque.modelo.Estoque;
import br.com.inf.estoque.modelo.Fornecedor;
import br.com.inf.estoque.modelo.Produto;

public class TestaConsulta {
	
	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		
		Produto produto1 = estoque.procuraProdutoPorId(8);
		
		Query query = estoque.realizaQuery("select f from Fornecedor f where f.produto.id=" +produto1.getId());
		
		List<Fornecedor> fornecedores = query.getResultList();
		
		for (Fornecedor f : fornecedores) {
			System.out.println("ID: " +f.getId());
			System.out.println("Nome: " +f.getNome());
			System.out.println("Descrição: " +f.getDescricao());
			System.out.println();
		}
		
		estoque.close();
		
	}

}
