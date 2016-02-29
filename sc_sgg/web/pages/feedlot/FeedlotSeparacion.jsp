<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="cl.sgg.business.FeedlotTraslado"%>
<%@page import="cl.sgg.business.FormFeedlotTraslado"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Separación Feedlot</title>

        <meta charset="utf-8">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
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


        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <%

            try
            {
                if (request.getSession().getAttribute("userSession") == null)
                {
                    response.sendRedirect("/login.jsp");
                }
            } catch (Exception e)
            {
                request.getSession().setAttribute("mensaje", e.getMessage());
            }

        %> 
        <!-- Menu Header -->
        <%@include file="/header.jsp" %>
        <!-- Menu Principal -->
        <%@include file="/nav.jsp" %>

        <div class="container">
            <div class="content">
                <div class="content-container">
                    <!-- Titulo -->
                    <div class="content-header">
                        <h2 class="content-header-title">Separación Feedlot</h2>
                        <ol class="breadcrumb">
                            <li class="active"><a href="/index.jsp">Inicio</a></li>
                            <li class="active">Feedlot</li>
                            <li class="active">Separación Feedlot</li>
                        </ol>
                    </div>
                    <!-- Mensajes - Notificaciones -->
                    <div class="row">
                        <div class="col-sm-6 col-md-4 col-md-offset-4">
                            <%                                if (request.getAttribute("mensaje") != ("") && request.getAttribute("mensaje") != null)
                                {
                                    if (request.getAttribute("StatusRespuesta").toString() == "true")
                                    {
                                        out.print("<div class='alert alert-success'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Operación exitosa!</strong> " + request.getAttribute("MensajeRespuesta").toString() + " </strong></div>");
                                    } else
                                    {
                                        out.print("<div class='alert alert-warning'><a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a><strong>Atención!</strong> " + request.getAttribute("MensajeRespuesta").toString() + " </strong></div>");
                                    }
                                }
                            %>
                        </div>
                    </div>
                    <!-- Formulario RUP -->
                    <div class="contenido">
                        <form  id="bajaAnimales" class="form-horizontal" name="FeedlotSeparacion" action="FeedlotSeparacion" onsubmit="return validateForm()" method="post">
                            <div class="form-group">
                                <label class="control-label col-sm-2">Código RUP:</label>
                                <div class="col-sm-4"> 
                                    <input type="text" maxlength="15" placeholder="Ingresar DIIO" id="txtBuscar"   class="form-control "  name="txtBuscar" title="Ingresar DIIO"  required >
                                    
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2">Código RUP:</label>
                                <div class="col-sm-4"> 
                                    <input type="text" maxlength="15" placeholder="Ingresar DIIO" id="txtBuscar"   class="form-control "  name="txtBuscar" title="Ingresar DIIO"  required >
                                    <input type="submit" id="botonForm" class="btn btn-primary pull-rightl" name="botonForm" value="Buscar"/>
                                </div>
                            </div>
                        </form>
                    </div>
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