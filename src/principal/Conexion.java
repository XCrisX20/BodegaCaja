package principal;

import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {

    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";// Driver@MachineName:Port/SID
    private final String USERID = "Cris";// USER ID
    private final String PASSW = "Semeolvido15";// PASSW
    
    public Connection realizarConexion(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection  conexion = DriverManager.getConnection(URL,USERID,PASSW);
            return conexion;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos", "Error de Conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    
    
    
}
