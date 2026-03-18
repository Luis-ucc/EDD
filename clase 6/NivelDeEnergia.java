import java.util.Random;

public class NivelDeEnergia {

    private Random random = new Random();

    public int[] generarEnergiaContenedores() {
        int[] energiaContenedores = new int[12];

        for (int i = 0; i < 12; i++) {
            energiaContenedores[i] = random.nextInt(101) + 50;
            System.out.print(energiaContenedores[i] + " ");
        }
        System.out.println();

        return energiaContenedores;
    }

public int[] filtrarMultiplosDe10(int[] energiaContenedores) {
    int contador = 0;

    for (int i = 0; i < energiaContenedores.length; i++) {
        int energia = energiaContenedores[i];

        if (energia % 10 == 0) {
            contador++;
        }
    }

    int[] filtrados = new int[contador];
    int indice = 0;
    
    for (int i = 0; i < energiaContenedores.length; i++) {
        int energia = energiaContenedores[i];

        if (energia % 10 == 0) {
            filtrados[indice] = energia;
            System.out.print(energia + " ");
            indice++;
        }
    }

    return filtrados;
}
}
