<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login de administrador</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>      
        <script src=<c:url value="/js/jquery.js" /> type="text/javascript"></script> 
    </head>
    <body>
        <div class="container">
            <form action=<c:url value="/opcionesAdmin" /> method="get">
                <h2 class="form-signin-heading">Acceso restringido a administradores del sistema</h2>
                <input type="text" class="form-control" placeholder="Nombre de administrador" name="nombre" required autofocus>
                <input type="password" class="form-control" placeholder="Password" name="pass" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
            </form>
        </div> <!-- /container -->
    </body>
</html>
