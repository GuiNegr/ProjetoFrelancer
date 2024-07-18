<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil</title>
    <link rel="stylesheet" href="css/homeCad.css">
</head>
<body>

    <nav class="menu">
        <ul class="ulnav">
            <li><a href="index.jsp" class="especialA"><img src="img/volte.png" alt="" class="img2"></a></li>
        </ul>
    </nav>
    <div class="mainDiv">
        <div class="imgDivPerfilLeft">
            <form class="FormPerfil">
                <img src="img/Building hashtag-amico.svg" alt="" class="img">
                <button type="submit" class="btnLeft">Buscar imagen</button>
            </form>
        </div>
        <div class="formPerfil">
            <form action="/ProfileServlet" method="post">
                <div class="textfield">
                    <label for="nome" class="lbNome">Nome</label>
                    <input type="text" name="nome" id="nome" class="inpNom" value="${sessionScope.user.nome}">
                </div>
                <div class="textfield">
                    <label for="sobrenome" class="lbSobrenome">Sobrenome</label>
                    <input type="text" name="sobrenome" id="sobrenome" class="inpSobr" value="${sessionScope.user.sobrenome}">
                </div>
                <div class="textfield">
                    <label for="telefone" class="lbTelefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" class="inpTele" value="${sessionScope.user.telefone}">
                </div>
                <div class="textfield">
                    <label for="email" class="lblEmail">E-MAIL</label>
                    <input type="text" name="email" id="email" class="inpEmail" value="${sessionScope.user.email}">
                </div>
                <div class="textfield">
                    <label for="aboutMe" class="lblME">SOBRE MIN</label>
                    <input type="text" name="aboutMe" id="aboutME" class="inptSOBRE"value="${sessionScope.user.aboutMe}">
                </div>
                <button type="submit" class="btnLeft">Salvar alterações</button>
            </form>
        </div>
    </div>
</body>
</html>
