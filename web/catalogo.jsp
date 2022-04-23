<%-- 
    Document   : catalogo
    Created on : 18-feb-2022, 10:49:09
    Author     : Usuario
--%>

<%@page import="servlet.FrontServlet"%>
<%@page import="servlet.Libro"%>
<%@page import="java.util.SortedSet"%>
<%@page import="java.util.Set"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Catalogo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Tienda de Libros</h1>
        
        <form action="FrontServlet">
            
            <input type="hidden" name="command" value="CarritoCom"/>
            <input type="submit" value="Comprar libros"/> 
        </form>
        <br/>
        
        <%
            SortedSet<Libro> catalogo = FrontServlet.getCatalogo().getLibros();
            
            for(Libro l:catalogo){
        %>
        
        <hr style="width:100%", size="3", color=black>
        <br/>
        <img src="<%=l.getFoto()%>"><br/>
        <%= l.toString()%> <form action="FrontServlet">
            <input type="hidden" name="command" value="ComprarCom"/>
            <input type="hidden" name="libro" value="<%=l.getName()%>"/>
            <input type="submit" value="<%=l.getCost()%> €"/>
        </form>
        
        <%
            }
        %>
        <hr style="width:100%", size="3", color=black>
        
        <br/>
        <br/>
        <form action="FrontServlet">
            
            <input type="hidden" name="command" value="CarritoCom"/>
            <input type="submit" value="Comprar libros"/> 
        </form>
            
    </body>
</html>
