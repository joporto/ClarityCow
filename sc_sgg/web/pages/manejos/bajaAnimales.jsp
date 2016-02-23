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


        <link href="/css/datepicker.css" rel="stylesheet" type="text/css"/>
        <script src="/js/bootstrap-datepicker.js" type="text/javascript"></script>
        <script src="/js/bootstrapValidator.min.js" type="text/javascript"></script>
         
        <style>


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

            .form-control{
                display: initial!important;
                width: 174px!important;
            }
        </style>
    </head>
    <body>
        <%
            if (request.getSession().getAttribute("userSession") == null) {
                response.sendRedirect("/login.jsp");
            }

        %> 

        <!-- Menu Header -->
        <%@include file="/header.jsp" %>
        <!-- Menu Principal -->
        <%@include file="/nav.jsp" %>

        <div class="container">

            <div class="content">

                <div class="content-container">

                    <div class="row jumbotron">






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



                        <form  id="bajaAnimales" class="form-horizontal" name="bajaAnimales" action="bajaAnimales" onsubmit="return validateForm()" method="post">
                            <p>Baja de animales, ingrese un DIIO valido y luego ingrese la causa de baja</p>  

                            <div class="form-group">
                                <label class="control-label col-sm-2">Ingresar DIIO</label>
                                <div class="col-sm-2">
                                    <input type="text" maxlength="15" placeholder="Solo Números" id="txtBuscar"   class="text-input txtTexto form-control"  name="txtBuscar" title="Solo Numeros"  required >
                                    <input type="hidden" value="<%=request.getAttribute("dioActual")%>" name="escondido" id="escondido">
                                    <input type="hidden" value="Buscar" name="valorBoton" id="valorBoton">
                                    <input type="hidden" value="Muerto" name="Motivo" id="Motivo">

                                </div>
                                <label class="control-label col-sm-2">
                                    <% if (request.getAttribute("message") != ("") && request.getAttribute("message") != null) {
                                    %>                       
                                    <%=request.getAttribute("message")%> 

                                    <% }%></label>
                                <div class="col-sm-2">
                                    <input type="submit" id="botonForm" class="btn btn-default form-control" name="botonForm" value="Buscar"/> </br></br>

                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="row">

                        <%
                            /* BajaAnimales anim = new BajaAnimales();*/

                            if (request.getAttribute("message") != ("") && request.getAttribute("message") != null) {
                                if (request.getAttribute("message") == "DIIO Encontrado") {


                        %>



                        <div class="contenido" style="display:none;">
                            <form  id="guardarBaja" class="form form-horizontal" name="guardarBaja" action="bajaAnimales" method="post">
                                <div class="form-group">
                                    <label class="control-label col-sm-2">DIIO ANIMAL</label>

                                    <div class="col-sm-4">
                                        <input type="text"  class="form-control" id="txtDio" name="txtDio"  value="<%=request.getAttribute("dioActual")%>"   disabled > 
                                    </div>
                                </div>
                                <div class="form-group">

                                    <label class="control-label col-sm-2">Fecha Registro</label>
                                    <div class="col-sm-4">
                                        <input disabled id="fechaRegistro" name="fechaRegistro" class="form-control" type="text" placeholder="yyyy-mm-dd">

                                    </div>
                                </div> 
                                <div class="form-group">

                                    <label class="control-label col-sm-2">Fecha Baja</label>
                                    <div class="col-sm-4">

                                        <input  required id="fechaBaja" name="fechaBaja" class="form-control" type="text" placeholder="yyyy-mm-dd">
                                    </div>
                                </div> 
                                <div class="form-group">

                                    <label class="control-label col-sm-2">Cambio estado Animal</label>
                                    <div class="col-sm-1">
                                        

                                        <INPUT TYPE="radio" id="radio1" NAME="radios" class="form-control" onchange="motivoAparente('Muerto');" value="Muerto" >
                                        Muerto
                                        
                                        <INPUT TYPE="radio" id="radio2"  NAME="radios" class="form-control" onchange="motivoAparente('Robado');"  value="Robado"   >
                                        Robo 

                                       

                                    </div>
                                </div> 
                                <div class="form-group">

                                    <label class="control-label col-sm-2">Motivo Aparente</label>
                                    <div class="col-sm-4">

                                        <select name="selMotivo" id="selMotivo" class="form-control">

                                            <%
                                                List<String> data = (List<String>) request.getAttribute("lista");
                                                for (int i = 0; i < data.size(); i++) {
                                            %>                    
                                            <option value="<%=data.get(i)%>"><%=data.get(i)%></option>
                                            <%
                                                }
                                            %>
                                        </select>  
                                    </div>
                                </div> 
                                <div class="form-group">

                                    <label class="control-label col-sm-2"></label>
                                    <div class="col-sm-4">

                                        <input type="submit" name="botonForm" class="btn btn-default" value="Guardar"/>
                                    </div>
                                </div> 












                                
                            </form>
                        </div>

                    </div>


                    <script>




                        function motivoAparente(motivo)
                        {



                            if (motivo == "Muerto") {
                                document.getElementById('Motivo').value = "Muerto";
                                /*  document.getElementById('radio1').checked = true;*/
                                document.forms["bajaAnimales"].submit();
                            }
                            if (motivo == "Robado") {
                                document.getElementById('Motivo').value = "Robado";
                                document.forms["bajaAnimales"].submit();

                            }
                        }

                        var ano = new Date().getUTCFullYear();
                        var dia = new Date().getDate();
                        var mes = new Date().getMonth();
                        var mesactual = mes + 1;
                        var fecha = ano + "-" + mesactual + "-" + dia;

                        document.getElementById('fechaRegistro').value = fecha;
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
                            format: "yyyy-mm-dd"


                        });
                        $('#fechaBaja').datepicker({
                            language: "es",
                            autoclose: true,
                            todayHighlight: true,
                            endDate: '+0d',
                            format: "yyyy-mm-dd"

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

                        } else {

                        }

                        /* System.out.print(request.getAttribute("valorCheck"));*/
                        if (request.getAttribute("valorCheck") != null) {
                            if ("true".equals(request.getAttribute("valorCheck").toString())) {
                                /* System.out.print("Entro True");*/
                    %>
                    <script>
                        document.getElementById('radio1').checked = true;
                    </script>
                    <%   } else { %><script>
                        document.getElementById('radio2').checked = true;
                    </script>
                    <%}
                        }

                        if (request.getAttribute("resultadoGuardar") != null) {
                            if ("true".equals(request.getAttribute("resultadoGuardar").toString())) {

                    %>       
                    <p>Registro Guardado</p>
                    <%                       } else {

                    %>                      
                    <p>Registro  NO Guardado</p>       
                    <%                               }
                        }
                    %>  



                </div>
            </div>
        </div>





        <%@include file="/footer.jsp" %>

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
        <script src="/js/demos/dashboard.js"></script>
        <script src="/js/demos/calendar.js"></script>
        <script src="/js/demos/charts/morris/area.js"></script>
        <script src="/js/demos/charts/morris/donut.js"></script>
    </body>
</html>
