import java.util.Scanner;

public class Ejecutador {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Muelle muelle = new Muelle();

        System.out.println(muelle.registrarBuque(1, "Ever Given", "Panama", 120.0));
        System.out.println(muelle.registrarBuque(2, "MSC Oscar", "China", 90.0));
        System.out.println(muelle.registrarBuque(3, "CMA CGM Antoine", "Francia", 75.0));
        System.out.println(muelle.registrarBuque(4, "HMM Algeciras", "Corea", 100.0));

        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero();
            switch (opcion) {
                case 1 -> menuBuques(muelle);
                case 2 -> menuContenedores(muelle);
                case 3 -> System.out.println("\n" + muelle.pesoTotalContenedores());
                case 4 -> {
                    System.out.println("\n--- CONTENEDORES AGRUPADOS POR ORIGEN ---");
                    System.out.println(muelle.listarPorOrigen());
                }
                case 0 -> System.out.println("\nCerrando aplicacion. Hasta luego!");
                default -> System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    static void mostrarMenuPrincipal() {
        System.out.println("   LOGISTICA DISTRIBUCIONES JH - MUELLE  ║");
        System.out.println("  1. Menu de Buques                       ");
        System.out.println("  2. Menu de Contenedores                 ");
        System.out.println("  3. Peso total de los contenedores       ");
        System.out.println("  4. Listar contenedores por origen       ");
        System.out.println("  0. Cerrar aplicacion                    ");
        System.out.print("Seleccione una opcion: ");
    }

    static void menuBuques(Muelle muelle) {
        int opcion;
        do {
            System.out.println("           MENU DE BUQUES                 ");
            System.out.println("  1. Registrar nuevo buque                ");
            System.out.println("  2. Listar buques registrados            ");
            System.out.println("  3. Ver puestos disponibles              ");
            System.out.println("  0. Volver al menu principal             ");
            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero();
            switch (opcion) {
                case 1 -> registrarBuque(muelle);
                case 2 -> {
                    System.out.println("\n--- BUQUES EN EL MUELLE ---");
                    System.out.println(muelle.listarBuques());
                }
                case 3 -> System.out.println("\n" + muelle.puestosDisponiblesBuques());
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    static void registrarBuque(Muelle muelle) {
        System.out.println("\n--- REGISTRAR BUQUE ---");
        System.out.println(muelle.puestosDisponiblesBuques());
        System.out.print("ID:          ");
        int id = leerEntero();
        System.out.print("Nombre:      ");
        String nom = sc.nextLine().trim();
        System.out.print("Procedencia: ");
        String proc = sc.nextLine().trim();
        System.out.print("Peso maximo (toneladas): ");
        double cap = leerDouble();
        System.out.println(muelle.registrarBuque(id, nom, proc, cap));
    }

    static void menuContenedores(Muelle muelle) {
        int opcion;
        do {
            System.out.println("           MENU DE CONTENEDORES              ");
            System.out.println("  1. Ver esquema del muelle (matriz)      ");
            System.out.println("  2. Ver puestos disponibles por columna  ");
            System.out.println("  0. Volver al menu principal             ");
            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero();
            switch (opcion) {
                case 1 -> System.out.println(muelle.mostrarMatriz());
                case 2 -> System.out.println("\n" + muelle.puestosDisponiblesContenedores());
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un entero valido: ");
            }
        }
    }

    static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un decimal valido: ");
            }
        }
    }
}