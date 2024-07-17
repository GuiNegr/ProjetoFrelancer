<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%=session.getAttribute("people")%>
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
            <form action="/ProfileServlet" method="get">
                <div class="textfield">
                    <label for="nome" class="lbNome">Nome</label>
                    <input type="text" name="nome" id="nome" class="inpNom" value="${sessionScope.people.nome}">
                </div>
                <div class="textfield">
                    <label for="sobrenome" class="lbSobrenome">Sobrenome</label>
                    <input type="text" name="sobrenome" id="sobrenome" class="inpSobr" value="${sessionScope.people.sobrenome}">
                </div>
                <div class="textfield">
                    <label for="telefone" class="lbTelefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" class="inpTele">
                </div>
                <div class="textfield">
                    <label for="email" class="lblEmail">E-MAIL</label>
                    <input type="text" name="email" id="email" class="inpEmail">
                </div>
                <div class="textfield">
                    <label for="aboutMe" class="lblME">SOBRE MIN</label>
                    <input type="text" name="aboutMe" id="aboutME" class="inptSOBRE">
                </div>
                <button type="submit" class="btnLeft">Salvar alterações</button>
            </form>
        </div>
    </div>
</body>
</html>
