<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pago Tarjeta</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <div class="container" id="contenedor">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <form role="form" id="form" method="get" action=<c:url value="/pagoTarjeta"/>>
                        <h2>Datos de pago</h2>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" placeholder="Nombre" name="nombre" value="Nombre del titular: ${usuario.nombre}" tabindex="1" required>
                                <input type="text" name="userid" value="${usuario.idusuario}" hidden>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="text" min="0" class="form-control input-lg" placeholder="Nº de la tarjeta" name="direccion" value="" tabindex="2" required>
                            </div>
                        </div>
                        <h3>Fecha de expiracion y nº de verificación</h3>
                        <div class="row">
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Mes</label>
                                    <input type="number" min="1" max="12" class="form-control" placeholder="MM" required>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>Año</label>
                                    <input type="number" min="2014" max="2099" class="form-control" placeholder="YYYY" required>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-group">
                                    <label>CVC</label>
                                    <input type="number" min="100" max="999" class="form-control" placeholder="Ej. 331" required>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <h2>
                                Total: ${carro.precio} <span class="glyphicon glyphicon-euro"></span>
                            </h2>
                        </div>   
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-md-6"><input type="submit" value="Pagar y finalizar" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                            <div class="col-xs-6 col-md-6"><a href=<c:url value="/index"/> class="btn btn-success btn-block btn-lg" tabindex="10" >Volver</a></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
