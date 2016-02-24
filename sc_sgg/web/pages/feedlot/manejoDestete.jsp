<%-- 
    Document   : manejoDestete
    Created on : 20-feb-2016, 19:25:19
    Author     : Murciegalo
--%>

<%@page import="cl.sgg.business.GrillaInsumo"%>
<%@page import="cl.sgg.edm.Insumo"%>
<%@page import="cl.sgg.edm.InsumoTipo"%>
<%@page import="cl.sgg.utils.Respuesta"%>
<%@page import="cl.sgg.business.FeedlotManejoDestete"%>
<%@page import="cl.sgg.controller.ManejoDesteteController"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="cl.sgg.edm.Animal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date" %>   
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>



<head>
 <title>Manejo Destete</title>

  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,400,600,700">
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300,700">
  <link rel="stylesheet" href="/css/font-awesome.min.css">
  <link rel="stylesheet" href="/js/libs/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
  <link rel="stylesheet" href="/css/bootstrap.min.css">

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="/js/plugins/morris/morris.css">
  <link rel="stylesheet" href="/js/plugins/icheck/skins/minimal/blue.css">
  <link rel="stylesheet" href="/js/plugins/select2/select2.css">
  <link rel="stylesheet" href="/js/plugins/fullcalendar/fullcalendar.css">

  <!-- App CSS -->
  <link rel="stylesheet" href="/css/target-admin.css">
  <link rel="stylesheet" href="/css/custom.css">

   <script src="/js/libs/jquery-1.10.1.min.js"></script>
  <script src="/js/libs/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="/js/libs/bootstrap.min.js"></script>

  
    <!--[if lt IE 9]>
  <script src="./js/libs/excanvas.compiled.js"></script>
  <![endif]-->
  
  <!-- Plugin JS -->
  <script src="/js/plugins/icheck/jquery.icheck.js"></script>
  <script src="/js/plugins/select2/select2.js"></script>
  <script src="/js/libs/raphael-2.1.2.min.js"></script>
  <script src="/js/plugins/morris/morris.min.js"></script>
  <script src="/js/plugins/sparkline/jquery.sparkline.min.js"></script>
  <script src="/js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
  <script src="/js/plugins/fullcalendar/fullcalendar.min.js"></script>

  <!-- App JS -->
  <script src="/js/target-admin.js"></script>
  
  <!-- Plugin JS -->
  <script src="/js/bootstrap-datepicker.js" type="text/javascript"></script>
  <script src="/js/demos/dashboard.js"></script>
  <script src="/js/demos/calendar.js"></script>
  <script src="/js/demos/charts/morris/area.js"></script>
  <script src="/js/demos/charts/morris/donut.js"></script>
  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->

       
                    <style>
 
        
        .form_animales{
            padding-top: 5%;
        }
        
        .contenido{
            margin-top: 5%;
        }
        
        .bajatxt1{
            
            margin-left: 9.8%!important;
                width: 174px;
        }
        
         .bajatxt2{

    margin-left: 230px !important;
    width: 174px!important;

        }
        
          .bajatxt3{
                margin-left: 230px !important; 
            width: 174px!important;
        }
        
        .ulBaja{
       list-style:none;
       }
       
       .txtMotivo{
           float:left!important;
           margin-right: 8%!important;
       }
       .claseRadio{
               float: left;
               margin-right: 5px;
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
    
    .bajatxt4{
         margin-left: 26px!important;   
           width: 174px!important;
    }
    
    .tablaManejo{
        
        width: 25%;
        margin-left: 313px;
        background-color: #fff;
        
        
    }
    
    .bntEliminar{
        
            float: right;
    margin-right: 3%;
    }
    
    .btn-primary{
        width: 73px;
    height: 33px;
    }
    
    .ulAgregar{
        
            margin-top: 19px;
    }
        .liAgregar {
    float: left;
    margin-right: 25px;
        list-style: none;
    }
    
    .textLabel{
        float: left;
        margin-right: 25px;
        
    }
    
    .textoModal{
        font-size: 17px!important;
        
    }
    
    .txtAgregar{
        width: 130px;        
    }
    
    .tablaRegistro{        
        margin-top: 15px;
    }
    
    .divAgregar{
        background-color: #fff;
    }
    
    #regInsumos{
            min-height: 57px;
        
    }
    </style>          
    </head>
    <body>
<%
                if(request.getSession().getAttribute("userSession") == null)
                response.sendRedirect("/login.jsp");
                  
%> 
    
<!-- Menu Header -->
<%@include file="/header.jsp" %>
<!-- Menu Principal -->
<%@include file="/nav.jsp" %>

 <div class="container" >
                 <div class="panel panel-default">

            <div class="container jumbotron"> 
                <label>Registro de Manejo</label>                
                   <form action="manejoDestete"  method="POST"> 
                       <ul class="ulBaja">
                            <li><label class="textLabel">Fecha Registro</label> <input disabled  id="fechaRegistro" name="fechaRegistro" class="form-control txtTexto bajatxt2 " type="text"   placeholder="yyyy-mm-dd"></li>                    
                            <li><label class="textLabel">Fecha Baja</label><input   id="fechaBaja" name="fechaBaja" class="txtTexto bajatxt3 form-control" type="text"  placeholder="yyyy-mm-dd"> </li> 
                            <li> <INPUT checked class="claseRadio" TYPE="radio" id="radio1" NAME="radios"  value="" ><label class="textLabel">   Dio a Manejar</label><input type="text"  class="txtTexto bajatxt1" id="txtDio" name="txtDio"  >  <input type="submit" id="botonForm" class="btn btn-primary"  name="botonForm" value="Agregar"/></li>
                            <li> <INPUT  disabled class="claseRadio"  TYPE="radio" id="radio2" NAME="radios"  value="" ><label class="textLabel">   Grupo de DIIO a manejar</label><input disabled type="text"  class="txtTexto bajatxt4" id="txtDio" name="txtDio"  value=""    ><input disabled type="submit" id="botonForm" name="botonForm" value="Importar Excel"/></li>

                </ul>
            </form>  
             
            <table id="tablaManejo" style="background: #fff" class="table table-bordered tablaManejo">                
                   <tr>
        <th>DIO</th>
        <th></th>          
         </tr> 
                <%           
                  if(request.getAttribute("listaAnimales") != null){
                    List<Animal> data = (List<Animal>)request.getAttribute("listaAnimales"); 
                     for (int i = 0; i < data.size(); i++) {
                   %>
                   <tr> 
                    <td><%=data.get(i).getAnimalDiioActual()%></td>
                    <td><a href="<% data.remove(i).getAnimalDiioActual(); %>" class="btn btn-danger bntEliminar" role="button">Eliminar</a><%} }%></td>
                   </tr>
          </table>  
        </div>
                   
                   
        <div  id="regInsumos" >
       
         <label>Registro de Insumos</label> 
         <input type="submit" value="Agregar" id="bntAgregar" onclick="habilitar();" class="btn btn-primary">
         <input type="button" style="display: none;"  id="btnCerrar" value="Cerrar" onclick="desabilitar();" class="btn btn-danger">
            <%
          cl.sgg.business.FeedlotManejoDestete manejo = new cl.sgg.business.FeedlotManejoDestete();
          List<InsumoTipo> listInsumoTipo;
          List<Insumo> listInsumo = new  ArrayList<Insumo>();
          
        
          
         if(manejo.CargarTipoInsumo().isStatus()){ 
         listInsumoTipo = manejo.getListInsumoTipo(); %>
            <form action="manejoDestete" name="formAgregar" id="tipoInsumo" style="background: #fff" method="POST"> 
          <div id="divAgregar" class="divAgregar" style="display: none;">
              <ul class="ulAgregar">
                  <li class="liAgregar">  <p class="textoModal">Tipo de Insumo</p> <select onchange="motivoAparente('LlenarCombo');"  name="selMotivo" id="selMotivo" class="form-control">
                                                 <option  value="--Seleccione Tipo--">--Seleccione Tipo--</option>
                                               <% 
                                                          for (int i = 0; i < listInsumoTipo.size(); i++) {     %>                    
                                                    <option  id="valor" value="<%=listInsumoTipo.get(i).getInsumotipoId() %>"><%=listInsumoTipo.get(i).getInsumotipoDs() %></option>
                                               <%            }    }   %>
                      </select>  <input value="" id="Motivo" name="Motivo" type="hidden"></li>
                     
                                                                               <%
                  try{
          if(request.getAttribute("listaInsumos") != null){
          listInsumo = (List<Insumo>)request.getAttribute("listaInsumos");
          }
          %>  <li class="liAgregar"><p class="textoModal">Nombre</p><select id="insumo" class="form-control"> 
                 <option  value="--Seleccione Tipo--">--Seleccione Insumo--</option>
                  <%  for (int i = 0; i < listInsumo.size(); i++) {     %>                    
                                                    <option  id="valor" value="<%=listInsumo.get(i).getInsumoId() %>"><%=listInsumo.get(i).getInsumoNombre() %></option>
                                               <%            } }catch (Exception e) {throw e;  }   %></select></li>
         <li class="liAgregar"><input type="submit" id="idFormAgregar" name="botonForm" class="btn btn-info" value="Cargar"></li>
         
         <li class="liAgregar"><input id="valorSelect" value="" name="valorSelect" type="hidden"><input type="submit" id="agregarInsumo" name="botonForm" class="btn btn-info" value="Agregar Insumo"></li>
              </ul> 
          </div>
           </form>
         <%
              try{
                   if(request.getAttribute("listaRegistroInsumos") != null){                     
                    List<GrillaInsumo> grillaInsumo = (List<GrillaInsumo>)request.getAttribute("listaRegistroInsumos");                                                                            
                     %>                                                        
          <div class="tablaRegistro">            
         <table class="table table-bordered">
             <th>Tipo Insumo</th>
             <th>Cod SAP</th>
             <th>Nombre</th>
             <th>Unidad de medida</th>
             <th>Cantidad</th>
             <th></th>             
             
                   <%
                   for (int i = 0; i < grillaInsumo.size(); i++) {
                   %> 
                   <tr>
                   <td ><%=grillaInsumo.get(i).getTipoInsumo() %>   </td>
                   <td ><%=grillaInsumo.get(i).getInsumo().getInsumoCodigoSap()%>   </td>
                   <td ><%=grillaInsumo.get(i).getInsumo().getInsumoNombre() %>   </td>
                   <td ><%=grillaInsumo.get(i).getInsumo().getInsumoUnidadMedida() %>   </td>
                   <td ><%=grillaInsumo.get(i).getInsumo().getInsumoCantidad() %>   </td>
                   <td ></td>
                   </tr>
                    <% }
                            }
                            }catch(Exception e) {throw e;}
                        %>

         </table>   
          </div>
    </div> 
        </div>            
             </div>
         <script>
             
             document.getElementById("valorSelect").value = document.getElementById("TipoInsumo");
         
                            function motivoAparente(motivo)
                                                    {
                                                        if (motivo == "LlenarCombo") {
                                                            var valueSelect = document.getElementById('selMotivo').value;
                                                           /* alert(valueSelect);*/
                                                            document.getElementById('Motivo').value = 'combo';
                                                            document.getElementById('idFormAgregar').onclick = true;
                                                            /*  document.getElementById('radio1').checked = true;*/
                                                            /*
                                                           document.forms["formAgregar"].submit();*/
                                                        }
                                                    }
             
             
             
                           function habilitar(){
                           document.getElementById("divAgregar").style ="display:initial;background:#fff;";
                           document.getElementById("btnCerrar").style ="display: initial ;" ;  
                           document.getElementById("bntAgregar").style ="display: none ;" ;
                           document.getElementById("regInsumos").style="height:200px" ;
                                           }
                    
                          function desabilitar(){
                           document.getElementById("divAgregar").style ="display: none ;";
                           document.getElementById("btnCerrar").style ="display: none ;";
                           document.getElementById("bntAgregar").style ="display: initial ;" ;
                           document.getElementById("regInsumos").style="height:51px" ;
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
                                       
                                     var ano =  new Date().getUTCFullYear();
                                     var dia =  new Date().getDate();
                                     var mes = new Date().getMonth();
                                     var mesactual = mes+1;
                                     var fecha = ano+"-"+mesactual+"-"+dia;

                                     document.getElementById('fechaRegistro').value = fecha;
                                    $('#fechaBaja').datepicker({
                                            language: "es",
                                       autoclose: true,
                                       todayHighlight: true,
                                        endDate: '+0d',
                                       format:"yyyy-mm-dd"
                                       });   
            </script>      
             <%@include file="/footer.jsp" %>
        </body>
</html>
