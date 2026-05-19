public class Evaluacion {
    protected double nota;
    protected double porcentaje;

    public Evaluacion(double nota, double porcentaje) {
        this.nota = nota;
        this.porcentaje = porcentaje;
    }

    public double calcular() {
        return nota * porcentaje;
    }
}