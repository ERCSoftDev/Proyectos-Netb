
package CamSyst.Cliente;

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
import CamSyst.Vista.CamS;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public final class Cotizacion1 extends javax.swing.JInternalFrame {
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
   public static String sql;
   
   ClassConection conectar=new ClassConection();
   
public Cotizacion1() throws SQLException {
       initComponents();
       jTextField2.requestFocusInWindow();
       //Cotizacion1.jTextField3.setEnabled(false);
       cn=conectar.conecion();

       Calendar cal=Calendar.getInstance();
       String fecha=cal.get(Calendar.DATE) +"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
       jlb_fecha.setText(fecha);

          
    }     

public static void validNombreClientes(){
if (JLB_codCliente.getText().equals("C0000")){
}else{
String nombre=Factura.jLabel16.getText();
confNombreCaja.jTextField1.setText(nombre);
  
}}
public static void numfac()          {
  
       try{
        
         cts=cn.prepareCall("{call Genera_num_cotizacion}");
         r=cts.executeQuery();
       if (r.next())
       jTextField4.setText(r.getString(1));
           
       }catch (Exception e){} 
}

public static void datocli()         {
       JLB_codCliente.setText("C0000");
       jLabel16.setText("Sin nombre");
       jLabel18.setText("000-0000000-0");
       telefo.setText("000-000-0000");
       jLabel20.setText("sin Direccion");
 
    } 
public static void ajustarcolumnas() {
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
public static void operaci()         {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));

             }
        }
public static void operaci2()        {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
             PagoAdmin.jTextField5.setText(""+redondearTotal(total,2));

             }
}
public static void operaci3()        {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            PagoAdmin.jTextField1.setText(""+redondearTotal(total,2));

             }}
public static void operaci4()        {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            PagoAdmin.jTextField1.setText(""+redondearTotal(total,2));
            

             }}
public static void operaci6()        {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            PagoAdmin.jTextField5.setText(""+redondearTotal(total,2));

             }}
public static void operaci5()        {
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
             suma=c*d;
             totalsub=c*d;
             subtot+=totalsub; 
             des=subtot*val3/100;
             itb=subtot*0.18;
             total=(subtot+itb)-des;
             jtableDetalle.setValueAt("0.0", i, 6);
             jtableDetalle.setValueAt(""+redondearTotal(suma,2), i, 7);
             jtf_subto.setText(""+redondearSubtotal(subtot,2));
             jtf_desc.setText(""+redondearDes(des,2));
             jtf_igv.setText(""+redondearItbis(itb,2));
             jtf_total.setText(""+redondearTotal(total,2));
            PagoAdminComprobante.jTextField1.setText(""+redondearTotal(total,2));

             }}
public static void validar()         {
    if(jTextField6.getText().length()==0){
//    jTextField5.setText("0"); 
    }
 }
public static void imprimir()        {
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
public static void agregarDETALLE()  {
     for(int i=0;i<jtableDetalle.getRowCount();i++){
         
        String nfac=jTextField4.getText();
        String cedula=jLabel18.getText();
        String direccion=jLabel20.getText();
        String vendedor=jTextField1.getText();
        String nombre=jLabel16.getText();
        String codpro=      jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = jtableDetalle.getValueAt(i,1).toString(); 
        String detapro  = jtableDetalle.getValueAt(i,2).toString(); 
        String cantidad=    jtableDetalle.getValueAt(i,3).toString();
       // String cantidad  =  jtableDetalle.getValueAt(i,3).toString();
        String precio =     jtableDetalle.getValueAt(i,4).toString();
        String itbc =     jtableDetalle.getValueAt(i,5).toString();
        String itb =        jtableDetalle.getValueAt(i,6).toString();
        String prciototal  =jtableDetalle.getValueAt(i,7).toString();
        double cant=Double.parseDouble(cantidad);
        
        try{
            cts=cn.prepareCall("{call agregardetalleCoti(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);
            cts.setString(2, codpro);
            cts.setString(3, nombrepro);
            cts.setString(4, detapro);
            cts.setDouble(5, cant);
            cts.setString(6, precio);
            cts.setString(7, itbc);
            cts.setString(8, itb);
            cts.setString(9, prciototal);
            cts.setString(10, direccion);
            cts.setString(11, cedula);    
            cts.setString(12, vendedor);
            cts.setString(13, nombre);
            
            
            int opcion=cts.executeUpdate();
           // if (opcion==1)
             //  JOptionPane.showMessageDialog(null, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }}
    
}
public static void limpiar()         {
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
           Factura.jTextField8.setText("");
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
public static void agregarFacCli()   {
   //  for(int i=0;i<jtableDetalle.getRowCount();i++){
         
        String nfac=        jTextField4.getText();
        String fecha=       jlb_fecha.getText();     
        String codigoCli=   JLB_codCliente.getText();       
        String ced=         jLabel18.getText();       
        String subTotal=    jtf_subto.getText();
        String descuento=   jtf_desc.getText();
        String itbis=       jtf_igv.getText();
        String total=       jtf_total.getText();
        String NCF=         jTextField7.getText();
        
        try{
            cts=cn.prepareCall("{call RegistrarCotizacion(?,?,?,?,?,?,?,?)}");
            cts.setString(1, nfac);   
            cts.setString(2, fecha);
            cts.setString(3, codigoCli);
            cts.setString(4, ced);
            cts.setString(5, subTotal);
            cts.setString(6, descuento);
            cts.setString(7, itbis);
            cts.setString(8,total);

            int opcion=cts.executeUpdate();
            if (opcion==1)
              JOptionPane.showMessageDialog(null, "detalles Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar datos de detalle de factura"+e.getMessage());
                
        }
    
}
public static void verificaexistencia (){
     int row=jtableDetalle.getSelectedRow();
     
 if(jtableDetalle.getValueAt(row, 0).equals("P0159")){
 JOptionPane.showMessageDialog(null, "HAY EXISTENCIA DE ESTE PRODUCTO","AVISO URGENTE",JOptionPane.INFORMATION_MESSAGE);
 //dispose();

 }
 }
public static void scanertablavacia(){
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
       for (int i=0; i<6; i++){
      //int i=0; 
         i=i+1;
       }
            dato[0]=r.getString(1);
            dato[1]=r.getString(2);
            dato[2]=r.getString(3);
            dato[3]=1;
            dato[4]=r.getString(4);
            dato[5]=r.getString(5);

       tabla.addRow(dato);
       Factura.jtableDetalle.setModel(tabla);
       
       //ajustarcolumnas();
     //  Selecionaarticulo();
         }       
}     catch (SQLException ex) {
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
      }
}
}
public static void scanertablallena(){
if(jTextField2.getText().length()>0){;
   String x=jTextField2.getText();
   DefaultTableModel tabla = (DefaultTableModel) Factura.jtableDetalle.getModel();
  
           try{

        cts=cn.prepareCall("{call buscarpro5(?)}");
         cts.setString(1, x);
         r=cts.executeQuery();
         
   while (r.next()){
       Object dato[]=new  Object[6];
      // for (int i=0; i<6; i++){
      int i=0; 
         i=i+1;
       
            dato[0]=r.getString(1);
            dato[1]=r.getString(2);
            dato[2]=r.getString(3);
            dato[3]=1;
            dato[4]=r.getString(4);
           dato[5]=r.getString(5);
   
       
       tabla.addRow(dato);
       Factura.jtableDetalle.setModel(tabla);

         }       
}     catch (SQLException ex) {
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
      }
}
}
private void       scanner()         {
   //int row=jtableDetalle.getSelectedRow();
   if(jtf_total.getText().equals("")){
scanertablavacia();
 }
else
       scanertablallena();
 }
public static void guardar()         {

        agregarFacCli();
        agregarDETALLE();
        imprimir();
        limpiar();        
       
    }    
public static void revision()            {

    DefaultTableModel modelo = (DefaultTableModel) Factura.jtableDetalle.getModel();   
    int row=jtableDetalle.getSelectedRow();
    
     String veri=jtableDetalle.getValueAt(row, 0).toString();



}

public static void enviarFactura()       {
try{
        confNombreAdmin f=new confNombreAdmin();
        CamS.jDesktopPane1.add(f);
        
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}      
    } 
public static void enviarFacturaComprob(){
try{
        confNombreAdminComprob f=new confNombreAdminComprob();
        CamS.jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}      
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
        eliminarFila = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlb_fecha = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jtf_total = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fecha:");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Totales", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(51, 51, 51))); // NOI18N

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Descuento");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Subtotal:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 51));
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
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_igv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)
                        .addComponent(jtf_desc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24)
                        .addComponent(jtf_subto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jtableDetalle.setBackground(new java.awt.Color(102, 102, 102));
        jtableDetalle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 255)));
        jtableDetalle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtableDetalle.setForeground(new java.awt.Color(204, 204, 204));
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
        jtableDetalle.setGridColor(new java.awt.Color(153, 204, 255));
        jtableDetalle.setSelectionBackground(new java.awt.Color(153, 204, 255));
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
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/creativecommons-32.png"))); // NOI18N
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_printer_289614.png"))); // NOI18N
        jButton1.setToolTipText("Registrar factura");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminarFila, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 3, true));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Cod.Cliente:");

        JLB_codCliente.setBackground(new java.awt.Color(204, 204, 204));
        JLB_codCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        JLB_codCliente.setForeground(new java.awt.Color(0, 102, 102));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Señor(es):");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Ced/RNC:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tel.:");

        telefo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        telefo.setForeground(new java.awt.Color(0, 102, 102));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Direccion:");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));

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
        jTextField6.setForeground(new java.awt.Color(0, 102, 102));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(telefo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(JLB_codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(buscarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buscarClientes)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JLB_codCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(telefo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jlb_fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlb_fecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField4.setEnabled(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jtf_total.setBackground(new java.awt.Color(204, 204, 255));
        jtf_total.setForeground(new java.awt.Color(102, 102, 102));
        jtf_total.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("$#,##0.###"))));
        jtf_total.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jtf_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_totalActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Total a Pagar");

        jTextField7.setEditable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Cotizacion");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/report.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlb_fecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlb_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void buscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClientesActionPerformed
       validar();
        BuscarCliente bc=new BuscarCliente();
        CamS.jDesktopPane1.add(bc);
        bc.toFront();
        bc.setLocation(50,10);
        bc.setVisible(true);
        BuscarCliente.jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_buscarClientesActionPerformed
   
    
 
   
    
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jtableDetalleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtableDetalleKeyTyped
        char teclapre=(char) evt.getKeyCode();
        if(KeyEvent.VK_ENTER != (teclapre)) {
            operaci();
            jTextField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jtableDetalleKeyTyped
    
    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
      scanner();
            Factura.operaci();
            Factura.calcularpuntos();         
         //   jTable2.requestFocusInWindow();
            jTextField2.setText("");
           // Selecionaarticulo(); 
            jTextField2.requestFocusInWindow();
    }//GEN-LAST:event_jTextField2ActionPerformed
    
    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
 
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jTextField6CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField6CaretUpdate

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
    }//GEN-LAST:event_jtableDetalleKeyPressed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
           /* scanner();
            FacturaCajeros.operaci();
            FacturaCajeros.calcularpuntos();         
            jTable2.requestFocusInWindow();
            jTextField2.setText("");
            Selecionaarticulo(); 
            jTextField2.requestFocusInWindow();*/
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        /* if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
            scanner();
            FacturaCajeros.operaci();
            FacturaCajeros.calcularpuntos();         
            jTable2.requestFocusInWindow();
            jTextField2.setText("");
     //   }else{
        ///  String codpro=  jtableDetalle.getValueAt(i,0).toString();
           
          //  if(){
            Selecionaarticulo(); 
            Limpiar_Tabla();
            jTextField2.requestFocusInWindow();
          //  }}
        }*/
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
     /*  char teclapre=(char) evt.getKeyCode();
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
        }  */ 
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       if(Cotizacion1.jtf_total.getText().length()>0){  
    //validar();
    numfac();
    guardar();
    }else
         JOptionPane.showMessageDialog(null,"DEBE AGREGAR UN ARTICULO A LA FACTURA");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jtf_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_totalActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
           BuscarArticulosCoti bc=new BuscarArticulosCoti();
           CamS.jDesktopPane1.add(bc);
           bc.toFront();
           bc.setLocation(50,10);
           bc.setVisible(true);
           BuscarArticulosCoti.jTextField1.requestFocusInWindow();
       } catch (SQLException ex) {
           Logger.getLogger(Cotizacion1.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton2ActionPerformed
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel JLB_codCliente;
    private javax.swing.JButton buscarClientes;
    private javax.swing.JButton eliminarFila;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    public static javax.swing.JComboBox jComboBox2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JLabel jlb_fecha;
    public static javax.swing.JTable jtableDetalle;
    public static javax.swing.JTextField jtf_desc;
    public static javax.swing.JTextField jtf_igv;
    public static javax.swing.JTextField jtf_subto;
    public static javax.swing.JFormattedTextField jtf_total;
    public static javax.swing.JLabel telefo;
    // End of variables declaration//GEN-END:variables
}
