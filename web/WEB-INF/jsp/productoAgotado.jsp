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
    </head>
    <body style="text-align: center">
        <h1>Error en su compra</h1> <br>
        <h2>Lamentamos comunicarle que no tenemos disponibles algunos articulos, como ${productoAgotado.nombreproducto}</h2>
        <h3>Lo sentimos mucho, y rogamos disculpe las molestias </h3>
        <br>
        <a href=<c:url value="/index"/> class="btn btn-success btn-block btn-lg" tabindex="10" style="max-width:20%; margin: auto">Volver al inicio</a>
    </body>
</html>
