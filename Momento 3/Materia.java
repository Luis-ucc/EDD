import java.util.*;
import Excepciones.*;
public class Materia {
    String codigo;
    String nombre;
    int cuposMaximos;
    int creditos;
    LinkedList<String> prerequisitos = new LinkedList<>();
    ArrayList<Estudiante> inscritos = new ArrayList<>();
    Queue<Estudiante> colaEspera = new LinkedList<>();
 
    public Materia(String codigo, String nombre, int cuposMaximos, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cuposMaximos = cuposMaximos;
        this.creditos = creditos;
    }
 
    public void agregarPrerequisito(String codigo) {
        prerequisitos.add(codigo);
    }
 
    public boolean tieneCupo() {
        return inscritos.size() < cuposMaximos;
    }
 
    /**
     * Intenta inscribir al estudiante.
     * Si no hay cupo, lo agrega a la cola de espera e informa al llamador
     * lanzando CupoLlenoException (el llamador decide si tratar eso como
     * error o como flujo normal de lista de espera).
     */
    public void inscribir(Estudiante e) throws CupoLlenoException {
        if (tieneCupo()) {
            inscritos.add(e);
            System.out.println("Inscripcion exitosa: " + e.nombre);
        } else {
            colaEspera.add(e);
            throw new CupoLlenoException(
                "La materia '" + nombre + "' no tiene cupos. " +
                e.nombre + " fue agregado a la cola de espera (posicion " +
                colaEspera.size() + ")."
            );
        }
    }
 
    /**
     * Cancela la inscripcion de un estudiante y promueve al siguiente
     * de la cola de espera, si existe.
     */
    public void cancelar(Estudiante e) throws ColaDeEsperaVaciaException {
        inscritos.remove(e);
        if (!colaEspera.isEmpty()) {
            Estudiante siguiente = colaEspera.poll();
            inscritos.add(siguiente);
            System.out.println(siguiente.nombre + " entro desde la cola de espera.");
        } else {
            // Lanzar solo si la lógica del negocio requiere saber que la cola estaba vacía.
            // Aquí se muestra como ejemplo; puedes optar por no lanzar si la cancelación
            // sin cola de espera es un caso completamente válido y silencioso.
            throw new ColaDeEsperaVaciaException(
                "No hay estudiantes en cola de espera para '" + nombre + "'."
            );
        }
    }
}