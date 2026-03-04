public class Contenedor {
    private int id;
    private String origen;
    private double peso; // 
    private String tipo; // 

    public Contenedor(int id, String origen, double peso, String tipo) {
        this.id = id;
        this.origen = origen;
        this.peso = peso;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigen(String o) {
        this.origen = o;
    }

    public void setPeso(double p) {
        this.peso = p;
    }

    public void setTipo(String t) {
        this.tipo = t;
    }

    @Override
    public String toString() {
        return "Contenedor{id=" + id + ", origen='" + origen + "', peso=" + peso + "t, tipo='" + tipo + "'}";
    }
}