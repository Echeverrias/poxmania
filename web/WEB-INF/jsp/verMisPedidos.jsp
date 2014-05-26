<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver mis pedidos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>      
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <h1 id="overview" class="page-header">Pedidos correspondientes a ${usuarioPedido.nombre}</h1>
        <div class="panel panel-default">
            <c:forEach var="pedido" items="${listaPedidos}" >
                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="idpedi" class="form-control input-lg" placeholder="ID Pedido" value="Número de pedido: ${pedido.pedido.idpedido}" disabled style="text-align: center;">
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6 ">                   
                    </div>
                </div>  
            </div>
            <ul class="list-group">
                <li class="list-group-item" >Estado del producto: ${pedido.pedido.estado} </li>
            </ul>
            <ul class="list-group">
                <c:forEach var="producto" items="${pedido.productos}" >
                    <li class="list-group-item" >${producto.prod.nombreproducto}  ${producto.prod.precio} €  | Cantidad: ${producto.cantidad} | Importe total : ${producto.cantidad * producto.prod.precio} € </li>
                    </c:forEach>
            </ul>
        </c:forEach>
        <ul class="list-group">
            <a class="col-xs-6 btn btn-primary btn-block btn-lg" href="<c:url value="/index" />" >Volver al índice</a>
        </ul>
        <c:import url="footer.jsp" charEncoding="utf-8"/>
    </body>
</html>

