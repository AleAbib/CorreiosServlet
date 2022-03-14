package correios.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import correios.controller.ClienteController;
import correios.model.Cliente;

public class Login implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("logando " + login);
		
		ClienteController clienteController = new ClienteController();
		
		
		Cliente cliente = null;
		cliente = clienteController.clienteValido(login, senha);
		
		HttpSession sessao = request.getSession();
		boolean LoginValido = true;
		sessao.setAttribute("loginValido", LoginValido);
		
		if(cliente != null) {
			System.out.println("Usuario existe");
			sessao.setAttribute("usuarioLogado", cliente);
			return "redirect:inicio?acao=MostraForm";
		}else {
			LoginValido = false;
			sessao.setAttribute("loginValido", LoginValido);
			return"redirect:inicio?acao=TelaInicio";
		}
	}

}
