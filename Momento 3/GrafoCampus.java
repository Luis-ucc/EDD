import java.util.*;

public class GrafoCampus {
    String[] edificios = {
            "Biblioteca",
            "Ingenieria",
            "Cafeteria",
            "Laboratorios",
            "Administracion"
    };
    int[][] distancias = {
            { 0, 200, 400, 350, 500 },
            { 200, 0, 150, 300, 450 },
            { 400, 150, 0, 250, 200 },
            { 350, 300, 250, 0, 100 },
            { 500, 450, 200, 100, 0 }
    };

    public void dijkstra(int origen, int destino) {
        int n = distancias.length;
        int[] distancia = new int[n];
        boolean[] visitado = new boolean[n];
        int[] previo = new int[n];
        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(previo, -1);
        distancia[origen] = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = minimo(distancia, visitado);
            visitado[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visitado[v] &&
                        distancias[u][v] != 0 &&
                        distancia[u] + distancias[u][v] < distancia[v]) {
                    distancia[v] = distancia[u] + distancias[u][v];
                    previo[v] = u;
                }
            }
        }
        System.out.println("Distancia total: " + distancia[destino]);
        imprimirRuta(previo, destino);
    }

    int minimo(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE;
        int indice = -1;
        for (int i = 0; i < distancia.length; i++) {
            if (!visitado[i] && distancia[i] < min) {
                min = distancia[i];
                indice = i;
            }
        }
        return indice;
    }

    void imprimirRuta(int[] previo, int j) {
        if (j == -1)
            return;
        imprimirRuta(previo, previo[j]);
        System.out.print(edificios[j] + " -> ");
    }
}
