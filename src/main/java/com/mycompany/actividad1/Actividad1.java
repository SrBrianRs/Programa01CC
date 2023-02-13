/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.actividad1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SrBri
 */
public class Actividad1 {

    public static void main(String[] args) {
           ConexionDB con = ConexionDB.getInstance();
    String sql = "insert into empleados (id, nombre, direccion, telefono)" + 
            "values"
            +"('1','Brian','La quemada', '27227225151')";
    boolean res = con.execute(sql);
    if(res)
        Logger.getLogger("Principal").log(Level.INFO,"Se guardo");
    else
        Logger.getLogger("Principal").log(Level.SEVERE,"Se guardo");
    }
}
