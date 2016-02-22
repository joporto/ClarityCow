<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Feedlot</title>

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


  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
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

    <div class="container">

      <div class="content">

        <div class="content-container">

          <div class="row">
    <table class="table table-hover table-responsive">
        <thead>
          <tr>
            <th>Tipo traslado</th>
            <th>Fecha traslado</th>
            <th>FMA</th>
            <th>Guía de despacho</th>
            <th>Fundo Origen</th>
            <th>Fundo Destino</th>
            <th>Estado</th>
            <th>Acción</th>
          </tr>
        </thead>
     <tbody>
     <% 
         cl.sgg.business.Feedlot fd = new cl.sgg.business.Feedlot();

         if(fd.CargarGrilla().isStatus())
         {
             for(cl.sgg.business.GrillaFeedlot arg: fd.getListGrilla())
             {

     %>  

       <tr>
           <td><%= arg.getTipoTraslado() %></td>
           <td><%= arg.getFechaTraslado() %></td>
           <td><%= arg.getFMA() %></td>
           <td><%= arg.getGuiaDespacho() %></td>
           <td><%= arg.getFundoOrigen() %></td>
           <td><%= arg.getFundoDestino() %></td>
           <td><%= arg.getStatus() %></td>
           <td><a href="trasladoDestete.jsp?idTransporte=<%= arg.getIdTransporte() %>" class="btn btn-info" role="button">Cargar</a></td>
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
