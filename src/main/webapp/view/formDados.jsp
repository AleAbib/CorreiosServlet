<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value = "/inicio" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="view/style.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@200;400;700&display=swap" rel="stylesheet">
  <title>Document</title>
</head>
<body>
  <div class="card">
    <h1>Dados do produto</h1>
    <div class="container-form">
      <form action="${linkEntradaServlet}" method="post">

        <h2>Dados da Compra</h2>
        <div class="label-container">
          <label for='product-name'>Nome do produto: </label>
          <input id='product-name' placeholder="Nome do produto" name="nomeDoProduto" >
        </div>
       	
        <div class="label-container">
       	  <label for='product-description'>Descrição do produto: </label>
       	  <input id='product-description' placeholder="Descrição do produto" name="descricao" >
        </div>
		
        <div class="label-container">
          <label for='price'>Valor do produto: </label>
          <input id='price' placeholder="Valor do produto" name="valorProduto">
        </div>

        <div class="label-container">
          <input type="hidden" name="acao" value="NovosDados">
          <input type="submit" placeholder="Enviar">
        </div>
      </form>
    </div>
  </div>  

</body>
</html>