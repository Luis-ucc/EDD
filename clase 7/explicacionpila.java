import java.util.Stack;

public class explicacionpila {
    public static void main(String[] args) {

        Stack<String> objpila = new Stack<>();

        objpila.push("Luis");
        objpila.push("Maria");
        objpila.push("Carlos");
        objpila.push("Juan");
        objpila.push("Pedro");

        System.out.println("tope de la Pila: " + objpila.peek());

        System.out.println("pila vacia: " + objpila.empty());

        System.out.println("elemento removido: " + objpila.pop());

        System.out.println("tope de la Pila: " + objpila.peek());

        System.out.println(objpila.search("Maria"));
        System.out.println(objpila.search("Juan"));
        System.out.println(objpila.search("Carlos"));
        System.out.println(objpila.search("Luis"));
    }
}
