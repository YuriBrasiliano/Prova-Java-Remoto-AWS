<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Conta FIESC</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Olá Novamente!<br/><br/>
						Número da Conta<br/><br/>Saldo em Conta:<br/><br/></span>
						<span class="txt1">
							<br/><br/> <a href="configCliente.jsp" style="text-decoration:none;">Configurações</a><br>
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
							<a href="transferir.jsp" style="text-decoration:none; color:white">Transferir</a>
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