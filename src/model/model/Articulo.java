package model;
public class Articulo extends Producto{    
    private Categoria categoria;

    public Articulo(String nombreProducto, double precioProducto, Categoria categoria) {
        super(nombreProducto, precioProducto);
        this.categoria = categoria;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString() {
        return "Articulo{" +
                "idProducto=" + getIdProducto() +
                ", nombreProducto='" + getNombreProducto() + '\'' +
                ", precioProducto=" + getPrecioProducto() +
                ", categoria=" + categoria +
                '}';
    }
    @Override
    public double calcularDescuento() {
       
        return getPrecioProducto() * 0.10;
    }

   
}