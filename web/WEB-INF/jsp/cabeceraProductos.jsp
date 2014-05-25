<!-- Autores: Samuel Martin y Juan Antonio Echeverrias -->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Categorías</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav"> 
                <li ><a href=<c:url value="/indexTodas"/> >Todas</a></li>
                    <c:forEach var="categoria" items="${listaCategorias}" >
                    <li><a href=<c:url value="/indexEspecifico?cat=${categoria.idcategoria}" /> > ${categoria.nombrecategoria}</a></li>
                    </c:forEach>
            </ul>
            <ul class="nav navbar-nav navbar-right">    
                <c:if test="${user == ''}">
                    <li ><a id="loginLi" href="#">Login</a></li>
                    <li><a href=<c:url value="/registro" />>Registrarse</a></li>
                    </c:if>
                    <c:if test="${user != ''}">
                    <li ><a id="user" href=<c:url value="/verMisPedidos?uId=${userid}" /> >${user}</a></li>
                    <li ><a id="user" href=<c:url value="/logout" /> >Logout</a></li>
                    </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <c:if test="${carro.total == 0}">
                        <a class="navbar-brand" href=<c:url value="/verCarro" /> >
                        </c:if>
                        <c:if test="${carro.total != 0}">
                            <a class="navbar-brand" style="color:blue" href=<c:url value="/verCarro" /> >
                            </c:if>
                            <span class="glyphicon glyphicon-shopping-cart"></span>Ver Carro
                        </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="panel-heading">          
    <ul>
        <div class="row">          

            <form method="get" action=<c:url value="/buscarProducto" />>
                <div class="col-xs-9 col-sm-9 col-md-9">
                    <input placeholder="Buscar" class="form-control input-lg" type="text" name="nombre" required>
                </div>
                <div class="col-xs-3 col-sm-3 col-md-3">
                    <input class="btn btn-success btn-block btn-lg" type="submit" name="enviar" value="Buscar" placeholder="PS4">
                </div>
            </form>
        </div> 
    </ul>
</div>
</div> 
<div class="container" id="logi">
    <form class="form-signin" role="form" action=<c:url value="/loginUsuario" />>
        <h2 class="form-signin-heading">Por favor, loguéate</h2>
        <input type="text" name="nick" class="form-control" placeholder="Nick" required autofocus>
        <input type="password" name="password" class="form-control" placeholder="Contraseña" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
    </form>
</div>

