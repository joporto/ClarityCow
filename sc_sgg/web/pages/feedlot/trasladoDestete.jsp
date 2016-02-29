<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="cl.sgg.business.FeedlotTraslado"%>
<%@page import="cl.sgg.business.FormFeedlotTraslado"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Traslado Destete</title>

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
            try {
                if (request.getSession().getAttribute("userSession") == null) {
                    response.sendRedirect("/login.jsp");
                }

            } catch (Exception e) {

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
                    <div class="content-header">
                        <h2 class="content-header-title">Feedlot Traslado destete</h2>
                        <ol class="breadcrumb">
                            <li>Home</li>
                            <li><a href="#">Feedlot</a></li>
                            <li class="active"><a href="#">Traslado destete</a></li>

                        </ol>
                    </div>

                    <%                        String rupOrigen = "";
                        String rupDestino = "";
                        String nomRupOrigen = "";
                        String nomRupDestino = "";
                        String comuna = "";
                        String direccion = "";
                        String nomTransportista = "";
                        String rutTransportista = "";
                        String patenteVehiculo = "";
                        String patenteAcoplado = "";
                        String fechaRegistro = "";
                        String fechaTraslado = "";
                        String FMA = "";
                        String guiaDespacho = "";

                        cl.sgg.business.FeedlotTraslado ft = new FeedlotTraslado();
                        if (request.getSession().getAttribute("ft") != null) {
                            ft = (cl.sgg.business.FeedlotTraslado) request.getSession().getAttribute("ft");
                        } else if (request.getParameter("idTransporte") != null) 
                        {
                            int idTrasporte = 0;
                            try 
                            {
                                idTrasporte = Integer.parseInt(request.getParameter("idTransporte"));
                                ft = new FeedlotTraslado(idTrasporte);
                                ft.CargarForm();

                                request.getSession().setAttribute("idTrasporte", idTrasporte);
                                request.getSession().setAttribute("ft", ft);

                            } catch (Exception e) {
                                request.getSession().setAttribute("mensaje", e.getMessage());
                            }
                        }
                        rupOrigen = "" + ft.getFft().getRupOrigen();
                        rupDestino = "" + ft.getFft().getRupDestino();
                        nomRupOrigen = ft.getFft().getNomRupOrigen();
                        nomRupDestino = ft.getFft().getNomRupDestino();
                        comuna = ft.getFft().getComuna();
                        direccion = ft.getFft().getDireccion();
                        //idTransportista = ""+ft.getFft().getIdTransportista();
                        nomTransportista = ft.getFft().getNomTransportista();
                        rutTransportista = ft.getFft().getRutTransportista();
                        //idVehiculo = ""+ft.getFft().getIdVehiculo();
                        patenteVehiculo = ft.getFft().getPatenteVehiculo();
                        patenteAcoplado = ft.getFft().getPatenteAcoplado();
                        fechaRegistro = "" + ft.getFft().getFechaRegistro();
                        fechaTraslado = "" + ft.getFft().getFechaTraslado();
                        FMA = ft.getFft().getFMA();
                        guiaDespacho = ft.getFft().getGuiaDespacho();
                    %>



                    <%                             if (request.getParameter("mensaje") != null) {
                            String msj = request.getParameter("mensaje");
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                        if (request.getAttribute("mensaje") != null) {
                            String msj = request.getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                        if (request.getSession().getAttribute("mensaje") != null) {
                            String msj = request.getSession().getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                        }
                    %>

                    <a href="#filtros" class="btn btn-info" data-toggle="collapse">Mostrar/Ocultar filtros</a>
                    <div id="filtros" class="collapse">

                        <p>
                            Utilice cada filtro de forma individual.
                        </p>
                        <div class="row">

                            <div class="col-md-6">

                                <div class="portlet">

                                    <div class="portlet-header">

                                        <h3>
                                            <i class="fa fa-filter"></i>
                                            Buscar Transportista
                                        </h3>

                                    </div> <!-- /.portlet-header -->

                                    <div class="portlet-content">

                                        <form role="form" class="form" action="trasladoDestete" method="post">

                                            <table class="table table-condensed">
                                                <tr>
                                                    <td><a class="text-info">Rut</a> </td>
                                                    <td><input type="text" name="busqRutTrasportista" class="form-control success" placeholder="rut transportista" value="<%= rutTransportista%>"></td>
                                                </tr>
                                                <tr>
                                                    <td><a class="text-info">Nombre</a></td>
                                                    <td><input type="text" name="busqNombreTransportista" class="form-control" placeholder="nombre transportista" value="<%= nomTransportista%>"></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>
                                                        <button type="submit" name="btnFiltro" class="btn glyphicon glyphicon-search" value="transportista"> Buscar</button>
                                                    </td>
                                                </tr>
                                            </table> 
                                        </form>
                                    </div>
                                </div> 

                                <div class="portlet">
                                    <div class="portlet-header">
                                        <h3>
                                            <i class="fa fa-filter"></i>
                                            Buscar Rup Origen
                                        </h3>
                                    </div> 
                                    <div class="portlet-content">
                                        <form role="form" class="form" action="trasladoDestete" method="post">
                                            <table class="table table-condensed">
                                                <tr>
                                                    <td><a class="text-info">Código</a> </td>
                                                    <td><input type="text" name="busqCodRupOrigen" class="form-control success" placeholder="código rup origen" value="<%= rupOrigen%>"></td>
                                                </tr>
                                                <tr>
                                                    <td><a class="text-info">Nombre</a></td>
                                                    <td><input type="text" name="busqNomRupOrigen" class="form-control" placeholder="nombre rup origen" value="<%= nomRupOrigen%>"></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td>
                                                        <button type="submit" name="btnFiltro" class="btn glyphicon glyphicon-search" value="rupOrigen"> Buscar</button>

                                                    </td>
                                                </tr>
                                            </table> 
                                        </form>
                                    </div>
                                </div> 
                            </div> 
                            <div class="col-md-6">
                                <div class="portlet">
                                    <div class="portlet-header">
                                        <h3>
                                            <i class="fa fa-filter"></i>
                                            Buscar Vehículo
                                        </h3>
                                    </div> <!-- /.portlet-header -->
                                    <div class="portlet-content">
                                        <form role="form" class="form" action="trasladoDestete" method="post">
                                            <table class="table table-condensed">
                                                <tr>
                                                    <td><a class="text-info">Patente</a> </td>
                                                    <td><input type="text" name="txtBusquedaPatente" class="form-control success" placeholder="patente Vehículo" value="<%= patenteVehiculo%>"></td>
                                                </tr>
                                                <br>
                                                <br>
                                                <tr>
                                                    <td></td>
                                                    <td><button type="submit" name="btnFiltro" class="btn glyphicon glyphicon-search" value="vehiculo"> Buscar</button></td>
                                                </tr>
                                            </table> 
                                        </form>
                                    </div> <!-- /.portlet-content -->
                                </div> <!-- /.portlet -->
                                <div class="portlet">

                                    <div class="portlet-header">

                                        <h3>
                                            <i class="fa fa-filter"></i>
                                            Buscar Rup Destino
                                        </h3>

                                    </div> <!-- /.portlet-header -->

                                    <div class="portlet-content">

                                        <form role="form" class="form" action="trasladoDestete" method="post">

                                            <table class="table table-condensed">
                                                <tr>
                                                    <td><a class="text-info">Código</a> </td>
                                                    <td><input type="text" name=txtBusquedaRupDestino class="form-control success" placeholder="código rup destino" value="<%= rupDestino%>"></td>
                                                </tr>
                                                <tr>
                                                    <td><a class="text-info">Nombre</a></td>
                                                    <td><input type="text" name="txtBusquedaNomRupDestino" class="form-control" placeholder="nombre rup destino" value="<%= nomRupDestino%>"></td>
                                                </tr>
                                                <tr>
                                                    <td></td>
                                                    <td><button type="submit" name="btnFiltro" class="btn glyphicon glyphicon-search" value="rupDestino"> Buscar</button></td>
                                                </tr>
                                            </table> 
                                        </form>
                                    </div> <!-- /.portlet-content -->
                                </div> <!-- /.portlet -->

                            </div> <!-- /.col -->
                        </div>
                    </div>
                    <br>
                    <br>
                    <form class="form-horizontal" role="form" action="trasladoDestete" method="post">



                        <input style="display:none;" type="text" name="idTransporte" class="form-control" placeholder="Rup Origen" value="<%= request.getSession().getAttribute("idTrasporte")%>">


                        <div class="form-group">
                            <label class="control-label col-sm-2">RUP Origen</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtCodRupOrigen" class="form-control" placeholder="Rup Origen" value="<%= nomRupOrigen%>">
                            </div>
                            <label class="control-label col-sm-2">Código RUP Origen</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtCodRupOrigen" class="form-control" placeholder="Código Rup Origen" value="<%= rupOrigen%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">RUP Destino</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtRupDestino" class="form-control" placeholder="Rup Destino" value="<%= nomRupDestino%>">
                            </div>
                            <label class="control-label col-sm-2">Código RUP Destino</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtCodRupDestino" class="form-control" placeholder="Código Rup Destino" value="<%= rupDestino%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2">Transportista</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtNomTransportista" class="form-control" placeholder="Transportista" value="<%= nomTransportista%>">
                            </div>
                            <label class="control-label col-sm-2">Rut Transportista</label>
                            <div class="col-sm-4">
                                <input disabled type="text" name="txtRutTransportista" class="form-control" placeholder="Rut Transportista" value="<%= rutTransportista%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Patente Vehículo</label>
                            <div class="col-sm-4"> 
                                <input disabled type="text" name="txtPatenteVehiculo" class="form-control" placeholder="Patente Vehículo" value="<%= patenteVehiculo%>">
                            </div>
                            <label class="control-label col-sm-2" >Patente Acoplado</label>
                            <div class="col-sm-4"> 
                                <input type="text" name="txtPatenteAcoplado" class="form-control" placeholder="Patente Acoplado" value="<%= patenteAcoplado%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Comuna</label>
                            <div class="col-sm-4"> 
                                <input disabled type="text" class="form-control" name="txtComuna" placeholder="Comuna" value="<%= comuna%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Dirección</label>
                            <div class="col-sm-10"> 
                                <input disabled type="text" class="form-control" placeholder="Dirección" value="<%= direccion%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >FMA</label>
                            <div class="col-sm-4"> 
                                <input type="text" class="form-control" placeholder="FMA" value="<%= FMA%>">
                            </div>
                            <label class="control-label col-sm-2" >Guía de despacho</label>
                            <div class="col-sm-4"> 
                                <input type="text" class="form-control" placeholder="Guía de despacho" value="<%= guiaDespacho%>">
                            </div>
                        </div>  

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Fecha de traslado</label>
                            <div class="col-sm-4"> 
                                <input type="text" class="form-control" placeholder="fecha de traslado" value="<%= fechaTraslado%>">
                            </div>
                            <label class="control-label col-sm-2" >Fecha de registro</label>
                            <div class="col-sm-4"> 
                                <input disabled type="text" class="form-control" placeholder="fecha de traslado" value="<%= fechaRegistro%>">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-sm-2" >Tipo de acción</label>
                            <div class="col-sm-4"> 
                                <div class="radio">
                                    <label class="text-primary small">
                                        <input type="radio"  checked="true" name="optradio" value="Confirmar">Confirmado</label>
                                </div>
                                <div class="radio">
                                    <label class="text-primary small">
                                        <input type="radio" name="optradio" value="Trasladar">Por Confirmar</label>
                                </div>
                            </div>

                            <%
                                String txtDiio = "";
                                String txtPeso = "";

                                if (request.getAttribute("txtDiio") != null) {
                                    txtDiio = request.getAttribute("txtDiio").toString();
                                }

                                if (request.getAttribute("txtPeso") != null) {
                                    txtPeso = request.getAttribute("txtPeso").toString();
                                }

                            %>
                            <label class="control-label col-sm-2" >Cargar DIIO</label>
                            <div class="col-sm-4"> 
                                <input type="text" class="form-control" placeholder="Diio" name="txtDiio" value="<%= txtDiio%>">
                            </div>
                        </div>  

                        <div class="form-group">
                            <label class="control-label col-sm-2">Peso</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" placeholder="peso" name="txtPeso" value="<%= txtPeso%>">
                            </div>
                            <div class="col-sm-4"> 
                                <button type="submit" name="btnGuardar" class="btn btn-default" value="guardarDiio">Agregar/Actualizar</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-sm-2">Archivo Excel</label>
                            <div class="col-sm-4"> 
                                <input id="file-1" type="file" name="fileExcel">
                            </div>
                            <div class="col-sm-4"> 
                                <button type="submit" name="btnGuardar" class="btn btn-default" value="guardarExcel">Cargar Excel</button>
                            </div>
                        </div>

                        <div class="form-group">
                            <table class="table table-hover table-responsive">
                                <thead>
                                    <tr>
                                        <th>DIIO</th>
                                        <th>Peso (KG)</th>
                                        <th>Estado</th>
                                        <th>Editar</th>
                                        <th>Borrar</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%

                                        if (ft.getListFeedlotTraslado().size() == 0) {
                                            ft.CargarGrilla();
                                        }

                                        if (ft.getListFeedlotTraslado().size() > 0) {
                                            for (cl.sgg.business.GrillaFeedlotTraslado arg : ft.getListFeedlotTraslado()) {

                                    %>  

                                    <tr>
                                        <td><%= arg.getAnimal().getAnimalDiioActual()%></td>
                                        <td><%= arg.getPeso()%></td>
                                        <td><%= arg.getStatus()%></td>
                                        <td><a href="trasladoDestete?editarDiio=<%= arg.getAnimal().getAnimalDiioActual()%>">Editar</a></td>
                                        <td><a href="trasladoDestete?borrarDiio=<%= arg.getAnimal().getAnimalDiioActual()%>">Borrar</a></td>
                                    </tr>
                                    <%
                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                        <br>
                        <div class="form-group"> 
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" name="btnGuardar" class="btn btn-default" value="guardarFormulario">Guardar Formulario</button>
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