package Api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import Objetos.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class insertar_venta {
    private Conexion conexion;
     public insertar_venta(){
         this.conexion= new Conexion();
     }
     public void Agrgar(String id, String idP,String Precio,String Cantidad, String Des ){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO Detalles_Ventas values(?,?,?,?,?);";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, id);
                       pstmt.setString(2, idP);
                       pstmt.setString(3, Precio);
                       pstmt.setString(4, Cantidad);
                       pstmt.setString(5, Des);
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al registrar la compra: " + e.getMessage());
               }
     }
     public int buscar(){
        List<Ventas> ventas = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Ventas order by Id_Venta desc;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                String id = rs.getString("Id_Venta");
                String id_E = rs.getString("Id_Empleado");
                String Fec = rs.getString("Fecha_Venta");
                String Caja= rs.getString("Caja");
                String total = rs.getString("Vendido");

                Ventas producto = new Ventas(id, id_E, Fec, Caja, total); 
                ventas.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        String x;
        if(ventas.isEmpty()) x = "1"; 
        else  x = ventas.getLast().getId();
        int a = Integer.parseInt(x);
        return ventas.size();
     }
     public void Agrgarv(String Id_E, String fech, String caja, String vendido){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO Ventas (Id_Empleado, Fecha_Venta, Caja, Vendido)values(?,?,?,?);";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, Id_E);
                       pstmt.setString(2, fech);
                       pstmt.setString(3, caja);
                       pstmt.setString(4, vendido);
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al registrar la compra: " + e.getMessage());
               }
     }
     public void Actualizar(String Id, String v){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "UPDATE Ventas SET Vendido = ? WHERE Id_Venta = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, v);
                       pstmt.setString(2, Id);
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al registrar la compra: " + e.getMessage());
               }
     }
}
