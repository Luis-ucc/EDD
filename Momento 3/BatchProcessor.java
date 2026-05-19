import java.io.*;
import java.util.*;
import Excepciones.*;

public class BatchProcessor {
    Queue<String> colaSolicitudes = new LinkedList<>();
    SistemaUniversitario sistema;

    public BatchProcessor(SistemaUniversitario sistema) {
        this.sistema = sistema;
    }

    public void cargarArchivo(String ruta) throws ArchivoInvalidoException {
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            throw new ArchivoInvalidoException("El archivo no existe en la ruta: " + ruta);
        }
        if (!archivo.canRead()) {
            throw new ArchivoInvalidoException("Sin permisos de lectura: " + ruta);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numeroLinea = 0;
            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                linea = linea.trim();
                if (linea.isEmpty())
                    continue;

                String[] partes = linea.split(",");
                if (partes.length != 5) {
                    throw new ArchivoInvalidoException(
                            "Formato invalido en linea " + numeroLinea +
                                    ". Se esperaba: ID, Nombre, Semestre, Email, CodigoMateria");
                }
                colaSolicitudes.add(linea);
            }
            System.out.println(colaSolicitudes.size() + " solicitudes cargadas.");

        } catch (IOException e) {
            throw new ArchivoInvalidoException("Error leyendo el archivo: " + e.getMessage());
        }
    }

    public void procesar() {
        if (colaSolicitudes.isEmpty()) {
            System.out.println("No hay solicitudes en cola.");
            return;
        }
        while (!colaSolicitudes.isEmpty()) {
            String solicitud = colaSolicitudes.poll();
            String[] partes = solicitud.split(",");

            String id = partes[0].trim();
            String nombre = partes[1].trim();
            int semestre = Integer.parseInt(partes[2].trim());
            String email = partes[3].trim();
            String codigoMateria = partes[4].trim();

            // Paso 1: registrar si no existe todavía
            sistema.registrarEstudiante(nombre, id, semestre, email);

            // Paso 2: inscribirlo a la materia
            try {
                sistema.inscribirEstudiante(id, codigoMateria);
                System.out.println("[OK] " + nombre + " inscrito en " + codigoMateria);
            } catch (EstudianteNoEncontradoException e) {
                System.out.println("[ERROR] " + id + ": " + e.getMessage());
            } catch (PreRequisitoNoAprobadoException e) {
                System.out.println("[SKIP] " + nombre + ": " + e.getMessage());
            } catch (CupoLlenoException e) {
                System.out.println("[ESPERA] " + nombre + " en cola de espera para " + codigoMateria);
            }
        }
    }
}