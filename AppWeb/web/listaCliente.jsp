<%-- 
    Document   : listaCliente
    Created on : 07/03/2015, 08:42:11 PM
    Author     : PAUL
--%>

<%@page import="Bean.BeanCliente"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="Logica.LogicaCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de clientes</h1>
        <table>
            <tr>
                <td>Codigo</td>
                <td>Nombres</td>
                <td>Apellidos</td>
                <td>Sexo</td>
            </tr>
            <tbody> 
                <c:forEach var="BeanCliente" items="${listaCliente}">
                    <tr>
                        
                        <td><c:if test="${BeanCliente.codCliente}"></c:if></td>
                        <td>${BeanCliente.nomCli}</td>
                        <td>${BeanCliente.apeCli}</td>
                        <td>${BeanCliente.sexo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
         <table>
            <tr><td>Codigo</td><td>Nombres</td><td>Apellidos</td><td>Sexo</td>
            </tr>
            <tbody> 
                <% LogicaCliente lCliente=new LogicaCliente();
                List<BeanCliente> lstCliente=lCliente.listarCliente();
                for(int i=0;i<lstCliente.size();i++){%>
                <tr>
                    <td><%=lstCliente.get(i).getCodCliente()%></td>  
                    <td><%=lstCliente.get(i).getNomCli()%></td>  
                    <td><%=lstCliente.get(i).getApeCli()%></td>  
                    <td><%=lstCliente.get(i).getSexo()%></td>  
                </tr>
                <%}%>
            </tbody>
         </table>
        
        
        
    </body>
</html>
