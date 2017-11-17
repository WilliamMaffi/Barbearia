package controllers;

import play.mvc.*;
import play.data.*;

import javax.inject.Inject;

import views.html.*;

import models.*;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory;

    @Inject
    Produto produto;

    @Inject 
    Barbearia barbearia;

    
    public Result index() {
        return ok(index.render("Ola Mundo"));
    }

    public Result cadastroDeProduto(){
        Form<Produto> formProduto = formFactory.form(Produto.class).bindFromRequest();
    	return ok(cadastroDeProduto.render("Cadastro", formProduto));
    }

    public Result listaTudo(){
        List<Produto> listDeProdutos = produto.find.all();
        
        return ok(listagem.render(listDeProdutos));

    }

    public Result cadastroDeNovoProduto(){
        DynamicForm formulario = formFactory.form().bindFromRequest();
        produto.nome = formulario.get("nome");
        produto.descricao = formulario.get("desc");
        produto.unidade = formulario.get("un");
        produto.preco = Double.valueOf(formulario.get("preco"));

        produto.save();

        flash("success", produto.nome + " cadastrado com sucesso");

        return redirect(routes.HomeController.cadastroDeProduto());
    }


	public Result barbearia(){
    	Form<Barbearia> formBarbearia = formFactory.form(Barbearia.class).bindFromRequest();
    	return ok(barbearia.render("Barbearia", formBarbearia));
	}
    
}

