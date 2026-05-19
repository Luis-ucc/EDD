import Excepciones.*;
public class Aula {
    boolean[][] horario = new boolean[7][24];
 
    /**
     * Reserva el aula para el dia, hora y duración indicados.
     * Lanza HorarioConflictivoException si alguna franja ya está ocupada.
     */
    public void reservar(int dia, int hora, int duracion)
            throws HorarioConflictivoException {
 
        // Primero validamos sin modificar nada (atomicidad)
        for (int i = hora; i < hora + duracion; i++) {
            if (horario[dia][i]) {
                throw new HorarioConflictivoException(
                    "Conflicto de horario: el aula ya esta reservada el dia " +
                    dia + " a las " + i + ":00."
                );
            }
        }
        // Si no hubo conflicto, registramos la reserva
        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = true;
        }
    }
 
    public void liberar(int dia, int hora, int duracion) {
        for (int i = hora; i < hora + duracion; i++) {
            horario[dia][i] = false;
        }
    }
 
    public boolean consultarDisponibilidad(int dia, int hora) {
        return !horario[dia][hora];
    }
}