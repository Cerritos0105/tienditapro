package Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
public class AgregarUser {
    private Conexion conexion;
     public AgregarUser(){
         this.conexion= new Conexion();
     }
     public void Agrgar(String Nombre, String Apellido, String Usuario,String Contrasena, String Ciudad, String fhN,  String Cargo, String Telefono){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO Empleados (Nombre,Apellido,Usuario, Contrasena, Ciudad, Fecha_Nacimiento, Cargo, Telefono) VALUES (?,?,sha1(?),sha1(?),?,?,?,?);";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, Nombre);
                       pstmt.setString(2, Apellido);
                       pstmt.setString(3, Usuario);
                       pstmt.setString(4, Contrasena);
                       pstmt.setString(5, Ciudad);
                       pstmt.setString(6, fhN);
                       pstmt.setString(7, Cargo);
                       pstmt.setString(8, Telefono);
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al registrar el usuario: " + e.getMessage());
               }
     }
}
