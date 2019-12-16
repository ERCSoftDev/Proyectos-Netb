
package CamSyst.Controlador;

import CamSyst.Vista.CamS;
import CamSyst.Vista.Login_CamSyst;
import javax.swing.UIManager;

public class CamSyst {

    public static void main(String[] args) {
        
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
               UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
       
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CamS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
      
        Login_CamSyst as =new Login_CamSyst();
        as.setLocationRelativeTo(null);
        as.show();
    }
}
