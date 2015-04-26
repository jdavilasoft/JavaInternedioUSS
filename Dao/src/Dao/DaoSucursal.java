/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import AccesoDatos.Conexion;
import Bean.BeanSucursal;
import java.sql.ResultSet;

/**
 *
 * @author Alumno
 */ 
public class DaoSucursal {
 DaoConexion dConexion=new DaoConexion();

     public void ingresarSucursal(BeanSucursal bSucursal) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO sucursal("
                + "nomsuc, dirsuc, seriefactsuc, seriebolsuc, estadosuc,"
                + "serienota, nunfact, numbol, numtic)"
                +"VALUES (" +bSucursal.getNomSuc()+ ", " +bSucursal.getDirSuc()+ ","
                +bSucursal.getSerieFactSuc()+ "," +bSucursal.getSerieBolSuc()+ "," + bSucursal.getEstadoSuc() + ","
                + bSucursal.getSerieNota()+ "," +bSucursal.getNunFact()+ "," + bSucursal.getNumBol() + ","
                + bSucursal.getNumTic() + ")");
    }

    public String actualizarSucursal(BeanSucursal bSucursal) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE sucursal"
                + "SET nomsuc=" + bSucursal.getNomSuc()+ ", dirsuc=" + bSucursal.getDirSuc()+ ", seriefactsuc=" + bSucursal.getSerieFactSuc()+ ", seriebolsuc=" + bSucursal.getSerieBolSuc() + ""
                + ", estadosuc=" + bSucursal.getEstadoSuc()+", serienota="+bSucursal.getSerieNota()+",nunfact="+bSucursal.getNunFact()+",numbol="+bSucursal.getNumBol()+",numtic="+bSucursal.getNumTic()+""
                + " WHERE codsuc=" + bSucursal.getCodSuc());
        return "Actualizado Correctamente";
    }

    
    public Integer eliminarSucursal(Integer codCliente) {

        return 1; //Para Sucursal eliminada
    }

   public ResultSet listar() throws Exception {
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("select codsuc, nomsuc, dirsuc, seriefactsuc, seriebolsuc, estadosuc, serienota from sucursalr order by nomsuc asc");
        return rs;
    }

    public ResultSet buscarCliente() {

        return null;
    }

}
