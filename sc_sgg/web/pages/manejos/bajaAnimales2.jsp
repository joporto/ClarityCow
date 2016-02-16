<!DOCTYPE html>
<html>
    <head>
    <title>Baja de animales</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-select.css" rel="stylesheet">
    
    <script src="/js/bootstrap-select.js"></script>
    
    <!-- Custom CSS -->


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
   <%
                if(request.getSession().getAttribute("userSession") == null)
                response.sendRedirect("/login.jsp");
                  
    %> 
    
    <!-- Menu Header -->
    <%@include file="/header.jsp" %>
    <!-- Menu Principal -->

    <div class="container">
    <h2>Baja de Animales</h2>
    
    <div class="panel-heading"><%@include file="/nav.jsp" %></div>
        <!-- Inicio Contenido -->
        
    <div class="panel-body">
        <form name="buscarDiioForm">
        <p>Buscar DIIO</p>       
        <input type="text" class="text-input" name="buscarDiio">
        <input type="submit" class="" name="btnBuscarDiio" value="Buscar">    
        </form>
    </div>
            
            
            
        
      <!-- Inicio Footer -->
      <div class="panel-footer"><%@include file="/footer.jsp" %></div>
    
    </div>
    <!-- jQuery Version 1.11.1 -->
    <script src="/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>  
    </body>
</html>
