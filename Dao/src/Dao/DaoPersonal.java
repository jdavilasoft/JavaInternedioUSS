package Dao;

import Bean.BeanPersonal;
import java.sql.ResultSet;

public class DaoPersonal {

    DaoConexion dConexion = new DaoConexion();

    public void ingresarPersonal(BeanPersonal bPersonal) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("INSERT INTO personal("
                + "nomper, apeper, dirper, estadoper, sexo, dni)"
                + "VALUES ('"
                + bPersonal.getNomPer() + "','"
                + bPersonal.getApePer() + "','"
                + bPersonal.getDirPer() + "','"
                + bPersonal.getEstadoPer() + "','"
                + bPersonal.getSexo() + "',"
                + bPersonal.getDni() + ")");
    }

    public String actualizarPersonal(BeanPersonal bPersonal) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("UPDATE personal"
                + "SET nomper='" + bPersonal.getNomPer() + "', apeper='" + bPersonal.getApePer() + "', dirper='" + bPersonal.getDirPer() + "'"
                + ",estadoper='" + bPersonal.getEstadoPer() + ", sexo='" + bPersonal.getSexo() + "', dni='" + bPersonal.getDni()
                + " WHERE codper=" + bPersonal.getCodPer());
        return "Actualizado Correctamente";
    }

    public Integer eliminarPersonal(Integer codPer) throws Exception {
        dConexion.conn.Conectar();
        dConexion.conn.ejecutarActualizacion("DELETE FROM"
                + " WHERE codPer=" + codPer);
        return 1; //Para Personal Eliminado
    }

    public ResultSet listarPersonal() throws Exception {
        dConexion.conn.Conectar();
        ResultSet rs;
        rs = dConexion.conn.ejecutarListas("SELECT codper, nomper, apeper, dirper, estadoper, sexo, dni FROM personal");
        return rs;
    }

    public ResultSet buscarPersonal() {

        return null;
    }

}
