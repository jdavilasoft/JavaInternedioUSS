/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Bean.BeanCliente;
import Bean.BeanProducto;
import Dao.DaoCliente;
import Dao.DaoProducto;

public class logicaProducto {

    DaoProducto dProducto;

    public void insertar(BeanProducto bProducto) throws Exception {
        dProducto = new DaoProducto();
        dProducto.ingresarProducto(bProducto);
    }

    public String actualizar(BeanProducto wProducto) throws Exception {
        dProducto = new DaoProducto();
        String msje = dProducto.actualizarProducto(wProducto);
        return msje;
    }

    public Integer eliminar(int codigo) throws Exception {
        dProducto = new DaoProducto();
        int valor = dProducto.eliminarProducto(codigo);
        return valor;
    }
}
