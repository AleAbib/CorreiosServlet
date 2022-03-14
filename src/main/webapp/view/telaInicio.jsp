<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value = "/inicio" var="linkEntradaServlet"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="view/style-telainicio.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Smooch+Sans:wght@200;400;700&display=swap" rel="stylesheet">
  <title>Document</title>
</head>
<body>
	<div class="card">
    <h1>Projeto Correios Web</h1>
    <div class="container-form">
    	<c:if test="${loginValido == false }">
	    	<script type="text/javascript">
	    		window.alert("Usuario e/ou senha incorretos!")
	    	</script>
    	</c:if>
    	<c:set var="loginValido" scope="session" value="true"/>
    	<form class ='form' action="${linkEntradaServlet}" method="post">
	        <div class="label-container">
	    		  <label for='client-login'>Login: </label>
	       		<input id='client-login' placeholder="Login" name="login" >
	        </div>
	        <div class="label-container">
	        	<label for='client-password'>Senha: </label>
	        	<input id='client-password' placeholder="Senha" name="senha" type="password" >
	        </div>
	        <div class="label-container">
	        	<input type="hidden" name=acao value=Login>
				    <input type="submit" value="Entrar">
	        </div>
		</form>
      
      <div class="submit-button">
        <a href="${linkEntradaServlet}?acao=TelaCadastro">
          Cadastrar
        </a>
      </div>
    </div>
  </div>
</body>
</html>