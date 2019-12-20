
package actasyst;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

public class ConsultaBautismos extends javax.swing.JInternalFrame {

private static final long serialVersionUID = 1L;
CamSyst.Controlador.ClassConection conectar=new CamSyst.Controlador.ClassConection();
   Connection cn;
   CallableStatement cts;
   ResultSet r;
   String userName;
    String passWord;
   
    public ConsultaBautismos() {
        initComponents();
    
      cn=conectar.conecion();
      cargar();
      jTextField1.requestFocusInWindow();
      jTextField1.setEnabled(true);
      jTextField1.requestFocusInWindow();
      
    }
    public  void SelecionaBautismo(){
        int row=jTable1.getSelectedRow();
        String libroasent=  jTable1.getValueAt(row, 1) .toString();
        String pagina=      jTable1.getValueAt(row, 2) .toString();
        String noacta=      jTable1.getValueAt(row, 0) .toString();
        String parroquia=   jTable1.getValueAt(row, 22).toString();
        String direccion=   jTable1.getValueAt(row, 23).toString();
        String fechab=      jTable1.getValueAt(row, 8) .toString();
        String parroco=     jTable1.getValueAt(row, 20).toString();
        String nombreb=     jTable1.getValueAt(row, 3) .toString();
        String apellidob=   jTable1.getValueAt(row, 4) .toString();
        String sexo=        jTable1.getValueAt(row, 7) .toString();
        String lugarnaci=   jTable1.getValueAt(row, 6) .toString();
        String fechanaci=   jTable1.getValueAt(row, 5) .toString();
        String nompa=       jTable1.getValueAt(row, 9) .toString();
        String cedpa=       jTable1.getValueAt(row, 10).toString();
        String nomma =      jTable1.getValueAt(row, 11).toString();
        String cedma =      jTable1.getValueAt(row, 12).toString();
        String reg=         jTable1.getValueAt(row, 15).toString();
        String folio=       jTable1.getValueAt(row, 16).toString();
        String declaracion= jTable1.getValueAt(row, 17).toString();
        String anio=        jTable1.getValueAt(row, 18).toString();
        String circuns=     jTable1.getValueAt(row, 19).toString();
        String padrino=     jTable1.getValueAt(row, 13).toString();
        String madrina=     jTable1.getValueAt(row, 14).toString();
        String contmatr=    jTable1.getValueAt(row, 21).toString();
        String fecharegb=   jTable1.getValueAt(row, 24).toString();
        String otrasNotas=  jTable1.getValueAt(row, 25).toString();
         
         Bautismos.jComboBox5   .setSelectedItem(libroasent);
         Bautismos.jTextField23 .setText(pagina);
         Bautismos.jTextField1       .setText(noacta);
         Bautismos.jComboBox4        .setSelectedItem(parroquia);
         Bautismos.jTextField21      .setText(direccion);
         Bautismos.jTextField900     .setText(fechab);
         Bautismos.jTextField5       .setText(parroco);
         Bautismos.jTextField2       .setText(nombreb);
         Bautismos.jTextField3       .setText(apellidob);
         Bautismos.jComboBox1        .setSelectedItem(sexo);
         Bautismos.jTextField4       .setText(lugarnaci);
         Bautismos.jTextField901     .setText(fechanaci);
         Bautismos.jTextField7       .setText(nompa);
         Bautismos.jTextField8       .setText(cedpa);
         Bautismos.jTextField9       .setText(nomma);
         Bautismos.jTextField10      .setText(cedma);
         Bautismos.jTextField14      .setText(reg);
         Bautismos.jTextField12      .setText(folio);
         Bautismos.jTextField13      .setText(declaracion);
         Bautismos.jComboBox3        .setSelectedItem(anio);
         Bautismos.jComboBox2        .setSelectedItem(circuns);
         Bautismos.jTextField15      .setText(padrino);
         Bautismos.jTextField16      .setText(madrina);
         Bautismos.jTextField6       .setText(contmatr);
         Bautismos.jTextField902     .setText(fecharegb);
         Bautismos.jTextArea1        .setText(otrasNotas);

                Bautismos.jButton1.setEnabled(false);
                Bautismos.jButton2.setEnabled(false);
                Bautismos.jButton3.setEnabled(false);
                Bautismos.jButton5.setEnabled(true);
                Bautismos.jButton8.setEnabled(true);
                Bautismos.jButton9.setEnabled(true);
                Bautismos.jButton10.setEnabled(true);
            
    }
    public void abilitar (){
           Bautismos.jTextField1.setEnabled(true);
           Bautismos.jTextField2.setEnabled(true);
           Bautismos.jTextField3.setEnabled(true); 
           Bautismos.jTextField7.setEnabled(true);
           Bautismos.jTextField5.setEnabled(true);
           Bautismos.jTextField8.setEnabled(true);
           Bautismos.jTextField9.setEnabled(true);
           Bautismos.jTextField10.setEnabled(true);
           Bautismos.jTextField16.setEnabled(true);
           Bautismos.jTextField12.setEnabled(true);
           Bautismos.jTextField23.setEnabled(true);
           Bautismos.jComboBox1.setEnabled(true);
           Bautismos.jComboBox2.setEnabled(true);
           Bautismos.jTextField4.setEnabled(true);
           Bautismos.jComboBox3.setEnabled(true);
           Bautismos.jTextField15.setEnabled(true);
           Bautismos.jTextField14.setEnabled(true);
           Bautismos.jComboBox5.setEnabled(true);
           Bautismos.jTextField6.setEnabled(true);
           Bautismos.jComboBox4.setEnabled(true);
           Bautismos.jTextField21.setEnabled(true);
           Bautismos.jTextArea1.setEnabled(true);
           Bautismos.jTextField901.setEnabled(true);
           Bautismos.jTextField900.setEnabled(true);
           Bautismos.jTextField2.requestFocus();
           Bautismos.jTextField13.setEnabled(true);
           Bautismos.jTextField902.setEnabled(true);
           
    }
    private void cargarfiltro(){
   
        String x=jTextField1.getText();
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("No.Acta");
         tabla.addColumn("Libro Asent.");
       tabla.addColumn("Pagina");
       tabla.addColumn("Nombre Bautizado/a");
       tabla.addColumn("Apellido Bautizado/a");
       tabla.addColumn("Fecha Nacimiento");
       tabla.addColumn("Lugar Nacimiento");
       tabla.addColumn("sexo");
       tabla.addColumn("Fecha Bautismo");
       tabla.addColumn("Nombre Padre");
       tabla.addColumn("CedulaP.");
       tabla.addColumn("Nombre Madre");
       tabla.addColumn("CedulaM.");
       tabla.addColumn("Padrino");
       tabla.addColumn("Madrina");
       tabla.addColumn("RegistroNo");
       tabla.addColumn("Folio");
       tabla.addColumn("DeclaracionNo");
       tabla.addColumn("Año");
       tabla.addColumn("Circunscripcion");
       tabla.addColumn("Nombre Rev.Parroco");
       tabla.addColumn("Contrajo Matrimonio Con");
       tabla.addColumn("En la parroquia");
       tabla.addColumn("Direccion");
       tabla.addColumn("Fecha");
       tabla.addColumn("Otras Notas");
       
         cts=cn.prepareCall("{call mostrarBautismosfiltro(?)}");
         cts.setString(1, x);
       r=cts.executeQuery();
       
       while (r.next()){
       Object dato[]=new  Object[26];
       for (int i=0; i<26; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       jLabel2.setText(""+jTable1.getRowCount());
       
       }catch (Exception e){}
    }    
    
    private void cargar(){
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("No.Acta");
         tabla.addColumn("Libro Asent.");
       tabla.addColumn("Pagina");
       tabla.addColumn("Nombre Bautizado/a");
       tabla.addColumn("Apellido Bautizado/a");
       tabla.addColumn("Fecha Nacimiento");
       tabla.addColumn("Lugar Nacimiento");
       tabla.addColumn("sexo");
       tabla.addColumn("Fecha Bautismo");
       tabla.addColumn("Nombre Padre");
       tabla.addColumn("CedulaP.");
       tabla.addColumn("Nombre Madre");
       tabla.addColumn("CedulaM.");
       tabla.addColumn("Padrino");
       tabla.addColumn("Madrina");
       tabla.addColumn("RegistroNo");
       tabla.addColumn("Folio");
       tabla.addColumn("DeclaracionNo");
       tabla.addColumn("Año");
       tabla.addColumn("Circunscripcion");
       tabla.addColumn("Nombre Rev.Parroco");
       tabla.addColumn("Contrajo Matrimonio Con");
       tabla.addColumn("En la parroquia");
       tabla.addColumn("Direccion");
       tabla.addColumn("Fecha");
       tabla.addColumn("Otras Notas");
       
         cts=cn.prepareCall("{call mostrarBautismos}");
         r=cts.executeQuery();
       
       while (r.next()){
       Object dato[]=new  Object[26];
       for (int i=0; i<26; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       jLabel2.setText(""+jTable1.getRowCount());
       
       }catch (Exception e){}}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1476487154_Back_Previous_Move_Arrow_Direction.png"))); // NOI18N
        jMenuItem1.setText("Enviar al formulario");
        jMenuItem1.setToolTipText("enviar al formulario para editar o imprimir");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1476487247_InterfaceExpendet-01.png"))); // NOI18N
        jMenuItem3.setText("Actualizar");
        jMenuItem3.setToolTipText("Actualizar listado de registro");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CONSULTA DE BAUTISMOS");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setText("Buscar Bautismo por Apellido:");
        jRadioButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setText("Buscar Bautismo por Nombre:");
        jRadioButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(51, 102, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451537142_Help_mark_query_question_support_talk.png"))); // NOI18N
        jButton1.setToolTipText("Buscar");
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(33, 33, 33)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jRadioButton2))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Nombre del bautizado", "Apellido del bautizado", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(51, 51, 255));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(new java.awt.Color(102, 102, 255));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setMinWidth(170);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(170);
            jTable1.getColumnModel().getColumn(3).setMinWidth(170);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(170);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
            jTable1.getColumnModel().getColumn(8).setResizable(false);
            jTable1.getColumnModel().getColumn(9).setResizable(false);
            jTable1.getColumnModel().getColumn(10).setResizable(false);
            jTable1.getColumnModel().getColumn(11).setResizable(false);
            jTable1.getColumnModel().getColumn(12).setResizable(false);
            jTable1.getColumnModel().getColumn(13).setResizable(false);
            jTable1.getColumnModel().getColumn(14).setResizable(false);
            jTable1.getColumnModel().getColumn(15).setResizable(false);
            jTable1.getColumnModel().getColumn(16).setResizable(false);
            jTable1.getColumnModel().getColumn(17).setResizable(false);
            jTable1.getColumnModel().getColumn(18).setResizable(false);
            jTable1.getColumnModel().getColumn(19).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad de registros:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("jLabel2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Todo los registros");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField1.setEnabled(true);
        jTextField1.requestFocus();
        
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
            String X=jTextField1.getText();
                
      if (jRadioButton1.isSelected()==true){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("No.Acta");
         tabla.addColumn("Libro Asent.");
       tabla.addColumn("Pagina");
       tabla.addColumn("Nombre Bautizado/a");
       tabla.addColumn("Apellido Bautizado/a");
       tabla.addColumn("Fecha Nacimiento");
       tabla.addColumn("Lugar Nacimiento");
       tabla.addColumn("sexo");
       tabla.addColumn("Fecha Bautismo");
       tabla.addColumn("Nombre Padre");
       tabla.addColumn("CedulaP.");
       tabla.addColumn("Nombre Madre");
       tabla.addColumn("CedulaM.");
       tabla.addColumn("Padrino");
       tabla.addColumn("Madrina");
       tabla.addColumn("RegistroNo");
       tabla.addColumn("Folio");
       tabla.addColumn("DeclaracionNo");
       tabla.addColumn("Año");
       tabla.addColumn("Circunscripcion");
       tabla.addColumn("Nombre Rev.Parroco");
       tabla.addColumn("Contrajo Matrimonio Con");
       tabla.addColumn("En la parroquia");
       tabla.addColumn("Direccion");
       tabla.addColumn("Fecha");
       tabla.addColumn("Otras Notas");
         cts=cn.prepareCall("{call mostrarPorNom(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[26];
       for (int i=0; i<26; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
jLabel2.setText(""+jTable1.getRowCount());

       }catch (Exception e){}
       
    }
    else if(jRadioButton2.isSelected()==true){
     DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("No.Acta");
         tabla.addColumn("Libro Asent.");
       tabla.addColumn("Pagina");
       tabla.addColumn("Nombre Bautizado/a");
       tabla.addColumn("Apellido Bautizado/a");
       tabla.addColumn("Fecha Nacimiento");
       tabla.addColumn("Lugar Nacimiento");
       tabla.addColumn("sexo");
       tabla.addColumn("Fecha Bautismo");
       tabla.addColumn("Nombre Padre");
       tabla.addColumn("CedulaP.");
       tabla.addColumn("Nombre Madre");
       tabla.addColumn("CedulaM.");
       tabla.addColumn("Padrino");
       tabla.addColumn("Madrina");
       tabla.addColumn("RegistroNo");
       tabla.addColumn("Folio");
       tabla.addColumn("DeclaracionNo");
       tabla.addColumn("Año");
       tabla.addColumn("Circunscripcion");
       tabla.addColumn("Nombre Rev.Parroco");
       tabla.addColumn("Contrajo Matrimonio Con");
       tabla.addColumn("En la parroquia");
       tabla.addColumn("Direccion");
       tabla.addColumn("Fecha");
       tabla.addColumn("Otras Notas");
             cts=cn.prepareCall("{call mostrarPorApe(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[26];
       for (int i=0; i<26; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
jLabel2.setText(""+jTable1.getRowCount());
       }catch (Exception e){}
    
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField1.setEnabled(true);
        jTextField1.requestFocus();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jTextField1.setEnabled(true);
        cargarfiltro();
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

     SelecionaBautismo();
     abilitar ();
     dispose();
     JOptionPane.showMessageDialog(rootPane, "Bautismo Añadido Correctamente");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       cargar(); 
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       cargarfiltro();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       jTable1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER && userName.equals("Administrador")){
       Bautismos p=new Bautismos();
       ActaS.jDesktopPane1.add(p);
       p.show();
       p.setLocation(50, 5);
       p.setVisible(true);            
       SelecionaBautismo();
       abilitar ();
       this.jTextField1.setText("");
       jTextField1.requestFocusInWindow();   
       
       
        }else if(evt.getKeyCode() == KeyEvent.VK_ENTER && userName.equals("Secretaria")){
       Bautismos p=new Bautismos();
       ActaSSecre.jDesktopPane1.add(p);
       p.show();
       p.setLocation(50, 5);
       p.setVisible(true);
       SelecionaBautismo();
       abilitar ();
       }else dispose();             
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       if(userName.equals("Administrador")){
       Bautismos p=new Bautismos();
       ActaS.jDesktopPane1.add(p);
       p.show();
       p.setLocation(50, 5);
       p.setVisible(true);            
       SelecionaBautismo();
       abilitar ();
       this.jTextField1.setText("");
       jTextField1.requestFocusInWindow();   
       
       
        }else if(userName.equals("Secretaria")){
       Bautismos p=new Bautismos();
       ActaSSecre.jDesktopPane1.add(p);
       p.show();
       p.setLocation(50, 5);
       p.setVisible(true);
       SelecionaBautismo();
       abilitar ();
       }else dispose(); 
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    
}
