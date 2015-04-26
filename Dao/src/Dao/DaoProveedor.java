/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import AccesoDatos.Conexion;
import Bean.BeanProveedor;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class DaoProveedor {
    
    DaoConexion dConexion=new DaoConexion();
   
    public void ingresarProveedor(BeanProveedor bProveedor) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO proveedor("
                + "razsocialprov, contacprov, telprov, dirprov, celrpmprov, rucprov)"
                + "VALUES ('" + bProveedor.getRazonSocial()+"', '"+bProveedor.getContacProv()+"', '"
                +bProveedor.getTelProv()+"', '"+bProveedor.getDirProv()+"', '"
                +bProveedor.getCelProv()+"', '"+bProveedor.getRucProv()+ "')");
    }

    public String actualizarProveedor(BeanProveedor bProveedor) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE proveedor"
                + "SET razsocialprov= '" + bProveedor.getRazonSocial()+"',"
                + " contacprov= '" + bProveedor.getContacProv() +"', "
                + "telprov= '" + bProveedor.getTelProv() + "', "
                + "dirprov= '" + bProveedor.getDirProv() + "',"
                + "celrpmprov= '" + bProveedor.getCelProv()+ "',"
                + "rucprov= '" + bProveedor.getRucProv()+ "',"
                + " WHERE codprov= " + bProveedor.getCodProv()+"");
        return "Actualizado Correctamente";
    }

    public Integer eliminarProveedor(Integer codProv) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("DELETE FROM proveedor\n"
                + " WHERE codprov=" + codProv);
        return 1;
    }

    public ResultSet listarProveedor() throws Exception {
        
         dConexion.conn.Conectar();
         ResultSet  res=dConexion.conn.ejecutarListas("SELECT codprov, razsocialprov, contacprov, telprov, "
                                            + "dirprov, celrpmprov, rucprov  FROM proveedor");
       
        return res;
    }


      
    
    
    
    
    
    
    
    public ResultSet buscarCliente() {

        return null;
    }

    
    
    
    
        
    
    
    
}
