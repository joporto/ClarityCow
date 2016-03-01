<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Feedlot - Cargar Traslado</title>

        <meta charset="utf-8">
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,400,600,700">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300,700">
        <link rel="stylesheet" href="/css/font-awesome.min.css">
        <link rel="stylesheet" href="/js/libs/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
        <link rel="stylesheet" href="/css/bootstrap.min.css">

        <!-- Plugin CSS -->
        <link rel="stylesheet" href="/js/plugins/icheck/skins/minimal/blue.css">

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

                    <div class="content-header">

                        <h2 class="content-header-title">Cargar Feedlot</h2>


                        <ol class="breadcrumb">
                            <li>Home</li>
                            <li><a href="#">Feedlot</a></li>
                            <li class="active"><a href="#">Cargar Traslado</a></li>

                        </ol>

                    </div>
                    <%                             if (request.getParameter("mensaje") != null) {
                            String msj = request.getParameter("mensaje");
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");

                        }
                        if (request.getAttribute("mensaje") != null) {
                            String msj = request.getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                            request.setAttribute("mensaje", null);
                        }
                        if (request.getSession().getAttribute("mensaje") != null) {
                            String msj = request.getSession().getAttribute("mensaje").toString();
                            out.print("<div class='alert alert-warning'><strong>Mensaje: </strong>" + msj + "</div>");
                            request.getSession().setAttribute("mensaje", null);
                        }
                    %>

                    <table class="table table-striped table-bordered table-hover table-highlight" 
                           data-provide="datatable" 
                           data-display-rows="10"
                           data-info="true"
                           data-search="true"
                           data-length-change="true"
                           data-paginate="true">
                        <thead>
                            <tr>
                                <th data-sortable="true" class="text-center"><span class="small">Tipo traslado</span></th>
                                <th data-sortable="true" class="text-center" style="width: 150px"><span class="small">Fecha traslado</span></th>
                                <th data-sortable="true" class="text-center"><span class="small">FMA</span></th>
                                <th data-sortable="true" class="text-center" style="width: 150px"><span class="small">Guía despacho</span></th>
                                <th data-sortable="true" class="text-center"><span class="small">Fundo origen</span></th>
                                <th data-sortable="true" class="text-center"><span class="small">Fundo destino</span></th>
                                <th data-sortable="true" class="text-center"><span class="small">Estado</span></th>
                                <th class="text-center"><span class="small">Acción</span></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%         cl.sgg.business.Feedlot fd = new cl.sgg.business.Feedlot();

                                if (fd.CargarGrilla().isStatus()) {
                                    for (cl.sgg.business.GrillaFeedlot arg : fd.getListGrilla()) {

                            %>  

                            <tr>
                                <td><%= arg.getTipoTraslado()%></td>
                                <td><%= arg.getFechaTraslado()%></td>
                                <td><%= arg.getFMA()%></td>
                                <td><%= arg.getGuiaDespacho()%></td>
                                <td><%= arg.getFundoOrigen()%></td>
                                <td><%= arg.getFundoDestino()%></td>
                                <td><%= arg.getStatus()%></td>
                                <td><a href="trasladoDestete.jsp?idTransporte=<%= arg.getIdTransporte()%>" class="btn btn-info" role="button">Cargar</a></td>
                            </tr>

                            <%
                                    }
                                }
                            %>
                        </tbody>
                    </table>  


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
        <script src="/js/plugins/datatables/jquery.dataTables.min.js"></script>
        <script src="/js/plugins/datatables/DT_bootstrap.js"></script>
        <script src="/js/plugins/tableCheckable/jquery.tableCheckable.js"></script>
        <script src="/js/plugins/icheck/jquery.icheck.min.js"></script>

        <!-- App JS -->
        <script src="/js/target-admin.js"></script>
    </body>
</html>
