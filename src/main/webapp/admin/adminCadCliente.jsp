<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Cadastrar Cliente</title>
</head>
<body>
<body>
		<%
		String admin = (String)session.getAttribute("admin");
		if (admin == null ){
			response.sendRedirect("index.jsp");
		}
		
		%>
<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title"><br/><br/><br/>Por favor, preencher os dados para cadastrar um cliente<br/><br/> (Note que ainda precisa cadastrar uma conta para tal cliente).<br/><br/><br/></span>
						<div class="text-center">
						<span class="txt1">
							<a href="admin_dashboard.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<form class="login100-form" action="../ServletAdminCadCliente" method="post">
				<input type = "hidden" name ="cmd" value="CriarConta"> <br />
						<div class="wrap-input100">
						<input class="input100" type="text" name="nomeCadastro" placeholder="Digite o Nome Completo" required>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100" type="number" name="cpfCadastro" placeholder="Digite o CPF" required>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100" type="password" name="SenhaCliente" placeholder="Digite uma senha para o Cliente" required>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100" type="date" name="dateCadastro" placeholder="Digite a Data de Nascimento" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" name="EndCadastro" placeholder="Digite o Endereço" required>
						<span class="focus-input100"></span>
					</div>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							Criar Conta
						</button></form>
					</div>

			</div>

</body>
</html>