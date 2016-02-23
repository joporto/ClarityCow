<!-- V1.0.0 -->
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Feedlot Separación</title>
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
                            function validateForm()
                            {
                                var x = document.forms["buscador"]["txtBuscarCodRup"].value;
                                var y = document.forms["buscador"]["txtBuscarNomRup"].value;
                                if ((x == null || x == "") && (y == null || y == ""))
                                {
                                    alert("Ingrese valor a buscar");
                                    return false;
                                }
                                if (Math.floor(y) == y)
                                {
                                    return true;
                                } else
                                {
                                    alert("Valor ingresado debe ser Númerico");
                                    return false;
                                }
                            }
                        </script>

                        <form id="buscador" name="buscador" action="buscador" onsubmit="return validateForm()" method="post">
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Buscar Establecimiento (RUP)</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="Cod RUP">Cod RUP:</label>
                                        <div class="col-sm-10">
                                            <input type="text" maxlength="15" class="form-control" id="txtBuscarCodRup" class="text-input txtTexto"  name="txtBuscarCodRup" title="Solo Texto" placeholder="Ingrese Cod RUP">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                                        <div class="col-sm-10">          
                                            <input type="text" maxlength="15" class="form-control" placeholder="Ingrese Nombre RUP" id="txtBuscarNomRup" name="txtBuscarNomRup" title="Solo Numeros">
                                        </div>
                                    </div>
                                    <input type="submit" id="botonForm" class="btn btn-default" name="botonForm" value="Buscar"/> </br></br>
                                </div>
                            </div>
                        </form>
                        



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
