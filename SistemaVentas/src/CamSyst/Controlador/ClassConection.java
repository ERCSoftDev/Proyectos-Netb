
package CamSyst.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {
    Connection cn;
    
    public Connection conecion(){
     
   // String usuario=user;
 //   String contrasena=password;'
  
    //DESKTOP-6GQ3AI7    
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=prucamsyst;","sa","admin010225");
        System.out.println("Conexion exitosa!!");
         }catch(  ClassNotFoundException | SQLException c){
         }
        
    return cn;
    }
    public void cerrarConexion() throws SQLException {
        cn.commit();
	}

}

        