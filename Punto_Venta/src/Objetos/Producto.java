package Objetos;
public class Producto {
    private String id;
    private String Nombre;
    private String cantidad;
    private String precio;

    public Producto(String id, String Nombre, String cantidad, String precio) {
        this.id = id;
        this.Nombre = Nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public Producto(){
       
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
