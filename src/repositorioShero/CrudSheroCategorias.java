package repositorioShero;
import java.util.ArrayList;

import controladorShero.CrudConsolaShero;
import model.Categoria;

public class CrudSheroCategorias extends CrudConsolaShero <Categoria> {
    private final ArrayList<Categoria> categorias;
    public CrudSheroCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    @Override
    public void crear() {
        String nombre = leerTexto("Ingrese el nombre de la categoría: ");
        categorias.add(new Categoria(nombre));
        System.out.println("Categoría creada.");

    }
    @Override
    public void listar() {
        System.out.println("\n===Lista de Categorías===");
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías registradas.");
        } else {
            for (Categoria cat : categorias) {
                System.out.println(cat);
            }
        }
    }
    @Override
    public void actualizar() {

        int id = leerEntero("Ingrese el ID de la categoría a actualizar: ");
        for (Categoria cat : categorias) {
            if (cat.getIdCategoria() == id) {
                String nuevoNombre = leerTexto("Ingrese el nuevo nombre de la categoría: ");
                cat.setNombreCategoria(nuevoNombre);
                System.out.println("Categoría actualizada.");
                return;
            }
        }
        System.out.println("Categoría con ID " + id + " no encontrada.");
    }
    @Override
    public void eliminar() {
        int id = leerEntero("Ingrese el ID de la categoría a eliminar: ");
        for (int i = 0; i < categorias.size(); i++) {
            if (categorias.get(i).getIdCategoria() == id) {
                categorias.remove(i);
                System.out.println("Categoría eliminada.");
                return;
            }
        }
        System.out.println("Categoría con ID " + id + " no encontrada.");
    }

   
}
