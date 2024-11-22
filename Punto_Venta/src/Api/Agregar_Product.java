package Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
public class Agregar_Product {
    private Conexion conexion;
     public Agregar_Product(){
         this.conexion= new Conexion();
     }
     public void Agregar(int id_categoria, String nombre, String descripcion, double precio, int cantidad){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO Productos (Id_Categoria, Nombre, Descripción, Precio, Cantidad) VALUES (?, ?, ?, ?, ?);";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, id_categoria);
                       pstmt.setString(2, nombre);
                       pstmt.setString(3, descripcion);
                       pstmt.setDouble(4, precio);
                       pstmt.setInt(5, cantidad);
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al registrar el usuario: " + e.getMessage());
               }
     }
}
