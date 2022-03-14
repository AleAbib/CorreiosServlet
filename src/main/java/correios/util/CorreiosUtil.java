package correios.util;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import correios.controller.ClienteController;
import correios.model.Cliente;

public class CorreiosUtil {

	private String uri;
	private ClienteController clienteController = new ClienteController();

	public CorreiosUtil(Cliente cliente) {
		uri = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=&sDsSenha="
				+ "&sCepOrigem=70002900&sCepDestino=" + cliente.getEndereco().getCEP() + "&nVlPeso=1&nCdFormato=1&nVlComprimento=20"
				+ "&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n"
				+ "&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
		
		getAPIFrete(cliente);
		getAPIPrazo(cliente);
		clienteController.atualizar(cliente);
		
	}

	public void getAPIFrete(Cliente cliente) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String APIFrete = doc.getElementsByTagName("Valor").item(0).getTextContent().replace(",", ".");
			Float valor = Float.parseFloat(APIFrete);
			
			cliente.setValorFrete(valor);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	public void getAPIPrazo(Cliente cliente) {
		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response.body())));
			doc.getDocumentElement().normalize();
			String APIPrazo = doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent();
			int valor = Integer.parseInt(APIPrazo);
			
			cliente.setPrazoEntrega(valor);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
