
package sql;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * Clase de prueba de conexión con una base de datos MySQL
 */
public class conee {
    
    /** 
     * Crea una instancia de la clase MySQL y realiza todo el código 
     * de conexión, consulta y muestra de resultados.
     */
    public conee() 
    {
        // Se mete todo en un try por los posibles errores de MySQL
        try
        {
          
            // Se crea un Statement, para realizar la consulta
            try ( // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
                    var conexion = DriverManager.getConnection ("jdbc:mysql://localhost/pruebas","root","") )
            {
                // Se crea un Statement, para realizar la consulta
                Statement s = conexion.createStatement();
                // Se realiza la consulta. Los resultados se guardan en el
                // ResultSet rs
                ResultSet rs = (s.executeQuery ("Select * from tblusuarios"));
                
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (rs.next()) 
                
                {
                 System.out.println (rs.getString ("nombre"));   
                }
                ResultSet ss = (s.executeQuery ("Select * from yola"));
                
                // Se recorre el ResultSet, mostrando por pantalla los resultados.
                while (ss.next()) 
                
                {                  
                    System.out.println (ss.getString ("nombre"));
                 }
                // Se cierra la conexión con la base de datos.
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Método principal, instancia una clase conexion
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new conee();
    }
    
}
