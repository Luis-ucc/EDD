import java.util.*;
import Excepciones.*;

public class Main3 {
    static SistemaUniversitario sistema = new SistemaUniversitario();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n===== SISTEMA UNIVERSITARIO =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Buscar estudiante");
            System.out.println("3. Listar estudiantes");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Crear materia");
            System.out.println("6. Inscribir estudiante");
            System.out.println("7. Registrar nota");
            System.out.println("8. Ver historial academico");
            System.out.println("9. Reservar aula");
            System.out.println("10. Liberar aula");
            System.out.println("11. Ruta mas corta entre edificios");
            System.out.println("12. Deshacer");
            System.out.println("13. Rehacer");
            System.out.println("14. Cargar solicitudes batch");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    buscarEstudiante();
                    break;
                case 3:
                    sistema.listarEstudiantes();
                    break;
                case 4:
                    eliminarEstudiante();
                    break;
                case 5:
                    crearMateria();
                    break;
                case 6:
                    inscribir();
                    break;
                case 7:
                    registrarNota();
                    break;
                case 8:
                    historial();
                    break;
                case 9:
                    reservarAula();
                    break;
                case 10:
                    liberarAula();
                    break;
                case 11:
                    sistema.mostrarRutaMasCorta();
                    break;
                case 12:
                    deshacer();
                    break;
                case 13:
                    rehacer();
                    break;
                case 14:
                    cargarBatch();
                    break;
            }
        } while (opcion != 0);
    }

    static void registrarEstudiante() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine();
        System.out.print("Semestre: ");
        int semestre = sc.nextInt();
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        sistema.registrarEstudiante(nombre, id, semestre, email);
    }

    static void buscarEstudiante() {
        System.out.print("ID: ");
        String id = sc.nextLine();
        try {
            sistema.buscarEstudiante(id);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    static void eliminarEstudiante() {
        System.out.print("ID estudiante: ");
        String id = sc.nextLine();
        try {
            sistema.eliminarEstudiante(id);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    static void crearMateria() {
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Cupos: ");
        int cupos = sc.nextInt();
        System.out.print("Creditos: ");
        int creditos = sc.nextInt();
        sc.nextLine();
        sistema.crearMateria(codigo, nombre, cupos, creditos);
    }

    static void inscribir() {
        System.out.print("ID estudiante: ");
        String id = sc.nextLine();
        System.out.print("Codigo materia: ");
        String codigo = sc.nextLine();
        try {
            sistema.inscribirEstudiante(id, codigo);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } catch (PreRequisitoNoAprobadoException e) {
            System.out.println("[PREREQUISITO] " + e.getMessage());
        } catch (CupoLlenoException e) {
            // No es un error fatal: el estudiante quedó en cola de espera
            System.out.println("[CUPO LLENO] " + e.getMessage());
        }
    }

    static void registrarNota() {
        System.out.print("ID estudiante: ");
        String id = sc.nextLine();
        System.out.print("Semestre: ");
        int semestre = sc.nextInt();
        System.out.print("Materia posicion: ");
        int materia = sc.nextInt();
        System.out.print("Nota: ");
        double nota = sc.nextDouble();
        sc.nextLine();
        try {
            sistema.registrarNota(id, semestre, materia, nota);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    static void historial() {
        System.out.print("ID estudiante: ");
        String id = sc.nextLine();
        try {
            sistema.mostrarHistorial(id);
        } catch (EstudianteNoEncontradoException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }

    static void reservarAula() {
        System.out.print("Dia (0-6): ");
        int dia = sc.nextInt();
        System.out.print("Hora (0-23): ");
        int hora = sc.nextInt();
        System.out.print("Duracion: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        try {
            sistema.reservarAula(dia, hora, duracion);
        } catch (HorarioConflictivoException e) {
            System.out.println("[CONFLICTO] " + e.getMessage());
        }
    }

    static void liberarAula() {
        System.out.print("Dia: ");
        int dia = sc.nextInt();
        System.out.print("Hora: ");
        int hora = sc.nextInt();
        System.out.print("Duracion: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        sistema.liberarAula(dia, hora, duracion);
    }

    static void deshacer() {
        try {
            sistema.deshacer();
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("[DESHACER] " + e.getMessage());
        }
    }

    static void rehacer() {
        try {
            sistema.rehacer();
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("[REHACER] " + e.getMessage());
        }
    }

    static void cargarBatch() {
        System.out.print("Ruta del archivo: ");
        String ruta = sc.nextLine();
        BatchProcessor bp = new BatchProcessor(sistema); // <-- le pasas el sistema
        try {
            bp.cargarArchivo(ruta);
            bp.procesar();
        } catch (ArchivoInvalidoException e) {
            System.out.println("[ARCHIVO] " + e.getMessage());
        }
    }
}