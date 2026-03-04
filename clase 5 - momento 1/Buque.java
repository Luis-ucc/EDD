public class Buque {
    private int id;
    private String nombre;
    private String procedencia;
    private double pesoMaximo;

    public Buque(int id, String nombre, String procedencia, double pesoMaximo) {
        this.id = id;
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.pesoMaximo = pesoMaximo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProcedencia(String p) {
        this.procedencia = p;
    }

    public void setPesoMaximo(double p) {
        this.pesoMaximo = p;
    }

    @Override
    public String toString() {
        return "Buque{id=" + id + ", nombre='" + nombre + "', procedencia='" + procedencia + "', pesoMaximo="
                + pesoMaximo + "t}";
    }
}