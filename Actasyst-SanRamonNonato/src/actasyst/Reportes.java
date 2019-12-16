
package actasyst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class Reportes {
    Connection cn;
    Statement Instrucion;
    
    public Reportes(){
        try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://Computech-PC:1433;DatabaseName=ActaPSRN;","Administrador","admin010225");
         Instrucion = cn.createStatement();             //10.0.0.10 para servidor parroquia
         }catch(ClassNotFoundException|SQLException e){
            
            JOptionPane.showMessageDialog(null, e,"Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }

   
    public void verReporte(String ruta, Map parame){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Computech\\Documents\\NetBeansProjects\\Actasyst-SanRamonNonato\\src\\Reportes\\Bautismos.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parame, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void verReporte2(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\ActaSyst\\Reportes\\CuadreDiario.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           // Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
