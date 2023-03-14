<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Operação Realizada com Sucesso!</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
		<div class="container-login100">
			<div class="wrap-login100" style="justify-content: center; text-align:center;">
				<h1>Operação Realizada com Sucesso!<br><br></h1>
				<h2>Gostaria de Fazer outra operação<br><br>
				
								<%
				if (session.getAttribute("cliente") != null){
					out.print("<button class='login100-form-btn' onclick="+"window.open(document.referrer,'_self');"+">Clique aqui</button>");
				}else if (session.getAttribute("admin") != null){
					out.print("<button class='login100-form-btn' onclick='javascript: history.go(-2)');'>Clique aqui</button>");
				}
				
				%>
				
				</div>
</div>


</body>
