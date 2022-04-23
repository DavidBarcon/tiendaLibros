<%-- 
    Document   : catalogo
    Created on : 18-feb-2022, 10:49:09
    Author     : Usuario
--%>


<%@page import="servlet.Libro"%>
<%@page import="servlet.Catalogo"%>
<%@page import="servlet.FrontServlet"%>
<%@page import="servlet.ShoppingCart"%>
<%@page import="java.util.Set"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Shopping Cart</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        
        
        
        <%
            Catalogo catalogo = FrontServlet.getCatalogo();
            ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
            Set<String> cart2 = cart.getLibros();
            int costoT = 0;
            for(String l:cart2){
            
            Libro libro = catalogo.getLibro(l);
            //System.out.println(libro);
            int costo = libro.getCost();
            costoT += costo;
            
        %>
        <hr align="left" style="width:30%", size="3", color=black> 
        <br/>
        <%= l %> <%= costo %> €
        <br/>
        
        <form action="FrontServlet">
            <input type="hidden" name="command" value="RemoveCom"/>
            <input type="hidden" name="libro" value="<%=l%>"/> 
            <input type="submit" value="quitar"/>
            <br/>
        </form>
        <%
            }
        %>
        
        <hr align="left" style="width:30%", size="3", color=black> 
        
        <br/>
        Total: <%= costoT %> €
        <br/>
        <form action="FrontServlet">
            
            <input type="hidden" name="command" value="VolverCom"/>
            <input type="submit" value="volver"/>
        </form>
        
        <form action="FrontServlet">
            
            <input type="hidden" name="command" value="FinalCom"/>
            <input type="submit" value="comprar"/>
        </form>
        
        

            
    </body>
</html>
