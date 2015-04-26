/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import AccesoDatos.Conexion;

/**
 *
 * @author MELANI
 */
public class DaoConexion {
   Conexion conn = new Conexion("org.postgresql.Driver", "jdbc:postgresql://", "127.0.0.1", "5432", "javaintermedio", "postgres", "123456"); 
}
