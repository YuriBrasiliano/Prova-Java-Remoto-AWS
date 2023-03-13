<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>
<%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Alteração de Dados</title>
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
						Alterar Cadastro <br/><br/>Cliente<br/><br/><%
						        try {
						        	String numConta = request.getParameter("numConta");
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT * FROM clientes WHERE numContaCliente=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String nome = resultado.getString("nomeCliente");
						                out.println(nome);
						                out.println("<br><br>Conta<br><br>");
						                out.println(request.getParameter("numConta"));}

						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %>
						<br/><br/>Deseja Excluir a Conta do Cliente ?<br/></span>
						
						<form action="../ServletAdminExcluirConta" method="post">
						<button type='submit' name = 'numConta' value = '<%= request.getParameter("numConta") %>' class="login100-form-btn">
							Excluir Conta
						</button></form><br/><br/><br/><br/>
						
						<div class="text-center">
						<span class="txt1">
							<a href="admin_dashboard.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<form class="login100-form" action="../ServletAdminAlterarConta" method="post">
				<input type = "hidden" name ="cmd" value="CriarConta">
				
									<div class="wrap-input100">
						<input class="input100" type="text" name="NomeCompleto" placeholder="Digite o Nome Completo" required>
						<span class="focus-input100"></span>
					</div>
				<%
						        try {
						        	String numConta = request.getParameter("numConta");
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT * FROM clientes WHERE numContaCliente=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String CPF = resultado.getString("CPFCliente");
						                String DataNascimento = resultado.getString("DataNascimentoCliente");
						                out.println("<center><strong><br><br>CPF<br><br></strong>"+CPF+"<br><br>");
						                out.println("<strong>Data de Nascimento<br><br></strong>"+DataNascimento+"<br><br></center>");}
						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %><br><br><br>
					<div class="wrap-input100">
						<input class="input100" type="password" name="SenhaCliente" placeholder="Digite uma nova senha" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" name="EndCadastro" placeholder="Digite o Endereço" required>
						<span class="focus-input100"></span>
					</div>
						<br/><br/>
						<button type='submit' class="login100-form-btn" name="numConta" value="<%= request.getParameter("numConta") %>">
							Alterar Conta
						</button></form>
					</div>

			</div>

</body>

</html>