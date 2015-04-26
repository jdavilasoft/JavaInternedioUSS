
package Dao;

import AccesoDatos.Conexion;
import Bean.BeanCatProducto;
import java.sql.ResultSet;

public class DaoCat_producto {
     DaoConexion dConexion=new DaoConexion();

public void ingresarCatProducto(BeanCatProducto bCatProducto) throws Exception{
    dConexion.conn.Conectar();
    dConexion.conn.ejecutarActualizacion("INSERT INTO cat_producto("
            +"cat_descripcion)"
            +"VALUES ("+bCatProducto.getCatDescripcion()+")");

}
public String actualizarCatProducto(BeanCatProducto bCatProducto) throws Exception{
    dConexion.conn.Conectar();
    dConexion.conn.ejecutarActualizacion("UPDATE cat_producto"
   +"SET cat_descripcion="+bCatProducto.getCatDescripcion()+""
   +"WHERE catcodigo="+bCatProducto.getCatCodigo());
     return "Actualizado Correctamente";
}

public Integer eliminarCatProducto(Integer catCodigo )throws Exception{
    dConexion.conn.Conectar();
    dConexion.conn.ejecutarActualizacion("DELETE FROM cat_producto\n"
    +"WHERE catcodigo="+catCodigo);
         return 1;
    
}
public ResultSet listarcatProducto() {

        return null;
    }

    public ResultSet buscarCatProducto() {

        return null;
    }

}
