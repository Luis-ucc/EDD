public class Profesor extends Persona {
    String departamento;
    double salario;

    public Profesor(
            String nombre,
            String id,
            String email,
            String departamento,
            double salario) {
        super(nombre, id, email);
        this.departamento = departamento;
        this.salario = salario;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== PROFESOR ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id);
        System.out.println("Departamento: " + departamento);
        System.out.println("Salario: " + salario);
    }
}
