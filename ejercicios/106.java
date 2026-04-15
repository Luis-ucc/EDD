import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class 106 {

    public static void main(String[] args) {

        final int TIEMPO_SIMULACION = 60 * 7;

        Queue<Integer> cola = new LinkedList<>();
        Random random = new Random();

        int atendidos = 0;
        int maxCola = 0;
        int sumaCola = 0;

        int[] cajas = new int[4]; 

        for (int t = 0; t < TIEMPO_SIMULACION; t++) {

            llegadaCliente(cola, random, t);

            boolean activarCajaExtra = cola.size() > 20;

            atendidos += procesarCajas(cola, cajas, random, activarCajaExtra);

            actualizarCajas(cajas, activarCajaExtra);

            sumaCola += cola.size();
            maxCola = Math.max(maxCola, cola.size());
        }

        mostrarResultados(atendidos, sumaCola, maxCola, TIEMPO_SIMULACION);
    }

    private static void llegadaCliente(Queue<Integer> cola, Random rand, int tiempo) {
        if (rand.nextInt(2) == 0) {
            cola.offer(tiempo);
        }
    }

    private static int procesarCajas(Queue<Integer> cola, int[] cajas, Random rand, boolean usarCaja4) {
        int atendidos = 0;

        if (cajas[0] == 0 && !cola.isEmpty()) {
            cola.poll();
            cajas[0] = rand.nextInt(2) + 1;
            atendidos++;
        }

        if (cajas[1] == 0 && !cola.isEmpty()) {
            cola.poll();
            cajas[1] = rand.nextInt(4) + 2;
            atendidos++;
        }

        if (cajas[2] == 0 && !cola.isEmpty()) {
            cola.poll();
            cajas[2] = rand.nextInt(3) + 2;
            atendidos++;
        }

        if (usarCaja4 && cajas[3] == 0 && !cola.isEmpty()) {
            cola.poll();
            cajas[3] = rand.nextInt(3) + 2;
            atendidos++;
        }

        return atendidos;
    }


    private static void actualizarCajas(int[] cajas, boolean usarCaja4) {
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i] > 0 && (i < 3 || usarCaja4)) {
                cajas[i]--;
            }
        }
    }

    private static void mostrarResultados(int atendidos, int sumaCola, int maxCola, int tiempoTotal) {
        double promedio = (double) sumaCola / tiempoTotal;

        System.out.println("Clientes atendidos: " + atendidos);
        System.out.println("Tamaño promedio de cola: " + promedio);
        System.out.println("Tamaño máximo de cola: " + maxCola);
    }
}