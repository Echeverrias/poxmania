<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <!-- para el login -->
        <link href=<c:url value="/css/signin.css" /> rel="stylesheet">
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
        <script src=<c:url value="/js/indexSignIn.js" /> type="text/javascript"></script> 
        
    </head>
    <body>

        <c:import url="cabeceraProductos.jsp" charEncoding="utf-8"/>
        
        <h1> Contenido del carro: ${user}</h1>
        
         
        <!-- formulario de modificación de pedido -->
         
        <table>
            <c:forEach var="producto" items="${carro.contenido}" >
                <tr>
                    <td>
                        <img title="imagen" alt="imagen de ${producto.prod.nombreproducto}" src=".${producto.prod.imagen}"  height="50px">
                        <a href=<c:url value="/detallesProducto?id=${producto.prod.idproducto}" /> >${producto.prod.nombreproducto}</a>  
                        <div class="cantidad">
                            <form method="get" action=<c:url value="/decrementar" />>
                                <input type="hidden" name="id" value="${producto.prod.idproducto}"></input>
                                <input class="decrementar" type="submit" value="-" ></input>
                            </form>    
                            <input type="text" name="${producto.prod.idproducto}" value="${producto.cantidad}" size="1" readonly></input>
                             <form method="get" action=<c:url value="/incrementar" />>
                                <input type="hidden" name="id" value="${producto.prod.idproducto}"></input>
                                <input class="incrementar" type="submit" value="+" ></input>
                            </form>  
                            <a href=<c:url value="/sacarDeCarro?id=${producto.prod.idproducto}" /> >Eliminar</a>  
                            <p>Precio: ${producto.prod.precio} <span class="glyphicon glyphicon-euro"></span><p>
                            </td>
                    <td>
                        Precio Total:   ${producto.prod.precio * producto.cantidad} <span class="glyphicon glyphicon-euro"></span>

                    </td>
                
                 </tr>
                 
            </c:forEach>
                 </table>  
        
            <div class="pedido">
                <a href=<c:url value="/hacerPedido" /> class="btn btn-primary" role="button">Hacer pedido</a>
                <p>Importe Total: ${carro.precio} <span class="glyphicon glyphicon-euro"></span></p>
            </div>
                  
            
        <br><br>   
        <!-- formulario de realizar pedido -->   
        <form method="get" action="FinalizarPedido" name="agregarEnCarro"> 
            Nombre de pedido <input type="text" name="nombrePedido" required>
            <input type="submit" name="finalizarPedido" value="Finalizar pedido">
        </form>
        <br><br>
        
        <a href=<c:url value="/index" />>Volver</a>
       
        
    </body>
</html>
