<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Conta FIESC</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

		<%
		String cliente = (String)session.getAttribute("cliente");

		if (cliente == null ){
			response.sendRedirect("../client/index.jsp");
		}
		
		%>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
<%
						        try {
						        	if (cliente != null ){
						        		String numConta = new StringBuilder(cliente).reverse().toString();
						        	
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT nomeCliente FROM clientes WHERE numContaCliente=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String nome = resultado.getString("nomeCliente");
						                out.println("Olá "+ nome);}

						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } }catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }


						        try {
						        	if (cliente != null ){
										out.print("<br><br>Número da Conta<br>");
										out.print(new StringBuilder(cliente).reverse().toString());
										out.print("<br><br>Saldo em Conta: <br>");
										
							            Connection conn = ConnectionFactory.getConnection();
								  	    String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
									    PreparedStatement stmt = conn.prepareStatement(sql);
									    stmt.setString(1, new StringBuilder(cliente).reverse().toString());
									    ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                out.println(resultado.getString("saldoConta"));
						            }						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        }} catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %>
						    </span>
						<span class="txt1"><a href="deslogar.jsp" style="text-decoration:none;">Deslogar</a></span>
						
						</div>
						
						
				<div class="login100-form">
				<span class="login100-form-title">Oque deseja fazer?</span>
						<button onclick="window.location.href = 'retirar.jsp'" type='submit' class="login100-form-btn">Retirar</button>
						<br/><br/>
						<button onclick="window.location.href = 'depositar.jsp'" type='submit' class="login100-form-btn">Depositar</button>
						<br/><br/>
						<button onclick="window.location.href = 'extrato.jsp'" type='submit' class="login100-form-btn">Verificar Extrato</button>
					</div>

			</div>
		</div>

</body>

</html>