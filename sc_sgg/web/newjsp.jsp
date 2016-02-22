<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
  <title>SGG Smart Clarity</title>

  <meta charset="utf-8">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,400,600,700">
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Oswald:400,300,700">
  <link rel="stylesheet" href="./css/font-awesome.min.css">
  <link rel="stylesheet" href="./js/libs/css/ui-lightness/jquery-ui-1.9.2.custom.min.css">
  <link rel="stylesheet" href="./css/bootstrap.min.css">

  <!-- Plugin CSS -->
  <link rel="stylesheet" href="./js/plugins/morris/morris.css">
  <link rel="stylesheet" href="./js/plugins/icheck/skins/minimal/blue.css">
  <link rel="stylesheet" href="./js/plugins/select2/select2.css">
  <link rel="stylesheet" href="./js/plugins/fullcalendar/fullcalendar.css">

  <!-- App CSS -->
  <link rel="stylesheet" href="./css/target-admin.css">
  <link rel="stylesheet" href="./css/custom.css">


  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>

<body>

<div class="navbar">

<div class="container">

    <div class="navbar-header">

    </div> <!-- /.navbar-header -->
    
     
    <div class="navbar-collapse collapse">
    <div class="navbar-header">
                <button type="button" 
                        class="navbar-toggle" 
                        data-toggle="collapse" 
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Menú</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand text-info" href="/index.jsp">SmartClarity - SGG</a> 
   </div>
        
      <ul class="nav navbar-nav noticebar navbar-left">

     <li class="dropdown">
          <a href="./page-notifications.html" class="dropdown-toggle" data-toggle="dropdown">
            <i class="fa fa-envelope"></i>
            <span class="navbar-visible-collapsed">&nbsp;Messages&nbsp;</span>
          </a>

          <ul class="dropdown-menu noticebar-menu" role="menu">                
            <li class="nav-header">
              <div class="pull-left">
                Messages
              </div>

              <div class="pull-right">
                <a href="javascript:;">New Message</a>
              </div>
            </li>

            <li>
              <a href="./page-notifications.html" class="noticebar-item">
                <span class="noticebar-item-image">
                  <img src="./img/avatars/avatar-1-md.jpg" style="width: 50px" alt="">
                </span>

                <span class="noticebar-item-body">
                  <strong class="noticebar-item-title">New Message</strong>
                  <span class="noticebar-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit...</span>
                  <span class="noticebar-item-time"><i class="fa fa-clock-o"></i> 20 minutes ago</span>
                </span>
              </a>
            </li>

            <li>
              <a href="./page-notifications.html" class="noticebar-item">
                <span class="noticebar-item-image">
                  <img src="./img/avatars/avatar-2-md.jpg" style="width: 50px" alt="">
                </span>

                <span class="noticebar-item-body">
                  <strong class="noticebar-item-title">New Message</strong>
                  <span class="noticebar-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit...</span>
                  <span class="noticebar-item-time"><i class="fa fa-clock-o"></i> 5 hours ago</span>
                </span>
              </a>
            </li>

            <li class="noticebar-menu-view-all">
              <a href="./page-notifications.html">View All Messages</a>
            </li>
          </ul>
        </li>

      </ul>

      <ul class="nav navbar-nav navbar-right">   

        <li>
            <a href="javascript:;">Usuario: 
            <%
                        if(request.getSession().getAttribute("userSession") != null)       
                         {
                            cl.sgg.utils.UserSession usr = 
                                    (cl.sgg.utils.UserSession) request.getSession().getAttribute("userSession");
             
            %>
            <span class="text-success"> <%= usr.getUsername() %></span>
             <%         }
             %>
            
          </a>
        </li>    
           

        <li class="dropdown navbar-profile">
          <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:;">
            <img src="./img/avatars/avatar-1-xs.jpg" class="navbar-profile-avatar" alt="">
            <span class="navbar-profile-label">rod@rod.me &nbsp;</span>
            <i class="fa fa-caret-down"></i>
          </a>

          <ul class="dropdown-menu" role="menu">

            <li>
              <a href="./page-profile.html">
                <i class="fa fa-user"></i> 
                &nbsp;&nbsp;My Profile
              </a>
            </li>

            

            <li class="divider"></li>

            <li>
              <a href=".//login.jsp?cmd=close">
                <i class="fa fa-sign-out"></i> 
                &nbsp;&nbsp;Logout
              </a>
                
            </li>

          </ul>

        </li>

      </ul>

    </div> <!--/.navbar-collapse -->

</div> <!-- /.container -->

</div> <!-- /.navbar -->

<div class="mainbar">
 
  <div class="container">

    <button type="button" class="btn mainbar-toggle" data-toggle="collapse" data-target=".mainbar-collapse">
      <i class="fa fa-bars"></i>
    </button>
     
    
    <div class="mainbar-collapse collapse">
       <ul class="nav navbar-nav mainbar-nav">
                    <li>
                        <a href="#">Histórico Animal</a>
                    </li>
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Manejos 
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Traslados 
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
                    <a href="/pages/feedlot/feedlot.jsp" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Feedlot 
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
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true">Maestros 
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

    </div> <!-- /.navbar-collapse -->   

  </div> <!-- /.container --> 

</div> <!-- /.mainbar -->

<div class="container">

  <div class="content">

    <div class="content-container">

      <div class="row">

      <div class="row">

        <div class="col-md-8">

          <div class="portlet portlet-table">

            <div class="portlet-header">

              <h3>
                <i class="fa fa-group"></i>
                Recent Signups
              </h3>

              <ul class="portlet-tools pull-right">
                <li>
                  <button class="btn btn-sm btn-default">
                    Add User
                  </button>
                </li>
              </ul>

            </div> <!-- /.portlet-header -->

            <div class="portlet-content">


              <div class="table-responsive">

                <table id="user-signups" class="table table-striped table-bordered table-checkable"> 
                  <thead> 
                    <tr> 
                      <th class="checkbox-column"> 
                        <input type="checkbox" id="check-all" class="icheck-input" />
                      </th> 
                      <th class="hidden-xs">First Name</th> 
                      <th>Last Name</th> 
                      <th>Status</th>
                      <th class="text-center" style="width: 90px">Approve</th>
                    </tr> 
                  </thead> 

                  <tbody> 
                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" name="actiony" value="joey" class="icheck-input"> 
                      </td> 

                      <td class="hidden-xs">Joey</td> 
                      <td>Greyson</td> 
                      <td><span class="label label-success">Approved</span></td> 
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td> 
                    </tr> 

                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" name="actiony" value="wolf" class="icheck-input">
                      </td> 
                      <td class="hidden-xs">Wolf</td> 
                      <td>Bud</td> <td><span class="label label-default">Pending</span>
                      </td>  
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td> 
                    </tr> 

                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" name="actiony" value="sam" class="icheck-input"> 
                      </td> 

                      <td class="hidden-xs">Sam</td> 
                      <td>Mitchell</td> 
                      <td><span class="label label-success">Approved</span></td>  
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td> 
                    </tr> 

                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" value="carlos" name="actiony" class="icheck-input"> 
                      </td> 
                      <td class="hidden-xs">Carlos</td> 
                      <td>Lopez</td> 
                      <td><span class="label label-success">Approved</span></td> 
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td>  
                    </tr>  

                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" name="actiony" value="rob" class="icheck-input"> 
                      </td> 
                      <td class="hidden-xs">Rob</td> 
                      <td>Johnson</td> 
                      <td><span class="label label-default">Pending</span></td> 
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td> 
                    </tr> 

                    <tr> 
                      <td class="checkbox-column"> 
                        <input type="checkbox" value="mike" name="actiony" class="icheck-input"> 
                      </td> 
                      <td class="hidden-xs">Mike</td> 
                      <td>Jones</td> 
                      <td><span class="label label-default">Pending</span></td>  
                      <td class="text-center">
                        <a href="javascript:void(0);" class="btn btn-xs btn-primary" data-original-title="Approve">
                          <i class="fa fa-check"></i>
                        </a> 
                      </td> 
                    </tr>            

                  </tbody> 

                </table>
                  

              </div> <!-- /.table-responsive -->
                  
            </div> <!-- /.portlet-content -->

            <div class="portlet-footer">
              <div class="text-right">                  
                Apply to Selected: &nbsp;&nbsp;
                <select id="apply-selected" name="table-select" class="ui-select2" style="width: 125px">
                  <option value="">Select Action</option>
                  <option value="approve">Approve</option>
                  <option value="edit">Edit</option>
                  <option value="delete">Delete</option>
                  
                </select>
              </div>
            </div> <!-- /.portlet-footer -->

          </div> <!-- /.portlet -->

          <div class="portlet">

            <div class="portlet-header">

              <h3>
                <i class="fa fa-compass"></i>
                Traffic Overview
              </h3>

            </div> <!-- /.portlet-header -->

            <div class="portlet-content">

              <div class="progress-stat">
                  
                <div class="progress-stat-label">
                  % New Visits
                </div> <!-- /.stat-label -->
                
                <div class="progress-stat-value">
                  77.7%
                </div> <!-- /.stat-value -->
                
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="77" aria-valuemin="0" aria-valuemax="100" style="width: 77%">
                    <span class="sr-only">77.74% Visit Rate</span>
                  </div>
                </div> <!-- /.progress -->
                
              </div> <!-- /.progress-stat -->


              <div class="progress-stat">
                  
                <div class="progress-stat-label">
                  % Mobile Visitors
                </div> <!-- /.stat-label -->
                
                <div class="progress-stat-value">
                  33.2%
                </div> <!-- /.stat-value -->
                
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-tertiary" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%">
                    <span class="sr-only">33% Mobile Visitors</span>
                  </div>
                </div> <!-- /.progress -->
                
              </div> <!-- /.progress-stat -->


              <div class="progress-stat">
                
                <div class="progress-stat-label">
                  Bounce Rate
                </div> <!-- /.stat-label -->
                
                <div class="progress-stat-value">
                  42.7%
                </div> <!-- /.stat-value -->
                
                <div class="progress progress-striped active">
                  <div class="progress-bar progress-bar-secondary" role="progressbar" aria-valuenow="42" aria-valuemin="0" aria-valuemax="100" style="width: 42%">
                    <span class="sr-only">42.7% Bounce Rate</span>
                  </div>
                </div> <!-- /.progress -->
                
              </div> <!-- /.progress-stat -->

            </div> <!-- /.portlet-content -->

          </div> <!-- /.portlet -->

        </div> <!-- /.col -->

        <div class="col-md-4">

          <div class="portlet">

            <div class="portlet-header">

              <h3>
                <i class="fa fa-bar-chart-o"></i>
                Donut Chart
              </h3>

            </div> <!-- /.portlet-header -->

            <div class="portlet-content">

              <div id="donut-chart" class="chart-holder-225"></div>
                  

            </div> <!-- /.portlet-content -->

          </div> <!-- /.portlet -->

              

          




          <div class="portlet">

            <div class="portlet-header">
              <h3>
                <i class="fa fa-bar-chart-o"></i>
                Sparkline
              </h3>
            </div> <!-- /.portlet-header -->

            <div class="portlet-content">

              <div class="row row-marginless">

                <div class="spark-stat col-md-6 col-sm-6 col-xs-6">

                  <div id="total-visits">32, 38, 46, 49, 53, 48, 47, 56</div>
                  <span class="spark-stat-value">1,564</span>
                  <h5 class="spark-stat-label">Total Visits</h5>

                </div> <!-- /.col -->

                <div class="spark-stat col-md-6 col-sm-6 col-xs-6">

                  <div id="new-visits">32, 38, 46, 49, 53, 48, 47, 56</div>
                  <span class="spark-stat-value">872</span>
                  <h5 class="spark-stat-label">New Visits</h5>

                </div> <!-- /.col -->

              </div> <!-- /.row -->


              <div class="row row-marginless">

                <div class="spark-stat col-md-6 col-sm-6 col-xs-6">

                  <div id="unique-visits">32, 38, 46, 49, 53, 48, 47, 56</div>
                  <span class="spark-stat-value">845</span>
                  <h5 class="spark-stat-label">Unique Visits</h5>

                </div> <!-- /.col -->

                <div class="spark-stat col-md-6 col-sm-6 col-xs-6">

                  <div id="revenue-visits" data-bar-color="#c00">32, 38, 46, 49, 53, 48, 47, 56</div>
                  <span class="spark-stat-value">$13,492</span>
                  <h5 class="spark-stat-label">Revenue Visits</h5>

                </div> <!-- /.col -->

              </div> <!-- /.row -->

            </div> <!-- /.portlet-content -->

          </div> <!-- /.portlet -->

        </div> <!-- /.col -->

      </div> <!-- /.row -->

    </div> <!-- /.content-container -->
      
  </div> <!-- /.content -->

</div> <!-- /.container -->

</div> <!-- /.container MAIN -->


<footer class="footer">

  <div class="container">

    <div class="row">

      <div class="col-sm-3">

        <h4>SmartClarity</h4>

        <br>

        <p>Sistema de gestión ganadera</p>  

        <hr>    

        <p>&copy; 2016 Flagare SPA.</p>
        
        <p>Contacto: 800 800 5000</p>

      </div> <!-- /.col -->

      <div class="col-sm-3"> 

        <h4>Soporte</h4>

        <br>

        <ul class="icons-list">
          <li>
            <i class="fa fa-angle-double-right icon-li"></i>
            <a href="#;">Manual de Usuario</a>
          </li>
          <li>
            <i class="fa fa-angle-double-right icon-li"></i>
            <a href="javascript:;">Consultas frecuentes</a>
          </li>
          <li>
            <i class="fa fa-angle-double-right icon-li"></i>
            <a href="javascript:;">Video Tutorial</a>
          <li>
            <i class="fa fa-angle-double-right icon-li"></i>
            <a href="javascript:;">Contacto</a>
          </li>
        </ul>          

      </div> <!-- /.col -->

    </div> <!-- /.row -->

  </div> <!-- /.container -->
  
</footer>

  <script src="./js/libs/jquery-1.10.1.min.js"></script>
  <script src="./js/libs/jquery-ui-1.9.2.custom.min.js"></script>
  <script src="./js/libs/bootstrap.min.js"></script>

  <!--[if lt IE 9]>
  <script src="./js/libs/excanvas.compiled.js"></script>
  <![endif]-->
  
  <!-- Plugin JS -->
  <script src="./js/plugins/icheck/jquery.icheck.js"></script>
  <script src="./js/plugins/select2/select2.js"></script>
  <script src="./js/libs/raphael-2.1.2.min.js"></script>
  <script src="./js/plugins/morris/morris.min.js"></script>
  <script src="./js/plugins/sparkline/jquery.sparkline.min.js"></script>
  <script src="./js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
  <script src="./js/plugins/fullcalendar/fullcalendar.min.js"></script>

  <!-- App JS -->
  <script src="./js/target-admin.js"></script>
  
  <!-- Plugin JS -->
  <script src="./js/demos/dashboard.js"></script>
  <script src="./js/demos/calendar.js"></script>
  <script src="./js/demos/charts/morris/area.js"></script>
  <script src="./js/demos/charts/morris/donut.js"></script>
  
</body>
</html>