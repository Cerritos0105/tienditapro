package Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class transaccio {
    private Conexion conexion;
    private Busca_Productos bp = new Busca_Productos();
     public transaccio(){
         this.conexion= new Conexion();
     }
     public void iniciar(){
         try(Connection conn = conexion.getConnection()) {
                   //se crea el string que hace la consulta
                   String consulta = "start transaction;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
                   
         }catch (Exception e) {
                   e.printStackTrace();
         }
     }
     public void terminar(){
         try(Connection conn = conexion.getConnection()) {
                   //se crea el string que hace la consulta
                   String consulta = "commit;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
                   
         }catch (Exception e) {
                   e.printStackTrace();
         }
     }
}
