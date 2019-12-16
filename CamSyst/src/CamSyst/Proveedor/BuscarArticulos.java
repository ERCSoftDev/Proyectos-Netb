
package CamSyst.Proveedor;

import static CamSyst.Vista.CamS.jDesktopPane1;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Productos;
import java.awt.event.KeyEvent;

public final class BuscarArticulos extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    Connection cn;
    CallableStatement cts;
    ResultSet r;
    
    String userName;
    String passWord;
public BuscarArticulos(String user, String password) throws SQLException {
    initComponents();
        userName = user;
        passWord = password;
    cn=conectar.conecion(user,password);
    cargar();
}

   // BuscarArticulos() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }
 public void cargar(){
        
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALLE"); 
       tabla.addColumn("PROVEEDOR");
       tabla.addColumn("PRECIO COSTO");
       tabla.addColumn("PRECIO LISTA");
       tabla.addColumn("PORCIENTO%");
       tabla.addColumn("STOCK");
       
       cts=cn.prepareCall("{call mostrarpro2}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
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
        jLabel2 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Busqueda de Articulos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre producto:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar articulo");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 204, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTable1.setForeground(new java.awt.Color(51, 51, 51));
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
        jTable1.setGridColor(new java.awt.Color(255, 255, 204));
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

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new-file.png"))); // NOI18N
        jButton2.setToolTipText("Crear un producto si no existe");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(6, 6, 6)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    
    private void Selecionaarticulo(){
     
       
        DefaultTableModel modelo = (DefaultTableModel) Pedidos.jtableDetalle.getModel();
        int row=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(row, 0). toString();
        String nom=jTable1.getValueAt(row, 1).toString();
        String det=jTable1.getValueAt(row, 2).toString();
        String prov=jTable1.getValueAt(row,3).toString();
        String pre=jTable1.getValueAt(row, 4).toString();
        String preL= jTable1.getValueAt(row, 5).toString();
     //   Pedidos.jtableDetalle.requestFocus();
        //Pedidos.changeSelection(row,4);
      //  Pedidos.jtableDetalle.editCellAt(row,4);  
        
         int i=0; 
         i=i+1;
         Object[]  dato=new Object[8];
         
            dato[0]=id;
            dato[1]=nom;
            dato[2]=det;
            dato[3]=prov;            
            dato[4]=1;
            dato[5]=pre;
            dato[6]=preL;
            dato[7]="";
            
            
            modelo.addRow(dato);
            Pedidos.jtableDetalle.setModel(modelo);
           /// Pedidos.jtableDetalle.requestFocusInWindow();//requestFocus();
         //   Pedidos.jtableDetalle.editCellAt(row,4);
         //   Pedidos.jtableDetalle.editCellAt(i, 4);//editCellAt(colunm, 2);
            Pedidos.ajustarcolumnas();
             
            this.dispose();
           

         
       
 }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       String x=jTextField1.getText();
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALE");  
       tabla.addColumn("PROVEEDOR");
       tabla.addColumn("PRECIO");
       tabla.addColumn("STOCK");
       
      
      
         cts=cn.prepareCall("{call buscarpro(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[6];
       for (int i=0; i<6; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        
        Selecionaarticulo();  
        Pedidos.operac();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        Productos f=new Productos(this.userName,this.passWord);
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
         char teclapre=evt.getKeyChar();
        if((teclapre) == KeyEvent.VK_ENTER) {
     String x=jTextField1.getText();
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALE");  
       tabla.addColumn("PROVEEDOR");
       tabla.addColumn("PRECIO");
       tabla.addColumn("STOCK");
       
      
      
         cts=cn.prepareCall("{call buscarpro(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[6];
       for (int i=0; i<6; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
    }                                   
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        
       Selecionaarticulo();
       Pedidos.operac();
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       Pedidos.operac();
    }//GEN-LAST:event_jTable1KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}