public class Manifiesto {
    private String ID;
    private double peso;
    private int Prioridad;

    public Manifiesto(String ID, double peso, int Prioridad) {
        this.ID = ID;
        this.peso = peso;
        this.Prioridad = Prioridad;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int prioridad) {
        Prioridad = prioridad;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Peso: %.2f | Prioridad: %d", ID, peso, Prioridad);
    }


}
