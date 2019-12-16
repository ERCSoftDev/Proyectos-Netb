
package CamSyst.Consultas;

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import CamSyst.Controlador.ClassConection;
import CamSyst.Cliente.Factura;
import CamSyst.Cliente.FacturaCajeros;
import static CamSyst.Consultas.ConsultaFacturaCli.jTable1;
import CamSyst.Proveedor.MostrarFactura;
import CamSyst.Controlador.Reportes;
import CamSyst.Vista.CamS;
import java.awt.Color;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ConsultaFacturaCli extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    String userName;
    String passWord;
   public static Connection cn;
   public static CallableStatement cts;
   public static ResultSet r;
    public ConsultaFacturaCli() {
        initComponents();
         jTextField1.setEnabled(false);
         cn=conectar.conecion();
         cargar();
    }

public void cargar()    {
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
         cts=cn.prepareCall("{call mostrartodasFacturacli}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
   
       }catch (Exception e){}}
public static void Dias(){
    //String x=MostrarFactura.lbl_nFactuta.getText();
    try {
             cts=cn.prepareCall("DiasPagar");
             //cts.setString(1,x);
             r=cts.executeQuery();
        
          MostrarFactura.jTextField2.setText(r.getString(1));
 } catch (SQLException ex) {
        }
    
    }

private void mostrarDetallefacturacli(){
     MostrarFactura mf = new MostrarFactura();
                
         try {
            
       int row=ConsultaFacturaCli.jTable1.getSelectedRow();
       
        String idf=     ConsultaFacturaCli.jTable1.getValueAt(row, 0).toString();
        String fecha=   ConsultaFacturaCli.jTable1.getValueAt(row, 1).toString();
       // String NCF=     jTable1.getValueAt(row, 2).toString();
        String idcli=   ConsultaFacturaCli.jTable1.getValueAt(row, 3).toString();
        String NCF=     ConsultaFacturaCli.jTable1.getValueAt(row, 2).toString();
        String ruccli=  ConsultaFacturaCli.jTable1.getValueAt(row, 4).toString();
        String fp=      ConsultaFacturaCli.jTable1.getValueAt(row, 5).toString();
        String sub_to=  ConsultaFacturaCli.jTable1.getValueAt(row, 6).toString();
        String desc=    ConsultaFacturaCli.jTable1.getValueAt(row, 7).toString();
        String igv=     ConsultaFacturaCli.jTable1.getValueAt(row, 8).toString();
        String tot_a_pa=ConsultaFacturaCli.jTable1.getValueAt(row, 9).toString();
        String fep=     ConsultaFacturaCli.jTable1.getValueAt(row, 10).toString();
      
        DefaultTableModel tabla = (DefaultTableModel) MostrarFactura.jtableDetalle.getModel();
        try
       {
        cts=cn.prepareCall("{call mostrarDeta(?)}");
        cts.setString(1, idf);
        r=cts.executeQuery();
        
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       
       MostrarFactura.jtableDetalle .setModel(tabla);
       
       MostrarFactura.lbl_nFactuta  .setText(idf);
       MostrarFactura.JLB_codCliente.setText(idcli);
       MostrarFactura.combrobante   .setText(NCF);
       MostrarFactura.jlb_ruc       .setText(ruccli);
       MostrarFactura.jTextField1   .setText(fp);
       MostrarFactura.lbl_Fecha     .setText(fecha);
       MostrarFactura.jlb_subtotal  .setText(sub_to);
       MostrarFactura.jlb_des       .setText(desc);
       MostrarFactura.jlb_igv       .setText(igv);
       MostrarFactura.jlb_total     .setText(tot_a_pa);
       MostrarFactura.jTextField2   .setText(fep);
       
  }catch (Exception e){}
        } catch (Exception ex) {
        
          Logger.getLogger(FacturaCajeros.class.getName()).log(Level.SEVERE, null, ex);
        }
        CamS.jDesktopPane1.add(mf);
        mf.toFront();
        mf.setLocation(50,10);
        mf.setVisible(true);
       // this.dispose();
       }
private void mostrarDetallefacturacliNotaCredito(){
     MostrarFacturaNotaCredito mf = new MostrarFacturaNotaCredito();
                
         try {
            
       int row=jTable1.getSelectedRow();
       
        String idf=     jTable1.getValueAt(row, 0).toString();
        String fecha=   jTable1.getValueAt(row, 1).toString();
        String NCF=     jTable1.getValueAt(row, 2).toString();
        String idcli=   jTable1.getValueAt(row, 3).toString();
        String ruccli=  jTable1.getValueAt(row, 4).toString();
        String fp=      jTable1.getValueAt(row, 5).toString();
        String sub_to=  jTable1.getValueAt(row, 6).toString();
        String desc=    jTable1.getValueAt(row, 7).toString();
        String igv=     jTable1.getValueAt(row, 8).toString();
        String tot_a_pa=jTable1.getValueAt(row, 9).toString();
        String fep=     jTable1.getValueAt(row, 10).toString();
      //String itb=     jTable1.getValueAt(row, 9).toString();
      
        DefaultTableModel tabla = (DefaultTableModel) MostrarFacturaNotaCredito.jtableDetalle.getModel();
        try
       {
        cts=cn.prepareCall("{call mostrarDeta(?)}");
        cts.setString(1, idf);
        r=cts.executeQuery();
        
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       
       MostrarFacturaNotaCredito.jtableDetalle .setModel(tabla);
       
       MostrarFacturaNotaCredito.lbl_nFactuta  .setText(idf);
       MostrarFacturaNotaCredito.JLB_codCliente.setText(idcli);
       MostrarFacturaNotaCredito.jlb_ruc       .setText(ruccli);
       MostrarFacturaNotaCredito.jTextField1   .setText(fp);
       MostrarFacturaNotaCredito.lbl_Fecha     .setText(fecha);
       MostrarFacturaNotaCredito.jlb_subtotal  .setText(sub_to);
       MostrarFacturaNotaCredito.jlb_des       .setText(desc);
       MostrarFacturaNotaCredito.jlb_igv       .setText(igv);
       MostrarFacturaNotaCredito.jlb_total     .setText(tot_a_pa);
       MostrarFacturaNotaCredito.jTextField2   .setText(fep);
       MostrarFacturaNotaCredito.jTextField3   .setText(NCF);
       
  }catch (Exception e){}
        } catch (Exception ex) {
        
          Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
           CamS.jDesktopPane1.add(mf);
        mf.toFront();
        mf.setLocation(50,10);
        mf.setVisible(true);
       // this.dispose();
}
private void buscarpornombreCliente(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       tabla.addColumn("Nombre cliente");
       
       String X=jTextField1.getText();
         cts=cn.prepareCall("{call mostrarFacturaNomCli(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[12];
       for (int i=0; i<12; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void buscarporRNC(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
       String X=jTextField1.getText();
         cts=cn.prepareCall("{call mostrarFacturaRNC(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void buscarporCodCli(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
       String X=jTextField1.getText();
         cts=cn.prepareCall("{call mostrarFacturaCodCli(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void buscarporFormaPago(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
       String X=jTextField1.getText();
         cts=cn.prepareCall("{call mostrarFacturaFormaPago(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void buscarporFecha(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
       String X=jTextField1.getText();
         cts=cn.prepareCall("{call mostrarPorFecha(?)}");
            cts.setString(1, X);
            r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void convertirFechas()    {
     String dia = Integer.toString(jDateChooser1.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mes = Integer.toString(jDateChooser1.getCalendar().get(Calendar.MONTH)+1);
    String year = Integer.toString(jDateChooser1.getCalendar().get(Calendar.YEAR));
    String fechaI = ( dia+ "/" + mes+ "/" + year);
    jTextField2.setText(fechaI);

    String diaf = Integer.toString(jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH));
    String mesf = Integer.toString(jDateChooser2.getCalendar().get(Calendar.MONTH)+1);
    String yearf = Integer.toString(jDateChooser2.getCalendar().get(Calendar.YEAR));
    String fechaF = (diaf+ "/" + mesf+ "/" + yearf);
    jTextField3.setText(fechaF);
    }
private void convertirmes()    {
    String mes = Integer.toString(jMonthChooser1.getMonth()+1);
    String fechaI = (mes);
    jTextField4.setText(fechaI);
    }
public static void imprimirmes()        {

    try{
      
    String rutaInforme= "C:\\Users\\Vigilandotech\\Desktop\\Nueva carpeta\\cam\\SistemaVentas\\src\\Reportes\\ReportFacturasCliente.jrxml";
        Reportes re= new Reportes();
        Map parametros = new HashMap();
        parametros.put("MES",jTextField4.getText());
        re.verReporteFacMes(rutaInforme, parametros);

    } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
}

private void buscarporRangoFecha(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
     String in=jTextField2.getText();
     String f=jTextField3.getText();
        
         cts=cn.prepareCall("{call mostrarPorRangoFecha(?,?)}");
         
           cts.setString(1,in);
           cts.setString(2, f);
            r=cts.executeQuery();
          //  JOptionPane.showMessageDialog(this,"ESTOY VIVO POR AQUI!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
       while (r.next()){
           
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       ConsultaFacturaCli.jTable1.setModel(tabla);
       
       }catch (Exception e){}
       
    }
private void buscarpormes(){
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
       tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
     String in=jTextField4.getText();
        
         cts=cn.prepareCall("{call mostrarPormes(?)}");
         
           cts.setString(1,in);
            r=cts.executeQuery();
       while (r.next()){
           
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       ConsultaFacturaCli.jTable1.setModel(tabla);
       
       }catch (Exception e){}
       
    }
private void mostrartodas()       {
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
 
         cts=cn.prepareCall("{call mostrarTodasfac}");
           r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[11];
       for (int i=0; i<11; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
private void mostrartodasNC()     {
    
      DefaultTableModel tabla= new DefaultTableModel();
       try{
         tabla.addColumn("N° Factura");
       tabla.addColumn("Fecha");
       tabla.addColumn("NCF");
       tabla.addColumn("N/C");
       tabla.addColumn("Cod-Cliente");
       tabla.addColumn("RNC");
        tabla.addColumn("Forma de Pago");
       tabla.addColumn("Sub-Total");
       tabla.addColumn("Descuento");
       tabla.addColumn("Itbi");
       tabla.addColumn("Total a Pagar");
       tabla.addColumn("FechaPago");
       
 
         cts=cn.prepareCall("{call mostrarTodasfacNC}");
           r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[12];
       for (int i=0; i<12; i++){
           dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       }catch (Exception e){}
       
    }
public static void generanumNC(){
try{
        
         cts=cn.prepareCall("{call GeneranumNC}");
         r=cts.executeQuery();
         if (r.next())
        
          MostrarFacturaNotaCredito.jTextField4.setText(r.getString(1));
          }catch (Exception e){} 
}
public static void generacodNC(){
try{
        
         cts=cn.prepareCall("{call GeneracodNC}");
         r=cts.executeQuery();
         if (r.next())
        
          MostrarFacturaNotaCredito.jTextField5.setText(r.getString(1));
          }catch (Exception e){} 
}
public static void incrementarNC()  {
          try{
        
         cts=cn.prepareCall("{call registrarcomprobanteNC}");
         r=cts.executeQuery();

           
       }catch (Exception e){} 
}
public static void guardarNC(){
    
     for(int i=0;i<MostrarFacturaNotaCredito.jtableDetalle.getRowCount();i++){

String codNC=       MostrarFacturaNotaCredito.jTextField5.   getText();         
String diaspar=     MostrarFacturaNotaCredito.jTextField2.   getText();
String numfac=      MostrarFacturaNotaCredito.lbl_nFactuta.  getText();
String CompNC=      MostrarFacturaNotaCredito.jTextField4.   getText();
String NCFAfectado= MostrarFacturaNotaCredito.jTextField3.   getText();
String codcli=      MostrarFacturaNotaCredito.JLB_codCliente.getText();
String formadepago= MostrarFacturaNotaCredito.jTextField1.   getText();
String rnc=         MostrarFacturaNotaCredito.jlb_ruc.       getText();
String fecha=       MostrarFacturaNotaCredito.lbl_Fecha.     getText();
String subtotal=    MostrarFacturaNotaCredito.jlb_subtotal.  getText();
String descuento=   MostrarFacturaNotaCredito.jlb_des.       getText();
String itbis=       MostrarFacturaNotaCredito.jlb_igv.       getText();
String total=       MostrarFacturaNotaCredito.jlb_total.     getText();
String fechaNC=     MostrarFacturaNotaCredito.jTextField6.   getText();

        String codpro=      MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,0).toString();
        String nombrepro  = MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,1).toString();        
        String cantidad=    MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,2).toString();
        String precio =     MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,3).toString();
        String itbc =       MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,4).toString();
        String preciototal =MostrarFacturaNotaCredito.jtableDetalle.getValueAt(i,5).toString();

try {
          
            cts=cn.prepareCall("{call guardarNC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cts.setString(1, codNC);
            cts.setString(2, diaspar);             //1
            cts.setString(3, numfac);           //2
            cts.setString(4, CompNC);//3
            cts.setString(5, NCFAfectado);  //4
            cts.setString(6, codcli);  //5
            cts.setString(7, formadepago);        //6
            cts.setString(8, rnc);      //7
            
            cts.setString(9,  fecha);            //8
            cts.setString(10,  subtotal);          //9
            cts.setString(11, descuento);           //10
            cts.setString(12, itbis);         //11
            cts.setString(13, total);   //12
           
            cts.setString(14, codpro);            //13
            cts.setString(15, nombrepro);          //14
            cts.setString(16, cantidad);           //15
            cts.setString(17, precio);         //16
            cts.setString(18, itbc);//17
            cts.setString(19, preciototal);//18
            cts.setString(20, fechaNC);
            
            int opcion=cts.executeUpdate();
            //if(opcion==1)
            

        }catch(SQLException e){
            }
       
       }
}

public void colorear(){
    
    for(int i=0;i<ConsultaFacturaCli.jTable1.getRowCount();i++){
if (jTable1.getValueAt(i, 2).toString().equals("NCF") ){

         setBackground(Color.MAGENTA);

}else{

         setBackground(Color.GREEN);

}} 

}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jMenuItem1.setText("Mostrar detalles de factura");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Generar nota de credito");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jLabel2.setText("A");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setSelectionBackground(new java.awt.Color(153, 204, 0));
        jTable1.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jTable1.setShowHorizontalLines(false);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(153, 204, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377296_printer.png"))); // NOI18N
        jButton2.setToolTipText("Imprimir facturas de clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 204, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setToolTipText("Buscar factura");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jRadioButton3.setSelected(true);
        jRadioButton3.setText("Factura de hoy");
        jRadioButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 204, 0));
        jLabel4.setText("Listado de facturas");

        jComboBox1.setBackground(new java.awt.Color(102, 102, 102));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 204, 0));
        jComboBox1.setMaximumRowCount(10);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Otras opciones", "Nombre cliente", "RNC", "Codigo cliente", "Forma de pago", "Fecha", "Por Mes", "Rango de fechas", "Todas las facturas", "Notas de credito de hoy" }));
        jComboBox1.setAutoscrolls(true);
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.setMinimumSize(new java.awt.Dimension(136, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(136, 30));
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fecha inicial");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Fecha final");

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Buscar por rango");

        jMonthChooser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("enviar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jMonthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jTextField2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(286, 286, 286))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField4)
                        .addComponent(jLabel4)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(67, 67, 67))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

convertirFechas(); 
buscarporRangoFecha();   

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
      mostrarDetallefacturacli();
      Dias();
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        cargar();
        jTextField1.setText("");
                jTextField1.setEnabled(false);
             
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                  int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA HACER ESTO","ALERTA!",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
    
     int opcion2=JOptionPane.showConfirmDialog(null,"SE GENERARA UNA NOTA DE CREDITO CON LOS DATOS DE ESTA FACTURA","DESEA CONTINUAR?!",JOptionPane.YES_NO_OPTION);
if(opcion2==JOptionPane.YES_NO_OPTION)
      try {
         mostrarDetallefacturacliNotaCredito();
         generacodNC();
         generanumNC();
         Dias();
         
         
         } catch (HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        imprimirmes();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       mostrarDetallefacturacli();
    }//GEN-LAST:event_jTable1KeyPressed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

        if (jComboBox1.getSelectedItem().equals("Nombre cliente")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
       jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
                
                
            }else if (jComboBox1.getSelectedItem().equals("RNC")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
            }else if (jComboBox1.getSelectedItem().equals("Codigo cliente")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
            }else if (jComboBox1.getSelectedItem().equals("Forma de pago")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
            }else if (jComboBox1.getSelectedItem().equals("Fecha")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
            }else if (jComboBox1.getSelectedItem().equals("Fecha")){
              jTextField1.setText("");
                jTextField1.setEnabled(true);
                jTextField2.setText("");
       jTextField3.setText("");
       jDateChooser1.setCalendar(null);
       jDateChooser2.setCalendar(null);
       jDateChooser1.setEnabled(false);
       jDateChooser2.setEnabled(false);
                jTextField1.requestFocus();
            }
            else if (jComboBox1.getSelectedItem().equals("Por Mes")){
               try{
           jDateChooser1.setEnabled(false);
           jDateChooser2.setEnabled(false);
           jTextField1.setText("");
           jTextField1.setEnabled(false);
           jMonthChooser1.requestFocus();
        }catch(Exception e){}
            }else if (jComboBox1.getSelectedItem().equals("Todas las facturas")){
               try{
           jRadioButton3.setSelected(isIcon);
           jTextField1.setText("");
           jTextField1.setEnabled(false);
           mostrartodas();
        }catch(Exception e){}
               
   }else if (jComboBox1.getSelectedItem().equals("Notas de credito de hoy")){
               try{
           jRadioButton3.setSelected(isIcon);
           jTextField1.setText("");
           jTextField1.setEnabled(false);
           mostrartodasNC();
           }catch(Exception e){}
               
   }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
     if(jComboBox1.getSelectedItem().equals("Nombre cliente")){
         buscarpornombreCliente();
     }else if(jComboBox1.getSelectedItem().equals("RNC")){
        buscarporRNC();
     }else if(jComboBox1.getSelectedItem().equals("Codigo cliente")){
        buscarporCodCli();
     }else if(jComboBox1.getSelectedItem().equals("Forma de pago")){
        buscarporFormaPago();
     }else if(jComboBox1.getSelectedItem().equals("Fecha")){
        buscarporFecha();
     }else if(jComboBox1.getSelectedItem().equals("Rango de fechas")){
       // buscarporRNC();
     }    
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked
      convertirFechas();
    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
      
       
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
convertirmes();
buscarpormes();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
