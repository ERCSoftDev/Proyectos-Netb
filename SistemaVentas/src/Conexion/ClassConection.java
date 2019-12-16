/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author AVALOS
 */
public class ClassConection {
    public Connection conecion(){
        Connection cn = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://AVALOS-PC:1433;DatabaseName=proyectoI;","sa","123");
         }catch(  ClassNotFoundException | SQLException c){}
       return cn; 
    }
    
}
