/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividad1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SrBri
 */
public class ConexionDB {
    private static ConexionDB conexionDB=null;
    
    public static ConexionDB getInstance(){
        if(conexionDB==null)
            conexionDB = new ConexionDB ();  
        
        return conexionDB;
    }
    
    private  String url="jdbc:postgresql://localhost:7000/personas";
    private Connection con = null;
    private String usr="postgres";
    private String psw="postgres";
     
     private ConexionDB (){
          try {
            con = DriverManager.getConnection(url,usr,psw);
            Logger.getLogger(ConexionDB.class.getName()).log(
            Level.INFO,"Se conecto a la BD");
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
     } 
     
     public boolean execute(String sql){
         Statement st=null;
         try{
         st = con.createStatement();
         st.execute(sql);
         return true;
         }catch(SQLException ex){
              Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
              return false;
         } 
         finally{
             if(st!=null){
                 try {
                     st.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
     }
    
}
