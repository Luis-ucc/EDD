public class Contenedor {
    private int id;
    private String origen;
    private double peso;

    public Contenedor(int id, String origen, double peso) {
        this.id = id;
        this.origen = origen;
        this.peso = peso;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setOrigen(String o) {
        this.origen = o;
    }

    public void setPeso(double p) {
        this.peso = p;
    }

    @Override
    public String toString() {
        return "Contenedor{id=" + id + ", origen='" + origen + "', peso=" + peso + "t}";
    }
}