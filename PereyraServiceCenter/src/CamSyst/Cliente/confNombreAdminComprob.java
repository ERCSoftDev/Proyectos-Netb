
package CamSyst.Cliente;

import CamSyst.Controlador.ClassConection;
import CamSyst.Vista.CamS;
import com.sun.glass.events.KeyEvent;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class confNombreAdminComprob extends javax.swing.JInternalFrame {
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
   public static String sql;

 ClassConection conectar=new ClassConection();
 
    public confNombreAdminComprob() {
        initComponents();

        this.setLocation(380,120);
        cn=conectar.conecion();
    }
    private void llamada(){
        
        Factura.agregarDetSusp();
        Factura.agregarFacCliSusp();
        Factura.limpiar();  
        JOptionPane.showMessageDialog(null, "GRACIAS POR SU COMPRA...");
        JOptionPane.showMessageDialog(this, "DIRIJASE CAJA");
        this.dispose(); 

}
    private void registarNombre(){
     String codcli=   Factura.JLB_codCliente.getText();
     String n_fact=   Factura.jTextField4.getText();
     String nombre=   jTextField1.getText();   
     String total=    Factura.jtf_total.getText();
     String fecha=    Factura.jlb_fecha.getText();
     
     try{
            cts=cn.prepareCall("{call agregarNomFatSusp(?,?,?,?,?)}");
            cts.setString(1, codcli);
            cts.setString(2, n_fact);
            cts.setString(3, nombre);
            cts.setString(4, total);
            cts.setString(5, fecha);
          
            int opcion=cts.executeUpdate();
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos suspendidos"+e.getMessage());
           
        }
     // FacturaVendedor.limpiar(); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Enviar a caja");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Escriba el nombre:");

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_send-01_186386.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Presione Enter...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   // if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            Factura.numfac();
            Factura.numComprobF01();
            Factura.incrementarncf01();
            Factura.jTextField8.setText("COMPROBANTE FISCAL");  
            Factura.debitarProductos();
            Factura.agregarFacCli();
            Factura.agregarDETALLE();
            //registarNombre();
            //llamada();
             Factura.limpiar();
            Factura.datocli();  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER && Factura.formaPago.getSelectedItem().equals("Contado")) {
        try {      
           PagoAdminComprobante bs = new PagoAdminComprobante();
           CamS.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
           Factura.operaci5();
           Factura.jTextField8.setText("COMPROBANTE FISCAL");
           PagoAdmin.jTextField2.requestFocusInWindow();
           PagoAdmin.jTextField4.setEnabled(false);
           PagoAdmin.jTextField5.setEnabled(false);
       } catch (Exception e){}
        dispose();
       PagoAdmin.jTextField4.setEnabled(false);
       PagoAdmin.jTextField5.setEnabled(false);
         }else if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        Factura.numfac();
            Factura.numComprobF01();
            Factura.incrementarncf01();
            Factura.jTextField8.setText("COMPROBANTE FISCAL");  
            Factura.debitarProductos();
            Factura.agregarFacCli();
            Factura.agregarDETALLE();
            Factura.imprimir();
            Factura.limpiar();
        JOptionPane.showMessageDialog(null, "GRACIAS POR SU COMPRA...");
        dispose(); 
         }                
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(confNombreAdminComprob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confNombreAdminComprob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confNombreAdminComprob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confNombreAdminComprob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confNombreAdminComprob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
