<%-- 
    Document   : index
    Created on : 11-feb-2016, 3:22:39
    Author     : javierOporto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     Listado de Razas
     <br>
        <%
            cl.sgg.dao.RazaDAO rdao = new cl.sgg.dao.RazaDAO();
            
            for(cl.sgg.edm.Raza arg : rdao.getList())
            {
                out.print(arg.getRazaNombre());
        %>
        
        <br>
        
        <%
            }
            
        %>
        
    </body>
</html>
