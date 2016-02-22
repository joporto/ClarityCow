<%@page import="java.util.ArrayList"%>
<%@page import="cl.sgg.business.BajaAnimales"%>
<%@page import="cl.sgg.controller.bajaAnimales"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--
    Document   : Prueba
    Created on : 14-feb-2016, 23:25:06
    Author     : Murciegalo
-->


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
<%@ page import="java.util.Date" %>   
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">


    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet"  type="text/css">
    <link href="/css/bootstrap-select.css" rel="stylesheet"  type="text/css">
    <link href="/css/datepicker.css" rel="stylesheet" type="text/css"/>
   <link href="/css/style.css" rel="stylesheet" type="text/css"/>
       <!-- jQuery Version 1.11.1 -->
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="/js/bootstrap-select.js" type="text/javascript"></script>
    <script src="/js/bootstrap-datepicker.js" type="text/javascript"></script>
    <script src="/js/bootstrapValidator.min.js" type="text/javascript"></script>
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
            
            margin-left: 10.4%!important;
                width: 174px;
        }
        
         .bajatxt2{

    margin-left: 94px !important;
    width: 174px!important;

        }
        
          .bajatxt3{
             margin-left: 126px!important;   
            width: 174px!important;
        }
        
        .ulBaja{
       list-style:none;
       }
       
       .txtMotivo{
           float:left!important;
           margin-right: 8%!important;
       }
            
       .txtTexto{         
    /* width: 100%; */
    height: 34px;
    padding: 6px 12px;
    font-size: 14px;
    line-height: 1.42857143;
    color: #555;
   /* background-color: #fff;*/
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
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
    <div class="panel-heading">
        <%@include file="/nav.jsp" %>
    </div>
    
    <script type="text/javascript">
    function validateForm() {
    var x = document.forms["bajaAnimales"]["txtBuscar"].value;
    if (x == null || x == "") {
        alert("Ingrese un DIO");
        return false;
    }
   if (Math.floor(x) == x) {
  return true;
} else {
     alert("Valor ingresado debe ser Númerico");
  return false;
}
}




   </script>
    
    
     <div class="container jumbotron">
      <form  id="bajaAnimales" name="bajaAnimales" action="bajaAnimales" onsubmit="return validateForm()" method="post">
                <p>Buscar DIIO</p>  
                <input type="text" placeholder="Solo Números" id="txtBuscar"   class="text-input txtTexto"  name="txtBuscar" title="Solo Numeros"  required >
                <input type="hidden" value="<%=request.getAttribute("dioActual")%>" name="escondido" id="escondido">
                <input type="hidden" value="Buscar" name="valorBoton" id="valorBoton">
                  <input type="hidden" value="Muerto" name="Motivo" id="Motivo">
                  <input type="submit" id="botonForm" name="botonForm" value="Buscar"/> </br></br>
                  <label>
                    <% if(request.getAttribute("message")!=("") && request.getAttribute("message")!=null){
%>                       
                    <%=request.getAttribute("message")%> 
                            
                    <% }%></label>
            </form>
     </div>
               
           <%
             /* BajaAnimales anim = new BajaAnimales();*/
             
             
              
              if(request.getAttribute("message")!=("") && request.getAttribute("message")!=null){
              if(request.getAttribute("message") == "Dio Encontrado" ){
                  
                 
                 /*  anim.BuscarDIIO(Integer.parseInt(request.getAttribute("dioActual").toString()));*/
                 /*  anim.setMotivoAparente("Robo");*/
               /* try {                 
                    if(anim.CargarCbMotivoAparente("Muerto").isStatus())                        
            {                 
                  System.out.print("uno");
                  list =  anim.getListaCb();

            }
                    if(anim.CargarCbMotivoAparente("Robo").isStatus())
                            {
                        System.out.print("dos");
                        list =  anim.getListaCb();  
                    }                    
                    
                } catch (Exception e) {                 
                    System.out.print(e.toString());
                }     */ 
              %>
              
            
            
                      <div class="contenido" style="display:none;">
                      <form  id="guardarBaja" name="guardarBaja" action="bajaAnimales" method="post">
                   <ul class="ulBaja">
                       <li><label>DIIO ANIMAL</label><input type="text"  class="txtTexto bajatxt1" id="txtDio" name="txtDio"  value="<%=request.getAttribute("dioActual")%>"   disabled > </li> 
                       <li><label>Fecha Registro</label> <input  id="fechaRegistro" name="fechaRegistro" class="txtTexto bajatxt2" type="text" class="form-control"  placeholder="yyyy-mm-dd"></li>                    
                        <li><label>Fecha Baja</label><input  required id="fechaBaja" name="fechaBaja" class="txtTexto bajatxt3" type="text" class="form-control"  placeholder="yyyy-mm-dd"> </li> 
                        <p></p>
                        <li><label>Cambio estado Animal</label>                       
                       <BR>
                       
                            <INPUT TYPE="radio" id="radio1" NAME="radios" onchange="motivoAparente('Muerto');" value="Muerto" >
                            Muerto
                           <BR>
                           <INPUT TYPE="radio" id="radio2"  NAME="radios" onchange="motivoAparente('Robado');"  value="Robado"   >
                            Robo 
                           
             <BR>      
            </li>                      
           <li> <label class="txtMotivo">Motivo Aparente</label>
            <select name="selMotivo" id="selMotivo" class="form-control">
                
                <% 
                     List<String> data = (List<String>)request.getAttribute("lista"); 
                      for (int i = 0; i < data.size(); i++) {
                   %>                    
            <option value="<%=data.get(i)%>"><%=data.get(i)%></option>
                   <%               
                }          
                    %>
          </select>  
             </li>
                       <ul>
                           <input type="submit" name="botonForm" value="Guardar"/>
                     </form>
               </div>
                  
                </div>
          
                  
      <script>           

          
          
          
          function motivoAparente(motivo)
          {
            
              
                
              if(motivo == "Muerto"){
                   document.getElementById('Motivo').value = "Muerto";
                 /*  document.getElementById('radio1').checked = true;*/
               document.forms["bajaAnimales"].submit();
              }
               if(motivo == "Robado"){
                   document.getElementById('Motivo').value = "Robado";
               document.forms["bajaAnimales"].submit();
          
              }
          }
          
          
 $.fn.datepicker.dates['es'] = {
        days: ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"],
        daysShort: ["Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb", "Dom"],
        daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa", "Do"],
        months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
        today: "Hoy"
    };
               $('#fechaRegistro').datepicker({                   
                     language: "es",
                    autoclose: true,
                    todayHighlight: true,
                     endDate: '+0d',
                    format:"yyyy-mm-dd"
                   
                
                });  
             $('#fechaBaja').datepicker({
                     language: "es",
                autoclose: true,
                todayHighlight: true,
                 endDate: '+0d',
                format:"yyyy-mm-dd"
                
                });   
                
                
      

          </script>
    
         
              <style>
                  .contenido{
                      
                      display: block!important;
                  }
              </style>
              <%
              }
           /* out.println(request.getAttribute("message")); */
         /*  out.println(request.getAttribute("dioActual"));*/
          /*   out.println(request.getAttribute("fechaBaja"));*/            
          
              
               
               }
          else{
           
           
          }
   
                           /* System.out.print(request.getAttribute("valorCheck"));*/
                            if(request.getAttribute("valorCheck")!= null){
                            if("true".equals(request.getAttribute("valorCheck").toString())){
                           /* System.out.print("Entro True");*/
                                %>
                                <script>
                                    document.getElementById('radio1').checked = true;
                                    </script>
                             <%   }else{ %><script>
                                    document.getElementById('radio2').checked = true;
                                    </script>
                                    <%}}

 if(request.getAttribute("resultadoGuardar")!= null )
{
if("true".equals(request.getAttribute("resultadoGuardar").toString()) ){
                       
               %>       
               <p>Registro Guardado</p>
                       <% 
                   }else{
                   
                       %>                      
                       <p>Registro  NO Guardado</p>       
                       <%  
                   }
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
    <!--
 <%@include file="/footer.jsp" %>-->
    </body>
</html>
