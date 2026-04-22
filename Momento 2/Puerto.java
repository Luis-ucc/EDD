import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Puerto {

    private Carga[] manifiesto;
    private Carga[][] patio;
    private Queue<Carga> inspeccion;
    private Stack<Carga> buque;

    private int contadorManifiesto = 0;

    public Puerto(int tamManifiesto, int filasPatio, int colPatio) {
        manifiesto = new Carga[tamManifiesto];
        patio = new Carga[filasPatio][colPatio];
        inspeccion = new LinkedList<>();
        buque = new Stack<>();
    }

    // MÓDULO 1 — REGISTRO DE MANIFIESTO
    public void registrarEnManifiesto(Carga c) {
        if (contadorManifiesto >= manifiesto.length)
            throw new IllegalStateException(" Manifiesto lleno. Capacidad: " + manifiesto.length);
        manifiesto[contadorManifiesto++] = c;
        System.out.println("  ✔ Registrado: " + c);
    }

    public void mostrarResumenManifiesto() {
        double total = 0;
        System.out.println(" MANIFIESTO ");
        for (int i = 0; i < contadorManifiesto; i++) {
            System.out.printf("  [%d] %s%n", i, manifiesto[i]);
            total += manifiesto[i].getPeso();
        }
        System.out.printf("  Peso total: " + total);
    }

    // MÓDULO 2 — PATIO DE ALMACENAMIENTO

    public void ubicarEnPatio(Carga c) {
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                if (patio[i][j] == null) {
                    patio[i][j] = c;
                    System.out.printf("   %s → Patio(%d,%d)%n", c, i, j);
                    return;
                }
            }
        }
        throw new RuntimeException(" ALERTA: Puerto Saturado. No hay espacio en el patio.");
    }

    public void mostrarPatio() {
        System.out.println(" PATIO DE ALMACENAMIENTO ");
        for (int i = 0; i < patio.length; i++) {
            System.out.print("  Fila " + i + ": ");
            for (int j = 0; j < patio[i].length; j++) {
                System.out.printf("%-22s", patio[i][j] == null ? "[ libre ]" : patio[i][j]);
            }
            System.out.println();
        }
    }

    // MÓDULO 3 — BAHÍA DE INSPECCIÓN (Cola FIFO)

    public void enviarAInspeccion() {
        System.out.println(" ENCOLANDO INSPECCIÓN ");
        for (int i = 0; i < patio.length; i++) {
            for (int j = 0; j < patio[i].length; j++) {
                Carga c = patio[i][j];
                if (c != null && c.requiereInspeccion()) {
                    inspeccion.add(c); // enqueue — O(1)
                    System.out.println("   " + c + "  Cola de inspección");
                }
            }
        }
        System.out.println("  Cola tiene " + inspeccion.size() + " elemento(s).");
    }

    public Carga inspeccionarSiguiente() {
        if (inspeccion.isEmpty()) {
            System.out.println("  La bahía de inspección está vacía.");
            return null;
        }
        Carga c = inspeccion.poll(); // dequeue
        System.out.println("  Inspeccionando: " + c);
        return c;
    }

    // MÓDULO 4 — ESTIBA EN EL BUQUE (Pila LIFO)

    public void apilarEnBuque(Carga c) {
        if (!buque.isEmpty()) {
            double pesoTope = buque.peek().getPeso();
            if (c.getPeso() > pesoTope) {
                System.out.printf(
                        "    rechazado:  (inestable) ",
                        c, c.getPeso(), pesoTope);
                return;
            }
        }
        buque.push(c);
        System.out.println("   " + c + " apilado en el buque. Tope actual.");
    }

    public void retirarCargaDañado() {
        if (buque.isEmpty()) {
            System.out.println("   El buque está vacío.");
            return;
        }

        Stack<Carga> aux = new Stack<>();

        while (!buque.isEmpty())
            aux.push(buque.pop());

        Carga dañado = aux.pop();
        System.out.println("   Carga dañada retirada: " + dañado);

        while (!aux.isEmpty())
            buque.push(aux.pop());

        System.out.println("   Resto de la carga re-apilada en orden original.");
    }

    public void mostrarBuque() {
        System.out.println(" BUQUE (tope → fondo) ");
        if (buque.isEmpty()) {
            System.out.println("  (vacío)");
        } else {
            List<Carga> vista = new ArrayList<>(buque);
            for (int i = vista.size() - 1; i >= 0; i--)
                System.out.println("  " + vista.get(i));
        }
    }
}
