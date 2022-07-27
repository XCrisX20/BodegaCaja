
package puestos;

import java.awt.*;
import java.sql.*;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import principal.Conexion;

public class Productos extends javax.swing.JFrame {

    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    int xMouse;
    int yMouse;
    //Colores
    private final Color color1 = Color.MAGENTA;
    private final Color color2 = Color.BLUE;
    public Productos() {
        initComponents();
        cargarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnVerProducto = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        pnlProductos.setBackground(new java.awt.Color(86, 101, 115));
        pnlProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
        }

        pnlProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 460, 280));

        btnVerProducto.setBackground(new java.awt.Color(40, 105, 133));
        btnVerProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnVerProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/box.png"))); // NOI18N
        btnVerProducto.setText("Ver Producto");
        btnVerProducto.setBorder(null);
        btnVerProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductoActionPerformed(evt);
            }
        });
        pnlProductos.add(btnVerProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 153, 40));

        btnEliminar.setBackground(new java.awt.Color(40, 105, 133));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        pnlProductos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 153, 40));
        pnlProductos.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 95, 340, 30));

        btnBuscar.setBackground(new java.awt.Color(40, 105, 133));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/search.png"))); // NOI18N
        pnlProductos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 95, 110, 30));

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

        btnVolver.setBackground(new java.awt.Color(40, 105, 133));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/arrowLeft.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos Actuales");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlProductos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 460, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Caja caja = new Caja();
        caja.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVerProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductoActionPerformed
        if (tblProductos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una sola fila", "Seleccion Incorrecta", JOptionPane.WARNING_MESSAGE);
        }else{
            DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
            String id = String.valueOf(mdl.getValueAt(tblProductos.getSelectedRow(), 0));
            
            InformacionProducto infProd = new InformacionProducto(Integer.parseInt(id));
            infProd.setVisible(true);
            
            
        }
    }//GEN-LAST:event_btnVerProductoActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    void cargarTabla(){
        
        DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
        mdl.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from producto");
            while(rs.next()){
                mdl.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),rs.getInt("precio")});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Puede mostrar los productos", "Error de seleccion", JOptionPane.ERROR);
        }
        
    }
    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Productos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVerProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
