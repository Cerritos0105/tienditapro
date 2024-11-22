package Api;

import Objetos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Busca_Productos {
    private Conexion conexion;

    public Busca_Productos() {
        this.conexion = new Conexion();
    }

    public List<Producto> busca() {
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Productos order by Existencia;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                String id = rs.getString("Id_Producto");
                String nombre = rs.getString("Nombre");
                String cantidad = rs.getString("Existencia");
                String precio = rs.getString("Precio");

                Producto producto = new Producto(id, nombre, cantidad, precio); 
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        return productos;
    }
    public Producto busca_id(String id){
       Producto x=new Producto();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Productos where Id_Producto = ?;";
            String nombre;
            String cantidad;
            String precio;
            Statement stmn = conn.createStatement();
           try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1,id);
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 nombre = rs.getString("Nombre");
                                 cantidad = rs.getString("Existencia");
                                 precio = rs.getString("Precio");
                                 x = new Producto(id, nombre, cantidad, precio);
                            }
                        } 
                       int ggg = Integer.parseInt(id);
                       
                   } 
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        return x;
    }
    public int maxP() {
        List<Producto> productos = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Productos order by Existencia;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                String id = rs.getString("Id_Producto");
                String nombre = rs.getString("Nombre");
                String cantidad = rs.getString("Existencia");
                String precio = rs.getString("Precio");

                Producto producto = new Producto(id, nombre, cantidad, precio); 
                productos.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        return productos.size();
    }
}
