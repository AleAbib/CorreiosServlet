package correios.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import correios.controller.ClienteController;
import correios.controller.ProdutoController;
import correios.model.Cliente;
import correios.model.Produto;

public class NovosDados implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		String paramValorProduto = request.getParameter("valorProduto");
		String paramNomeDoProduto = request.getParameter("nomeDoProduto");
		String paramDescricao = request.getParameter("descricao");
		Float valorProduto = Float.valueOf(paramValorProduto);
		
		HttpSession sessao = request.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("usuarioLogado");
		
		Produto produto = new Produto(paramNomeDoProduto, paramDescricao, valorProduto);
		
		cliente.setProduto(produto);
		
		ProdutoController produtoController = new ProdutoController();
		ClienteController clienteController = new ClienteController();
		produtoController.cadastrar(produto);
		clienteController.atualizar(cliente);
		
		System.out.println("Produto Cadastrado");
		
		return "redirect:inicio?acao=CalculaFrete";
	}

}
