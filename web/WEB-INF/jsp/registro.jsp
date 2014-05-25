<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
        <script src=<c:url value="/js/registroTogle.js" /> type="text/javascript"></script> 
        <link href=<c:url value="/css/registro.css" /> rel="stylesheet">
    </head>
    <body>
        <div class="container" id="contenedor">
            <div class="row">
                <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
                    <form role="form" id="form" method="get" action=<c:url value="/registrarUsuario" />>
                        <h2>Regístrese <small>Mejorará su experiencia en PoxMania</small></h2>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name" class="form-control input-lg" placeholder="Nombre" tabindex="1">
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" class="form-control input-lg" placeholder="Apellidos" tabindex="2">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" name="direccion" id="direccion" class="form-control input-lg" placeholder="Direccion" tabindex="3">
                        </div>
                        <div class="form-group">
                            <input type="text" name="telefono" id="telefono" class="form-control input-lg" placeholder="Teléfono" tabindex="4">
                        </div>
                        <div class="form-group">
                            <input type="text" name="nick" id="nick" class="form-control input-lg" placeholder="Nick" tabindex="5">
                            <span class="glyphicon glyphicon-asterisk"></span>
                        </div>
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="6">
                                    <span class="glyphicon glyphicon-asterisk"></span>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    <input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirmar Password" tabindex="7">
                                    <span class="glyphicon glyphicon-asterisk"></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-3 col-sm-3 col-md-3">

                                <label for="aceptar" title="imagen">
                                    <img src=<c:url value="${aceptar}"/> alt="acepto_condiciones"  title="imagen"/>
                                </label>
                                <input type="checkbox" id="aceptar" name="acept" value="aceptar"  title="imagen"/>
                            </div>
                            <div class="col-xs-9 col-sm-9 col-md-9">
                                Haciendo click en  <strong class="label label-primary">Aceptar</strong>, aceptas los  <a id="terminos" tabindex="11" href="#" >términos y condiciones</a> de este sitio.
                            </div>
                        </div>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-md-6"><input type="submit" value="Registrar" class="btn btn-primary btn-block btn-lg" tabindex="9"></div>
                            <div class="col-xs-6 col-md-6"><a href=<c:url value="/index" /> class="btn btn-success btn-block btn-lg" tabindex="10" >Volver</a></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container" id="term2">
            <h1> Términos y condiciones </h1>
            <p>La sociedad POXMANIA, sociedad anónima con un capital de 3 euros, cuya sede social se encuentra en el número 2-9 rue Sarah Bernhardt  92600nord-Seine (Francia / France) e inscrita en el Registro Mercantil y de Sociedades de Nanterre con el número 352 236 234; con número de CIF ES N0213376I (de ahora en adelante "Poxmania") publica un sitio web al que se puede acceder mediante la dirección siguiente: http://www.poxmania.es (de ahora en adelante elSitio).
                <br><br>
                Además de los productos que Pixmania comercializa directamente en el sitio, éste último también permite a vendedores profesionales ofrecer y vender sus propios productos a los consumidores que utilizan el Sitio.
                <br><br>
                Con este fin, la sociedad ha creado e implementado una plataforma electrónica accesible en el Sitio que los vendedores profesionales y los consumidores pueden utilizar para establecer un contacto directo.
                <br><br>
                En este contexto, Pixmania actúa como intermediario técnico ofreciendo la plataforma a los vendedores profesionales y los consumidores, pero no interviene en los contratos de venta que cierran directamente entre ello.
                <br><br>
                Estas condiciones de uso (de ahora en adelante, las Condiciones de Uso) organizan las condiciones de uso para el cliente de la plataforma que ofrece Pixmania y definen las modalidades de intervención de Pixmania como intermediario técnico.
                <br><br>
                Estas condiciones deben ser aceptadas por los consumidores cuando utilizan la plataforma para realizar pedidos de productos de los vendedores profesionales.
            </p>
        </div>
    </body>
</html>
