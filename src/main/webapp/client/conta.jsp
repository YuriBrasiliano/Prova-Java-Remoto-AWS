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
			response.sendRedirect("/index.jsp");
		}
		
		%>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Olá <%
						        try {
						        	String numConta = new StringBuilder(cliente).reverse().toString();
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT nomeCliente FROM clientes WHERE numContaCliente=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String nome = resultado.getString("nomeCliente");
						                out.println(nome);}

						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %><br/><br/>
						Número da Conta<br/><br/>
						<%
						
						String cpfCliente = (String)session.getAttribute("cliente");
						if (cliente != null ){						
						String numConta = new StringBuilder(cpfCliente).reverse().toString();
						out.print(numConta);						
						}else{
							response.sendRedirect("/index.jsp");
						}
						String numConta = new StringBuilder(cliente).reverse().toString();
						%>

						<br/><br/>Saldo em Conta:<br/><br/>
						
						<%
						        try {
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String coluna1 = resultado.getString("saldoConta");

						                out.println(coluna1);
						            }
						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %></span>
						<span class="txt1">
							<br/><br/> <a href="deslogar.jsp" style="text-decoration:none;">Deslogar</a><br>
						</span> </div>
				<div class="login100-form">
				<span class="login100-form-title">
						Oque deseja fazer?</span>
						<button type='submit' class="login100-form-btn">
							<a href="retirar.jsp" style="text-decoration:none; color:white">Retirar</a>
						</button>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							<a href="depositar.jsp" style="text-decoration:none; color:white">Depositar</a>
						</button>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							<a href="extrato.jsp" style="text-decoration:none; color:white">Verificar Extrato</a>
						</button>
					</div>

			</div>
		</div>

</body>

</html>