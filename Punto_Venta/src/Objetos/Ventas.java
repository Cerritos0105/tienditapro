package Objetos;
public class Ventas {
    private String id;
    private String idE;
    private String Fch;
    private String caja;
    private String Total;

    public Ventas(String id, String idE, String Fch, String caja, String Total) {
        this.id = id;
        this.idE = idE;
        this.Fch = Fch;
        this.caja = caja;
        this.Total = Total;
    }

    public Ventas(String id, String idE, String Fch, String Total) {
        this.id = id;
        this.idE = idE;
        this.Fch = Fch;
        this.Total = Total;
    }
    

    public Ventas() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdE() {
        return idE;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }

    public String getFch() {
        return Fch;
    }

    public void setFch(String Fch) {
        this.Fch = Fch;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }
    
}
