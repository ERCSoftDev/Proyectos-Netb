

package CamSyst.Vista;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sparesystem;","sa","admin010225");
            
            st=con.prepareStatement(sql);
            st.setString(1, use.getText());
            st.setString(2, contrasena.getText());
            st.setString(3, jComboBox1.getSelectedItem().toString());
            r=st.executeQuery();
            if(r.next()){  
            IniciarSesion();
            jProgressBar1.requestFocusInWindow();
            this.contrasena.setEnabled(false);
            Login_CamSyst.use.setEnabled(false);
            
            ImageIcon imagen = new ImageIcon("C:\\Users\\eciprian\\Documents\\NetBeansProjects\\PereyraServiceCenter\\src\\Imagenes\\iconfinder_ui_16_3556111.png");
            jLabel8.setIcon(imagen);
            }      
            else{         
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas,"+"Verifique el nombre de usuario y password");
            use.requestFocusInWindow();
            }                 
        }
        catch(HeadlessException | ClassNotFoundException | SQLException e){
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
                  if (a <100&&jComboBox1.getSelectedItem().equals("Contabilidad")){
              a++;
              jProgressBar1.setValue(a);
       } 
          else
              if(jComboBox1.getSelectedItem().equals("Contabilidad")){
              objetotimer.stop();
              Contabilidad fr2=new Contabilidad(); 
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
              Cajeros fr1=new Cajeros(); 
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
          if(a <100&&jComboBox1.getSelectedItem().equals("Atencion")){
              a++;
              jProgressBar1.setValue(a);
          }
          else
              if(jComboBox1.getSelectedItem().equals("Atencion")){
              objetotimer.stop();
              vendedor fr1=new vendedor(); 
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
          if(a <100&&jComboBox1.getSelectedItem().equals("Programador")){
              a++;
              jProgressBar1.setValue(a);
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
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contrasena = new javax.swing.JPasswordField();
        jComboBox1 = new javax.swing.JComboBox();
        use = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setLocationByPlatform(true);
        setMinimumSize(getPreferredSize());
        setName("Login"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(603, 313));
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);

        jComboBox2.setEditable(true);
        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Empresa", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 204, 255));
        jButton1.setText("Login");
        jButton1.setToolTipText("Ingresar al sistema");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 204, 255));
        jLabel6.setText("ERC SoftDev");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 204, 255));
        jLabel1.setText("Sing In");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jLabel7.setText("SpareSyst 1.0");

        contrasena.setBackground(new java.awt.Color(102, 102, 102));
        contrasena.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        contrasena.setForeground(new java.awt.Color(204, 204, 204));
        contrasena.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true), "Password", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contrasenaKeyTyped(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(206, 230, 255));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(102, 102, 102));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Contabilidad", "Facturacion", "Cobros", "Compras", "Inventario", "Nominas", "Encargado", "Asistente", "Cajer@s", "Atencion", "Informatica" }));
        jComboBox1.setSelectedIndex(-1);
        jComboBox1.setToolTipText("Elegir modulo de sistema que deseas");
        jComboBox1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 2, true), "Modulo", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        use.setBackground(new java.awt.Color(102, 102, 102));
        use.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        use.setForeground(new java.awt.Color(204, 204, 204));
        use.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 204, 255), 2, true), "Usuario", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        use.setSelectionColor(new java.awt.Color(153, 204, 255));
        use.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                useKeyTyped(evt);
            }
        });

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jProgressBar1.setForeground(new java.awt.Color(153, 204, 255));
        jProgressBar1.setMinimum(10);
        jProgressBar1.setAutoscrolls(true);
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jProgressBar1.setDoubleBuffered(true);
        jProgressBar1.setFocusCycleRoot(true);
        jProgressBar1.setFocusTraversalPolicyProvider(true);
        jProgressBar1.setInheritsPopupMenu(true);
        jProgressBar1.setMinimumSize(new java.awt.Dimension(20, 27));
        jProgressBar1.setOpaque(true);
        jProgressBar1.setString("");
        jProgressBar1.setStringPainted(true);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_InterfaceExpendet-09_592608.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_unlock__access__key__password_2537322 (1).png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_38_Target_Audience_1688838.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_company_87420 (1).png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_ui_15_3556112.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 871, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)))
                        .addGap(285, 285, 285))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(use, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        jComboBox1.getAccessibleContext().setAccessibleName("Modulo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    validacion();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    public static javax.swing.JTextField use;
    // End of variables declaration//GEN-END:variables
}
