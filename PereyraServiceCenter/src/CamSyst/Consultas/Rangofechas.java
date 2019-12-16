
package CamSyst.Consultas;

import CamSyst.Controlador.ClassConection;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Rangofechas extends javax.swing.JInternalFrame {

 ClassConection conectar=new ClassConection();
 public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
   
    public Rangofechas() {
        cn=conectar.conecion();
        initComponents();
    }

    private void convertirFechas(){
     String dia = Integer.toString(jDateChooser3.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jDateChooser3.getCalendar().get(Calendar.MONTH)+1);
    String year = Integer.toString(jDateChooser3.getCalendar().get(Calendar.YEAR));
    String fechaI = ( dia+ "/" + mes+ "/" + year);
    jTextField1.setText(fechaI);

    String diaf = Integer.toString(jDateChooser4.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mesf = Integer.toString(jDateChooser4.getCalendar().get(Calendar.MONTH)+1);
    String yearf = Integer.toString(jDateChooser4.getCalendar().get(Calendar.YEAR));
    String fechaF = (diaf+ "/" + mesf+ "/" + yearf);
    jTextField2.setText(fechaF);
    }
    private void buscarporFecha(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
        String in=jTextField1.getText();
     String f=jTextField2.getText();
        
         cts=cn.prepareCall("{call mostrarPorRangoFecha(?)}");
         
           cts.setString(1,in);
           cts.setString(2, f);
            r=cts.executeQuery();
          //  JOptionPane.showMessageDialog(this,"ESTOY VIVO POR AQUI!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
       while (r.next()){
           
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       ConsultaFacturaCli.jTable1.setModel(tabla);
       
       }catch (Exception e){}
       
    }
    private void registrarRango(){
    
         
        String fechai=jTextField1.getText();
        String fechaf=jTextField2.getText();

        
        try{
            cts=cn.prepareCall("{call registrarRangoF(?,?)}");
            cts.setString(1, fechai);
            cts.setString(2, fechaf);

            
            
            int opcion=cts.executeUpdate();
           // if (opcion==1)
             //  JOptionPane.showMessageDialog(null, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();

        popupMenu1.setLabel("popupMenu1");

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);

        jLabel1.setText("Desde:");

        jLabel2.setText("Al");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Introduzca un rango de fecha");

        jButton1.setBackground(new java.awt.Color(0, 153, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    convertirFechas();
   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           registrarRango();
        buscarporFecha();
    }//GEN-LAST:event_jButton2ActionPerformed

    
            public void run() {
                new Rangofechas().setVisible(true);
             
            }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
