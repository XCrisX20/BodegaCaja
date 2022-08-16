
package puestos;

import modelos.Producto;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import principal.Conexion;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class RealizarVenta extends javax.swing.JFrame {
    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    private String rut_empleado;
    private ArrayList<Producto> productos_lista = new ArrayList<>();
    Timestamp fecha_guardar;
    int idVenta = 0;
    int xMouse;
    int yMouse;
    
    
    public RealizarVenta(String rut_empleado) {
        this.rut_empleado = rut_empleado;
        initComponents();
        llenarTablaPendientes();
        llenarTabla();
        txtCantidad.setText("1");
        llenarComboBox();
        agregarBuscador();
        configurarFecha_Hora();
    }
    
    public RealizarVenta() {}

    
    private void llenarTablaPendientes(){
        DefaultTableModel mdl = (DefaultTableModel) tblVentasPendientes.getModel();
        mdl.setRowCount(0);
        String cons = "Select * from ventas where estado_venta = 'P'";
        String tv = "", tp = "", estado_venta = "";
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                if(rs.getString("tipo_venta").equalsIgnoreCase("P")) tv = "Presencial";
                if(rs.getString("tipo_venta").equalsIgnoreCase("E")) tv = "Encargo";
                if(rs.getString("tipo_pago").equalsIgnoreCase("E")) tp = "Efectivo";
                if(rs.getString("tipo_pago").equalsIgnoreCase("D")) tp = "Debito";
                if(rs.getString("estado_venta").equalsIgnoreCase("A")) estado_venta = "Aprobado";
                if(rs.getString("estado_venta").equalsIgnoreCase("C")) estado_venta = "Cancelado";
                if(rs.getString("estado_venta").equalsIgnoreCase("P")) estado_venta = "Pendiente";
                
                mdl.addRow(new Object[]{
                    rs.getInt("id_venta"), rs.getString("fecha_hora"), tv, tp, rs.getString("telefono"), rs.getString("nombre_pedido"),
                    rs.getInt("total_pago"),estado_venta
                });
            }
            tblVentasPendientes.setModel(mdl);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al obtener datos de las ventas", "Error de obtencion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void llenarTabla(){
        int suma = 0;
        txtTotal.setText("$ 0");
        DefaultTableModel mdl = (DefaultTableModel) tblProductos_venta.getModel();
        mdl.setRowCount(0);
        for(Producto p: productos_lista){
            mdl.addRow(new Object[]{
                p.getId_producto(), p.getNombre(), p.getCantidad(), p.getPrecio(), p.getTotal()
            });
            suma += p.getTotal();
            txtTotal.setText("$ " + String.valueOf(suma));
            tblProductos_venta.setModel(mdl);
        }
        
        
        
    }
    public static Timestamp convert(Date date) {
        return new Timestamp(date.getTime());
    }
    
    private void configurarFecha_Hora(){
        String dateTime = DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm").format(LocalDateTime.now());
        txtFecha.setText(dateTime);
        
        //Date utilDate = new Date();
        //fecha_guardar = convert(utilDate);
    }
    private void agregarBuscador(){
        AutoCompleteDecorator.decorate(cmbProductos);
    }
    
    private void llenarComboBox(){
        String cons = "Select * from producto";
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(cons);
            while(rs.next()){
                cmbProductos.addItem(rs.getString("nombre"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener los productos");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTipoVenta = new javax.swing.ButtonGroup();
        btnTipoPago = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jdAgregarProducto = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos_venta = new javax.swing.JTable();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        jdVentasPendientes = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentasPendientes = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        cmbEstadoVenta = new javax.swing.JComboBox<>();
        btnEstadoVenta = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rbPresencial = new javax.swing.JRadioButton();
        rbEncargo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rbEfectivo = new javax.swing.JRadioButton();
        rbDebito = new javax.swing.JRadioButton();
        btnAgregarProductos = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNombrePedido = new javax.swing.JTextField();
        btnAgregarCola = new javax.swing.JButton();
        btnVerVentas = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jdAgregarProducto.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdAgregarProducto.setTitle("AgregarProductos");
        jdAgregarProducto.setBackground(new java.awt.Color(86, 101, 115));
        jdAgregarProducto.setResizable(false);
        jdAgregarProducto.setSize(new java.awt.Dimension(420, 450));
        jdAgregarProducto.setType(java.awt.Window.Type.POPUP);

        jPanel4.setBackground(new java.awt.Color(86, 101, 115));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Seleccione un Producto");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, 127, -1));

        tblProductos_venta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Nombre", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos_venta);
        if (tblProductos_venta.getColumnModel().getColumnCount() > 0) {
            tblProductos_venta.getColumnModel().getColumn(0).setResizable(false);
            tblProductos_venta.getColumnModel().getColumn(1).setResizable(false);
            tblProductos_venta.getColumnModel().getColumn(2).setResizable(false);
            tblProductos_venta.getColumnModel().getColumn(3).setResizable(false);
            tblProductos_venta.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 380, 158));

        jPanel4.add(cmbProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 22, 180, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cantidad");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, 78, -1));
        jPanel4.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 59, 100, -1));

        btnAgregar.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 100, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Productos Agregados");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total: ");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 40, 20));

        txtTotal.setEnabled(false);
        jPanel4.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 360, 110, -1));

        btnEliminar.setBackground(new java.awt.Color(40, 105, 133));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.setBorder(null);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 130, 30));

        javax.swing.GroupLayout jdAgregarProductoLayout = new javax.swing.GroupLayout(jdAgregarProducto.getContentPane());
        jdAgregarProducto.getContentPane().setLayout(jdAgregarProductoLayout);
        jdAgregarProductoLayout.setHorizontalGroup(
            jdAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
        jdAgregarProductoLayout.setVerticalGroup(
            jdAgregarProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        jdVentasPendientes.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jdVentasPendientes.setResizable(false);
        jdVentasPendientes.setSize(new java.awt.Dimension(650, 450));
        jdVentasPendientes.setType(java.awt.Window.Type.POPUP);

        jPanel5.setBackground(new java.awt.Color(86, 101, 115));
        jPanel5.setPreferredSize(new java.awt.Dimension(650, 450));

        tblVentasPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Tipo Venta", "Tipo Pago", "Telefono", "Nombre Pedido", "Total", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVentasPendientes);
        if (tblVentasPendientes.getColumnModel().getColumnCount() > 0) {
            tblVentasPendientes.getColumnModel().getColumn(0).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(1).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(2).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(3).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(4).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(5).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(6).setResizable(false);
            tblVentasPendientes.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Ventas Pendientes");

        cmbEstadoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pendiente", "Aprobado", "Cancelado" }));

        btnEstadoVenta.setBackground(new java.awt.Color(40, 105, 133));
        btnEstadoVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadoVenta.setText("Cambiar Estado Venta");
        btnEstadoVenta.setBorder(null);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstadoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jdVentasPendientesLayout = new javax.swing.GroupLayout(jdVentasPendientes.getContentPane());
        jdVentasPendientes.getContentPane().setLayout(jdVentasPendientesLayout);
        jdVentasPendientesLayout.setHorizontalGroup(
            jdVentasPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jdVentasPendientesLayout.setVerticalGroup(
            jdVentasPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 500));

        jPanel1.setBackground(new java.awt.Color(86, 101, 115));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Realizar Venta");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 343, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(40, 105, 133));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha - Hora: ");

        txtFecha.setForeground(new java.awt.Color(255, 255, 255));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(null);
        txtFecha.setEnabled(false);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tipo Venta:");

        rbPresencial.setBackground(new java.awt.Color(40, 105, 133));
        btnTipoVenta.add(rbPresencial);
        rbPresencial.setForeground(new java.awt.Color(255, 255, 255));
        rbPresencial.setSelected(true);
        rbPresencial.setText("Presencial");

        rbEncargo.setBackground(new java.awt.Color(40, 105, 133));
        btnTipoVenta.add(rbEncargo);
        rbEncargo.setForeground(new java.awt.Color(255, 255, 255));
        rbEncargo.setText("Encargo");
        rbEncargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEncargoActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo Pago:");

        rbEfectivo.setBackground(new java.awt.Color(40, 105, 133));
        btnTipoPago.add(rbEfectivo);
        rbEfectivo.setForeground(new java.awt.Color(255, 255, 255));
        rbEfectivo.setSelected(true);
        rbEfectivo.setText("Efectivo");

        rbDebito.setBackground(new java.awt.Color(40, 105, 133));
        btnTipoPago.add(rbDebito);
        rbDebito.setForeground(new java.awt.Color(255, 255, 255));
        rbDebito.setText("Debito");

        btnAgregarProductos.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregarProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProductos.setText("Agregar / ver Productos");
        btnAgregarProductos.setBorder(null);
        btnAgregarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductosActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Telefono:");

        jTextField1.setText("+569");
        jTextField1.setEnabled(false);

        txtTelefono.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtTelefonoInputMethodTextChanged(evt);
            }
        });
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Nombre Pedido:");

        txtNombrePedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombrePedidoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbPresencial))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rbEfectivo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDebito)
                            .addComponent(rbEncargo)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addComponent(btnAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTelefono))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombrePedido)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbPresencial)
                    .addComponent(rbEncargo))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbEfectivo)
                    .addComponent(rbDebito))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombrePedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnAgregarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 330, 300));

        btnAgregarCola.setBackground(new java.awt.Color(40, 105, 133));
        btnAgregarCola.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCola.setText("Agregar a Cola de Ventas");
        btnAgregarCola.setBorder(null);
        btnAgregarCola.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarColaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCola, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 150, 40));

        btnVerVentas.setBackground(new java.awt.Color(40, 105, 133));
        btnVerVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVerVentas.setText("Ver ventas en Cola");
        btnVerVentas.setBorder(null);
        btnVerVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerVentasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVerVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void rbEncargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEncargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbEncargoActionPerformed

    private void btnAgregarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductosActionPerformed
        jdAgregarProducto.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductosActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(txtCantidad.getText().equals("") || Integer.parseInt(txtCantidad.getText()) == 0){
            JOptionPane.showMessageDialog(null, "La cantidad no debe estar Vacia","Error al intentar agregar", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String producto = (String) cmbProductos.getSelectedItem();
        Producto prod = new Producto();
        try{
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("Select * from producto where nombre = '"+producto+"'");
            boolean existe = false;
            if(rs.next()){
                for(Producto e: productos_lista){
                    if(e.getId_producto() == rs.getInt("id_producto")){
                        existe = true;
                        e.setCantidad(e.getCantidad() + Integer.parseInt(txtCantidad.getText()));
                        e.setTotal(e.getCantidad() * rs.getInt("precio"));
                        llenarTabla();
                    }
                }
                if(!existe){
                    prod.setId_producto(rs.getInt("id_producto"));
                    prod.setNombre(rs.getString("nombre"));
                    prod.setDescripcion(rs.getString("descripcion"));
                    prod.setCantidad(Integer.parseInt(txtCantidad.getText()));
                    prod.setPrecio(rs.getInt("precio"));
                    prod.setTotal(rs.getInt("precio") * prod.getCantidad());
                    productos_lista.add(prod);
                }
                llenarTabla();
            }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Obtener Datos del Producto", "Error al obtener Producto",JOptionPane.ERROR);
        }
        llenarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if(tblProductos_venta.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Error de seleccion", JOptionPane.WARNING_MESSAGE);
            return;
        }
        productos_lista.remove(tblProductos_venta.getSelectedRow());
        llenarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregarColaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarColaActionPerformed
        if(productos_lista.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han Asociado Productos a la venta","Venta sin productos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String tv = "";
        String tp = "";
        if(rbEncargo.isSelected()) tv = "E";
        if(rbPresencial.isSelected()) tv = "P";
        if(rbEfectivo.isSelected()) tp = "E";
        if(rbDebito.isSelected()) tv = "D";
        String estadoVenta = "P";
        
        String valor_pagar = txtTotal.getText().substring(txtTotal.getText().indexOf("$")+1).trim();
        int totalPagar = Integer.parseInt(valor_pagar);

        String cons = "Insert into ventas (fecha_hora, tipo_venta, total_pago, tipo_pago, rut_empleado, telefono, nombre_pedido, estado_venta)"
                + "values(CAST(sysdate AS TIMESTAMP),'"+tv+"',"+totalPagar+",'"+tp+"','"+rut_empleado+"','"+txtTelefono.getText()+"','"+txtNombrePedido.getText()+"','"+estadoVenta+"')";
        
        //ingresar la venta
        try{
            Statement stm = conn.createStatement();
            stm.executeUpdate(cons);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al Ingresar la Venta "+ex, "Error de Insercion", JOptionPane.ERROR_MESSAGE);
        
        }
        
        //obtener la ultima venta generada
        String cons2 = "Select max(id_venta) as id from ventas";
        try{
            Statement stm2 = conn.createStatement();
            ResultSet rs = stm2.executeQuery(cons2);
            if(rs.next()){
                idVenta = rs.getInt("id");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener la ultima venta "+ex, "Error de obtencion", JOptionPane.ERROR_MESSAGE);
        }
        //Guardar Registros de los productos de la venta
        if (idVenta != 0){
           String cons3 = "";
            for(Producto e: productos_lista){
                cons3 = "Insert into productos_venta (id_producto, id_venta, cantidad)"
                    + "values("+e.getId_producto()+","+idVenta+","+e.getCantidad()+")";
                try{
                    Statement stm3 = conn.createStatement();
                    stm3.executeUpdate(cons3);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al Ingresar el Producto asociado a la venta "+ex, "Error de Insercion", JOptionPane.ERROR_MESSAGE);
                }
            } 
        }
        
        
        productos_lista.clear();
        llenarTabla();
        configurarFecha_Hora();
        rbEfectivo.setSelected(true);
        rbPresencial.setSelected(true);
        txtTelefono.setText("");
        txtNombrePedido.setText("");
        txtTelefono.setRequestFocusEnabled(true);
        idVenta = 0;
        
        JOptionPane.showMessageDialog(null, "La Venta se Creo Exitosamente, Se agrego a la Fila","Venta Creada", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnAgregarColaActionPerformed

    private void btnVerVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerVentasActionPerformed
        jdVentasPendientes.setVisible(true);
    }//GEN-LAST:event_btnVerVentasActionPerformed

    private void txtNombrePedidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombrePedidoKeyTyped
        int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = key >= 97 && key <= 122;
        boolean espacio = key == 32;

         if (!(minusculas || mayusculas || espacio))
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombrePedidoKeyTyped

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        if(txtTelefono.getText().length() >= 8){
            evt.consume();
        }else{
            int key = evt.getKeyChar(); 
            boolean numeros = key >= 48 && key <= 57;   
            if (!numeros)evt.consume();
        }
        
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtTelefonoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtTelefonoInputMethodTextChanged
        
    }//GEN-LAST:event_txtTelefonoInputMethodTextChanged

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCola;
    private javax.swing.JButton btnAgregarProductos;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEstadoVenta;
    private javax.swing.ButtonGroup btnTipoPago;
    private javax.swing.ButtonGroup btnTipoVenta;
    private javax.swing.JButton btnVerVentas;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbEstadoVenta;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JDialog jdAgregarProducto;
    private javax.swing.JDialog jdVentasPendientes;
    private javax.swing.JRadioButton rbDebito;
    private javax.swing.JRadioButton rbEfectivo;
    private javax.swing.JRadioButton rbEncargo;
    private javax.swing.JRadioButton rbPresencial;
    private javax.swing.JTable tblProductos_venta;
    private javax.swing.JTable tblVentasPendientes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombrePedido;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
