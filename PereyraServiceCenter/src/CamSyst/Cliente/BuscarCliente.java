
package CamSyst.Cliente;

import java.sql.*;
import CamSyst.Controlador.ClassConection;
import CamSyst.Vista.Cajeros;
import CamSyst.Vista.CamS;
import CamSyst.Vista.vendedor;
import java.awt.event.KeyEvent;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class BuscarCliente extends javax.swing.JInternalFrame {
    ClassConection conectar=new ClassConection();
   Connection cn;
   CallableStatement cts;
   ResultSet r;
   
   ListSelectionModel lsClientes;
    String userName;
    String passWord;
   
    public BuscarCliente() {
        initComponents();
        cn=conectar.conecion();
        cargar();
    }

    public void SelecionaCLiente(){
        
       // DefaultTableModel modelo = (DefaultTableModel) Cotizacion.jtableDetalle.getModel();
        int row=BuscarCliente.jTable1.getSelectedRow();
        
        String id=BuscarCliente.jTable1.getValueAt(row, 0).toString();
        String nom=BuscarCliente.jTable1.getValueAt(row, 1).toString();
        String ape=BuscarCliente.jTable1.getValueAt(row, 2).toString();
        String ced=BuscarCliente.jTable1.getValueAt(row, 3).toString();
        String cel=BuscarCliente.jTable1.getValueAt(row, 5).toString();
        String dir=BuscarCliente.jTable1.getValueAt(row, 6).toString();
        String blue=BuscarCliente.jTable1.getValueAt(row, 7).toString();
      
         
         Factura.jLabel16.setText(nom+" "+ape);
         Factura.jLabel18.setText(ced);
         Factura.telefo.setText(cel);
         Factura.JLB_codCliente.setText(id);
         Factura.jLabel20.setText(dir);
         Factura.jTextField6.setText(blue);
         
       // modelo.addRow(modelo);
      //  Cotizacion.jtableDetalle.setModel(modelo); 
        dispose();

    }
    private void SelecionaCLienteCajeros(){
        
       // DefaultTableModel modelo = (DefaultTableModel) Cotizacion.jtableDetalle.getModel();
        int row=jTable1.getSelectedRow();
        String id=jTable1.getValueAt(row, 0).toString();
        String nom=jTable1.getValueAt(row, 1).toString();
        String ape=jTable1.getValueAt(row, 2).toString();
        String ced=jTable1.getValueAt(row, 3).toString();
        String cel=jTable1.getValueAt(row, 5).toString();
        String dir=jTable1.getValueAt(row, 6).toString();
        String blue=jTable1.getValueAt(row, 7).toString();
         
         FacturaCajeros.jLabel16.setText(nom+" "+ape);
         FacturaCajeros.jLabel18.setText(ced);
         FacturaCajeros.telefo.setText(cel);
         FacturaCajeros.JLB_codCliente.setText(id);
         FacturaCajeros.jLabel20.setText(dir);
         FacturaCajeros.jTextField6.setText(blue);
         
       // modelo.addRow(modelo);
      //  Cotizacion.jtableDetalle.setModel(modelo); 
//        dispose();

    }
    
    private void buscarcliente(){
        String Nombrecliente=jTextField1.getText();
        DefaultTableModel tabla= new DefaultTableModel();
       try{
        tabla.addColumn("CODIGO");
       tabla.addColumn("NOMBRES");
       tabla.addColumn("APELLIDOS");
    //   tabla.addColumn("SEXO");
       tabla.addColumn("CEDULA");
       tabla.addColumn("TELEFONO");
       tabla.addColumn("CEL");
    //   tabla.addColumn("E_MAIL");
       tabla.addColumn("DIRECCION");
       tabla.addColumn("CodigoBlue");
         cts=cn.prepareCall("{call buscarCliente(?)}");
            cts.setString(1, Nombrecliente);
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
    
private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("CODIGO");
       tabla.addColumn("NOMBRES");
       tabla.addColumn("APELLIDOS");
      // tabla.addColumn("SEXO");
       tabla.addColumn("CEDULA");
       tabla.addColumn("TELEFONO");
       tabla.addColumn("CEL");
    //   tabla.addColumn("E_MAIL");
       tabla.addColumn("DIRECCION");
       tabla.addColumn("CodigoBlue");
         cts=cn.prepareCall("{call mostrarCliente5}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       jLabel3.setText(""+jTable1.getRowCount());
       }catch (Exception e){}}    

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
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenuItem1.setText("Atualizar Registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
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
        jLabel1.setText("Busqueda de clientes");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 102, 0));
        jTextField1.setCaretColor(new java.awt.Color(255, 51, 51));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar clientes");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new-file.png"))); // NOI18N
        jButton2.setToolTipText("Crear un nuevo cliente");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("Clientes");
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setGridColor(new java.awt.Color(102, 153, 255));
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(102, 153, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setText("1000");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Clientes Registrados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1003, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(251, 251, 251)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
buscarcliente(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cliente cli=new cliente();
        CamS.jDesktopPane1.add(cli);
        cli.toFront();
        cli.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        cargar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        SelecionaCLiente();
        //FacturaVendedor.calcularpuntos();
        
        Factura.jTextField2.requestFocusInWindow();
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
      buscarcliente();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           //buscarart(); 
           BuscarCliente.jTable1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER) {        
        SelecionaCLiente();
        dispose();
        Factura.jTextField2.requestFocusInWindow();
       }         
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
