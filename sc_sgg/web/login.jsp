<%-- 
    Document   : login
    Created on : 13-feb-2016, 3:40:03
    Author     : javierOporto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login SGG</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 
    <!-- Versión compilada y comprimida del CSS de Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
     <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    
     <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
    
     <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
        <%
            if(request.getParameter("cmd") != null)
            {     
                if(request.getParameter("cmd").equals("close"))
                request.getSession().setAttribute("userSession",null);
            }
        %>
        
        
    <div class="container">
        <form class="form-signin" action="LoginServlet" method="post">
        
            <h2>SGG SmartClarity</h2>
            <h3 class="form-signin-heading">Iniciar Sesión</h3>
        
            <label for="inputUsuario" class="sr-only">Usuario</label>
            <input type="text" id="inputEmail" class="form-control" placeholder="Usuario" required autofocus name="Usuario">
        
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
        
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Recordar contraseña
          </label>
        </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
    </div> 
    </body>
</html>
