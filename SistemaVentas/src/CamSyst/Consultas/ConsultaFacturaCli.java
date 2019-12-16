
package CamSyst.Consultas;

import CamSyst.Vista.CamS;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Cliente.Factura;
import CamSyst.Proveedor.MostrarFactura;
import CamSyst.Controlador.Reportes;

public class ConsultaFacturaCli extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    String userName;
    String passWord;
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
    public ConsultaFacturaCli() {
        initComponents();
       // userName=user;
       // passWord=password;
         jTextField1.setEnabled(false);
         cn=conectar.conecion();
         cargar();
    }

    
     private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Cod-Provee");
       tabla.addColumn("TEL");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
         cts=cn.prepareCall("{call mostrartodasFacturacli}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[10];
       for (int i=0; i<10; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
   
       }catch (Exception e){}}
     
     
public static void Dias(){
    //String x=MostrarFactura.lbl_nFactuta.getText();
    try {
             cts=cn.prepareCall("DiasPagar");
             //cts.setString(1,x);
             r=cts.executeQuery();
        
          MostrarFactura.jTextField2.setText(r.getString(1));
 } catch (SQLException ex) {
        }
    
    }
 
private void mostrarDetallefacturacli(){
     MostrarFactura mf = new MostrarFactura();
                
         try {
            
       int row=jTable1.getSelectedRow();
       
        String idf=     jTable1.getValueAt(row, 0).toString();
        String fecha=   jTable1.getValueAt(row, 1).toString();
        String idcli=   jTable1.getValueAt(row, 2).toString();
        String ruccli=  jTable1.getValueAt(row, 3).toString();
        String fp=      jTable1.getValueAt(row, 4).toString();
        String sub_to=  jTable1.getValueAt(row, 5).toString();
        String desc=    jTable1.getValueAt(row, 6).toString();
        String igv=     jTable1.getValueAt(row, 7).toString();
        String tot_a_pa=jTable1.getValueAt(row, 8).toString();
        String fep=     jTable1.getValueAt(row, 9).toString();
        //String itb=     jTable1.getValueAt(row, 9).toString();
      
        DefaultTableModel tabla = (DefaultTableModel) MostrarFactura.jtableDetalle.getModel();
        try
       {
        cts=cn.prepareCall("{call mostrarDeta(?)}");
        cts.setString(1, idf);
        r=cts.executeQuery();
        
       while (r.next()){
       Object dato[]=new  Object[10];
       for (int i=0; i<10; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       
       MostrarFactura.jtableDetalle .setModel(tabla);
       
       MostrarFactura.lbl_nFactuta  .setText(idf);
       MostrarFactura.JLB_codCliente.setText(idcli);
       MostrarFactura.jlb_ruc       .setText(ruccli);
       MostrarFactura.jTextField1   .setText(fp);
       MostrarFactura.lbl_Fecha     .setText(fecha);
       MostrarFactura.jlb_subtotal  .setText(sub_to);
       MostrarFactura.jlb_des       .setText(desc);
       MostrarFactura.jlb_igv       .setText(igv);
       MostrarFactura.jlb_total     .setText(tot_a_pa);
       MostrarFactura.jTextField2   .setText(fep);
       
  }catch (Exception e){}
        } catch (Exception ex) {
        
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
           CamS.jDesktopPane1.add(mf);
        mf.toFront();
        mf.setLocation(50,10);
        mf.setVisible(true);
       // this.dispose();
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        jLabel1.setText("jLabel1");

        jMenuItem1.setText("Mostrar detalles de factura");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar Factura");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377296_printer.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir facturas de clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Mostrar por N° factura:");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar factura");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Mostrar por Fecha:");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Mostrar todas las facturas.");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1))
                        .addGap(47, 47, 47)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(564, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jRadioButton3))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String X=jTextField1.getText();
                
      if (jRadioButton1.isSelected()==true){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField1.requestFocus();
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Cod-Provee");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
         cts=cn.prepareCall("{call mostrarFacturacli(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[9];
       for (int i=0; i<9; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
    else if(jRadioButton2.isSelected()==true){
        jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField1.requestFocus();
     DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Cod-Provee");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
             cts=cn.prepareCall("{call mostrarFechacli(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[9];
       for (int i=0; i<9; i++){
           dato[i]=r.getDate(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
    
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
      mostrarDetallefacturacli();
      Dias();
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        cargar();
        jTextField1.setText("");
                jTextField1.setEnabled(false);
             
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
       
        jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField1.requestFocus();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField1.requestFocus();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     
          DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                  int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA ELIMINAR ESTA FACTURA","ALERTA!",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
    
     int opcion2=JOptionPane.showConfirmDialog(null,"LA FACTURA SERA ELIMINADA DE TODAS LAS CUENTAS","PELIGRO!",JOptionPane.YES_NO_OPTION);
if(opcion2==JOptionPane.YES_NO_OPTION)
      try {
            int row=jTable1.getSelectedRow();
         String idf=jTable1.getValueAt(row, 0).toString();
            cts=cn.prepareCall("{ call deletefactcli(?)}");
            cts.setString(1, idf);
            int rpta=cts.executeUpdate();

            if(rpta==1){
            JOptionPane.showMessageDialog(this, "Factura Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
          //ahora obtenemos la fila selccionada
       if(row<0){
            // no se puede eliminar
            JOptionPane.showMessageDialog(this,"Tabla vacia o no ha seleccionado uan fila.");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(row);
        }
        
            
                    }else {
             JOptionPane.showMessageDialog(this, "Factura No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
    String rutaInforme= "C:\\Program Files\\Camsyst\\Reportes\\ReportFacturasCliente.jrxml";
        Reportes re= new Reportes();
        re.verReporte5(rutaInforme);

        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
