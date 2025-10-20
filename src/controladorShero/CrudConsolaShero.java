package controladorShero;
import java.util.Scanner;
import java.util.function.Function;

public abstract class CrudConsolaShero<T> {
    public abstract void crear();
    public abstract void listar();
    public abstract void actualizar();
    public abstract void eliminar();

    public final Scanner scanner = new Scanner(System.in);

    public void mostrarOpciones() {
        System.out.println("\n===Seleccione una opción:===");
        System.out.println("1. Crear");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Eliminar");
        System.out.println("0. Volver/Salir");
        System.out.print("Opción: ");
    }

    public int leerEntero(String mensaje) {
        Integer valor = leerNumero(mensaje, Integer::parseInt, "entero");
        return valor.intValue();
    }

    public double leerDouble(String mensaje) {
       Double valor = leerNumero(mensaje, Double::parseDouble, "decimal");
       return valor.doubleValue();
    }
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    protected <N extends Number> N leerNumero(String mensaje, Function<String, N> parser, String tipoDescripcion) {
            while (true) {
            System.out.print(mensaje);
            String linea = scanner.nextLine().trim();
            try {
                return parser.apply(linea);
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número " + tipoDescripcion + ".");
            }
        }
    }
}
