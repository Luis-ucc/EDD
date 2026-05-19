import java.util.*;

public class Estudiante extends Persona {
    int semestre;
    Double[][] notas = new Double[10][20];
    ArrayList<String> materiasAprobadas = new ArrayList<>();

    public Estudiante(String nombre, String id, int semestre, String email) {
        super(nombre, id, email);
        this.semestre = semestre;
    }

    @Override

    public void mostrarInformacion() {
        System.out.println("=== ESTUDIANTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Semestre: " + semestre);
    }

    public void registrarNota(int semestre, int materia, double nota) {
        notas[semestre][materia] = nota;
    }

    public double promedioSemestre(int semestre) {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < 20; i++) {
            if (notas[semestre][i] != null) {
                suma += notas[semestre][i];
                contador++;
            }
        }
        if (contador == 0)
            return 0;
        return suma / contador;
    }

    public double promedioAcumulado() {
        double suma = 0;
        int contador = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null) {
                    suma += notas[i][j];
                    contador++;
                }
            }
        }
        if (contador == 0)
            return 0;

        return suma / contador;
    }

    public void materiasReprobadas() {
        System.out.println("=== REPROBADAS ===");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                if (notas[i][j] != null && notas[i][j] < 3.0) {
                    System.out.println(
                            "Semestre " + i +
                                    " Materia " + j +
                                    " Nota: " + notas[i][j]);
                }
            }
        }
    }
}