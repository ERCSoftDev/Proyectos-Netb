
package actasyst;

import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class NuevaCircuns extends javax.swing.JInternalFrame {
    
 CamSyst.Controlador.ClassConection conectar=new CamSyst.Controlador.ClassConection();
   String userName;
   String passWord;
    Connection con;
    CallableStatement cst;
    ResultSet r;
    

     public NuevaCircuns() {
        initComponents();
        
        con=conectar.conecion();
        cargar();
    
     try{
    MaskFormatter mascara = new MaskFormatter("##.##");
    JFormattedTextField textField = new JFormattedTextField(mascara);
    textField.setValue(new Float("12.34"));
}
     catch ( ParseException | NumberFormatException e){}
}
     
     private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("Desc.Oficialia");
       cst=con.prepareCall("{call mostrarOfi}");
       r=cst.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[1];
       for (int i=0; i<1; i++){
           dato[i]=r.getString(i+1);
       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       

       }catch (Exception e){}
desabilitar();
           this.jButton1.setEnabled(false);
           this.jButton2.setEnabled(false);
           this.jButton3.setEnabled(true);
           this.jButton4.setEnabled(false);
           this.jButton5.setEnabled(false);
            this.jButton7.setEnabled(true);
           
              }
    public void abilitar (){
           this.jTextField1.setEnabled(true);
           this.jButton6.setEnabled(true);
}
    public void desabilitar(){
           this.jTextField1.setEnabled(false);           
}
    public void limpiar(){
     this.jTextField1.setText("");           
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("Nueva Circunscripcion");
        setName("jFrame"); // NOI18N

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Oficialia:");

        jLabel2.setText("Ej.: 1ra Circuns. Santo Domingo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("Nueva Circunscripcion");

        jButton1.setText("Guardar/Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451536341_Add.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Salir");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(36, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(33, 33, 33)
                .addComponent(jButton7)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("NuevaCircuns");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    limpiar();
    cargar();
    abilitar ();
    this.jTextField1.setEnabled(false);
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String circuns = jTextField1.getText();
       
             if(jTextField1.getText().length()==0){  
             JOptionPane.showMessageDialog(this, "El campo de texto No Puede estar Vacio"+"Aviso");
             }
             else
                  
            try {
            cst = con.prepareCall("{call registrarCircuns(?)}");
            cst.setString(1, circuns);

            int rpta = cst.executeUpdate();
            if  (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA SALIR","confirmar",JOptionPane.YES_NO_OPTION);
            if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
            }
        }
            
            } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
                     
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String NombreCircuns = jTextField1. getText();
        

        try {
            cst = con.prepareCall("{call modificarCircuns(?)}");
         
            cst.setString(1,NombreCircuns );
            

            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Oficialia Modificada Exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                cargar();
                abilitar ();
                
            } else {

                JOptionPane.showMessageDialog(this, "Error al modificar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    limpiar();
    abilitar();
        this.jButton1.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jButton3.setEnabled(false);
        this.jButton4.setEnabled(false);
        this.jButton5.setEnabled(false);
        this.jButton6.setEnabled(false);
        this.jButton7.setEnabled(true);
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA SALIR","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String nombreb = JOptionPane.showInputDialog("INGRESE EL NOMBRE DE LA OFICIALIA");
        try {
            cst = con.prepareCall("{call buscarOfi(?)}");
            cst.setString(1, nombreb);
            r = cst.executeQuery();

            if (r.next()) {
                JOptionPane.showMessageDialog(this, "Busqueda Exitosa!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                abilitar();
                this.jTextField1.setText(r.getString(1));
            } else {
                desabilitar();
                JOptionPane.showMessageDialog(this, "Oficialia No Encontrada!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.jTextField1.setEnabled(false);
               
}
        
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        this.jButton4.setEnabled(true);
        this.jButton5.setEnabled(true);
        this.jButton2.setEnabled(true);
        this.jTextField1.setEnabled(true);
                // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
String NombreCircuns = this.jTextField1.getText();
        try {
            cst = con.prepareCall("{call eliminarCircuns(?)}");
            cst.setString(1, NombreCircuns);
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Oficialia Eliminada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                cargar();
                abilitar (); 
            } else {
                JOptionPane.showMessageDialog(this, " Oficialia No Eliminada", "ERROR!", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }    
               // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

   
}

