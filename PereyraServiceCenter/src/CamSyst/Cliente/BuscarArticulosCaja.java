
package CamSyst.Cliente;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Productos;
import CamSyst.Vista.Cajeros;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class BuscarArticulosCaja extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    Connection cn;
    CallableStatement cts;
    ResultSet r;
    
public BuscarArticulosCaja() throws SQLException {
    initComponents();
    cn=conectar.conecion();
    cargar();
}

 public void cargar(){
        
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALLE"); 
       tabla.addColumn("STOCK");
       tabla.addColumn("PRECIO");
       tabla.addColumn("ITBIS");
       tabla.addColumn("UBICACION");
       
       
     cts=cn.prepareCall("{call mostrarpro3}");
       r=cts.executeQuery();
       
       while (r.next()){
       Object dato[]=new  Object[7];
       for (int i=0; i<7; i++){
       dato[i]=r.getString(i+1);
}
       tabla.addRow(dato);
}
       this.jTable1.setModel(tabla);
     
       
       }catch (Exception e){}
 }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("Actualizar");
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exportar Registro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setClosable(true);
        setIconifiable(true);
        setTitle("BUSCAR ARTICULOS");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Busqueda de Articulos!");

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 0), 1, true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar producto");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Detalle", "Stock", "Precio"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setGridColor(new java.awt.Color(153, 204, 0));
        jTable1.setSelectionBackground(new java.awt.Color(153, 204, 0));
        jTable1.setShowHorizontalLines(false);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451536341_Add.png"))); // NOI18N
        jButton2.setToolTipText("Crear un producto");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setEnabled(false);
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
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(19, 19, 19)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void buscarart(){
    String x=jTextField1.getText();
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALE");  
       tabla.addColumn("STOCK");
       tabla.addColumn("PRECIO");
       tabla.addColumn("ITBIS");
       tabla.addColumn("UBICACION");
       
      
      
        cts=cn.prepareCall("{call buscarpro(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[7];
       for (int i=0; i<7; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
 }    
    
 public void verificaexistencia (){
     int row=jTable1.getSelectedRow();
     
 if(jTable1.getValueAt(row, 3).equals("0.0")){
 JOptionPane.showMessageDialog(null, "NO HAY EXISTENCIA DE ESTE PRODUCTO, REALICE UN PEDIDO","AVISO URGENTE",JOptionPane.INFORMATION_MESSAGE);
 dispose();
 }else
 Selecionaarticulo();
 }
 
 
    public void Selecionaarticulo(){
       
        DefaultTableModel modelo = (DefaultTableModel) FacturaCajeros.jtableDetalle.getModel();
        int row=jTable1.getSelectedRow();
        
        String id=jTable1.getValueAt(row, 0). toString();
        String nom=jTable1.getValueAt(row, 1).toString();
        String det=jTable1.getValueAt(row, 2).toString();
        String pre=jTable1.getValueAt(row, 4).toString();
        String Itbis=jTable1.getValueAt(row, 5).toString();
          
         int i=0; 
         i=i+1;
         Object[]  dato=new Object[6];
         
            dato[0]=id;
            dato[1]=nom;
            dato[2]=det;
            dato[3]=1;
            dato[4]=pre;
            dato[5]=Itbis;
 
            FacturaCajeros.operaci();
           // Factura.calcularpuntos();
            modelo.addRow(dato);
            FacturaCajeros.jtableDetalle.setModel(modelo);
            FacturaCajeros.ajustarcolumnas();
            dispose();
            FacturaCajeros.jTextField2.requestFocusInWindow();
   
 }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscarart();
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
      verificaexistencia ();   
      FacturaCajeros.operaci();
     FacturaCajeros.calcularpuntos();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        Productos f=new Productos();
        Cajeros.jDesktopPane1.add(f);
        f.setLocation(50, 5);  
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
     verificaexistencia ();
      FacturaCajeros.operaci();
      FacturaCajeros.calcularpuntos();
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           //buscarart(); 
           jTable1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       buscarart(); 
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           verificaexistencia ();
           FacturaCajeros.operaci();
           FacturaCajeros.calcularpuntos();
           jTextField1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
