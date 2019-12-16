
package CamSyst.Cliente;

import static CamSyst.Cliente.FacturaVendedor.JLB_codCliente;
import static CamSyst.Cliente.FacturaVendedor.jLabel16;
import static CamSyst.Cliente.FacturaVendedor.jLabel18;
import static CamSyst.Cliente.FacturaVendedor.jLabel20;
import static CamSyst.Cliente.FacturaVendedor.jTextField3;
import static CamSyst.Cliente.FacturaVendedor.jTextField4;
import static CamSyst.Cliente.FacturaVendedor.jTextField7;
import static CamSyst.Cliente.FacturaVendedor.jTextField8;
import static CamSyst.Cliente.FacturaVendedor.jlb_fecha;
import static CamSyst.Cliente.FacturaVendedor.jtf_desc;
import static CamSyst.Cliente.FacturaVendedor.jtf_igv;
import static CamSyst.Cliente.FacturaVendedor.jtf_subto;
import static CamSyst.Cliente.FacturaVendedor.jtf_total;
import static CamSyst.Cliente.FacturaVendedor.telefo;
import CamSyst.Controlador.ClassConection;
import CamSyst.Vista.vendedor;
import static CamSyst.Vista.vendedor.jDesktopPane1;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturasEnviadas extends javax.swing.JInternalFrame {
   Connection con;
   CallableStatement cts;
   PreparedStatement st;
   ResultSet r;
   
   ClassConection conectar= new ClassConection();

public FacturasEnviadas() {
        
        initComponents();
        this.setLocation(380,120);
        con=conectar.conecion();
        cargar();
    }
private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO CLIENTE");
       tabla.addColumn("NO FACTURA");
       tabla.addColumn("NOMBRE");          
       tabla.addColumn("TOTAL");
       tabla.addColumn("FECHA");
       
       cts=con.prepareCall("{call mostrarFatSusp}");
         r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[5];
       for (int i=0; i<5; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
jLabel2.setText(""+jTable1.getRowCount());
       }catch (Exception e){}

}
 private void buscarart(){
    String x=FacturaVendedor.jTextField10.getText();
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO CLIENTE");
       tabla.addColumn("ID");
       tabla.addColumn("NOMBRE");         
       tabla.addColumn("TOTAL");
       tabla.addColumn("FECHA");
       
      
      
        cts=con.prepareCall("{call buscarNombreSusp(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[5];
       for (int i=0; i<5; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
 }  



private void mostrarInformacioAdicional(){
    
        int row=jTable1.getSelectedRow();
       
        String idf=     jTable1.getValueAt(row, 1).toString();
          try {
            cts=con.prepareCall("{call mostrarfactsusp(?)}");
            cts.setString(1, idf);
            r=cts.executeQuery();

            if(r.next()){
            JOptionPane.showMessageDialog(this,"Informacio Adicional agregada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
       
        jTextField4.setText(r.getString(1));
        //formaPago.setSelectedItem(r.getString(2));
        jTextField3.setText(r.getString(3));
        jlb_fecha.setText(r.getString(4));
        JLB_codCliente.setText(r.getString(5));
        jLabel18  .setText(r.getString(6));
        jtf_subto  .setText(r.getString(7));
        jtf_desc .setText(r.getString(8));
        jtf_igv .setText(r.getString(9));
        jtf_total.setText(r.getString(10));
        jTextField7.setText(r.getString(11));
        jTextField8.setText(r.getString(16));
        jLabel20.setText(r.getString(12));
        telefo.setText(r.getString(13));
        jTextField1.setText(r.getString(14));
        jLabel16.setText(r.getString(15));
      }  
        DefaultTableModel tabla = (DefaultTableModel) FacturaVendedor.jtableDetalle.getModel();
       {
        cts=con.prepareCall("{call mostrardetallesusp(?)}");
        cts.setString(1, idf);
        r=cts.executeQuery();
        
       while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
       dato[i]=r.getString(i+1);

       }
       FacturaVendedor.operaci();
       tabla.addRow(dato);
       }
       
       FacturaVendedor.jtableDetalle .setModel(tabla);
       
      
 }
           JOptionPane.showMessageDialog(this,"Informacion adicional  No Encontrada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
}
    
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Facturas suspendidas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No Factura", "Cod.Cliente", "Nombre", "Total"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setSelectionBackground(new java.awt.Color(255, 51, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Facturas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        try{
          //  JOptionPane.showMessageDialog(this,"Informacion adicional  No Encontrada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            FacturaVendedor j=new FacturaVendedor();
            jDesktopPane1.add(j);
            j.setLocation(50, 5);
            j.show();
            j.setVisible(true);
           
            mostrarInformacioAdicional();
            FacturaVendedor.operaci(); 
            //
           // FacturaVendedor.operaci();
            String nombre=vendedor.jLabel6.getText();
            FacturaVendedor.jTextField1.setText(nombre);
            FacturaVendedor.jTextField2.requestFocusInWindow();
            dispose();
        }catch(Exception e){}
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       buscarart(); 
    }//GEN-LAST:event_jTextField1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
