import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 104 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese primer numero grande: ");
        String numero1 = entrada.nextLine();

        System.out.print("Ingrese segundo numero grande: ");
        String numero2 = entrada.nextLine();

        Queue<Integer> colaA = convertirACola(numero1);
        Queue<Integer> colaB = convertirACola(numero2);

        Queue<Integer> suma = sumarColas(colaA, colaB);

        mostrarResultado(suma);

        entrada.close();
    }

    private static Queue<Integer> convertirACola(String numero) {
        Queue<Integer> cola = new LinkedList<>();
        for (char digito : numero.toCharArray()) {
            cola.offer(Character.getNumericValue(digito));
        }
        return cola;
    }

    private static Queue<Integer> sumarColas(Queue<Integer> c1, Queue<Integer> c2) {

        LinkedList<Integer> lista1 = new LinkedList<>(c1);
        LinkedList<Integer> lista2 = new LinkedList<>(c2);

        int i = lista1.size() - 1;
        int j = lista2.size() - 1;
        int acarreo = 0;

        Queue<Integer> resultado = new LinkedList<>();

        while (i >= 0 || j >= 0 || acarreo != 0) {

            int valor1 = (i >= 0) ? lista1.get(i) : 0;
            int valor2 = (j >= 0) ? lista2.get(j) : 0;

            int total = valor1 + valor2 + acarreo;

            resultado.offer(total % 10);
            acarreo = total / 10;

            i--;
            j--;
        }

        return resultado;
    }


    private static void mostrarResultado(Queue<Integer> resultado) {
        LinkedList<Integer> lista = new LinkedList<>(resultado);

        System.out.print("Resultado: ");
        for (int i = lista.size() - 1; i >= 0; i--) {
            System.out.print(lista.get(i));
        }
        System.out.println();
    }
}