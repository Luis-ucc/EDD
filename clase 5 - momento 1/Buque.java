public class Buque {
    private int id;
    private String nombre;
    private String procedencia;
    private int capacidadContenedores;

    public Buque(int id, String nombre, String procedencia, int capacidadContenedores) {
        this.id = id;
        this.nombre = nombre;
        this.procedencia = procedencia;
        this.capacidadContenedores = capacidadContenedores;
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

    public int getCapacidadContenedores() {
        return capacidadContenedores;
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

    public void setCapacidadContenedores(int c) {
        this.capacidadContenedores = c;
    }

    @Override
    public String toString() {
        return "Buque{id=" + id + ", nombre='" + nombre + "', procedencia='" + procedencia + "', capacidad="
                + capacidadContenedores + "}";
    }
}