
package CamSyst.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Login_CamSyst extends javax.swing.JFrame {

   Connection con;
   CallableStatement cst;
   PreparedStatement st;
   ResultSet r;

    public Timer objetotimer;
    public int a;
      
    public  Login_CamSyst() {
    initComponents();
    use.requestFocusInWindow();
    setIconImage(new ImageIcon(getClass().getResource("/Imagenes/logo.png.png")).getImage());
    
    }
    
   public void IniciarSesion(){
         
    objetotimer = new Timer(80,new claseTimer());   
    objetotimer.start();
}
   public void validacion()   {
    String sql= "select* from usuario where nick=? and contra=? and tipo=?";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=prucamsyst;","sa","admin010225");
            st=con.prepareStatement(sql);
            st.setString(1, use.getText());
            st.setString(2, contrasena.getText());
            st.setString(3, jComboBox1.getSelectedItem().toString());
            r=st.executeQuery();
            if(r.next()){  
            IniciarSesion();
            jProgressBar1.requestFocusInWindow();
            this.contrasena.setEnabled(false);
            this.use.setEnabled(false);
           
                    
            JOptionPane.showMessageDialog(null,"Bienvenido:"+" "+use.getText());
            }
           
            else{         
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas,"+"Verifique el nombre de usuario y password");
            use.requestFocusInWindow();
            }                 
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);     
        }    
   
   }
       
   public class claseTimer implements ActionListener{

        @Override
        @SuppressWarnings("deprecation")
        public void actionPerformed(ActionEvent e){
            
          a=jProgressBar1.getValue();
          if (a <100&&jComboBox1.getSelectedItem().equals("Administrador")){
              a++;
              jProgressBar1.setValue(a);
       } 
          else
              if(jComboBox1.getSelectedItem().equals("Administrador")){
              objetotimer.stop();
              CamS fr2=new CamS(); 
              fr2.setEnabled(true);
              fr2.show();
              dispose(); 
          }
          else
          if(a <100&&jComboBox1.getSelectedItem().equals("Cajer@s")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Cajer@s")){
              objetotimer.stop();
              CamSCajera fr1=new CamSCajera(); 
              fr1.setEnabled(true);
              fr1.show();
              dispose(); 
          } 
          else
          if(a <100&&jComboBox1.getSelectedItem().equals("Encargado")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Encargado")){
              objetotimer.stop();
              CamSEncargado fr1=new CamSEncargado(); 
              fr1.setEnabled(true);
              fr1.show();
              dispose(); 
              }
           else
          if(a <100&&jComboBox1.getSelectedItem().equals("Atencion")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Atencion")){
              objetotimer.stop();
              CamSEncargado fr1=new CamSEncargado(); 
              fr1.setEnabled(true);
              fr1.show();
              dispose(); 
              }
           else
          if(a <100&&jComboBox1.getSelectedItem().equals("Asistente")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Asistente")){
              objetotimer.stop();
              CamSEncargado fr1=new CamSEncargado(); 
              fr1.setEnabled(true);
              fr1.show();
              dispose(); 
              }
           else
          if(a <100&&jComboBox1.getSelectedItem().equals("Programador")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Programador")){
              objetotimer.stop();
              CamSEncargado fr1=new CamSEncargado(); 
              fr1.setEnabled(true);
              fr1.show();
              dispose(); 
              }
        }
     }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        use = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

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
        setLocationByPlatform(true);
        setMinimumSize(getPreferredSize());
        setName("Login"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(603, 313));
        setType(java.awt.Window.Type.UTILITY);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Contraseña:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1452220983_door_in.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.setToolTipText("Ingresar al sistema");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1452221026_101.png"))); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.setToolTipText("Cancelar operacion");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(0, 153, 204));
        jProgressBar1.setAutoscrolls(true);
        jProgressBar1.setStringPainted(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("ERC SoftDev");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jLabel7.setText("BlueSyst 1.1");

        contrasena.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        contrasena.setForeground(new java.awt.Color(0, 51, 102));
        contrasena.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contrasenaKeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lock-256.png"))); // NOI18N
        jLabel3.setToolTipText("CamSyst");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Tipo Usuario:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 153, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Encargado", "Asistente", "Cajer@s", "Atencion", "Programador" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        use.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        use.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                useKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Usuario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 33, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(301, 301, 301))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jComboBox1, 0, 210, Short.MAX_VALUE)
                                            .addComponent(contrasena)
                                            .addComponent(use))
                                        .addGap(280, 280, 280)))))
                        .addComponent(jLabel10)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    validacion();
    }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            System.exit(0);        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void contrasenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contrasenaKeyTyped
       char teclapre=evt.getKeyChar();
        if((teclapre) == KeyEvent.VK_ENTER) {
       //     if(jComboBox1.getSelectedItem().equals("Administrador")){
            
         //   }
            validacion();
        }
    }//GEN-LAST:event_contrasenaKeyTyped

    private void useKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_useKeyTyped
       char teclapre=evt.getKeyChar();
        if((teclapre) == KeyEvent.VK_ENTER) {         
            contrasena.requestFocusInWindow();
        }
    }//GEN-LAST:event_useKeyTyped

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
           public void run() {
           new Login_CamSyst().setVisible(true);
            }
       });
    } 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField use;
    // End of variables declaration//GEN-END:variables
}
