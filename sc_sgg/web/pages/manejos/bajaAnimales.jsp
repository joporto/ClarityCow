<%-- 
    Document   : bajaAnimales
    Created on : 12-feb-2016, 23:10:45
    Author     : Murciegalo
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-submenu.min.css">
<link rel="stylesheet" href="/css/style.css" >


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"  type="text/javascript"></script>
<script src="../js/bootstrap.min.js"  type="text/javascript"></script>
<script src="../js/bootstrap-submenu.js" type="text/javascript"></script>
<title>Inicio</title>
    </head>
<body>

<!-- Menu Header -->
<%@include file="../../header.jsp" %>
<!-- Menu Principal -->
     


 
<div class="container">
  <h2>Las Vaquitas</h2>
  <div class="panel panel-default">
      <!-- Inicio Head -->
    <div class="panel-heading"><%@include file="../../nav.jsp" %></div>
    
    <!-- Inicio Contenido -->
    <div class="panel-body">
        
        
        <div class="contenedor">
            <form>
                <label>DIIO</label>
                <textarea></textarea>
                <button>Buscar</button>
            </form>
        </div>
        
        
           <div class="contenedor">
               <ul>
                   <li><label>DIIO ANIMAL*</label> <textarea></textarea></li>
                   <li><label>Fecha Baja*</label> <textarea></textarea></li>
                   <li><label>Fecha Registro</label> <textarea></textarea></li>
                   <li><label>Cambio estado Animal</label>   </li>
                   <div class="checkbox">
                        <label><input type="checkbox" value="">Option 1</label>
                      </div>
                      <div class="checkbox">
                        <label><input type="checkbox" value="">Option 2</label>
                      </div>
                   
                                     </ul>
                     </div>
        
        
    </div>
    
    <!-- Inicio Footer -->
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>
  </div>
</div>
        
    </body>
</html>
