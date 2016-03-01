<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
    <head>
        <title>Tables Advanced - Target Admin</title>

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
        <div class="container">

            <div class="table-responsive">
                <table 
                    class="table table-striped table-bordered table-hover table-highlight table-checkable" 
                    data-provide="datatable" 
                    data-display-rows="10"
                    data-info="true"
                    data-search="true"
                    data-length-change="true">
                    <thead>
                        <tr>
               
                            <th data-sortable="true">Rendering engine</th>
                            <th data-sortable="true">Browser</th>
                            <th data-sortable="true">Platform(s)</th>
                            <th class="hidden-xs hidden-sm">Engine version</th>
                            <th class="hidden-xs hidden-sm">CSS grade</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                           
                            <td>Trident</td>
                            <td>Internet
                                Explorer 5.0
                            </td>
                            <td>Win 95+</td>
                            <td class="hidden-xs hidden-sm">5</td>
                            <td class="hidden-xs hidden-sm">C</td>
                        </tr>
                        <tr >
                            
                            <td>Trident</td>
                            <td>Internet
                                Explorer 5.5
                            </td>
                            <td>Win 95+</td>
                            <td class="hidden-xs hidden-sm">5.5</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                            
                            <td>Trident</td>
                            <td>Internet
                                Explorer 6
                            </td>
                            <td>Win 98+</td>
                            <td class="hidden-xs hidden-sm">6</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                            
                            <td>Trident</td>
                            <td>Internet Explorer 7</td>
                            <td>Win XP SP2+</td>
                            <td class="hidden-xs hidden-sm">7</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                            
                            <td>Trident</td>
                            <td>AOL browser (AOL desktop)</td>
                            <td>Win XP</td>
                            <td class="hidden-xs hidden-sm">6</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr class="">
                            
                            <td>Misc</td>
                            <td>NetFront 3.1</td>
                            <td>Embedded devices</td>
                            <td class="hidden-xs hidden-sm">-</td>
                            <td class="hidden-xs hidden-sm">C</td>
                        </tr>
                        <tr class="">
                            
                            <td>Misc</td>
                            <td>NetFront 3.4</td>
                            <td>Embedded devices</td>
                            <td class="hidden-xs hidden-sm">-</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                           
                            <td>Gecko</td>
                            <td>Firefox 2.0</td>
                            <td>Win 98+ / OSX.2+</td>
                            <td class="hidden-xs hidden-sm">1.8</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                            
                            <td>Gecko</td>
                            <td>Firefox 3.0</td>
                            <td>Win 2k+ / OSX.3+</td>
                            <td class="hidden-xs hidden-sm">1.9</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        <tr >
                            
                            <td>Gecko</td>
                            <td>Camino 1.0</td>
                            <td>OSX.2+</td>
                            <td class="hidden-xs hidden-sm">1.8</td>
                            <td class="hidden-xs hidden-sm">A</td>
                        </tr>
                        
                    </tbody>
                </table>
            </div> <!-- /.table-responsive -->
        </div> <!-- /.container -->

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