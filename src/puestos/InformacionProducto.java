
package puestos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import principal.Conexion;


public class InformacionProducto extends javax.swing.JFrame {

    Conexion conn =  new Conexion();
    Connection conex = conn.realizarConexion();
    private final int idProducto;
    ArrayList<String> insumos;
    
    private String nomProd;
    private String desProd;
    private int precioProd;
    
    int xMouse;
    int yMouse;
    
    
    public InformacionProducto(int idProducto) {
        this.insumos = new ArrayList<>();
        this.idProducto = idProducto;
        initComponents();
        cargarDatosProductos();
        llenarLista();
        llenarComboBox();
    }
    
    private void llenarComboBox(){
        String cons = "Select * from Insumo";
        try{
            Statement stm = conex.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                cmbProductos.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            
        }
    }
    
    
    private void llenarLista(){
        DefaultListModel<String> modelo = new DefaultListModel<>();
        lstInsumos.setModel(modelo);
        try{
            String cons = "Select *  from insumos_productos where id_producto = "+idProducto;
            Statement stm = conex.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                int idInsumo = rs.getInt("id_insumo");
                insumos.add(String.valueOf(idInsumo));
            }
            for(String e: insumos){
                String cons2 = "select * from insumo where id_insumo = "+Integer.parseInt(e);
                Statement stm2 = conex.createStatement();
                ResultSet rs2 = stm2.executeQuery(cons2);
                
                if(rs2.next()){
                    modelo.addElement(rs2.getString("nombre"));
                    lstInsumos.setModel(modelo);
                }

            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista", "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    private void cargarDatosProductos(){
        try{
            String cons = "Select * from Producto where id_producto = "+idProducto;
            Statement stm = conex.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            if(rs.next()){
                nomProd = rs.getString("nombre");
                desProd = rs.getString("descripcion");
                precioProd = rs.getInt("precio");
                
                lblIdProducto.setText("ID: " +String.valueOf(idProducto));
                lblNombreProducto.setText("Producto: " +nomProd);
                lblPrecio.setText("Precio: $" +precioProd);
                
            }
            
            
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Obtener el Producto", "Error", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdAgregarInsumo = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlDatosProducto = new javax.swing.JPanel();
        lblIdProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstInsumos = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnDescartar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        jdAgregarInsumo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdAgregarInsumo.setTitle("Agregar Insumo");
        jdAgregarInsumo.setAlwaysOnTop(true);
        jdAgregarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdAgregarInsumo.setLocationByPlatform(true);
        jdAgregarInsumo.setModal(true);
        jdAgregarInsumo.setPreferredSize(new java.awt.Dimension(200, 200));
        jdAgregarInsumo.setResizable(false);
        jdAgregarInsumo.setSize(new java.awt.Dimension(450, 300));
        jdAgregarInsumo.setType(java.awt.Window.Type.POPUP);

        jPanel3.setBackground(new java.awt.Color(86, 101, 115));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Escoja un Insumo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escoja la Cantidad a Usar");

        btnCancelar.setBackground(new java.awt.Color(40, 105, 133));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(40, 105, 133));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorder(null);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 551, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdAgregarInsumoLayout = new javax.swing.GroupLayout(jdAgregarInsumo.getContentPane());
        jdAgregarInsumo.getContentPane().setLayout(jdAgregarInsumoLayout);
        jdAgregarInsumoLayout.setHorizontalGroup(
            jdAgregarInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdAgregarInsumoLayout.setVerticalGroup(
            jdAgregarInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(400, 400));

        jPanel1.setBackground(new java.awt.Color(86, 101, 115));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout pnlDatosProductoLayout = new javax.swing.GroupLayout(pnlDatosProducto);
        pnlDatosProducto.setLayout(pnlDatosProductoLayout);
        pnlDatosProductoLayout.setHorizontalGroup(
            pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(lblPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlDatosProductoLayout.setVerticalGroup(
            pnlDatosProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(pnlDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setViewportView(lstInsumos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 173, 242));

        jPanel2.setBackground(new java.awt.Color(40, 105, 133));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(40, 101, 115));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/arrowLeft.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Informacion de Producto");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contiene");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 70, 30));

        btnDescartar.setBackground(new java.awt.Color(40, 105, 133));
        btnDescartar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnDescartar.setForeground(new java.awt.Color(255, 255, 255));
        btnDescartar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/discard.png"))); // NOI18N
        btnDescartar.setText("Descartar un Insumo");
        btnDescartar.setBorder(null);
        btnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescartarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 190, 60));

        btnAgregar.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/add.png"))); // NOI18N
        btnAgregar.setText("Agregar un Insumo");
        btnAgregar.setBorder(null);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 180, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarActionPerformed
        int idInsumo = 0;
        if (lstInsumos.getSelectedIndex() == -1){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una sola fila", "Seleccion Incorrecta", JOptionPane.WARNING_MESSAGE);
        }else{
            String nombreInsumo = lstInsumos.getSelectedValue();
            String cons = "Select * from insumo where nombre = '"+nombreInsumo+"'";
            try{
                Statement stm = conex.createStatement();
                ResultSet rs = stm.executeQuery(cons);
                if(rs.next()){
                    idInsumo = rs.getInt("id_insumo");
                }
                
                if(idInsumo != 0){
                    int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar El Insumo "+nombreInsumo+"?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    switch(opcion){
                        case 0: 
                            String cons1 = "delete from insumos_productos where id_producto = "+idProducto+" and id_insumo = "+idInsumo;
                            Statement stm1 = conex.createStatement();
                            stm1.executeUpdate(cons1);
                            JOptionPane.showMessageDialog(null, "Se ha Borrado el Insumo "+nombreInsumo,"Insumo Borrado!", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        case 2: 
                            JOptionPane.showMessageDialog(null, "Has Cancelado el borrado", "Borrado Cancelado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                    }
                    
                    
                    
                    /*String cons1 = "delete from insumos_productos where id_producto = "+idProducto+" and id_insumo = "+idInsumo;
                    Statement stm1 = conex.createStatement();
                    stm1.executeUpdate(cons1);
                    JOptionPane.showMessageDialog(null, "Se ha Borrado el Insumo "+nombreInsumo,"Insumo Borrado!", JOptionPane.INFORMATION_MESSAGE);
                    */
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"No se pudieron obtener datos del insumo","Error al obtener datos",JOptionPane.ERROR);
            }
            
            
            
        }
    }//GEN-LAST:event_btnDescartarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jdAgregarInsumo.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String insumo = cmbProductos.getSelectedItem().toString().trim();
        int cantidad = Integer.parseInt(txtCantidad.getText().trim());
        
        String consInsumo = "Select * from insumo where nombre = '"+insumo+"'";
        int idInsumo = 0;
        try{
            Statement stm = conex.createStatement();
            ResultSet rs = stm.executeQuery(consInsumo);
            
            if(rs.next()){
                idInsumo = rs.getInt("id_insumo");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el insumo seleccionado","Error Seleccion", JOptionPane.ERROR);
        }
        
        if(idInsumo != 0){
            try{
                String cons = "Insert into insumos_productos values("+idInsumo+","+idProducto+","+cantidad+")";
                Statement stm1 = conex.createStatement();
                stm1.executeUpdate(cons);
                 JOptionPane.showMessageDialog(null, "Insumo Ingresado","Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "No se pudo Agregar el Insumo","Error Insercion", JOptionPane.ERROR);
            }
        }
        llenarLista();
        jdAgregarInsumo.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionProducto(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescartar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog jdAgregarInsumo;
    private javax.swing.JLabel lblIdProducto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JList<String> lstInsumos;
    private javax.swing.JPanel pnlDatosProducto;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables

}
