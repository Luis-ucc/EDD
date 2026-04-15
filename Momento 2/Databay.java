

public class Databay {
    public static void main(String[] args) {
         
        almacenamiento puerto = new almacenamiento(8, 3 ,4);

        Manifiesto c1 = new Manifiesto("C001", 10.5, 1, true);
        Manifiesto c2 = new Manifiesto("C002", 8.0, 2, false);
        Manifiesto c3 = new Manifiesto("C003", 12.0, 1, false);
        Manifiesto c4 = new Manifiesto("C004", 5.0, 3, true);
        Manifiesto c5 = new Manifiesto("C005", 7.5, 2, false);
        Manifiesto c6 = new Manifiesto("C006", 9.0, 1, false);
        
        Manifiesto[] llegada = {c1, c2, c3, c4, c5, c6};
        
        for (Manifiesto c : llegada) almacenamiento.registrarmanifiesto(c);
        almacenamiento.mostrarManifiesto();
        for (Manifiesto c : llegada) almacenamiento.ubicarpatio(c);
        almacenamiento.mostrarpatio();

        System.out.println(" prueba saturacion");
        try {
            for (int i = 7; i <= 13; i++) {
                almacenamiento.ubicarpatio(new Manifiesto("X-0" + i, 5.0, 2, false));
            }
        } catch (RuntimeException e) {
            System.out.println(" " + e.getMessage());
        }

        System.out.println(" Envio a inspeccion");
        almacenamiento.enviarinspeccion();
        System.out.println(" procesando cola de inspeccion");
        for (int i = 0; i < 4; i++) almacenamiento.inspeccionarSiguiente();

        System.out.println("Estiba en el buque");

        Manifiesto[] cargabuque = {
            new Manifiesto("C001", 30.0, 3, false),
            new Manifiesto("C002", 25.0, 2, false),
            new Manifiesto("C003", 20.0, 2, false),
            new Manifiesto("C004", 12.0, 1, false),
            new Manifiesto("C005", 35.0, 3, false),
        };
        System.out.println();
        for (Manifiesto c : cargabuque) almacenamiento.apilarenbuque(c);
        almacenamiento.mostrarBuque();

        System.out.println("retiro de buque lleno en el fondo");
        almacenamiento.retirarContenedor();
        almacenamiento.mostrarBuque();

        






    }
}