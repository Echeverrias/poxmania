<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Alta producto</title>
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
                    <form role="form" id="form" method="POST" enctype="multipart/form-data" action=<c:url value="/insertarProducto"/>>
                        <h2>Alta de nuevo producto</h2>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="form-group">
                                <input type="text" class="form-control input-lg" placeholder="Nombre del producto" name="nombre" tabindex="1" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <select class="form-control" name="categoria" tabindex="2" required>
                                    <c:forEach var="categoria" items="${listaCategorias}" >
                                        <option>${categoria.idcategoria} -> ${categoria.nombrecategoria}</option>
                                    </c:forEach>
                                </select> 
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <textarea class="form-control" rows="5" placeholder="Descripcion" name="descripcion" tabindex="3" required></textarea>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="number"  step="any" min="0" class="form-control input-lg" placeholder="Precio" name="precio" tabindex="4" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="file" class="form-control input-lg" placeholder="imagen" name="imagen" tabindex="5" required>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group">
                                <input type="number" min="0" class="form-control input-lg" placeholder="Stock" name="stock" tabindex="6" required>
                            </div>
                        </div>
                        <hr class="colorgraph">
                        <div class="row">
                            <div class="col-xs-6 col-md-6"><input type="submit" value="Insertar" class="btn btn-primary btn-block btn-lg" tabindex="7"></div>
                            <div class="col-xs-6 col-md-6"><a href=<c:url value="/opcionesAdminOK"/> class="btn btn-success btn-block btn-lg" tabindex="10" >Volver</a></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
