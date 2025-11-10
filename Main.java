// Clase abstracta Producto
abstract class Producto {
    protected String nombre;
    protected double precio;
    protected int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Método abstracto
    public abstract void mostrarInformacion();

    // Método común
    public void aplicarDescuento(double porcentaje) {
        precio -= precio * (porcentaje / 100);
    }
}

// Subclase Electronico
class Electronico extends Producto {
    private int garantiaMeses;

    public Electronico(String nombre, double precio, int cantidad, int garantiaMeses) {
        super(nombre, precio, cantidad);
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Electrónico: " + nombre +
                " | Precio: $" + precio +
                " | Garantía: " + garantiaMeses + " meses");
    }
}

// Subclase Alimento
class Alimento extends Producto {
    private String fechaCaducidad;

    public Alimento(String nombre, double precio, int cantidad, String fechaCaducidad) {
        super(nombre, precio, cantidad);
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Alimento: " + nombre +
                " | Precio: $" + precio +
                " | Caducidad: " + fechaCaducidad);
    }
}

// Subclase Ropa
class Ropa extends Producto {
    private String talla;

    public Ropa(String nombre, double precio, int cantidad, String talla) {
        super(nombre, precio, cantidad);
        this.talla = talla;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Ropa: " + nombre +
                " | Precio: $" + precio +
                " | Talla: " + talla);
    }
}

// Clase principal
public class Main {
    public static void main(String[] args) {
        Producto p1 = new Electronico("Laptop Lenovo", 15000, 5, 24);
        Producto p2 = new Alimento("Cereal Integral", 60, 20, "12/2025");
        Producto p3 = new Ropa("Playera Blanca", 250, 15, "M");

        Producto[] inventario = {p1, p2, p3};

        System.out.println("=== Inventario ===");
        for (Producto p : inventario) {
            p.mostrarInformacion(); // Polimorfismo
        }

        System.out.println("\nAplicando descuento del 10% en todos los productos:");
        for (Producto p : inventario) {
            p.aplicarDescuento(10);
            p.mostrarInformacion();
        }
    }
}
