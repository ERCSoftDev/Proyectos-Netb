
package CamSyst.Controlador;

import CamSyst.Vista.CamS;
import CamSyst.Vista.Login_CamSyst;
import com.alee.laf.WebLookAndFeel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CamSyst {

    public static void main(String[] args) {
       // SwingUtilities.invokeLater( nuevo  Runnable ()
        {
           // @Override 
            //public  void run ()
            {
                // Instalar WebLaF como aplicación LaF 
                //WebLookAndFeel.install();

                // También puede hacerlo de una de las formas anticuadas: 
                // UIManager.setLookAndFeel (new WebLookAndFeel ()); 
                // UIManager.setLookAndFeel ("com.alee.laf.WebLookAndFeel"); 
                // UIManager.setLookAndFeel (WebLookAndFeel.class.getCanonicalName ());

                // Cree su aplicación aquí usando componentes Swing 
                // JFrame frame = ...

                // O use componentes similares de Web * para obtener acceso a algunas características extendidas 
                // WebFrame frame = ...
            }
        //});
        
        
        try {
           //  WebLookAndFeel.install();
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
            //    JFrame.setDefaultLookAndFeelDecorated(true);
             //   JDialog.setDefaultLookAndFeelDecorated(true);
             // UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
           //  UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
           //   UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
       
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
           java.util.logging.Logger.getLogger(CamS.class.getName()).log(java.util.logging.Level.SEVERE, null,ex);
        
          }
      
        Login_CamSyst as =new Login_CamSyst();
        as.setLocationRelativeTo(null);
        as.show();
   }
}}
