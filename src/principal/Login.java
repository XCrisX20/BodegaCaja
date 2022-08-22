package principal;

import principal.Conexion;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import puestos.*;
public class Login extends javax.swing.JFrame {

    private ImageIcon imagen;
    private Icon icono;
    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    
    int xMouse;
    int yMouse;
    
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        pintarImagen(lblImagen, "src/assets/images/user1.jpg");
    }

    final void pintarImagen(JLabel lbl, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
        lblImagen.setIcon(icono);
        this.repaint();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelLogin = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        pswClave = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));

        panelLogin.setBackground(new java.awt.Color(86, 101, 115));
        panelLogin.setPreferredSize(new java.awt.Dimension(500, 400));
        panelLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/user1.jpg"))); // NOI18N
        lblImagen.setToolTipText("");
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(247, 255, 147)));
        lblImagen.setMaximumSize(new java.awt.Dimension(100, 100));
        lblImagen.setMinimumSize(new java.awt.Dimension(100, 100));
        lblImagen.setPreferredSize(new java.awt.Dimension(100, 100));
        panelLogin.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, 270));

        lblUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("User:");
        panelLogin.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 50, -1));

        lblClave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblClave.setForeground(new java.awt.Color(255, 255, 255));
        lblClave.setText("Clave:");
        panelLogin.add(lblClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 50, -1));

        txtUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(6, 154, 142));
        panelLogin.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 190, -1));

        pswClave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pswClave.setForeground(new java.awt.Color(6, 154, 142));
        panelLogin.add(pswClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 190, -1));

        btnIngresar.setBackground(new java.awt.Color(40, 105, 133));
        btnIngresar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnIngresar.setBorderPainted(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelLogin.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 190, 32));

        jPanel1.setBackground(new java.awt.Color(40, 105, 133));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        btnSalir.setBackground(new java.awt.Color(40, 105, 133));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelLogin.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 40));

        lblLogo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Sistema de Bodega y Caja");
        lblLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelLogin.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 200, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("\"La Picada de Lenny\"");
        panelLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        String user = txtUser.getText();
        String pssw = new String(pswClave.getPassword());
        boolean ingreso = false;
        String t_emp = ""; 
        String rut_empleado ="";
        if (user.isEmpty() || pssw.isEmpty()){
            JOptionPane.showMessageDialog(null, "Los campos no pueden estar Vacios", "Error de ingreso", JOptionPane.WARNING_MESSAGE);
        }else{
            try{
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("Select * from empleadott");
                while(rs.next()){
                    if (user.equals(rs.getString("usuario")) && pssw.equals(rs.getString("clave"))){
                        ingreso = true;
                        t_emp = rs.getString("t_empleado");
                        rut_empleado = rs.getString("rut_empleado");
                    }
                }
                if (!ingreso){
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos", "Error Ingreso", JOptionPane.WARNING_MESSAGE);
                }else{
                    
                    switch(t_emp){
                        case "A":
                            this.setVisible(false);
                            Admin adm = new Admin();
                            adm.setVisible(true);
                            break;
                        case "B":
                            this.setVisible(false);
                            Bodega bod = new Bodega(rut_empleado);
                            bod.setVisible(true);
                            break;
                        case "C":
                            this.setVisible(false);
                            Caja caj = new Caja(rut_empleado);
                            caj.setVisible(true);
                            break;
                        default:
                            System.out.println("Caso no Contemplado.");
                    }
                    
                }
            
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error de Ingreso", "Error Ingreso", JOptionPane.ERROR);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_jPanel1MouseDragged

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField pswClave;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private Connection Conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
