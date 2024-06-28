
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="css/Mainstyle.css">
</head>
<body>
    <nav>
        <ul class="ulnav">
            <li><a href="index.jsp" class="especialA"><img src="img/volte.png" alt="Voltar" class="img" ></a></li>
        </ul>
    </nav>
        <div class="mainDiv">

    <div class="formDiv">
      
        
        <form action="login-servlet" class="form" method="post">
          <div class="textfield">
          <label for="">USERNAME</label>
          <input type="text" name="username" id="username">
          </div>
          <div class="textfield">
          <label for="">SENHA</label>
          <input type="password" name="password" id="password">
          </div>
          <button type="submit" class="btnLeft">ENVIAR</button>
        </form>
      </div>

        </div>
</body>
</html>