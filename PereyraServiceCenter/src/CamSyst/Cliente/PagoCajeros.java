
package CamSyst.Cliente;

import CamSyst.Controlador.ClassConection;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PagoCajeros extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
   public PagoCajeros(){
       
        
        
        initComponents();
        this.setLocation(380,120);
        cn=conectar.conecion();
     

    }
   public void verificarentreda(){
       
if(jTextField1.getText().length()>jTextField2.getText().length()){
 JOptionPane.showMessageDialog(null, "DEBE INGRESAR UNA CANTIDAD DE DINERO MAYOR ");
}
   
   }
   private void porciento(){
    try {
             cts=cn.prepareCall("buscarPorciento");
             r=cts.executeQuery();
             if (r.next())
        
          jTextField6.setText(r.getString(1));
 } catch (SQLException ex) {
            //Logger.getLogger(ReporteDiario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void calculaporciento(){
        double operac;
      

        double monto1=Double.parseDouble(jTextField6.getText());
        double monto2=Double.parseDouble(jTextField5.getText());
     
        
        operac=monto2+(monto2*monto1/100);
        
   jTextField5.setText(""+redondearvalor2(operac,2));
    }
   private void pagoTarjeta() {
        String nf=FacturaCajeros.jTextField4.getText();
        String fecha=FacturaCajeros.jlb_fecha.getText();
        String digito=jTextField4.getText();
        String total=jTextField5.getText();
        int Bauche=1;

        
        try{
            cts=cn.prepareCall("{call detalleTarjeta(?,?,?,?,?)}");
            cts.setString(1, nf);
            cts.setString(2, fecha);
            cts.setString(3, digito);
            cts.setString(4, total);
            cts.setInt(5, Bauche);
            
            
            int opcion=cts.executeUpdate();
            if (opcion==1)
               JOptionPane.showMessageDialog(null, "detalles de tarjeta Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        
            FacturaCajeros.numfac();
            FacturaCajeros.numComprobF02();
            FacturaCajeros.incrementarncf();
        FacturaCajeros.debitarProductos();
        FacturaCajeros.agregarFacCli();
        FacturaCajeros.agregarDETALLE();
        FacturaCajeros.imprimir();
        FacturaCajeros.limpiar();
        
        FacturaCajeros.datocli();
        JOptionPane.showMessageDialog(null, "GRACIAS POR SU COMPRA...");
        this.dispose(); 
        
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de tarjeta"+e.getMessage());
       
      
        }
     }
   public static void valor() {
        double operacion;

        double monto1=Double.parseDouble(jTextField1.getText());
        double monto2=Double.parseDouble(jTextField2.getText());
        
        operacion=monto2-monto1;
        
   jTextField3.setText(""+redondearvalor(operacion,2));
    }
   public static void valor1(){
        double operac;
      

        double monto1=Double.parseDouble(jTextField1.getText());
        double monto2=Double.parseDouble(jTextField2.getText());
        double monto3=Double.parseDouble(jTextField5.getText());
        
        operac=(monto3+monto2)-monto1;
        
   jTextField3.setText(""+redondearvalor1(operac,3));
    }
   public static void valor2(){
        double operac;
      

        double monto1=Double.parseDouble(jTextField1.getText());
        double monto2=Double.parseDouble(jTextField2.getText());
     
        
        operac=monto2-monto1;
        
   jTextField3.setText(""+redondearvalor2(operac,2));
    }
   public static void ope()   {
    double operacion;

        double monto3=Double.parseDouble(jTextField1.getText());
        double monto4=Double.parseDouble(jTextField5.getText());
        
        operacion=monto3-monto4;
        
   jTextField2.setText(""+redondearope(operacion,2));
//  jTextField2.setEnabled(false);
    
    }
   
    private static double redondearvalor   (double operacion,int numDecimal)    {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*operacion+0.5)/p;
    
}
    private static double redondearvalor1  (double operac,int numDecimal)       {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*operac+0.5)/p;
    
}
    private static double redondearvalor2  (double operac,int numDecimal)       {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*operac+0.5)/p;
    
}
    private static double redondearope     (double operacion,int numDecimal)    {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*operacion+0.5)/p;
    
}
  
    public static void validacion(){
    int caract=4;
    if(jTextField4.getText().length()<caract){
       JOptionPane.showMessageDialog(null, "DEBE INGRESAR LOS 4 ULTIMOS DIGITOS DE LA TARJETA DE CREDITO...");
    jTextField4.requestFocusInWindow();
    }
    } 
    public void llamada(){
        // if(FacturaCajeros.jTextField7.getText().length()>0){  
        FacturaCajeros.numfac();
        FacturaCajeros.numComprobF02(); 
        FacturaCajeros.incrementarncf();
        FacturaCajeros.debitarProductos();
        FacturaCajeros.agregarFacCli();
        FacturaCajeros.agregarDETALLE();
        FacturaCajeros.imprimir();
        FacturaCajeros.limpiar();   
        JOptionPane.showMessageDialog(null, "GRACIAS POR SU COMPRA...");
        this.dispose(); 
       //  }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));
        setTitle("Forma de pago ");
        setAlignmentX(50.0F);
        setAlignmentY(50.0F);
        setNormalBounds(new java.awt.Rectangle(50, 50, 50, 50));
        setVisible(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Cash_dollar_earnings_money_profit_savings_stack_1886546.png"))); // NOI18N
        jButton1.setToolTipText("pago en Efectivo");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
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

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_visa_213724.png"))); // NOI18N
        jButton2.setToolTipText("Pago con Tarjeta");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
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

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Total a pagar: ");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField2.setToolTipText("Ingreso monto del efectivo");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 153, 51));
        jTextField3.setToolTipText("Cambio o devuelta");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField4.setToolTipText("Ultimos 4 digitos de la tarjeta");
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField5.setToolTipText("Numero de Bauche");
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Devuelta o Cambio");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("4 ultimos digitos de la tarjeta");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Monto a Pagar");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jCheckBox1.setText("Pago dividido");
        jCheckBox1.setContentAreaFilled(false);
        jCheckBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tarjeta");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Efectivo");

        jTextField6.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("5%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel1)))
                                    .addComponent(jLabel6))
                                .addGap(0, 88, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                    .addComponent(jTextField3))
                                .addGap(0, 223, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addGap(1, 1, 1))
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
   
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
    char car = evt.getKeyChar();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER && jTextField5.getText().length()>0 && (car<'0' || car>'9')) {
         verificarentreda();
           valor2();
           JOptionPane.showMessageDialog(null,"DEVUELVALE AL CLIENTE "+jTextField3.getText()+" PESOS");
           llamada();
           FacturaCajeros.datocli();
           evt.consume();
        
      }                 
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed

        
       if(jTextField5.getText().length()>0){
       valor1();
       JOptionPane.showMessageDialog(null,"DEVUELVALE AL CLIENTE "+jTextField3.getText()+" PESOS");     
       llamada();
       FacturaCajeros.datocli();
       }else    
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           valor2();
           JOptionPane.showMessageDialog(null,"DEVUELVALE AL CLIENTE "+jTextField3.getText()+" PESOS");
           llamada();
           FacturaCajeros.datocli();
           dispose();
       }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      llamada();
      }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       jTextField2.setText("");
       jTextField3.setText("");
        jTextField2.setEnabled(false); 
         jTextField4.setEnabled(true); 
        jTextField4.requestFocusInWindow();
        jTextField5.setEnabled(true);

            FacturaCajeros.operaci9(); 
            porciento();
            calculaporciento();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        if(jCheckBox1.isSelected()){ 
        jTextField5.setText("");
         jTextField5.setEnabled(true); 
        JOptionPane.showMessageDialog(null, "Ingrese el monto a pagar con la tarjeta...");
       jTextField5.requestFocusInWindow();
        }else
            jTextField5.setText("");           

    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      validacion();
      ope();
      
      jTextField2.requestFocusInWindow();
      jTextField2.setEnabled(true);
      }else
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          
        // valor1();
         llamada();
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        jTextField2.setEnabled(true);
        jCheckBox1.setSelected(false);
        jTextField2.requestFocusInWindow();
        jTextField5.setText("");
        jTextField4.setText("");
        jTextField4.setEnabled(false);
        jTextField5.setEnabled(false);
       
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
                        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //Factura.puntos();  
            pagoTarjeta();
            FacturaCajeros.datocli();
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped

       char car = evt.getKeyChar();
       if((car<'0' || car>'9')){
       evt.consume();
       }            
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char car = evt.getKeyChar();
          if((car<'0' || car>'9')){
         evt.consume();
   
    }                 
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyReleased
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
