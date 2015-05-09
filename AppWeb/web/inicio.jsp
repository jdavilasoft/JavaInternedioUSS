<%-- 
    Document   : maqueteado
    Created on : 02/05/2015, 04:56:28 PM
    Author     : PAUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>

        <title>JSP Page</title>
    </head>
    <body class="jumbotron">

        <div class="container-fluid">
            <div class="col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li role="presentation" class="active"><a href="inicio.jsp">Inicio</a></li>
                    <li role="presentation"><a href="personal.jsp">Personal</a></li>
                    <li role="presentation"><a href="#">cliente</a></li>
                </ul>
            </div>
            <div class="col-md-10">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title" id="panel-title">BIENVENIDA<a class="anchorjs-link" href="#panel-title"><span class="anchorjs-icon"></span></a></h3>
                    </div>
                    <div class="panel-body">
                        BIENVENIDO: <%=session.getAttribute("usuarioSession")%> AL SISTEMA WEB
                        <center><img  src="img/fondomain.jpg"  width="100%"  height="100%" ></center>
                    </div>
                </div>
            </div>

        </div>
        <footer class="text-center col-lg-12 ">
            <div class="bg-primary" >
                Copyright - GRUPO DE JAVA INTERMEDIO
            </div>
        </footer>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/npm.js"></script>
    </body>

</html>
