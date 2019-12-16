
package CamSyst.Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes {
    Connection cn;
    Statement Instrucion;
    
    public Reportes(){
        try{
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=prucamsyst;","sa","admin010225");
         Instrucion = cn.createStatement();
        }catch(ClassNotFoundException|SQLException e){
            
            JOptionPane.showMessageDialog(null, e,"Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }


    public void verReporte(String ruta, Map parame){
     // JasperReport jr;
      /* Array para almacenar las impresoras del sistema */
         PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
         if( printService.length>0 )//si existen impresoras
         {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                     "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[1]);
             if( impresora != null ) //Si se selecciono una impresora
             {
        try{
           JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\FacturaGourmeticket.jrxml");
           JasperPrint jp = JasperFillManager.fillReport(jr, parame, cn);
            
           JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
           jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp );
          
           jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
           jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);    
           jrprintServiceExporter.exportReport();
        
         JasperViewer.viewReport(jp,false);
 
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.err.println("Error iReport: " + ex.getMessage() );
        }
         
             }}}
    public void verReporteCuadre(String ruta, Map parame){
     // JasperReport jr;
      /* Array para almacenar las impresoras del sistema */
         PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, null);
         if( printService.length>0 )//si existen impresoras
         {
            //se elige la impresora
            PrintService impresora = (PrintService) JOptionPane.showInputDialog(null, "Eliga impresora:",
                     "Imprimir Reporte", JOptionPane.QUESTION_MESSAGE, null, printService, printService[1]);
             if( impresora != null ) //Si se selecciono una impresora
             {
                // JasperReport jr;
        try{
           JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\CuadreF.jrxml");
           JasperPrint jp = JasperFillManager.fillReport(jr, parame, cn);
            
           JRPrintServiceExporter jrprintServiceExporter = new JRPrintServiceExporter();
           jrprintServiceExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp );
          
           jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, impresora );
           jrprintServiceExporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);    
           jrprintServiceExporter.exportReport();
        
         JasperViewer.viewReport(jp,false);
 
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.err.println("Error iReport: " + ex.getMessage() );
        }
         
             }}}
    
    public void verReport(String ruta, Map parame){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\FacturaPedidos.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parame, cn);
            JasperViewer.viewReport(jp,false);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            //Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void verReporte2(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\Listadoclientes.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte3(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\ReporteProveedor.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     //LISTADO DE PROVEEDORES 
     public void verReporte4(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Computech\\Desktop\\Nueva carpeta (4)\\cam\\SistemaVentas\\src\\Reportes\\Listadoproveedores.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte5(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\ReportFacturasCliente.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte6(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Users\\Computech\\Desktop\\Nueva carpeta (4)\\cam\\SistemaVentas\\src\\Reportes\\Listadoproductos.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte8(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\ReporteDeUsuarios.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte9(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\ReportRegistroFact.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
     public void verReporte10(String ruta){
        try{
            JasperReport jr = JasperCompileManager.compileReport("C:\\Program Files\\Camsyst\\Reportes\\ProductosPorPedir.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr,null, cn);
            JasperViewer.viewReport(jp,false);
            } catch (JRException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
           
        }
    }
   
}
