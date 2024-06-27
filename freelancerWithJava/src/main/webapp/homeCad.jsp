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
            <li><a href="login.jsp" class="especialA"><img src="img/volte.png" alt="" class="img2">
        </ul>
    <div class="mainDiv">
        <!--OQUE ESTÁ A ESQUERDA COM IMAGEN E A OPÇÃO DE LEVAR O ARQUIVO-->
            <div class="imgDivPerfilLeft">
                    <form action="" class="FormPerfil">
                    <img src="img/Building hashtag-amico.svg" alt="" class="img">
                    <button type="submit" class="btnLeft">Buscar imagen</button>
                    </form>
            </div>
    <!--OQUE ESTÁ A DIREITA COM O FORMULARIO CARREGANDO O HHTPSESSION-->
            <div class="formPerfil">
                    <form action="ProfileServlet" method = "post" class="form">

                <div class="textfield">
                        <label for="" class="lbNome">Nome</label>
                        <input type="text" name="" id="" class="inpNom">
                    </div>
                    
                    <div class="textfield">
                        <label for="" class="lbSobrenome">Sobrenome</label>
                        <input type="text" name="" id="" class="inpSobr">
                    </div>

                    <div class="textfield">
                        <label for="" class="lbTelefone">Telefone</label>
                        <input type="text" name="" id="" class="inpTele">
                    </div>
                        <div class="textfield">
                        <label for="" class="lblEmail">E-MAIL</label>
                        <input type="text" name="" id="" class="inpEmail">
                    </div>
                        <div class="textfield">
                        <label for="" class="lblME">SOBRE MIN</label>
                        <input type="text" name="" id="" class="inptSOBRE">
                    </div>
                        <button type="submit" class="btnLeft">Salvar alterações</button>
                    </form>
            </div>
    
    </div>
    </nav>
</body>
</html>