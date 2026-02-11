public class arreglos {
    public static void main(String[] args) throws Exception {

        int[] a = {2, 6, 8, 1, 20, 40, 7, 3, 5};

        System.out.println("tamaño del arreglo a: " + a.length);

        for(int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "]=" + a[i]);
        }

        int suma = 0;
        for(int i = 0; i < a.length; i++) {
            suma += a[i];
        }

        System.out.println("la suma de todos los elementos del arreglo [a] es: " + suma);

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


    }
}
