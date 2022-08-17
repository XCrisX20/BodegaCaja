
package puestos;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import principal.Conexion;
import principal.Login;

public class Bodega extends javax.swing.JFrame {

    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    int xMouse;
    int yMouse;
    
    public Bodega() {
                initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        llenarTabla();
        tablaInsumos.setAutoCreateRowSorter(false);
        llenarCombo();
        this.setLocationRelativeTo(this);
    }

    
    void llenarCombo(){
        cmbTipoInsumo.removeAllItems();
        cmbUnidadMedida.removeAllItems();
        String[] tipos = {"Carnes", "Cereales", "Bebidas","Vegetales","Frutas","Lacteos"};
        String[] um = {"Litro", "MiliLitro", "Kilogramo", "Gramo","Unidad"};
        
        for (String e: tipos){
            cmbTipoInsumo.addItem(e);
        }
        for (String e : um){
            cmbUnidadMedida.addItem(e);
        }
    }
    
    void llenarTabla(){
        DefaultTableModel mdl = (DefaultTableModel) tablaInsumos.getModel();
        mdl.setRowCount(0);
        DefaultTableModel modelo = (DefaultTableModel) tablaInsumos.getModel();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from insumo");
            
            while (rs.next()){
                modelo.addRow(new Object[]{rs.getInt("id_insumo"), rs.getString("nombre"),rs.getString("tipo_insumo"),rs.getInt("stock_actual"),rs.getInt("stock_critico"),rs.getString("unidad_medida")});
            }
            tablaInsumos.setModel(modelo);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Conectar a la BD", "Error de Conexion", JOptionPane.ERROR);
        }
    }

    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdAjuste = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        panelBodega = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        panelDatos = new java.awt.Panel();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblStockActual = new javax.swing.JLabel();
        lblStockCritico = new javax.swing.JLabel();
        lblUnidadMedida = new javax.swing.JLabel();
        cmbUnidadMedida = new javax.swing.JComboBox<>();
        txtStockCritico = new javax.swing.JTextField();
        txtStockActual = new javax.swing.JTextField();
        cmbTipoInsumo = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelBotones = new java.awt.Panel();
        btnAjustes = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtBuscarNombre = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        btnAgregarInsumo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblId2 = new javax.swing.JLabel();
        lblId1 = new javax.swing.JLabel();

        jdAjuste.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdAjuste.setAlwaysOnTop(true);
        jdAjuste.setLocationByPlatform(true);
        jdAjuste.setModal(true);
        jdAjuste.setUndecorated(true);
        jdAjuste.setSize(new java.awt.Dimension(550, 380));
        jdAjuste.setType(java.awt.Window.Type.POPUP);

        jPanel2.setBackground(new java.awt.Color(86, 101, 115));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(40, 105, 133));

        jButton1.setBackground(new java.awt.Color(40, 105, 133));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Ajuste");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Stock");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Descripcion");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Aceptar");

        tfNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfNombre.setEnabled(false);
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Insumo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(jLabel4)
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jdAjusteLayout = new javax.swing.GroupLayout(jdAjuste.getContentPane());
        jdAjuste.getContentPane().setLayout(jdAjusteLayout);
        jdAjusteLayout.setHorizontalGroup(
            jdAjusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdAjusteLayout.setVerticalGroup(
            jdAjusteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bodega");
        setUndecorated(true);

        panelBodega.setBackground(new java.awt.Color(86, 101, 115));
        panelBodega.setPreferredSize(new java.awt.Dimension(800, 600));
        panelBodega.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaInsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Tipo", "Stock Actual", "Stock Critico", "Unidad Medida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaInsumos);
        if (tablaInsumos.getColumnModel().getColumnCount() > 0) {
            tablaInsumos.getColumnModel().getColumn(0).setResizable(false);
            tablaInsumos.getColumnModel().getColumn(1).setResizable(false);
            tablaInsumos.getColumnModel().getColumn(2).setResizable(false);
            tablaInsumos.getColumnModel().getColumn(3).setResizable(false);
            tablaInsumos.getColumnModel().getColumn(4).setResizable(false);
            tablaInsumos.getColumnModel().getColumn(5).setResizable(false);
        }

        panelBodega.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 640, 360));

        txtID.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtIDInputMethodTextChanged(evt);
            }
        });
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIDKeyTyped(evt);
            }
        });
        panelBodega.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 190, 30));

        btnBuscar.setBackground(new java.awt.Color(40, 105, 133));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBodega.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 120, 110, 30));

        panelDatos.setBackground(new java.awt.Color(40, 105, 133));
        panelDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDatos.setEnabled(false);
        panelDatos.setName(""); // NOI18N

        lblNombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre");

        lblTipo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(255, 255, 255));
        lblTipo.setText("Tipo Insumo");

        lblStockActual.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStockActual.setForeground(new java.awt.Color(255, 255, 255));
        lblStockActual.setText("Stock Actual");

        lblStockCritico.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStockCritico.setForeground(new java.awt.Color(255, 255, 255));
        lblStockCritico.setText("Stock Critico");

        lblUnidadMedida.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblUnidadMedida.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidadMedida.setText("Unidad medida");

        cmbUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtStockCritico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockCriticoKeyTyped(evt);
            }
        });

        txtStockActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockActualKeyTyped(evt);
            }
        });

        cmbTipoInsumo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoInsumoActionPerformed(evt);
            }
        });

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.setPreferredSize(new java.awt.Dimension(70, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(40, 105, 133));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbTipoInsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(cmbUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDatosLayout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblStockActual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblStockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lblUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBodega.add(panelDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 320));

        panelBotones.setBackground(new java.awt.Color(140, 140, 140));

        btnAjustes.setBackground(new java.awt.Color(40, 105, 133));
        btnAjustes.setForeground(new java.awt.Color(255, 255, 255));
        btnAjustes.setText("Ajustes");
        btnAjustes.setBorder(null);
        btnAjustes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjustes.setPreferredSize(new java.awt.Dimension(70, 30));
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(40, 105, 133));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(70, 30));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        panelBodega.add(panelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 530, 450, 60));
        panelBodega.add(txtBuscarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 200, 30));

        btnBuscar1.setBackground(new java.awt.Color(40, 105, 133));
        btnBuscar1.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar1.setText("Buscar");
        btnBuscar1.setBorder(null);
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panelBodega.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 110, 30));

        btnAgregarInsumo.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregarInsumo.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarInsumo.setText("Agregar Nuevo Insumo");
        btnAgregarInsumo.setBorder(null);
        btnAgregarInsumo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInsumoActionPerformed(evt);
            }
        });
        panelBodega.add(btnAgregarInsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 180, 40));

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

        btnCerrarSesion.setBackground(new java.awt.Color(40, 105, 133));
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Bodega");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 771, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelBodega.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 50));

        lblId2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblId2.setForeground(new java.awt.Color(255, 255, 255));
        lblId2.setText("Nombre");
        panelBodega.add(lblId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 70, 30));

        lblId1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblId1.setForeground(new java.awt.Color(255, 255, 255));
        lblId1.setText("ID");
        panelBodega.add(lblId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBodega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.setVisible(false);
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void cmbTipoInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoInsumoActionPerformed
        
    }//GEN-LAST:event_cmbTipoInsumoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        borrarCampos();
        panelDatos.setEnabled(false);
        panelBotones.setEnabled(true);
        txtID.setEnabled(true);
        txtBuscarNombre.setEnabled(true);
        btnAgregar.setText("Agregar");
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtStockActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockActualKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)evt.consume();
    }//GEN-LAST:event_txtStockActualKeyTyped

    private void txtStockCriticoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockCriticoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)evt.consume();
        
    }//GEN-LAST:event_txtStockCriticoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnAgregarInsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInsumoActionPerformed
        panelDatos.setEnabled(true);
        panelBotones.setEnabled(false);
        txtNombre.requestFocus();
    }//GEN-LAST:event_btnAgregarInsumoActionPerformed

    void borrarCampos(){
        txtNombre.setText("");
        cmbTipoInsumo.setSelectedIndex(0);
        txtStockActual.setText("");
        txtStockCritico.setText("");
        cmbUnidadMedida.setSelectedIndex(0);
    }
    
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (btnAgregar.getText().equals("Agregar")){
            String nombre = txtNombre.getText();
            String tipo_insumo = cmbTipoInsumo.getItemAt(cmbTipoInsumo.getSelectedIndex());
            String unidad_medida = cmbUnidadMedida.getItemAt(cmbUnidadMedida.getSelectedIndex());

            if (nombre.isEmpty() || txtStockActual.getText().equals("") || txtStockActual.getText() == null || txtStockCritico.getText().equals("") || txtStockCritico.getText() == null){
                JOptionPane.showMessageDialog(null, "No deben haber Campos Vacios", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }else{
                int stock_actual = Integer.parseInt(txtStockActual.getText());
                int stock_critico = Integer.parseInt(txtStockCritico.getText());
                String cons = "Insert into insumo (nombre, tipo_insumo, stock_actual, stock_critico, unidad_medida)"+
                    "values('"+nombre+"','"+tipo_insumo+"',"+stock_actual+","+stock_critico+",'"+unidad_medida+"')";
                try{
                    Statement stm = conn.createStatement();
                    stm.executeUpdate(cons);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "No se Pudo guardar", "Error de Guardado", JOptionPane.ERROR);
                }
                llenarTabla();
                borrarCampos();
                txtNombre.requestFocus();
            }
        }        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        
        if (tablaInsumos.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una sola fila", "Seleccion Incorrecta", JOptionPane.WARNING_MESSAGE);
        }else{
            DefaultTableModel mdl = (DefaultTableModel) tablaInsumos.getModel();
            String id = String.valueOf(mdl.getValueAt(tablaInsumos.getSelectedRow(), 0));
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas Seguro de Eliminar El Insumo con id: "+id+"?", "Eliminacion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
            switch(opcion){
                case 0:
                    String cons = "Delete from insumo where id_insumo = "+id;
                    try {
                        Statement stm = conn.createStatement();
                        stm.executeUpdate(cons);
                        JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente","Eliminacion Concretada", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "No se Pudo Eliminar", "Eliminacion Fallida", JOptionPane.ERROR);
                        break;
                    }
                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminacion Cancelada", "Eliminacion Cancelada",JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
        }
        llenarTabla();
        
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
        /*DefaultTableModel mdl = (DefaultTableModel) tablaInsumos.getModel();
        mdl.setRowCount(0);
        String cons = "Select * from insumo where nombre like '"+txtID.getText()+"%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                mdl.addRow(new Object[]{rs.getInt("id_insumo"), rs.getString("nombre"),rs.getString("tipo_insumo"),rs.getInt("stock_actual"),rs.getInt("stock_critico"),rs.getString("unidad_medida")});
            }    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Pudieron Cargar los Insumos", "Busqueda Fallida", JOptionPane.ERROR);         
        }*/
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtIDInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtIDInputMethodTextChanged
        
    }//GEN-LAST:event_txtIDInputMethodTextChanged

    private void txtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyTyped
        DefaultTableModel mdl = (DefaultTableModel) tablaInsumos.getModel();
        mdl.setRowCount(0);
        String cons = "Select * from insumo where nombre like '%"+txtID.getText()+"%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                mdl.addRow(new Object[]{rs.getInt("id_insumo"), rs.getString("nombre"),rs.getString("tipo_insumo"),rs.getInt("stock_actual"),rs.getInt("stock_critico"),rs.getString("unidad_medida")});
            }    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se Pudieron Cargar los Insumos", "Busqueda Fallida", JOptionPane.ERROR);         
        }
    }//GEN-LAST:event_txtIDKeyTyped

    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed
     jdAjuste.setVisible(true);
        
    }//GEN-LAST:event_btnAjustesActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    jdAjuste.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    jdAjuste.setVisible(false);      // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bodega().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarInsumo;
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbTipoInsumo;
    private javax.swing.JComboBox<String> cmbUnidadMedida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jdAjuste;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblStockActual;
    private javax.swing.JLabel lblStockCritico;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JPanel panelBodega;
    private java.awt.Panel panelBotones;
    private java.awt.Panel panelDatos;
    private javax.swing.JTable tablaInsumos;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStockActual;
    private javax.swing.JTextField txtStockCritico;
    // End of variables declaration//GEN-END:variables
}
