import java.util.*;
import Excepciones.*;
 
public class SistemaUniversitario {
    HashMap<String, Estudiante> estudiantes = new HashMap<>();
    HashMap<String, Materia> materias = new HashMap<>();
    Aula aula = new Aula();
    GrafoCampus grafo = new GrafoCampus();
    Stack<Operacion> pilaDeshacer = new Stack<>();
    Stack<Operacion> pilaRehacer = new Stack<>();
 
    public void registrarEstudiante(String nombre, String id, int semestre, String email) {
        Estudiante e = new Estudiante(nombre, id, semestre, email);
        estudiantes.put(id, e);
        System.out.println("Estudiante registrado: " + nombre);
    }
 
    /**
     * Busca un estudiante por ID.
     * Lanza EstudianteNoEncontradoException si no existe.
     */
    public Estudiante buscarEstudiante(String id)
            throws EstudianteNoEncontradoException {
        Estudiante e = estudiantes.get(id);
        if (e == null) {
            throw new EstudianteNoEncontradoException(
                "No se encontro ningun estudiante con ID: " + id
            );
        }
        System.out.println("Nombre: " + e.nombre);
        System.out.println("Semestre: " + e.semestre);
        System.out.println("Email: " + e.email);
        return e;
    }
 
    public void listarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }
        for (Estudiante e : estudiantes.values()) {
            System.out.println(e.id + " - " + e.nombre);
        }
    }
 
    public void eliminarEstudiante(String id)
            throws EstudianteNoEncontradoException {
        Estudiante eliminado = estudiantes.remove(id);
        if (eliminado == null) {
            throw new EstudianteNoEncontradoException(
                "No se puede eliminar: estudiante con ID '" + id + "' no existe."
            );
        }
        pilaDeshacer.push(new Operacion("ELIMINAR_ESTUDIANTE", eliminado));
        System.out.println("Estudiante eliminado: " + eliminado.nombre);
    }
 
    public void crearMateria(String codigo, String nombre, int cupos, int creditos) {
        Materia m = new Materia(codigo, nombre, cupos, creditos);
        materias.put(codigo, m);
        System.out.println("Materia creada: " + nombre);
    }
 
    /**
     * Inscribe un estudiante en una materia.
     * Lanza EstudianteNoEncontradoException si el ID no existe.
     * Lanza PreRequisitoNoAprobadoException si no cumple los prerequisitos.
     * Lanza CupoLlenoException si la materia no tiene cupo (y lo pone en cola).
     */
    public void inscribirEstudiante(String id, String codigo)
            throws EstudianteNoEncontradoException,
                   PreRequisitoNoAprobadoException,
                   CupoLlenoException {
 
        Estudiante e = estudiantes.get(id);
        if (e == null) {
            throw new EstudianteNoEncontradoException(
                "Estudiante con ID '" + id + "' no encontrado."
            );
        }
 
        Materia m = materias.get(codigo);
        if (m == null) {
            // Podrías crear MateriaNoEncontradaException; aquí se reutiliza IllegalArgument
            throw new IllegalArgumentException(
                "La materia con codigo '" + codigo + "' no existe."
            );
        }
 
        for (String pre : m.prerequisitos) {
            if (!e.materiasAprobadas.contains(pre)) {
                throw new PreRequisitoNoAprobadoException(
                    "El estudiante " + e.nombre +
                    " no ha aprobado el prerequisito: " + pre +
                    " (requerido para '" + m.nombre + "')."
                );
            }
        }
 
        // inscribir() lanza CupoLlenoException si no hay cupo (la relanzamos)
        m.inscribir(e);
        pilaDeshacer.push(new Operacion("INSCRIPCION", e));
    }
 
    public void registrarNota(String id, int semestre, int materia, double nota)
            throws EstudianteNoEncontradoException {
        Estudiante e = estudiantes.get(id);
        if (e == null) {
            throw new EstudianteNoEncontradoException(
                "No se puede registrar nota: estudiante '" + id + "' no existe."
            );
        }
        e.registrarNota(semestre, materia, nota);
        pilaDeshacer.push(new Operacion("NOTA", e));
        System.out.println("Nota registrada.");
    }
 
    public void mostrarHistorial(String id)
            throws EstudianteNoEncontradoException {
        Estudiante e = estudiantes.get(id);
        if (e == null) {
            throw new EstudianteNoEncontradoException(
                "Historial no disponible: estudiante '" + id + "' no existe."
            );
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Semestre " + i);
            for (int j = 0; j < 20; j++) {
                if (e.notas[i][j] != null) {
                    System.out.println("  Materia " + j + " -> " + e.notas[i][j]);
                }
            }
        }
        System.out.println("Promedio acumulado: " + e.promedioAcumulado());
        e.materiasReprobadas();
    }
 
    /**
     * Reserva el aula; delega la excepción de conflicto al llamador.
     */
    public void reservarAula(int dia, int hora, int duracion)
            throws HorarioConflictivoException {
        aula.reservar(dia, hora, duracion); // lanza HorarioConflictivoException
        pilaDeshacer.push(new Operacion("RESERVA", dia));
        System.out.println("Reserva realizada.");
    }
 
    public void liberarAula(int dia, int hora, int duracion) {
        aula.liberar(dia, hora, duracion);
        System.out.println("Horario liberado.");
    }
 
    public void mostrarRutaMasCorta() {
        Scanner sc = new Scanner(System.in);
        System.out.println("0 Biblioteca  1 Ingenieria  2 Cafeteria  3 Laboratorios  4 Administracion");
        System.out.print("Origen: ");
        int o = sc.nextInt();
        System.out.print("Destino: ");
        int d = sc.nextInt();
        grafo.dijkstra(o, d);
    }
 
    /**
     * Deshace la última operación.
     * Lanza PilaDeshacerVaciaException si no hay nada que deshacer.
     */
    public void deshacer() throws PilaDeshacerVaciaException {
        if (pilaDeshacer.empty()) {
            throw new PilaDeshacerVaciaException(
                "No hay operaciones para deshacer."
            );
        }
        Operacion op = pilaDeshacer.pop();
        pilaRehacer.push(op);
        if (op.tipo.equals("ELIMINAR_ESTUDIANTE")) {
            Estudiante e = (Estudiante) op.dato;
            estudiantes.put(e.id, e);
            System.out.println("Estudiante restaurado: " + e.nombre);
        }
    }
 
    /**
     * Rehace la última operación deshecha.
     * Lanza PilaDeshacerVaciaException si no hay nada que rehacer.
     */
    public void rehacer() throws PilaDeshacerVaciaException {
        if (pilaRehacer.empty()) {
            throw new PilaDeshacerVaciaException(
                "No hay operaciones para rehacer."
            );
        }
        Operacion op = pilaRehacer.pop();
        pilaDeshacer.push(op);
        if (op.tipo.equals("ELIMINAR_ESTUDIANTE")) {
            Estudiante e = (Estudiante) op.dato;
            estudiantes.remove(e.id);
            System.out.println("Eliminacion rehecha: " + e.nombre);
        }
    }
}