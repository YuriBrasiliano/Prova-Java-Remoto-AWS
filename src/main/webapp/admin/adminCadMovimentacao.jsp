<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="senai.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<title>Cadastrar Movimentação</title>
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
									<span class="login100-form-title">
<br/><br/><br/>Cadastrar Movimentação<br/><br/><br/></span>
						<div class="text-center">
						<span class="txt1">
							<a href="admin_dashboard.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<%
        try {
            Connection conexao = ConnectionFactory.getConnection();
            
	  	      String sql = "SELECT * FROM clientes WHERE numContaCliente IN (SELECT numConta FROM conta);";
		      PreparedStatement stmt = conexao.prepareStatement(sql);
		      ResultSet resultado = stmt.executeQuery();

		      out.println("<table border='2' align= 'center'><tr><th align= 'center'>Depositar/Retirar/Extrato</th><th align= 'center'>Número da Conta</th><th width='500px' align= 'center'>Nome do Cliente</th><th align= 'center'>Data de Nascimento do Cliente</th><th align= 'center'>CPF do Cliente</th><th align= 'center'>Endereço do Cliente</th></tr>");
            while (resultado.next()) {
                String coluna2 = resultado.getString("nomeCliente");
                String coluna1 = resultado.getString("numContaCliente");
                String coluna3 = resultado.getString("DataNascimentoCliente");
                String coluna4 = resultado.getString("CPFCliente");
                String coluna5 = resultado.getString("EnderecoCliente");
                
                out.println("<tr><td align= 'center'><form action='adminVerExtratoConta.jsp' method='post'><button type='submit' name='numConta' value='"+coluna1+"' class='login100-form-btn'>Ver Extrato</button></form><form action='adminCadMovimentacaoDep.jsp' method='post'><button type='submit' name='numConta' value='"+coluna1+"' class='login100-form-btn'>Depositar Valor</button></form><form action='adminCadMovimentacaoRet.jsp' method='post'><button type='submit' name='numConta' value='"+coluna1+"' class='login100-form-btn'>Retirar Valor</button></form></td><td align= 'center'>"+ coluna1 + "</td><td align= 'center'>" + coluna2 + "</td><td align= 'center'>" + coluna3 + "</td><td align= 'center'>" + coluna4 + "</td><td align= 'center'>" + coluna5 + "</td></tr>");
            }

            resultado.close();
            stmt.close();
            conexao.close();
        } catch (SQLException e) {
            out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    %>
					</div>

			</div>

</body>
</html>