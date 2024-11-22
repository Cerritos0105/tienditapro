
package Objetos;
public class Usuaio {
    private String id;
    private String Nombre;
    private String Apellido;
    private String cargo;
    private String User;
    public Usuaio(String id, String Nombre, String Apellido, String cargo) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.cargo = cargo;
    }

    public Usuaio(String User) {
        this.User = User;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
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

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
