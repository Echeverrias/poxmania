<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar categoria</title>
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
            <form role="form" id="form" method="get" action=<c:url value="/editarCategoriaFin"/>>
            <h2>Edicion de categoria</h2>
            <hr class="colorgraph">
            <div class="row">
                <div class="form-group">
                    <input type="text" class="form-control input-lg" placeholder="Nombre de la categoria" name="nombreCategoria" tabindex="1" value="${categoria.nombrecategoria}" required>
                </div>
                <input type="text" name="idcategoria" value="${categoria.idcategoria}" hidden>
            </div>
            <hr class="colorgraph">
            <div class="row">
                <div class="col-xs-6 col-md-6"><input type="submit" value="Editar" class="btn btn-primary btn-block btn-lg" tabindex="9"></div>
                <div class="col-xs-6 col-md-6"><a href=<c:url value="/editarCategoria"/> class="btn btn-success btn-block btn-lg" tabindex="10" >Volver</a></div>
            </div>
        </form>
    </div>
</div>
</div>
</body>
</html>
