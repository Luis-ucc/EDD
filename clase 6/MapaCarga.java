public class MapaCarga {

    public int[][] crearMapa(int[] energiaFiltrada) {
        int[][] mapaCarga = new int[3][3];
        int indice = 0;
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (indice < energiaFiltrada.length) {
                    
                    mapaCarga[i][j] = energiaFiltrada[indice];
                    indice++;
                } else {
                    mapaCarga[i][j] = -1;
                }
            }
        }
        
        return mapaCarga;
    }

        public void mostrarMapa(int[][] mapa) {
        System.out.println("    Col 0   Col 1   Col 2");
        for (int i = 0; i < 3; i++) {
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < 3; j++) {
                if (mapa[i][j] == -1) {
                    System.out.print("[VACÍO]   ");
                } else {
                    System.out.printf("[%3d]   ", mapa[i][j]);
                }
            }
            System.out.println();
        }
    }


}
