
package CamSyst;

import CamSyst.Controlador.ClassConection;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Modulos extends javax.swing.JInternalFrame {
    
   Connection con;
   CallableStatement cts;
   PreparedStatement st;
   ResultSet r;
   
   ClassConection conectar= new ClassConection();

    public Modulos() {
        initComponents();
         con=conectar.conecion();
         cargar();
         desabilitar();
    }
    
  

/* La clase JFrame encapsula el concepto de una ventana, para implementar una aplicación que muestre una ventana debemos plantear una clase que herede de la clase JFrame */

private void limpiar(){
jTextField1.setText("");
jTextField2.setText("");
jPasswordField1.setText("");
jPasswordField2.setText("");
jComboBox1.setSelectedItem(0);

}    

private void habilitar(){
    jTextField1.setEnabled(true);
    //jTextField2.setEnabled(true);
    jPasswordField1.setEnabled(true);
    jPasswordField2.setEnabled(true);
    jComboBox1.setEnabled(true);
    jButton5.setEnabled(true);
}
private void desabilitar(){
    jTextField1.setEnabled(false);
    jTextField2.setEnabled(false);
    jPasswordField1.setEnabled(false);
    jPasswordField2.setEnabled(false);
    jComboBox1.setEnabled(false);
    //jComboBox1.setEnabled(false);
    
    }
private void registrarUsuario(){
        String iduser=          jTextField2.getText();
        String nick=            jTextField1.getText();
        String pass      =      jPasswordField1.getText();
        String confirpass    =  jPasswordField1.getText();
        String tipo =           jComboBox1.getSelectedItem().toString();
        
         try {
            cts=con.prepareCall("{call registrarusuario(?,?,?,?,?)}");
            cts.setString(1, iduser);
            cts.setString(2, nick);
            cts.setString(3, pass);
            cts.setString(4, confirpass);
            cts.setString(5, tipo);
            
            int rpta=cts.executeUpdate();
           if(rpta==1)
             JOptionPane.showMessageDialog(this,"Informacion Registrada correctamente!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
             JOptionPane.showMessageDialog(this,"Operacion no completada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }   
}
private void modificarUsuario(){
        String iduser=          jTextField2.getText();
        String nick=            jTextField1.getText();
        String pass      =      jPasswordField1.getText();
        String confirpass    =  jPasswordField1.getText();
        String tipo =           jComboBox1.getSelectedItem().toString();
        
         try {
            cts=con.prepareCall("{call modificarUsuario(?,?,?,?,?)}");
            cts.setString(1, iduser);
            cts.setString(2, nick);
            cts.setString(3, pass);
            cts.setString(4, confirpass);
            cts.setString(5, tipo);
            
            int rpta=cts.executeUpdate();
           if(rpta==1)
             JOptionPane.showMessageDialog(this,"Usuario modificado correctamente!!","Atencion",JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
             JOptionPane.showMessageDialog(this,"Operacion no completada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
             
        }   

}
private void bloquear(){
 jCheckBox1.setEnabled(false);  jCheckBox11.setEnabled(false);jCheckBox21.setEnabled(false); jCheckBox31.setEnabled(false);jCheckBox41.setEnabled(false); jCheckBox51.setEnabled(false);
 jCheckBox12.setEnabled(false);jCheckBox22.setEnabled(false); jCheckBox32.setEnabled(false);jCheckBox42.setEnabled(false); jCheckBox52.setEnabled(false);
 jCheckBox3.setEnabled(false);  jCheckBox13.setEnabled(false);jCheckBox23.setEnabled(false); jCheckBox33.setEnabled(false);jCheckBox43.setEnabled(false); jCheckBox53.setEnabled(false);
 jCheckBox4.setEnabled(false);  jCheckBox14.setEnabled(false);jCheckBox24.setEnabled(false); jCheckBox34.setEnabled(false);jCheckBox44.setEnabled(false); jCheckBox54.setEnabled(false);
 jCheckBox5.setEnabled(false);  jCheckBox15.setEnabled(false);jCheckBox25.setEnabled(false); jCheckBox35.setEnabled(false);jCheckBox45.setEnabled(false); jCheckBox55.setEnabled(false);
 jCheckBox6.setEnabled(false);  jCheckBox16.setEnabled(false);jCheckBox26.setEnabled(false); jCheckBox36.setEnabled(false);jCheckBox46.setEnabled(false); jCheckBox56.setEnabled(false);
 jCheckBox7.setEnabled(false);  jCheckBox17.setEnabled(false);jCheckBox27.setEnabled(false); jCheckBox37.setEnabled(false);jCheckBox47.setEnabled(false); jCheckBox57.setEnabled(false);
 jCheckBox8.setEnabled(false);  jCheckBox18.setEnabled(false);jCheckBox28.setEnabled(false); jCheckBox38.setEnabled(false);jCheckBox48.setEnabled(false); 
 jCheckBox9.setEnabled(false);  jCheckBox19.setEnabled(false);jCheckBox29.setEnabled(false); jCheckBox39.setEnabled(false);jCheckBox49.setEnabled(false); 
jCheckBox10.setEnabled(false);  jCheckBox20.setEnabled(false);jCheckBox30.setEnabled(false); jCheckBox40.setEnabled(false);jCheckBox50.setEnabled(false);                   

}
private void Administrador(){
       jCheckBox1.setSelected(true);  jCheckBox21.setSelected(true);  jCheckBox41.setSelected(true);
       jCheckBox22.setSelected(true); jCheckBox42.setSelected(true);
       jCheckBox3.setSelected(true);  jCheckBox23.setSelected(true);  jCheckBox43.setSelected(true);
       jCheckBox4.setSelected(true);  jCheckBox24.setSelected(true);  jCheckBox44.setSelected(true);
       jCheckBox5.setSelected(true);  jCheckBox25.setSelected(true);  jCheckBox45.setSelected(true);
       jCheckBox6.setSelected(true);  jCheckBox26.setSelected(true);  jCheckBox46.setSelected(true);
       jCheckBox7.setSelected(true);  jCheckBox27.setSelected(true);  jCheckBox47.setSelected(true);
       jCheckBox8.setSelected(true);  jCheckBox28.setSelected(false); jCheckBox48.setSelected(true);
       jCheckBox9.setSelected(true);  jCheckBox29.setSelected(true);  jCheckBox49.setSelected(true);
       jCheckBox10.setSelected(true); jCheckBox30.setSelected(true);  jCheckBox50.setSelected(true);
       jCheckBox11.setSelected(true); jCheckBox31.setSelected(true);  jCheckBox51.setSelected(true);
       jCheckBox12.setSelected(true); jCheckBox32.setSelected(true);  jCheckBox52.setSelected(true);
       jCheckBox13.setSelected(true); jCheckBox33.setSelected(true);  jCheckBox53.setSelected(true);
       jCheckBox14.setSelected(true); jCheckBox34.setSelected(true);  jCheckBox54.setSelected(true);  
       jCheckBox15.setSelected(true); jCheckBox35.setSelected(true);  jCheckBox55.setSelected(true);
       jCheckBox16.setSelected(true); jCheckBox36.setSelected(true);  jCheckBox56.setSelected(true);
       jCheckBox17.setSelected(true); jCheckBox37.setSelected(true);  jCheckBox57.setSelected(true);
       jCheckBox18.setSelected(true); jCheckBox38.setSelected(true);
       jCheckBox19.setSelected(true); jCheckBox39.setSelected(true);
       jCheckBox20.setSelected(true); jCheckBox40.setSelected(true);
         
       //jcheckbox28 es del programador
  
   
   }
private void Encargado(){
       jCheckBox1.setSelected(true);
//       jCheckBox2.setSelected(true);
       jCheckBox3.setSelected(true);
       jCheckBox4.setSelected(true);
       jCheckBox5.setSelected(true);
       jCheckBox6.setSelected(true);
       jCheckBox7.setSelected(true);
       jCheckBox8.setSelected(true);
       jCheckBox9.setSelected(true);
       jCheckBox10.setSelected(true);
       jCheckBox11.setSelected(true);
       jCheckBox12.setSelected(true);
       jCheckBox13.setSelected(true);
       jCheckBox14.setSelected(true);      
       jCheckBox15.setSelected(true);
       jCheckBox16.setSelected(true);
       jCheckBox17.setSelected(true);
       jCheckBox18.setSelected(true);
       jCheckBox19.setSelected(true);
       jCheckBox20.setSelected(true);
       jCheckBox21.setSelected(true);
       jCheckBox22.setSelected(true);
       jCheckBox23.setSelected(true);
       jCheckBox24.setSelected(false);
       jCheckBox25.setSelected(true);
       jCheckBox26.setSelected(true);
       jCheckBox27.setSelected(false);
       jCheckBox28.setSelected(false);
       jCheckBox28.setEnabled(false);
       jCheckBox29.setSelected(true);      
       jCheckBox30.setSelected(false);
       jCheckBox31.setSelected(false);
       jCheckBox32.setSelected(false);
       jCheckBox33.setSelected(false);
       jCheckBox34.setSelected(false);
       jCheckBox35.setSelected(false);
       jCheckBox36.setSelected(true);
       jCheckBox37.setSelected(true);
       jCheckBox38.setSelected(false);
       jCheckBox39.setSelected(false);
       jCheckBox40.setSelected(true);
       jCheckBox41.setSelected(true);
       jCheckBox42.setSelected(false);
       jCheckBox43.setSelected(false);
       jCheckBox44.setSelected(false);      
       jCheckBox45.setSelected(false);
       jCheckBox46.setSelected(false);
       jCheckBox47.setSelected(false);
       jCheckBox48.setSelected(false);
       jCheckBox49.setSelected(false);
       jCheckBox50.setSelected(true);
       jCheckBox51.setSelected(true);
       jCheckBox52.setSelected(true);
       jCheckBox53.setSelected(true);
       jCheckBox54.setSelected(true);
       jCheckBox55.setSelected(false);
       jCheckBox56.setSelected(false);
       jCheckBox57.setSelected(true);
      
   
   }

private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("CODIGO");
       tabla.addColumn("USUARIO");
       tabla.addColumn("CONTRASEÑA");
       tabla.addColumn("TIPO");
       
         cts=con.prepareCall("{call mostrarUsuario}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[4];
       for (int i=0; i<4; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable2.setModel(tabla);
jLabel50.setText(""+jTable2.getRowCount());
       }catch (Exception e){}

}
private void eliminarUsuario(){
String iduser=this.jTextField2.getText();
        try {
            cts=con.prepareCall("{call eliminarUsuario(?)}");
            cts.setString(1, iduser);
            int rpta=cts.executeUpdate();

            if(rpta==1){
                JOptionPane.showMessageDialog(this, "Usuario Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                desabilitar();
                cargar();

            }else {
                JOptionPane.showMessageDialog(this, "Usuario No Eliminado","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jCheckBox12 = new javax.swing.JCheckBox();
        jCheckBox13 = new javax.swing.JCheckBox();
        jCheckBox14 = new javax.swing.JCheckBox();
        jCheckBox21 = new javax.swing.JCheckBox();
        jCheckBox22 = new javax.swing.JCheckBox();
        jCheckBox23 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox15 = new javax.swing.JCheckBox();
        jCheckBox16 = new javax.swing.JCheckBox();
        jCheckBox17 = new javax.swing.JCheckBox();
        jCheckBox18 = new javax.swing.JCheckBox();
        jCheckBox9 = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox10 = new javax.swing.JCheckBox();
        jCheckBox11 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox8 = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox19 = new javax.swing.JCheckBox();
        jPanel7 = new javax.swing.JPanel();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jCheckBox27 = new javax.swing.JCheckBox();
        jCheckBox28 = new javax.swing.JCheckBox();
        jCheckBox29 = new javax.swing.JCheckBox();
        jCheckBox36 = new javax.swing.JCheckBox();
        jCheckBox50 = new javax.swing.JCheckBox();
        jCheckBox57 = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jCheckBox20 = new javax.swing.JCheckBox();
        jCheckBox30 = new javax.swing.JCheckBox();
        jCheckBox35 = new javax.swing.JCheckBox();
        jCheckBox33 = new javax.swing.JCheckBox();
        jCheckBox48 = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jCheckBox37 = new javax.swing.JCheckBox();
        jCheckBox38 = new javax.swing.JCheckBox();
        jCheckBox39 = new javax.swing.JCheckBox();
        jCheckBox40 = new javax.swing.JCheckBox();
        jCheckBox41 = new javax.swing.JCheckBox();
        jCheckBox42 = new javax.swing.JCheckBox();
        jCheckBox43 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jCheckBox44 = new javax.swing.JCheckBox();
        jCheckBox45 = new javax.swing.JCheckBox();
        jCheckBox46 = new javax.swing.JCheckBox();
        jCheckBox47 = new javax.swing.JCheckBox();
        jCheckBox49 = new javax.swing.JCheckBox();
        jCheckBox31 = new javax.swing.JCheckBox();
        jCheckBox32 = new javax.swing.JCheckBox();
        jCheckBox34 = new javax.swing.JCheckBox();
        jPanel11 = new javax.swing.JPanel();
        jCheckBox51 = new javax.swing.JCheckBox();
        jCheckBox52 = new javax.swing.JCheckBox();
        jCheckBox53 = new javax.swing.JCheckBox();
        jCheckBox54 = new javax.swing.JCheckBox();
        jCheckBox55 = new javax.swing.JCheckBox();
        jCheckBox56 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sistema", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox12.setText("Datos de la empresa");

        jCheckBox13.setText("Configuracion de idioma");

        jCheckBox14.setText("Uso del sistema");

        jCheckBox21.setText("Usuarios");

        jCheckBox22.setText("Programador");

        jCheckBox23.setText("Backup");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox12)
                            .addComponent(jCheckBox14)
                            .addComponent(jCheckBox21)
                            .addComponent(jCheckBox22)
                            .addComponent(jCheckBox23))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox23)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administracion de Permisos y ventanas disponibles para el usuario");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo de usuario", "Administrador", "Encargado", "Asistente", "Cajer@s", "Atencion", "Programador" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Usuario");

        jLabel3.setText("Password");

        jLabel4.setText("Repetir password");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Datos de modulo");

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tareas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox15.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox15.setText("Facturacion");

        jCheckBox16.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox16.setText("Ingreso pedidos");

        jCheckBox17.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox17.setText("Devoluciones");

        jCheckBox18.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox18.setText("Gastos & Ingresos");

        jCheckBox9.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox9.setText("Cliente");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Mantenimiento");

        jCheckBox10.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox10.setText("Producto");

        jCheckBox11.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox11.setText("Proveedor");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox11)
                            .addComponent(jCheckBox10)
                            .addComponent(jCheckBox15)
                            .addComponent(jCheckBox16)
                            .addComponent(jCheckBox17)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jCheckBox15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(153, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox3.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox3.setText("Cliente");

        jCheckBox4.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox4.setText("Factura cliente");

        jCheckBox5.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox5.setText("Factura proveedor");

        jCheckBox6.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox6.setText("Abonos");

        jCheckBox7.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox7.setText("Productos");

        jCheckBox8.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox8.setText("Lista de precios");

        jCheckBox1.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox1.setText("Proveedor");

        jCheckBox19.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox19.setText("Empleado");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox5)
                            .addComponent(jCheckBox6)
                            .addComponent(jCheckBox7)
                            .addComponent(jCheckBox8)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(153, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sistema", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox24.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox24.setText("Datos de la empresa");

        jCheckBox25.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox25.setText("Configuracion de idioma");

        jCheckBox26.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox26.setText("Uso del sistema");

        jCheckBox27.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox27.setText("Usuarios");

        jCheckBox28.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox28.setText("Programador");

        jCheckBox29.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox29.setText("Backup");

        jCheckBox36.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox36.setText("Acerca de");

        jCheckBox50.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox50.setText("Cerrar seccion");

        jCheckBox57.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox57.setText("Salir");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox24)
                            .addComponent(jCheckBox26)
                            .addComponent(jCheckBox27)
                            .addComponent(jCheckBox28)
                            .addComponent(jCheckBox29)
                            .addComponent(jCheckBox36)
                            .addComponent(jCheckBox50)
                            .addComponent(jCheckBox57))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox57))
        );

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrador", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox20.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox20.setText("Productos A Pedir");

        jCheckBox30.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox30.setText("Registro de actividades");

        jCheckBox35.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox35.setText("Gestion Empleado");

        jCheckBox33.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox33.setText("Impresiones");

        jCheckBox48.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox48.setText("Bancos");
        jCheckBox48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox48ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox20)
                            .addComponent(jCheckBox35)
                            .addComponent(jCheckBox33))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jCheckBox48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox48)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(153, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reportes", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox37.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox37.setText("cuadre diario");

        jCheckBox38.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox38.setText("Reporte mensual");

        jCheckBox39.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox39.setText("Reporte anual");

        jCheckBox40.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox40.setText("Ingreso");

        jCheckBox41.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox41.setText("Gastos");
        jCheckBox41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox41ActionPerformed(evt);
            }
        });

        jCheckBox42.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox42.setText("Estadistica");

        jCheckBox43.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox43.setText("Total Inventario");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox38, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox39)
                            .addComponent(jCheckBox42)
                            .addComponent(jCheckBox43)
                            .addComponent(jCheckBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jCheckBox40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addComponent(jCheckBox41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox43)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(153, 204, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RR.HH", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox44.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox44.setText("Contrato");

        jCheckBox45.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox45.setText("Licencia");
        jCheckBox45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox45ActionPerformed(evt);
            }
        });

        jCheckBox46.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox46.setText("Vacaciones");

        jCheckBox47.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox47.setText("Ingresos");
        jCheckBox47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox47ActionPerformed(evt);
            }
        });

        jCheckBox49.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox49.setText("Descuento");

        jCheckBox31.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox31.setText("Prestamo");

        jCheckBox32.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox32.setText("TSS");

        jCheckBox34.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox34.setText("Nominas");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox46)
                                    .addComponent(jCheckBox49)
                                    .addComponent(jCheckBox47, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 28, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox31)
                            .addComponent(jCheckBox32)
                            .addComponent(jCheckBox34))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(153, 204, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contabilidad", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jCheckBox51.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox51.setText("Cuentas por pagar");

        jCheckBox52.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox52.setText("Cuentas por cobrar");
        jCheckBox52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox52ActionPerformed(evt);
            }
        });

        jCheckBox53.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox53.setText("Desembolso");

        jCheckBox54.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox54.setText("Abonos");

        jCheckBox55.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox55.setText("Bancos");
        jCheckBox55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox55ActionPerformed(evt);
            }
        });

        jCheckBox56.setBackground(new java.awt.Color(153, 204, 255));
        jCheckBox56.setText("Diario general");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBox53)
                                    .addComponent(jCheckBox56)
                                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jCheckBox54, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(jCheckBox55, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox55)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox56)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jTable2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable2.setSelectionBackground(new java.awt.Color(0, 204, 204));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-32.png"))); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454378002_Add-Male-User.png"))); // NOI18N
        jButton4.setText("Nuevo");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jButton5.setText("Crear");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/698873-icon-136-document-edit-32.png"))); // NOI18N
        jButton6.setText("Modificar");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyTyped(evt);
            }
        });

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setText("Id User");

        jLabel50.setText("jLabel8");

        jLabel8.setText("Registros");

        jLabel9.setText("Nombre del modulo");

        jLabel10.setText("Id Modulo");

        jTextField4.setEditable(false);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jPasswordField1)
                                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel4))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton6)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(5, 5, 5))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jButton4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton5)
                            .addGap(14, 14, 14)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel50))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44))))
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Usuarios", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Lista de Uasurios ", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox55ActionPerformed

    private void jCheckBox52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox52ActionPerformed

    private void jCheckBox47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox47ActionPerformed

    private void jCheckBox45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox45ActionPerformed

    private void jCheckBox41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox41ActionPerformed

    private void jCheckBox48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox48ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals("Administrador")){
            bloquear();
            Administrador();
        }
        if(jComboBox1.getSelectedItem().equals("Encargado")){
            bloquear();
            Encargado();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       registrarUsuario();
       limpiar();
       desabilitar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     try{
         habilitar();
         jTextField1.requestFocusInWindow();
         cts=con.prepareCall("{call numeroiduser}");
         r=cts.executeQuery();
         if (r.next())
        
          jTextField2.setText(r.getString(1));
          }catch (Exception e){} 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
      char teclapre=evt.getKeyChar();
        if((teclapre) == KeyEvent.VK_ENTER) {
            jPasswordField1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jPasswordField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyTyped
         char teclapre=evt.getKeyChar();
        if((teclapre) == KeyEvent.VK_ENTER) {
            jPasswordField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jPasswordField1KeyTyped

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
       int row=       jTable2.getSelectedRow();
        String cod=     jTable2.getValueAt(row, 0).toString();
        String nick=     jTable2.getValueAt(row, 1).toString();
        String pass=  jTable2.getValueAt(row, 2).toString();
        String tipo=    jTable2.getValueAt(row, 3).toString();
    
        jTextField2.setText(cod);
        jTextField1.setText(nick);
        jPasswordField1.setText(pass);
        jPasswordField2.setText(pass);
        jComboBox1.setSelectedItem(tipo);
        
        
        JOptionPane.showMessageDialog(this,"Usuario Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
        habilitar();
        jButton5.setEnabled(false);
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       modificarUsuario();
       cargar();
       limpiar();
       desabilitar();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        eliminarUsuario();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//       newjframe();
    }//GEN-LAST:event_jButton2ActionPerformed

            public void run() {
                new Modulos().setVisible(true);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox10;
    private javax.swing.JCheckBox jCheckBox11;
    private javax.swing.JCheckBox jCheckBox12;
    private javax.swing.JCheckBox jCheckBox13;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jCheckBox15;
    private javax.swing.JCheckBox jCheckBox16;
    private javax.swing.JCheckBox jCheckBox17;
    private javax.swing.JCheckBox jCheckBox18;
    private javax.swing.JCheckBox jCheckBox19;
    private javax.swing.JCheckBox jCheckBox20;
    private javax.swing.JCheckBox jCheckBox21;
    private javax.swing.JCheckBox jCheckBox22;
    private javax.swing.JCheckBox jCheckBox23;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
    private javax.swing.JCheckBox jCheckBox27;
    private javax.swing.JCheckBox jCheckBox28;
    private javax.swing.JCheckBox jCheckBox29;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox30;
    private javax.swing.JCheckBox jCheckBox31;
    private javax.swing.JCheckBox jCheckBox32;
    private javax.swing.JCheckBox jCheckBox33;
    private javax.swing.JCheckBox jCheckBox34;
    private javax.swing.JCheckBox jCheckBox35;
    private javax.swing.JCheckBox jCheckBox36;
    private javax.swing.JCheckBox jCheckBox37;
    private javax.swing.JCheckBox jCheckBox38;
    private javax.swing.JCheckBox jCheckBox39;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox40;
    private javax.swing.JCheckBox jCheckBox41;
    private javax.swing.JCheckBox jCheckBox42;
    private javax.swing.JCheckBox jCheckBox43;
    private javax.swing.JCheckBox jCheckBox44;
    private javax.swing.JCheckBox jCheckBox45;
    private javax.swing.JCheckBox jCheckBox46;
    private javax.swing.JCheckBox jCheckBox47;
    private javax.swing.JCheckBox jCheckBox48;
    private javax.swing.JCheckBox jCheckBox49;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox50;
    private javax.swing.JCheckBox jCheckBox51;
    private javax.swing.JCheckBox jCheckBox52;
    private javax.swing.JCheckBox jCheckBox53;
    private javax.swing.JCheckBox jCheckBox54;
    private javax.swing.JCheckBox jCheckBox55;
    private javax.swing.JCheckBox jCheckBox56;
    private javax.swing.JCheckBox jCheckBox57;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JCheckBox jCheckBox9;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
