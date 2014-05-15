package br.com.inf.estoque.teste;

import br.com.inf.estoque.modelo.Estoque;
import br.com.inf.estoque.modelo.Produto;

public class TesteJPA {

	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		
		Produto cama = new Produto();
		cama.setNome("Cama casal");
		cama.setDescricao("Super-King");
		cama.setPreco(3283.45);
		cama.setQuantidade(2);
		
		estoque.adiciona(cama);
		
		Produto pc = new Produto();
		pc.setNome("Notebook");
		pc.setDescricao("Processador i7");
		pc.setPreco(1299.50);
		pc.setQuantidade(10);
		
		estoque.adiciona(pc);
	
		//estoque.remove(2);
		
				
		estoque.commit();		
		estoque.close();
	}
}
