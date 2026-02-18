public class ejercicios {
    public static void main(String[] args) {
        // 2 ejercicio

        System.out.println("\n=== Ejercicio 2: neto a pagar ===");

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

        System.out.println("\n=== Ejercicio 3: Separacion numeros pares e impares ===");

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

        System.out.println("\n=== Ejercicio 10: Suma de opuestos ===");
        int[] p = { 8, 5, 3, 10, 2, 8, 1 };
        int h = p.length;
        int m = (h + 1) / 2; // tamaño del arreglo resultado
        int[] B = new int[m];

        for (int i = 0; i < m; i++) {
            int j = h - 1 - i;
            B[i] = (i == j) ? p[i] : p[i] + p[j];
        }

        System.out.print("A = ");
        for (int x : p)
            System.out.print(x + " ");
        System.out.print("\nB = ");
        for (int x : B)
            System.out.print(x + " ");
        System.out.println();

        // 11 ejercicio

                System.out.println("\n=== Ejercicio 11: Negativos, ceros y positivos ===");
        int[] Aa = {-3, 0, 7, -1, 5, 0, -8, 4, 0, 2};
        int na = Aa.length;
        int[] neg  = new int[na], ceros = new int[na], pos = new int[na];
        int cn = 0, cc = 0, cpp = 0;

        for (int x : Aa) {
            if      (x < 0) neg[cn++] = x;
            else if (x > 0) pos[cpp++] = x;
            else            ceros[cc++] = x;
        }

        System.out.print("Negativos: ");
        for (int i = 0; i < cn; i++) System.out.print(neg[i] + " ");
        System.out.print("\nCeros:     ");
        for (int i = 0; i < cc; i++) System.out.print(ceros[i] + " ");
        System.out.print("\nPositivos: ");
        for (int i = 0; i < cpp; i++) System.out.print(pos[i] + " ");
        System.out.println();

        //12 ejercicio

                System.out.println("\n=== Ejercicio 12: Posiciones de un valor x ===");
        int[] Ab = {4, 6, 8, 2, 6, 9, 6, 1};
        int x = 6;
        int[] Ba = new int[Ab.length];
        int count = 0;

        for (int i = 0; i < Ab.length; i++)
            if (Ab[i] == x) Ba[count++] = i + 1;   // posición 1-based

        System.out.print("Posiciones de " + x + ": ");
        for (int i = 0; i < count; i++) System.out.print(B[i] + " ");
        System.out.println();

        //13 ejercicio

                System.out.println("\n=== Ejercicio 13: Mayores y menores que la media ===");
        double[] Ac = {3, 7, 1, 9, 4, 6, 2, 8, 5, 10};
        int nc = Ac.length;
        double suma = 0;
        for (double xx : Ac) suma += xx;
        double media = suma / nc;

        double[] mayores  = new double[nc];
        double[] menores  = new double[nc];
        int cm = 0, cme = 0;

        for (double xx : Ac) {
            if      (xx > media) mayores[cm++] = xx;
            else if (xx < media) menores[cme++] = xx;
        }

        System.out.printf("Media: %.2f%n", media);
        System.out.print("Mayores: ");
        for (int i = 0; i < cm; i++)  System.out.print(mayores[i] + " ");
        System.out.print("\nMenores: ");
        for (int i = 0; i < cme; i++) System.out.print(menores[i] + " ");
        System.out.println();

        //14 ejercicio

                System.out.println("\n=== Ejercicio 14: Diferencia de elementos sucesivos ===");
        int[] Af = {4, 6, 8, 2, 6, 9, 5, 1};
        int[] Bf = new int[Af.length - 1];

        for (int i = 0; i < Bf.length; i++)
            Bf[i] = Af[i] - Af[i + 1];

        System.out.print("A = "); for (int xc : Af) System.out.print(xc + " ");
        System.out.print("\nB = "); for (int xc : Bf) System.out.print(xc + " ");
        System.out.println();

        //15 ejercicio

                System.out.println("\n=== Ejercicio 15: Trabajadores con sueldo promedio ===");
        String[] nombres = {"Ana", "Luis", "Maria", "Pedro", "Juan"};
        double[] sueldos = {1500, 2000, 1800, 2000, 1700};
        int nh = nombres.length;

        double sumaa = 0;
        for (double s : sueldos) sumaa += s;
        double promedio = sumaa / nh;

        System.out.printf("Promedio salarial: %.2f%n", promedio);
        System.out.println("Trabajadores con sueldo igual al promedio:");
        int countt = 0;
        for (int i = 0; i < nh; i++) {
            if (sueldos[i] == promedio) {
                System.out.println("  " + nombres[i]);
                countt++;
            }
        }
        System.out.println("Total: " + countt);

    }
}
