
package actasyst;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class AccessoSistema extends javax.swing.JFrame {

  private static final long serialVersionUID = 1L;
  
   CamSyst.Controlador.ClassConection conectar=new CamSyst.Controlador.ClassConection();
   String userName;
   String passWord;
  Connection con;
  CallableStatement cst;
  ResultSet r;


  public Timer objetotimer;
  public int a;
    
        
    public AccessoSistema() {
        initComponents();
        txtContraseña.requestFocusInWindow();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/A.png")).getImage());
    }
 public void IniciarSesion(String user,String password){

        objetotimer = new Timer(80,new claseTimer());
                        try
	                {
	                    //chekar si el usuario escrbio el nombre de usuario y pw
	                    if (jComboBox1.getSelectedItem().toString().length() > 0 && txtContraseña.getText().length() > 0 )
                                
	                    {
                                // Si el usuario si fue validado correctamente
	                        if(  user.equals(user)&& password.equals(password))

	                        {
//                                this.user=user;
                            //    this.password=password;
                            //    conectar.conecion(this.user,this.password);
                                
	                          objetotimer.start();
                                    
                                }
	                        else
	                        {
	                             JOptionPane.showMessageDialog(null,"El nombre de usuario y/o contrasenia no son validos.");
	                            JOptionPane.showMessageDialog(null, jComboBox1.getSelectedItem()+" " +txtContraseña.getText() );// +txtContraseña.getText() );
	                            jComboBox1.getSelectedItem(); 
                                    txtContraseña.setText("");//limpiar campos
                                    jComboBox1.requestFocusInWindow();

	                            jComboBox1.requestFocusInWindow();
                                     }

                        }
                            else
	                    {
	                        JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +
	                            "NO puede dejar ningun campo vacio");
                                jComboBox1.requestFocusInWindow();
	                    }

	                } catch (Exception e)
	                {
	                }
}

public class claseTimer implements ActionListener{

        @Override
        @SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent e) {
          a=jProgressBar1.getValue();
          if (a <100){
              a++;
              jProgressBar1.setValue(a);
               }
         /* else{
              if(user.equals("Administrador")){
              objetotimer.stop();     
              //pass=admin010225
              ActaS fr2=new ActaS(); 
              fr2.setEnabled(true); 
              fr2.show();
              cerrar();
              JOptionPane.showMessageDialog(rootPane,"Bienvenido Sr/a "+user+" ActaSyst 7.0 ");
         // } 
              else{
              if(user.equals("Secretaria")){
              objetotimer.stop();     
               //pass=secre148214
              ActaSSecre fr3=new ActaSSecre(AccessoSistema.this.user, AccessoSistema.this.password); 
              fr3.setEnabled(true); 
              fr3.show();
              cerrar();
              JOptionPane.showMessageDialog(rootPane,"Bienvenido Sr/a "+user+" ActaSyst 7.0 ");
          }                                  

              objetotimer.stop();

          }}*/}
    }
private void cerrar(){
   this.dispose(); 
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jScrollPane2.setViewportView(jTree1);

        jMenuItem1.setText("jMenuItem1");

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipo Usuario");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1452220983_door_in.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.setToolTipText("ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1452221026_101.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setToolTipText("salir de esta ventana");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña:");
        jLabel2.setToolTipText("ingresar constraseña");

        jProgressBar1.setBackground(new java.awt.Color(51, 51, 51));
        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(204, 0, 0));
        jProgressBar1.setToolTipText("Ingresando al sistema porfavor espere...");
        jProgressBar1.setAutoscrolls(true);
        jProgressBar1.setStringPainted(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Login");

        jComboBox1.setEditable(true);
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Secretaria" }));
        jComboBox1.setToolTipText("Tipo de usuario");
        jComboBox1.setAutoscrolls(true);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/san-vicente-ferrer_1.png"))); // NOI18N
        jLabel5.setToolTipText("Nuestra Señora De La Anunciacion");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Soft");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jLabel7.setText("ActaSyst 7.0");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondos-de-madera.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel4KeyPressed(evt);
            }
        });

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });

        txtUsuario.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Usuario:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Dev.");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("ERC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 215, Short.MAX_VALUE))
                                    .addComponent(jLabel8))
                                .addGap(121, 121, 121))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, 0)
                                        .addComponent(jLabel9)
                                        .addGap(12, 12, 12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel10))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 161, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel9)
                                .addComponent(jLabel11))))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 25, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        IniciarSesion((String) jComboBox1.getSelectedItem(),txtContraseña.getText());
        jButton1.setEnabled(false);
   
    }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        System.exit(0);
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
//this.jComboBox1.removeAllItems();
          //   try {
          //   cst = con.prepareCall("select * from usuarios");
          //   r = cst.executeQuery();
          //   while(r.next()){
          //   this.jComboBox1.addItem(r.getString("NombreUsuario"));
           //  }
           //  } catch (SQLException ex) {
           //  Logger.getLogger(AccessoSistema.class.getName()).log(Level.SEVERE, null, ex);
      //  }       
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jLabel4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel4KeyPressed
       
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        IniciarSesion((String) jComboBox1.getSelectedItem(),txtContraseña.getText());
        jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jLabel4KeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      IniciarSesion((String) jComboBox1.getSelectedItem(),txtContraseña.getText());
      this.jButton1.setEnabled(false);
      txtContraseña.setEnabled(false);
      jLabel5.requestFocusInWindow();
       }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new AccessoSistema().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

}
