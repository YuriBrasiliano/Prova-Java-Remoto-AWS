<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.sql.*" %>
    <%@ page import="senai.util.*" %>
    <%@ page import="java.time.format.DateTimeFormatter" %>
    <%@ page import="java.time.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Extrato Cliente</title>
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
						Extrato Conta<br/><br/> <% out.print(request.getParameter("numConta").toString());%>
					
						<br/><br/>Saldo Atual:<br/><br/>

						<%
						        try {
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, request.getParameter("numConta").toString());
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						            	out.println("R$");
						                out.println(resultado.getString("saldoConta"));
						            }
						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %><br/><br/><br/><br/>

						<span class="txt1">
							<a href="admin_dashboard.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
				
				<div class="login100-form">
				<%
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
	  	      String sql = "SELECT * FROM transacoes WHERE numConta=?";
		      PreparedStatement stmt = conexao.prepareStatement(sql);
		      stmt.setString(1, request.getParameter("numConta").toString());
		      ResultSet resultado = stmt.executeQuery();

		      out.println("<table border='2' align= 'center'><tr><th align= 'center'>Tipo da Transação</th><th width='500px' align= 'center'>Data da Transação</th><th align= 'center'>Valor da Transação</th></tr>");
            while (resultado.next()) {
                String coluna4 = resultado.getString("valorTransacao");
                String coluna2 = resultado.getString("TipoTransacao");
                String coluna3 = resultado.getString("DataTransacao");
                String color = null;
    			
               if(coluna2.startsWith("dep")){coluna2 = "Depósito";color = "blue";}
               if(coluna2.startsWith("ret")){coluna2 = "Retirada";color = "red";}
                
                out.println("<tr><td align= 'center'>"+ coluna2 + "</td><td align= 'center'>" + coluna3 + "</td><td align= 'center'><font color='"+color+"'>R$ " + coluna4 + "</font></td></tr>");
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    %>

			</div></div>
		</div>

</body>

</html>

</body>
</html>