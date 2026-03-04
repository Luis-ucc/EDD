import java.util.Arrays;
import java.util.Random;

public class Muelle {

    private Contenedor[][] matriz;
    private Buque[] buques;

    private static final String[] ORIGENES = {
            "China", "Panama", "Francia", "Mexico", "Japon",
            "Brasil", "USA", "Alemania", "India", "Colombia"
    };

    private static final Random random = new Random();
    private int contadorIdContenedor = 200;

    public Muelle() {
        this.matriz = new Contenedor[10][10];
        this.buques = new Buque[10];
    }

    public Contenedor[][] getMatriz() {
        return matriz;
    }

    public Buque[] getBuques() {
        return buques;
    }


    public String registrarBuque(int id, String nombre, String procedencia, double pesoMaximo) {
        String cadena = "Muelle lleno. No se puede registrar mas buques.";
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                buques[i] = new Buque(id, nombre, procedencia, pesoMaximo);
                cadena = "Buque '" + nombre + "' registrado en el puesto [" + i + "] | Peso maximo: " + pesoMaximo
                        + "t\n";
                cadena += generarContenedoresDeBuque(pesoMaximo);
                break;
            }
        }
        return cadena;
    }

    private String generarContenedoresDeBuque(double pesoMaximo) {
        String cadena = "";
        double pesoTotal = 0;
        int intentos = 0;

        while (pesoTotal < pesoMaximo && intentos < 1000) {
            int col = random.nextInt(10);
            String origen = ORIGENES[random.nextInt(ORIGENES.length)];

            double pesoRestante = pesoMaximo - pesoTotal;
            double maxPosible = Math.min(30.0, pesoRestante);
            if (maxPosible < 5.0)
                break;

            double peso = Math.round((5.0 + random.nextDouble() * (maxPosible - 5.0)) * 10.0) / 10.0;

            boolean colocado = false;
            for (int fila = 9; fila >= 0; fila--) {
                if (matriz[fila][col] == null) {
                    matriz[fila][col] = new Contenedor(contadorIdContenedor++, origen, peso);
                    pesoTotal += peso;
                    cadena += "  -> Contenedor [" + (contadorIdContenedor - 1) +
                            "] | Origen: " + origen +
                            " | Peso: " + peso + "t" +
                            " | Posicion: [" + fila + "][" + col + "]\n";
                    colocado = true;
                    break;
                }
            }
            if (!colocado)
                intentos++;
        }

        cadena += String.format("  Total cargado: %.2ft de %.2ft%n", pesoTotal, pesoMaximo);
        return cadena;
    }

    public String listarBuques() {
        String cadena = "";
        int count = 0;
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] != null) {
                cadena += "  Puesto [" + i + "] -> " + buques[i].toString() + "\n";
                count++;
            }
        }
        if (count == 0)
            cadena = "  No hay buques registrados.";
        return cadena;
    }

    public String puestosDisponiblesBuques() {
        String cadena = "  Puestos libres para buques: ";
        int count = 0;
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                cadena += "[" + i + "] ";
                count++;
            }
        }
        if (count == 0)
            cadena = "  No hay puestos disponibles para buques.";
        return cadena;
    }

    public String pesoTotalContenedores() {
        double total = 0;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] != null) {
                    total += matriz[i][j].getPeso();
                    count++;
                }
            }
        }
        return String.format("Peso total de %d contenedor(es): %.2f toneladas.", count, total);
    }

    public String listarPorOrigen() {
        String cadena = "";
        String[] origenes = new String[100];
        int numOrigenes = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] != null) {
                    String org = matriz[i][j].getOrigen();
                    boolean existe = false;
                    for (int k = 0; k < numOrigenes; k++) {
                        if (origenes[k].equals(org)) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe)
                        origenes[numOrigenes++] = org;
                }
            }
        }

        if (numOrigenes == 0)
            return "  No hay contenedores en el muelle.";

        for (int k = 0; k < numOrigenes; k++) {
            cadena += "\n  Origen: " + origenes[k] + "\n";
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (matriz[i][j] != null && matriz[i][j].getOrigen().equals(origenes[k])) {
                        cadena += "    [" + i + "][" + j + "] -> " + matriz[i][j].toString() + "\n";
                    }
                }
            }
        }
        return cadena;
    }

    public String mostrarMatriz() {
        String cadena = "\n     ";
        for (int j = 0; j < 10; j++)
            cadena += String.format(" C%-3d", j);
        cadena += "\n     " + "-".repeat(50) + "\n";
        for (int i = 0; i < 10; i++) {
            cadena += String.format("F%-3d |", i);
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j] == null)
                    cadena += "  _  ";
                else
                    cadena += String.format(" %-3d ", matriz[i][j].getId());
            }
            cadena += "\n";
        }
        cadena += "\n  F=Fila  C=Columna  _=Libre  numero=ID contenedor\n";
        return cadena;
    }

    public String puestosDisponiblesContenedores() {
        String cadena = "  Espacios libres por columna:\n";
        for (int j = 0; j < 10; j++) {
            int libres = 0;
            for (int i = 0; i < 10; i++) {
                if (matriz[i][j] == null)
                    libres++;
            }
            cadena += "    Columna [" + j + "]: " + libres + " espacio(s) libre(s)\n";
        }
        return cadena;
    }

    @Override
    public String toString() {
        return "Muelle{buques=" + Arrays.toString(buques) + "}";
    }
}