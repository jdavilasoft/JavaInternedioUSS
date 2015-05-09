<%-- 
    Document   : login
    Created on : 25/04/2015, 08:49:11 PM
    Author     : javierdt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio de Sesión</title>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
        <link type="text/css" rel="stylesheet" href="css/stylesheet.css"/>
    </head>
    <body>
        
        <form method="POST" name="frmLogueo" id="frmLogueo" action="logueo.html">
            <div id="divprincipal" class="row">
                <div class="col-xs-12">
                    <div class="row">
                        <h4><center><label>Inicio de Sesión</label></center></h4>
                        <div class="col-xs-8">
                            <div class="form-group col-xs-12">
                                <label for="txtUsuario">Nombre de usuario</label>
                                <input class="form-control" type="text" name="txtUsuario" id="txtUsuario" placeholder="User"/>
                            </div>

                            <div class="form-group col-xs-12">
                                <label for="txtPass">Contraseña</label>
                                <input class="form-control" type="password" name="txtPass" id="txtPass" placeholder="Password"/>
                            </div>
                        </div>
                        <div id="imglogin" class="col-xs-4">
                            <img src="img/security.png" alt="imagen" width="140" height="140"/>
                        </div>
                    </div>
                </div>
                <div id="divderecha" class="form-group col-xs-10">
                    <input type="submit" class="btn btn-primary" name="btnLoguear" id="btnLoguear" value="Loguearse"/>
                </div>
            </div>
        </form>
        
        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="bootstrap/js/npm.js"></script>
    </body>
</html>
