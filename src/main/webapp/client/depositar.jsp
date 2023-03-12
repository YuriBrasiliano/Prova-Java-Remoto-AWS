<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Depositar</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Depositar<br/><br/><br/><br/>Saldo Atual:<br/><br/><br/></span>
						<div class="text-center">
						<span class="txt1">
							<a href="conta.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<div class="login100-form">
				<span class="login100-form-title">
						Quanto deseja Depositar?</span>
						<div class="wrap-input100">
						<input class="input100" type="number" name="valorDepositar" placeholder="Valor a ser depositado" required>
						<span class="focus-input100"></span>
					</div>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							Depositar
						</button>
					</div>

			</div>
		</div>

</body>

</html>