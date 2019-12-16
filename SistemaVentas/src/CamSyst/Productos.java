//UC-004
//Enfry Reyes Ciprian

package CamSyst;

import java.sql.*;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import CamSyst.Controlador.ClassConection;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import CamSyst.Controlador.Reportes;
import java.text.ParseException;
import java.util.Calendar;

public class Productos extends javax.swing.JInternalFrame {

    ClassConection conectar=new ClassConection();
    Connection        con;
    CallableStatement cst;
    ResultSet         r;
    
    public Productos(String user,String password) {
        initComponents();
        con=conectar.conecion();
    
    Calendar cal=Calendar.getInstance();
       String fecha=cal.get(Calendar.DATE) +"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
       jLabel18.setText(fecha);    
    cargarHistorialProductos();    
    cargar();
    try
{
    
    MaskFormatter mascara = new MaskFormatter("##.##");
    // Se construye el JFormattedTextField pasándole la máscara
    JFormattedTextField textField = new JFormattedTextField(mascara);
    // Se da un valor inicial válido para evitar problemas
    textField.setValue(new Float("12.34"));
}
catch ( ParseException | NumberFormatException e){}
    }
    
    //metodo para mostrar el contenido de la tabla 
    private void cargar(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn  ("CODIGO");
       tabla.addColumn  ("PRODUCTO");
       tabla.addColumn  ("DETALLE");
       tabla.addColumn  ("PROVEEDOR");
       tabla.addColumn  ("COSTO");
       tabla.addColumn  ("PRECIO LISTA");
       tabla.addColumn  ("PORCIENTO");
       tabla.addColumn  ("PRECIO VENTA");
       tabla.addColumn  ("STOCK");
       tabla.addColumn  ("STOCK MIN.");
       tabla.addColumn  ("UBICACION");
       tabla.addColumn  ("VENCIMIENTO");
       
       tabla.addColumn  ("CODIGO FABRICA");
       tabla.addColumn  ("ITBIS");
       tabla.addColumn  ("VALOR ITBIS");
       tabla.addColumn  ("PRECIO V.+ITBIS");
       
         cst=con.prepareCall("{call mostrarpro}");
         r=cst.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[16];
       for (int i=0; i<16; i++){
       dato[i]=r.getString(i+1);
     }
       tabla.addRow(dato);
}
       this.jTable1.setModel(tabla);
}catch (Exception e){}
       
    }
       
    private void cargarHistorialProductos(){
        
         DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn  ("Codigo");
       tabla.addColumn  ("Fecha");
       tabla.addColumn  ("Producto");
       tabla.addColumn  ("Accion");
       
         cst=con.prepareCall("{call verhistorialprod}");
         r=cst.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[4];
       for (int i=0; i<4; i++){
       dato[i]=r.getString(i+1);
     }
       tabla.addRow(dato);
}
       this.jTable2.setModel(tabla);
}catch (Exception e){}       
       
//Metodo para desabilitar los botones
desabilitar();
           this.registrar.setEnabled(false);
           this.NuevoCliente.setEnabled(true);
           this.buscar.setEnabled(true);
           this.modificar.setEnabled(false);
           this.eliminar.setEnabled(false);
              }

    //Metodo para habilitar los botones
    public void abilitar (){
           this.jTextField2.setEnabled(true);
           this.jTextField3.setEnabled(true); 
           this.jTextField4.setEnabled(true); 
           this.jTextField5.setEnabled(true); 
           this.jTextField7.setEnabled(true);
           this.jTextField14.setEnabled(true);
           this.jTextField7.setEnabled(true);
           this.precioLista.setEnabled(true);
           this.jTextField6.setEnabled(true); 
           this.jTextField2.requestFocus();
           this.jTextField17.setEnabled(true);
           this.precioVenta.setEnabled(true);
           this.precioCosto.setEnabled(true);
           this.jTextField9.setEnabled(true);
           this.jTextField11.setEnabled(true);
           this.jTextField12.setEnabled(true); 
           this.jTextField13.setEnabled(true);
           this.jTextField15.setEnabled(true);         
           this.jTextArea1.setEnabled(true);
           
}
    //metodo para desabilitar los campos de textos
    public void desabilitar(){
           this.jTextField2.setEnabled(false);
           this.jTextField3.setEnabled(false); 
           this.jTextField4.setEnabled(false);
           this.jTextField5.setEnabled(false);
           this.jTextField7.setEnabled(false);
           
           this.jTextField11.setEnabled(false);
           this.jTextField12.setEnabled(false); 
           this.jTextField13.setEnabled(false);
           this.jTextField15.setEnabled(false);
           this.jTextArea1.setEnabled(false);
           
           this.precioLista.setEnabled(false);
           this.jTextField6.setEnabled(false); 
           this.jTextField17.setEnabled(false);
           this.precioVenta.setEnabled(false);
           this.precioCosto.setEnabled(false);
           this.jTextField9.setEnabled(false);
           this.jTextField14.setEnabled(false);
           //this.itbis.setEnabled(false);
           
}
    //Metodo para limpiar los campos de textos
    public void limpiar(){
           this.jTextField1.setText("");
           this.jTextField2.setText("");
           this.jTextField3.setText(""); 
           this.jTextField7.setText("");
           this.precioLista.setText("");
           this.jTextField6.setText("");
           this.precioVenta.setText("");
           this.precioCosto.setText("");
           this.jTextField4.setText("");
           this.jTextField5.setText("");
           this.jTextField8.setText("");
           this.jTextField9.setText("");
           this.jTextField14.setText("");
            this.jTextArea1.setText("");
           this.jTextField11.setText("");
           this.jTextField12.setText("");
           this.jTextField13.setText("");
           this.jTextField15.setText("");
           this.itbis.setText("");
           this.jTextField18.setText("");
           this.jTextField17.setText("");
           this.jTextField16.setText("");
 
}
    
    private void cargarInfoAdi(){
   String X=jTextField1.getText();
          try {
            cst=con.prepareCall("{call buscarInfoAdicionalproducto(?)}");
            cst.setString(1, X);
            r=cst.executeQuery();

            if(r.next()){
            JOptionPane.showMessageDialog(this,"Informacio Adicional agregada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
       
       // jTextField1. setText(r.getString(2));

        jTextArea1  .setText(r.getString(2));
        jTextField11.setText(r.getString(3));
        jTextField12.setText(r.getString(4));
        jTextField13.setText(r.getString(5));
        jTextField15.setText(r.getString(6));
       
 }else{
           JOptionPane.showMessageDialog(this,"Informacion adicional  No Encontrada!!","Aviso",JOptionPane.INFORMATION_MESSAGE);
}
        } catch (SQLException | HeadlessException e) {JOptionPane.showMessageDialog(this, e.toString());
}
    
    
}
    
    private void informacionAdicional(){
           String cod=jTextField1. getText();
           String extra=jTextArea1.  getText();
           String aplicacion=jTextField11.getText();
           String componente=jTextField12.getText();
           String equivalente=jTextField13.getText();
           String fabricante=jTextField15.getText();
         
           
            try {

            //Mostramos los datos
            cst = con.prepareCall("{call regInformacionProd(?,?,?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, extra);
            cst.setString(3, aplicacion);
            cst.setString(4, componente);
            cst.setString(5, equivalente);
            cst.setString(6, fabricante);
            
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Esta nueva operacion a sido registrada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               
            } else {

                JOptionPane.showMessageDialog(this, "Error al registrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
}
}

    private void enviartable2(){
        String cod = jTextField1.getText();
        String fecha = jLabel18.getText();
        String pro = jTextField2.getText();
        String accion = jTextField8.getText();

        try {

            //Mostramos los datos
            cst = con.prepareCall("{call historialProd(?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, fecha);
            cst.setString(3, pro);
            cst.setString(4, accion);
            
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Esta nueva operacion a sido registrada por seguridad", "Aviso", JOptionPane.INFORMATION_MESSAGE);
               
            } else {

                JOptionPane.showMessageDialog(this, "Error al registrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        
}

}
   
    public void calculaUtilidad(){
 double val1 = Double.parseDouble(precioLista.getText()); 
       double val2 = Double.parseDouble(jTextField17.getText()); 
       double suma = val1 * val2/100+val1; 
       
       String valorTotal = Double.toString(suma); 
       precioVenta.setText(String.valueOf(valorTotal)); 
    
 } 

    public void calculadora(){
 double val1 = Double.parseDouble(precioLista.getText()); 
       double val2 = Double.parseDouble(jTextField17.getText()); 
       double suma = val1 * val2/100+val1; 
       
       String valorTotal = Double.toString(suma); 
       precioVenta.setText(String.valueOf(valorTotal)); 
    
 } 
    
    public void calculavalorItbis(){
 double val1 = Double.parseDouble(precioVenta.getText()); 
       double val2 = Double.parseDouble(itbis.getText()); 
       double suma = val1 * val2/100; 
       
       String valorTotal = Double.toString(suma); 
       jTextField16.setText(String.valueOf(valorTotal)); 
    
 }

    public void calculaItbis(){
 double val1 = Double.parseDouble(precioVenta.getText()); 
       double val2 = Double.parseDouble(jTextField16.getText()); 
       double suma = val1 + val2; 
       
       String valorTotal = Double.toString(suma); 
       jTextField18.setText(String.valueOf(valorTotal)); 
    
 }
   
    public void calcular(){
        int x= Integer.parseInt(precioLista.getText());
        double z= x*0.30;
        precioVenta.setText(String.valueOf(z));
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        precioCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        precioLista = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        precioVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        itbis = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField8 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        buscar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        NuevoCliente = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField10 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jScrollBar2 = new javax.swing.JScrollBar();

        jMenuItem1.setText("Actualizar Registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("MANTENIMIENTO DE PRODUCTOS");
        setAutoscrolls(true);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel2.setAutoscrolls(true);

        jPanel4.setBackground(new java.awt.Color(251, 233, 216));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 0), null));
        jPanel4.setAutoscrolls(true);

        jTextField1.setToolTipText("");
        jTextField1.setEnabled(false);
        jTextField1.setFocusAccelerator('*');
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });

        jLabel1.setText("Codigo Sistema:");

        jLabel2.setText("Producto:");

        jLabel3.setText("Detalle:");

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel4.setText("Proveedor:");

        jLabel5.setText("Precio Costo:");

        precioCosto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioCosto.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                precioCostoCaretUpdate(evt);
            }
        });
        precioCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioCostoActionPerformed(evt);
            }
        });
        precioCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioCostoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioCostoKeyTyped(evt);
            }
        });

        jLabel6.setText("Cantidad:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel7.setText("Stock Minimo:");

        jLabel8.setText("Precio Lista:");

        precioLista.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioLista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                precioListaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioListaKeyTyped(evt);
            }
        });

        jLabel9.setText("Precio venta sin Itbis:");

        precioVenta.setEditable(false);
        precioVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        precioVenta.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                precioVentaInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        precioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioVentaActionPerformed(evt);
            }
        });
        precioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioVentaKeyTyped(evt);
            }
        });

        jLabel10.setText("Utilidad:");

        jLabel11.setText("Ref. Ubicacion:");

        jTextField5.setBackground(new java.awt.Color(204, 255, 204));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel15.setText("Fecha vencimiento:");

        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("dd/mm/aaaaa");

        jLabel25.setText("Codigo Fab.:");

        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("%");

        jLabel12.setText("Itbis:");

        jTextField16.setEditable(false);
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel14.setText("%");

        itbis.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        itbis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itbisKeyPressed(evt);
            }
        });

        jLabel30.setText("Precio Venta+ Itbis:");

        jTextField18.setEditable(false);
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel31.setText("Valor del impuesto");

        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField17KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(jLabel25)
                                .addComponent(jLabel1))
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel15)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(10, 10, 10))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addComponent(jLabel30))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(precioVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(precioLista, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(precioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel27))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(itbis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel31)))
                            .addGap(2, 2, 2)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTextField7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(precioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(precioLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itbis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel12))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(precioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Mantenimiento de Productos", jPanel2);

        jPanel6.setBackground(new java.awt.Color(251, 233, 216));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 0), null));

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 177, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jLabel20.setText("Aplicacion:");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Imagen del producto");

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel22.setText("Componente:");

        jLabel23.setText("Equivalente:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jLabel24.setText("Inf. Extra:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451536341_Add.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/handle4.png"))); // NOI18N

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel28.setText("Fabricante/ Distribuidor:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField12, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                                .addComponent(jTextField13)))
                        .addGap(0, 0, 0)
                        .addComponent(jLabel29))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(25, 25, 25))
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel20))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel24))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informacion Adicional", jPanel6);

        jPanel8.setBackground(new java.awt.Color(251, 233, 216));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), null));

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
                {null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Acccion "
            }
        ));
        jTable2.setSelectionBackground(new java.awt.Color(255, 102, 0));
        jTable2.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(jTable2);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel13.setText("Ultimos productos alterados...  Notificacion");

        jLabel17.setText("de hoy fecha:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("jLabel18");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(0, 108, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        jTabbedPane1.addTab("Notificaciones", jPanel8);

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xmag.png"))); // NOI18N
        buscar.setToolTipText("Buscar Articulo");
        buscar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        buscar.setBorderPainted(false);
        buscar.setContentAreaFilled(false);
        buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/698873-icon-136-document-edit-32.png"))); // NOI18N
        modificar.setToolTipText("Modificar un producto");
        modificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete-32.png"))); // NOI18N
        eliminar.setToolTipText("Eliminar un articulo");
        eliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/close_delete.png"))); // NOI18N
        cancelar.setToolTipText("Cancelar operacion");
        cancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        NuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/new-file.png"))); // NOI18N
        NuevoCliente.setToolTipText("Crear un nuevo producto");
        NuevoCliente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        NuevoCliente.setBorderPainted(false);
        NuevoCliente.setContentAreaFilled(false);
        NuevoCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoClienteActionPerformed(evt);
            }
        });

        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        registrar.setToolTipText("Registrar Articulo");
        registrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        registrar.setBorderPainted(false);
        registrar.setContentAreaFilled(false);
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(NuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NuevoCliente)
                    .addComponent(modificar)
                    .addComponent(buscar)
                    .addComponent(registrar)
                    .addComponent(eliminar)
                    .addComponent(cancelar))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setAutoscrolls(true);

        jTable1.setBackground(new java.awt.Color(251, 240, 229));
        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE PRODUCTO", "DETALLE", "PROVEEDOR", "PRECIO ", "STOCK"
            }
        ));
        jTable1.setToolTipText("Lista de productos en el inventario");
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setGridColor(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionBackground(new java.awt.Color(255, 102, 51));
        jTable1.setShowHorizontalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField10KeyReleased(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Ingrese el nombre y pulse Enter...");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377296_printer.png"))); // NOI18N
        jButton3.setToolTipText("Imprimir listado de productos ");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_logout_63128.png"))); // NOI18N
        salir.setToolTipText("Salir de esta ventana");
        salir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 204, 255), null, null));
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 244, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salir))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
           cargar();            
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void NuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoClienteActionPerformed
    
        try{
            jTextField8.setText("Agregado");    
            cst=con.prepareCall("{call Genera_num_PRODUCTOS}");
            r=cst.executeQuery();
            if (r.next())

            jTextField1.setText(r.getString(1));
        }catch (Exception e){}

        abilitar();
        this.registrar.setEnabled(true);
        this.NuevoCliente.setEnabled(false);
        this.buscar.setEnabled(false);
        this.modificar.setEnabled(false);
        this.eliminar.setEnabled(false);
    }//GEN-LAST:event_NuevoClienteActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

        limpiar();
        desabilitar();
        this.registrar.setEnabled(false);
        this.NuevoCliente.setEnabled(true);
        this.buscar.setEnabled(true);
        this.modificar.setEnabled(false);
        this.eliminar.setEnabled(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        //Boton para eliminar
        
        String cod = this.jTextField1.getText();
        try {
            
            jTextField8.setText("Eliminado");
            cst = con.prepareCall("{call eliminarpro(?)}");
            cst.setString(1, cod);
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Producto Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                enviartable2();
                cargarHistorialProductos();
                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(true);
                this.buscar.setEnabled(true);
                this.modificar.setEnabled(false);
                this.eliminar.setEnabled(false);
                cargar();
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Producto No Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        //Boton para modificar
        //Capturamos los datos
       
        calculadora();    
        String cod = jTextField1.getText();
        String pro = jTextField2.getText();
        String det = jTextField3.getText();
        String stoc = jTextField4.getText();
        String ubicacion = jTextField5.getText();
        String prov = jTextField7.getText();
        String precioc = precioCosto.getText();
        String preciov = precioVenta.getText();
        String listp = jTextField17.getText();
        String prec = precioLista.getText();
        double stc =     Double.parseDouble  (this.jTextField6.getText());
        String vencimiento = jTextField9.getText();
        String it = jTextField16.getText();
        String itb = itbis.getText();
        String pvci = jTextField18.getText();

        try {

            //Mostramos los datos
            jTextField8.setText("Alterado");
            cst = con.prepareCall("{call modicficarpro(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, pro);
            cst.setString(3, det);
            cst.setString(4, prov);
            cst.setString(5, precioc);
            cst.setString(6, prec);
            cst.setString(7, listp);
            cst.setString(8, preciov);
            cst.setDouble(9, stc);
            cst.setString(10, stoc);
            cst.setString(11, ubicacion);
            cst.setString(12, vencimiento);
            cst.setString(13, itb);
            cst.setString(14, it);
             cst.setString(15, pvci);

            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Producto Modificado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                enviartable2();
                cargarHistorialProductos();
                cargar();
                limpiar();
                desabilitar();

                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(true);
                this.buscar.setEnabled(true);
                this.modificar.setEnabled(false);
                this.eliminar.setEnabled(false);
            } else {

                JOptionPane.showMessageDialog(this, "Error al modificar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed


        try {
            String codFabrica=JOptionPane.showInputDialog("INGRESE EL CODIGO DE FABRICA DEL PRODUCTO A BUSCAR");
            this.jTextField8.setText("Modificado");
            cst = con.prepareCall("{call buscarProductos(?)}");
            cst.setString(1,codFabrica);
            r = cst.executeQuery();

            if (r.next()) {
                JOptionPane.showMessageDialog(this, "Producto Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                
                abilitar();
                //Mostramo los datos
                this.jTextField1    .setText(r.getString(1));
                this.jTextField2    .setText(r.getString(2));
                this.jTextField3    .setText(r.getString(3));
                this.jTextField7    .setText(r.getString(4));
                this.precioCosto    .setText(r.getString(5));
                this.precioLista    .setText(r.getString(6));
                this.jTextField17   .setText(r.getString(7));
                this.precioVenta    .setText(r.getString(8));
                this.jTextField6    .setText(r.getString(9));
                this.jTextField4    .setText(r.getString(10));
                this.jTextField5    .setText(r.getString(11));
                this.jTextField9    .setText(r.getString(12));
                this.jTextField14   .setText(r.getString(13));
                this.itbis          .setText(r.getString(14));
                this.jTextField16   .setText(r.getString(15));
                this.jTextField18   .setText(r.getString(16));
                
                
                cargarInfoAdi();

                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(false);
                this.buscar.setEnabled(false);
                this.modificar.setEnabled(true);
                this.eliminar.setEnabled(true);

            } else {

                JOptionPane.showMessageDialog(this, "Producto  No Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void guardar(){
        calculadora();
        String cod =                    jTextField1.getText();
        String pro =                    jTextField2.getText();
        String det =                    jTextField3.getText();
        String stoc =                   jTextField4.getText();
        String ubicacion =              jTextField5.getText();
        String prov =                   jTextField7.getText();
        String precioc =                precioCosto.getText();
        String preciov =                precioVenta.getText();
        String utilidad =               jTextField17.getText();
        String prec =                   precioLista.getText();
        int stc =Integer.parseInt (this.jTextField6.getText());
        String vencimiento =            jTextField9.getText();
        String codFabrica =             jTextField14.getText();
        String itbi=                    itbis.getText();
        String ValorItbis=              jTextField16.getText();
        String PrecioVentaconIrbis=     jTextField18.getText();
        

        try {

            //Mostramos los datos
            cst = con.prepareCall("{call productosnuevos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, cod);
            cst.setString(2, pro);
            cst.setString(3, det);
            cst.setString(4, prov);
            cst.setString(5, precioc);
            cst.setString(6, prec);
            cst.setString(7, utilidad);
            cst.setString(8, preciov);
            cst.setDouble(9, stc);
            cst.setString(10, stoc);
            cst.setString(11, ubicacion);
            cst.setString(12, vencimiento);
            cst.setString(13, codFabrica);
            cst.setString(14, itbi);
            cst.setString(15, ValorItbis);
            cst.setString(16, PrecioVentaconIrbis);

            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Producto registrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                desabilitar();

                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(true);
                this.buscar.setEnabled(true);
                this.modificar.setEnabled(false);
                this.eliminar.setEnabled(false);
            } else {

                JOptionPane.showMessageDialog(this, "Error al registrar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
}
    private void selecion(){
int row=        jTable1.getSelectedRow();
        String cod=             jTable1.getValueAt(row, 0).toString();
        String pro=             jTable1.getValueAt(row, 1).toString();
        String det=             jTable1.getValueAt(row, 2).toString();
        String prov=            jTable1.getValueAt(row, 3).toString();
        String precioc=         jTable1.getValueAt(row, 4).toString();
        String prec=            jTable1.getValueAt(row, 5).toString();
        String utilidad=        jTable1.getValueAt(row, 6).toString();
        String preciov=         jTable1.getValueAt(row, 7).toString();
        String stc=             jTable1.getValueAt(row, 8).toString();
        String stoc=            jTable1.getValueAt(row, 9).toString();
        String ubicacion=       jTable1.getValueAt(row, 10).toString();
        String vencimiento=     jTable1.getValueAt(row, 11).toString();
        
        String codFabrica=      jTable1.getValueAt(row, 12).toString();
        String itbi=            jTable1.getValueAt(row, 13).toString();
        String valorItbis=      jTable1.getValueAt(row, 14).toString();
        String precioVconItbis= jTable1.getValueAt(row, 15).toString();
        
        jTextField1     .setText(cod);
        jTextField2     .setText(pro);
        jTextField3     .setText(det);
        jTextField7     .setText(prov);
        precioCosto     .setText(precioc);
        precioLista     .setText(prec);
        jTextField17    .setText(utilidad);
        precioVenta     .setText(preciov);
        jTextField6     .setText(stc);
        jTextField4     .setText(stoc);
        jTextField5     .setText(ubicacion);
        jTextField9     .setText(vencimiento);
        
        jTextField14     .setText(codFabrica);
        jTextField16     .setText(valorItbis);
        itbis            .setText(itbi);
        jTextField18     .setText(precioVconItbis);
        
      
        JOptionPane.showMessageDialog(this,"Cliente Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
}

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')&&(car<'0' || car>'9')&&(car<'.'||car>'.')) evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyTyped

    private void precioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioVentaKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_precioVentaKeyTyped

    private void precioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioVentaActionPerformed
        calculadora();
    }//GEN-LAST:event_precioVentaActionPerformed

    private void precioVentaInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_precioVentaInputMethodTextChanged
        calculadora();
    }//GEN-LAST:event_precioVentaInputMethodTextChanged

    private void precioListaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioListaKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_precioListaKeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped

     //  char car = evt.getKeyChar();
     //   if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')&&(car<'.'||car>'.')) evt.consume();
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped

        //char car = evt.getKeyChar();
      //  if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_jTextField6KeyTyped

    private void precioCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCostoKeyTyped

        char car = evt.getKeyChar();
        if((car<'0' || car>'9')&&(car<'.'||car>'.')) evt.consume();
    }//GEN-LAST:event_precioCostoKeyTyped

    private void precioCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioCostoActionPerformed

    private void precioCostoCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_precioCostoCaretUpdate

    }//GEN-LAST:event_precioCostoCaretUpdate

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped

    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped

    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
 
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jTextField3.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate

    }//GEN-LAST:event_jTextField1CaretUpdate

    private void precioListaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioListaKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        calculadora();
         itbis.requestFocusInWindow();
       }
    }//GEN-LAST:event_precioListaKeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jTextField7.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
 if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            precioCosto.requestFocusInWindow();
        }       
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jTextField4.requestFocusInWindow();
        }    
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jTextField5.requestFocusInWindow();
        }    
    }//GEN-LAST:event_jTextField4KeyPressed

    private void precioCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCostoKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            jTextField17.requestFocusInWindow();
    }//GEN-LAST:event_precioCostoKeyPressed
    }
    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        enviartable2();
        
        cargarHistorialProductos();
        informacionAdicional();
        guardar();
        cargar();
       
    }//GEN-LAST:event_registrarActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             jTextField9.requestFocusInWindow();
        
        }
    }//GEN-LAST:event_jTextField5KeyPressed

     private void buscarart(){
    String x=jTextField10.getText();
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("CODIGO");
       tabla.addColumn("PRODUCTO");
       tabla.addColumn("DETALE"); 
       tabla.addColumn("PROVEEDOR"); 
       tabla.addColumn("COSTO");
       tabla.addColumn("PRECIO LISTA"); 
       tabla.addColumn("PORCIENTO");
       tabla.addColumn("PRECIO VENTA");           
       tabla.addColumn("STOCK");
       tabla.addColumn("STOCK MINIMO"); 
       tabla.addColumn("UBICACION");
       
       tabla.addColumn  ("CODIGO FABRICA");
       tabla.addColumn  ("ITBIS");
       tabla.addColumn  ("VALOR ITBIS");
       tabla.addColumn  ("PRECIO V.+ITBIS");
       
      
      
         cst=con.prepareCall("{call buscarprodfiltro(?)}");
         cst.setString(1, x);
         r=cst.executeQuery();
         
       while (r.next()){
       Object dato[]=new  Object[16];
       for (int i=0; i<16; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);

       }catch (Exception e){}
 }    
    
    
    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        jTextField10.requestFocusInWindow();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
 
    
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jTextField10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyReleased
     buscarart();  
    }//GEN-LAST:event_jTextField10KeyReleased

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
    if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       jTable1.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       selecion();
       cargarInfoAdi();
       abilitar();
                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(false);
                this.buscar.setEnabled(false);
                this.modificar.setEnabled(true);
                this.eliminar.setEnabled(true);
      jTextField10.setText("");
      jTextField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
 if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       selecion();
       cargarInfoAdi();
       abilitar();
                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(false);
                this.buscar.setEnabled(false);
                this.modificar.setEnabled(true);
                this.eliminar.setEnabled(true);
      jTextField10.setText("");
      jTextField2.requestFocusInWindow();
        }
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  try{
    String rutaInforme= "C:\\Users\\Computech\\Desktop\\Nueva carpeta (4)\\cam\\SistemaVentas\\src\\Reportes\\Listadoproductos.jrxml";
        Reportes re= new Reportes();
        //Map parametros = new HashMap();
        //parametros.put(null,jTextField1.getText());
        re.verReporte6(rutaInforme);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void itbisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itbisKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        calculavalorItbis();
        calculaItbis();  
         jTextField6.requestFocusInWindow();
       }
    }//GEN-LAST:event_itbisKeyPressed

    private void jTextField17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         precioLista.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField17KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         jTextField2.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        enviartable2();
        
        cargarHistorialProductos();
        informacionAdicional();
        guardar();
        cargar();
         }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
 if(evt.getKeyCode() == KeyEvent.VK_ENTER){
       selecion();
       cargarInfoAdi();
       abilitar();
                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(false);
                this.buscar.setEnabled(false);
                this.modificar.setEnabled(true);
                this.eliminar.setEnabled(true);
      jTextField10.setText("");
      jTextField2.requestFocusInWindow();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
       
    }//GEN-LAST:event_jTable1MousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
 if(evt.getClickCount()==1){
       selecion();
       cargarInfoAdi();
       abilitar();
                this.registrar.setEnabled(false);
                this.NuevoCliente.setEnabled(false);
                this.buscar.setEnabled(false);
                this.modificar.setEnabled(true);
                this.eliminar.setEnabled(true);
      jTextField10.setText("");
      jTextField2.requestFocusInWindow();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NuevoCliente;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton eliminar;
    private javax.swing.JTextField itbis;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
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
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField precioCosto;
    private javax.swing.JTextField precioLista;
    private javax.swing.JTextField precioVenta;
    private javax.swing.JButton registrar;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
