<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-submenu.min.css">
<link rel="stylesheet" href="/css/style.css" >

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"  type="text/javascript"></script>
<script src="/js/bootstrap.min.js"  type="text/javascript"></script>
<script src="js/bootstrap-submenu.js" type="text/javascript"></script>
<title>Inicio</title>
    </head>
<<<<<<< HEAD
    <body>
     Listado de Razas
     <br>
        <%
            cl.sgg.dao.RazaDAO rdao = new cl.sgg.dao.RazaDAO();
            
            for(cl.sgg.edm.Raza arg : rdao.getList())
            {
                out.print(arg.getRazaNombre());
        %>
        
        <br>
        
        <%
            }
            
        %>
=======
<body>

<!-- Menu Header -->
<%@include file="header.jsp" %>
<!-- Menu Principal -->
     

<!--
<div class="container-fluid">
  <h1></h1>
  <p></p> 
</div>

holi

dos
-->
 
<div class="container">
  <h2>Las Vaquitas</h2>
  <div class="panel panel-default">
      <!-- Inicio Head -->
    <div class="panel-heading"><%@include file="nav.jsp" %></div>
    
    <!-- Inicio Contenido -->
    <div class="panel-body"></div>
    
    <!-- Inicio Footer -->
    <div class="panel-footer">
        <%@include file="footer.jsp" %></div>
  </div>
</div>
>>>>>>> origin/master
        
    </body>
</html>
