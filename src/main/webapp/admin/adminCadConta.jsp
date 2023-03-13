<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Cadastrar Conta</title>
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

									<span class="login100-form-title">
						Selecione um dos Clientes sem conta:
						
						<br/><br/>
						    						<div class="text-center">
						<span class="txt1">
							<a href="admin_dashboard.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>

				<%
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
	  	      String sql = "SELECT * FROM clientes WHERE numContaCliente NOT IN (SELECT numConta FROM conta);";
		      PreparedStatement stmt = conexao.prepareStatement(sql);
		      ResultSet resultado = stmt.executeQuery();

		      out.println("<table border='2' align= 'center'><tr><th align= 'center'>Criar Conta</th><th align= 'center'>Número da Conta</th><th width='500px' align= 'center'>Nome do Cliente</th><th align= 'center'>Data de Nascimento do Cliente</th><th align= 'center'>CPF do Cliente</th><th align= 'center'>Endereço do Cliente</th></tr>");
            while (resultado.next()) {
                String coluna2 = resultado.getString("nomeCliente");
                String coluna1 = resultado.getString("numContaCliente");
                String coluna3 = resultado.getString("DataNascimentoCliente");
                String coluna4 = resultado.getString("CPFCliente");
                String coluna5 = resultado.getString("EnderecoCliente");
                
                out.println("<tr><td align= 'center'><form action='../ServletCadContaFinal' method='post'><button type='submit' name='numContaCliente' value='"+coluna1+"' class='login100-form-btn'>Criar Conta</button></form></td><td align= 'center'>"+ coluna1 + "</td><td align= 'center'>" + coluna2 + "</td><td align= 'center'>" + coluna3 + "</td><td align= 'center'>" + coluna4 + "</td><td align= 'center'>" + coluna5 + "</td></tr>");
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    %>
    </span>



		</div></div>
		

</body>
</html>