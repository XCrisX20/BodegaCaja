
package puestos;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import principal.Conexion;

public class Productos extends javax.swing.JFrame {

    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    DecimalFormat formato = new DecimalFormat("$ #,###");
    int idProducto = 0;
    int xMouse;
    int yMouse;
    ArrayList<String> insumos;
    //Colores
    public Productos() {
        insumos = new ArrayList<>();
        initComponents();
        evitarPegar(txtPrecioProducto);
        evitarPegar(txtCantidad);
        txtCantidad.setText("1");
        cargarTabla();
        llenarTablaInsumos();
        cargarDatosInfoProductos();
        llenarComboBox();
        cargarUnidadMedida();
        cmbProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarUnidadMedida();
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdInformacionProducto = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        pnlDatosProducto = new javax.swing.JPanel();
        lblIdProducto = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnDescartar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInsumos = new javax.swing.JTable();
        jdAgregarInsumo = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        lblUnidadMedida = new javax.swing.JLabel();
        jdAgregarProducto = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarProducto_ = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionProducto = new javax.swing.JTextArea();
        txtPrecioProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
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
        btnAgregarProducto = new javax.swing.JButton();

        jdInformacionProducto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdInformacionProducto.setTitle("Información del Producto");
        jdInformacionProducto.setPreferredSize(new java.awt.Dimension(550, 400));
        jdInformacionProducto.setResizable(false);
        jdInformacionProducto.setSize(new java.awt.Dimension(550, 400));
        jdInformacionProducto.setType(java.awt.Window.Type.POPUP);

        jPanel2.setBackground(new java.awt.Color(86, 101, 115));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(pnlDatosProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Contiene");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 70, 30));

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
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 180, 60));

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
        jPanel2.add(btnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, 190, 60));

        tblInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Insumo", "Unidad Medida", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblInsumos);
        if (tblInsumos.getColumnModel().getColumnCount() > 0) {
            tblInsumos.getColumnModel().getColumn(0).setResizable(false);
            tblInsumos.getColumnModel().getColumn(1).setResizable(false);
            tblInsumos.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 240, 240));

        javax.swing.GroupLayout jdInformacionProductoLayout = new javax.swing.GroupLayout(jdInformacionProducto.getContentPane());
        jdInformacionProducto.getContentPane().setLayout(jdInformacionProductoLayout);
        jdInformacionProductoLayout.setHorizontalGroup(
            jdInformacionProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdInformacionProductoLayout.setVerticalGroup(
            jdInformacionProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdAgregarInsumo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdAgregarInsumo.setTitle("Agregar Insumo");
        jdAgregarInsumo.setAlwaysOnTop(true);
        jdAgregarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jdAgregarInsumo.setLocationByPlatform(true);
        jdAgregarInsumo.setModal(true);
        jdAgregarInsumo.setPreferredSize(new java.awt.Dimension(500, 220));
        jdAgregarInsumo.setResizable(false);
        jdAgregarInsumo.setSize(new java.awt.Dimension(500, 220));
        jdAgregarInsumo.setType(java.awt.Window.Type.POPUP);

        jPanel4.setBackground(new java.awt.Color(86, 101, 115));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Escoja un Insumo");

        cmbProductos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cmbProductosInputMethodTextChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Escoja la Cantidad a Usar");

        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

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

        lblUnidadMedida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUnidadMedida.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdAgregarInsumoLayout = new javax.swing.GroupLayout(jdAgregarInsumo.getContentPane());
        jdAgregarInsumo.getContentPane().setLayout(jdAgregarInsumoLayout);
        jdAgregarInsumoLayout.setHorizontalGroup(
            jdAgregarInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jdAgregarInsumoLayout.setVerticalGroup(
            jdAgregarInsumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jdAgregarProducto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdAgregarProducto.setTitle("Agregar Producto");
        jdAgregarProducto.setPreferredSize(new java.awt.Dimension(500, 500));
        jdAgregarProducto.setSize(new java.awt.Dimension(500, 500));
        jdAgregarProducto.setType(java.awt.Window.Type.POPUP);

        jPanel3.setBackground(new java.awt.Color(86, 101, 115));

        btnAgregarProducto_.setText("Agregar");
        btnAgregarProducto_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProducto_ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(40, 105, 133));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Descripcion");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio");

        txtNombreProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreProductoKeyTyped(evt);
            }
        });

        txtDescripcionProducto.setColumns(20);
        txtDescripcionProducto.setLineWrap(true);
        txtDescripcionProducto.setRows(5);
        txtDescripcionProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionProductoKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcionProducto);

        txtPrecioProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioProductoKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ingresar un Producto Nuevo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPrecioProducto))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarProducto_, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarProducto_, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jdAgregarProductoLayout = new javax.swing.GroupLayout(jdAgregarProducto.getContentPane());
        jdAgregarProducto.getContentPane().setLayout(jdAgregarProductoLayout);
        jdAgregarProductoLayout.setHorizontalGroup(
            jdAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jdAgregarProductoLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jdAgregarProductoLayout.setVerticalGroup(
            jdAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(550, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(550, 550));

        pnlProductos.setBackground(new java.awt.Color(86, 101, 115));
        pnlProductos.setMinimumSize(new java.awt.Dimension(550, 550));
        pnlProductos.setPreferredSize(new java.awt.Dimension(550, 550));
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

        pnlProductos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 510, 300));

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
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlProductos.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 440, 153, 40));
        pnlProductos.add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 390, 30));

        btnBuscar.setBackground(new java.awt.Color(40, 105, 133));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/search.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlProductos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 110, 30));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
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

        pnlProductos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 50));

        btnAgregarProducto.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconos/add_product2.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        pnlProductos.add(btnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 153, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlProductos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboBox(){
        String cons = "Select * from Insumo";
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                cmbProductos.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudieron Cargar los insumos", "Error al cargar insumos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarUnidadMedida(){
        String nombreInsumo = (String) cmbProductos.getSelectedItem();
    
        String cons = "Select * from insumo where nombre = '"+nombreInsumo+"'";
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            if(rs.next()){
                lblUnidadMedida.setText(rs.getString("unidad_medida"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Obtener el Insumo", "Error de Obtencion",JOptionPane.ERROR_MESSAGE);
        }
    
    
    }
    
    
    private void cargarDatosInfoProductos(){
        if(idProducto == 0){
            return;
        }
        String cons = "Select * from producto where id_producto = "+idProducto;
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            if(rs.next()){
                lblIdProducto.setText("ID: " +String.valueOf(rs.getInt("id_producto")));
                lblNombreProducto.setText("Nombre: " + rs.getString("nombre"));
                lblPrecio.setText("Precio: " + formato.format(rs.getInt("precio")));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener datos del producto","Error de Obtencion", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    private void borrarDatosTabla(){
        DefaultTableModel modelo = (DefaultTableModel) tblInsumos.getModel();
        modelo.setRowCount(0);
        tblInsumos.setModel(modelo);
        
        DefaultTableModel mdl = (DefaultTableModel) tblInsumos.getModel();
    }
    
    private void llenarTablaInsumos(){
        if(idProducto == 0) return;
        borrarDatosTabla();
        DefaultTableModel modelo = (DefaultTableModel) tblInsumos.getModel();
        try{
            String cons = "Select *  from insumos_productos where id_producto = "+idProducto;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                int idInsumo = rs.getInt("id_insumo");
                insumos.add(String.valueOf(idInsumo));
            }
            
            for(String e: insumos){
                String cons2 = "select * from insumo, insumos_productos where insumo.id_insumo = insumos_productos.id_insumo and insumo.id_insumo = "+Integer.parseInt(e);
                Statement stm2 = conn.createStatement();
                ResultSet rs2 = stm2.executeQuery(cons2);
                
                if(rs2.next()){
                    modelo.addRow(new Object[] {
                        rs2.getString("nombre"), rs2.getString("unidad_medida"), rs2.getInt("stock_rest")
                    });
                    
                }

            }
            insumos.clear();
            tblInsumos.setModel(modelo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Cargar la Lista "+ex, "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
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
            idProducto = Integer.parseInt(String.valueOf(mdl.getValueAt(tblProductos.getSelectedRow(), 0)));
            cargarDatosInfoProductos();
            insumos.clear();
            llenarTablaInsumos();
            
            jdInformacionProducto.setVisible(true);
            
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

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        jdAgregarProducto.setVisible(true);
            
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(txtBuscarProducto.getText().isEmpty()){
            DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
            mdl.setRowCount(0);
            String precio;
            String cons_productos = "Select * from producto";
            try{
                Statement stm_productos = conn.createStatement();
                ResultSet rs_productos = stm_productos.executeQuery(cons_productos);
                while(rs_productos.next()){
                    precio = formato.format(rs_productos.getInt("precio"));
                    mdl.addRow(new Object[]{
                        rs_productos.getInt("id_producto"), rs_productos.getString("nombre"), rs_productos.getString("descripcion"), precio
                    });
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al obtener los productos", "Error de obtencion", JOptionPane.ERROR_MESSAGE);
            }
            
            return;
        }
        DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
        mdl.setRowCount(0);
        String textoBuscado = txtBuscarProducto.getText().trim().toLowerCase();  
        String cons = "Select * from producto where lower(nombre) like '"+textoBuscado+"%'";
        String precio;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            boolean entro = false;
            while(rs.next()){
                entro = true;
                precio = formato.format(rs.getInt("precio"));
                mdl.addRow(new Object[]{
                    rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("descripcion"), precio
                });
            }
            if(!entro){
                JOptionPane.showMessageDialog(null, "No existen productos asociados a esta busqueda", "Busqueda Fallida", JOptionPane.INFORMATION_MESSAGE);
                txtBuscarProducto.requestFocus();
                txtBuscarProducto.selectAll();
            }
            tblProductos.setModel(mdl);
        }catch(SQLException ex){
          JOptionPane.showMessageDialog(null, "Error al realizar la busqueda "+ex,"Productos no encontrados", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        jdAgregarInsumo.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescartarActionPerformed
        int idInsumo = 0;
        if(tblInsumos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una fila", "Seleccion Incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel mdl = (DefaultTableModel) tblInsumos.getModel();
        String nombreInsumo = String.valueOf(mdl.getValueAt(tblInsumos.getSelectedRow(), 0));
        String cons = "Select * from insumo where nombre = '"+nombreInsumo+"'";
        
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            if(rs.next()){
                idInsumo = rs.getInt("id_insumo");
            }

            if(idInsumo != 0){
                int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar El Insumo "+nombreInsumo+"?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                switch(opcion){
                    case 0:
                        String cons1 = "delete from insumos_productos where id_producto = "+idProducto+" and id_insumo = "+idInsumo;
                        Statement stm1 = conn.createStatement();
                        stm1.executeUpdate(cons1);
                        JOptionPane.showMessageDialog(null, "Se ha Borrado el Insumo "+nombreInsumo+" del producto","Insumo Borrado!", JOptionPane.INFORMATION_MESSAGE);
                        llenarTablaInsumos();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Has Cancelado el borrado", "Borrado Cancelado", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }

            }

        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"No se pudieron obtener datos del insumo","Error al obtener datos",JOptionPane.ERROR);
        }
    }//GEN-LAST:event_btnDescartarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        jdAgregarInsumo.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String insumo = cmbProductos.getSelectedItem().toString().trim();
        int cantidad = Integer.parseInt(txtCantidad.getText().trim());
        
        String consInsumo = "Select * from insumo where nombre = '"+insumo+"'";
        int idInsumo = 0;
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(consInsumo);

            if(rs.next()){
                idInsumo = rs.getInt("id_insumo");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener el insumo seleccionado","Error Seleccion", JOptionPane.ERROR);
        }
        boolean existe = false;
        if(idInsumo != 0){
            
            String consProv = "Select count(*) as cantidad from insumos_productos where id_producto = "+idProducto+" and id_insumo = "+idInsumo;
            
            try{
                Statement stmProv = conn.createStatement();
                ResultSet rsProv = stmProv.executeQuery(consProv);
                if(rsProv.next()){
                    if(rsProv.getInt("cantidad") != 0){
                        JOptionPane.showMessageDialog(null, "Ya Existe este Insumo en el producto Actual", "Insercion Fallida", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
                
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de Insumos "+ex, "Error de Obtencion", JOptionPane.ERROR_MESSAGE);
            }
            
            try{
                String cons = "Insert into insumos_productos values("+idInsumo+","+idProducto+","+cantidad+")";
                Statement stm1 = conn.createStatement();
                stm1.executeUpdate(cons);
                JOptionPane.showMessageDialog(null, "Insumo Ingresado","Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "No se pudo Agregar el Insumo","Error Insercion", JOptionPane.ERROR);
            }
        }
        jdAgregarInsumo.dispose();
        llenarTablaInsumos();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAgregarProducto_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProducto_ActionPerformed
        if(txtDescripcionProducto.getText().length() > 300){
            JOptionPane.showMessageDialog(null, "La descripcion contiene mas de 300 caracteres, por favor reduzca el contenido.", "Reducir el Contenido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(txtNombreProducto.getText().length() > 35){
            JOptionPane.showMessageDialog(null, "El nombre contiene mas de 35 caracteres, por favor reduzca el contenido.", "Reducir el Contenido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String nombre = txtNombreProducto.getText().trim();
        String descripcion = txtDescripcionProducto.getText().trim();
        int precio = Integer.parseInt(txtPrecioProducto.getText().trim());
        String cons = "Insert into producto(nombre, descripcion, precio) values('"+nombre+"','"+descripcion+"', "+precio+")";
        try{
            Statement stm = conn.createStatement();
            stm.executeUpdate(cons);
            JOptionPane.showMessageDialog(null, "Producto Ingresado", "Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
            borrarCampos();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Agregar Producto", "Error de Insercion", JOptionPane.ERROR);
        }
        cargarTabla();
    }//GEN-LAST:event_btnAgregarProducto_ActionPerformed

    private void txtPrecioProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioProductoKeyTyped
        if(txtPrecioProducto.getText().length() > 4){
            evt.consume();
            return;
        }
        int key = evt.getKeyChar(); 
        boolean numeros = key >= 48 && key <= 57;   
        if (!numeros)evt.consume();
        
        if(key == 9 || key == 10){
            evt.consume();
            String textoOriginal = txtPrecioProducto.getText().trim();
            txtPrecioProducto.setText(textoOriginal);
            btnAgregarProducto_.requestFocus();
        }
        
    }//GEN-LAST:event_txtPrecioProductoKeyTyped

    private void txtDescripcionProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionProductoKeyTyped
        if(txtDescripcionProducto.getText().length() > 299){
            int key = evt.getKeyChar();
            evt.consume();
            if(key == 9 || key == 10){
                evt.consume();
                String textoOriginal = txtDescripcionProducto.getText().trim();
                txtDescripcionProducto.setText(textoOriginal);
                txtPrecioProducto.requestFocus();
                txtPrecioProducto.selectAll();
            }
            return;
        }
        int key = evt.getKeyChar();
        if(key == 9 || key == 10){
            evt.consume();
            String textoOriginal = txtDescripcionProducto.getText().trim();
            txtDescripcionProducto.setText(textoOriginal);
            txtPrecioProducto.requestFocus();
            txtPrecioProducto.selectAll();
        }
    }//GEN-LAST:event_txtDescripcionProductoKeyTyped

    private void txtNombreProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreProductoKeyTyped
        if(txtNombreProducto.getText().length() > 34){
            evt.consume();
            int key = evt.getKeyChar();
            if(key == 9 || key == 10){
                evt.consume();
                String textoOriginal = txtNombreProducto.getText().trim();
                txtNombreProducto.setText(textoOriginal);
                txtDescripcionProducto.requestFocus();
                txtDescripcionProducto.selectAll();
            }
            return;
        }
        int key = evt.getKeyChar();
        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
        
        if(key == 9 || key == 10){
            evt.consume();
            String textoOriginal = txtNombreProducto.getText().trim();
            txtNombreProducto.setText(textoOriginal);
            txtDescripcionProducto.requestFocus();
            txtDescripcionProducto.selectAll();
        }
         
    }//GEN-LAST:event_txtNombreProductoKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblProductos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Fila", "Seleccion Incorrecta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
        idProducto = Integer.parseInt(String.valueOf(mdl.getValueAt(tblProductos.getSelectedRow(), 0)));
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar El Producto con id: "+idProducto+"?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            switch(opcion){
                case 0:
                    String cons = "select count(*) as cantidad from insumos_productos where id_producto = "+idProducto;
                    try{
                        Statement stm = conn.createStatement();
                        ResultSet rs = stm.executeQuery(cons);
                        if(rs.next()){
                            if(rs.getInt("cantidad") != 0){
                                JOptionPane.showMessageDialog(null, "No se puede Eliminar ya que aun hay insumos asociados a este producto", "No se pudo Eliminar", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error al Obtener los Insumos del Producto", "Error de obtencion", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    
                    String cons2 = "select count(*) as cantidad from productos_venta where id_producto = "+idProducto;
                    try{
                        Statement stm2 = conn.createStatement();
                        ResultSet rs2 = stm2.executeQuery(cons2);
                        if(rs2.next()){
                            if(rs2.getInt("cantidad") != 0){
                                JOptionPane.showMessageDialog(null, "No se puede Eliminar ya que hay ventas asociadas a este producto", "No se pudo Eliminar", JOptionPane.WARNING_MESSAGE);
                                break;
                            }
                        }
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error al Obtener ventas del Producto", "Error de obtencion", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    
                    String cons3 = "Delete from producto where id_producto = "+idProducto;
                    try{
                        Statement stm3 = conn.createStatement();
                        stm3.executeUpdate(cons3);
                        JOptionPane.showMessageDialog(null, "Producto Eliminado Correctamente!", "Borrado Exitoso",JOptionPane.INFORMATION_MESSAGE);
                        cargarTabla();
                    }catch(SQLException ex){
                        JOptionPane.showMessageDialog(null, "Error al intentar Eliminar el Producto, Intente mas Tarde", "Error de Borrado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        int key = evt.getKeyChar(); 
        boolean numeros = key >= 48 && key <= 57;   
        if (!numeros)evt.consume();
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void cmbProductosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cmbProductosInputMethodTextChanged
        
    }//GEN-LAST:event_cmbProductosInputMethodTextChanged

    public static void evitarPegar(JTextField campo) {
        InputMap map2 = campo.getInputMap(JTextField.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    private void borrarCampos(){
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        txtPrecioProducto.setText("");
        txtNombreProducto.requestFocus();
    }
    
    private void cargarTabla(){
        DefaultTableModel mdl = (DefaultTableModel) tblProductos.getModel();
        mdl.setRowCount(0);
        String precio;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from producto");
            
            while(rs.next()){
                precio = formato.format(rs.getInt("precio"));
                mdl.addRow(new Object[]{rs.getString("id_producto"), rs.getString("nombre"), rs.getString("descripcion"),precio});
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
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnAgregarProducto_;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescartar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVerProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JDialog jdAgregarInsumo;
    private javax.swing.JDialog jdAgregarProducto;
    private javax.swing.JDialog jdInformacionProducto;
    private javax.swing.JLabel lblIdProducto;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JPanel pnlDatosProducto;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JTable tblInsumos;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextArea txtDescripcionProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
