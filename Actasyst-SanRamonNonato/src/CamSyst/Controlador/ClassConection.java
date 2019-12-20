
package CamSyst.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {
    Connection cn;
    
    public Connection conecion(){
     
 
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=SpareSystem;","sa","admin010225");
         
        System.out.println("Conexion exitosa!!");
         }catch(  ClassNotFoundException | SQLException c){
         }
        
    return cn;
    }
    public void cerrarConexion() throws SQLException {
        cn.commit();
	}

}

        