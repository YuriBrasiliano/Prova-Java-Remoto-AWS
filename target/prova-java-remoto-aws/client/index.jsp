<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="senai.util.ConnectionFactory" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Banco FIESC</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Seja Bem Vindo ao Banco FIESC!<br/><br/><br/>Acesse Sua Conta<br/><br/><br/>
						Desenvolvido por Yuri Brasiliano<br>
						Prova-Java-Remoto por FIESC</span>
					
				</div>

				<form class="login100-form" action="../LoginServlet" method="post">
				<input type = "hidden" name ="cmd" value="FazerLogin"> <br />

					<div class="wrap-input100">
						<input class="input100" type="number" name="CPFCliente" placeholder="CPF/Número da Conta" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="password" name="SenhaCliente" placeholder="Senha" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<button type='submit' class="login100-form-btn">
							Entrar
						</button>
					</div>
					<br/><br/>

					<br/><br/><br/><br/><br/>
					<div class="text-center">
						<a class="txt2" href="abrirConta.jsp">
							Crie sua conta ainda hoje!
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
					
				</form>
			</div>
		</div>

</body>

</html>