<<<<<<< HEAD
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
   <link href="/css/style.css" rel="stylesheet" type="text/css"/>
       <!-- jQuery Version 1.11.1 -->
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>   
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
        
        .bajatxt1{
            
            margin-left: 10.2%;
        }
        
         .bajatxt2{

    margin-left: 94px;
    width: 174px;

        }
        
          .bajatxt3{
             margin-left: 126px;   
            width: 174px;
        }
        
        .ulBaja{
       list-style:none;
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
    
     <div class="container jumbotron">
      <form  id="bajaAnimales" action="bajaAnimales" method="post">
                <p>Buscar DIIO</p>       
               
                <input type="text" id="txtBuscar"   class="text-input"  name="txtBuscar" title="Solo Números"   >
                <label value="<%=request.getAttribute("dioActual")%>"></label>
                <input type="submit" onclick="valor();"/>
            </form>
     </div>
               
                      <div class="contenido" style="display:none;">
                    
                   <ul class="ulBaja">
                       <li><label>DIIO ANIMAL</label>     <input type="text"  class="bajatxt1" id="txtDio" name="txtDio"  value="<%=request.getAttribute("dioActual")%>" title="Solo Números"  disabled > </li> 
                       <li><label>Fecha Registro</label>  <input type="date" class="bajatxt2" id="txtFechaRegistro" name="txtFechaRegistro"   ></li>
                        <li><label>Fecha Baja</label><input type="date" id="txtFechaBaja" class="bajatxt3" name="txtFechaBaja"   value="" >  </li> 
                        <p></p>
                        <li><label>Cambio estado Animal</label> 
                      
                       <BR>
             <INPUT TYPE="radio" NAME="radios" VALUE="radio1" CHECKED>
             Muerto
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="radio2">
             Robo   
             <BR>      
            </li>                      
           <li> <label>Motivo Aparente</label>
            <select class="form-control">
            <option></option>           
          </select>  
             </li>
                       <ul>
                           <input type="submit" value="Guardar"/>
                    
               </div>
                </div>
                       
                       
                       <script type="text/javascript">
                           $('#txtFechaRegistro').datepicker({ 
     dateFormat: 'dd-mm-yy'
     }).datepicker("setDate", new Date());
                           </script>
    
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
         /*  out.println(request.getAttribute("dioActual"));*/
          /*   out.println(request.getAttribute("fechaBaja"));*/            
          
              
               
               }
          else{
           
              out.println("");
          }
          %>  
       <!--  <label id="message"></label> -->
       <!--
       <script type="text/javascript">
           function valor(){
               var valuer =  document.getElementById("txtBuscar");
               var bajatxt =  document.getElementById("bajatxt1");
               if(valuer != null)                 
                   $( "p" ).text( valuer.value );
               
           
           }
           </script>  -->
        <!-- Inicio Footer -->
      
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>

    </body>
</html>
=======
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
       <!-- jQuery Version 1.11.1 -->
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>   
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
        
        .bajatxt1{
            
            margin-left: 10.2%;
        }
        
         .bajatxt2{

    margin-left: 94px;
    width: 174px;

        }
        
          .bajatxt3{
             margin-left: 126px;   
            width: 174px;
        }
        
        .ulBaja{
       list-style:none;
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
    
     <div class="container jumbotron">
      <form  id="bajaAnimales" action="bajaAnimales" method="post">
                <p>Buscar DIIO</p>       
               
                <input type="text" id="txtBuscar"   class="text-input"  name="txtBuscar" title="Solo Números"   >
                <label value="<%=request.getAttribute("dioActual")%>"></label>
                <input type="submit" onclick="valor();"/>
            </form>
     </div>
               
                      <div class="contenido" style="display:none;">
                    
                   <ul class="ulBaja">
                       <li><label>DIIO ANIMAL</label>     <input type="text"  class="bajatxt1" id="txtDio" name="txtDio"  value="<%=request.getAttribute("dioActual")%>" title="Solo Números"  disabled > </li> 
                       <li><label>Fecha Registro</label>  <input type="date" class="bajatxt2" id="txtFechaRegistro" name="txtFechaRegistro"   ></li>
                        <li><label>Fecha Baja</label><input type="date" id="txtFechaBaja" class="bajatxt3" name="txtFechaBaja"   value="" >  </li> 
                        <p></p>
                        <li><label>Cambio estado Animal</label> 
                      
                       <BR>
             <INPUT TYPE="radio" NAME="radios" VALUE="radio1" CHECKED>
             Muerto
            <BR>
            <INPUT TYPE="radio" NAME="radios" VALUE="radio2">
             Robo   
             <BR>      
            </li>                      
           <li> <label>Motivo Aparente</label>
            <select class="form-control">
            <option></option>           
          </select>  
             </li>
                       <ul>
                           <input type="submit" value="Guardar"/>
                    
               </div>
                </div>
                       
                       
                       <script type="text/javascript">
                           $('#txtFechaRegistro').datepicker({ 
     dateFormat: 'dd-mm-yy'
     }).datepicker("setDate", new Date());
                           </script>
    
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
         /*  out.println(request.getAttribute("dioActual"));*/
          /*   out.println(request.getAttribute("fechaBaja"));*/            
          
              
               
               }
          else{
           
              out.println("");
          }
          %>  
       <!--  <label id="message"></label> -->
       <!--
       <script type="text/javascript">
           function valor(){
               var valuer =  document.getElementById("txtBuscar");
               var bajatxt =  document.getElementById("bajatxt1");
               if(valuer != null)                 
                   $( "p" ).text( valuer.value );
               
           
           }
           </script>  -->
        <!-- Inicio Footer -->
      
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>

    </body>
</html>
>>>>>>> origin/master
