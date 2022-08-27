
package puestos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import principal.Conexion;
import principal.Login;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Image;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caja extends javax.swing.JFrame {
    Conexion conex = new Conexion();
    Connection conn = conex.realizarConexion();
    private String rut_empleado;
    int xMouse;
    int yMouse;
    DecimalFormat formato = new DecimalFormat("$ #,###");
    
    
    public Caja(String rut_empleado) {
        this.rut_empleado = rut_empleado;
        initComponents();
        llenarTabla();
    }

    public Caja() {
        initComponents();
        llenarTabla();
    }

    private void llenarTabla(){
        String cons = "Select * From Ventas Order By fecha_hora desc";
        DefaultTableModel mdl = (DefaultTableModel) tblVentas.getModel();
        mdl.setRowCount(0);
        String tv = "", tp = "", estado_venta = "";
        String total = "";
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
                
                //NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("cl","CL"));
                DecimalFormat formato = new DecimalFormat("$ #,###");
                total = formato.format(rs.getInt("total_pago"));
                
                mdl.addRow(new Object[]{
                    rs.getInt("id_venta"), rs.getString("fecha_hora"), tv, tp, total, estado_venta
                });
            }
            tblVentas.setModel(mdl);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "No se pudo obtener las ventas", "Error al obtener ventas", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        panelCaja = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnVerProductos = new javax.swing.JButton();
        btnNuevaVenta = new javax.swing.JButton();
        btnCerrarCaja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setSize(new java.awt.Dimension(850, 500));

        panelCaja.setBackground(new java.awt.Color(86, 101, 115));
        panelCaja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVentas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venta", "Fecha - Hora", "Tipo de Venta", "Tipo de Pago", "Total", "Estado Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVentas);
        if (tblVentas.getColumnModel().getColumnCount() > 0) {
            tblVentas.getColumnModel().getColumn(0).setResizable(false);
            tblVentas.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblVentas.getColumnModel().getColumn(1).setResizable(false);
            tblVentas.getColumnModel().getColumn(2).setResizable(false);
            tblVentas.getColumnModel().getColumn(3).setResizable(false);
            tblVentas.getColumnModel().getColumn(4).setResizable(false);
            tblVentas.getColumnModel().getColumn(5).setResizable(false);
        }

        panelCaja.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 840, 300));

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

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("CAJA");

        btnCerrarSesion.setBackground(new java.awt.Color(40, 105, 133));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerra sesion");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 605, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCaja.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 50));

        btnVerProductos.setBackground(new java.awt.Color(40, 105, 133));
        btnVerProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerProductos.setForeground(new java.awt.Color(255, 255, 255));
        btnVerProductos.setText("Ver productos");
        btnVerProductos.setBorder(null);
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });
        panelCaja.add(btnVerProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 160, 37));

        btnNuevaVenta.setBackground(new java.awt.Color(40, 105, 133));
        btnNuevaVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setBorder(null);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });
        panelCaja.add(btnNuevaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 160, 37));

        btnCerrarCaja.setBackground(new java.awt.Color(40, 105, 133));
        btnCerrarCaja.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarCaja.setText("Cerrar Caja");
        btnCerrarCaja.setBorder(null);
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });
        panelCaja.add(btnCerrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 440, 160, 37));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCaja, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Login log = new Login();
        log.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed
        this.dispose();
        RealizarVenta rv = new RealizarVenta(rut_empleado);
        rv.setVisible(true);
    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        this.dispose();
        Productos prd = new Productos();
        prd.setVisible(true);
    }//GEN-LAST:event_btnVerProductosActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed
        String dateTime = DateTimeFormatter.ofPattern("YYYY-MM").format(LocalDateTime.now()); //Devuelve Fecha formato 2022-08
        
        File fichero = new File("src/principal/rutaReportes.txt"); //buscamos la ruta donde guardar reportes
        if(!fichero.exists()) {
            JOptionPane.showMessageDialog(null, "No hay una ruta especificada para la creacion de los reportes, por favor configurela en ADMINISTRACION", "Configure la ruta para reportes", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        FileReader fr;
        String ruta = ""; //obtenemos la ruta
        try {
            fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            ruta = br.readLine();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Ruta no Encontrada","Error de ruta",JOptionPane.ERROR_MESSAGE);
            return;
        } catch (IOException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No se pudo leer el archivo","Error de lectura",JOptionPane.ERROR_MESSAGE);
            return;
        }
        //aca creamos ruta para el guardado de carpetas mensuales // c:/user/juan/documents/prueba/{{2022-08}}
        File fichero2 = new File(ruta+"/"+dateTime);
        
        if(!fichero2.exists()){ // si el fichero no existe, se procede a crearlo
            if(!fichero2.mkdir()){
                JOptionPane.showMessageDialog(null, "No se pudo crear el fichero especificado","Error al crear fichero",JOptionPane.ERROR_MESSAGE);
            }
        }else{ //si el fichero existe se guardan los archivos diarios en el
            String dateTime2 = DateTimeFormatter.ofPattern("MM-dd").format(LocalDateTime.now());
            File fichero3 = new File(ruta + "/" + dateTime + "/" + dateTime2+".pdf");
            
            Document documento = new Document();
            try{
                PdfWriter.getInstance(documento, new FileOutputStream(fichero3));
                
                documento.open();
                PdfPTable tabla = new PdfPTable(5);
                tabla.addCell("ID");
                tabla.addCell("Fecha");
                tabla.addCell("Tipo Pago");
                tabla.addCell("Total");
                tabla.addCell("Vendedor");
                
                String cons = "Select id_venta, fecha_hora, tipo_pago, total_pago, nombre_completo from ventas, empleadott where estado_venta = 'A' and ventas.rut_empleado = empleadott.rut_empleado";
                String total;
                try{
                    Statement stm = conn.createStatement();
                    ResultSet rs = stm.executeQuery(cons);
                    
                    while(rs.next()){
                        total = formato.format(rs.getInt("total_pago"));
                        tabla.addCell(String.valueOf(rs.getInt("id_venta")));
                        tabla.addCell(rs.getString("fecha_hora"));
                        if(rs.getString("tipo_pago").equalsIgnoreCase("E")){
                            tabla.addCell("Efectivo");
                        }else{
                            tabla.addCell("Debito");
                        }
                        tabla.addCell(total);
                        tabla.addCell(rs.getString("nombre_completo"));
                        
                        
                    }
                    
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Error al obtener los datos de las ventas", "Error de Obtencion", JOptionPane.ERROR_MESSAGE);
                }
                documento.add(tabla);
                
            }catch(DocumentException | FileNotFoundException ex){
                System.out.println(ex);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte Creado y Caja Cerrada Exitosamente!", "Caja Cerrada",JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    
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
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnVerProductos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelCaja;
    private javax.swing.JTable tblVentas;
    // End of variables declaration//GEN-END:variables
}
