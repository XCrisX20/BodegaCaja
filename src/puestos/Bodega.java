
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

        panelBodega = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInsumos = new javax.swing.JTable();
        lblId = new javax.swing.JLabel();
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
        btnEliminar = new javax.swing.JButton();
        txtBuscarNombre = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        panel3 = new java.awt.Panel();
        lblId1 = new javax.swing.JLabel();
        panel4 = new java.awt.Panel();
        lblId2 = new javax.swing.JLabel();
        btnAgregarInsumo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bodega");

        panelBodega.setBackground(new java.awt.Color(180, 41, 55));
        panelBodega.setPreferredSize(new java.awt.Dimension(800, 600));
        panelBodega.setLayout(null);

        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        panelBodega.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(900, 10, 140, 30);

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

        panelBodega.add(jScrollPane1);
        jScrollPane1.setBounds(380, 110, 640, 360);

        lblId.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblId.setForeground(new java.awt.Color(255, 255, 255));
        lblId.setText("Agregar Nuevo Insumos");
        panelBodega.add(lblId);
        lblId.setBounds(30, 50, 200, 30);

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
        panelBodega.add(txtID);
        txtID.setBounds(380, 70, 140, 30);

        btnBuscar.setText("Buscar");
        panelBodega.add(btnBuscar);
        btnBuscar.setBounds(540, 70, 110, 30);

        panelDatos.setBackground(new java.awt.Color(140, 140, 140));
        panelDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelDatos.setEnabled(false);
        panelDatos.setName(""); // NOI18N

        lblNombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");

        lblTipo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblTipo.setText("Tipo Insumo");

        lblStockActual.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStockActual.setText("Stock Actual");

        lblStockCritico.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblStockCritico.setText("Stock Critico");

        lblUnidadMedida.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
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

        btnAgregar.setText("Agregar");
        btnAgregar.setPreferredSize(new java.awt.Dimension(70, 30));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
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

        panelBodega.add(panelDatos);
        panelDatos.setBounds(20, 160, 340, 320);

        panelBotones.setBackground(new java.awt.Color(140, 140, 140));

        btnEliminar.setText("Eliminar");
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
                .addGap(128, 128, 128)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        panelBodega.add(panelBotones);
        panelBotones.setBounds(590, 500, 420, 70);
        panelBodega.add(txtBuscarNombre);
        txtBuscarNombre.setBounds(730, 70, 140, 30);

        btnBuscar1.setText("Buscar");
        panelBodega.add(btnBuscar1);
        btnBuscar1.setBounds(890, 70, 110, 30);

        panel3.setBackground(new java.awt.Color(140, 140, 140));

        lblId1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblId1.setForeground(new java.awt.Color(255, 255, 255));
        lblId1.setText("ID");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addComponent(lblId1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblId1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBodega.add(panel3);
        panel3.setBounds(380, 30, 100, 30);

        panel4.setBackground(new java.awt.Color(140, 140, 140));

        lblId2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblId2.setForeground(new java.awt.Color(255, 255, 255));
        lblId2.setText("Nombre");

        javax.swing.GroupLayout panel4Layout = new javax.swing.GroupLayout(panel4);
        panel4.setLayout(panel4Layout);
        panel4Layout.setHorizontalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4Layout.createSequentialGroup()
                .addComponent(lblId2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panel4Layout.setVerticalGroup(
            panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblId2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelBodega.add(panel4);
        panel4.setBounds(730, 30, 100, 30);

        btnAgregarInsumo.setText("Agregar Nuevo Insumo");
        btnAgregarInsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInsumoActionPerformed(evt);
            }
        });
        panelBodega.add(btnAgregarInsumo);
        btnAgregarInsumo.setBounds(70, 100, 180, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBodega, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cmbTipoInsumo;
    private javax.swing.JComboBox<String> cmbUnidadMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblId1;
    private javax.swing.JLabel lblId2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblStockActual;
    private javax.swing.JLabel lblStockCritico;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUnidadMedida;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private javax.swing.JPanel panelBodega;
    private java.awt.Panel panelBotones;
    private java.awt.Panel panelDatos;
    private javax.swing.JTable tablaInsumos;
    private javax.swing.JTextField txtBuscarNombre;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStockActual;
    private javax.swing.JTextField txtStockCritico;
    // End of variables declaration//GEN-END:variables
}
