
package CamSyst.Cliente;

import CamSyst.Vista.CamS;
import java.awt.HeadlessException;
import java.sql.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import CamSyst.Controlador.ClassConection;
import CamSyst.Controlador.Reportes;
import static CamSyst.Vista.CamS.jDesktopPane1;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public final class Factura extends javax.swing.JInternalFrame {
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
   public static String sql;
   
   ClassConection conectar=new ClassConection();
   
   public static String userName;
   public static String passWord;
   
   public Factura() throws SQLException {
       initComponents();
       jTextField2.requestFocusInWindow();
       Factura.jTextField3.setEnabled(false);
       //userName = user;
      //  passWord = password;
       cn=conectar.conecion();
//       jTextField1.setText(""+user);
       
       Calendar cal=Calendar.getInstance();
       String fecha=cal.get(Calendar.DATE) +"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
       jlb_fecha.setText(fecha);
       //numComprobF02();
       numfac();
     

    }     
 
public static void numfac()         {
    
       try{
        
         cts=cn.prepareCall("{call Genera_num_FacturaCli}");
         r=cts.executeQuery();
       if (r.next())
       jTextField4.setText(r.getString(1));
           
       }catch (Exception e){} 
}
public static void datocli()        {
       JLB_codCliente.setText("C0000");
       jLabel16.setText("Sin nombre");
       jLabel18.setText("000-0000000-0");
       telefo.setText("000-000-0000");
       jLabel20.setText("sin Direccion");
 
    } 
public static void ajustarcolumnas(){
     TableColumn columna =null;
     
     for(int i=0;i<=5;i++){
         columna=jtableDetalle.getColumnModel().getColumn(i);
         switch (i) {
             case 0:
                 columna.setPreferredWidth(6);
                 break;
             case 1:
                 columna.setPreferredWidth(50);
                 break;
             case 2:
                 columna.setPreferredWidth(20);
                 break;
             default:
                 columna.setPreferredWidth(40); 
                 break;
         }
     }
}
public static void operaci()        {
         double suma;
         double totalsub;
         double subtot=0;
         double des;
         double itb=0;
         double total;
         double itbis;

             for(int i=0;i<jtableDetalle.getRowCount();i++){
             String precioV= jtableDetalle.getValueAt(i,4).toString();
             String cantidad= jtableDetalle. getValueAt(i, 3).toString();
             String Itbis= jtableDetalle. getValueAt(i, 5).toString();
             double c=Double.parseDouble(cantidad);
             double d=Double.parseDouble(precioV);
             double it=Double.parseDouble(Itbis);
             int val3 = Integer.parseInt(jComboBox2.getSelectedItem().toString()); 
     
             itbis=it*c;
             suma=c*d+itbis;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb+=itbis;
             total=subtot-des+itbis;
             jtableDetalle.setValueAt(""+redondearItbis(itbis,2), i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            

             }
        }
public static void operaci2()       {
         double suma;
         double suma1;
         double subtot=0;
         double des;
         double itb=0;
         double total;
         double itbis;

             for(int i=0;i<jtableDetalle.getRowCount();i++){
             String precioV= jtableDetalle.getValueAt(i,4).toString();
             String cantidad= jtableDetalle. getValueAt(i, 3).toString();
             String Itbis= jtableDetalle. getValueAt(i, 5).toString();
             double c=Double.parseDouble(cantidad);
             double d=Double.parseDouble(precioV);
             double it=Double.parseDouble(Itbis);
             int val3 = Integer.parseInt(jComboBox2.getSelectedItem().toString()); 
     
             itbis=it*c;
             suma1=c*d;
             suma=c*d+itbis;
             subtot+=suma1; 
             des=subtot*val3/100;
             itb+=itbis;
             total=subtot-des+itbis;
             jtableDetalle.setValueAt(""+redondearItbis(itbis,2), i, 6);
              jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
             Pago.jTextField5.setText(""+redondearTotal(total,2));

             }
}
public static void operaci3()       {
         double suma;
         double suma1;
         double subtot=0;
         double des;
         double itb=0;
         double total;
         double itbis;

             for(int i=0;i<jtableDetalle.getRowCount();i++){
             String precioV= jtableDetalle.getValueAt(i,4).toString();
             String cantidad= jtableDetalle. getValueAt(i, 3).toString();
             String Itbis= jtableDetalle. getValueAt(i, 5).toString();
             double c=Double.parseDouble(cantidad);
             double d=Double.parseDouble(precioV);
             double it=Double.parseDouble(Itbis);
             int val3 = Integer.parseInt(jComboBox2.getSelectedItem().toString()); 
     
             itbis=it*c;
             suma1=c*d;
             suma=c*d+itbis;
             subtot+=suma1; 
             des=subtot*val3/100;
             itb+=itbis;
             total=subtot-des+itbis;
             jtableDetalle.setValueAt(""+redondearItbis(itbis,2), i, 6);
              jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            Pago.jTextField1.setText(""+redondearTotal(total,2));

             }}
public static void calcularpuntos() {
 if(jTextField6.getText().length()>0){
double suma; 
double val3 = Double.parseDouble(jtf_total.getText()); 
suma=(val3*0.1*100/1000);
jTextField5.setText(""+redondearPuntos(suma,2));
}
}
public static void validar()        {
    if(jTextField6.getText().length()==0){
    jTextField5.setText("0"); 
    }
 }
public static void puntos()         {
        String nfac=jTextField4.getText();
        String codcli=JLB_codCliente.getText();
        String codblue=jTextField6.getText();
        String nombrecli=jLabel16.getText();
        double tot=Double.parseDouble(Factura.jtf_total.getText());
        String puntoacu=jTextField5.getText();
         
        
        try {
            cts=cn.prepareCall("{call bluepoint(?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, codcli);
            cts.setString(3, codblue);
            cts.setString(4, nombrecli);
            cts.setDouble(5, tot);
            cts.setString(6, puntoacu);

            int opcion=cts.executeUpdate();
            if(opcion==1)
                 JOptionPane.showMessageDialog(null, "Puntos registrados correctamente","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar puntos del cliente"+e.getMessage());
        }

}
public static void imprimir(){
    try{
    String rutaInforme= "C:\\Program Files\\Camsyst\\Reportes\\Facturagourmeti.jrxml";
        Reportes re= new Reportes();
        Map parametros = new HashMap();
        parametros.put("n_factura",jTextField4.getText());
        re.verReporte(rutaInforme, parametros);

    } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}
public static void agregarDETALLE() {
     for(int i=0;i<jtableDetalle.getRowCount();i++){
         
        String nfac=jTextField4.getText();
        String cedula=jLabel18.getText();
        String direccion=jLabel20.getText();
        String vendedor=jTextField1.getText();
        String nombre=jLabel16.getText();
        String codpro=      jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = jtableDetalle.getValueAt(i,1).toString(); 
        String cantidad=    jtableDetalle.getValueAt(i,3).toString();
       // String cantidad  =  jtableDetalle.getValueAt(i,3).toString();
        String precio =     jtableDetalle.getValueAt(i,4).toString();
        String itb =        jtableDetalle.getValueAt(i,6).toString();
        String prciototal  =jtableDetalle.getValueAt(i,7).toString();
        double cant=Double.parseDouble(cantidad);
        
        try{
            cts=cn.prepareCall("{call agregardetalle(?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, codpro);
            cts.setString(3, nombrepro);
            cts.setDouble(4, cant);
            cts.setString(5, precio);
            cts.setString(6, prciototal);
            cts.setString(7, direccion);
            cts.setString(8, cedula);    
            cts.setString(9, vendedor);
            cts.setString(10, nombre);
            cts.setString(11, itb);
            
            int opcion=cts.executeUpdate();
           // if (opcion==1)
             //  JOptionPane.showMessageDialog(null, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }}
    
}
public static void limpiar()        {
           Factura.JLB_codCliente.setText("");
           Factura.jLabel16.setText  ("");
           Factura.jLabel18.setText("");        
           Factura.telefo.setText("");
           Factura.jLabel20.setText("");
           Factura.jTextField4.setText("");
           Factura.jTextField3.setText("");
           Factura.jTextField5.setText("");
           Factura.jTextField6.setText("");
           Factura.jTextField7.setText("");
           Factura.jTextField2.setText("");
           Factura.jtf_subto.setText(""); 
           Factura.jtf_desc.setText("");
           Factura.jtf_igv.setText("");
           Factura.jtf_total.setText("");
           //Factura.jComboBox1.getSelectedItem();
          // Factura.jlb_fecha.setText(null);
           

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
public static void agregarFacCli()  {
   //  for(int i=0;i<jtableDetalle.getRowCount();i++){
         
        String nfac=        jTextField4.getText();
        String formPago=    formaPago.getSelectedItem().toString();
        String fechapago=   jTextField3.getText();
        String fecha=       jlb_fecha.getText();     
        String codigoCli=   JLB_codCliente.getText();       
        String ced=         jLabel18.getText();       
        String subTotal=    jtf_subto.getText();
        String descuento=   jtf_desc.getText();
        String itbis=       jtf_igv.getText();
        String total=       jtf_total.getText();
        String NCF=         jTextField7.getText();
        
        try{
            cts=cn.prepareCall("{call RegistrarFacturacli(?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, formPago);
            cts.setString(3, fechapago);
            cts.setString(4, fecha);
            cts.setString(5, codigoCli);
            cts.setString(6, ced);
            cts.setString(7, subTotal);
            cts.setString(8, descuento);
            cts.setString(9, itbis);
            cts.setString(10,total);
            cts.setString(11,NCF);
            
            
            int opcion=cts.executeUpdate();
           // if (opcion==1)
             //  JOptionPane.showMessageDialog(null, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }
    
}
private void       scanner()          {
    {
    if(jTextField2.getText().length()>0){;
    String x=jTextField2.getText();
  DefaultTableModel tabla= new DefaultTableModel();
  
           try{
       tabla.addColumn("Codigo");
       tabla.addColumn("Descripcion");
       tabla.addColumn("Detalle"); 
       tabla.addColumn("Cantidad");
       tabla.addColumn("Precio");
       tabla.addColumn("Itbis"); 
       tabla.addColumn("Itbis Calculado");
       tabla.addColumn("Total");


        cts=cn.prepareCall("{call buscarpro5(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
   while (r.next()){
       Object dato[]=new  Object[6];
      int i=0; 
         i=i+1;
       
            dato[0]=r.getString(1);
            dato[1]=r.getString(2);
            dato[2]=r.getString(3);
            dato[3]=1;
            dato[4]=r.getString(4);
            dato[5]=r.getString(5);

       tabla.addRow(dato);
       Factura.jTable2.setModel(tabla);
       ajustarcolumnas();
       Selecionaarticulo();
         }       
}     catch (SQLException ex) {
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
      }}
}}
public void        Selecionaarticulo(){
       
        DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();
        int row=jTable2.getSelectedRow();
        
        String id=jTable2.getValueAt(row, 0). toString();
        String nom=jTable2.getValueAt(row, 1).toString();
        String det=jTable2.getValueAt(row, 2).toString();
        String pre=jTable2.getValueAt(row, 4).toString();
        String Itbis=jTable2.getValueAt(row, 5).toString();
          
         int i=0; 
         i=i+1;
         Object[]  dato=new Object[6];
         
            dato[0]=id;
            dato[1]=nom;
            dato[2]=det;
            dato[3]=1;
            dato[4]=pre;
            dato[5]=Itbis;
 
           // Factura.operaci();
           // Factura.calcularpuntos();
            modelo.addRow(dato);
            Factura.jtableDetalle.setModel(modelo);
            //Factura.ajustarcolumnas();
            //dispose();
           // Factura.jTextField2.requestFocusInWindow();
   
 }
public static void guardar()          {
 
        if (jTextField3.getText().equals("  -  -    ") && formaPago.getSelectedItem().equals("Credito")){ 
JOptionPane.showMessageDialog(null, "DEBE INGRESAR LA FECHA CORRECTAMENTE PARA PAGAR ESTA FACTURA t/"+""+"DD-MM-YYYY");
 jTextField3.requestFocusInWindow();
}else
         if (jTextField3.getText().length()>=2 && formaPago.getSelectedItem().equals("Credito")){ 
        
        debitarProductos();
        agregarFacCli();
        agregarDETALLE();
        imprimir();
        limpiar();
        numfac();
         }
                 
        if (jTextField3.getText().length() >0 && formaPago.getSelectedItem().equals("Contado")){
            
         int opcion=JOptionPane.showConfirmDialog(null,"LA FACTURA QUE INTENTA GUARDAR ES AL CONTADO?","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION)
{
     try {
           
          formaPago bs = new formaPago();
           jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
       } catch (Exception e){}             

        }
    }    
}
public static void debitarProductos() {
     for(int i=0;i<jtableDetalle.getRowCount();i++){

        String codpro=      jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = jtableDetalle.getValueAt(i,1).toString();
        String detalle  =   jtableDetalle.getValueAt(i,2).toString();
        String stock  =     jtableDetalle.getValueAt(i,3).toString();
        String precio =     jtableDetalle.getValueAt(i,4).toString();
        Double st = Double.parseDouble(stock);
        
        try{
            cts=cn.prepareCall("{call debitarProductos(?,?,?,?,?)}");

            cts.setString(1, codpro);
            cts.setString(2, nombrepro);
            cts.setString(3, detalle);
            cts.setDouble(4, st);
            cts.setString(5, precio);
            
            
            int opcion=cts.executeUpdate();
         //   if (opcion==1)
            //    JOptionPane.showMessageDialog(null, "Producto registrado correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos del productos"+e.getMessage());
                
        }}
}
private void       Limpiar_Tabla()    {
         DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
for (int i = 0; i < jTable2.getRowCount(); i++) {
modelo.removeRow(i);
i-=1;
}
}
public static void revision()         {

    DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();   
    int row=jtableDetalle.getSelectedRow();
    
     String veri=jtableDetalle.getValueAt(row, 0).toString();



}
public static void numComprobF01()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante01}");
         r=cts.executeQuery();
         if (r.next())
         jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
public static void numComprobF02()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante02}");
         r=cts.executeQuery();
         if (r.next())
         jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
public static void incrementarncf()   {
          try{
        
         cts=cn.prepareCall("{call registrarcomprobante}");
         r=cts.executeQuery();

           
       }catch (Exception e){} 
}
public static void incrementarncf01()   {
          try{
        
         cts=cn.prepareCall("{call registrarcomprobante01}");
         r=cts.executeQuery();

           
       }catch (Exception e){} 
}

//Metodos para redondear cifras decimales
private static double redondearSubtotal(double subtot,int numDecimal){

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*subtot+0.5)/p;
    
}
private static double redondearTotal   (double total,int numDecimal) {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*total+0.5)/p;
    
}
private static double redondearItbis   (double itb,int numDecimal)   {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*itb+0.5)/p;
    
}
private static double redondearDes     (double des,int numDecimal)   {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*des+0.5)/p;
    
}
private static double redondearPuntos  (double suma,int numDecimal)  {

    long p=1;
    for(int i=0;i<numDecimal;i++)p*=10;
    return(double)(int)(p*suma+0.5)/p;
    
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jtf_subto = new javax.swing.JTextField();
        jtf_desc = new javax.swing.JTextField();
        jtf_igv = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableDetalle = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JLB_codCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        telefo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        buscarClientes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        formaPago = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JFormattedTextField();
        buscarArticulo = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jlb_fecha = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtf_total = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        eliminarFila = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion ");
        setToolTipText("Ventana de Facturacion");
        setFont(new java.awt.Font("Agency FB", 1, 10)); // NOI18N
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setText("Descuento");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Subtotal:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setText("Total de Itbis:");

        jtf_subto.setEditable(false);

        jtf_desc.setEditable(false);

        jtf_igv.setEditable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "3", "5", "8", "10", "15", "20", "25", "30", "35", "40", "45", "50", " " }));
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jtf_subto, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel26)
                .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel24)
                .addComponent(jtf_subto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel25))
        );

        jtableDetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jtableDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Detalle", "Cantidad", "Precio", "Itbis", "Itbis Calculado", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jtableDetalle.setFocusTraversalPolicyProvider(true);
        jtableDetalle.setGridColor(new java.awt.Color(204, 204, 204));
        jtableDetalle.setSelectionBackground(new java.awt.Color(102, 153, 255));
        jtableDetalle.setShowHorizontalLines(false);
        jtableDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtableDetalleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtableDetalleKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtableDetalle);

        jButton5.setBackground(new java.awt.Color(0, 204, 204));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        jButton5.setToolTipText("Registrar Factura e Imprimir");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton5KeyTyped(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Descripcion", "Detalle", "Cantidad", "Precio", "Itbis", "Itbis Calculado", "Total"
            }
        ));
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable2KeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Cod.Cliente:");

        JLB_codCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JLB_codCliente.setForeground(new java.awt.Color(0, 153, 153));
        JLB_codCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Señor(es):");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ced/RNC:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 153));
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tel.:");

        telefo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        telefo.setForeground(new java.awt.Color(0, 153, 153));
        telefo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 153));
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buscarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emblem-people.png"))); // NOI18N
        buscarClientes.setToolTipText("Agregar cliente");
        buscarClientes.setBorderPainted(false);
        buscarClientes.setContentAreaFilled(false);
        buscarClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClientesActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(51, 102, 255));
        jTextField6.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField6CaretUpdate(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cod.Blue:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(JLB_codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jTextField6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(buscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JLB_codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(buscarClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(telefo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("Vendedor");

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 0));
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion de pago", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 102, 204))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        formaPago.setBackground(new java.awt.Color(0, 102, 204));
        formaPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        formaPago.setForeground(new java.awt.Color(255, 255, 255));
        formaPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contado", "Credito" }));
        formaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formaPagoActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Fecha de Pago:");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Tipo de Factura:");

        try {
            jTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formaPago, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jTextField3))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173))
        );

        buscarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/palet02.png"))); // NOI18N
        buscarArticulo.setToolTipText("agregar articulo");
        buscarArticulo.setBorderPainted(false);
        buscarArticulo.setContentAreaFilled(false);
        buscarArticulo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarArticuloActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(204, 0, 0));
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Bardcode Scanner_48455.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 102, 255));
        jLabel11.setText("Blue");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 153, 255));
        jLabel21.setText("Point");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_bloglovin_599538_1.png"))); // NOI18N
        jButton8.setToolTipText("Acumula Puntos Azules");
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton8KeyPressed(evt);
            }
        });

        jlb_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlb_fecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("  Factura de Venta");

        jtf_total.setBackground(new java.awt.Color(204, 204, 255));
        jtf_total.setForeground(new java.awt.Color(102, 102, 102));
        jtf_total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$#,##0.###"))));
        jtf_total.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Total a Pagar");

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(102, 153, 255));
        jTextField5.setText("0");

        eliminarFila.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        eliminarFila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-32.png"))); // NOI18N
        eliminarFila.setToolTipText("Eliminar producto de la lista");
        eliminarFila.setBorderPainted(false);
        eliminarFila.setContentAreaFilled(false);
        eliminarFila.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminarFila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarFilaActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_delete.png"))); // NOI18N
        jButton3.setToolTipText("Salir de esta ventana");
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calculator.png"))); // NOI18N
        jButton6.setToolTipText("Realizar calculo");
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField7.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NCF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField5))
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtf_total)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(eliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jlb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(11, 11, 11)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 15, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(31, 31, 31))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(8, 8, 8)
                                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(29, 29, 29)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField7)))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(eliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(buscarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void buscarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarArticuloActionPerformed
     
       try {
           validar();
           BuscarArticulos2 bs;
           bs = new BuscarArticulos2(this.userName,this.passWord);
           CamS.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setLocation(50,10);
           bs.setVisible(true);
           BuscarArticulos2.jTextField1.requestFocusInWindow();
       } catch (SQLException ex) {
           Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_buscarArticuloActionPerformed

    private void buscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClientesActionPerformed
       validar();
        BuscarCliente bc=new BuscarCliente();
        CamS.jDesktopPane1.add(bc);
        bc.toFront();
        bc.setLocation(50,10);
        bc.setVisible(true);
        BuscarCliente.jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_buscarClientesActionPerformed
   
    
 
   
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    if(jtf_total.getText().length()>0){
    validar();
    guardar();
    }else
         JOptionPane.showMessageDialog(null,"DEBE AGREGAR UN ARTICULO A LA FACTURA");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void eliminarFilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarFilaActionPerformed
        // TODO add your handling code here:
         DefaultTableModel modelo = (DefaultTableModel) jtableDetalle.getModel();
        //ahora obtenemos la fila selccionada
        int fila_select = jtableDetalle.getSelectedRow();

        if(fila_select<0){
            // no se puede eliminar
            JOptionPane.showMessageDialog(this,"TABLA VACIA, SELECCIONE UNA FILA...");
        }else {
          // la eliminamos del modelo:
        modelo.removeRow(fila_select);
        operaci();
        calcularpuntos();
        }

        
    }//GEN-LAST:event_eliminarFilaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     
int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA SALIR?","CONFIRMAR!",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
this.dispose();

}

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        validar();
        operaci();     
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formaPagoActionPerformed
       if(formaPago.getSelectedItem().equals("Credito")) {
              jTextField3.setEnabled(true);
        }else{
            if(formaPago.getSelectedItem().equals("Formas de pago")) {
            
              jTextField3.setEnabled(false);
         }
            else{
            if(formaPago.getSelectedItem().equals("Contado")) {
              this.jTextField3.setText("");
              jTextField3.setEnabled(false);
         }
           
         }
    }                               
    }//GEN-LAST:event_formaPagoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jtableDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableDetalleKeyTyped
        char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_ENTER != (teclapre)) {
            operaci();
            calcularpuntos();
            jTextField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jtableDetalleKeyTyped
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
       scanner();
       Selecionaarticulo(); 
       operaci();
       calcularpuntos();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton8KeyPressed
     
    }//GEN-LAST:event_jButton8KeyPressed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
     //  JOptionPane.showMessageDialog(null,"VENTANA EN PROGRAMACION, DISCULPE LOS INVONVENIENTES.");
    }//GEN-LAST:event_jButton8MouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
 if(evt.getKeyChar()== KeyEvent.VK_F4){     
try {
    
           BuscarArticulos2 bs;
           bs = new BuscarArticulos2(this.userName,this.passWord);
           CamS.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setLocation(50,10);
           bs.setVisible(true);
           BuscarArticulos2.jTextField1.requestFocusInWindow();
       } catch (SQLException ex) {
           Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_formKeyPressed
    }
    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
       calcularpuntos();
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField6CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField6CaretUpdate
        calcularpuntos();
    }//GEN-LAST:event_jTextField6CaretUpdate

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
          validar();
    }                                    
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked

    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
       if(jComboBox2.getSelectedItem().equals("0")){
      operaci();
      }
       if(jComboBox2.getSelectedItem().equals("3")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("5")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("8")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("10")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("15")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("20")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("25")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("30")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("35")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("40")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("45")){
      operaci();
      }
      if(jComboBox2.getSelectedItem().equals("50")){
      operaci();
      }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jtableDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableDetalleKeyPressed
        operaci();
        calcularpuntos();
    }//GEN-LAST:event_jtableDetalleKeyPressed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
    
    }//GEN-LAST:event_jTable2KeyPressed

    private void jTable2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyReleased
          //scanner(); 
           Selecionaarticulo(); 
           Factura.operaci();
           Factura.calcularpuntos();
          
           jTextField2.requestFocusInWindow();
            jTextField2.setText("");
    }//GEN-LAST:event_jTable2KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased

    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
           scanner(); 
           
           Factura.operaci();
           Factura.calcularpuntos();
          
           jTable2.requestFocusInWindow();
            jTextField2.setText("");
           Selecionaarticulo(); 
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTable2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyTyped
         char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_ENTER != (teclapre)) {
           
            Selecionaarticulo(); 
            operaci();
            calcularpuntos();
            Limpiar_Tabla();
            jTextField2.requestFocusInWindow();
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jTable2KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
       char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_ENTER != (teclapre)) {
            scanner(); 
            jTable2.requestFocus();
            Selecionaarticulo();      
        } 
 
        else{ 
        if(KeyEvent.VK_F2 != (teclapre)) {
           validar();
            guardar();
        }
        }   
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton5KeyTyped
      
    }//GEN-LAST:event_jButton5KeyTyped
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel JLB_codCliente;
    private javax.swing.JButton buscarArticulo;
    private javax.swing.JButton buscarClientes;
    private javax.swing.JButton eliminarFila;
    public static javax.swing.JComboBox<String> formaPago;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    public static javax.swing.JComboBox jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private static javax.swing.JTable jTable2;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JFormattedTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JLabel jlb_fecha;
    public static javax.swing.JTable jtableDetalle;
    public static javax.swing.JTextField jtf_desc;
    public static javax.swing.JTextField jtf_igv;
    public static javax.swing.JTextField jtf_subto;
    public static javax.swing.JFormattedTextField jtf_total;
    public static javax.swing.JLabel telefo;
    // End of variables declaration//GEN-END:variables
}
