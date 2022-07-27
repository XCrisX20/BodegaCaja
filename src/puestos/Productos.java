
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnVerProducto = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        pnlProductos.setBackground(new java.awt.Color(86, 101, 115));
        pnlProductos.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos Actuales");
        pnlProductos.add(jLabel1);
        jLabel1.setBounds(10, 10, 212, 29);

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

        pnlProductos.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 452, 260);

        btnVolver.setBackground(new java.awt.Color(40, 105, 133));
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/arrowLeft.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        pnlProductos.add(btnVolver);
        btnVolver.setBounds(358, 11, 118, 25);

        btnVerProducto.setBackground(new java.awt.Color(40, 105, 133));
        btnVerProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnVerProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/box.png"))); // NOI18N
        btnVerProducto.setText("Ver Producto");
        pnlProductos.add(btnVerProducto);
        btnVerProducto.setBounds(24, 375, 153, 41);

        btnEliminar.setBackground(new java.awt.Color(40, 105, 133));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        pnlProductos.add(btnEliminar);
        btnEliminar.setBounds(323, 375, 153, 40);
        pnlProductos.add(txtBuscarProducto);
        txtBuscarProducto.setBounds(20, 70, 340, 25);

        btnBuscar.setBackground(new java.awt.Color(40, 105, 133));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/search.png"))); // NOI18N
        pnlProductos.add(btnBuscar);
        btnBuscar.setBounds(370, 70, 100, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    // End of variables declaration//GEN-END:variables
}
