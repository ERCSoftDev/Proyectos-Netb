
package CamSyst.Proveedor;

import CamSyst.Vista.CamS;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import CamSyst.Controlador.ClassConection;
import CamSyst.Controlador.Reportes;
import static CamSyst.Vista.CamS.jLabel6;
import CamSyst.Vista.vendedor;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Connection;


public final class Pedidos extends javax.swing.JInternalFrame {
 
   ClassConection conectar=new ClassConection();    
   String userName;
   String passWord;
   
  public static Connection cn;
  public static CallableStatement cts;
  public static ResultSet r;
   String sql;
   
    
   
public Pedidos() throws SQLException {
        initComponents();            
        cn=conectar.conecion();
  
      //   jTextField2.setText(""+user);
         operac(); 
         this.desc1.setEnabled(false);
         this.jTextField3.setEnabled(false);
       
          Calendar cal=Calendar.getInstance();
          String fecha2=cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
          this.fecha.setText(fecha2);
          this.fecha.setEnabled(true);

}
    private static double redondearItbis   (double itb,int numDecimal)   {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*itb+0.5)/p;
    
}
    private static double redondearTotal   (double itb,int numDecimal)   {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*itb+0.5)/p;
    
}
    public static void ajustarcolumnas(){
     TableColumn columna =null;
     for(int i=0;i<=7;i++){
         //jtableDetalle.requestFocus();
         columna=jtableDetalle.getColumnModel().getColumn(i);
         if(i==0){
             columna.setPreferredWidth(7);
            
         }
         else if(i==1){
              columna.setPreferredWidth(50);
         }
          else if(i==2){
              columna.setPreferredWidth(20);
         }
         else {
            columna.setPreferredWidth(40); 
         }
     }
 }
    private void       GeneraNum()      {
     try{
        
       cts=cn.prepareCall("{call Genera_num_Factura}");
       r=cts.executeQuery();
       if (r.next())
        
         jTextField1.setText(r.getString(1));
           }catch (Exception e){} 
}
    private void       imprim()         {
    try{
    String rutaInforme= "C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\PedidosProveedor.jrxml";
        Reportes re= new Reportes();
        Map parametros = new HashMap();
        parametros.put("n_fac",jTextField1.getText());
        re.verReport(rutaInforme,parametros);

        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
    public static void operac()         {
         double suma;
         double subtot=0;
         double des;
         double itc = 0;
         double itbc;
         double total = 0;

             for(int i=0;i<jtableDetalle.getRowCount();i++){
             String precioL= jtableDetalle.getValueAt(i, 5).toString();
             String Itbis= jtableDetalle. getValueAt(i, 6).toString();
             String cantidad= jtableDetalle. getValueAt(i, 4).toString();
             int c=Integer.parseInt(cantidad);
             double d=Double.parseDouble(precioL);
             double ic=Double.parseDouble(Itbis);
             double val3 = Integer.parseInt(jComboBox2.getSelectedItem().toString()); 
             
             suma=c*d;
             subtot+=suma; 
             des=(subtot*val3)/100;
             itbc=subtot*0.18;
             itc=itbc;
             total=(subtot+itc)-des;
             jtableDetalle.setValueAt(suma, i, 7);
             //jtableDetalle.setValueAt(precioL, i, 7);
             ///jtableDetalle.setValueAt(itbc, i, 7);
             subtotal.setText(""+redondearTotal(subtot,2));
             desc1.setText(""+des);
             itbis.setText(""+redondearItbis(itc,2));
             total1.setText(""+redondearTotal(total,2));  
       
             // String sd = Double.toString(sumades); 
             //desc1.setText(String.valueOf(sumades)); 
             
        }

   }
    public static void operac1()         {

         double subtotales = 0;
         double itbs=0;
         double total=0;

          {
             
             double val3 = Double.parseDouble(desc1.getText());
             double val4 = Double.parseDouble(subtotal.getText()); 
            // double val5 = Double.parseDouble(subtotal.getText()); 
             
           
             subtotales=(val4-val3);
             itbs=subtotales*0.18;
             total=subtotales+itbs;

             subtotal.setText(""+redondearTotal(subtotales,2));  
             itbis   .setText(""+redondearTotal(itbs,2));
             total1   .setText(""+redondearTotal(total,2));
             

        }

   }
    private void       agregarDETALLE() {
     for(int i=0;i<jtableDetalle.getRowCount();i++){
         
        String nfac=        jTextField1.getText();
        String nomprov=     jLabel16.getText();
        String direccion=   jLabel18.getText();
        String tel=         telefono.getText();
        String usuario=     jTextField2.getText();
        String noFac=       jTextField5.getText();
        String codpro=      jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = jtableDetalle.getValueAt(i,1).toString();
        String detalle  =   jtableDetalle.getValueAt(i,2).toString();
        String stock  =     jtableDetalle.getValueAt(i,4).toString();
        String precioC =    jtableDetalle.getValueAt(i,5).toString();
        //String precio =   jtableDetalle.getValueAt(i,5).toString();
        String totalf =     jtableDetalle.getValueAt(i,7).toString();
        
        
        try{
            cts=cn.prepareCall("{call AgregarDetalleFactProvee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1,  nfac);           
            cts.setString(2,  nomprov);
            cts.setString(3,  direccion);    
            cts.setString(4,  tel);
            cts.setString(5,  usuario);
            cts.setString(6,  codpro);
            cts.setString(7,  nombrepro);
            cts.setString(8,  detalle);
            cts.setString(9,  stock);
            cts.setString(10, precioC);
            cts.setString(11, totalf);
            cts.setString(12, noFac);

           
            
            int opcion=cts.executeUpdate();
            //if (opcion==1)
           //     JOptionPane.showMessageDialog(this, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }}
 }
    private void limpiar(){
    jTextField1.setText(""); telefono.setText("");
    jTextField2.setText(""); jLabel18.setText("");
    jTextField3.setText(""); jLabel16.setText("");
    jTextField4.setText(""); provee.setText("");
    jTextField5.setText(""); total1.setText("");
    jTextField6.setText(""); subtotal.setText("");
    fecha.setText      (""); desc1.setText("");
    jLabel20.setText   (""); itbis.setText("");
    
    try {
            DefaultTableModel modelo=(DefaultTableModel) jtableDetalle.getModel();
            int filas=jtableDetalle.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
       
       
    
    }
    
    public static void scanertablavacia(){
if(jTextField4.getText().length()>0){;
   String x=jTextField4.getText();
   DefaultTableModel tabla= new DefaultTableModel();
  
           try{
       tabla.addColumn("Codigo");
       tabla.addColumn("Descripcion");
       tabla.addColumn("Detalle"); 
       tabla.addColumn("Proveedor"); 
       tabla.addColumn("Cantidad");
       tabla.addColumn("Precio Costo");
       tabla.addColumn("Itbis"); 
       tabla.addColumn("Total");


        cts=cn.prepareCall("{call buscarartpro(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
   while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
      //int i=0; 
         i=i+1;
       }
            dato[0]=r.getString(1);
            dato[1]=r.getString(2);
            dato[2]=r.getString(3);            
            dato[3]=r.getString(4);
            dato[4]=1;
            dato[5]=r.getString(5);
            dato[6]=r.getString(6);
            dato[7]="";

       tabla.addRow(dato);
       Pedidos.jtableDetalle.setModel(tabla);
       
       //ajustarcolumnas();
     //  Selecionaarticulo();
         }       
}     catch (SQLException ex) {
          Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
      }
}
}
public static void scanertablallena(){
if(jTextField4.getText().length()>0){;
   String x=jTextField4.getText();
   DefaultTableModel tabla = (DefaultTableModel) Pedidos.jtableDetalle.getModel();
  
           try{

        cts=cn.prepareCall("{call buscarartpro(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
   while (r.next()){
       Object dato[]=new  Object[8];
      // for (int i=0; i<6; i++){
      int i=0; 
         i=i+1;
       
            dato[0]=r.getString(1);
            dato[1]=r.getString(2);
            dato[2]=r.getString(3);
            dato[3]=r.getString(3);
            dato[4]=1;
            dato[5]=r.getString(5);
            dato[6]=r.getString(6);
            dato[7]="";
   
       
       tabla.addRow(dato);
       Pedidos.jtableDetalle.setModel(tabla);

         }       
}     catch (SQLException ex) {
          Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
      }
}
}
private void       scanner()         {
   //int row=jtableDetalle.getSelectedRow();
   if(total1.getText().equals("")){
scanertablavacia();
 }
else
       scanertablallena();
 }
    
    public static void nome(){
     String X=CamS.jLabel1.getText();
    try {
             cts=cn.prepareCall("{call mostrarnomem(?)}");
             cts.setString(1,X);
             r=cts.executeQuery();
             if (r.next())
          CamS.jLabel6.setText(r.getString(1));
 } catch (SQLException ex) {}
    
 }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        desc1 = new javax.swing.JTextField();
        itbis = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        subtotal = new javax.swing.JFormattedTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDetalle = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        provee = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        total1 = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("jLabel5");

        jCheckBox1.setText("jCheckBox1");

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setResizable(true);
        setTitle("Pedidos");
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Subtotal:");

        desc1.setBackground(new java.awt.Color(204, 204, 255));
        desc1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        desc1.setForeground(new java.awt.Color(0, 153, 153));
        desc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc1ActionPerformed(evt);
            }
        });
        desc1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                desc1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                desc1KeyTyped(evt);
            }
        });

        itbis.setEditable(false);
        itbis.setBackground(new java.awt.Color(204, 204, 255));
        itbis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itbis.setForeground(new java.awt.Color(0, 153, 153));
        itbis.setToolTipText("Itbis");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        subtotal.setEditable(false);
        subtotal.setForeground(new java.awt.Color(0, 153, 153));
        subtotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        subtotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "15", "20", "25", "30", "40", "50", "Otros" }));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Desc.");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Itbis");

        jCheckBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jCheckBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jCheckBox2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox2)
                .addGap(21, 21, 21)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itbis, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(desc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel19)
                        .addComponent(itbis)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jtableDetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jtableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Detalle", "Proveedor", "Cantidad", "Precio Costo", "Itbis", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableDetalle.setInheritsPopupMenu(true);
        jtableDetalle.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jtableDetalle.setSelectionForeground(new java.awt.Color(102, 102, 102));
        jtableDetalle.setShowHorizontalLines(false);
        jtableDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtableDetalleKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtableDetalle);

        jButton5.setBackground(new java.awt.Color(153, 204, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Floppy_Disk_2215477.png"))); // NOI18N
        jButton5.setToolTipText("Guardar Factura e imprimir");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 153, 255), 1, true));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-32.png"))); // NOI18N
        jButton4.setToolTipText("Eliminar registro de la factura");
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_delete.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 204, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_send-01_186386.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(236, 95, 47), 2, true));
        jPanel5.setForeground(new java.awt.Color(204, 51, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("No. Fact. Sist");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Cod.Proveedor:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Señor(es):");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("RNC:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Telefono:");

        jTextField1.setBackground(new java.awt.Color(102, 153, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 153, 153));
        jTextField1.setOpaque(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        provee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        provee.setForeground(new java.awt.Color(0, 153, 153));
        provee.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        telefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        telefono.setForeground(new java.awt.Color(0, 153, 153));
        telefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/provider (1).png"))); // NOI18N
        jButton7.setToolTipText("has click para agregar un proveedor");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(236, 95, 47));
        jLabel12.setText("Pedidos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(33, 33, 33)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(provee, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(21, 21, 21))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(provee, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                            .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Empleado");

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion de Pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Fecha de Pago");

        jComboBox1.setBackground(new java.awt.Color(236, 95, 47));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        jComboBox1.setToolTipText("Seleccione la forma de pago de esta factura");
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        try {
            jTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Tipo de Factura");

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Dias para pagar:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_palet03_62585.png"))); // NOI18N
        jButton8.setToolTipText("has click para agregar un articulo");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Fecha");

        total1.setEditable(false);
        total1.setForeground(new java.awt.Color(255, 102, 0));
        total1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("RD$#,##0.00"))));
        total1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        total1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Total a Pagar:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 0, 0));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Bardcode Scanner_48455.png"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Numero Factura");

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(102, 102, 102));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.Factura", "Fecha", "Proveedor", "Total"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Facturas en proceso");

        fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23))
                                    .addComponent(jTextField2))))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(21, 21, 21))))
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(3, 3, 3)
                        .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarfactura(){
       // for(int i=0;i<jtableDetalle.getRowCount();i++){
        String nfac  = jTextField1.getText();
        String fec   = fecha      .getText();
        String codprov= provee    .getText();
        String tel   = telefono   .getText();
        String subt  = subtotal   .getText();
        String desc  = desc1      .getText();
        String itbi   = itbis     .getText();
        String tot   = total1     .getText();
        String formp   = jComboBox1    .getSelectedItem().toString();
        String fep   =  jTextField3     .getText();
        String nofac   =  jTextField5     .getText();
        

        
        try {
            cts=cn.prepareCall("{call RegistrarFactura(?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, fec);
            cts.setString(3, codprov);
            cts.setString(4, tel);
            cts.setString(5, subt);
            cts.setString(6, desc);
            cts.setString(7, itbi);
            cts.setString(8, tot);
            cts.setString(9, formp);
            cts.setString(10,fep);
            cts.setString(11,nofac);

            int opcion=cts.executeUpdate();
            
         //   if (opcion==1)
           // JOptionPane.showMessageDialog(this, "Factura Registrados correctamente!","aviso",JOptionPane.INFORMATION_MESSAGE);
        
        }catch(SQLException | HeadlessException e){  
        JOptionPane.showMessageDialog(this,"Error al registrar Factura"+e);
        }

    }
    private void agregarDETALLEfactura(){
        for(int i=0;i< jtableDetalle.getRowCount();i++){
       // jtableDetalle.requestFocusInWindow();
        jtableDetalle.requestFocusInWindow();
        String codpro=      jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = jtableDetalle.getValueAt(i,1).toString();
        String detalle  =   jtableDetalle.getValueAt(i,2).toString();
        String proveedor  = jtableDetalle.getValueAt(i,3).toString();
        String cant  =     jtableDetalle.getValueAt(i,4).toString();
        String precioCosto =     jtableDetalle.getValueAt(i,5).toString();

        try{
    
            cts=cn.prepareCall("{call productopedi(?,?,?,?,?,?)}");
            cts.setString(1, codpro);
            cts.setString(2, nombrepro);
            cts.setString(3, detalle);
            cts.setString(4, proveedor);
            cts.setString(5, precioCosto);
            cts.setString(6, cant);

            
            int opcion=cts.executeUpdate();
            
          //  if (opcion==1)
            //JOptionPane.showMessageDialog(this, "Productos Registrados correctamente!","aviso",JOptionPane.INFORMATION_MESSAGE);
        
        }catch(SQLException | HeadlessException e){  
        JOptionPane.showMessageDialog(this,"Error al registrar Productos");
        
        }
    }
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     
    if (jTextField3.getText().equals("  -  -    ") && jComboBox1.getSelectedItem().equals("Credito")){ 
JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA FECHA CORRECTAMENTE PARA PAGAR ESTA FACTURA t/"+""+"DD-MM-YYYY");
 jTextField3.requestFocusInWindow();
}else
         if (jTextField3.getText().length()>=2 && jComboBox1.getSelectedItem().equals("Credito")){ 
        agregarfactura();
        agregarDETALLEfactura();      
        agregarDETALLE();
        imprim();
        limpiar();
        String nombre=CamS.jLabel6.getText();
        Pedidos.jTextField2.setText(nombre);
        

        }
   else              
       if (jTextField3.getText().length() >0 &&total1.getText().length()>0&& jComboBox1.getSelectedItem().equals("Contado")){
            
         int opcion=JOptionPane.showConfirmDialog(null,"LA FACTURA QUE INTENTA GUARDAR ES AL CONTADO?","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION)
{
        agregarDETALLEfactura();
        agregarfactura();
        agregarDETALLE();
        imprim();     
        limpiar();
          String nombre=CamS.jLabel6.getText();
        Pedidos.jTextField2.setText(nombre);
}

    }//GEN-LAST:event_jButton5ActionPerformed
    } 
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

         DefaultTableModel modelo = (DefaultTableModel) jtableDetalle.getModel();
        int fila_select = jtableDetalle.getSelectedRow();

        if(fila_select<0){
            JOptionPane.showMessageDialog(this,"Tabla vacia o no ha seleccionado uan fila.");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(fila_select);
        operac();
        }

        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        if(jComboBox1.getSelectedItem().equals("Credito")) {
              jTextField3.setEnabled(true);
        }else{
            if(jComboBox1.getSelectedItem().equals("Formas de pago")) {
            
              jTextField3.setEnabled(false);
         }
            else{
            if(jComboBox1.getSelectedItem().equals("Contado")) {
              this.jTextField3.setText("");
              jTextField3.setEnabled(false);
         }
           
         }
    }//GEN-LAST:event_jComboBox1ActionPerformed
    }
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        
            if(jComboBox2.getSelectedItem().equals("0")) {
              operac();
         }
             else{
            if(jComboBox2.getSelectedItem().equals("1")) {
            operac();
         }
             else{
            if(jComboBox2.getSelectedItem().equals("2")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("3")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("4")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("5")) {
            operac();
         }else{
            if(jComboBox2.getSelectedItem().equals("6")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("7")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("8")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("9")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("10")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("15")) {
            operac();
         }
           else{
            if(jComboBox2.getSelectedItem().equals("20")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("25")) {
            operac();
         }
           else{
            if(jComboBox2.getSelectedItem().equals("30")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("35")) {
            operac();
         }
           else{
            if(jComboBox2.getSelectedItem().equals("40")) {
            operac();
         }
            else{
            if(jComboBox2.getSelectedItem().equals("45")) {
            operac();
            }
            else{
            if(jComboBox2.getSelectedItem().equals("50")) {
            operac();
         }
    }  
            }}}}}}}}}}}}}}}}}
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
 try {
          
           BuscarArticulos bs;
           bs = new BuscarArticulos();
           CamS.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setLocation(50,10);
           bs.setVisible(true);
           
       } catch (SQLException ex) {
           Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
       }       
          
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       GeneraNum();
        BuscarProveedor1 bc=new BuscarProveedor1();
        CamS.jDesktopPane1.add(bc);
        bc.toFront();
        bc.setLocation(50,10);
        bc.setVisible(true);
         try{
        
         cts=cn.prepareCall("{call Genera_num_Factura}");
       r=cts.executeQuery();
       if (r.next())
        
         jTextField1.setText(r.getString(1));
           }catch (Exception e){} 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Limpiar la pantalla y empezar nuevamente","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
        
     
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtableDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableDetalleKeyTyped
            char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_ENTER != (teclapre)) {
            operac();
            jTextField4.requestFocusInWindow();
       }
    }//GEN-LAST:event_jtableDetalleKeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
 scanner();
            Pedidos.operac();        
         //   jTable2.requestFocusInWindow();
            jTextField4.setText("");
           // Selecionaarticulo(); 
            jTextField4.requestFocusInWindow();
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            // agregaAdetalleFACT();
            jTextField2.requestFocusInWindow();
        }

    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
     
    }//GEN-LAST:event_jTextField4KeyTyped
    
    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
       char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_F1 != (teclapre)) {
            operac();
             try {
           
           BuscarArticulos bs;
           bs = new BuscarArticulos();
           vendedor.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setLocation(50,10);
           bs.setVisible(true);           
       } catch (SQLException ex) {
           Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
       } 
       }
    }//GEN-LAST:event_formKeyTyped

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed

        desc1.setEnabled(true);
        desc1.requestFocusInWindow();
        desc1.setText("");
        
    
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckBox2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2KeyTyped

    private void desc1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyTyped
      
    }//GEN-LAST:event_desc1KeyTyped

    private void desc1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_desc1KeyPressed
     //   char teclapre=(char) evt.getKeyCode();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            operac1();
            desc1.setEnabled(false); 
           jTextField4.requestFocusInWindow();
           jCheckBox2.setSelected(false);
       }
    }//GEN-LAST:event_desc1KeyPressed

    private void desc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desc1ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    public static javax.swing.JTextField desc1;
    public static javax.swing.JTextField fecha;
    public static javax.swing.JTextField itbis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox jComboBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    private javax.swing.JFormattedTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public static javax.swing.JTable jtableDetalle;
    public static javax.swing.JLabel provee;
    public static javax.swing.JFormattedTextField subtotal;
    public static javax.swing.JLabel telefono;
    public static javax.swing.JFormattedTextField total1;
    // End of variables declaration//GEN-END:variables
}
