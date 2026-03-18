import java.util.Queue;
import java.util.LinkedList;

public class explicacionCola {
    
    public static void main(String[] args) {
        
        Queue<Integer> objcola = new LinkedList<>();

        objcola.add(29);
        objcola.add(16);
        objcola.offer(10);
        objcola.offer(34);

        System.out.println(objcola);

        System.out.println("cabeza de la Cola(element): " + objcola.element());
        System.out.println("cabeza de la Cola(peek): " + objcola.peek());

        System.out.println("elemento eliminado con poll(): " + objcola.poll());
        System.out.println("elemento eliminado con remove(): " + objcola.remove());

        System.out.println(objcola);

        System.out.println("tamaño de la Cola: " + objcola.size());
    }
}
