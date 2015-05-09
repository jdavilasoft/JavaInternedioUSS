
package Dao;

import Bean.BeanUsuario;
import java.sql.ResultSet;


public class DaoUsuario {
    DaoConexion dConexion = new DaoConexion();
    
    public ResultSet loguearse(BeanUsuario bUsuario) throws Exception {
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("select user_login, codper from usuario"
            + " where user_login='" + bUsuario.getUserLogin() + "' and user_pass=md5('" + bUsuario.getContrasenia() + "')");
        return rs;
    }
}
