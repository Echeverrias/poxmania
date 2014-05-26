<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Realizar pedido</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
        <script src=<c:url value="/js/hacerPedido.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <div class="container" id="contenedor">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <form role="form" id="form" method="get" action=<c:url value="/pago"/>>
                        <h2>Datos personales para el envío</h2>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" placeholder="Nombre" name="nombre" value="${usuario.nombre}" tabindex="1" required>
                                <input type="text" name="userid" value="${usuario.idusuario}" hidden>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="text" min="0" class="form-control input-lg" placeholder="Direccion" name="direccion" value="${usuario.direccion}" tabindex="4" required>                 
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" placeholder="telefono" name="telefono" value="${usuario.telefono}" tabindex="5" required>
                            </div>
                        </div>
                        <div class="row">
                            <h2>
                                Total: ${carro.precio} <span class="glyphicon glyphicon-euro"></span>
                            </h2>
                        </div>
                        <input type="hidden" name="option" value="1" id="btn-input" />
                        <div class="btn-group" data-toggle="buttons-radio">  
                            <button id="btn-one" type="button" data-toggle="button" name="option" value="1" class="btn btn-primary radios">Pago contra reembolso ( +5€ )</button>
                            <button id="btn-two" type="button" data-toggle="button" name="option" value="2" class="btn btn-default radios">Pago con tarjeta de crédito</button>
                        </div>                 
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-md-6"><input type="submit" value="Pago" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                            <div class="col-xs-6 col-md-6"><a href=<c:url value="/index"/> class="btn btn-success btn-block btn-lg" tabindex="10" >Volver</a></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
