/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import AccesoDatos.Conexion;
import Bean.BeanInsumo;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */
public class DaoInsumo {
    DaoConexion dConexion=new DaoConexion();
    
    
    public void ingresarInsumo (BeanInsumo bInsumo) throws  Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO insumo(" 
                 + "nomins, cantins,fechavencins,unidmedins)"
                +"VALVUES ('"+bInsumo.getNomInsumo()+"',"+bInsumo.getCantInsumo()+",'"+bInsumo.getFechaVcmto()+"',"+bInsumo.getUnidMed()+"')");
        
        
    }
    public String actualizarInsumo(BeanInsumo bInsumo) throws Exception {
        
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE "
        +"SET nominsu='"+ bInsumo.getNomInsumo()+ "', cantins="+bInsumo.getCantInsumo()+",fechavencins='"+bInsumo.getFechaVcmto()
                +"',unidmedins="+bInsumo.getUnidMed());
        return "Actualizado Correctamente";
    }
    
    public Integer eliminarInsumo(Integer codInsumo)throws  Exception{
         dConexion.conn.Conectar();
       dConexion.conn.ejecutarActualizacion("DELETE FROM insumo\n"
                + " WHERE codins=" + codInsumo);
       return 1;
        
    }
    
    public ResultSet listarInsumo() {

        return null;
    }

    public ResultSet buscarInsumo() {

        return null;
    }

    

    
}
