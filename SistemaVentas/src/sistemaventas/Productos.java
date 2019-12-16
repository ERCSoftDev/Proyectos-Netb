
package sistemaventas;

import java.sql.*;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import Conexion.ClassConection;
import java.awt.HeadlessException;
import java.text.ParseException;
public class Productos extends javax.swing.JInternalFrame {
ClassConection conectar=new ClassConection();
       Connection con;
    CallableStatement cst;
    ResultSet r;
    public Productos() {
        initComponents();
          con=conectar.conecion();
    cargar();
    try
{
    /* El "patrón" para el editor. Las # representan cifras. En la API puedes ver más. Ojo con el punto decimal, según el idioma puede ser una coma.*/
    MaskFormatter mascara = new MaskFormatter("##.##");
    // Se construye el JFormattedTextField pasándole la máscara
    JFormattedTextField textField = new JFormattedTextField(mascara);
    // Se da un valor inicial válido para evitar problemas
    textField.setValue(new Float("12.34"));
}
catch ( ParseException | NumberFormatException e){}
    }
     private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALLE");
       tabla.addColumn("PROVEEDOR");
       tabla.addColumn("PRECIO");
       tabla.addColumn("stock");
         cst=con.prepareCall("{call mostrarpro}");
       r=cst.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[6];
       for (int i=0; i<6; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
desabilitar();
           this.jButton1.setEnabled(false);
           this.jButton2.setEnabled(true);
           this.jButton3.setEnabled(true);
           this.jButton4.setEnabled(false);
           this.jButton5.setEnabled(false);
              }
    public void abilitar (){
           this.jTextField2.setEnabled(true);
           this.jTextField3.setEnabled(true); 
           this.jTextField7.setEnabled(true);
           this.jTextField5.setEnabled(true);
           this.jTextField6.setEnabled(true); 
           this.jTextField2.requestFocus();
           
    }
    public void desabilitar(){
           this.jTextField2.setEnabled(false);
           this.jTextField3.setEnabled(false); 
           this.jTextField7.setEnabled(false);
           this.jTextField5.setEnabled(false);
           this.jTextField6.setEnabled(false); 
                          }
    public void limpiar(){
     this.jTextField1.setText("");
           this.jTextField2.setText("");
           this.jTextField3.setText(""); 
           this.jTextField7.setText("");
           this.jTextField5.setText("");
           this.jTextField6.setText("");//esto sirve para limpiar los campos..
           
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItem1.setText("Actualizar Registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO DE PRODUCTOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setToolTipText("");
        jTextField1.setEnabled(false);
        jTextField1.setFocusAccelerator('*');
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nombre de producto:");

        jLabel3.setText("Detalle:");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel4.setText("Proveedor:");

        jLabel5.setText("Precio:");

        jTextField5.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField5CaretUpdate(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel6.setText("Stock:");

        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jTextField7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jTextField2))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Search).jpg"))); // NOI18N
        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User edit).jpg"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User delete).jpg"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Wzdelete.jpg"))); // NOI18N
        jButton6.setText("Cancelar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Delete).jpg"))); // NOI18N
        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (User add).jpg"))); // NOI18N
        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento de Productos", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE PRODUCTO", "DETALLE", "PROVEEDOR", "PRECIO ", "STOCK"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Listado de Productos", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField5CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField5CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5CaretUpdate

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cod = jTextField1.getText(), pro = jTextField2.getText();
        String det = jTextField3.getText(), prov = jTextField7.getText();
        double prec = Double.parseDouble(this.jTextField5.getText());

        int stc = Integer.parseInt(this.jTextField6.getText());
        try {
            cst = con.prepareCall("{call registrarProductos(?,?,?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, pro);
            cst.setString(3, det);
            cst.setString(4, prov);
            cst.setDouble(5, prec);
            cst.setInt(6, stc);

            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
            limpiar();
            desabilitar();
            this.jButton1.setEnabled(false);
            this.jButton2.setEnabled(true);
            this.jButton3.setEnabled(true);
            this.jButton4.setEnabled(false);
            this.jButton5.setEnabled(false);

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //ESTE ES EL BOTON BUSCAR....
        //CAPTURAMOS LAS VARIABLES
        String cod = JOptionPane.showInputDialog("INGRESE EL CODIGO DEL PRODUCTO A BUSCAR si decea puede editalpara modificar o eliminar el registro");
        try {
            cst = con.prepareCall("{call buscarpro(?)}");
            cst.setString(1, cod);
            r = cst.executeQuery();

            if (r.next()) {
                JOptionPane.showMessageDialog(this, "Producto Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                abilitar();
                this.jTextField1.setText(r.getString(1));
                this.jTextField2.setText(r.getString(2));
                this.jTextField3.setText(r.getString(3));
                this.jTextField7.setText(r.getString(4));
                this.jTextField5.setText(r.getString(5));
                this.jTextField6.setText(r.getString(6));
                this.jButton1.setEnabled(false);
                this.jButton2.setEnabled(false);
                this.jButton3.setEnabled(false);
                this.jButton4.setEnabled(true);
                this.jButton5.setEnabled(true);
            } else {

                JOptionPane.showMessageDialog(this, "Producto  No Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //ESTE ES EL BOTON MODIFICAR QUE VA A SER SIMILAR AL REGISTRAR  ASI QUE COPIAMOS LOS MISMOS CODIGOS
        //PERO CAMBIAMOS EL NOMBRE DEL PROCEDIMINETO............
        String cod = jTextField1.getText(), pro = jTextField2.getText();
        String det = jTextField3.getText(), prov = jTextField7.getText();
        double prec = Double.parseDouble(this.jTextField5.getText());
        int stc = Integer.parseInt(this.jTextField6.getText());

        try {
            cst = con.prepareCall("{call modicficarpro(?,?,?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, pro);
            cst.setString(3, det);
            cst.setString(4, prov);
            cst.setDouble(5, prec);
            cst.setInt(6, stc);
            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Producto Modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                desabilitar();
                this.jButton1.setEnabled(false);
                this.jButton2.setEnabled(true);
                this.jButton3.setEnabled(true);
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
                         } else {

                JOptionPane.showMessageDialog(this, "Error al modificar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String cod = this.jTextField1.getText();
        try {
            cst = con.prepareCall("{call eliminarpro(?)}");
            cst.setString(1, cod);
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Producto Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.jButton1.setEnabled(false);
                this.jButton2.setEnabled(true);
                this.jButton3.setEnabled(true);
                this.jButton4.setEnabled(false);
                this.jButton5.setEnabled(false);
                limpiar();
                          } else {
                JOptionPane.showMessageDialog(this, "Producto No Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        limpiar();
        desabilitar();
        this.jButton1.setEnabled(false);
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(true);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpiar();
         try{
        
         cst=con.prepareCall("{call Genera_num_PRODUCTOS}");
       r=cst.executeQuery();
       if (r.next())
        
          jTextField1.setText(r.getString(1));
            }catch (Exception e){} 
        abilitar();
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(false);
        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         cargar();
         
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();
     
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
if((car<'0' || car>'9')&&(car<'.'||car>'.')) evt.consume();
       
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
        // TODO add your handling code here:
           char car = evt.getKeyChar();
if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')&&(car<'.'||car>'.')) evt.consume();
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
