<%-- 
    Document   : Unknown
    Created on : 18-feb-2022, 11:03:19
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Gracias por su compra</h1>
        <form action="FrontServlet">
            <input type="hidden" name="command" value="VolverCom"/>
            <input type="submit" value="volver al catalogo"/>
        </form>
    </body>
</html>
