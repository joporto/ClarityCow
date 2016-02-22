
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
                            <a href="/page-notifications.html" class="noticebar-item">
                                <span class="noticebar-item-image">
                                    <img src="/img/avatars/avatar-1-md.jpg" style="width: 50px" alt="">
                                </span>

                                <span class="noticebar-item-body">
                                    <strong class="noticebar-item-title">New Message</strong>
                                    <span class="noticebar-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit...</span>
                                    <span class="noticebar-item-time"><i class="fa fa-clock-o"></i> 20 minutes ago</span>
                                </span>
                            </a>
                        </li>

                        <li>
                            <a href="/page-notifications.html" class="noticebar-item">
                                <span class="noticebar-item-image">
                                    <img src="/img/avatars/avatar-2-md.jpg" style="width: 50px" alt="">
                                </span>

                                <span class="noticebar-item-body">
                                    <strong class="noticebar-item-title">New Message</strong>
                                    <span class="noticebar-item-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit...</span>
                                    <span class="noticebar-item-time"><i class="fa fa-clock-o"></i> 5 hours ago</span>
                                </span>
                            </a>
                        </li>

                        <li class="noticebar-menu-view-all">
                            <a href="/page-notifications.html">View All Messages</a>
                        </li>
                    </ul>
                </li>

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
                        <img src="/img/avatars/avatar-1-xs.jpg" class="navbar-profile-avatar" alt="">
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