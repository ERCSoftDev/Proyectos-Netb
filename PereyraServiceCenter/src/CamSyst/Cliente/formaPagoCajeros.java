
package CamSyst.Cliente;

import CamSyst.Consultas.ConsultaClientesrnc;
import CamSyst.Consultas.ConsultaClientesrncCajero;
import CamSyst.Controlador.ClassConection;
import CamSyst.Vista.Cajeros;
import static CamSyst.Vista.CamS.jDesktopPane1;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;


public class formaPagoCajeros extends javax.swing.JInternalFrame {

    static void setSelectedItem(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   ClassConection conectar=new ClassConection();
   CallableStatement cts;
   ResultSet r;
   Connection cn;
   String userName;
   String passWord;
  
    public formaPagoCajeros() {
        initComponents();
         this.setLocation(380,120);
        cn=conectar.conecion();
       // comprobante.numComprobF02();
        
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprobante");
        setAlignmentX(380.0F);
        setAlignmentY(190.0F);

        jButton1.setBackground(new java.awt.Color(102, 153, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Consumidor Final");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 153, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("Credito Fiscal");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 153, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("Gubernamental");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      if(FacturaCajeros.formaPago.getSelectedItem().equals("Contado")){
        try {  
           PagoCajeros bs = new PagoCajeros();
           Cajeros.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
           FacturaCajeros.operaci3();
           FacturaCajeros.jTextField8.setText("FACTURA DE CONSUMO");
           PagoCajeros.jTextField2.requestFocusInWindow();
           PagoCajeros.jTextField4.setEnabled(false);
           PagoCajeros.jTextField5.setEnabled(false);
       } catch (Exception e){}
        dispose();
        PagoCajeros.jTextField4.setEnabled(false);
       PagoCajeros.jTextField5.setEnabled(false);
}else if(FacturaCajeros.formaPago.getSelectedItem().equals("Credito")){
       FacturaCajeros.numfac();              
      FacturaCajeros.numComprobF02();
      FacturaCajeros.incrementarncf();
      FacturaCajeros.debitarProductos();
        FacturaCajeros.agregarFacCli();
        FacturaCajeros.agregarDETALLE();
        FacturaCajeros.imprimir();
        FacturaCajeros.limpiar();
        FacturaCajeros.avisocomprob();
        jButton1.setEnabled(false);
   dispose();
    }//GEN-LAST:event_jButton1MouseClicked
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
    
        try {
            ConsultaClientesrncCajero bs = new ConsultaClientesrncCajero();
           jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
           ConsultaClientesrnc.jTextField2.requestFocusInWindow();
       } catch (Exception e){}
         this.dispose();
         
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try {
            ConsultaClientesrncCajero bs = new ConsultaClientesrncCajero();
           Cajeros.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
           ConsultaClientesrncCajero.jTextField2.requestFocusInWindow();
       } catch (Exception e){}
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
