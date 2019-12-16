package CamSyst.Cliente;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Controlador.Reportes;


public final class cliente extends javax.swing.JInternalFrame {
   public static Connection cn;
   public static CallableStatement cts;
   public static  ResultSet r;
   
   ClassConection conectar= new ClassConection();
   
public cliente(String user,String password) {
        initComponents();
        cn=conectar.conecion(user,password);
    this.blue.setEnabled(false);  
    jTextField14.setText("0");
    jTextField10.setText("Republica Dominicana");
    cargar();   
    DESABILITAR();
    BOTONES();
    
    
}
private void resetear(){
if(blue.getText().length()==0)
jTextField9.setText("0");
}
 private void sumafacturascredi(){
     String X=jTextField1.getText();
    try {
             cts=cn.prepareCall("{call balanceCliente(?)}");
             cts.setString(1,X);
             r=cts.executeQuery();
             if (r.next())
        
          jTextField14.setText(r.getString(1));
 } catch (SQLException ex) {}
    
 }
 
 private void puntos(){
     String X=jTextField1.getText();
    try {
             cts=cn.prepareCall("{call mostrarpuntos(?)}");
             cts.setString(1,X);
             r=cts.executeQuery();
             if (r.next())
        
          jTextField9.setText(r.getString(1));
 } catch (SQLException ex) {}
    
 }

public void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("Codigo");
       tabla.addColumn("Nombres");
       tabla.addColumn("Apellidos");
       tabla.addColumn("Sexo");
       tabla.addColumn("Cedula");
       tabla.addColumn("Telefono");
       tabla.addColumn("Celular");
       tabla.addColumn("E_mail");
       tabla.addColumn("Direccion");
       tabla.addColumn("Codigo BluePoint");
       
         
       cts=cn.prepareCall("{call mostrarCliente}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<10; i++){
       dato[i]=r.getString(i+1);
}
       tabla.addRow(dato);
}
      this.jTable1.setModel(tabla);
      jLabel13.setText(""+jTable1.getRowCount());

       }catch (Exception e){}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JFormattedTextField();
        jTextField6 = new javax.swing.JFormattedTextField();
        jTextField4 = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        blue = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jLabel18 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Clientes");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jButton4.setToolTipText("Modificar datos del cliente");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-32.png"))); // NOI18N
        jButton5.setToolTipText("Eliminar el cliente");
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_delete.png"))); // NOI18N
        jButton7.setToolTipText("Cancelar la operacion");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jButton1.setToolTipText("Registrar el cliente");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(1, 1, 1)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(1, 1, 1)
                .addComponent(jButton7))
        );

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 0), new java.awt.Color(204, 204, 204), new java.awt.Color(102, 102, 102)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(0, 102, 255));
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Clientes registrados");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos De clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(51, 0, 255))); // NOI18N

        jLabel1.setText("Codigo cliente:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellidos:");

        jLabel4.setText("Sexo:");

        jLabel5.setText("RNC/Cedula:");

        jLabel6.setText("Telefono residencia:");

        jLabel7.setText("E_mail empresarial:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 153, 102));
        jTextField1.setEnabled(false);
        jTextField1.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 153, 102));
        jTextField2.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 153, 102));
        jTextField3.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione...", "M", "F" }));

        jLabel8.setText("Cel:");

        jLabel9.setText("Direccion Trabajo:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 153, 102));
        jTextField7.setSelectedTextColor(new java.awt.Color(51, 51, 51));

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 153, 102));
        jTextField8.setSelectedTextColor(new java.awt.Color(51, 51, 51));

        jTextField5.setForeground(new java.awt.Color(0, 153, 102));
        try {
            jTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setForeground(new java.awt.Color(0, 153, 102));
        try {
            jTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setSelectedTextColor(new java.awt.Color(51, 51, 51));

        jTextField4.setForeground(new java.awt.Color(0, 153, 102));
        try {
            jTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField4.setSelectedTextColor(new java.awt.Color(51, 51, 51));

        jButton2.setBackground(new java.awt.Color(255, 204, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new-file.png"))); // NOI18N
        jButton2.setToolTipText("Ingresar un nuevo usuario");
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

        jLabel11.setText("BluePoint:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton3.setToolTipText("Buscar el cliente");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        blue.setEditable(false);
        blue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        blue.setForeground(new java.awt.Color(51, 102, 255));
        blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueActionPerformed(evt);
            }
        });

        jLabel28.setText("E_mail personal:");

        jLabel29.setText("Direccion residencia:");

        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(0, 153, 102));

        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(0, 153, 102));

        jLabel30.setText("Tel. Trabajo:");

        jTextField18.setForeground(new java.awt.Color(0, 153, 102));
        try {
            jTextField18.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField18.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Esta Funcion no esta incluida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel28)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel29))
                                    .addComponent(jLabel11)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel5)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(jLabel3)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(blue)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(jTextField16))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(blue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel33))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel29)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informacion Prioritaria", jPanel1);

        jLabel10.setText("Tipo Negocio del cliente:");

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 153, 102));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- -", "Farmacia", "Electronica", "Supermercados", "Almacen", "Mayoristas", "Detallistas", "casa de cambio", "Negocio unipersonal" }));

        jLabel14.setText("Tipo entidad:");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(0, 153, 102));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- -", "Persona Juridica", "Persona Normal" }));

        jLabel16.setText("Pais:");

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(0, 153, 102));

        jLabel17.setText("Provincia:");

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(0, 153, 102));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- -", "Azua, Azua de Compostela", "Bahoruco, Neiba", "Barahona, Santa Cruz de Barahona", "Dajabón, Dajabón", "Distrito Nacional, Santo Domingo", "Duarte, San Francisco de Macorís", "Elías Piña, Comendador", "El Seibo , Santa Cruz del Seibo", "Espaillat, Moca", "Hato Mayor, Hato Mayor del Rey", "Hermanas Mirabal, Salcedo", "Independencia, Jimaní", "La Altagracia, Salvaleón de Higüey", "La Romana, La Romana", "La Vega, Concepción de la Vega", "María Trinidad Sánchez, Nagua", "Monseñor Nouel, Bonao", "Monte Cristi, San Fernando de Monte Cristi", "Monte Plata, Monte Plata", "Pedernales, Pedernales", "Peravia, Baní", "Puerto Plata, San Felipe de Puerto Plata", "Samaná, Santa Bárbara de Samaná", "Sánchez Ramírez, Cotuí", "San Cristóbal, San Cristóbal", "San José de Ocoa, San José de Ocoa", "San Juan, San Juan de la Maguana", "San Pedro de Macorís, San Pedro de Macorís", "Santiago, Santiago de los Caballeros", "Santiago Rodríguez, Sabaneta", "Santo Domingo, Santo Domingo Este", "Valverde, Mao" }));

        jLabel18.setText("Categoria del cliente:");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox5.setForeground(new java.awt.Color(0, 153, 102));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- -", "Buena paga", "Moroso", "inestable", "tarde pero seguro", "Cumplidor", " " }));

        jLabel19.setText("Notas:");

        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 153, 102));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel20.setText("Vendedor:");

        jComboBox6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox6.setForeground(new java.awt.Color(0, 153, 102));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- -", "Administrador", "Enfry" }));

        jLabel21.setText("Limite credito:");

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(0, 153, 102));

        jLabel22.setText("Limite descuento:");

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(0, 153, 102));

        jLabel23.setText("Interes:");

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(255, 0, 0));

        jLabel24.setText("%");

        jLabel26.setText("Pasados");

        jLabel27.setText("Dias");

        jLabel32.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel14)
                    .addComponent(jLabel10)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField10)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel23)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32))
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27)))
                .addGap(200, 200, 200))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel20)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Informacion adicional", jPanel3);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 153, 255));
        jLabel13.setText("jLabel13");

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(51, 102, 255));
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("puntos acumulados");

        jTextField14.setEditable(false);
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 0, 0));
        jTextField14.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Balance adeudado:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("RD$");

        jButton8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377296_printer.png"))); // NOI18N
        jButton8.setToolTipText("Imprimir listado de clientes");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addGap(59, 59, 59)
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)
                        .addGap(130, 130, 130)
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)
                                .addComponent(jLabel31))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         
       // limpiar();
       jTextField14.setText("0");
         try{
              jTextField14.setText("0");
        this.blue.setEnabled(true);  
         cts=cn.prepareCall("{call Genera_num_CLIENTES}");
         r=cts.executeQuery();
         if (r.next())
        
          jTextField1.setText(r.getString(1));
          }catch (Exception e){} 
    sumafacturascredi();     
    ABILITAR();
           this.jButton1.setEnabled(true);
           this.jButton2.setEnabled(false);
           this.jButton3.setEnabled(false);
           this.jButton4.setEnabled(false);
           this.jButton5.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed
private void mostrarInformacioAdicional(){
    
         String X=jTextField1.getText();
          try {
            cts=cn.prepareCall("{call buscarInfoAdicional(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();

            if(r.next()){
            JOptionPane.showMessageDialog(this,"Informacio Adicional agregada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
       
       // jTextField1. setText(r.getString(2));
        jTextField18.setText(r.getString(1));
        jTextField17.setText(r.getString(2));
        jTextField16.setText(r.getString(3));
        jComboBox2  .setSelectedItem(r.getString(4));
        jComboBox3  .setSelectedItem(r.getString(5));
        jComboBox4  .setSelectedItem(r.getString(6));
        jComboBox5  .setSelectedItem(r.getString(7));
        jTextArea1  .setText(r.getString(8));
        jComboBox6  .setSelectedItem(r.getString(9));
        jTextField11.setText(r.getString(10));
        jTextField14.setText(r.getString(11));
        jTextField13.setText(r.getString(12));
        jTextField15.setText(r.getString(13));
        jTextField12.setText(r.getString(14));
 }else{
           JOptionPane.showMessageDialog(this,"Informacion adicional  No Encontrada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
}
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
}
    
    
}
    
    private void informacionAdicional(){
        String cod=             jTextField1.getText();
        String telTrabajo=      jTextField18.getText();
        String correoPersonal=  jTextField17.getText();
        String dirPersonal=     jTextField16.getText();
        String tipoNegocio=     jComboBox2  .getSelectedItem().toString();
        String entidad=         jComboBox3  .getSelectedItem().toString();
        String provincia=       jComboBox4  .getSelectedItem().toString();
        String categoria=       jComboBox5  .getSelectedItem().toString();
        String notas=           jTextArea1  .getText();
        String vendedor=        jComboBox6  .getSelectedItem().toString();
        int limCredito=         Integer.parseInt(jTextField11.getText());
        int balAdeudado=        Integer.parseInt(jTextField14.getText());
        int interes=            Integer.parseInt(jTextField13.getText());
        int dias=               Integer.parseInt(jTextField15.getText());
        int limDescuento=       Integer.parseInt(jTextField12.getText());
      
        
        try {
            cts=cn.prepareCall("{call informacionAdi(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, cod);
            cts.setString(2, telTrabajo);
            cts.setString(3, correoPersonal);
            cts.setString(4, dirPersonal);
            cts.setString(5, tipoNegocio);
            cts.setString(6, entidad);
            cts.setString(7, provincia);
            cts.setString(8, categoria);
            cts.setString(9, notas);
            cts.setString(10, vendedor);
            cts.setInt(11,limCredito);
            cts.setInt(12,balAdeudado);
            cts.setInt(13,interes);
            cts.setInt(14,dias);
            cts.setInt(15,limDescuento);
            
            int rpta=cts.executeUpdate();
           if(rpta==1)
             JOptionPane.showMessageDialog(this,"Informacion adicional Registrada correctamente!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
             JOptionPane.showMessageDialog(this,"Operacion no completada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
             limpiar2();
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, e);
        }   
}
     private void updateinformacionAdicional(){
        String cod=             jTextField1.getText();
        String telTrabajo=      jTextField18.getText();
        String correoPersonal=  jTextField17.getText();
        String dirPersonal=     jTextField16.getText();
        String tipoNegocio=     jComboBox2  .getSelectedItem().toString();
        String entidad=         jComboBox3  .getSelectedItem().toString();
        String provincia=       jComboBox4  .getSelectedItem().toString();
        String categoria=       jComboBox5  .getSelectedItem().toString();
        String notas=           jTextArea1  .getText();
        String vendedor=        jComboBox6  .getSelectedItem().toString();
        int limCredito=         Integer.parseInt(jTextField11.getText());
        int balAdeudado=        Integer.parseInt(jTextField14.getText());
        int interes=            Integer.parseInt(jTextField13.getText());
        int dias=               Integer.parseInt(jTextField15.getText());
        int limDescuento=       Integer.parseInt(jTextField12.getText());
      
        
        try {
            cts=cn.prepareCall("{call updateinformacionAdi(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, cod);
            cts.setString(2, telTrabajo);
            cts.setString(3, correoPersonal);
            cts.setString(4, dirPersonal);
            cts.setString(5, tipoNegocio);
            cts.setString(6, entidad);
            cts.setString(7, provincia);
            cts.setString(8, categoria);
            cts.setString(9, notas);
            cts.setString(10, vendedor);
            cts.setInt(11,limCredito);
            cts.setInt(12,balAdeudado);
            cts.setInt(13,interes);
            cts.setInt(14,dias);
            cts.setInt(15,limDescuento);
            
            int rpta=cts.executeUpdate();
           if(rpta==1)
             JOptionPane.showMessageDialog(this,"Informacion adicional actualizada correctamente!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
             JOptionPane.showMessageDialog(this,"Operacion no completada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
             limpiar2();
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, e);
        }   
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
 
        String nom=JOptionPane.showInputDialog("INGRESE EL CODIGO DEL CLIENTE A BUSCAR","Ingrese el c0001 Ej:enfry");
          try {
            cts=cn.prepareCall("{call buscarCliente(?)}");
            cts.setString(1, nom);
            r=cts.executeQuery();

            if(r.next()){
            JOptionPane.showMessageDialog(this,"Cliente Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
            this.jTextField1.setText(r.getString(1));
            this.jTextField2.setText(r.getString(2));
            this.jTextField3.setText(r.getString(3));
            this.jComboBox1.setSelectedItem(r.getString(4));
            this.jTextField4.setText(r.getString(5));
            this.jTextField5.setText(r.getString(6));
            this.jTextField6.setText(r.getString(7));
            this.jTextField7.setText(r.getString(8));
            this.jTextField8.setText(r.getString(9));
            //cliente.jTextField9.setText(r.getString(11));
            this.blue.setText(r.getString(10));
            mostrarInformacioAdicional();
           // this.blue.setEnabled(false);
            
    ABILITAR();
           this.jButton1.setEnabled(false);
           this.jButton2.setEnabled(false);
           this.jButton3.setEnabled(false);
           this.jButton4.setEnabled(true);
           this.jButton5.setEnabled(true);
            }else{

           JOptionPane.showMessageDialog(this,"Cliente  No Encontrado!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
}
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
}

    }//GEN-LAST:event_jButton3ActionPerformed
public void BOTONES(){
           this.jButton1.setEnabled(false);
           this.jButton2.setEnabled(true);
           this.jButton3.setEnabled(true);
           this.jButton4.setEnabled(false);
           this.jButton5.setEnabled(false);
}
    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped

        char car=evt.getKeyChar();
         if(  jTextField1.getText().length()>=5)evt.consume();
          if((car<'c' || car>'c') && (car<'C' || car>'C')&&(car<'0'||car>'9')) evt.consume();
 
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

         char car=evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();
 
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
       char car=evt.getKeyChar();
       if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')) evt.consume();

    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
  
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
  
         int row=       jTable1.getSelectedRow();
        String cod=     jTable1.getValueAt(row, 0).toString();
        String nom=     jTable1.getValueAt(row, 1).toString();
        String apelli=  jTable1.getValueAt(row, 2).toString();
        String sexo=    jTable1.getValueAt(row, 3).toString();
        String cedula=  jTable1.getValueAt(row, 4).toString();
        String tel=     jTable1.getValueAt(row, 5).toString();
        String cel=     jTable1.getValueAt(row, 6).toString();
        String email=   jTable1.getValueAt(row, 7).toString();
        String direc=   jTable1.getValueAt(row, 8).toString();
        String bluep=   jTable1.getValueAt(row, 9).toString();
       // String puntos=   jTable1.getValueAt(row, 10).toString();
        
        jTextField1.setText(cod);
        jTextField2.setText(nom);
        jTextField3.setText(apelli);
        jComboBox1.setSelectedItem(sexo);
        jTextField4.setText(cedula);
        jTextField5.setText(tel);
        jTextField6.setText(cel);
        jTextField7.setText(email);
        jTextField8.setText(direc);
        blue.setText(bluep);
        //jTextField9.setText(puntos);
        
        JOptionPane.showMessageDialog(this,"Cliente Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
        
        mostrarInformacioAdicional();
        sumafacturascredi(); 
        puntos();
        resetear();
        if(jTextField14.getText().equals("")){
        jTextField14.setText("0");
        }
        ABILITAR();
        this.blue.setEnabled(false);  
           this.jButton1.setEnabled(false);
           this.jButton2.setEnabled(false);
           this.jButton3.setEnabled(false);
           this.jButton4.setEnabled(true);
           this.jButton5.setEnabled(true);
                                                
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       jTextField14.setText("0");
       puntos();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      try{
   String rutaInforme= "C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\Listadoclientes.jrxml";
        Reportes re= new Reportes();
        //Map parametros = new HashMap();
        //parametros.put(null,jTextField1.getText());
        re.verReporte2(rutaInforme);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String cod= jTextField1.getText();
        String nom= jTextField2.getText();
        String ape= jTextField3.getText();
        String sexo=this.jComboBox1.getSelectedItem().toString();
        String ced= jTextField4.getText();
        String tel= jTextField5.getText();
        String cel= jTextField6.getText();
        String emil=jTextField7.getText();
        String dir= jTextField8.getText();
        String bluep=      blue.getText();
      //String Puntos= jTextField9.getText();

        try {
            cts=cn.prepareCall("{call RegistrarClientes(?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, cod);
            cts.setString(2, nom);
            cts.setString(3, ape);
            cts.setString(4, sexo);
            cts.setString(5, ced);
            cts.setString(6, tel);
            cts.setString(7, cel);
            cts.setString(8, emil);
            cts.setString(9, dir);
            cts.setString(10,bluep);
           // cts.setString(11,Puntos);

            int rpta=cts.executeUpdate();
            if(rpta==1)
            JOptionPane.showMessageDialog(this,"Cliente Registrado correctamente!!","Atencion",JOptionPane.INFORMATION_MESSAGE);
            informacionAdicional();
            BOTONES();
            DESABILITAR();
            limpiar();
            cargar();

        } catch (SQLException | HeadlessException e) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        limpiar();
        BOTONES();
        DESABILITAR();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String nom=this.jTextField1.getText();
        try {
            cts=cn.prepareCall("{call eliminarCliente(?)}");
            cts.setString(1, nom);
            int rpta=cts.executeUpdate();

            if(rpta==1){
                JOptionPane.showMessageDialog(this, "Cliente Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                DESABILITAR();
                BOTONES();
                cargar();

            }else {
                JOptionPane.showMessageDialog(this, "Cliente No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        String cod= jTextField1.getText();
        String nom= jTextField2.getText();
        String ape= jTextField3.getText();
        String sexo=this.jComboBox1.getSelectedItem().toString();
        String ced= jTextField4.getText();
        String tel= jTextField5.getText();
        String cel= jTextField6.getText();
        String emil=jTextField7.getText();
        String dir= jTextField8.getText();
        String bluep= blue.getText();

        try {
            cts=cn.prepareCall("{call modificarClientes(?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, cod);
            cts.setString(2, nom);
            cts.setString(3, ape);
            cts.setString(4, sexo);
            cts.setString(5, ced);
            cts.setString(6, tel);
            cts.setString(7, cel);
            cts.setString(8, emil);
            cts.setString(9, dir);
            cts.setString(10, bluep);
            int rpta=cts.executeUpdate();
            if(rpta==1){

                JOptionPane.showMessageDialog(this, "Cliente Modificado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                updateinformacionAdicional();
                limpiar();
                DESABILITAR();
                BOTONES();
                cargar();
            }else {
                JOptionPane.showMessageDialog(this, "Error al modificar","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void blueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed
 public void limpiar(){
     
           this.jTextField1.setText("");
           this.jTextField2.setText("");
           this.jTextField3.setText(""); 
           this.jComboBox1.setSelectedIndex(0);
           this.jTextField4.setText("");
           this.jTextField5.setText("");
           this.jTextField6.setText("");
           this.jTextField7.setText("");
           jTextField8.setText("");
           jTextField9.setText("");
           blue.setText("");
           //informacion adicional
        jTextField18.setText("");
        jTextField17.setText("");
        jTextField16.setText("");
        jComboBox2  .setSelectedIndex(0);
        jComboBox3  .setSelectedIndex(0);
        jComboBox4  .setSelectedIndex(0);
        jComboBox5  .setSelectedIndex(0);
        jTextArea1  .setText("");
        jComboBox6  .setSelectedIndex(0);
        jTextField11.setText("");
        jTextField14.setText("");
        jTextField13.setText("");
        jTextField15.setText("");
        jTextField12.setText("");
 }
  private void limpiar2(){
  jTextField18.setText("");
        jTextField17.setText("");
        jTextField16.setText("");
        jComboBox2  .setSelectedIndex(0);
        jComboBox3  .setSelectedIndex(0);
        jComboBox4  .setSelectedIndex(0);
        jComboBox5  .setSelectedIndex(0);
        jTextArea1  .setText("");
        jComboBox6  .setSelectedIndex(0);
        jTextField11.setText("");
        jTextField14.setText("");
        jTextField13.setText("");
        jTextField15.setText("");
        jTextField12.setText("");
  
  }       
  public void ABILITAR(){
          this.jTextField2.setEnabled(true);
           this.jTextField3.setEnabled(true);
           this.jComboBox1.setEnabled(true);
           this.jTextField4.setEnabled(true);
           this.jTextField5.setEnabled(true);
           this.jTextField6.setEnabled(true);
           this.jTextField7.setEnabled(true);
           jTextField8.setEnabled(true);
            blue.setEnabled(true);
           jTextField18.setEnabled(true);
           blue.setEnabled(true);
           jTextField17.setEnabled(true);
           jTextField16.setEnabled(true);
           jComboBox2  .setEnabled(true);
           jComboBox3  .setEnabled(true);
           jComboBox4  .setEnabled(true);
           jComboBox5  .setEnabled(true);
           jTextArea1  .setEnabled(true);
           jComboBox6  .setEnabled(true);
           jTextField11.setEnabled(true);
           jTextField14.setEnabled(true);
           jTextField13.setEnabled(true);
           jTextField15.setEnabled(true);
           jTextField12.setEnabled(true);
           this.jTextField2.requestFocus();
  }
   public void DESABILITAR(){
           this.jTextField2.setEnabled(false);
           this.jTextField3.setEnabled(false); 
           this.jComboBox1. setEnabled(false);
           this.jTextField4.setEnabled(false);
           this.jTextField5.setEnabled(false);
           this.jTextField6.setEnabled(false);
           this.jTextField7.setEnabled(false);
           jTextField8.setEnabled(false);
           blue.setEnabled(false);
           jTextField18.setEnabled(false);
           jTextField17.setEnabled(false);
           jTextField16.setEnabled(false);
           jComboBox2  .setEnabled(false);
           jComboBox3  .setEnabled(false);
           jComboBox4  .setEnabled(false);
           jComboBox5  .setEnabled(false);
           jTextArea1  .setEnabled(false);
           jComboBox6  .setEnabled(false);
           jTextField11.setEnabled(false);
           jTextField14.setEnabled(false);
           jTextField13.setEnabled(false);
           jTextField15.setEnabled(false);
           jTextField12.setEnabled(false);
           }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JFormattedTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JFormattedTextField jTextField4;
    private javax.swing.JFormattedTextField jTextField5;
    private javax.swing.JFormattedTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
