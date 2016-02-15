<%-- 
    Document   : Prueba
    Created on : 14-feb-2016, 23:25:06
    Author     : Murciegalo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-submenu.min.css">
<link rel="stylesheet" href="/css/style.css" > 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"  type="text/javascript"></script>
<script src="../../js/bootstrap.min.js"  type="text/javascript"></script>
<script src="../../js/bootstrap-submenu.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Baja Animales</title>
    </head>
    <body>
        <!-- Menu Header -->

<%@include file="../../header.jsp" %>
<!-- Menu Principal -->

<div class="container">
      <div class="panel panel-default">
      <!-- Inicio Head -->
    <div class="panel-heading"><%@include file="../../nav.jsp" %></div>
               <form  action="bajaAnimales" method="post">
                <label >DIIO</label>
                <input type="text" id="txtBuscar" name="txtBuscar" class="form-control" id="usr" title="Solo Números"  >
                <!--<button type="button" id="boton_1" class="btn btn-default" >Default</button>-->
                <input type="submit" />
            </form>
        
</div>
          <%if(request.getAttribute("message")!=(""))
            out.println(request.getAttribute("message"));
          else{
              out.println("");
          }
          %> 
       <!--  <label id="message"></label> -->
       
       
         <!-- Inicio Footer -->
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>
  
    </body>
</html>
