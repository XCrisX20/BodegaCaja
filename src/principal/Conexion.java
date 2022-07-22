package principal;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Conexion {
    
    private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";// Driver@MachineName:Port/SID
    private final String USERID = getDatos()[0];
    private final String PASSW = getDatos()[1];
    
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
    
    public String[] getDatos(){
        String[] datos = new String[2];
        try {
            File doc = new File("src/principal/datos.txt");
            Scanner obj = new Scanner(doc);
            int i = 0;
            while (obj.hasNextLine()){
                datos[i] = obj.nextLine();
                i++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al recibir credenciales " + e);
        }
        
        return datos;
    }
    
    
}
