<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Banco FIESC(ADMIN)</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Banco FIESC<br/><br/><br/>Login de Administrador</span>
					
				</div>

				<form class="login100-form" action = "../AdminServlet" method="post">

					<div class="wrap-input100">
						<input class="input100" type="text" name="EmailAdmin" placeholder="Email" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="password" name="SenhaAdmin" placeholder="Senha" required>
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn">
						<button type='submit' class="login100-form-btn">
							Entrar
						</button>
					</div>
					<br/><br/>

				
				</form>
			</div>
		</div>

</body>

</html>