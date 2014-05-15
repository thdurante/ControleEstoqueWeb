package br.com.caelum.online.loja.controlador;

import java.util.List;

import br.com.caelum.online.loja.dao.ProdutoDao;
import br.com.caelum.online.loja.dominio.Produto;
import br.com.caelum.online.loja.repositorio.RepositorioDeProdutos;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;

@Resource
public class ProdutoController {
	
	private final RepositorioDeProdutos produtos;
	private Result result;
	private Validator validator;

	public ProdutoController(RepositorioDeProdutos produtos, Result result, Validator validator) {
		this.produtos = produtos;
		this.result = result;
		this.validator = validator;
	}

	public List<Produto> lista(){
		return produtos.pegaTodos();
	}
	
	@Post
	public void adiciona(final Produto produto){
		
		
		
		validator.checking(new Validations() {
			{
				that(produto.getPreco() > 0.1, "erro", "produto.preco.invalido");
				that(produto.getDescricao() != null, "erro", "produto.descricao.invalida");
				that(produto.getNome() != null && produto.getNome().length() > 3 && produto.getNome().length() < 100, "erro", "produto.nome.invalido");
			}
		});
	
		
		validator.onErrorUsePageOf(ProdutoController.class).formulario();
		
		produtos.salva(produto);
		result.include("mensagem", "Novo produto adicionado com sucesso!");
		result.redirectTo(ProdutoController.class).lista();
	}
	
	public void formulario(){
		
	}
	
	@Path("/produto/{id}")
	public Produto exibe(Long id){
		return produtos.pegaPorId(id);
	}
	
	@Path("/produto/{id}/xml")
	public void exibeComoXML(Long id){
		Produto produto =  produtos.pegaPorId(id);
		result.use(Results.xml()).from(produto).serialize();
	}
	
	@Post
	public void remove(Produto produto){
		produtos.remove(produto);
		result.nothing();
	}
}
