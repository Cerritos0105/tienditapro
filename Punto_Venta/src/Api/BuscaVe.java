package Api;
import Objetos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class BuscaVe {
    private Conexion conexion;

    public BuscaVe() {
        this.conexion = new Conexion();
    }
    public List<Ventas> busca() {
        List<Ventas> V = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Ventas order by Fecha_Venta;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                String id = rs.getString("Id_Venta");
                String IdE = rs.getString("Id_Empleado");
                String  fec = rs.getString("Fecha_Venta");
                String Tot = rs.getString("Vendido");

                Ventas v = new Ventas(id, IdE, fec, Tot); 
                V.add(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        return V;
    }
}
