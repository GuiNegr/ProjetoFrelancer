<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/Mainstyle.css">
</head>
<body>
    <nav>
        <ul class="ulnav">
            <li><a href="index.jsp" class="especialA"><img src="img/volte.png" alt="Voltar" class="img" ></a></li>
        </ul>
    </nav>

    <div class="formDiv">
      <form action="create-user" method = "post" class="form">
        <label for="">USERNAME</label>
        <input type="text" name="userName" id="userName" >
        <label for="">NOME </label>
        <input type="text" name="nome" id="nome" >
        <label for="">SOBRENOME</label>
        <input type="text" name="sobrenome" id="sobrenome">
        <label for="">EMAIL</label>
        <input type="email" name="email" id="email" >
        <label for="">SENHA</label>
        <input type="password" name="pass" id="pass" >
        <button type="submit" class="botao">ENVIAR</button>
      </form>
    </div>
</body>
</html>