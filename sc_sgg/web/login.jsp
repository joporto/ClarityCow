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


        <!-- Versión compilada y comprimida del CSS de Bootstrap -->
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style type="text/css">
            .form-signin
            {
                max-width: 330px;
                padding: 15px;
                margin: 0 auto;
            }
            .form-signin .form-signin-heading, .form-signin .checkbox
            {
                margin-bottom: 10px;
            }
            .form-signin .checkbox
            {
                font-weight: normal;
            }
            .form-signin .form-control
            {
                position: relative;
                font-size: 16px;
                height: auto;
                padding: 10px;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }
            .form-signin .form-control:focus
            {
                z-index: 2;
            }
            .form-signin input[type="text"]
            {
                margin-bottom: -1px;
                border-bottom-left-radius: 0;
                border-bottom-right-radius: 0;
            }
            .form-signin input[type="password"]
            {
                margin-bottom: 10px;
                border-top-left-radius: 0;
                border-top-right-radius: 0;
            }
            .account-wall
            {
                margin-top: 20px;
                padding: 40px 0px 20px 0px;
                background-color: #f7f7f7;
                -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
                box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            }
            .login-title
            {
                color: #555;
                font-size: 18px;
                font-weight: 400;
                display: block;
            }
            .profile-img
            {
                width: 96px;
                height: 96px;
                margin: 0 auto 10px;
                display: block;
                -moz-border-radius: 50%;
                -webkit-border-radius: 50%;
                border-radius: 50%;
            }
            .need-help
            {
                margin-top: 10px;
            }
            .new-account
            {
                display: block;
                margin-top: 10px;
            }
        </style>
        <script type='text/javascript'>//<![CDATA[
            window.onload = function () {

            }//]]> 
        </script>
    </head>
    <body>
        <%
            if (request.getParameter("cmd") != null) {
                if (request.getParameter("cmd").equals("close")) {
                    request.getSession().setAttribute("userSession", null);
                }
            }
        %>

        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-md-4 col-md-offset-4">
                    <h1 class="text-center login-title">Iniciar sesión - ClarityCow</h1>

                    <%
                        if (request.getParameter("mensaje") != null) {
                            String msj = request.getParameter("mensaje");
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                        if (request.getAttribute("mensaje") != null) {
                            String msj = request.getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                        if (request.getSession().getAttribute("mensaje") != null) {
                            String msj = request.getSession().getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                        
                        
                    %>



                    <div class="account-wall">
                        <img class="profile-img" src="/img/logo_sc.png"
                             alt="">
                        <form class="form-signin" action="/LoginServlet" method="post">
                            <input type="text" class="form-control" placeholder="Usuario" required autofocus name="Usuario">
                            <input type="password" class="form-control" placeholder="Password" required name="password">
                            <button class="btn btn-lg btn-primary btn-block" type="submit">
                                Iniciar Sesión</button>
                            <label class="checkbox pull-left">
                                <input type="checkbox" value="remember-me">
                                Recordar contraseña
                            </label>
                        </form>
                    </div>
                </div>
            </div>
        </div>




    </body>
</html>
