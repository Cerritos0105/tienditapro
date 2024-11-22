package Api;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class LogonApi {
     private Conexion conexion;
     public LogonApi(){
         this.conexion= new Conexion();
     }
     //Login normal
     public boolean login(String user, String pas){
       boolean cy = false;
               try (Connection conn = conexion.getConnection()) {
                   //se crea el string que hace la consulta
                   String consulta = "SELECT * FROM Empleados where Usuario = sha1(?) AND contrasena=sha1(?);";
                   //se intenta mandar la consulta
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, user);
                       pstmt.setString(2, pas);
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 cy = true;
                            }
                        }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   //error de contraseña
                   System.out.println("Usuario o contraseña incorrecta" + e.getMessage());
               }
               //se regresa el resultado de la consulta
               return cy;
     }
      //se verifica si el usuario ya existe en caso de que intente registrarse con el mismo correo
      public boolean login2(String User){
       boolean cy = false;
               try (Connection conn = conexion.getConnection()) {
                   String consulta = "SELECT * FROM Empleados where Usuario = sha1(?);";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, User);
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 cy = true;
                            }
                        }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(null, "El email no se encuentra registrado");
               }
               return cy;
     }
      
     public boolean login3(){
         boolean cy= false;
         try (Connection conn = conexion.getConnection()) {
                   //se crea el string que hace la consulta
                   String consulta = "SELECT * FROM Empleados where cargo='Gerente';";
                   //se intenta mandar la consulta
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 cy = true;
                            }
                        }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   //error de contraseña
                   System.out.println("Usuario o contraseña incorrecta" + e.getMessage());
               }
         return cy;
     }
     
}