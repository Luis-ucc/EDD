import java.util.Arrays;

public class Inventario {

    private Producto[] producto;

    public Inventario(Producto[] producto) {
        this.producto = producto;
    }

    public Producto[] getProducto() {
        return producto;
    }

    public void setProducto(Producto[] producto) {
        this.producto = producto;
    }

    // 1. Agregar producto en la primera posicion disponible (null)
    public String agregarProducto(Producto p) {
        String cadena = "Inventario lleno. No se pudo agregar: " + p.getNombre();
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] == null) {
                producto[i] = p;
                cadena = "Producto '" + p.getNombre() + "' agregado correctamente.";
                break;
            }
        }
        return cadena;
    }

    // 2. Buscar por ID
    public String buscarPorId(int id) {
        String cadena = "Producto NO Encontrado....";
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] != null && id == producto[i].getId()) {
                cadena = producto[i].toString();
                break;
            }
        }
        return cadena;
    }

    // 3. Actualizar stock
    public String actualizarStock(int id, int nuevaCantidad) {
        String cadena = "Producto con ID " + id + " NO Encontrado....";
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] != null && id == producto[i].getId()) {
                producto[i].setCantidadStock(nuevaCantidad);
                cadena = "Stock de '" + producto[i].getNombre() + "' actualizado a " + nuevaCantidad + " unidades.";
                break;
            }
        }
        return cadena;
    }

    // 4. Generar informe valor total (precio x cantidad)
    public String generarInformeValorTotal() {
        double total = 0;
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] != null) {
                total += producto[i].getPrecio() * producto[i].getCantidadStock();
            }
        }
        return String.format("Valor total del inventario: $%.2f", total);
    }

    // 5. Obtener productos agotados (stock < 5)
    public String obtenerProductosAgotados() {
        String cadena = "";
        int count = 0;
        for (int i = 0; i < producto.length; i++) {
            if (producto[i] != null && producto[i].getCantidadStock() < 5) {
                cadena += producto[i].toString() + "\n";
                count++;
            }
        }
        if (count == 0) {
            cadena = "No hay productos con stock bajo.";
        }
        return cadena;
    }

    // Reto: Ordenar por precio descendente (Bubble Sort)
    public String ordenarPorPrecioDescendente() {
        for (int i = 0; i < producto.length - 1; i++) {
            for (int j = 0; j < producto.length - i - 1; j++) {
                if (producto[j] != null && producto[j + 1] != null) {
                    if (producto[j].getPrecio() < producto[j + 1].getPrecio()) {
                        Producto temp = producto[j];
                        producto[j] = producto[j + 1];
                        producto[j + 1] = temp;
                    }
                }
            }
        }
        return "Inventario ordenado por precio descendente.";
    }

    @Override
    public String toString() {
        return "Inventario [producto=" + Arrays.toString(producto) + "]";
    }
}