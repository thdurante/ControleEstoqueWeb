package br.com.caelum.online.loja.controlador;

import br.com.caelum.online.loja.dominio.UsuarioLogado;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class LoginController {
	
	private UsuarioLogado usuarioLogado;
	private Result result;

	public LoginController(UsuarioLogado usuarioLogado, Result result){
		this.usuarioLogado = usuarioLogado;
		this.result = result;		
	}
	
	public void loga(String login, String senha){
		if(login.equals("thdurante") && senha.equals("tdp")){
			this.usuarioLogado.setLogin(login);
			result.redirectTo(ProdutoController.class).lista(); // ok vá para a lista de produtos
		} else{
			//usuário mão reconhecido, volte para o formulário
			result.include("mensagem_erro", "Usuário e/ou senha inválidos");
			result.redirectTo(LoginController.class).formulario();			
		}
	}
	
	public void exibe(){
		result.include("usuario", usuarioLogado.getLogin());
	}
	
	public void formulario(){}

}
