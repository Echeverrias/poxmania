<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar pedidos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>      
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <h1 id="overview" class="page-header">Opciones de administración de pedidos</h1>
        <div class="panel panel-default">
            <c:forEach var="pedido" items="${listaPedidos}" >
                <form role="form" id="form" method="get" action=<c:url value="/editarPedidoConcreto"/>>
                    <div class="panel-heading">
                        <input type="text" name="idpedido" value="${pedido.pedido.idpedido}" hidden>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="idpedi" class="form-control input-lg" placeholder="ID Pedido" value="Número de pedido: ${pedido.pedido.idpedido}" disabled style="text-align: center;">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="submit" value="Cambiar" class="btn btn-success btn-block btn-lg">
                                </div>
                            </div>
                        </div>        
                        <select class="form-control" name="estado" tabindex="2" required>
                            <option selected>${pedido.pedido.estado}</option>
                            <option >Nuevo</option>
                            <option >En preparación</option>
                            <option >Listo para enviar</option>
                            <option >De camino</option>
                        </select> 
                    </div>
            </div>
        </div>
    </form>
    <!-- List group -->
    <ul class="list-group">
        <c:forEach var="producto" items="${pedido.productos}" >
            <li class="list-group-item" >${producto.prod.nombreproducto}  ${producto.prod.precio} €  | Cantidad: ${producto.cantidad} | Importe total : ${producto.cantidad * producto.prod.precio} € </a> </li>
            </c:forEach>
    </ul>
</c:forEach>
<ul class="list-group">
    <a class="col-xs-6 btn btn-primary btn-block btn-lg" href="<c:url value="/opcionesAdminOK" />" >Volver al índice</a>
</ul>
</body>
</html>

