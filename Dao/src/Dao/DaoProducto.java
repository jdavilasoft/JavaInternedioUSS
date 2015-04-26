/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import AccesoDatos.Conexion;
import Bean.BeanCliente;
import Bean.BeanProducto;
import java.sql.ResultSet;

public class DaoProducto {


    DaoConexion dConexion=new DaoConexion();

    public void ingresarProducto(BeanProducto bProducto) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO producto("
                + "             catcodigo, nomprod, precprod, stockactualprod, descprod,"
                + "            estadopro, desckar)"
                + "    VALUES (" + bProducto.getCategoriaProducto().getCatCodigo() + ", '" + bProducto.getNomProd() + "', '" + bProducto.getPrecProd() + "', " + bProducto.getStockActualProd() + ", '" + bProducto.getDescProd() + "', '" + bProducto.getEstadoProd() + "',"
                + "             '" + bProducto.getDesckar() + "');");
    }

    public String actualizarProducto(BeanProducto bProducto) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE producto"
                + "   SET catcodigo=" + bProducto.getCategoriaProducto() + ", nomprod='" + bProducto.getNomProd() + "', precprod='" + bProducto.getPrecProd() + "', stockactualprod=" + bProducto.getStockActualProd() + ", "
                + "       descprod='" + bProducto.getDescProd() + "', estadopro='" + bProducto.getEstadoProd() + "', desckar='" + bProducto.getDesckar() + "' "
                + " WHERE codprod=" + bProducto.getCodProd() + "");
        return "Successful Updated Row(s)..";
    }

    public Integer eliminarProducto(Integer codProd) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("DELETE FROM producto"
                + " WHERE codProd=" + codProd + "");
        return 1;
    }
}
