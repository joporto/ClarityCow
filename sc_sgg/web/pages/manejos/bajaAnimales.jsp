<%-- 
    Document   : bajaAnimales
    Created on : 12-feb-2016, 23:10:45
    Author     : Murciegalo
--%>

<%@page import="cl.sgg.edm.Diio"%>
<%@page import="cl.sgg.utils.Respuesta"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="cl.sgg.business.*"%>
<%@page import="cl.sgg.business.BajaAnimales.*"%>
<!DOCTYPE html>
<html>
    <head>
<link rel="stylesheet" href="/css/bootstrap.min.css" >
<link rel="stylesheet" href="/css/bootstrap-submenu.min.css">
<link rel="stylesheet" href="/css/style.css" >


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"  type="text/javascript"></script>
<script src="../../js/bootstrap.min.js"  type="text/javascript"></script>
<script src="../../js/bootstrap-submenu.js" type="text/javascript"></script>
<title>Inicio</title>
    </head>
<body>

<!-- Menu Header -->
<%@include file="../../header.jsp" %>
<!-- Menu Principal -->
     <script type="text/javascript">
function validar(e) {
    tecla = (document.all) ? e.keyCode : e.which;
    if (tecla==8) return true;
    patron =/\d/;
    te = String.fromCharCode(tecla);
    return patron.test(te);} 
</script>
<%
    BajaAnimales anim = new BajaAnimales();
    Respuesta resp = new Respuesta();
   // resp =  anim.BuscarDIIO(1);
   // System.out.println(resp.isStatus());
  //  System.out.println(resp.getMensaje());
    //anim.CargarCbMotivoAparente("Muerto");
   
   // System.out.println(resp.getMensaje());
    //System.out.println(resp.getMensaje());
    
    
   /*
    <script>
        function valor(){
      document.getElementById("userName").innerHTML = "New text!";*/
       
    if(request.getParameter("uno") != null){
    resp =  anim.BuscarDIIO(Integer.parseInt(request.getParameter("uno")));
    //request.setAttribute("userName", "userName" );
    System.out.println(resp.getMensaje());
    }
    /*
    <style>
        .contenedor_dos{
            display: block;
        }
    </style>-->*/        
    %>
        <!--}
        
</script>-->
 
<div class="container">
  <h2>Las Vaquitas</h2>
  <div class="panel panel-default">
      <!-- Inicio Head -->
    <div class="panel-heading"><%@include file="../../nav.jsp" %></div>
    
    <!-- Inicio Contenido -->
    <div class="panel-body">
        
        
        <div class="contenedor">
            <form class="formulario_uno">
                <label >DIIO</label>
                <input type="text" id="uno" name="uno" class="form-control" id="usr" title="Solo Números"  >
                <button type="button" id="boton_1" class="btn btn-default" onclick="valor();">Default</button>
            </form>
        </div>
        
        <label id="userName" name="username"></label>
        
        
        
           <div class="contenedor_dos" style="display:none">
               <ul>
                   <li><label>DIIO ANIMAL*</label>  <input type="text" class="form-control" id="usr"></li>
                   <li><label>Fecha Baja*</label> <input type="text" class="form-control" id="fechaBaja">  <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></li>
                    
                       <div class='input-group date' id='datetimepicker5'>
                    <input type='text' class="form-control" />
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
                    
                    
                   <li><label>Fecha Registro</label> <input type="text" class="form-control" id="usr">  <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span></li>
                   <li><label>Cambio estado Animal</label>   </li>
                   <div class="radio">
                    <label><input type="radio" name="optradio" value="Robo">Robo</label>
                  </div>
                  <div class="radio">
                    <label><input type="radio" name="optradio"value="Muerte">Muerte</label>
                  </div>
                   <li><label>Motivo aparente</label><div class="form-group">
                  <label for="sel1">Select list:</label>
  
  

  <select class="form-control " id="sel1">
    <option></option>
    
  </select>
</div></li>
                </ul>
            </div>
        
        
    </div>
    
    <!-- Inicio Footer -->
    <div class="panel-footer">
        <%@include file="../../footer.jsp" %></div>
  </div>
</div>
           <script type="text/javascript">
            $(function () {
                $('#fechaBaja').datetimepicker({
                    defaultDate: "11/1/2013",
                    disabledDates: [
                        moment("12/25/2013"),
                        new Date(2013, 11 - 1, 21),
                        "11/22/2013 00:53"
                    ]
                });
            });
        </script>
    </body>
</html>
