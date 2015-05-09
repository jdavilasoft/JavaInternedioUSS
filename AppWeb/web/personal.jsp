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

        <script type="text/javascript">
            function mostrar() {
                document.getElementById("resultado").innerHTML = "Grabado Correctamente";
            }
        </script>

        <title>JSP Page</title>
    </head>
    <body class="jumbotron">

        <div class="container-fluid">
            <div class="col-md-2">
                <ul class="nav nav-pills nav-stacked">
                    <li role="presentation"><a href="inicio.jsp">Inicio</a></li>
                    <li role="presentation" class="active"><a href="inicio.jsp">Personal</a></li>
                    <li role="presentation"><a href="listarPersonal.html">Listado de Personal</a></li>
                    <li role="presentation"><a href="#">cliente</a></li>
                </ul>
            </div>
            <div class="col-md-10">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title" id="panel-title">Usuario logueado: <%=session.getAttribute("usuarioSession")%> <a class="anchorjs-link" href="#panel-title"><span class="anchorjs-icon"></span></a></h3>
                    </div>
                    <div class="panel-body">

                        <form class="form-horizontal" method="POST" name="frmpersonal" id="frmpersonal" action="regPersonal.html">
                            <div class="form-group">
                                <label for="txtDni" class="col-sm-2 control-label">Dni</label>
                                <div class="col-sm-2">
                                    <input type="text" class="form-control" name="txtDni" id="txtDni" placeholder="Dni">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="txtNombre" class="col-sm-2 control-label">Nombre</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="txtNombre" id="txtNombre" placeholder="Nombres">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="txtApellido" class="col-sm-2 control-label">Apellidos</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="txtApellido" id="txtApellido" placeholder="Apellidos">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="txtDireccion" class="col-sm-2 control-label">Dirección</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="txtDireccion" id="txtDireccion" placeholder="Dirección">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cmbSexo" class="col-sm-2 control-label">Sexo</label>
                                <div class="col-sm-10">
                                    <select id="cmbSexo" name="cmbSexo">
                                        <option value ="MASCULINO">Masculino</option>
                                        <option value ="FEMENINO">Femenino</option>
                                    </select>
                                </div>
                            </div>

                            <input type="submit" class="btn btn-primary" name="btnGrabar" id="btnGrabar" value="Grabar Personal" onclick="javascript:mostrar()"/>

                            <br>

                            <div id="resultado"></div>

                        </form>

                    </div>
                </div>
            </div>

        </div>
        <footer class="text-center col-lg-12 ">
            <div class="bg-primary" >
                Copyright - GRUPO DE JAVA INTERMEDIO
            </div>
        </footer>
        <script type="text/javascript" src="jquery/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/npm.js"></script>  
    </body>

</html>
