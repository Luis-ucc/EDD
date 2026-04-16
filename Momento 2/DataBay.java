public class DataBay {
 
    public static void main(String[] args) {
 
        Puerto puerto = new Puerto(8, 3, 4); // manifiesto=8, patio=3×4
 
        System.out.println(" Registro de Manifiesto");
        Carga[] llegada = {
            new Carga("C-001", 28.5, 1, false),  
            new Carga("C-002", 15.0, 2, true),   
            new Carga("C-003", 30.0, 3, false),  
            new Carga("C-004", 22.0, 2, false),
            new Carga("C-005", 10.0, 1, true),  
            new Carga("C-006", 18.0, 3, false),
        };
        for (Carga c : llegada) puerto.registrarEnManifiesto(c);
        puerto.mostrarResumenManifiesto();
 
        System.out.println("Patio de Almacenamiento");
        for (Carga c : llegada) puerto.ubicarEnPatio(c);
        puerto.mostrarPatio();
 
        System.out.println(" [Prueba de saturación]");
        try {
            for (int i = 7; i <= 13; i++)
                puerto.ubicarEnPatio(new Carga("X-0" + i, 5.0, 3, false));
        } catch (RuntimeException e) {
            System.out.println("  " + e.getMessage());
        }
 
        System.out.println(" Bahía de Inspección ");
        puerto.enviarAInspeccion();
        System.out.println(" Procesando cola de inspección:");
        for (int i = 0; i < 4; i++) puerto.inspeccionarSiguiente();
 
        System.out.println(" Estiba en el Buque (LIFO + BONO peso)");
 
        Carga[] cargaBuque = {
            new Carga("B-001", 30.0, 3, false),  
            new Carga("B-002", 25.0, 2, false),
            new Carga("B-003", 20.0, 2, false),
            new Carga("B-004", 12.0, 1, false),
            new Carga("B-005", 35.0, 3, false),  
        };
        System.out.println();
        for (Carga c : cargaBuque) puerto.apilarEnBuque(c);
        puerto.mostrarBuque();

        System.out.println(" [retiro de contenedor dañado en el fondo]");
        puerto.retirarCargaDañado();
        puerto.mostrarBuque();
 
    }
}