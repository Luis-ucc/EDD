
public class arreglo2 {
    public static void main(String[] args) throws Exception {
        int [] a = {7,2,6,1,0,3};

        for(int i = 0; i < a.length; i++){
            System.out.println("a[]" + i + "]=" + a[i]);
        }

        int total = 0;
        for (int i = 0; i < a.length; i++){
            total += a[i];
        }
        System.out.println("la suma de los elementos del arreglo a es: " + total);
        

    }
}
