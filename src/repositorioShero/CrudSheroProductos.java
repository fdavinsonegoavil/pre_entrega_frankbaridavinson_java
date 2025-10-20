package repositorioShero;
import java.util.ArrayList;

import controladorShero.CrudConsolaShero;
import model.Producto;
import model.Servicio;
import model.Articulo;
import model.Categoria;

public class CrudSheroProductos extends CrudConsolaShero<Producto> {
    
    private final ArrayList<Producto> productos;
    private final ArrayList<Categoria> categorias;
    
    public CrudSheroProductos(ArrayList<Producto> productos, ArrayList<Categoria> categorias) {
        this.productos = productos;
        this.categorias = categorias;
    }

    @Override
    public void crear() {
        System.out.println("1) Crear Artículo");
        System.out.println("2) Crear Servicio");
        int op = leerEntero("Elegi una opción: ");
        switch (op) {
        
            case 1:
                crearArticulo();
                break;
            case 2: 
                crearServicio();
                break;
            default:
                System.out.println("Opción inválida.");
                leerEntero("Elegi una opción: ");
                break;
        }
    }
    @Override
    public void listar() {
        System.out.println("1) Listar Artículos");
        listarProductos();
    }

    @Override
    public void actualizar() {
         int id = leerEntero("Id del producto: ");
    for (Producto p : productos) {
        if (p.getIdProducto() == id) {
            actualizarDatosGenerales(p);
            actualizarCategoria((Articulo) p);
            actualizarDuracion((Servicio) p);
            }

            System.out.println("Actualizado: " + p);
            return;
        }
        System.out.println("No se encontró producto con id " + id);
    
    }

 

    @Override
    public void eliminar() {
        int id = leerEntero("Id del producto a eliminar: ");
        boolean eliminado = productos.removeIf(p -> p.getIdProducto() == id);
        
        if (eliminado) {
            System.out.println("Producto eliminado.");
        } else {
        throw new java.util.NoSuchElementException("Producto con ID " + id + " no encontrado.");
        }
        
    }


    /*FUNCIONES AUXILIARES */
   
    private void crearArticulo(){
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        if (categorias.isEmpty()) {
        System.out.println("No hay categorías disponibles. Por favor, cree una categoría primero.");
        return;
        }
        System.out.println("Categorías:");
        for (Categoria c : categorias) {
            System.out.println(c.getIdCategoria() + ") " + c.getNombreCategoria());
        }
        int idCat = leerEntero("Elegí id de categoría: ");
        Categoria seleccionada = categorias.stream()
                                            .filter(c -> c.getIdCategoria() == idCat)
                                            .findFirst()
                                            .orElse(null);

        if (seleccionada == null) {
            System.out.println("Categoría inválida.");
            return;
        }
        productos.add(new Articulo(nombre, precio, seleccionada));
        System.out.println("Artículo creado.");
    }

    private void crearServicio(){
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int duracion = leerEntero("Duración (horas): ");
        productos.add(new Servicio(nombre, precio, duracion));
        System.out.println("Servicio creado.");
    }

    private void listarProductos() {
      
        if (productos.isEmpty()) {
            throw new java.util.NoSuchElementException("No hay productos registrados.");
        }else{
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }
    private void actualizarDatosGenerales(Producto p) {
    String nuevoNombre = leerTexto("Nuevo nombre: ");
    double nuevoPrecio = leerDouble("Nuevo precio: ");
    p.setNombreProducto(nuevoNombre);
    p.setPrecioProducto(nuevoPrecio);
}

private void actualizarCategoria(Articulo articulo) {
    System.out.println("¿Cambiar categoría? 1=Sí / 0=No");
    int cam = leerEntero("Opción: ");
    if (cam == 1) {
        for (Categoria c : categorias) {
            System.out.println(c.getIdCategoria() + ") " + c.getNombreCategoria());
        }
        int idCat = leerEntero("Elegí id de categoría: ");
        for (Categoria c : categorias) {
            if (c.getIdCategoria() == idCat) {
                articulo.setCategoria(c);
                break;
            }
        }
    }
}

private void actualizarDuracion(Servicio servicio) {
    System.out.println("¿Cambiar duración (horas)? 1=Sí / 0=No");
    int cam = leerEntero("Opción: ");
    if (cam == 1) {
        int dur = leerEntero("Nueva duración (horas): ");
        servicio.setDuracionHoras(dur);
    }
}
}
