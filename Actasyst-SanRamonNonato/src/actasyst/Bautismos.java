
package actasyst;

import java.sql.*;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import Conexion.ClassConection;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.text.SimpleDateFormat;
import javax.swing.ListSelectionModel;


public class Bautismos extends javax.swing.JInternalFrame {

private static final long serialVersionUID = 1L;

ClassConection conectar=new ClassConection();

    Connection con;
    CallableStatement cst;
    ResultSet r;
    ListSelectionModel lsBautismos;
     String userName;
     String passWord;
    
    public Bautismos(String user,String password){
    initComponents();
    userName = user;
    passWord = password;

    jLabel32.setText(""+user);

    con=conectar.conecion(user,password);
    
    cargar();
    Items();
    valorbau();
    mostrarparroquias();
    mostrarcircu();
    //SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
   // SpellChecker.registerDictionaries(null,"C:\\Users\\Computech\\Documents\\NetBeansProjects\\Actasyst-SanRamonNonato\\build");
   // SpellChecker.register(jTextField21);
   // SpellChecker.register(jTextField5);
   // SpellChecker.register(jTextField2);
   // SpellChecker.register(jTextField3);
   // SpellChecker.register(jTextField4);
   // SpellChecker.register(jTextField7);
   // SpellChecker.register(jTextField9);
   // SpellChecker.register(jTextField16);
   // SpellChecker.register(jTextField15);
   // SpellChecker.register(jTextField6);
   // SpellChecker.register(jTextArea1);
    
        Calendar cal=Calendar.getInstance();
        String fecha=cal.get(Calendar.DATE) +"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
        jLabel34.setText(fecha);
        
    try{
    MaskFormatter mascara = new MaskFormatter("##.##");
    JFormattedTextField textField = new JFormattedTextField(mascara);
    textField.setValue(new Float("12.34"));
}
catch ( ParseException | NumberFormatException e){}
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
         
         Bautismos.jComboBox5   .     setSelectedItem(libroasent);
         Bautismos.jTextField23 .     setText(pagina);
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
                
                try{
            cst = con.prepareCall("{call buscarfechas(?)}");  
            cst.setString(1,noacta);
            r = cst.executeQuery();

            if (r.next()) {
                JOptionPane.showMessageDialog(this, "Fechas Agregadas Correctamente!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                abilitar();
                Bautismos.jTextField901 .setText                    (r.getString(6));               
                Bautismos.jTextField900. setText                    (r.getString(9));               
                Bautismos.jTextField902. setText                    (r.getString(25));              

            } else {

                JOptionPane.showMessageDialog(this, "Bautismo No Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    
    }
    private void mostrarparroquias(){
        this.jComboBox4.removeAllItems();
try{

            Statement sent=con.createStatement();
            r=sent.executeQuery("select * from ListaParroquias");
            //r=cst.executeQuery();
            while (r.next()){

            this.jComboBox4.addItem(r.getString("parroquia"));
            }

        }catch (Exception e){}
}     
    private void mostrarcircu(){
        this.jComboBox2.removeAllItems();
try{

            Statement sent=con.createStatement();   
            r=sent.executeQuery("select circu+' '+'CIRCUNS'+' '++oficialia as circunscrip from circunscripciones ");
            while (r.next()){

            this.jComboBox2.addItem(r.getString("circunscrip"));
            
            }

        }catch (Exception e){}
}  
    private void cargas(){
        
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
         cst=con.prepareCall("{call mostrarBautismos}");
       r=cst.executeQuery();
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
    public  void Items(){
        TextAutoCompleter nombreb =  new TextAutoCompleter(jTextField2);
        TextAutoCompleter apellidob = new TextAutoCompleter(jTextField3);
        TextAutoCompleter lugarn =   new TextAutoCompleter(jTextField4);
        TextAutoCompleter nompa =    new TextAutoCompleter(jTextField7);
        TextAutoCompleter nomma =    new TextAutoCompleter(jTextField9);
        TextAutoCompleter padrino =  new TextAutoCompleter(jTextField15);
        TextAutoCompleter madrina =  new TextAutoCompleter(jTextField16);
        TextAutoCompleter rev =      new TextAutoCompleter(jTextField5);
        TextAutoCompleter contma =   new TextAutoCompleter(jTextField6);
        TextAutoCompleter dirparroquia =   new TextAutoCompleter(jTextField21);
 
        try{
           cst=con.prepareCall("select  distinct nombreb from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           nombreb.addItem(r.getString("nombreb"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct apellidob from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           apellidob.addItem(r.getString("apellidob"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct lugarn from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           lugarn.addItem(r.getString("lugarn"));
        }catch (Exception e){}
        
        try{
            cst=con.prepareCall("select distinct nompa from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           nompa.addItem(r.getString("nompa"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct nomma from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           nomma.addItem(r.getString("nomma"));
        }catch (Exception e){}
        
        try{
            cst=con.prepareCall("select distinct padrino from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           padrino.addItem(r.getString("padrino"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct madrina from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           madrina.addItem(r.getString("madrina"));
        }catch (Exception e){}
        
        try{
            cst=con.prepareCall("select distinct rev from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           rev.addItem(r.getString("rev"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct contma from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           contma.addItem(r.getString("contma"));
        }catch (Exception e){}
        
        try{
           cst=con.prepareCall("select distinct dirparroquia from Bautismos");
           r=cst.executeQuery();
           while (r.next())
           dirparroquia.addItem(r.getString("dirparroquia"));
           
           
        }catch (Exception e){}
        
    } //AUTO COMPLETAR CAMPOS DESDE SQL
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
       
           
       cst=con.prepareCall("{call mostrarBautismos}");
       r=cst.executeQuery();
       while (r.next()){
       Object dato[]=new  Object[26];
       for (int i=0; i<26; i++){
       dato[i]=r.getString(i+1);

       }
       tabla.addRow(dato);
       }
       this.jTable1.setModel(tabla);
       jLabel31.setText(""+jTable1.getRowCount());

       }catch (Exception e){}
desabilitar();
           Bautismos.jButton1.setEnabled(false);
           Bautismos.jButton2.setEnabled(true);
           Bautismos.jButton3.setEnabled(true);
//           this.modificar.setEnabled(false);
           Bautismos.jButton5.setEnabled(false);
           Bautismos.jButton8.setEnabled(true);
           Bautismos.jButton9.setEnabled(false);
           Bautismos.jButton10.setEnabled(true);
              }  //CREAR TABLA DINAMICA
    public  void abilitar (){
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
    public  void desabilitar(){
           Bautismos.jTextField1.setEnabled(false);
           Bautismos.jTextField2.setEnabled(false);
           Bautismos.jTextField3.setEnabled(false); 
           Bautismos.jTextField7.setEnabled(false);
           Bautismos.jTextField5.setEnabled(false);
           Bautismos.jTextField8.setEnabled(false);
           Bautismos.jComboBox1.setEnabled(false);
           Bautismos.jComboBox2.setEnabled(false);
           Bautismos.jTextField9.setEnabled(false);
           Bautismos.jTextField10.setEnabled(false);
           Bautismos.jTextField13.setEnabled(false);
           Bautismos.jTextField902.setEnabled(false);
           Bautismos.jTextField12.setEnabled(false);
           Bautismos.jComboBox3.setEnabled(false);
           Bautismos.jTextField23.setEnabled(false);
           Bautismos.jTextField4.setEnabled(false);
           Bautismos.jTextField16.setEnabled(false);
           Bautismos.jTextField15.setEnabled(false);
           Bautismos.jTextField14.setEnabled(false);
           Bautismos.jComboBox5.setEnabled(false);
           Bautismos.jTextField6.setEnabled(false);
           Bautismos.jComboBox4.setEnabled(false);
           Bautismos.jTextField21.setEnabled(false);
           Bautismos.jTextArea1.setEnabled(false);
           Bautismos.jTextField901.setEnabled(false);
           Bautismos.jTextField900.setEnabled(false);
           //Bautismos.jTextField11.setEnabled(false);

                          }
    public  void limpiar(){
           Bautismos.jTextField1.setText("");
           Bautismos.jTextField2.setText("");
           Bautismos.jTextField3.setText(""); 
           Bautismos.jTextField7.setText("");
           Bautismos.jTextField5.setText("");
           Bautismos.jTextField4.setText("");
           Bautismos.jTextField8.setText(""); 
           Bautismos.jTextField9.setText("");
           Bautismos.jTextField10.setText("");
           Bautismos.jTextField15.setText("");
           Bautismos.jTextField16.setText(""); 
           Bautismos.jTextField14.setText("");
           Bautismos.jTextField12.setText("");
           Bautismos.jComboBox5.setSelectedIndex(0);
           Bautismos.jTextField23.setText(""); 
           Bautismos.jTextField6.setText("");
           Bautismos.jComboBox4.setSelectedIndex(0);
           Bautismos.jTextField21.setText("");
           Bautismos.jTextField13.setText("");
           Bautismos.jTextArea1.setText("");
           Bautismos.jTextField901.setText("");
           Bautismos.jTextField900.setText("");
           Bautismos.jTextField902.setText("");
           Bautismos.jComboBox1.setSelectedIndex(0);
           Bautismos.jComboBox2.setSelectedIndex(0);
           Bautismos.jComboBox3.setSelectedIndex(0);
           //this.jTextField6.setText("");//esto sirve para limpiar los campos..
           
} 
    public void validarcampos(){
           if(jTextField1.getText().length()==0){
    JOptionPane.showMessageDialog(this, "EL NUMERO DE ACTA NO PUEDE ESTAR EN BLANCO");
    jTextField1.requestFocusInWindow();
    }else
       if(jTextField23.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR LA PAGINA DEL LIBRO");
    jTextField23.requestFocusInWindow();
    }else
       if(jTextField21.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR LA DIRECCION DE LA PARROQUIA");
    jTextField21.requestFocusInWindow();        
    }else
       if(jTextField5.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR NOMBRE DEL PARROCO");
    jTextField5.requestFocusInWindow();
       }else
       if(jTextField2.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR NOMBRE DEL BAUTIZADO/A");
    jTextField2.requestFocusInWindow();
       }else
       if(jTextField3.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR APELLIDO DEL BAUTIZADO/A");
    jTextField3.requestFocusInWindow();
       }else
       if(jTextField900.getText().equals("  -  -    ")){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR LA FECHA DEL BAUTISMO");
    jTextField900.requestFocusInWindow();
       }else
       if(jTextField4.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL LUGAR DE NACIMIENTO");
    jTextField4.requestFocusInWindow();
       }else
       if(jTextField901.getText().equals("  -  -    ")){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR LA FECHA DE NACIMIENTO");
    jTextField901.requestFocusInWindow();
       }else
       if(jTextField7.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL NOMBRE DEL PADRE");
    jTextField7.requestFocusInWindow();
       }else
       if(jTextField9.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL NOMBRE DE LA MADRE");
    jTextField9.requestFocusInWindow();
       }else
       if(jTextField14.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL No. DE REGISTRO");
    jTextField14.requestFocusInWindow();
       }else
       if(jTextField12.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL FOLIO");
    jTextField12.requestFocusInWindow();
       }else
       if(jTextField13.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL No. DE DECLARACION ");
    jTextField13.requestFocusInWindow();
       }else
       if(jTextField15.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL NOMBRE DEL PADRINO");
    jTextField15.requestFocusInWindow();
       }else
       if(jTextField16.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR EL NOMBRE DE LA MADRINA");
    jTextField16.requestFocusInWindow();
       }else
       if(jTextField6.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESPECIFICAR SI CONTROJO MATRIMONIO O NO");
    jTextField6.requestFocusInWindow();
       }else
       if(jTextField902.getText().equals("  -  -    ")){
    JOptionPane.showMessageDialog(this, "DEBE ESCRIBIR LA FECHA DE HOY");
    jTextField902.requestFocusInWindow();
       }else
       if(jTextArea1.getText().length()==0){
    JOptionPane.showMessageDialog(this, "DEBE ESPECIFICAR SI HAY ALGUNA NOTA, DE NO HABER ESCRIBIR 'NO'");
    jTextArea1.requestFocusInWindow();
       }
       
       
       
       else
           guardarregistro();
    } 
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
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
        jTextField7 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jComboBox2 = new javax.swing.JComboBox<String>();
        jComboBox3 = new javax.swing.JComboBox<String>();
        jComboBox4 = new javax.swing.JComboBox<String>();
        jComboBox5 = new javax.swing.JComboBox<String>();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField8 = new javax.swing.JFormattedTextField();
        jTextField10 = new javax.swing.JFormattedTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jTextField901 = new javax.swing.JFormattedTextField();
        jTextField900 = new javax.swing.JFormattedTextField();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        jTextField902 = new javax.swing.JFormattedTextField();
        label4 = new java.awt.Label();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        label1 = new java.awt.Label();

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1476487247_InterfaceExpendet-01.png"))); // NOI18N
        jMenuItem1.setText("Actualizar Registros");
        jMenuItem1.setToolTipText("Actualiza y Organiza los registros");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jMenuItem5.setText("Editar Registro");
        jMenuItem5.setToolTipText("enviar registro al formulario principal para editarlo");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("REGISTRO DE BAUTISMOS");
        setAutoscrolls(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTabbedPane1, org.jdesktop.beansbinding.ELProperty.create("${resizable}"), this, org.jdesktop.beansbinding.BeanProperty.create("resizable"));
        bindingGroup.addBinding(binding);

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jTabbedPane1.setEnabled(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setAutoscrolls(true);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jPanel4, org.jdesktop.beansbinding.ELProperty.create("${preferredSize}"), jPanel4, org.jdesktop.beansbinding.BeanProperty.create("preferredSize"));
        bindingGroup.addBinding(binding);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.setEnabled(false);
        jTextField1.setFocusAccelerator('*');
        jTextField1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                jTextField1CaretUpdate(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jLabel1.setText("No.Acta");

        jLabel2.setText("Nombre del Bautizado/a:");

        jLabel3.setText("Apellido del Bautizado/a:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });

        jLabel4.setText("Nombre Padre:");

        jLabel5.setText("Bautizado por Rev.Parroco:");

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField7KeyTyped(evt);
            }
        });

        jLabel7.setText("Fecha del Bautismo:");

        jLabel8.setText("Fecha Nacimiento:");

        jLabel12.setText("Lugar Nacimiento:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel16.setText("Sexo:");

        jLabel17.setText("Cedula:");

        jLabel18.setText("Nombre Madre:");

        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });

        jLabel19.setText("Reg.Nacimiento:");

        jLabel20.setText("Cedula:");

        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(102, 102, 255));
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(102, 102, 255));
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });

        jLabel21.setText("Folio:");

        jLabel22.setText("No.");

        jLabel23.setText("Declara.No.:");

        jLabel24.setText("Año:");

        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(102, 102, 255));
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField14KeyTyped(evt);
            }
        });

        jLabel25.setText("Circunscripcion Estado Civil:");

        jLabel26.setText("Padrino: ");

        jLabel27.setText("Madrina");

        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField15KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });

        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField16KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField16KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField16KeyTyped(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 51, 0)), "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(153, 51, 0))); // NOI18N
        jPanel5.setToolTipText("Barra de opciones");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454378002_Add-Male-User.png"))); // NOI18N
        jButton2.setToolTipText("Nuevo registro");
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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454378026_delete.png"))); // NOI18N
        jButton5.setToolTipText("Eliminar registro");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/16 (Save).jpg"))); // NOI18N
        jButton1.setToolTipText("guardar registro");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546591_database.png"))); // NOI18N
        jButton3.setToolTipText("Buscar especifica de registro");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546632_Print.png"))); // NOI18N
        jButton9.setToolTipText("Imprimir registro");
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jButton9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton9KeyTyped(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1452221026_101.png"))); // NOI18N
        jButton10.setToolTipText("Cancelar operacion");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1454377420_EditDocument.png"))); // NOI18N
        jButton8.setToolTipText("Modificar registro");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451536580_Icon_Element_Water_01.png"))); // NOI18N
        jButton6.setToolTipText("Busqueda Avanzada");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 0, 0));
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1476487914_sign-emergency-code-sos_61.png"))); // NOI18N
        jButton12.setToolTipText("Salir del esta ventana");
        jButton12.setBorderPainted(false);
        jButton12.setContentAreaFilled(false);
        jButton12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(jButton12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });

        jLabel9.setText("Direccion Parroquia:");

        jLabel10.setText("En la parroquia:");

        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField21KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Libro Asentamiento:");

        jLabel14.setText("Pagina del libro:");

        jTextField23.setBackground(new java.awt.Color(102, 102, 255));
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(51, 51, 51));
        jTextField23.setSelectedTextColor(new java.awt.Color(51, 51, 51));
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField23KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField23KeyTyped(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MASCULINO", "FEMENINO" }));
        jComboBox1.setToolTipText("");
        jComboBox1.setComponentPopupMenu(jPopupMenu1);
        jComboBox1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox1KeyPressed(evt);
            }
        });

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });

        jComboBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(102, 102, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "3034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045", "2046", "2047", "2048", "2049", "2050", "2051", "2052", "2053", "2054", "2055", "2056", "2057", "2058", "2059", "2060", "2061", "2062", "2063", "2064", "2065", "2066", "2067", "2068", "2069", "2070", "2071", "2072", "2073", "2074", "2075", "2076", "2077", "2078", "2079", "2080", "2081", "2082", "2083", "2084", "2085", "2086", "2087", "2088", "2089", "2090", "2091", "2092", "2093", "2094", "2095", "2096", "2097", "2098", "2099", "2100" }));
        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });

        jComboBox4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(102, 102, 255));
        jComboBox4.setAutoscrolls(true);
        jComboBox4.setName("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); // NOI18N
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox4MouseClicked(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });
        jComboBox4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox4KeyPressed(evt);
            }
        });

        jComboBox5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25" }));
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
        });
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jLabel6.setText("Contrajo Matrimonio con:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField6KeyTyped(evt);
            }
        });

        jLabel11.setText("Fecha Reg.Bautismo:");

        jLabel15.setText("Otras notas:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        try {
            jTextField8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });

        try {
            jTextField10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 255));
        jLabel29.setText("Digitador:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("jLabel32");

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/A.png"))); // NOI18N
        jButton11.setToolTipText("Informacion acerca de ActaSyst");
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jTextField901.setBackground(new java.awt.Color(102, 102, 255));
        jTextField901.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTextField901.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField901.setToolTipText("fecha de nacimiento ");
        jTextField901.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField901.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField901KeyPressed(evt);
            }
        });

        jTextField900.setBackground(new java.awt.Color(102, 102, 255));
        jTextField900.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTextField900.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField900.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField900.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField900KeyPressed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        label2.setText("Dia/Mes/Año");

        label3.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        label3.setText("Dia/Mes/Año");

        jTextField902.setBackground(new java.awt.Color(102, 102, 255));
        jTextField902.setForeground(new java.awt.Color(51, 51, 51));
        try {
            jTextField902.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextField902.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField902.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField902ActionPerformed(evt);
            }
        });
        jTextField902.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField902KeyPressed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        label4.setText("Dia/Mes/Año");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Fecha:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 255));
        jLabel34.setText("jLabel34");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Precio:");

        jTextField11.setEditable(false);

        jLabel36.setText("$");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_plus-sign_173078.png"))); // NOI18N
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_plus-sign_173078.png"))); // NOI18N
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(36, 36, 36)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25))
                        .addGap(210, 210, 210)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel22)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(23, 23, 23)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel3))
                                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel7)))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jTextField900, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(239, 239, 239))
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel21)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel23)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(jLabel24)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jComboBox3, 0, 54, Short.MAX_VALUE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel17))
                                                        .addGap(21, 21, 21)
                                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                                            .addComponent(jTextField10)))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jTextField901, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jLabel11)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jTextField902, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(25, 25, 25)
                                                    .addComponent(jLabel27)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                            .addComponent(jLabel18)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel35))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jTextField900, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(17, 17, 17))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField901, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField902, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Registro de Bautismos", jPanel2);

        jScrollPane4.setAutoscrolls(true);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "01", "02", "03", "04", "05", "06", "Title 7", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19"
            }
        ));
        jTable1.setComponentPopupMenu(jPopupMenu1);
        jTable1.setFocusTraversalPolicyProvider(true);
        jTable1.setInheritsPopupMenu(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jTable1.setShowHorizontalLines(false);
        jTable1.setSurrendersFocusOnKeystroke(true);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jScrollPane4.setViewportView(jScrollPane1);

        jLabel28.setText("jLabel28");

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel28, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Cantidad Actas Registradas:");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 204, 51));
        jLabel31.setText("jLabel31");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546591_database.png"))); // NOI18N
        jButton4.setToolTipText("Busque de Bautismo");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        label1.setText("Busqueda Avanzada");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 519, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jLabel31)))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Listado de Bautismo", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1079, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        setBounds(0, 0, 1115, 600);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      cargar();   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jTextField6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyTyped
     char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();     
       }    
    }//GEN-LAST:event_jTextField6KeyTyped

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
       String x=jComboBox5.getSelectedItem().toString();
        try{
            if(jComboBox5.getSelectedItem().equals("1")){
            cst=con.prepareCall("{call Genera_num_Bautismo(?)}");
            cst.setString(1, x);
            r=cst.executeQuery();
            if (r.next())
            jTextField1.setText(r.getString(1));
             }else
                 if(jComboBox5.getSelectedItem().equals("2")){
                 cst=con.prepareCall("{call Genera_num_Bautismo2(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("3")){
                 cst=con.prepareCall("{call Genera_num_Bautismo3(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("4")){
                 cst=con.prepareCall("{call Genera_num_Bautismo4(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("5")){
                 cst=con.prepareCall("{call Genera_num_Bautismo5(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("6")){
                 cst=con.prepareCall("{call Genera_num_Bautismo6(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("7")){
                 cst=con.prepareCall("{call Genera_num_Bautismo7(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("8")){
                 cst=con.prepareCall("{call Genera_num_Bautismo8(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("9")){
                 cst=con.prepareCall("{call Genera_num_Bautismo9(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("10")){
                 cst=con.prepareCall("{call Genera_num_Bautismo10(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("11")){
                 cst=con.prepareCall("{call Genera_num_Bautismo11(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("12")){
                 cst=con.prepareCall("{call Genera_num_Bautismo12(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("13")){
                 cst=con.prepareCall("{call Genera_num_Bautismo13(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("14")){
                 cst=con.prepareCall("{call Genera_num_Bautismo14(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("15")){
                 cst=con.prepareCall("{call Genera_num_Bautismo15(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("16")){
                 cst=con.prepareCall("{call Genera_num_Bautismo16(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("17")){
                 cst=con.prepareCall("{call Genera_num_Bautismo17(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("18")){
                 cst=con.prepareCall("{call Genera_num_Bautismo18(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("19")){
                 cst=con.prepareCall("{call Genera_num_Bautismo19(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("20")){
                 cst=con.prepareCall("{call Genera_num_Bautismo20(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("21")){
                 cst=con.prepareCall("{call Genera_num_Bautismo21(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("22")){
                 cst=con.prepareCall("{call Genera_num_Bautismo22(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("23")){
                 cst=con.prepareCall("{call Genera_num_Bautismo23(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("24")){
                 cst=con.prepareCall("{call Genera_num_Bautismo24(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("25")){
                 cst=con.prepareCall("{call Genera_num_Bautismo25(?)}");
                 cst.setString(1, x);
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }
        }catch (Exception e){}
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
     
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField23KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyTyped
        int cantCaracteres=4;
        if (jTextField23.getText().length()>=cantCaracteres){
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "EL LIBRO NO CONTIENE MAS DE "+cantCaracteres+" CIFRAS");

        }
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')){
          
        evt.consume();// TODO add your handling code here:
    }//GEN-LAST:event_jTextField23KeyTyped
  }
    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
       char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();    
       }    
    }//GEN-LAST:event_jTextField5KeyTyped
    
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        limpiar();
        cargar();
        Bautismos.jTextField1.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    @SuppressWarnings("unchecked")
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(this.jTextField1.getText().length()>0){
        ingresarRegistroContable();
        }
        desabilitar();
        String rutaInforme= "C:\\Users\\Computech\\Documents\\NetBeansProjects\\Actasyst-SanRamonNonato\\src\\Reportes\\Bautismos.jrxml";                     
        Reportes re= new Reportes();
        Map parametros = new HashMap();
        parametros.put("noacta",Bautismos.jTextField1.getText());
        limpiar();
        re.verReporte(rutaInforme, parametros);
        try{
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
int opcion=JOptionPane.showConfirmDialog(null,"SEGURO QUE DESEA MODIFICAR ESTE BAUTISMO?","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
        String fechanaci = jTextField901.getText();
        String fechab =jTextField900.getText();
        String fecharegb = jTextField902.getText();
        String noacta =    jTextField1. getText(), nombreb = jTextField2.getText();
        String apellidob = jTextField3. getText(), lugarn =  jTextField4.getText();
        String nompa =    jTextField7. getText(), cedpa =    jTextField8.getText();
        String nomma =     jTextField9. getText();
        String cedma =     jTextField10.getText(), padrino = jTextField15.getText();
        String madrina =   jTextField16.getText(), regno =   jTextField14.getText();
        String folio =     jTextField12.getText(), declano = jTextField13.getText();
        String rev =     jTextField5. getText();
        String libroasent =jComboBox5.getSelectedItem().toString(), pagina =     jTextField23. getText();
        String contma =jTextField6.getText(), nomparroquia =     jComboBox4.getSelectedItem().toString();
        String dirparroquia =jTextField21.getText(), otros =     jTextArea1. getText();
        String sexo= jComboBox1.getSelectedItem().toString();
        String circu= jComboBox2.getSelectedItem().toString();
        String año = jComboBox3.getSelectedItem().toString();

        try {
            cst = con.prepareCall("{call modificarBautismos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //modificarBautismos
            cst.setString(1, noacta);
            cst.setString(2, libroasent);
            cst.setString(3, pagina);
            cst.setString(4, nombreb);
            cst.setString(5, apellidob);
            cst.setString(6, fechanaci);
            cst.setString(7, lugarn);
            cst.setString(8, sexo);
            cst.setString(9, fechab);
            cst.setString(10, nompa);
            cst.setString(11, cedpa);
            cst.setString(12, nomma);
            cst.setString(13, cedma);
            cst.setString(14, padrino);
            cst.setString(15, madrina);
            cst.setString(16, regno);
            cst.setString(17, folio);
            cst.setString(18, declano);
            cst.setString(19, año);
            cst.setString(20, circu);
            cst.setString(21, rev);
            cst.setString(22, contma);
            cst.setString(23, nomparroquia);
            cst.setString(24, dirparroquia);
            cst.setString(25, fecharegb);
            cst.setString(26, otros);

            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Bautismo Modificado Exitosamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                desabilitar();
                Bautismos.jButton1.setEnabled(true);
                Bautismos.jButton2.setEnabled(false);
                Bautismos.jButton3.setEnabled(false);
                //this.modificar.setEnabled(false);
                Bautismos.jButton5.setEnabled(false);
                Bautismos.jButton8.setEnabled(true);
                Bautismos.jButton9.setEnabled(false);
                Bautismos.jButton10.setEnabled(true);
            } else {

                JOptionPane.showMessageDialog(this, "Error al modificar", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
       } // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String x=jComboBox5.getSelectedItem().toString();
        try{
            if(jComboBox5.getSelectedItem().equals("1")){
            cst=con.prepareCall("{call Genera_num_Bautismo(?)}");
            cst.setString(1, x);
            r=cst.executeQuery();
            if (r.next())
            jTextField1.setText(r.getString(1)); 
          }
        }catch (Exception e){}
        abilitar();
        Bautismos.jButton1.setEnabled(true);
        Bautismos.jButton2.setEnabled(false);
        Bautismos.jButton3.setEnabled(false);
//        this.modificar.setEnabled(false);
        Bautismos.jButton5.setEnabled(false);
        Bautismos.jButton8.setEnabled(false);
        Bautismos.jButton9.setEnabled(false);
        Bautismos.jButton10.setEnabled(true);
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
int opcion=JOptionPane.showConfirmDialog(null,"SEGURO QUE DESEA ELIMINAR ESTE BAUTISMO?","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
        String cod = Bautismos.jTextField1.getText();
        try {
            cst = con.prepareCall("{call eliminarbautismos(?)}");
            cst.setString(1, cod);
            int rpta = cst.executeUpdate();

            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Bautismo Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                Bautismos.jButton1.setEnabled(false);
                Bautismos.jButton2.setEnabled(true);
                Bautismos.jButton3.setEnabled(true);
//                this.modificar.setEnabled(false);
                Bautismos.jButton5.setEnabled(false);
                Bautismos.jButton8.setEnabled(false);
                Bautismos.jButton9.setEnabled(false);
                Bautismos.jButton10.setEnabled(true);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Bautismo No Eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }}
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String noacta = JOptionPane.showInputDialog("INGRESE EL NO. DE ACTA DEL BAUTISADO A BUSCAR PARA MODIFICAR");
        try {
            cst = con.prepareCall("{call buscarbautismos(?)}");
            cst.setString(1, noacta);
            r = cst.executeQuery();

            if (r.next()) {
                JOptionPane.showMessageDialog(this, "Busqueda Exitosa!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                abilitar();
                Bautismos.jTextField1.setText        (r.getString(1));
                Bautismos.jTextField23.setText       (r.getString(3));
                Bautismos.jTextField2.setText        (r.getString(4));
                Bautismos.jTextField3.setText        (r.getString(5));
                Bautismos.jTextField901.setText                     (r.getString(6));
                Bautismos.jTextField4.setText        (r.getString(7));
                Bautismos.jComboBox1.setSelectedItem (r.getString(8));
                Bautismos.jTextField900.setText                    (r.getString(9));
                Bautismos.jTextField7.setText        (r.getString(10));
                Bautismos.jTextField8.setText        (r.getString(11));
                Bautismos.jTextField9.setText        (r.getString(12));
                Bautismos.jTextField10.setText       (r.getString(13));
                Bautismos.jTextField15.setText       (r.getString(14));
                Bautismos.jTextField16.setText       (r.getString(15));
                Bautismos.jTextField14.setText       (r.getString(16));
                Bautismos.jTextField12.setText       (r.getString(17));
                Bautismos.jTextField13.setText       (r.getString(18));
                Bautismos.jComboBox3.setSelectedItem (r.getString(19));
                //this.jComboBox2.setSelectedItem (r.getString(20));
                Bautismos.jTextField5.setText        (r.getString(21));
                Bautismos.jTextField6.setText        (r.getString(22));
                Bautismos.jTextField21.setText       (r.getString(24));
                Bautismos.jTextField902.setText                    (r.getString(25));
                Bautismos.jTextArea1.setText         (r.getString(26));

                Bautismos.jButton1.setEnabled(false);
                Bautismos.jButton2.setEnabled(false);
                Bautismos.jButton3.setEnabled(false);
//                this.modificar.setEnabled(true);
                Bautismos.jButton5.setEnabled(true);
                Bautismos.jButton8.setEnabled(true);
                Bautismos.jButton9.setEnabled(true);
                Bautismos.jButton10.setEnabled(true);

            } else {

                JOptionPane.showMessageDialog(this, "Bautismo No Encontrado!!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void ingresarRegistroContable(){

        String noacta =    jTextField1.  getText();
        String libroasent =jComboBox5.   getSelectedItem().toString();
        String pagina =    jTextField23. getText();
        String nombreb =   jTextField2.  getText();
        String apellidob = jTextField3.  getText();
        String fecha =     jLabel34.     getText();
        String valorbau =  jTextField11.  getText();

        try {
            cst = con.prepareCall("{call registrarcuadrediario(?,?,?,?,?,?,?)}");
            cst.setString(1, noacta);
            cst.setString(2, libroasent);
            cst.setString(3, pagina);
            cst.setString(4, nombreb);
            cst.setString(5, apellidob);
            cst.setString(6, fecha);
            cst.setString(7, valorbau);
      

            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Datos enviados al cuadre correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
        }
    }      
    
    public void guardarregistro(){
    String fechanaci =jTextField901.getText();
        String fechab = jTextField900.getText();
        String fecharegb = jTextField902.getText();
        String noacta =    jTextField1. getText(), nombreb = jTextField2.getText();
        String apellidob = jTextField3. getText(), lugarn =  jTextField4.getText();
        String nompa =    jTextField7. getText(), cedpa =    jTextField8.getText();
        String nomma =     jTextField9. getText();
        String cedma =     jTextField10.getText(), padrino = jTextField15.getText();
        String madrina =   jTextField16.getText(), regno =   jTextField14.getText();
        String folio =     jTextField12.getText(), declano = jTextField13.getText();
        String rev =     jTextField5. getText();
        String libroasent =jComboBox5.getSelectedItem().toString(), pagina =     jTextField23. getText();
        String contma =jTextField6.getText(), nomparroquia =     jComboBox4.getSelectedItem().toString();
        String dirparroquia =jTextField21.getText(), otros =     jTextArea1. getText();
        String sexo=jComboBox1.getSelectedItem().toString();
        String circu=jComboBox2.getSelectedItem().toString();
        String año = jComboBox3.getSelectedItem().toString();

        try {
              
            cst = con.prepareCall("{call registrarBautismos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cst.setString(1, noacta);
            cst.setString(2, libroasent);
            cst.setString(3, pagina);
            cst.setString(4, nombreb);
            cst.setString(5, apellidob);
            cst.setString(6, fechanaci);
            cst.setString(7, lugarn);
            cst.setString(8, sexo);
            cst.setString(9, fechab);
            cst.setString(10, nompa);
            cst.setString(11, cedpa);
            cst.setString(12, nomma);
            cst.setString(13, cedma);
            cst.setString(14, padrino);
            cst.setString(15, madrina);
            cst.setString(16, regno);
            cst.setString(17, folio);
            cst.setString(18, declano);
            cst.setString(19, año);
            cst.setString(20, circu);
            cst.setString(21, rev);
            cst.setString(22, contma);
            cst.setString(23, nomparroquia);
            cst.setString(24, dirparroquia);
            cst.setString(25, fecharegb);
            cst.setString(26, otros);

            int rpta = cst.executeUpdate();
            if (rpta == 1) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }   
            limpiar();
            desabilitar();
            Bautismos.jButton1.setEnabled(false);
            Bautismos.jButton2.setEnabled(true);
            Bautismos.jButton3.setEnabled(true);
            Bautismos.jButton5.setEnabled(false);
            Bautismos.jButton8.setEnabled(false);
            Bautismos.jButton9.setEnabled(false);
            Bautismos.jButton10.setEnabled(true);

        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage() );
        }
    }   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    validarcampos();       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField16KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyTyped
char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
         
    }    
    }//GEN-LAST:event_jTextField16KeyTyped

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
        
    }    
    }//GEN-LAST:event_jTextField15KeyTyped

    private void jTextField14KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')){
        
        evt.consume();
    }//GEN-LAST:event_jTextField14KeyTyped
    }
    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
   char car = evt.getKeyChar();
        if((car<'0' || car>'9')){
        
        evt.consume();
    }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
          char car = evt.getKeyChar();
        if((car<'0' || car>'9')){
        
        evt.consume();
    }
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
        
    }    
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyTyped
     char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
    }                 
    }//GEN-LAST:event_jTextField7KeyTyped

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed

    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
       char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
         
    }                 
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
         char car = evt.getKeyChar();
         if((car<'a' || car>'z') && (car<'A' || car>'Z')&&(car<' '||car>' ')){
         evt.consume();
   
    }                 
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
 
    }//GEN-LAST:event_jTextField1ActionPerformed
  
    private void jTextField1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_jTextField1CaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1CaretUpdate

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        int cantCaracteres=1;
        if (jTextField1.getText().length()>=cantCaracteres){ 
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "LO SENTIMOS, POR MOTIVO DE SEGURIDAD ESTE CODIGO NO PUEDE SER MODIFICADO"
                    + " (WARNING)(!)");
    }//GEN-LAST:event_jTextField1KeyTyped
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
     // jPopupMenu1.show(this,evt.getX(),evt.getY());  
    }//GEN-LAST:event_jTable1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
      // jPopupMenu1.show(this,evt.getX(),evt.getY());  
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
     SelecionaBautismo();
     abilitar ();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        ConsultaBautismos cb; 
        cb= new ConsultaBautismos(this.userName,this.passWord);
        ActaS.jDesktopPane1.add(cb);
        cb.toFront();
        cb.setLocation(50,10);
        cb.setVisible(true);      
         
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(userName.equals("Secretaria")){
        ConsultaBautismos cb; cb= new ConsultaBautismos(this.userName,this.passWord);
        ActaSSecre.jDesktopPane1.add(cb);
        cb.toFront();
        cb.setLocation(50,10);
        cb.setVisible(true); 
        ConsultaBautismos.jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton6ActionPerformed
        else 
            if(userName.equals("Administrador")){
        ConsultaBautismos cb; cb= new ConsultaBautismos(this.userName,this.passWord);
        ActaS.jDesktopPane1.add(cb);
        cb.toFront();
        cb.setLocation(50,10);
        cb.setVisible(true); 
        ConsultaBautismos.jTextField1.requestFocusInWindow();
    }                                        
    }
    
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       int opcion=JOptionPane.showConfirmDialog(null,"REALMENTE DESEA SALIR","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            dispose();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       try{
        Creador p=new Creador(this.userName,this.passWord);
       jDesktopPane1.add(p);
       p.show();
        //p.setLocation(50, 5);
    }catch(Exception e){}
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jComboBox4.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField23KeyPressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
       jTextField23.requestFocusInWindow();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        parroquias c; 
        c= new parroquias(this.userName,this.passWord);
        ActaS.jDesktopPane1.add(c);
        c.toFront();
        c.setLocation(50,10);
        c.setVisible(true); 
        //parroquias.jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
     //  parroquias cb; 
      //  cb= new parroquias(this.userName,this.passWord);
      //  ActaS.jDesktopPane1.add(cb);
      //  cb.toFront();
      //  cb.setLocation(50,10);
      //  cb.setVisible(true); 
      //  parroquias.jTextField1.requestFocusInWindow();
    }//GEN-LAST:event_jButton7MouseClicked

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jComboBox4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField21.requestFocusInWindow();
       }
    }//GEN-LAST:event_jComboBox4KeyPressed

    private void jTextField21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){    
     jTextField900.requestFocusInWindow();
      }                        
    }//GEN-LAST:event_jTextField21KeyPressed

    private void jTextField900KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField900KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField5.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField900KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            
      jTextField3.requestFocusInWindow();
       }else
            if(evt.getKeyCode() == KeyEvent.VK_SPACE){
            String t=jTextField21.getText();
       // if(t.length()>0){
        char pl=t.charAt(1);
        t=Character.toUpperCase(pl)+t.substring(1,t.length());
        jTextField21.setText(t);
        //}
    }//GEN-LAST:event_jTextField2KeyPressed
    }
    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jComboBox1.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jComboBox1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox1KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         jTextField4.requestFocusInWindow();
       }
    }//GEN-LAST:event_jComboBox1KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField901.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField901KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField901KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField7.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField901KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField8.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField9.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField10.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField14.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField12.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField13.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jComboBox3.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jComboBox2.requestFocusInWindow();
       }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField15.requestFocusInWindow();
       }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField16.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField15KeyPressed

    private void jTextField16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField6.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField16KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField902.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField902KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField902KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextArea1.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField902KeyPressed

    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
     jButton1.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextArea1KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
      if(evt.getKeyCode() == KeyEvent.VK_ENTER){
      jTextField2.requestFocusInWindow();
       }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Circunscripcion c; 
        c= new Circunscripcion(this.userName,this.passWord);
        ActaS.jDesktopPane1.add(c);
        c.toFront();
        c.setLocation(50,10);
        c.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jComboBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseClicked
       mostrarparroquias();
    }//GEN-LAST:event_jComboBox4MouseClicked

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped

   
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jButton9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton9KeyTyped
        
        
        
    }//GEN-LAST:event_jButton9KeyTyped

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox4ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        mostrarcircu();
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
       jTextField5.setText(jTextField5.getText().toUpperCase());
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        jTextField2.setText(jTextField2.getText().toUpperCase());
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        jTextField3.setText(jTextField3.getText().toUpperCase());
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        jTextField7.setText(jTextField7.getText().toUpperCase());
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        jTextField9.setText(jTextField9.getText().toUpperCase());
    }//GEN-LAST:event_jTextField9KeyReleased

    private void jTextField15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyReleased
        jTextField15.setText(jTextField15.getText().toUpperCase());
    }//GEN-LAST:event_jTextField15KeyReleased

    private void jTextField16KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyReleased
        jTextField16.setText(jTextField16.getText().toUpperCase());
    }//GEN-LAST:event_jTextField16KeyReleased

    private void jTextField21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyReleased
        jTextField21.setText(jTextField21.getText().toUpperCase());
    }//GEN-LAST:event_jTextField21KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        jTextField4.setText(jTextField4.getText().toUpperCase());
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        jTextField6.setText(jTextField6.getText().toUpperCase());
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
       jTextArea1.setText(jTextArea1.getText().toUpperCase());
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
       try{
            if(jComboBox5.getSelectedItem().equals("1")){
            cst=con.prepareCall("{call Genera_num_Bautismo}");
            r=cst.executeQuery();
            if (r.next())
            jTextField1.setText(r.getString(1));
             }else
                 if(jComboBox5.getSelectedItem().equals("2")){
                 cst=con.prepareCall("{call Genera_num_Bautismo2}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("3")){
                 cst=con.prepareCall("{call Genera_num_Bautismo3}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("4")){
                 cst=con.prepareCall("{call Genera_num_Bautismo4}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("5")){
                 cst=con.prepareCall("{call Genera_num_Bautismo5}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("6")){
                 cst=con.prepareCall("{call Genera_num_Bautismo6}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("7")){
                 cst=con.prepareCall("{call Genera_num_Bautismo7}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("8")){
                 cst=con.prepareCall("{call Genera_num_Bautismo8}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("9")){
                 cst=con.prepareCall("{call Genera_num_Bautismo9}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("10")){
                 cst=con.prepareCall("{call Genera_num_Bautismo10}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("11")){
                 cst=con.prepareCall("{call Genera_num_Bautismo11}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("12")){
                 cst=con.prepareCall("{call Genera_num_Bautismo12}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("13")){
                 cst=con.prepareCall("{call Genera_num_Bautismo13}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("14")){
                 cst=con.prepareCall("{call Genera_num_Bautismo14}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("15")){
                 cst=con.prepareCall("{call Genera_num_Bautismo15}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("16")){
                 cst=con.prepareCall("{call Genera_num_Bautismo16}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("17")){
                 cst=con.prepareCall("{call Genera_num_Bautismo17}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("18")){
                 cst=con.prepareCall("{call Genera_num_Bautismo18}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("19")){
                 cst=con.prepareCall("{call Genera_num_Bautismo19}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("20")){
                 cst=con.prepareCall("{call Genera_num_Bautismo20}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("21")){
                 cst=con.prepareCall("{call Genera_num_Bautismo21}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("22")){
                 cst=con.prepareCall("{call Genera_num_Bautismo22}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("23")){
                 cst=con.prepareCall("{call Genera_num_Bautismo23}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("24")){
                 cst=con.prepareCall("{call Genera_num_Bautismo24}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }else
                 if(jComboBox5.getSelectedItem().equals("25")){
                 cst=con.prepareCall("{call Genera_num_Bautismo25}");
                 r=cst.executeQuery();
                 if (r.next())
                 jTextField1.setText(r.getString(1));
                 }
        }catch (Exception e){}
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField21ActionPerformed

    private void jTextField902ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField902ActionPerformed
        
  
    }//GEN-LAST:event_jTextField902ActionPerformed
    private void valorbau() {
         try {
             cst=con.prepareCall("valorbau");
             r=cst.executeQuery();
             if (r.next())
        
          jTextField11.setText(r.getString(1));
 } catch (SQLException ex) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JButton jButton8;
    public static javax.swing.JButton jButton9;
    public static javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JComboBox<String> jComboBox2;
    public static javax.swing.JComboBox<String> jComboBox3;
    public static javax.swing.JComboBox<String> jComboBox4;
    public static javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JFormattedTextField jTextField10;
    public static javax.swing.JTextField jTextField11;
    public static javax.swing.JTextField jTextField12;
    public static javax.swing.JTextField jTextField13;
    public static javax.swing.JTextField jTextField14;
    public static javax.swing.JTextField jTextField15;
    public static javax.swing.JTextField jTextField16;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField21;
    public static javax.swing.JTextField jTextField23;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JFormattedTextField jTextField8;
    public static javax.swing.JTextField jTextField9;
    public static javax.swing.JFormattedTextField jTextField900;
    public static javax.swing.JFormattedTextField jTextField901;
    public static javax.swing.JFormattedTextField jTextField902;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    
    

   
}
