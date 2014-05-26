<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver carro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <!-- para el login -->
        <link href=<c:url value="/css/signin.css" /> rel="stylesheet">
        <link href=<c:url value="/css/verCarro.css" /> rel="stylesheet">
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
        <script src=<c:url value="/js/indexSignIn.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <c:import url="cabeceraProductos.jsp" charEncoding="utf-8"/>
        <div id="verCarro">
        <h1> Contenido del carro <span class="glyphicon glyphicon-shopping-cart"></span></h1>
            <c:forEach var="producto" items="${carro.contenido}" >
            <img title="imagen" style="width: 10%" alt="imagen de ${producto.prod.nombreproducto}" src=".${producto.prod.imagen}">
            <br>
            <a  href=<c:url value="/detallesProducto?id=${producto.prod.idproducto}" /> ><h3>${producto.prod.nombreproducto}</h3>
            </a> 
            <div class="row" >
                <form method="get" action=<c:url value="/decrementar" />>
                    <input type="hidden" name="id" value="${producto.prod.idproducto}"></input>
                    <input class="col-xs-1 col-md-1 btn btn-default btn-block btn-lg" style="max-width: 50px" type="submit" value="-" ></input>
                </form>    
                <input class="col-xs-1 col-md-1 input-lg" style="max-width: 100px" type="text" name="${producto.prod.idproducto}" value="${producto.cantidad}" size="1" readonly></input>
                <form method="get" action=<c:url value="/incrementar" />>
                    <input type="hidden" name="id" value="${producto.prod.idproducto}"></input>
                    <input class="col-xs-1 col-md-1 btn btn-default btn-block btn-lg" style="max-width: 50px" type="submit" value="+" ></input>
                </form>  
            </div>
            <a  href=<c:url value="/sacarDeCarro?id=${producto.prod.idproducto}" /> ><h2><span class="glyphicon glyphicon-trash"> Eliminar</h2></a>
            <p>Precio por cada unidad: ${producto.prod.precio} <span class="glyphicon glyphicon-euro"></span><p>
                Subtotal:   ${producto.prod.precio * producto.cantidad} <span class="glyphicon glyphicon-euro"></span>
            <br><h1>_______________________</h1><br>         
        </c:forEach>
            
        </div>
            
        <div class="row">
            <div class="col-xs-6 col-md-6"><a href=<c:url value="/hacerPedido" /> class="btn btn-primary btn-block btn-lg" tabindex="1">Terminar Compra</a></div>
            <div class="col-xs-6 col-md-6"><a href=<c:url value="/index" /> class="btn btn-success btn-block btn-lg" tabindex="2" >Volver</a></div>
        </div>
        
        <c:import url="footer.jsp" charEncoding="utf-8"/>
    </body>
</html>
