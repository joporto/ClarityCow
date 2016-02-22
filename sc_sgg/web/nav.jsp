

<%-- 
    Document   : nav
    Created on : 11-feb-2016, 12:12:25
    Author     : Murciegalo - Joporto
--%>
<!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Menú</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                 <a class="navbar-brand" href="/index.jsp">SC - SGG</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Histórico Animal</a>
                    </li>
                    <li class="dropdown">
                    <a href="#" 
                       class="dropdown-toggle" 
                       data-toggle="dropdown" 
                       role="button" 
                       aria-haspopup="true" 
                       aria-expanded="false">Manejos 
                     <span class="caret"></span>
                    </a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Parto</a></li>
                              <li><a href="#">Inseminación</a></li>
                              <li><a href="#">Palpación</a></li>
                              <li><a href="#">Manejo de enfermedades</a></li>
                              <li><a href="#">Medición de pelvis</a></li>
                              <li><a href="pages/manejos/bajaAnimales.jsp">Baja de animales</a></li>
                              <li><a href="#">Cargar DIIO</a></li>
                              <li><a href="#">Cambio DIIO</a></li>
                              <li><a href="#">Compra Animal</a></li>
                              <li><a href="#">Verificación Animal</a></li>
                            </ul>
                    </li>
                    <li class="dropdown">
                    <a href="#" 
                       class="dropdown-toggle" 
                       data-toggle="dropdown" 
                       role="button" 
                       aria-haspopup="true" 
                       aria-expanded="false">Traslados 
                     <span class="caret"></span>
                    </a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Traslado</a></li>
                              <li><a href="#">Cambios de corral</a></li>
                            </ul>
                    </li>
                    
                    <li>
                        <a href="#">Pesaje</a>
                    </li>
                    <li class="dropdown">
                    <a href="/pages/feedlot/feedlot.jsp" 
                       class="dropdown-toggle" 
                       data-toggle="dropdown" 
                       role="button" 
                       aria-haspopup="true" 
                       aria-expanded="false">Feedlot 
                     <span class="caret"></span>
                    </a>
                            <ul class="dropdown-menu">
                              <li><a href="/pages/feedlot/feedlot.jsp">Cargar Traslado</a></li>
                              <li><a href="/pages/feedlot/trasladoDestete.jsp">Traslado de destete</a></li>
                              <li><a href="#">Manejo de destete</a></li>
                              <li><a href="#">Separación Feedlot</a></li>
                              <li><a href="#">Pesaje Feedlot</a></li>
                            </ul>
                    </li>
                    <li>
                        <a href="#">Ventas</a>
                    </li>
                    <li class="dropdown">
                    <a href="#" 
                       class="dropdown-toggle" 
                       data-toggle="dropdown" 
                       role="button" 
                       aria-haspopup="true" 
                       aria-expanded="false">Maestros 
                     <span class="caret"></span>
                    </a>
                            <ul class="dropdown-menu">
                              <li><a href="#">Animal</a></li>
                              <li><a href="#">Generales</a></li>
                              <li><a href="#">RUP</a></li>
                              <li><a href="#">Insumos</a></li>
                              <li><a href="#">Transporte</a></li>
                              <li><a href="#">Usuarios</a></li>
                              <li><a href="#">Alimentación</a></li>
                            </ul>
                    </li>
                    <li>
                        <a href="#">Reportes</a>
                    </li>
                    
                         
                     </ul>
                
               
                   
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="/login.jsp?cmd=close">
                            <span class="glyphicon glyphicon-log-in"></span>Cerrar Sesión</a>
                    </li>
                   
                </ul>
             <ul class="nav navbar-nav navbar-right">
                  <li>
          
                           
                    </li>
             </ul>
        
             
           </div>
             <!-- /.container
            
              <%
                        if(request.getSession().getAttribute("userSession") != null)       
                         {
                            cl.sgg.utils.UserSession usr = 
                                    (cl.sgg.utils.UserSession) request.getSession().getAttribute("userSession");
             
            %>
            <span class="glyphicon glyphicon-user"> <%= usr.getUsername() %></span>
             <%         }
             %>
             -->
        </div>
    
 </nav>

