package br.com.inf.estoque.teste;

import br.com.inf.estoque.modelo.Estoque;
import br.com.inf.estoque.modelo.Fornecedor;
import br.com.inf.estoque.modelo.Produto;

public class TesteJPARelacionamento {

	public static void main(String[] args) {
		
		Estoque estoque = new Estoque();
		
		Produto cama = new Produto();
		cama.setNome("Cama casal");
		cama.setDescricao("Super-King");
		cama.setPreco(3283.45);
		cama.setQuantidade(2);
		
		
		
		Produto pc = new Produto();
		pc.setNome("Notebook");
		pc.setDescricao("Processador i7");
		pc.setPreco(1299.50);
		pc.setQuantidade(10);
		
		
		
		Fornecedor fornecedor1 = new Fornecedor();
		fornecedor1.setNome("Fornecedor da cama");
		fornecedor1.setDescricao("Fornece a cama King-Size");
		fornecedor1.setProduto(cama);
		
		Fornecedor fornecedor2 = new Fornecedor();
		fornecedor2.setNome("Fornecedor do notebook");
		fornecedor2.setDescricao("Fornece o notebook i7");
		fornecedor2.setProduto(pc);
		
		//cama.setFornecedor(fornecedor1);
		//pc.setFornecedor(fornecedor2);
		
		estoque.adiciona(pc);
		estoque.adiciona(cama);
		estoque.adiciona(fornecedor1);
		estoque.adiciona(fornecedor2);
	
		//estoque.remove(2);
		
				
		estoque.commit();		
		estoque.close();
	}
}
