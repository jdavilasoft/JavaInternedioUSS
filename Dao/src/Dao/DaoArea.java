package Dao;

import AccesoDatos.Conexion;
import Bean.BeanArea;
import java.sql.ResultSet;


public class DaoArea {

    DaoConexion dConexion=new DaoConexion();

    public void ingresarArea(BeanArea bArea) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO area("
                + "descripcion)"
                + "VALUES (" + bArea.getDescripcion()+")");
    }
    
     public String actualizarArea(BeanArea bArea) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE area"
                + "SET descripcion=" + bArea.getDescripcion()+ ""
                + " WHERE codarea=" + bArea.getCodArea());
        return "Actualizado Correctamente";
    }
     
     public Integer eliminarArea(Integer codArea) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("DELETE FROM area\n"
                + " WHERE codarea=" + codArea);
        return 1; //Para Cliente Eliminado
    
    
}
     public ResultSet listarArea() {

        return null;
    }

    public ResultSet buscarArea() {

        return null;
    }

}
