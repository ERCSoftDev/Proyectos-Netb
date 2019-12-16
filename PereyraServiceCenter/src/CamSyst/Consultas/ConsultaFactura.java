
package CamSyst.Consultas;

import CamSyst.Administrador.AbonosProveedores;
import static CamSyst.Administrador.AbonosProveedores.jTextField5;
import CamSyst.Vista.CamS;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Cliente.Factura;
import CamSyst.Controlador.Reportes;
import CamSyst.Proveedor.MostrarFacturaProveedor;
import static CamSyst.Vista.CamS.jDesktopPane1;

public class ConsultaFactura extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
      String userName;
    String passWord;
    Connection cn;
    CallableStatement cts;
    ResultSet r;
    
    public ConsultaFactura() {
         initComponents();
        //userName=user;
        //passWord=password;
         jTextField1.setEnabled(false);
         cn=conectar.conecion();
         cargar();
    }

    
    private static double redondearSubtotal(double subtot,int numDecimal){

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*subtot+0.5)/p;
    
}
     private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Cod-Provee");
       tabla.addColumn("Tel");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Fecha de pago");
       
       cts=cn.prepareCall("{call buscarFactura}");
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
     private void factVencidas(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Proveedor");
       tabla.addColumn("Tel");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Fecha de pago");
       tabla.addColumn("Dias de atraso");
       
       
       cts=cn.prepareCall("{call buscarcxpPorVenc}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
   
       }catch (Exception e){}
     
     }
     private  void factporprov(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       String k=jTextField4.getText();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("Proveedor");
       tabla.addColumn("Tel");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Fecha de pago");
       
   
       cts=cn.prepareCall("{call buscarcxpPorprov(?)}");
       cts.setString(1, k);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[10];
       for (int i=0; i<10; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
   
       }catch (Exception e){}
       
      }
     private void enviarfactabono(){
      try {           
        int row=        jTable1.getSelectedRow();
        String nof=     jTable1.getValueAt(row, 0).toString();
        String fechafac=   jTable1.getValueAt(row, 1).toString();
        String nombreprov=     jTable1.getValueAt(row, 2).toString();
        String totalfact=   jTable1.getValueAt(row, 7).toString();
        
        AbonosProveedores.jTextField1.setText(nof);
        AbonosProveedores.jTextField2.setText(fechafac);
        AbonosProveedores.jTextField3.setText(nombreprov);
        AbonosProveedores.jTextField5.setText(totalfact);
        
        double x = Double.parseDouble(jTextField5.getText());
        AbonosProveedores.jTextField5.setText(""+redondearSubtotal(x,2));

        
        
        }catch(Exception e){}
      
}
 
private void mostrarDetallefactura(){
     MostrarFacturaProveedor mf = new MostrarFacturaProveedor();
                
        try {           
        int row=        jTable1.getSelectedRow();
        String idf=     jTable1.getValueAt(row, 0).toString();
        String fecha=   jTable1.getValueAt(row, 1).toString();
        String idcli=   jTable1.getValueAt(row, 2).toString();
        String ruccli=  jTable1.getValueAt(row, 3).toString();
        String sub_to=  jTable1.getValueAt(row, 4).toString();
        String desc=    jTable1.getValueAt(row, 5).toString();
        String igv=     jTable1.getValueAt(row, 6).toString();
        String tot_a_pa=jTable1.getValueAt(row, 7).toString();
        String formap=jTable1.getValueAt(row, 8).toString();
        String fechap=jTable1.getValueAt(row, 9).toString();
        
        DefaultTableModel tabla = (DefaultTableModel) MostrarFacturaProveedor.jtableDetalle.getModel();
      
        try
       {
        cts=cn.prepareCall("{call mostrarFactura(?)}");
        cts.setString(1, idf);
        r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[5];
       for (int i=0; i<5; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       
       MostrarFacturaProveedor.jtableDetalle.setModel(tabla);
       
       MostrarFacturaProveedor.lbl_nFactuta.setText(idf);
       MostrarFacturaProveedor.jTextField2.setText(fecha);
       MostrarFacturaProveedor.JLB_codCliente.setText(idcli);
       MostrarFacturaProveedor.jlb_ruc.setText(ruccli);
       MostrarFacturaProveedor.lbl_Fecha.setText(fechap);
       MostrarFacturaProveedor.jlb_subtotal.setText(sub_to);
       MostrarFacturaProveedor.jlb_des.setText(desc);
       MostrarFacturaProveedor.jlb_igv.setText(igv);
       MostrarFacturaProveedor.jlb_total.setText(tot_a_pa);
       MostrarFacturaProveedor.jTextField1.setText(formap);
       
  }catch (Exception e){}
        } catch (Exception ex) {
        
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        CamS.jDesktopPane1.add(mf);
        mf.toFront();
        mf.setLocation(50,10);
        mf.setVisible(true);
        this.dispose();
       }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jPopupMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        jMenuItem3.setText("Realizar pago");
        jMenuItem3.setToolTipText("");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setGridColor(new java.awt.Color(153, 204, 255));
        jTable1.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jTable1.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jTable1.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1114, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Opcion de busqueda"));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas las facturas", "fact. Vencidas", "Por.proveedor", "por condicion" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Desde:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Hasta:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar factura");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 191, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377296_printer.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir facturas de proveedores");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
      mostrarDetallefactura();
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
    String rutaInforme= "C:\\Program Files\\Camsyst\\Reportes\\FactProveedores.jrxml";
        Reportes re= new Reportes();
        //Map parametros = new HashMap();
        //parametros.put(null,jTextField1.getText());
        re.verReporte4(rutaInforme);

        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
 if (jComboBox1.getSelectedItem().equals("Todas las facturas")){
              cargar();
              jTextField4.setText("");
              jTextField1.setText("");
              jTextField3.setText("");
              jTextField4.setEnabled(false); 
              jTextField1.setEnabled(false); 
              jTextField3.setEnabled(false); 
              jDateChooser1.setCalendar(null);
              jDateChooser2.setCalendar(null);
              jDateChooser1.setEnabled(false);
              jDateChooser2.setEnabled(false);     
              
 }else if (jComboBox1.getSelectedItem().equals("fact. Vencidas")){
              factVencidas();
              jTextField4.setText("");
              jTextField1.setText("");
              jTextField3.setText("");
              jTextField4.setEnabled(false); 
              jTextField1.setEnabled(false); 
              jTextField3.setEnabled(false); 
              jDateChooser1.setCalendar(null);
              jDateChooser2.setCalendar(null);
              jDateChooser1.setEnabled(false);
              jDateChooser2.setEnabled(false);     
              
 }else if (jComboBox1.getSelectedItem().equals("Por.proveedor")){
              factporprov();
              jTextField4.setText("");
              jTextField1.setText("");
              jTextField3.setText("");
              jTextField4.setEnabled(true); 
              jTextField1.setEnabled(false); 
              jTextField3.setEnabled(false); 
              jDateChooser1.setCalendar(null);
              jDateChooser2.setCalendar(null);
              jDateChooser1.setEnabled(false);
              jDateChooser2.setEnabled(false);     
              jTextField4.requestFocusInWindow();
             
               
   }        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
if(jComboBox1.getSelectedItem().equals("Por.proveedor")){  
        this.factporprov();
}
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      try{
        AbonosProveedores  p= new AbonosProveedores ();
        jDesktopPane1.add(p);
        p.setLocation(50, 5); 
        p.show();
        p.setVisible(true);
        enviarfactabono();
        
        AbonosProveedores.mostrarAbonos();
        AbonosProveedores.mostrarSaldo();
        AbonosProveedores.jTextField8.requestFocusInWindow();
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
