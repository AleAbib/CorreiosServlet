<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/inicio" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="view/style-telaproduto.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@200;400;700&display=swap" rel="stylesheet">
  <title>Document</title>
</head>
<body>
	<div class="card">
    <h1>Produtos</h1>
    <span>
    	Produto: ${usuarioLogado.produto.nomeProduto } 
    </span>
    <span>
    	Descrição: ${usuarioLogado.produto.descricao}
    </span>
    <span>
    	Valor do frete: ${usuarioLogado.valorFrete }
    </span>
	<span>
		Prazo de entrega: ${usuarioLogado.prazoEntrega }
	</span>
	
  	<a href="${linkEntradaServlet}?acao=MostraJson">
          Imprimir
    </a>
  </div>
</body>
</html>