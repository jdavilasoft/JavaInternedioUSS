<%-- 
    Document   : listaPersonal
    Created on : 09/05/2015, 10:50:46 AM
    Author     : javierdt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Personal</title>
    </head>
    <body>
        <h1>Listado de Personal</h1>
        <table>
            <tr>
                <td>Codigo</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Sexo</td>
            </tr>
            <tbody>
                <c:forEach var="BeanPersonal" items="${listaPersonal}">
                    <tr>
                        <td>${BeanPersonal.codPer}</td>
                        <td>${BeanPersonal.nomPer}</td>
                        <td>${BeanPersonal.apePer}</td>
                        <td>${BeanPersonal.sexo}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>
