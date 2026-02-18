public class EjecutarMoto {
    public static void main(String[] args) {

        Moto[] m = new Moto[8];

        m[0] = new Moto(2026, "akt", "negra", 125, 1250.0);
        m[1] = new Moto(2025, "Kawasaki", "Verde", 400, 25000.0);
        m[2] = new Moto(2026, "Honda", "rojo", 350, 4000.0);
        m[3] = new Moto(2027, "Honda C90", "DoradoNegro", 90.0, 10000.0);
        m[4] = new Moto(2025, "Yamaha", "Azul", 125, 2300.0);
        m[5] = new Moto(2026, "Suzuki", "Azul", 150.0, 2350.0);
        m[6] = new Moto(2026, "BMW", "Gris", 1200.0, 40000.0);
        m[7] = new Moto(2026, "Harley Davidson", "Negro", 1800.0, 35000.0);

        // operaciones

        int suma = 0;

        for (int i = 0; i < m.length; i++) {
            suma += m[i].getModelo();
        } 
        System.out.println("el promedio de los modelos de las motos del arreglo es: " + (suma / m.length));

        // presupuesto de 20000 dolares
        String cad = "\n";
        for (int i = 0; i < m.length; i++) {
            if (m[i].getPrecio() <= 20000.0) {
                cad += "-" + m[i].getMarca() + ": " + m[i].getPrecio() + " \n";
            }
        }

        System.out.println("las motos que puedo comprar con 20.000.0 US son: " + cad);

    }
}
