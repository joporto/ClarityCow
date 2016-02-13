<%-- 
    Document   : bajaAnimales2
    Created on : 13-feb-2016, 2:58:45
    Author     : javierOporto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Baja de animales</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-select.css" rel="stylesheet">
    
    <script src="/js/bootstrap-select.js"></script>
    
    <!-- Custom CSS -->
    <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    </head>
    <body>
   
   

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12 text-center">
                <h1>Contactos</h1>
                <p class="lead">Mantenga sus contactos actualizados</p>
            </div>
        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->
    <!-- filtros de búsqueda -->
    <div class="container jumbotron">
        <form name="contactosFiltros">
        <p>Empresa </p>       
        <select class="selectPicker">
          <option>Mutual</option>
          <option>Cardif</option>
        </select>
            
        </form>
    </div>
    
    <!-- Tabla de contactos -->
    <div class="container table-responsive">
        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Empresa</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
               
           
        
    </div>
    
    
    
    <!-- jQuery Version 1.11.1 -->
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>    
        
        
    </body>
</html>
