class Carga {
    private String id;
    private double peso; 
    private int prioridad; 
    private boolean peligroso;

    public Carga(String id, double peso, int prioridad, boolean peligroso) {
        this.id = id;
        this.peso = peso;
        this.prioridad = prioridad;
        this.peligroso = peligroso;
    }

    public String getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public boolean isPeligroso() {
        return peligroso;
    }

    public boolean requiereInspeccion() {
        return peligroso || prioridad == 1;
    }

    @Override
    public String toString() {
        return String.format("[%s | %.1f t | P%d%s]",
                id, peso, prioridad, peligroso ? " !" : "");
    }
}