package correios.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import correios.controller.ClienteController;
import correios.controller.EnderecoController;
import correios.model.Cliente;
import correios.model.Endereco;

public class Cadastro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeCliente = request.getParameter("login");
		String senhaCliente = request.getParameter("senha");

		String paramRua = request.getParameter("rua");
		String paramNumero = request.getParameter("numero");
		String paramCidade = request.getParameter("cidade");
		String paramEstado = request.getParameter("estado");
		String paramCEP = request.getParameter("CEP");

		int numero = Integer.valueOf(paramNumero);

		System.out.println(nomeCliente + senhaCliente);
		
		Endereco CEPValido = new Endereco();
		EnderecoController enderecoController = new EnderecoController();
		CEPValido = enderecoController.buscaCEP(paramCEP);
		
		if (CEPValido != null) {
			Cliente cliente = new Cliente(nomeCliente, senhaCliente, CEPValido);

			ClienteController clienteController = new ClienteController();

			clienteController.cadastrar(cliente);
		} else {

			Endereco endereco = new Endereco(paramRua, numero, paramCidade, paramEstado, paramCEP);
			Cliente cliente = new Cliente(nomeCliente, senhaCliente, endereco);

			ClienteController clienteController = new ClienteController();

			enderecoController.cadastrar(endereco);
			clienteController.cadastrar(cliente);
		}
		return "redirect:inicio?acao=TelaInicio";
	}

}
