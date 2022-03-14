package correios.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import correios.controller.ClienteController;
import correios.model.Cliente;
import correios.util.CorreiosUtil;

public class CalculaFrete implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("usuarioLogado");
		
		ClienteController clienteController = new ClienteController();
		clienteController.atualizar(cliente);
		
		new CorreiosUtil(cliente);
		
		
		return "redirect:inicio?acao=TelaProduto";
	}
}
