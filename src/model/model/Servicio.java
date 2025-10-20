package model;

public class Servicio extends Producto {
    private int duracionServicioHoras; // en horas

    public Servicio(String nombreProducto, double precioProducto, int duracionServicioHoras) {
        super(nombreProducto, precioProducto);
        this.duracionServicioHoras = duracionServicioHoras;
    }

    public int getDuracionServicioHoras() {
        return duracionServicioHoras;
    }
    public void duracionServicioHoras(int duracionServicioHoras) { 
        this.duracionServicioHoras = duracionServicioHoras;
    }

    @Override
    public String toString() {
        return super.toString() + ", duracionServicioHoras=" + duracionServicioHoras + "h";
    }

    @Override
    public double calcularDescuento() {
        // Ejemplo: 15% de descuento en servicios
        return getPrecioProducto() * 0.15;
    }


}
