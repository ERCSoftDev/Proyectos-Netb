
package CamSyst.Administrador;

import CamSyst.Cliente.Factura;
import CamSyst.Controlador.ClassConection;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class comprobante extends javax.swing.JInternalFrame {

   public static ClassConection conectar=new ClassConection();
   public static CallableStatement cts;
   public static ResultSet r;
   public static Connection cn;
   
   String userName;
   String passWord;
   
    public comprobante(String user, String password) {
        initComponents();
        this.setLocation(380,120);
        
        userName=user;
        passWord=password;
        cn=conectar.conecion(user,password);
        mostrarcomprobantes();
      //  numComprob();
    }
    
    private void SelecionaComprobante01(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("01")){
        numComprob01();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante02(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("02")){
        numComprob02();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante03(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("03")){
        numComprob03();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante04(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("04")){
        numComprob04();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante11(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("11")){
        numComprob11();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante12(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("12")){
        numComprob12();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante13(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("13")){
        numComprob13();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante14(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("14")){
        numComprob14();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    private void SelecionaComprobante15(){
     
        int row=jTable1.getSelectedRow();
        
        if(jTable1.getValueAt (row, 1).equals("15")){
        numComprob15();        
        String descripcion= jTable1.getValueAt (row, 0). toString();
        String tipo=        jTable1.getValueAt (row, 1). toString();
        String etiqueta=    jTable1.getValueAt (row, 2). toString();
        String aviso=       jTable1.getValueAt (row, 3). toString();
        String inicio=      jTable1.getValueAt (row, 4). toString();
        String termina=     jTable1.getValueAt (row, 5). toString();
        String comprobActual=jTable1.getValueAt(row, 6). toString();
        String vencimiento=  jTable1.getValueAt(row, 7). toString();

        
        jTextField1.setText(descripcion);
        jTextField2.setText(tipo);
        jTextField3.setText(etiqueta);
        jTextField4.setText(aviso);
        jTextField5.setText(inicio);
        jTextField6.setText(termina);
        jTextField7.setText(comprobActual);
        jTextField8.setText(vencimiento);
        
         JOptionPane.showMessageDialog(this,"Comprobante Seleccionado!!","Ingrese su nombre",JOptionPane.INFORMATION_MESSAGE);
         //limpiar();
        }  
 }
    
    public static void numComprob01()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante01}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob02()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante01}");
         r=cts.executeQuery();
         if (r.next())
        //Factura.jTextField7.setText(r.getString(1));
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob03()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante03}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob04()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante04}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob11()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante11}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob12()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante12}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob13()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante13}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob14()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante14}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprob15()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante15}");
         r=cts.executeQuery();
         if (r.next())
        jTextField9.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    
    public static void numComprobF01()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante01}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    
    public static void numComprobF03()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante03}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF04()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante04}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF11()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante11}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF12()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante12}");
         r=cts.executeQuery();
         if (r.next())
       Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF13()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante13}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF14()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante14}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    public static void numComprobF15()    {
    
       try{
        
         cts=cn.prepareCall("{call generarComprobante15}");
         r=cts.executeQuery();
         if (r.next())
        Factura.jTextField7.setText(r.getString(1));
           
       }catch (Exception e){} 
}
    
    private void registrarcomprobante(){
    
        String descripcion=  jTextField1.getText();
        String tipo=         jTextField2.getText();
        String etiqueta=     jTextField3.getText();
        String aviso=        jTextField4.getText();
        String inicia=       jTextField5.getText();
        String termina=      jTextField6.getText();
        String comprobActual=jTextField7.getText();
        String vencimiento=  jTextField8.getText();
        
        try{
            cts=cn.prepareCall("{call registracomprobante(?,?,?,?,?,?,?,?)}");
            cts.setString(1, descripcion);
            cts.setString(2, tipo);
            cts.setString(3, etiqueta);
            cts.setString(4, aviso);
            cts.setString(5, inicia);
            cts.setString(6, termina);
            cts.setString(7, comprobActual);
            cts.setString(8, vencimiento);
            
            int opcion=cts.executeUpdate();
            if (opcion==1)
               JOptionPane.showMessageDialog(null, "Comprobante Registrados correctamente!!","aviso",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al registrar comprobante"+e.getMessage());
            limpiar();
        }
        }
    private void mostrarcomprobantes() {
        
       DefaultTableModel tabla= new DefaultTableModel();
       try{
       tabla.addColumn("Descripcion");
       tabla.addColumn("Tipo");
       tabla.addColumn("Etiqueta"); 
       tabla.addColumn("Aviso");
       tabla.addColumn("Inicia");
       tabla.addColumn("Termina");
       tabla.addColumn("ComprobActual");
       tabla.addColumn("Vencimiento");
       
       cts=cn.prepareCall("{call mostrarComprob}");
       r=cts.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[8];
       for (int i=0; i<8; i++){
       dato[i]=r.getString(i+1);
      
}
       tabla.addRow(dato);
       
}
       this.jTable1.setModel(tabla);
       
     
       
       }catch (Exception e){}
 }
    private void modificarComprobante(){

        String descripcion=  jTextField1.getText();
        String tipo=         jTextField2.getText();
        String etiqueta=     jTextField3.getText();
        String aviso=        jTextField4.getText();
        String inicia=       jTextField5.getText();
        String termina=      jTextField6.getText();
        String comprobActual=jTextField7.getText();
        String vencimiento=  jTextField8.getText();
        
        
        try{
            cts=cn.prepareCall("{call editarComprobante(?,?,?,?,?,?,?,?)}");
            cts.setString(1, descripcion);
            cts.setString(2, tipo);
            cts.setString(3, etiqueta);
            cts.setString(4, aviso);
            cts.setString(5, inicia);
            cts.setString(6, termina);
            cts.setString(7, comprobActual);
            cts.setString(8, vencimiento);
            
            int opcion=cts.executeUpdate();
            if (opcion==1)
            JOptionPane.showMessageDialog(null, "Datos modificado correctamente!","aviso",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null,"Error al modificar datos"+e.getMessage());
               limpiar(); 
        }

}
    private void limpiar()             {
     this.jTextField1.setText("");
     this.jTextField2.setText("");
     this.jTextField3.setText("");
     this.jTextField4.setText("");
     this.jTextField5.setText("");
     this.jTextField6.setText("");
     this.jTextField7.setText("");
     this.jTextField8.setText("");   
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comprobantes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Registro de comprobantes");

        jLabel2.setText("Nombre del comprobante:");

        jLabel3.setText("Tipo:");

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Etiqueta:");

        jLabel5.setText("Aviso:");

        jLabel6.setText("Inicia:");

        jLabel7.setText("Termina:");

        jLabel8.setText("Comprobante actual:");

        jLabel9.setText("Fecha vencimiento:");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Habilitar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Descripcion", "Tipo", "Etiqueta", "Inicia", "Termina", "Actual", "Aviso"
            }
        ));
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTable1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(300);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(300);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Listado de comprobantes");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_6_3319634.png"))); // NOI18N

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jLabel12.setText("NCF:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField3)
                                    .addComponent(jTextField7))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel10)
                                .addGap(81, 81, 81)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(71, 71, 71)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    registrarcomprobante();
    mostrarcomprobantes();
    limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
numComprob02();       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      modificarComprobante();
      limpiar();
      mostrarcomprobantes();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
       SelecionaComprobante01() ;
       SelecionaComprobante02() ;
       SelecionaComprobante03() ;
       SelecionaComprobante04() ;
       SelecionaComprobante11() ;
       SelecionaComprobante12() ;
       SelecionaComprobante13() ;
       SelecionaComprobante14() ;
       SelecionaComprobante15() ;
       
    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyTyped
        SelecionaComprobante01() ;
       SelecionaComprobante02() ;
       SelecionaComprobante03() ;
       SelecionaComprobante04() ;
       SelecionaComprobante11() ;
       SelecionaComprobante12() ;
       SelecionaComprobante13() ;
       SelecionaComprobante14() ;
       SelecionaComprobante15() ;
       
    }//GEN-LAST:event_jTable1KeyTyped

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       SelecionaComprobante01() ;
       SelecionaComprobante02() ;
       SelecionaComprobante03() ;
       SelecionaComprobante04() ;
       SelecionaComprobante11() ;
       SelecionaComprobante12() ;
       SelecionaComprobante13() ;
       SelecionaComprobante14() ;
       SelecionaComprobante15() ;
       
       
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

            public void run() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
