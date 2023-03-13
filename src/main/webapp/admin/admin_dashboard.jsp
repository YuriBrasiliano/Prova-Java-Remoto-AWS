<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Admin Dashboard</title>
</head>
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
									<span class="login100-form-title">
						Olá Admin!<br/><br/>

</span>
						<span class="txt1">
							<br/><br/> <a href="deslogar.jsp" style="text-decoration:none;">Deslogar</a><br>
						</span> </div>
				<div class="login100-form">
				<span class="login100-form-title">
						Oque deseja fazer?</span>
						<button type='submit' class="login100-form-btn">
							<a href="adminCadCliente.jsp" style="text-decoration:none; color:white">Cadastrar Cliente</a>
						</button>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							<a href="adminCadConta.jsp" style="text-decoration:none; color:white">Cadastrar Conta</a>
						</button>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							<a href="adminCadMovimentacao.jsp" style="text-decoration:none; color:white">Cadastrar Movimentação</a>
						</button>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							<a href="adminAlterarCliente.jsp" style="text-decoration:none; color:white">Alterar Dados do Cliente</a>
						</button>
					</div>

			</div>
		</div>

</body>

</html>