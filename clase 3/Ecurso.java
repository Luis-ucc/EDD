public class Ecurso {
    public static void main(String[] args) {
        
        Curso[] n = new Curso[5];

        n[0] = new Curso(115, "Estructura de datos", "Diego Ramirez", 18);
        n[1] = new Curso(116, "Filosofia", "Juan Lopez", 25);
        n[2] = new Curso(117, "Matematicas 2", "Camilo Zuñiga", 13);
        n[3] = new Curso(118, "Fisica y electromagnectismo", "Alberto Perez", 16);
        n[4] = new Curso(119, "Ingles", "Catalina Lozano", 18);

        int Sestudiantes = 0;

        for (int i = 0; i < n.length; i++) {
            Sestudiantes += n[i].getEstudiantes();
        }

        System.out.println("el total de estudiantes entre todos los cursos son: " + Sestudiantes);


    }
}
