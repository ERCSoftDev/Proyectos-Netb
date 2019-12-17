
package CamSyst.Vista;

import CamSyst.AcercaDe;
import CamSyst.Administrador.Abonos;
import CamSyst.Administrador.AbonosProveedores;
import CamSyst.Administrador.CXC;
import CamSyst.Administrador.CuadrePorFecha;
import CamSyst.Administrador.CuentasPorPagar;
import java.sql.*;
import java.util.Calendar;
import javax.swing.JOptionPane;
import CamSyst.Controlador.ClassConection;
import CamSyst.Administrador.Empleados;
import CamSyst.Administrador.Empresa;
import CamSyst.Administrador.GastosIngresos;
import CamSyst.Administrador.PoncheEmpleados;
import CamSyst.Administrador.ProductosPorPedir;
import CamSyst.Administrador.RegistroMovUsuarios;
import CamSyst.Administrador.RegistrosDeIngresosFact;
import CamSyst.Administrador.ReporteDiario;
import static CamSyst.Administrador.ReporteDiario.jTextField36;
import CamSyst.Administrador.ReporteProductos;
import CamSyst.Proveedor.Pedidos;
import CamSyst.Proveedor.Proveedor;
import CamSyst.Administrador.VentanaReportes;
import CamSyst.Administrador.comprobante;
import CamSyst.Ayuda;
import CamSyst.Backup;
import CamSyst.Cliente.BuscarArticulos2;
import CamSyst.Cliente.Cotizacion1;
import CamSyst.Cliente.Factura;
import CamSyst.Cliente.FacturasEnviadas;
import CamSyst.Cliente.FacturasEnviadasAdmin;
import CamSyst.Consultas.VentanaConsult;
import CamSyst.Cliente.cliente;
import CamSyst.Cliente.formaPago;
import CamSyst.Consultas.ConsultaClientes;
import CamSyst.Consultas.ConsultaFactura;
import CamSyst.Consultas.ConsultaFacturaCli;
import CamSyst.Consultas.ConsultaPrecioVenta;
import CamSyst.Consultas.ConsultaPrecioCosto;
import CamSyst.Consultas.ConsultaProductos;
import CamSyst.Consultas.ConsultasEmpleados;
import CamSyst.Productos;
import CamSyst.Proveedor.BuscarArticulos;
import CamSyst.Proveedor.BuscarProveedor;
import CamSyst.Usuarios;
import static CamSyst.Vista.Login_CamSyst.use;
import CamSyst.password;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Contabilidad extends javax.swing.JFrame{


    ClassConection  conectar= new ClassConection();
    public static Connection con;
   public static CallableStatement cst;
   PreparedStatement st;
   public static  ResultSet r;
    String userName;
    String passWord;

    public Contabilidad() {
   
        initComponents();
        
       // setIconImage(new ImageIcon(getClass().getResource("/Imagenes/blue-wave-3.png")).getImage());

Calendar cal=Calendar.getInstance();
String fecha=cal.get(Calendar.DATE) +"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.YEAR);
String hora=cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND); 
this.lblfecha.setText(fecha); 
this.lblhora.setText(hora);


String nombre=Login_CamSyst.use.getText();
jLabel1.setText(nombre);
valida();
}  
 public void valida()   {
    String sql= "select nomem+apeem from Empleados inner join usuario\n" +
"on usuario.iduser=Empleados.codem and nick=?";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sparesystem;","sa","admin010225");
            st=con.prepareStatement(sql);
            st.setString(1, jLabel1.getText());
            r=st.executeQuery();
            if(r.next()){  
                 Contabilidad.jLabel6.setText(r.getString(1));
            }      
            else{         
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas,"+"Verifique el nombre de usuario y password");
            use.requestFocusInWindow();
            }                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Contabilidad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Contabilidad.class.getName()).log(Level.SEVERE, null, ex);
        } }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem68 = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton13 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lblfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem70 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu27 = new javax.swing.JMenu();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu28 = new javax.swing.JMenu();
        jMenuItem76 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem71 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem72 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu26 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenu17 = new javax.swing.JMenu();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem56 = new javax.swing.JMenuItem();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem59 = new javax.swing.JMenuItem();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenuItem40 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenuItem16.setText("jMenuItem16");

        jMenu5.setText("jMenu5");

        jMenuItem27.setText("jMenuItem27");

        jMenu24.setText("jMenu24");

        jMenuItem68.setText("jMenuItem68");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CamSyst");
        setBackground(new java.awt.Color(102, 102, 102));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(MAXIMIZED_BOTH);
        setLocation(getLocationOnScreen());
        setLocationByPlatform(true);
        setMaximizedBounds(getMaximizedBounds());
        setMinimumSize(getPreferredSize());
        setUndecorated(true);
        setSize(getPreferredSize());
        setState(4);

        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setEnabled(false);
        jScrollPane2.setWheelScrollingEnabled(false);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setForeground(new java.awt.Color(0, 102, 51));
        jDesktopPane1.setToolTipText("Ventana Principal");
        jDesktopPane1.setAutoscrolls(true);
        jDesktopPane1.setDoubleBuffered(true);
        jDesktopPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDesktopPane1KeyTyped(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton13.setText("Informacion");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(102, 102, 102));
        jLabel10.setFont(new java.awt.Font("Baskerville Old Face", 1, 140)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 204, 255));
        jLabel10.setText("Blue");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 921, Short.MAX_VALUE)
        );

        jDesktopPane1.setLayer(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1016, 1016, 1016)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2609, Short.MAX_VALUE)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(334, 334, 334)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jDesktopPane1);

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setAutoscrolls(true);
        jPanel2.setPreferredSize(new java.awt.Dimension(290, 550));

        lblfecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblfecha.setForeground(new java.awt.Color(255, 255, 255));
        lblfecha.setText("00/00/00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Hora Inicio:");

        lblhora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblhora.setForeground(new java.awt.Color(255, 255, 255));
        lblhora.setText("00/00/00");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Bienvenidos a SpareSyst v3.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");
        jLabel3.setMaximumSize(new java.awt.Dimension(39, 15));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ERC SoftDev");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Empleado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("jLabel6");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Administrador");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("F10-Consulta Precio de Venta");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 140)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setText("System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(362, 362, 362))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblfecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblhora)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblfecha)
                    .addComponent(lblhora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(207, 207, 207)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1334, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        menuBar.setBackground(new java.awt.Color(204, 35, 35));
        menuBar.setAutoscrolls(true);
        menuBar.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546255_Desktop.png"))); // NOI18N
        fileMenu.setText("Sistema");
        fileMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_meanicons_60_197221.png"))); // NOI18N
        jMenuItem23.setText("Datos de la empresa");
        jMenuItem23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem23.setEnabled(false);
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem23);

        jMenu25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_icon-85-folder-information_314768.png"))); // NOI18N
        jMenu25.setText("Informacion adicional");
        jMenu25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_6_3319634 (2).png"))); // NOI18N
        jMenuItem70.setText("Comprobantes");
        jMenuItem70.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem70ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem70);

        fileMenu.add(jMenu25);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/globe-tools-settings-32.png"))); // NOI18N
        jMenu11.setText("Configuracion idiomas");
        jMenu11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Spain-Flag.png"))); // NOI18N
        jMenuItem33.setText("Español");
        jMenuItem33.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu11.add(jMenuItem33);

        jMenuItem67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/united-states-of-america-usa.png"))); // NOI18N
        jMenuItem67.setText("English");
        jMenuItem67.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu11.add(jMenuItem67);

        fileMenu.add(jMenu11);

        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/xfce-system-settings.png"))); // NOI18N
        jMenuItem14.setText("Uso del sistema");
        jMenuItem14.setToolTipText("Uso de CamSyst");
        jMenuItem14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem14.setEnabled(false);
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem14);

        jMenuItem34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/user-32.png"))); // NOI18N
        jMenuItem34.setText("Usuarios");
        jMenuItem34.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem34.setEnabled(false);
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem34);

        jMenuItem69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_34_Custom_Coding_1688841.png"))); // NOI18N
        jMenuItem69.setText("Programador");
        jMenuItem69.setToolTipText("Ventana exclusivamente para el programador");
        jMenuItem69.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem69.setEnabled(false);
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem69);

        openMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Free-14-24.png"))); // NOI18N
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Acerca de");
        openMenuItem.setToolTipText("Informacion del sistema");
        openMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/electricity-24 (1).png"))); // NOI18N
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Cambiar sesion");
        saveMenuItem.setToolTipText("cambiar de usuario");
        saveMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        jMenuItem35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Blue_Backup_W.png"))); // NOI18N
        jMenuItem35.setText("Backup");
        jMenuItem35.setToolTipText("Copia de seguridad");
        jMenuItem35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem35.setEnabled(false);
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem35);

        exitMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout-24.png"))); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.setToolTipText("Salir");
        exitMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546533_maintenance.png"))); // NOI18N
        editMenu.setMnemonic('e');
        editMenu.setText("Mantenimiento");
        editMenu.setFocusPainted(true);
        editMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_2_330395 (1).png"))); // NOI18N
        copyMenuItem.setMnemonic('4');
        copyMenuItem.setText("Clientes");
        copyMenuItem.setToolTipText("Mantenimiento de cliente");
        copyMenuItem.setBorderPainted(true);
        copyMenuItem.setContentAreaFilled(false);
        copyMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        pasteMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Product-documentation (1).png"))); // NOI18N
        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Productos");
        pasteMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pasteMenuItem.setEnabled(false);
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(pasteMenuItem);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_vector_65_12_473798 (1).png"))); // NOI18N
        jMenuItem13.setText("Proveedores");
        jMenuItem13.setToolTipText("Vendedore y/o Proveedores");
        jMenuItem13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem13.setEnabled(false);
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem13);

        jMenuItem73.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emblem-people.png"))); // NOI18N
        jMenuItem73.setText("Empleados");
        jMenuItem73.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem73ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem73);

        menuBar.add(editMenu);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_preferences-calendar-and-tasks_24246.png"))); // NOI18N
        jMenu6.setText("Tareas");
        jMenu6.setToolTipText("Varias tareas");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Check_check_marks_list_checklist_documents_todo_list_1886538.png"))); // NOI18N
        jMenuItem20.setText("Facturacion");
        jMenuItem20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem20.setEnabled(false);
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuItem21.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventory-maintenance.png"))); // NOI18N
        jMenuItem21.setText("Ingreso de pedidos");
        jMenuItem21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem21.setEnabled(false);
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem21);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_dollar-exchange_532645 (1).png"))); // NOI18N
        jMenuItem19.setText("Gastos / Ingresos");
        jMenuItem19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        jMenuItem75.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_si-duo-stack_1215219 (2).png"))); // NOI18N
        jMenuItem75.setText("Cotizaciones");
        jMenuItem75.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem75.setEnabled(false);
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem75);

        jMenuItem22.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_ic_assignment_return_48px_352029.png"))); // NOI18N
        jMenuItem22.setText("Devoluciones");
        jMenuItem22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem22.setEnabled(false);
        jMenu6.add(jMenuItem22);

        menuBar.add(jMenu6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546591_database.png"))); // NOI18N
        jMenu1.setText("Consultas");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenu27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Business_56259.png"))); // NOI18N
        jMenu27.setText("Consulta Comisiones");
        jMenu27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu27.setEnabled(false);

        jMenuItem25.setText("Tren delantero");
        jMenuItem25.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu27.add(jMenuItem25);

        jMenuItem49.setText("Regriferacion");
        jMenuItem49.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu27.add(jMenuItem49);

        jMenuItem50.setText("Mecanica General");
        jMenuItem50.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu27.add(jMenuItem50);

        jMenuItem51.setText("Gomera");
        jMenuItem51.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu27.add(jMenuItem51);

        jMenu1.add(jMenu27);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_2_330395 (1).png"))); // NOI18N
        jMenuItem2.setMnemonic('u');
        jMenuItem2.setText("Clientes");
        jMenuItem2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_document-dollar_532647.png"))); // NOI18N
        jMenu28.setText("Consulta de Precios");
        jMenu28.setToolTipText("Consulta de Precios");
        jMenu28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu28.setEnabled(false);

        jMenuItem76.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItem76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_price_down_sale_shop_4177580 (1)_1.png"))); // NOI18N
        jMenuItem76.setText("Consult. Rapida Precio Venta");
        jMenuItem76.setToolTipText("Consult. Rapida Precio Venta");
        jMenuItem76.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem76);

        jMenuItem77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_price_down_sale_shop_4177580 (1).png"))); // NOI18N
        jMenuItem77.setText("Consult.Rapida Precio Costo");
        jMenuItem77.setToolTipText("Consult.Rapida Precio Costo");
        jMenuItem77.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem77);

        jMenu1.add(jMenu28);

        jMenu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Card_file_56261.png"))); // NOI18N
        jMenu14.setText("Facturas");
        jMenu14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Checklist_clipboard_inventory_list_report_tasks_todo_1886533.png"))); // NOI18N
        jMenuItem3.setText("Factura Clientes");
        jMenuItem3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem3);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Check_check_marks_list_checklist_documents_todo_list_1886538.png"))); // NOI18N
        jMenuItem1.setMnemonic('z');
        jMenuItem1.setText("Factura Proveedor");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem1);

        jMenuItem71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_send-01_186386.png"))); // NOI18N
        jMenuItem71.setText("Facturas Suspendidas");
        jMenuItem71.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem71);

        jMenu1.add(jMenu14);

        jMenu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventory-maintenance.png"))); // NOI18N
        jMenu15.setText("Inventario");
        jMenu15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu15.setEnabled(false);

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Product-documentation (1).png"))); // NOI18N
        jMenuItem9.setText("Productos");
        jMenuItem9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem9);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_document-03_1622833.png"))); // NOI18N
        jMenuItem18.setText("Listado de Precios");
        jMenuItem18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem18MouseClicked(evt);
            }
        });
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem18);

        jMenuItem72.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cart-32.png"))); // NOI18N
        jMenuItem72.setText("Listado Productos");
        jMenuItem72.setToolTipText("");
        jMenuItem72.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem72ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem72);

        jMenu1.add(jMenu15);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_vector_65_12_473798 (1).png"))); // NOI18N
        jMenuItem8.setText("Proveedores");
        jMenuItem8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem8.setEnabled(false);
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_provider_45069.png"))); // NOI18N
        jMenuItem10.setText("Empleados");
        jMenuItem10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        menuBar.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546632_Print.png"))); // NOI18N
        jMenu2.setText("Reportes");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenu26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_2_-_Cash_Register_2102044.png"))); // NOI18N
        jMenu26.setText("Ventas");
        jMenu26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/money-24.png"))); // NOI18N
        jMenuItem4.setText("Cuadre Diario");
        jMenuItem4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem4);

        jMenuItem74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconfinder_Christmas_Date_1651909.png"))); // NOI18N
        jMenuItem74.setText("Cuadre por fecha X");
        jMenuItem74.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem74);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checked-checklist-notepad-24.png"))); // NOI18N
        jMenuItem5.setText("Reporte Mensual");
        jMenuItem5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/advantage_diagram-24.png"))); // NOI18N
        jMenuItem6.setText("Reporte Anual");
        jMenuItem6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem6);

        jMenu2.add(jMenu26);

        jMenu21.setText("Ingresos");
        jMenu21.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem63.setText("Ingresos por dia");
        jMenuItem63.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu21.add(jMenuItem63);

        jMenuItem65.setText("Ingresos pro mes ");
        jMenuItem65.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu21.add(jMenuItem65);

        jMenuItem64.setText("Ingresos por año");
        jMenuItem64.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu21.add(jMenuItem64);

        jMenu2.add(jMenu21);

        jMenu17.setText("Gastos");
        jMenu17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem55.setText("Gastos por dia");
        jMenu17.add(jMenuItem55);

        jMenuItem61.setText("Gasto por mes ");
        jMenu17.add(jMenuItem61);

        jMenuItem62.setText("Gasto por año ");
        jMenu17.add(jMenuItem62);

        jMenu2.add(jMenu17);

        jMenu16.setText("Estadisticas");
        jMenu16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenu18.setText("Ventas");

        jMenuItem52.setText("Ventas por dia ");
        jMenu18.add(jMenuItem52);

        jMenuItem53.setText("Venta por mes  ");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem53);

        jMenuItem54.setText("Venta por año");
        jMenu18.add(jMenuItem54);

        jMenu16.add(jMenu18);

        jMenu19.setText("Gastos");

        jMenuItem56.setText("Gastos por dia");
        jMenu19.add(jMenuItem56);

        jMenuItem57.setText("Gastos por mes");
        jMenu19.add(jMenuItem57);

        jMenuItem58.setText("Gastos por año");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem58);

        jMenu16.add(jMenu19);

        jMenu20.setText("Productos");

        jMenuItem59.setText("20 Productos mas vendidos");
        jMenu20.add(jMenuItem59);

        jMenuItem60.setText("100 Productos mas vendidos");
        jMenu20.add(jMenuItem60);

        jMenu16.add(jMenu20);

        jMenu2.add(jMenu16);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventory-maintenance.png"))); // NOI18N
        jMenuItem11.setText("Total Inventario");
        jMenuItem11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem11.setEnabled(false);
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        menuBar.add(jMenu2);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emblem-people.png"))); // NOI18N
        jMenu4.setText("Administrador");
        jMenu4.setToolTipText("Uso exclusivo del Administrador");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cart-32.png"))); // NOI18N
        jMenuItem12.setText("Productos a Pedir");
        jMenuItem12.setToolTipText("Listado de Productos a pedir");
        jMenuItem12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem12.setEnabled(false);
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/System Activity Monitor.png"))); // NOI18N
        jMenuItem15.setText("Registro de Actividades");
        jMenuItem15.setToolTipText("Registro de actividad de los usuarios");
        jMenuItem15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem15.setEnabled(false);
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        menuBar.add(jMenu4);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_history_58875.png"))); // NOI18N
        jMenu8.setText("Contabilidad");
        jMenu8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_folder-document_299048.png"))); // NOI18N
        jMenuItem17.setText("Cuentas por Pagar");
        jMenuItem17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem17);

        jMenuItem26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/creativecommons-32.png"))); // NOI18N
        jMenuItem26.setText("Cuentas por Cobrar");
        jMenuItem26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem26MouseClicked(evt);
            }
        });
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem26);

        jMenuItem28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Money_56265.png"))); // NOI18N
        jMenuItem28.setText("Desembolsos");
        jMenuItem28.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu8.add(jMenuItem28);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/23.png"))); // NOI18N
        jMenu9.setText("Abonos");
        jMenu9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jMenuItem30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Flat1-18_2399642.png"))); // NOI18N
        jMenuItem30.setText("Factura Proveedores");
        jMenuItem30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem30);

        jMenuItem31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Flat1-18_2399642.png"))); // NOI18N
        jMenuItem31.setText("Factura Clientes");
        jMenuItem31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem31);

        jMenu8.add(jMenu9);

        jMenuItem29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_bank-building_532649.png"))); // NOI18N
        jMenuItem29.setText("Bancos");
        jMenuItem29.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu8.add(jMenuItem29);

        jMenuItem66.setText("Diario general");
        jMenuItem66.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu8.add(jMenuItem66);

        menuBar.add(jMenu8);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/group-24.png"))); // NOI18N
        jMenu10.setText("RR.HH");
        jMenu10.setEnabled(false);
        jMenu10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem36.setText("Contratos");
        jMenu10.add(jMenuItem36);

        jMenuItem37.setText("Licencias");
        jMenu10.add(jMenuItem37);

        jMenuItem38.setText("Vacaciones");
        jMenu10.add(jMenuItem38);

        jMenuItem39.setText("Ingresos");
        jMenu10.add(jMenuItem39);

        jMenuItem40.setText("Descuentos");
        jMenu10.add(jMenuItem40);

        jMenu22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_49_61513.png"))); // NOI18N
        jMenu22.setText("PrestaSyst");

        jMenuItem41.setText("Clientes");
        jMenu22.add(jMenuItem41);

        jMenu23.setText("Empleados");
        jMenu22.add(jMenu23);

        jMenu10.add(jMenu22);

        jMenuItem42.setText("Seguros TSS");
        jMenu10.add(jMenuItem42);

        jMenu12.setText("Impresiones");

        jMenuItem43.setText("Contratos");
        jMenu12.add(jMenuItem43);

        jMenuItem44.setText("Cancelacion empleado");
        jMenu12.add(jMenuItem44);

        jMenu10.add(jMenu12);

        jMenu13.setText("Nominas / Retribucion");

        jMenuItem32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_document-dollar_532647.png"))); // NOI18N
        jMenuItem32.setText("Totales Ingresos & Descuentos");
        jMenu13.add(jMenuItem32);

        jMenuItem45.setText("Total Nominas");
        jMenu13.add(jMenuItem45);

        jMenuItem46.setText("Calcular nominas");
        jMenu13.add(jMenuItem46);

        jMenuItem47.setText("Regalias");
        jMenu13.add(jMenuItem47);

        jMenuItem48.setText("Liquidaciones");
        jMenu13.add(jMenuItem48);

        jMenu10.add(jMenu13);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Checklist_clipboard_inventory_list_report_tasks_todo_1886533.png"))); // NOI18N
        jMenu7.setText("Gestion Empleado");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_hierarchy_1931214.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Empleado");
        cutMenuItem.setToolTipText("Empleados");
        cutMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        jMenu7.add(cutMenuItem);

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_simpline_55_2305607.png"))); // NOI18N
        jMenuItem24.setText("Ponches ");
        jMenuItem24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem24);

        jMenu10.add(jMenu7);

        menuBar.add(jMenu10);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546662_help-browser.png"))); // NOI18N
        jMenu3.setText("Ayuda");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Help.png"))); // NOI18N
        jMenuItem7.setText("Centro de ayuda");
        jMenuItem7.setToolTipText("Centro de Ayuda");
        jMenuItem7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        menuBar.add(jMenu3);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
      int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
if(opcion==JOptionPane.YES_NO_OPTION){
System.exit(0);
}
        
    }//GEN-LAST:event_exitMenuItemActionPerformed

    @SuppressWarnings({"UseSpecificCatch", "deprecation"})
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
if(userName.equals("empleado")){
        try{
            JOptionPane.showMessageDialog(this,"Estimado "+userName+" No tienes Permisos para Abrir esta Ventana"+"\nContacte con el Administrador"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog(this,""+"\t\t\t"+userName+"\nConectate como Administrador"+"\tPara poder Abrir esta ventana"+"\n\t\t\tDisculpe los Inconvenientes"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            }catch (Exception e){}
        
}
        else{
                if(userName.equals("Administrador")){
        try{
            JOptionPane.showMessageDialog(this,"Estimado "+userName+"Pestaña en mantenimiento"+"\nContacte con el Desarrollador"
            ,"Aviso!",JOptionPane.INFORMATION_MESSAGE);
           
            }catch (Exception e){}
        } }      
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
try{
        Empleados f=new Empleados();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}      
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
try{
    
            cliente p =new cliente();
        jDesktopPane1.add(p);
        
        p.show();
       }catch (Exception e){}    
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
       try{
        AcercaDe ac =new AcercaDe();
        jDesktopPane1.add(ac);
        ac.show();
        ac.setLocation(50, 5);
       }catch (Exception e){}
    }//GEN-LAST:event_openMenuItemActionPerformed

    @SuppressWarnings("deprecation")
    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
       
        Login_CamSyst acs=new Login_CamSyst();
         acs.show(true);
         this.hide();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
 
        try{
        Ayuda f=new Ayuda();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}       
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
       
      try{
        Productos f=new Productos();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
                          
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    @SuppressWarnings({"deprecation", "deprecation"})
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
try{
        ReporteDiario f=new ReporteDiario();
        Contabilidad.jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
      ReporteDiario.sumafacturas();
      ReporteDiario.sumafacturascredi();
      ReporteDiario.sumatarjetas();
      ReporteDiario.sumaNC();
       //ReporteDiario.sumadinero();
      ReporteDiario.sumaBauches();
      ReporteDiario.sumaGastos2();
      ReporteDiario.sumaIngreso();
      ReporteDiario.cajaChica();
      ReporteDiario.sumatotalfacturas();
      String nombre=Contabilidad.jLabel6.getText();
      ReporteDiario.jTextField35.setText(nombre);
      if(jTextField36.getText().equals("")){
       jTextField36.setText("0");
       }
        
        }catch(SQLException e){}        
    }//GEN-LAST:event_jMenuItem4ActionPerformed


    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       try{
        ConsultaFactura f=new ConsultaFactura();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
        ConsultaFacturaCli f=new ConsultaFacturaCli();
        jDesktopPane1.add(f);
        f.setLocation(50, 5);        
        f.setVisible(true);
        f.show();
        }catch(Exception e){}
        
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       try{
        ConsultaClientes f=new ConsultaClientes();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
       
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
     try{
        ConsultaProductos f=new ConsultaProductos();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      if(userName.equals("empleado")){
        try{
            JOptionPane.showMessageDialog(this,"Estimado "+userName+" No tienes Permisos para Abrir esta Ventana"+"\nContacte con el Administrador"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog(this,""+"\t\t\t"+userName+"\nConectate como Administrador"+"\tPara poder Abrir esta ventana"+"\n\t\t\tDisculpe los Inconvenientes"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            }catch (Exception e){}
        
}
        else{
                if(userName.equals("Administrador")){
        try{
            JOptionPane.showMessageDialog(this,"Estimado "+userName+"Pestaña en mantenimiento"+"\nContacte con el Desarrollador"
            ,"Aviso!",JOptionPane.INFORMATION_MESSAGE);
           
            }catch (Exception e){}
        }       
    }                                        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed

        try{
            ReporteProductos ac =new ReporteProductos();
            jDesktopPane1.add(ac);
            ac.show();
            ac.setLocation(50, 5);
            ac.setVisible(true);
            }catch (Exception e){}              
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseClicked

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        try{
        Proveedor f=new Proveedor();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
     try{
        BuscarProveedor f=new BuscarProveedor();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
       try{
           
        ConsultasEmpleados f=new ConsultasEmpleados();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       try{
            ProductosPorPedir ac =new  ProductosPorPedir();
            jDesktopPane1.add(ac);
            ac.show();
            ac.setLocation(50, 5);
            }catch (Exception e){}
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
     
        if(userName.equals("empleado")){
        try{
            JOptionPane.showMessageDialog(this,"Estimado "+userName+" No tienes Permisos para Abrir esta Ventana"+"\nContacte con el Administrador"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.showMessageDialog(this,""+"\t\t\t"+userName+"\nConectate como Administrador"+"\tPara poder Abrir esta ventana"+"\n\t\t\tDisculpe los Inconvenientes"
            ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);
            
            JOptionPane.setRootFrame(this);
            RegistrosDeIngresosFact ac =new RegistrosDeIngresosFact();
            jDesktopPane1.add(ac);
            ac.show();
            ac.setVisible(false);
            ac.setLocation(50, 5);
            }catch (Exception e){}
        
}
        else{
                if(userName.equals("Administrador")){
        try{
            RegistrosDeIngresosFact ac =new RegistrosDeIngresosFact();
            jDesktopPane1.add(ac);
            ac.show();
            ac.setLocation(50, 5);
            ac.setVisible(true);
            }catch (Exception e){}
        }       }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jDesktopPane1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDesktopPane1KeyTyped
     
    }//GEN-LAST:event_jDesktopPane1KeyTyped

    private void jMenuItem4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MouseClicked
      ReporteDiario.sumafacturas();
    }//GEN-LAST:event_jMenuItem4MouseClicked

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
         ReporteDiario.sumafacturas();
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
       try{
        formaPago f=new formaPago();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
       
        GastosIngresos bs = new GastosIngresos();
        Contabilidad.jDesktopPane1.add(bs);
        bs.toFront();
        bs.setLocation(50,10);
        bs.setVisible(true);
        GastosIngresos.sumaGastos();
        GastosIngresos.cajaChica();
        GastosIngresos.calcuCJ();
        GastosIngresos. jTextField1.requestFocusInWindow();
     
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
      try{
        Factura j=new Factura();
        jDesktopPane1.add(j);
        j.setLocation(50, 5); 
        j.show();
        j.setVisible(true);
        Factura.datocli();
        Factura.jTextField2.requestFocusInWindow();
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
       try{
        Pedidos f=new Pedidos();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
       }catch(Exception e){} 
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
       try{
        PoncheEmpleados f=new PoncheEmpleados();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        PoncheEmpleados.jFormattedTextField1.requestFocusInWindow();
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed

         try{
        CXC p= new CXC();
        jDesktopPane1.add(p);
        p.setLocation(50, 5); 
        p.show();
        p.setVisible(true);
 
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem26MouseClicked

    }//GEN-LAST:event_jMenuItem26MouseClicked

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        try{
        CuentasPorPagar p= new CuentasPorPagar(this.userName,this.passWord);
        jDesktopPane1.add(p);
        p.setLocation(50, 5); 
        p.show();
        p.setVisible(true);
 
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
   try{
        Abonos  p= new Abonos ();
        jDesktopPane1.add(p);
        p.setLocation(50, 5); 
        p.show();
        p.setVisible(true);
 
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem70ActionPerformed
       try{
        comprobante f=new comprobante();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
       }catch(Exception e){}
                             
    }//GEN-LAST:event_jMenuItem70ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed
       try {
           FacturasEnviadas bs = new FacturasEnviadas();
           jDesktopPane1.add(bs);
           bs.toFront();
           bs.setVisible(true);       
       } catch (Exception e){}                      
    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem72ActionPerformed
        try {
          
           BuscarArticulos bs;
           bs = new BuscarArticulos();
           Contabilidad.jDesktopPane1.add(bs);
           bs.toFront();
           bs.setLocation(50,10);
           bs.setVisible(true);
           
       } catch (SQLException ex) {
           Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
       }       
          
    }//GEN-LAST:event_jMenuItem72ActionPerformed

    private void jMenuItem73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem73ActionPerformed
        try{
        Empleados f=new Empleados();
        jDesktopPane1.add(f);
        f.setLocation(50, 5); 
        f.show();
        f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem73ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        try {
            BuscarArticulos2 bs;
            bs = new BuscarArticulos2();
            Contabilidad.jDesktopPane1.add(bs);
            bs.toFront();
            bs.setLocation(50,10);
            bs.setVisible(true);
            BuscarArticulos2.jTextField1.requestFocusInWindow();
        } catch (SQLException ex) {
            Logger.getLogger(Contabilidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
        try{
            CuadrePorFecha ac =new CuadrePorFecha();
            this.jDesktopPane1.add(ac);
            ac.show();
            ac.setLocation(50, 5);
            ac.setVisible(true);
        }catch (Exception e){}
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jMenuItem18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem18MouseClicked

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
       try{
        AbonosProveedores  p= new AbonosProveedores ();
        jDesktopPane1.add(p);
        p.setLocation(50, 5); 
        p.show();
        p.setVisible(true);
 
       }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
       try{
        Cotizacion1 t=new Cotizacion1();
        Contabilidad.jDesktopPane1.add(t);
        t.setLocation(50, 5); 
        t.show();
        t.setVisible(true);
       }catch(SQLException e){}
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
       try{
        ConsultaPrecioVenta f=new  ConsultaPrecioVenta();
        Contabilidad.jDesktopPane1.add(f);
        f.setLocation(50, 5);        
        f.setVisible(true);
        f.show();
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
        try{
        ConsultaPrecioCosto f=new  ConsultaPrecioCosto();
        Contabilidad.jDesktopPane1.add(f);
        f.setLocation(50, 5);        
        f.setVisible(true);
        f.show();
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        try{
            Backup  p= new Backup ();
            jDesktopPane1.add(p);
            p.setLocation(50, 5);
            p.show();
            p.setVisible(true);

        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        try{
            password  p= new password (this.userName,this.passWord);
            jDesktopPane1.add(p);
            p.setLocation(50, 5);
            p.show();
            p.setVisible(true);

        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        try{
            Usuarios  p= new Usuarios ();
            jDesktopPane1.add(p);
            p.setLocation(50, 5);
            p.show();
            p.setVisible(true);

        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed

        if(userName.equals("empleado")){
            try{
                JOptionPane.showMessageDialog(this,"Estimado "+userName+" No tienes Permisos para Abrir esta Ventana"+"\nContacte con el Administrador"
                    ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.showMessageDialog(this,""+"\t\t\t"+userName+"\nConectate como Administrador"+"\tPara poder Abrir esta ventana"+"\n\t\t\tDisculpe los Inconvenientes"
                    ,"Acceso Denegado!",JOptionPane.INFORMATION_MESSAGE);

                JOptionPane.setRootFrame(this);
                RegistroMovUsuarios ac =new RegistroMovUsuarios();
                jDesktopPane1.add(ac);
                ac.show();
                ac.setVisible(false);
                ac.setLocation(50, 5);
            }catch (Exception e){}

        }
        else{
            if(userName.equals("Administrador")){
                try{
                    RegistroMovUsuarios ac =new RegistroMovUsuarios();
                    jDesktopPane1.add(ac);
                    ac.show();
                    ac.setLocation(50, 5);
                    ac.setVisible(true);
                }catch (Exception e){}
            }       }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        try{
            Empresa f=new Empresa();
            jDesktopPane1.add(f);
            f.setLocation(50, 5);
            f.show();
            f.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem23ActionPerformed
       
    public static void main(String args[]){
        
        java.awt.EventQueue.invokeLater(new Runnable(){

             @Override
             public void run() {

             }        
          });
              
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton13;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu21;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu23;
    private javax.swing.JMenu jMenu24;
    private javax.swing.JMenu jMenu25;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu27;
    private javax.swing.JMenu jMenu28;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem43;
    private javax.swing.JMenuItem jMenuItem44;
    private javax.swing.JMenuItem jMenuItem45;
    private javax.swing.JMenuItem jMenuItem46;
    private javax.swing.JMenuItem jMenuItem47;
    private javax.swing.JMenuItem jMenuItem48;
    private javax.swing.JMenuItem jMenuItem49;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem50;
    private javax.swing.JMenuItem jMenuItem51;
    private javax.swing.JMenuItem jMenuItem52;
    private javax.swing.JMenuItem jMenuItem53;
    private javax.swing.JMenuItem jMenuItem54;
    private javax.swing.JMenuItem jMenuItem55;
    private javax.swing.JMenuItem jMenuItem56;
    private javax.swing.JMenuItem jMenuItem57;
    private javax.swing.JMenuItem jMenuItem58;
    private javax.swing.JMenuItem jMenuItem59;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem60;
    private javax.swing.JMenuItem jMenuItem61;
    private javax.swing.JMenuItem jMenuItem62;
    private javax.swing.JMenuItem jMenuItem63;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem69;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem70;
    private javax.swing.JMenuItem jMenuItem71;
    private javax.swing.JMenuItem jMenuItem72;
    private javax.swing.JMenuItem jMenuItem73;
    private javax.swing.JMenuItem jMenuItem74;
    private javax.swing.JMenuItem jMenuItem75;
    private javax.swing.JMenuItem jMenuItem76;
    private javax.swing.JMenuItem jMenuItem77;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables


}
