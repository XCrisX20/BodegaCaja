
package puestos;

import principal.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import principal.Login;

public class Admin extends javax.swing.JFrame {

    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    
    public Admin() {
        initComponents();
    }

    
    void borrarCampos(){
        txtRut.setText("");
        txtNombre.setText("");
        txtUser.setText("");
        txtClave.setText("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelAdmin = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVerUsuarios = new javax.swing.JButton();
        btnVerVentas = new javax.swing.JButton();
        btnGestionarProductos = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        rbCajero = new javax.swing.JRadioButton();
        rbBodeguero = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblRut = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtRut = new javax.swing.JTextField();
        btnAgregarUsuario = new javax.swing.JButton();
        btn_cerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(580, 550));
        setSize(new java.awt.Dimension(0, 0));

        panelAdmin.setBackground(new java.awt.Color(142, 0, 29));
        panelAdmin.setPreferredSize(new java.awt.Dimension(500, 450));
        panelAdmin.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("ADMINISTRACION");
        panelAdmin.add(lblTitulo);
        lblTitulo.setBounds(10, 11, 231, 41);

        btnVerUsuarios.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVerUsuarios.setText("Ver usuarios");
        btnVerUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerUsuariosActionPerformed(evt);
            }
        });
        panelAdmin.add(btnVerUsuarios);
        btnVerUsuarios.setBounds(340, 90, 157, 36);

        btnVerVentas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVerVentas.setText("Ver ventas");
        btnVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVentasActionPerformed(evt);
            }
        });
        panelAdmin.add(btnVerVentas);
        btnVerVentas.setBounds(340, 160, 157, 36);

        btnGestionarProductos.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnGestionarProductos.setText("Gestionar Productos");
        btnGestionarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarProductosActionPerformed(evt);
            }
        });
        panelAdmin.add(btnGestionarProductos);
        btnGestionarProductos.setBounds(340, 230, 157, 36);

        panel1.setBackground(new java.awt.Color(155, 155, 155));
        panel1.setName(""); // NOI18N
        panel1.setPreferredSize(new java.awt.Dimension(300, 200));

        rbCajero.setBackground(new java.awt.Color(155, 155, 155));
        buttonGroup1.add(rbCajero);
        rbCajero.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbCajero.setText("Cajero");

        rbBodeguero.setBackground(new java.awt.Color(155, 155, 155));
        buttonGroup1.add(rbBodeguero);
        rbBodeguero.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        rbBodeguero.setSelected(true);
        rbBodeguero.setText("Bodeguero");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Tipo de empleado");

        lblClave.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblClave.setText("Contraseña");

        lblUser.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblUser.setText("Nombre de usuario");

        lblNombre.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblNombre.setText("Nombre completo");

        lblRut.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lblRut.setText("Rut");

        txtRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRutKeyTyped(evt);
            }
        });

        btnAgregarUsuario.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnAgregarUsuario.setText("Agregar Usuario");
        btnAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rbBodeguero)
                        .addGap(18, 18, 18)
                        .addComponent(rbCajero))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblClave, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblUser))
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRut, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRut)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClave)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBodeguero)
                    .addComponent(rbCajero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnAgregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelAdmin.add(panel1);
        panel1.setBounds(10, 71, 300, 340);

        btn_cerrarSesion.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        btn_cerrarSesion.setText("Cerrar Sesión");
        btn_cerrarSesion.setToolTipText("");
        btn_cerrarSesion.setName("btn_cerrarSesion"); // NOI18N
        btn_cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarSesionActionPerformed(evt);
            }
        });
        panelAdmin.add(btn_cerrarSesion);
        btn_cerrarSesion.setBounds(380, 11, 120, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerUsuariosActionPerformed
        Usuarios user = new Usuarios();
        user.setVisible(true);
    }//GEN-LAST:event_btnVerUsuariosActionPerformed

    private void btnAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarUsuarioActionPerformed
        String rut = txtRut.getText();
        boolean val = validarRUT(rut);
        if(!val){
            JOptionPane.showMessageDialog(null, "El Rut no es Correcto", "Rut Incorrecto",JOptionPane.ERROR_MESSAGE);
            return;
        }
        String nombre = txtNombre.getText();
        String usuario = txtUser.getText();
        String clave = txtClave.getText();
        String rb = "N";
        if (rbBodeguero.isSelected()) rb = "B";
        if (rbCajero.isSelected()) rb = "C";
        
        if (rut.isEmpty() || nombre.isEmpty() || usuario.isEmpty() || clave.isEmpty()){
            JOptionPane.showMessageDialog(null, "Los campos no deben quedar Vacios", "Fallo Insercion", JOptionPane.WARNING_MESSAGE);
        }else{
            String cons = "Insert into empleadott (rut_empleado, nombre_completo, usuario, clave, t_empleado) values('"+rut+"','"+nombre+"','"+usuario+"','"+clave+"','"+rb+"')";
            try{
                Statement stm = conn.createStatement();
                stm.executeUpdate(cons);
                JOptionPane.showMessageDialog(null, "Usuario Ingresado", "Usuario Ingresado", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al Agregar Usuario", "Error de Insercion", JOptionPane.ERROR);
            }
            borrarCampos();
            txtRut.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarUsuarioActionPerformed

    private boolean validarRUT(String rut){
        if(contarCaracteres(rut, '-') != 1) return false;
        int pos_guion = rut.indexOf("-");
        if(pos_guion == -1 || rut.length() > 10) return false;
        String partNum = rut.substring(0, rut.indexOf("-"));
        if(partNum.length() == 7) partNum = "0" + partNum;
        if(partNum.length() != 8) return false;
        boolean isNumeric =  partNum.matches("[+-]?\\d*(\\.\\d+)?");
        if(!isNumeric) return false;
        String partDV = rut.substring(rut.indexOf("-")+1, rut.length());
        
        int suma = 0;
        int j = 3;
        for (int i = 0; i < partNum.length(); i++){
            if(j == 1) j = 7;
            suma += Integer.parseInt(String.valueOf(partNum.charAt(i))) * j;
            j--;
        }
        int resto = suma%11;
        int resDV = 11-resto;
        String dv = null;
        
        if(resDV > 0 && resDV < 10) dv = String.valueOf(resDV);
        if(resDV == 10) dv = "K";
        if(resDV == 11) dv = "0";
        
        return partDV.equalsIgnoreCase(dv);  
    }
    
    public static int contarCaracteres(String cadena, char caracter) {
        int posicion, contador = 0;
        posicion = cadena.indexOf(caracter);
        while (posicion != -1) {
            contador++;                               
            posicion = cadena.indexOf(caracter, posicion + 1);
        }
        return contador;
    }
    
    private void btnVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerVentasActionPerformed

    private void btnGestionarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGestionarProductosActionPerformed

    private void btn_cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarSesionActionPerformed
        this.dispose();
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_btn_cerrarSesionActionPerformed

    private void txtRutKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutKeyTyped
        
    }//GEN-LAST:event_txtRutKeyTyped

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarUsuario;
    private javax.swing.JButton btnGestionarProductos;
    private javax.swing.JButton btnVerUsuarios;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JButton btn_cerrarSesion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRut;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUser;
    private java.awt.Panel panel1;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JRadioButton rbBodeguero;
    private javax.swing.JRadioButton rbCajero;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
