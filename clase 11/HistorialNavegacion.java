import java.util.LinkedList;

class HistorialNavegacion {

    LinkedList<String> historial;

    public HistorialNavegacion() {
        historial = new LinkedList<>();
        historial.add("google.com");
        historial.add("github.com");
        historial.add("stackoverflow.com");
    }

    public void remover() {
        historial.removeLast();
        System.out.println(historial.getLast());
    }

    public void mostrar() {
        for(String url : historial) {
            System.out.println(url);
        }
    }

    public static void main(String[] args) {
        HistorialNavegacion h = new HistorialNavegacion();
        System.out.println(h.historial.getLast());

        h.remover();

        h.mostrar();
    }
}