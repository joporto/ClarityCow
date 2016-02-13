<!DOCTYPE html>
<html>
    <head>

<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-submenu.min.css">
<link rel="stylesheet" href="/css/style.css" >

<link rel="stylesheet" href="Style/bootstrap.min.css" >
<link rel="stylesheet" href="Style/bootstrap-submenu.min.css">
<link rel="stylesheet" href="Style/style.css" >


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"  type="text/javascript"></script>
<script src="js/bootstrap.min.js"  type="text/javascript"></script>
<script src="js/bootstrap-submenu.js" type="text/javascript"></script>
<title>Inicio</title>
    </head>
    <body>
<!-- Menu Header -->
<%@include file="header.jsp" %>
<!-- Menu Principal -->
     
<%
            if(session.getAttribute("userSession") == null)
            {
                response.sendRedirect("index.html");
            }
%>

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
</body>
</html>
