<!DOCTYPE html>
<html>
    <head>
    <title>FeedLot</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   
    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-select.css" rel="stylesheet">
    
    <!-- Custom CSS -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <style>
   *{
    padding: 0;
    margin: 0;
}

html {
  position: relative;
  min-height: 100%;
}
body {
  /* Margin bottom by footer height */
  margin-bottom: 60px;
}
.footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  /* Set the fixed height of the footer here */
  height: 60px;
     
}
  body {
    padding-top: 70px;
  }
  @media (max-width: 980px) {
    body {
      padding-top: 0;
    }
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

<div class="container">
  <h2>Feedlot</h2>
  <div class="panel panel-default">
    <!-- Inicio Head -->
    <div class="panel-heading">
    <%@include file="/nav.jsp" %>
    </div>
    
    <div class="panel-body">
    <!-- Inicio Contenido -->          
    <p class="lead">Traslados Feedlot por confirmar</p>
        
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
          <td><a href="#" class="btn btn-info" role="button">Cargar</a></td>
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
 
<!-- jQuery Version 1.11.1 -->
<script src="/js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
  <script src="/js/bootstrap.min.js"></script>   
</body>
</html>
