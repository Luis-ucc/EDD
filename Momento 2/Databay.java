public class databay {
    public static void main(String[] args) {
         
        Puerto puerto = new Puerto(8, 3 ,4);

        Contenedor c1 = new Contenedor("C001", 10.5, 1, true);
        Contenedor c2 = new Contenedor("C002", 8.0, 2, false);
        Contenedor c3 = new Contenedor("C003", 12.0, 1, false);
        Contenedor c4 = new Contenedor("C004", 5.0, 3, true);
        Contenedor c5 = new Contenedor("C005", 7.5, 2, false);
        Contenedor c6 = new Contenedor("C006", 9.0, 1, false);
        
        for (contenedor c : llegada) puerto.registrarmanifiesto(c);
        puerto.mostrarManifiesto();
        for (Contenedor c : llegada) puerto.ubicarpatio(c);
        puerto.mostrarpatio();

        System.out.println(" prueba saturacion");
        try {
            for (int i = 7; i <= 13; i++) {
                puerto.ubicarpatio(new Contenedor("C00" + i, 6.0, 2, false));
            } catch (RuntimeException e) {
                System.out.println(" " + e.getMessage());
            }
        }

        System.out.println(" Envio a inspeccion");
        puerto.enviarinspeccion();
        System.out.println(" procesando cola de inspeccion");
        for (int i = 0; i < 4; i++) puerto.inspeccionarSiguiente();

        System.out.println("Estiba en el buque");

        Contenedor[] cargabuque = {
            new Contenedor("C001", 30.0, 3, false),
            new Contenedor("C002", 25.0, 2, false),
            new Contenedor("C003", 20.0, 2, false),
            new Contenedor("C004", 12.0, 1, false),
            new Contenedor("C005", 35.0, 3, false),
        };
        System.out.println();
        for (contenedor c : cargabuque) puerto.apilarenbuque(c);
        puerto.mostrarBuque();

        System.out.println("retiro de buque lleno en el fondo");
        puerto.retirarContenedor();
        puerto.mostrarBuque();

        






    }
}