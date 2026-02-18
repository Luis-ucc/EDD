public class ejercicios {
    public static void main(String[] args) {
        // 2 ejercicio

        int[] a = { 20, 20, 15, 8, 12 };
        int[] b = { 2, 3, 4, 1, 2 };
        int[] c = { 3, 3, 5, 3, 1 };

        int[] t = new int[5];

        for (int i = 0; i < a.length; i++) {
            t[i] = a[i] + b[i] - c[i];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println("t[" + i + "]=" + t[i] + " | ");
        }

        // 3 ejercicio

        int sumapares = 0;
        int sumaimpares = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                sumapares += a[i];
            } else {
                sumaimpares += a[i];
            }
        }

        System.out.println("suma de pares " + sumapares);
        System.out.println("suma de impares " + sumaimpares);

        // 4 ejercicio

        System.out.println("\n=== Ejercicio 4: Mayor edad en dos arreglos ===");
        int n = 4;
        int[] z = { 23, 45, 12, 67 };
        int[] q = { 34, 89, 5, 22 };
        int mayor = z[0];
        for (int x : z)
            if (x > mayor)
                mayor = x;
        for (int x : q)
            if (x > mayor)
                mayor = x;
        System.out.println("Mayor edad: " + mayor);

        // 5 ejercicio

        System.out.println("\n=== Ejercicio 5: Total gastado por producto ===");
        double[] PU = { 10.5, 25.0, 5.75, 100.0 };
        int[] CC = { 3, 2, 10, 1 };
        String[] desc = { "Lapiz", "Cuaderno", "Borrador", "Libro" };
        int l = PU.length;

        double[] TG = new double[n];
        double totalGeneral = 0;
        int idxMayor = 0;

        for (int i = 0; i < n; i++) {
            TG[i] = PU[i] * CC[i];
            totalGeneral += TG[i];
            if (TG[i] > TG[idxMayor])
                idxMayor = i;
        }

        System.out.println("Total por producto:");
        for (int i = 0; i < n; i++)
            System.out.printf("  %s: %.2f%n", desc[i], TG[i]);
        System.out.printf("Total general: %.2f%n", totalGeneral);
        System.out.printf("Mayor gasto => %s: %.2f%n", desc[idxMayor], TG[idxMayor]);

        // 6 ejercico

        System.out.println("\n=== Ejercicio 6: Ganancias por vivienda ===");
        double[] alquileres = { 500, 750, 300, 1200 };
        double[] porcentajes = { 10, 15, 8, 20 };
        int f = alquileres.length;
        double[] ganancias = new double[n];

        for (int i = 0; i < n; i++)
            ganancias[i] = alquileres[i] * porcentajes[i] / 100.0;

        for (int i = 0; i < n; i++)
            System.out.printf("  Vivienda %d: ganancia = %.2f%n", i + 1, ganancias[i]);

        // 7 ejercicio

        System.out.println("\n=== Ejercicio 7: Pares e impares ===");
        int[] A = { 1, 4, 7, 2, 9, 6, 3, 8, 5, 10 };
        int[] pares = new int[10];
        int[] impares = new int[10];
        int cp = 0, ci = 0;

        for (int x : A) {
            if (x % 2 == 0)
                pares[cp++] = x;
            else
                impares[ci++] = x;
        }

        System.out.print("Pares:   ");
        for (int i = 0; i < cp; i++)
            System.out.print(pares[i] + " ");
        System.out.print("\nImpares: ");
        for (int i = 0; i < ci; i++)
            System.out.print(impares[i] + " ");
        System.out.println();

        // 8 ejercicio

        System.out.println("\n=== Ejercicio 8: Mayor, menor y repeticiones ===");

        int[] nums = { 5, 3, 9, 1, 7, 2, 8, 4, 6, 5, 3, 9, 1, 7, 2, 8, 4, 6, 5, 3,
                9, 1, 7, 2, 8, 4, 6, 5, 3, 9 };

        int mayorO = nums[0], menor = nums[0];
        for (int x : nums) {
            if (x > mayorO)
                mayorO = x;
            if (x < menor)
                menor = x;
        }

        int cMayor = 0, cMenor = 0;
        for (int x : nums) {
            if (x == mayor)
                cMayor++;
            if (x == menor)
                cMenor++;
        }

        System.out.println("Mayor: " + mayorO + "  (aparece " + cMayor + " veces)");
        System.out.println("Menor: " + menor + "  (aparece " + cMenor + " veces)");

        // 9 ejercicio

        System.out.println("\n=== Ejercicio 9: Contar ocurrencias de un número ===");
        int[] J = { 4, 6, 8, 2, 6, 9, 6, 1, 3, 6 };
        int buscar = 6;
        int contador = 0;

        for (int x : J)
            if (x == buscar)
                contador++;

        System.out.println("El número " + buscar + " aparece " + contador + " veces.");

        // 10 ejercicio

        

    }
}
