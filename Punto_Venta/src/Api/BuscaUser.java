package Api;

import Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BuscaUser {
    private Conexion conexion;

    public BuscaUser() {
        this.conexion = new Conexion();
    }
    
    public List<Usuaio> busca(){
        List<Usuaio> Usuarios = new ArrayList<>();
         try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Empleados;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                String id = rs.getString("id_Empleado");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String cargo = rs.getString("Cargo");

                Usuaio producto = new Usuaio(id, nombre, apellido, cargo); 
                Usuarios.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Usuarios: " + e.getMessage());
        }
        return Usuarios;
    }
    public String buscar(String us) {
    Usuaio user = new Usuaio(us);
    try (Connection conn = conexion.getConnection()) {
        // Consulta SQL
        String consulta = "SELECT * FROM Empleados WHERE Usuario = sha1(?);";
        try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
            // Asignar el valor al parámetro
            pstmt.setString(1, us);
            
            // Ejecutar la consulta
            try (ResultSet rs = pstmt.executeQuery()) {
                // Procesar los resultados
                if (rs.next()) {
                    String id = rs.getString("id_Empleado");
                    user.setId(id);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al buscar Usuarios: " + e.getMessage());
    }
    return user.getId();
}

}
