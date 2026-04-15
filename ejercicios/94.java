import java.util.Scanner;
import java.util.Stack;

public class 94 {

    public static void main(String[] args) {

        final int TOTAL_PILAS = 5;
        Stack<Integer>[] arregloPilas = new Stack[TOTAL_PILAS];
        Scanner entrada = new Scanner(System.in);

        for (int k = 0; k < TOTAL_PILAS; k++) {
            arregloPilas[k] = new Stack<>();
        }

        System.out.println("Ingrese pares (i, j). i=0 para terminar:");

        while (true) {
            System.out.print("i: ");
            int i = entrada.nextInt();

            if (i == 0) break;

            System.out.print("j: ");
            int j = entrada.nextInt();

            procesarOperacion(arregloPilas, i, j);
        }

        mostrarPilas(arregloPilas);
        entrada.close();
    }


    private static void procesarOperacion(Stack<Integer>[] pilas, int i, int valor) {
        int pos = Math.abs(i) - 1;

        if (pos >= pilas.length) {
            System.out.println("Índice inválido");
            return;
        }

        if (i > 0) {
            pilas[pos].push(valor);
            System.out.println("Insertado " + valor + " en pila " + (pos + 1));
        } else {
            if (pilas[pos].isEmpty()) {
                System.out.println("No se puede eliminar (pila vacía)");
            } else {
                int eliminado = pilas[pos].pop();
                System.out.println("Eliminado " + eliminado + " de pila " + (pos + 1));
            }
        }
    }


    private static void mostrarPilas(Stack<Integer>[] pilas) {
        System.out.println("\nContenido de las pilas:");
        for (int i = 0; i < pilas.length; i++) {
            System.out.println("Pila " + (i + 1) + ": " + pilas[i]);
        }
    }
}