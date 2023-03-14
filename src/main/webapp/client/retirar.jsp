<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.sql.*" %>
    <%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<title>Retirar</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

		<%
		String cliente = (String)session.getAttribute("cliente");
		if (cliente == null ){
			response.sendRedirect("/index.jsp");
		}
		String numConta = new StringBuilder(cliente).reverse().toString();
		%>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Retirar Conta <br><br><br><% out.print(numConta);%><br/><br/><br/><br/>Saldo Atual:<br/><br/>
						<%
						        try {
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                out.println("R$ " + resultado.getString("saldoConta"));
						            }
						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %></span>
						<div class="text-center">
						<span class="txt1">
							<a href="conta.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<form class="login100-form" action="../ServletRetirar" method="post">
				<span class="login100-form-title">
						Quanto deseja retirar ?</span>
		<div class="wrap-input100">
						<input class="input100" type="text" name="valorRetirar" placeholder="Valor a ser retirado" required pattern="^\d*(\.\d{0,2})?$">
						<span class="focus-input100"></span>
					</div>
						<br/><br/>
						<button type='submit' name="retirarvalor" value="<%= numConta %>" class="login100-form-btn">
							Retirar
						</button>
					</form>

			</div>
		</div>

</body>

</html>