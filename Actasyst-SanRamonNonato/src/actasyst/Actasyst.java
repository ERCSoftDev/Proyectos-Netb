
package actasyst;

import actasyst.Vista.Login_CamSyst;
import javax.swing.UIManager;

public class Actasyst {

    public static void main(String[] args) {
         try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
          
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        Login_CamSyst as =new Login_CamSyst();
        as.setLocationRelativeTo(null);
        as.show();
    }
   
}
