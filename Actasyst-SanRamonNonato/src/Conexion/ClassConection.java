
package Conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClassConection {
    Connection cn;
    public Connection conecion(String user, String password){
        
         String usuario=user;
         String contrasena=password;
        
        
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://Computech-PC:1433;DatabaseName=ActaPSRN;",usuario,contrasena);
        System.out.println("Conexion exitosa!!");
        //JOptionPane.showMessageDialog(null,"Se a conectado a la base de datos PSRN");
        //10.0.0.10 para servidor parroquia
         }catch(  ClassNotFoundException | SQLException c){
         }
       return cn; 
    }
     public void cerrarConexion() throws SQLException {
        cn.commit();
	}
}
