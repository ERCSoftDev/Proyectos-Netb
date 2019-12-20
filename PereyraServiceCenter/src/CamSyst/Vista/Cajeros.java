
package CamSyst.Vista;

import CamSyst.AcercaDe;
import CamSyst.Administrador.GastosIngresos;
import CamSyst.Administrador.PoncheEmpleados;
import CamSyst.Administrador.ReporteDiario;
import CamSyst.Ayuda;
import CamSyst.Backup;
import CamSyst.Cliente.BuscarArticulosCaja;
import CamSyst.Cliente.Factura;
import CamSyst.Cliente.FacturaCajeros;
import CamSyst.Cliente.FacturasEnviadasCaja;
import CamSyst.Cliente.cliente;
import CamSyst.Consultas.ConsultaClientes;
import CamSyst.Consultas.ConsultaFacturaCli;
import CamSyst.Controlador.ClassConection;
import static CamSyst.Vista.Login_CamSyst.use;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cajeros extends javax.swing.JFrame {
 ClassConection  conectar= new ClassConection();
    public static Connection con;
   public static CallableStatement cst;
   PreparedStatement st;
   public static  ResultSet r;

    public Cajeros() {
        initComponents();
        String nombre=Login_CamSyst.use.getText();
        jLabel1.setText(nombre);
        validacion();
      
    }
   
public void validacion()   {
    String sql= "select nomem+apeem from Empleados inner join usuario\n" +
"on usuario.iduser=Empleados.codem and nick=?";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=sparesystem;","sa","admin010225");
            st=con.prepareStatement(sql);
            st.setString(1, jLabel1.getText());
            r=st.executeQuery();
            if(r.next()){  
                 Cajeros.jLabel6.setText(r.getString(1));
            }      
            else{         
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas,"+"Verifique el nombre de usuario y password");
            use.requestFocusInWindow();
            }                 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CamS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CamS.class.getName()).log(Level.SEVERE, null, ex);
        } }
public void factSusp(){ 
try {
            FacturasEnviadasCaja bs = new FacturasEnviadasCaja();
            jDesktopPane1.add(bs);
            bs.toFront();
            bs.setLocation(50, 5);
            bs.setVisible(true);
        } catch (Exception e){}
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblhora = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        copyMenuItem = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem71 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu26 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(102, 102, 102));
        jDesktopPane1.setAutoscrolls(true);
        jDesktopPane1.setDoubleBuffered(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Plus_2001887.png"))); // NOI18N
        jButton1.setAlignmentY(0.0F);
        jButton1.setAutoscrolls(true);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 204, 0));

        lblfecha.setText("00/00/00");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Hora Inicio:");

        lblhora.setText("00/00/00");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Fecha:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Bienvenidos a BlueSyst v1.0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Usuario:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ERC SoftDev");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("jLabel1");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Empleado:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(170, 170, 170)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblfecha)
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblhora)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(lblfecha)
                    .addComponent(jLabel5)
                    .addComponent(lblhora)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jButton2.setBackground(new java.awt.Color(153, 204, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_send-01_186386 (2).png"))); // NOI18N
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 0), 4, true));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 0));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Cajeros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(83, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(652, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(491, 491, 491)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jButton1))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jDesktopPane1);

        menuBar.setBackground(new java.awt.Color(204, 35, 35));
        menuBar.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546255_Desktop.png"))); // NOI18N
        fileMenu.setText("Sistema");
        fileMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

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
        editMenu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        copyMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        copyMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emblem-people.png"))); // NOI18N
        copyMenuItem.setMnemonic('4');
        copyMenuItem.setText("Cliente");
        copyMenuItem.setToolTipText("Mantenimiento de cliente");
        copyMenuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        copyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(copyMenuItem);

        menuBar.add(editMenu);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_preferences-calendar-and-tasks_24246.png"))); // NOI18N
        jMenu6.setText("Tareas");
        jMenu6.setToolTipText("Varias tareas");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Check_check_marks_list_checklist_documents_todo_list_1886538.png"))); // NOI18N
        jMenuItem20.setText("Facturacion");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem20);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_dollar-exchange_532645.png"))); // NOI18N
        jMenuItem19.setText("Gastos / Ingresos");
        jMenuItem19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem19);

        menuBar.add(jMenu6);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1451546591_database.png"))); // NOI18N
        jMenu1.setText("Consultas");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/emblem-people.png"))); // NOI18N
        jMenuItem2.setMnemonic('u');
        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem71.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_send-01_186386.png"))); // NOI18N
        jMenuItem71.setText("Facturas Suspendidas");
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem71);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Card_file_56261.png"))); // NOI18N
        jMenuItem3.setText("Factura Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/checked-checklist-notepad-24.png"))); // NOI18N
        jMenuItem18.setText("Listado de Precios");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem18);

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
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem4);

        jMenu2.add(jMenu26);

        menuBar.add(jMenu2);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/group-24.png"))); // NOI18N
        jMenu10.setText("RR.HH");
        jMenu10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_Checklist_clipboard_inventory_list_report_tasks_todo_1886533.png"))); // NOI18N
        jMenu7.setText("Gestion Empleado");

        jMenuItem24.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jMenuItem24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_simpline_55_2305607.png"))); // NOI18N
        jMenuItem24.setText("Ponches ");
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed

        try{
            AcercaDe ac =new AcercaDe();
            jDesktopPane1.add(ac);
            ac.show();
            ac.setLocation(50, 5);
        }catch (Exception e){}
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed

        Login_CamSyst acs=new Login_CamSyst();
        acs.show(true);
        this.hide();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        try{
            Backup  p= new Backup ();
            jDesktopPane1.add(p);
            p.setLocation(50, 5);
            p.show();
            p.setVisible(true);

        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int opcion=JOptionPane.showConfirmDialog(null,"Realmente decea Salir","confirmar",JOptionPane.YES_NO_OPTION);
        if(opcion==JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }

    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void copyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuItemActionPerformed
        try{

            cliente p =new cliente();
            jDesktopPane1.add(p);
            p.show();
        }catch (Exception e){}
    }//GEN-LAST:event_copyMenuItemActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        try{
            
            FacturaCajeros j=new FacturaCajeros();
            Cajeros.jDesktopPane1.add(j);
            j.setLocation(50, 5);
            j.show();
            j.setVisible(true);
            FacturaCajeros.datocli();
            FacturaCajeros.jTextField2.requestFocusInWindow();
        }catch(Exception e){}
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{
            ConsultaClientes f=new ConsultaClientes();
            Cajeros.jDesktopPane1.add(f);
            f.setLocation(50, 5);
            f.show();
            f.setVisible(true);
        }catch(Exception e){}

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed
        try {
            FacturasEnviadasCaja bs = new FacturasEnviadasCaja();
            Cajeros.jDesktopPane1.add(bs);
            bs.toFront();
            bs.setVisible(true);
        } catch (Exception e){}
    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
            ConsultaFacturaCli f=new ConsultaFacturaCli();
            Cajeros.jDesktopPane1.add(f);
            f.setLocation(50, 5);
            f.setVisible(true);
            f.show();
          //  ConsultaFacturaCli.colorear();
        }catch(Exception e){}

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        try {
            //this.jButton9.setEnabled(true);
            BuscarArticulosCaja bs;
            bs = new BuscarArticulosCaja();
            Cajeros.jDesktopPane1.add(bs);
            bs.toFront();
            bs.setLocation(50,10);
            bs.setVisible(true);
            BuscarArticulosCaja.jTextField1.requestFocusInWindow();
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

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

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        try{
            Ayuda f=new Ayuda();
            jDesktopPane1.add(f);
            f.setLocation(50, 5);
            f.show();
            f.setVisible(true);
        }catch(Exception e){}

    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     try{
        
        FacturaCajeros j=new FacturaCajeros();
        Cajeros.jDesktopPane1.add(j);
        j.setLocation(50, 5); 
        j.show();
        j.setVisible(true);
        FacturaCajeros.datocli();
        String nombre=Cajeros.jLabel6.getText();
        FacturaCajeros.jTextField1.setText(nombre);
        FacturaCajeros.jTextField2.requestFocusInWindow();
       }catch(SQLException e){}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
            FacturasEnviadasCaja bs = new FacturasEnviadasCaja();
            jDesktopPane1.add(bs);
            bs.toFront();
            bs.setVisible(true);
        } catch (Exception e){}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try{
            ReporteDiario f=new ReporteDiario();
            Cajeros.jDesktopPane1.add(f);
            f.setLocation(50, 5);
            f.show();
            f.setVisible(true);
        }catch(SQLException e){}
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed

        GastosIngresos bs = new GastosIngresos();
        Cajeros.jDesktopPane1.add(bs);
        bs.toFront();
        bs.setLocation(50,10);
        bs.setVisible(true);
        GastosIngresos.sumaGastos();
        GastosIngresos.cajaChica();
        GastosIngresos.calcuCJ();
        GastosIngresos. jTextField1.requestFocusInWindow();

    }//GEN-LAST:event_jMenuItem19ActionPerformed

 
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cajeros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu26;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem71;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblfecha;
    private javax.swing.JLabel lblhora;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
}
