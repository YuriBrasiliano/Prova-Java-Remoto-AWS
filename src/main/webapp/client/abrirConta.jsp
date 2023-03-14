<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Abrir conta FIESC</title>
	<meta charset="UTF-8">
	<script src="../js/CPFMask.js"></script>
	<script src="../js/nomeMask.js"></script>
	<script src="../js/enderecomask.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/main.css">
</head>
<body>
	
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic">
									<span class="login100-form-title">
						Seja Bem Vindo ao Banco FIESP!<br/><br/>Por favor, preencher os dados para a abertura de conta.</span>
						<div class="text-center">
						<span class="txt1">
							<a href="index.jsp" style="text-decoration:none;">Voltar</a><br>
						</span> </div>
					
				</div>
				<form class="login100-form" action="../ServletCriarConta" method="post">
						<div class="wrap-input100">
						<input class="input100" type="text" name="nomeCadastro" placeholder="Digite seu Nome Completo" required id="txt_firstCapital" oninput="nomeCompleto()" pattern="[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$">
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100"  oninput="mascara(this)" type="text" name="cpfCadastro" placeholder="Digite seu CPF" required>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100" type="password" name="SenhaCliente" placeholder="Digite uma senha" required>
						<span class="focus-input100"></span>
					</div>
					<div class="wrap-input100">
						<input class="input100" type="date" name="dateCadastro" placeholder="Digite sua Data de Nascimento" required>
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100">
						<input class="input100" type="text" name="EndCadastro" id="txt_firstCapitalendereco" oninput="endereco()" placeholder="Digite seu Endereço" required>
						<span class="focus-input100"></span>
					</div>
						<br/><br/>
						<button type='submit' class="login100-form-btn">
							Criar Conta
						</button></form>
					</div>

			</div>

</body>

</html>