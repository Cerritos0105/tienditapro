package Api;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Eliminar_User {
    private Conexion conexion;
     public Eliminar_User(){
         this.conexion= new Conexion();
     }
     //Login normal
     public boolean eliminar(int id, String nombre, String apellido){
        boolean cy = false;
        try (Connection conn = conexion.getConnection()) {
            String busqueda = "select * from Empleados Where Id_Empleado = ? and Nombre = ? and Apellido = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(busqueda)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, nombre);
                pstmt.setString(3, apellido);
                try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                        cy = true;
                    }
                }
            }
            if(cy){
                String consulta = "delete from Empleados Where Id_Empleado = ? and Nombre = ? and Apellido = ?;";
                try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    pstmt.setInt(1, id);
                    pstmt.setString(2, nombre);
                    pstmt.setString(3, apellido);
                    pstmt.executeUpdate();
                    cy = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Usuario no existe " + e.getMessage());
        }
        return cy;
     }
}
