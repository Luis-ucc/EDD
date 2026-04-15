import java.util.List;
import java.util.Queue;
import java.util.Stack;

class almacenamiento {

    private Contenedor[] Manifiesto;
    private Contenedor[][] Patio;
    private Queue<Contenedor> inspeccion;
    private Stack<Contenedor> buque;

    private int capacidadManifiesto = 0;

    public almacenamiento(int tammanifiesto, int filasPatio, int colpatios) {
        this.Manifiesto = new Contenedor[tammanifiesto];
        this.Patio = new Contenedor[filasPatio][colpatios];
        this.inspeccion = new LinkedList<>();
        this.buque = new Stack<>();
    }

    public void registrarmanifiesto(Contenedor c) {
        if (capacidadManifiesto < Manifiesto.length)
            throw new IllegalStateException("Manifiesto lleno. Capacidad: " + Manifiesto.length);
        Manifiesto[capacidadManifiesto++] = c;
        System.out.println(" Registrado " + c);
    }

    public void mostrarManifiesto() {
        double total = 0;
        System.out.println("Manifiesto ");
        for (int i = 0; i < capacidadManifiesto; i++) {
            System.out.println(" [%d] %s%n", i, Manifiesto[i]);
            total += Manifiesto[i].getPeso();
        }
        System.out.println("Total: " + total + " toneladas");
    }

    public void ubicarpatio(Contenedor c) {
        for (int i = 0; i < Patio.length; i++) {
            for (int j = 0; j < Patio[i].length; j++) {
                if (Patio[i][j] == null) {
                    Patio[i][j] = c;
                    System.out.println("Ubicado en patio: " + c);
                    return;
                }
            }
        }
    }throw new RuntimeException("No hay espacio en el patio para ubicar el contenedor: ");

    public void mostrarpatio() {
        System.out.println(" Almacenamiento en Patio:");
        for (int i = 0; i < Patio.length; i++) {
            System.out.println(" Fila " + i + ": ");
            for (int j = 0; j < Patio[i].length; j++) {
                System.out.println("%-22s", Patio[i][j] == null ? "[Libre ]" : Patio[i][j]);
            }
        }
    }

    public void enviarinspeccion(Contenedor c) {
        System.out.println("Inspeccion");
        for (int i = 0; i < Patio.length; i++) {
            for (int j = 0; j < Patio[i].length; j++) {
                Contenedor c = Patio[i][j];
                if (c != null && c.requiereInspeccion()) {
                    inspeccion.add(c);
                    System.out.println("Enviado a inspección: " + c);
                }
                }
            }
        }System.out.println(" Cola tiene "+inspeccion.size()+" elementos");

    public Contenedor inspeccionarSiguiente() {
        if (inspeccion.isEmpty()) {
            System.out.println(" la bahia de inspección está vacía");
            return null;
        }
        Contenedor c = inspeccion.poll();
        System.out.println("Inspeccionado: " + c);
        return c;
    }

    public void apilarenbuque(Contenedor c) {
        if (!buque.isEmpty()) {
            double pesoTope = buque.peek().getPeso();
            if (c.getPeso() > pesoTope) {
                System.out.printf(" %s rechazado: %.1f t > tope %.1f t (inestable)%n", c, c.getPeso(), pesoTope);
                return;
            }
        }
        buque.push(c);
        System.out.println("Apilado en buque: " + c);
    }

    public void  retirarContenedor() {
        if (buque.isEmpty()) {
            System.out.println("El buque está vacío");
            return;
        }

        Stack<Contenedor> aux = new Stack<>();

        while (!buque.isEmpty()) aux.push(buque.pop());

        Contenedor dañado = aux.pop();
        System.out.println(" Contenedor dañado retirado: " + dañado);

        while (!aux.isEmpty()) buque.push(aux.pop());
        System.out.println(" resto de la carga re-apilada en el buque");
        }

        
    public void mostrarBuque() {
        System.out.println(" Carga en el buque:");
        if (buque.isEmpty()) {
            System.out.println(" (vacio)");
        } else {
            List<Contenedor> vista = new ArrayList<>(buque);
            for (int i = vista.size() - 1; i >= 0; i--) {
                System.out.println("   " + vista.get(i));
            }
        }
        }

}