<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Extrato</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>

		<%
		String cliente = (String)session.getAttribute("cliente");
		if (cliente == null ){
			response.sendRedirect("index.jsp");
		}
		%>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Extrato Conta
						
						<br/><br/>
						
						<%
						String cpfCliente = (String)session.getAttribute("cliente");
						String numConta = new StringBuilder(cpfCliente).reverse().toString();
						out.print(numConta);						
						%>
						<br/><br/>Saldo Atual:<br/><br/>

						<%
						        try {
						            Connection conn = ConnectionFactory.getConnection();
						  	      String sql = "SELECT saldoConta FROM conta WHERE numConta=?";
							      PreparedStatement stmt = conn.prepareStatement(sql);
							      stmt.setString(1, numConta);
							      ResultSet resultado = stmt.executeQuery();
						
						            while (resultado.next()) {
						                String coluna1 = resultado.getString("saldoConta");
						
						                // ...
						                out.println(coluna1);
						            }
						
						            resultado.close();
						            stmt.close();
						            conn.close();
						        } catch (SQLException e) {
						            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
						        }
						    %><br/><br/><br/><br/>
						    						<span class="txt1">
							<a href="conta.jsp" style="text-decoration:none;">Voltar</a><br>
						</span>
 </div>
				
				<div class="login100-form">
				<%
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
	  	      String sql = "SELECT * FROM transacoes WHERE numConta=?";
		      PreparedStatement stmt = conexao.prepareStatement(sql);
		      stmt.setString(1, numConta);
		      ResultSet resultado = stmt.executeQuery();

		      out.println("<table border='2' align= 'center'><tr><th align= 'center'>Tipo da Transação</th><th width='500px' align= 'center'>Data da Transação</th><th align= 'center'>Valor da Transação</th></tr>");
            while (resultado.next()) {
                String coluna4 = resultado.getString("valorTransacao");
                String coluna2 = resultado.getString("TipoTransacao");
                String coluna3 = resultado.getString("DataTransacao");
                String color = null;

               if(coluna2.startsWith("dep")){coluna2 = "Depósito";color = "blue";}
               if(coluna2.startsWith("ret")){coluna2 = "Retirada";color = "red";}
                
                out.println("<tr><td align= 'center'>"+ coluna2 + "</td><td align= 'center'>" + coluna3 + "</td><td align= 'center'><font color='"+color+"'>" + coluna4 + "</font></td></tr>");
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