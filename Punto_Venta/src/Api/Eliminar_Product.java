package Api;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class Eliminar_Product {
    private Conexion conexion;
     public Eliminar_Product(){
         this.conexion= new Conexion();
     }
     //Login normal
     public boolean eliminar(int id, String nombre){
        boolean cy = false;
        try (Connection conn = conexion.getConnection()) {
            String busqueda = "select * from Productos Where Id_Producto = ? and Nombre = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(busqueda)) {
                pstmt.setInt(1, id);
                pstmt.setString(2, nombre);
                try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                        cy = true;
                    }
                }
            }
            if(cy){
                String consulta = "delete from Productos Where Id_Producto = ? and Nombre = ?;";
                try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    pstmt.setInt(1, id);
                    pstmt.setString(2, nombre);
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
