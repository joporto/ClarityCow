
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
                <a class="navbar-brand navbar-brand-image" style="width:700px;" href="./index.jsp">
                    <img src="/img/logo_sc_2.png" class="img-responsive" style="height:60px; padding-left:1em; float:left;" alt="Site Logo">
                    <img src="/img/logo-Ariztia.png" class="img-responsive" style="height:60px; padding-left:1em; float:left;" alt="Site Logo2">
                    <span style="float:right; font-size:1.5em; line-height:60px; color:#424242; padding-left:0.5em; padding-right:0.5em;">ClarityCow</span>
                </a>
            </div>
            <ul class="nav navbar-nav noticebar navbar-left">
            </ul>
            <ul class="nav navbar-nav navbar-right">   
                <li>
                    <a href="javascript:;" class="text-primary">  
                        <%
                            if (request.getSession().getAttribute("userSession") != null) {
                                cl.sgg.utils.UserSession usr
                                        = (cl.sgg.utils.UserSession) request.getSession().getAttribute("userSession");

                        %>
                        <span class="text-success"> <%= "Usuario: " + usr.getFirstname() + " " + usr.getLastname()%></span>
                        <%         }
                        %>
                    </a>
                </li>    
                <li class="dropdown navbar-profile">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:;">
                        <img src="/img/avatars/user.png" class="navbar-profile-avatar" alt="">
                        <span class="navbar-profile-label">rod@rod.me &nbsp;</span>
                        <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu" role="menu">

                        <li>
                            <a href="/page-profile.html">
                                <i class="fa fa-user"></i> 
                                &nbsp;&nbsp;My Profile
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="/login.jsp?cmd=close">
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