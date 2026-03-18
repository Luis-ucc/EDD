public class Prin {

    public static void main(String[] args) {

        NivelDeEnergia nivelEnergia = new NivelDeEnergia();

        int[] energiaContenedores = nivelEnergia.generarEnergiaContenedores();

        int[] energiaFiltrada = nivelEnergia.filtrarMultiplosDe10(energiaContenedores);

        MapaCarga mapa = new MapaCarga();
        
        int[][] mapaCarga = mapa.crearMapa(energiaFiltrada);
        mapa.mostrarMapa(mapaCarga);

        Suministro[] manifiesto = new Suministro[9];
        int posicion = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int valor = mapaCarga[i][j];

                if (valor != -1) {
                    String id = "C-" + i + "-" + j;
                    String prioridad = (valor > 100) ? "ALTA" : "ESTÁNDAR";

                    manifiesto[posicion] = new Suministro(id, valor, prioridad);
                } else {
                    manifiesto[posicion] = null;
                }
                posicion++;
            }
        }

        for (int i = 0; i < manifiesto.length; i++) {
            System.out.println("Posición " + i + ": " + manifiesto[i]);
        }

    }
}
