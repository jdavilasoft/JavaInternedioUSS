<%-- 
    Document   : index
    Created on : 26/10/2014, 10:47:37 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FORMULARIO</title>
    </head>
    <body>
        <a href="pagina.jsp">NUEVA PAGINA</a>
        <a href="listarCliente.cl">Listado de cliente</a>
        <h1>FORMULARIO CLIENTE</h1>
        <form method="Post" id="frm" name="frm" action="registrarCliente.cl">
            <label>Tipo Cliente</label>
            <select id="cmbTipo" name="cmbTipo">
                <option value="NAT">NATURAL</option>
                <option value="JUR">JURIDICA</option>
            </select>
            <br><br>
            <label>Nombre</label>
            <input type="text" name="txtNombre" id="txtNombre" >
            <br><br>
            <label>Apellidos</label>
            <input type="text" name="txtApellido" id="txtApellido" >
            <br><br>
             <label>Celular</label>
            <input type="text" name="txtCelular" id="txtCelular" />
            <br><br>
            <label>Direccion</label>
            <input type="text" name="txtDireccion" id="txtDireccion" />
            <br><br>
            <label>Email</label>
            <input type="text" name="txtEmail" id="txtEmail" />
            <br><br>
            <div id="divNatural"><hr>
                DATOS DE PERSONA NATURAL<br>
                <label>Dni</label>
                <input type="text" name="txtDni" id="txtDni">
                <br><br>
                <label>Sexo</label>
                <select id="cmbSexo" name="cmbSexo">
                    <option value="MASCULINO">MASCULINO</option>
                    <option value="FEMENINO">FEMENINO</option>
                </select><br><br><hr>
            </div>
            <div id="divJuridica">
                DATOS DE PERSONA JURICA<br>
                <label>RUC</label>
                <input type="text" name="txtRuc" id="txtRuc"/>
                <br><br>
                <label>RAZON SOCIAL</label>
                <input type="text" name="txtRazonSocial" id="txtRazonSocial"/>
                <br><br> <hr>
            </div>

           
            
            <input type="submit" id="btnRegistrar" name="btnRegistrar" value="Registrar"/>
            <button type="button" id="btnRegistrar" name="btnRegistrar" >Registrar </button>
        </form>

    </body>
</html>
