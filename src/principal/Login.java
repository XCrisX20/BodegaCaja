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
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingresar");
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(400, 500));

        panelLogin.setBackground(new java.awt.Color(86, 101, 115));

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/images/user1.jpg"))); // NOI18N
        lblImagen.setToolTipText("");
        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(247, 255, 147)));
        lblImagen.setMaximumSize(new java.awt.Dimension(100, 100));
        lblImagen.setMinimumSize(new java.awt.Dimension(100, 100));
        lblImagen.setPreferredSize(new java.awt.Dimension(100, 100));

        lblUser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("User:");

        lblClave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblClave.setForeground(new java.awt.Color(255, 255, 255));
        lblClave.setText("Clave:");

        txtUser.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtUser.setForeground(new java.awt.Color(6, 154, 142));

        pswClave.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        pswClave.setForeground(new java.awt.Color(6, 154, 142));

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

        btnSalir.setText("X");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblClave, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pswClave))
                            .addGroup(panelLoginLayout.createSequentialGroup()
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addContainerGap())))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(btnSalir)
                .addGap(18, 18, 18)
                .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(pswClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

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
                            Bodega bod = new Bodega();
                            bod.setVisible(true);
                            break;
                        case "C":
                            this.setVisible(false);
                            Caja caj = new Caja();
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
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField pswClave;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    private Connection Conexion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
