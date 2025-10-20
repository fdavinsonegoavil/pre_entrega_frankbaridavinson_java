package model;

public abstract class Producto implements Vendible {
    private int idProducto;
    private String nombreProducto;
    private double precioProducto;
    
    private static int contadorProductos = 1;

    public Producto(String nombreProducto, double precioProducto) {
        this.idProducto = contadorProductos++;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public double getPrecioProducto() {
        return precioProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precioProducto=" + precioProducto +
                '}';
    }

}
