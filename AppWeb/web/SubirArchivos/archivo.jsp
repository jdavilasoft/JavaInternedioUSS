<%-- 
    Document   : archivo
    Created on : 14/03/2015, 07:34:20 PM
    Author     : PAUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SUBIR ARCHIVOS</h1>
       <form method="post" action="../subirArchivo.cl" enctype="multipart/form-data">
            <input type="file" name="txtFile" id="txtFile"/>
            <input type="submit" name="btnSubir" id="btnSubir" value="Subir Archivo"/>
        </form>
        
    </body>
</html>
