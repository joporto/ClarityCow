<!DOCTYPE html>
<html>
    <head>
    <title>Traslado Destete</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
   
   <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-select.css" rel="stylesheet">
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="/js/bootstrap-select.js"></script>
    
    <!-- Custom CSS -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
        $('.datepicker').datepicker();
    </script>
    
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
 
  <div class="panel panel-default">
    <!-- Inicio Head -->
    <div class="panel-heading">
    <%@include file="/nav.jsp" %>
    </div>
    
    <div class="panel-body">
    <!-- Inicio Contenido -->          

   
        
        <% 
        if(request.getParameter("idTransporte") != null)
        {
            out.print(request.getParameter("idTransporte"));
        }
        %>
   
        <%
        
        
        
        
        %>
        <div class="panel-group">
         <div class="container-fluid">
            <h1>Traslado destete</h1>
            <p>Utilice un filtro para buscar opciones</p>
            
            <div class="row">
              <div class="col-sm-4" style="background-color:lavender;">filtro 1</div>
              <div class="col-sm-4" style="background-color:lavenderblush;">filtro 2</div>
              <div class="col-sm-4" style="background-color:lavender;">filtro 3</div>
            </div>
          </div>
            <br>
            <br>
        <form class="form-horizontal" role="form">
            <div class="form-group">
              <label class="control-label col-sm-2">RUP Origen</label>
              <div class="col-sm-4">
                  <input type="text" name="txtCodRupOrigen" class="form-control" placeholder="Rup Origen">
              </div>
              <label class="control-label col-sm-2">Código RUP Origen</label>
              <div class="col-sm-4">
                <input type="text" name="txtCodRupOrigen" class="form-control" placeholder="Código Rup Origen">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-2">RUP Destino</label>
              <div class="col-sm-4">
                <input type="text" name="txtRupDestino" class="form-control" placeholder="Rup Destino">
              </div>
              <label class="control-label col-sm-2">Código RUP Destino</label>
              <div class="col-sm-4">
                <input type="text" name="txtCodRupDestino" class="form-control" placeholder="Código Rup Destino">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-2">Transportista</label>
              <div class="col-sm-4">
                <input type="text" name="txtNomTransportista" class="form-control" placeholder="Transportista">
              </div>
              <label class="control-label col-sm-2">Rut Transportista</label>
              <div class="col-sm-4">
                <input type="text" name="txtRutTransportista" class="form-control" placeholder="Rut Transportista">
              </div>
            </div>
            <div class="form-group">
              <label class="control-label col-sm-2" >Patente Vehículo</label>
              <div class="col-sm-4"> 
                <input type="text" name="txtPatenteVehiculo" class="form-control" placeholder="Patente Vehículo">
              </div>
              <label class="control-label col-sm-2" >Patente Acoplado</label>
              <div class="col-sm-4"> 
                <input type="text" name="txtPatenteAcoplado" class="form-control" placeholder="Patente Acoplado">
              </div>
            </div>
            
            <div class="form-group">
              <label class="control-label col-sm-2" >Comuna</label>
              <div class="col-sm-4"> 
                <input type="text" class="form-control" placeholder="Comuna">
              </div>
            </div>
            
            <div class="form-group">
              <label class="control-label col-sm-2" >Dirección</label>
              <div class="col-sm-10"> 
                <input type="text" class="form-control" placeholder="Dirección">
              </div>
            </div>
      
         <div class="form-group">
              <label class="control-label col-sm-2" >FMA</label>
              <div class="col-sm-4"> 
                <input type="text" class="form-control" placeholder="FMA">
              </div>
                <label class="control-label col-sm-2" >Guía de despacho</label>
              <div class="col-sm-4"> 
                <input type="text" class="form-control" placeholder="Guía de despacho">
              </div>
            </div>  
            
            
            <div class="form-group">
              <label class="control-label col-sm-2" >Fecha de traslado</label>
              <div class="col-sm-4"> 
                <input type="text" class="form-control" placeholder="fecha de traslado">
              </div>
              <label class="control-label col-sm-2" >Fecha de registro</label>
              <div class="col-sm-4"> 
                <input type="text" class="form-control" placeholder="fecha de traslado">
              </div>
            </div>
            
              <div>
          <ol class="breadcrumb">
            <li><a >Ternero</a></li>
            <li><a ><- Cambia a -> </a></li>
            <li class="active">Vaca</li>
          </ol>
        </div>
            
            <div class="form-group"> 
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Guardar</button>
              </div>
            </div>
        </form>
            
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
