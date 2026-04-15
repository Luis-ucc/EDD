import java.util.Stack;

public class 93 {

    public static boolean estaBalanceado(String texto) {
        Stack<Character> pila = new Stack<>();

        for (char simbolo : texto.toCharArray()) {

            switch (simbolo) {
                case '(', '{', '[':
                    pila.push(simbolo);
                    break;

                case ')', '}', ']':
                    if (pila.isEmpty()) return false;

                    char ultimo = pila.pop();

                    if (!coinciden(ultimo, simbolo)) {
                        return false;
                    }
                    break;
            }
        }

        return pila.isEmpty();
    }

    private static boolean coinciden(char abierto, char cerrado) {
        return (abierto == '(' && cerrado == ')') ||
               (abierto == '{' && cerrado == '}') ||
               (abierto == '[' && cerrado == ']');
    }

    public static void main(String[] args) {
        String e1 = "((a+b)*5) - 7";
        String e2 = "2*(a+b)/2.5 + x - 7*y]";

        System.out.println("Expresión 1 balanceada: " + estaBalanceado(e1));
        System.out.println("Expresión 2 balanceada: " + estaBalanceado(e2));
    }
}