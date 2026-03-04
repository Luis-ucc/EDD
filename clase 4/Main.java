import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Arreglo precargado con productos
        Producto[] arreglo = {
                new Producto(101, "roba de arroz", 150.00, 10),
                new Producto(202, "harina", 25.99, 3),
                new Producto(303, "sal", 89.99, 7),
                new Producto(404, "azucar", 350.00, 2),
                new Producto(505, "leche", 45.00, 4),
                new Producto(606, "panela", 120.00, 6),
                new Producto(707, "panal de huevos", 75.00, 12),
                new Producto(808, "Aceite", 60.00, 1),
        };

        Inventario inventario = new Inventario(arreglo);

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero();
            switch (opcion) {
                case 1 -> agregarProducto(inventario);
                case 2 -> buscarProducto(inventario);
                case 3 -> actualizarStock(inventario);
                case 4 -> System.out.println("\n" + inventario.generarInformeValorTotal());
                case 5 -> System.out.println(
                        "\n--- PRODUCTOS CON STOCK BAJO (< 5 unidades) ---\n" + inventario.obtenerProductosAgotados());
                case 6 -> {
                    System.out.println("\n" + inventario.ordenarPorPrecioDescendente());
                    System.out.println(inventario.toString());
                }
                case 7 -> System.out.println("\n" + inventario.toString());
                case 0 -> System.out.println("\nSaliendo del sistema. Hasta luego!");
                default -> System.out.println("\nOpcion no valida. Intente de nuevo.");
            }
        } while (opcion != 0);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE INVENTARIO - MENU");
        System.out.println("========================================");
        System.out.println("  1. Agregar producto");
        System.out.println("  2. Buscar producto por ID");
        System.out.println("  3. Actualizar stock");
        System.out.println("  4. Ver valor total del inventario");
        System.out.println("  5. Ver productos agotados (< 5 unidades)");
        System.out.println("  6. Ordenar por precio descendente");
        System.out.println("  7. Mostrar inventario completo");
        System.out.println("  0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    static void agregarProducto(Inventario inventario) {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        System.out.print("ID:             ");
        int id = leerEntero();
        System.out.print("Nombre:         ");
        String nombre = sc.nextLine().trim();
        System.out.print("Precio:         ");
        double precio = leerDouble();
        System.out.print("Cantidad stock: ");
        int stock = leerEntero();

        Producto p = new Producto(id, nombre, precio, stock);
        System.out.println(inventario.agregarProducto(p));
    }

    static void buscarProducto(Inventario inventario) {
        System.out.print("\nIngrese el ID a buscar: ");
        int id = leerEntero();
        System.out.println(inventario.buscarPorId(id));
    }

    static void actualizarStock(Inventario inventario) {
        System.out.print("\nIngrese el ID del producto: ");
        int id = leerEntero();
        System.out.print("Nueva cantidad en stock:   ");
        int nuevaCantidad = leerEntero();
        System.out.println(inventario.actualizarStock(id, nuevaCantidad));
    }

    static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero entero valido: ");
            }
        }
    }

    static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un numero decimal valido: ");
            }
        }
    }
}