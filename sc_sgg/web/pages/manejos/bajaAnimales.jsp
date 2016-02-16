<%-- 
    Document   : Prueba
    Created on : 14-feb-2016, 23:25:06
    Author     : Murciegalo
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
    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-select.css" rel="stylesheet">
    
    <script src="/js/bootstrap-select.js"></script>
        
                   <style>
    body {
        padding-top: 70px;
        /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
        
        .form_animales{
            padding-top: 5%;
        }
        
        .contenido{
            margin-top: 5%;
        }
    </style>
    </head>
    <body>
        
        
        <!-- Menu Header -->

<%@include file="../../header.jsp" %>
<!-- Menu Principal -->

<div class="container" >
      <div class="panel panel-default">
      <!-- Inicio Head -->
    <div class="panel-heading"><%@include file="../../nav.jsp" %></div>
      <form  action="bajaAnimales" method="post">
                <label >DIIO</label>
                <input type="text" id="txtBuscar" name="txtBuscar" title="Solo Números"   >
                <!--<button type="button" id="boton_1" class="btn btn-default" >Default</button>-->
                <input type="submit" />
            </form>
        
               
                      <div class="contenido" style="display:none;">
                    
                   <ul>
                       <li><label>DIIO ANIMAL</label>     <input type="text" id="txtDio" name="txtDio"   title="Solo Números"  > </li> 
                       <li><label>Fecha Registro</label>  <input type="date" id="txtFechaRegistro" name="txtFechaRegistro"   value ="today();" ></li>
                        <li><label>Fecha Baja</label><input type="date" id="txtFechaBaja" name="txtFechaBaja"   value="" >  </li> 
                        <li><label>Cambio estado Animal</label> </li>
                        <li>                                                      
                      </li>
                        <li> <label>Motivo Aparente</label>
                            <form action="guardarBaja">
                                 <input type="text" id="txtBuscar" name="txtBuscar" title="Solo Números"   >
                <!--<button type="button" id="boton_1" class="btn btn-default" >Default</button>-->
                <input type="submit"  method="post"/>
                                
                            </form>
   
                        </li>
                       <ul>
                           <input type="submit" value="Guardar"/>
                    
               </div>
</div>
          <%if(request.getAttribute("message")!=("") && request.getAttribute("message")!=null){
              
              if(request.getAttribute("message") == "Dio Encontrado" ){
              %>
              <style>
                  .contenido{
                      
                      display: block!important;
                  }
              </style>
              <%
              }

            out.println(request.getAttribute("message"));
          /*   out.println(request.getAttribute("fechaBaja"));*/            
          
              
               
               }
          else{
           
              out.println("");
          }
          %>  
       <!--  <label id="message"></label> -->
       
       
        <!-- Inicio Footer -->
         <!--
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>
  -->
    </body>
</html>
