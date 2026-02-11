public class ejercicios {
    public static void main(String[] args) {
        //2 ejercicio

        int[] a = {20,20,15,8,12};
        int[] b = {2,3,4,1,2};
        int[] c = {3,3,5,3,1};

        int[] t = new int[5];

        for(int i = 0; i < a.length; i++){
            t[i] = a[i] + b[i] - c[i];
        }

        for(int i = 0; i < a.length; i++){
            System.out.println("t[" + i + "]=" + t[i] + " | ");
        } 
        
        //3 ejercicio

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

        //4 ejercicio

        int[] l = {18,20,30,40};
        int[] m = {20,20,77,47};
        int edadM = l[0];
        int edadM2 = m[0];

        for(int i = 0; i < l.length; i++);{
            
            if(edadM <= l[i]){
                edadM = l[i];
            }
            if(edadM2 <= m[i]){
                edadM2 = m[i];
            }
        }
        String mayor = edadM>edadM2?"edad mayor es: "+ edadM: "edad mayor es" edadM2
        System.out.println(mayor);
    }
}
