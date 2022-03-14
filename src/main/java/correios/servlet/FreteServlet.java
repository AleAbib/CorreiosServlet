package correios.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import correios.model.Cliente;

@WebServlet("/frete")
public class FreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		Cliente cliente = (Cliente)sessao.getAttribute("usuarioLogado");
		
		Cliente teste = new Cliente();
		teste.setPrazoEntrega(cliente.getPrazoEntrega());
		teste.setValorFrete(cliente.getValorFrete());
		
		Gson gson = new Gson();
		String json = gson.toJson(teste);
				
		response.getWriter().print(json);
	}

}
