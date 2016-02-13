<%-- 
    Document   : nav
    Created on : 11-feb-2016, 12:12:25
    Author     : Murciegalo
--%>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Las Vaquitas</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index.jsp">Inicio</a></li>
      <li><a href="#">Histórico Animal</a></li>
        <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Manejos
        <span class="caret"></span></a>
        <ul class="dropdown-menu">  
          <li><a href="#">Parto</a></li> 
          <li><a href="#">Inseminación</a></li> 
          <li><a href="#">Palpación</a></li> 
          <li><a href="#">Manejo de Enfermedades</a></li> 
          <li><a href="#">Medición de Pelvis</a></li> 
          <li><a href="pages/manejos/bajaAnimales.jsp">Baja de animales</li> 
          <li><a href="#">Cargar DIIO</li> 
          <li><a href="#">Cambio DIIO</li> 
          <li><a href="#">Compra Animal</li> 
          <li><a href="#">Verificación Animal</li>  
        </ul>
        </li>
      <li><a href="#">Traslados</a></li> 
      <li><a href="#">Feedlot</a></li> 
       <li><a href="#">Ventas</a></li> 

       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Maestros
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li class="dropdown-submenu"><a tabindex="0">Maestro Animal</a>
            <ul class="dropdown-menu">    
               <li><a  href="pages/maestros/gestionRaza.jsp" tabindex="0">Gestión de Raza</a></li>
             
               <li><a tabindex="0">Gestión de Estado Animal</a></li>
               <li><a tabindex="0">Gestión de Categorias</a></li>
               <li><a tabindex="0">Gestión de Sexo</a></li>
               <li><a tabindex="0">Gestión de Grupos de Peso</a></li>
            </ul>
          </li> 
         <li class="dropdown-submenu"><a tabindex="0">Maestro Generales</a>
            <ul class="dropdown-menu">
               <li><a tabindex="0">Proveedores</a></li>
               <li><a tabindex="0">Clientes</a></li>
               <li><a tabindex="0">Tipo evento</a></li>        
            </ul>
        </li> 
            <li class="dropdown-submenu"><a tabindex="0">Maestros RUP</a>
            <ul class="dropdown-menu">
               <li><a tabindex="0">Tipo de RUP</a></li>
               <li><a tabindex="0">Establecimiento Agricola</a></li>
               <li><a tabindex="0">Corrales</a></li>        
            </ul>
        </li> 
          <li><a href="#">Maestros Insumos</a></li> 
          <li><a href="#">Maestros Transporte</a></li> 
          <li><a href="#">Maestros Usuarios</a></li> 
          <li><a href="#">Alimentación</a></li> 
        </ul>
      </li>
         <li><a href="#">Reportes</a></li> 
    </ul>
       <ul class="nav navbar-nav navbar-right">
       <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesión</a></li>
      </ul>
  </div>
</nav>