
package CamSyst.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {
    Connection cn;
    
    public Connection conecion(String user, String password){
     
    String usuario=user;
    String contrasena=password;
  
    //DESKTOP-6GQ3AI7    
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://Vigilandotech:1433;DatabaseName=prucamsyst;",usuario,contrasena);
        System.out.println("Conexion exitosa!!");
         }catch(  ClassNotFoundException | SQLException c){
             c.printStackTrace();
         }
        
    return cn;
    }
    public void cerrarConexion() throws SQLException {
        cn.commit();
	}

}

        