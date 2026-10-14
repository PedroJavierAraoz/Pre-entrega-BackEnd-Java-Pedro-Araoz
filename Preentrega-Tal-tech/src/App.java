import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tech.productos.Producto;
import com.tech.utils.EntradaConsola;

public class App {
  public static void main(String[] args) throws Exception {
        List<Producto> productos=  new ArrayList<Producto>();
        Scanner s= new Scanner(System.in);
        String opcion;

        do{
             opcion= printMenu(s,"Elija una opcion : ");
            
             switch (opcion) {
                case "1":
                    listarProductos(productos);
                    break;
                case "2":
                    agregarProducto(s, productos);
                    break;
                case "3":
                    eliminarProducto(s, productos);
                    break;
                case "4":
                    modificarProducto(s,productos);
                    break;
                default:
                    break;
             }

            } while (!"5".equals(opcion));
    }

    private static void listarProductos(List<Producto> productos) {
        System.out.println("Listado de productos existentes");
        System.out.println("======= == ========= ==========");
        if (productos.size()==0){
            System.out.println("El listado de  productos esta vacio.");
            return;
        }
        for(Producto p:productos){
            System.out.println(p.toString());
        }
        
    }
    
    private static void agregarProducto(Scanner s, List<Producto> productos) {
        Producto ingreso=leerProducto(s);
        productos.add(ingreso);
        
    }

    private static void eliminarProducto(Scanner s, List<Producto> productos) {
        String producto = EntradaConsola.leerTexto(s, "Ingrese el nombre del producto que a  eliminar : ").trim();
        int indiceDelProducto=buscarProductoPorNombre(productos, producto);
        if (indiceDelProducto <0){
            System.out.print("El producto '"+producto+"' no fue encontrado");
            return ;
            }
        productos.remove(indiceDelProducto);
        System.out.print("El producto '"+producto+"' fue eliminado");
    }


    private static void modificarProducto(Scanner s, List<Producto> productos) {
        String nomProducto = EntradaConsola.leerTexto(s, "Ingrese el nombre del producto que desea modificar: ").trim();
        int indice = buscarProductoPorNombre(productos,nomProducto);

        if (indice < 0) {
            System.out.println("El producto '" + nomProducto + "' no fue encontrado.");
            return;
        }

        System.out.print("Vamos  a modificar el producto ");
        Producto nuevoProducto = leerProducto(s);
        productos.set(indice, nuevoProducto);
        System.out.println("El producto fue modificado correctamente.");
    }

    public static int  buscarProductoPorNombre(List<Producto> productos, String nombre){
        //devuelve el indice  donde  esta  almacenado el producto
        for(Producto p: productos){
            if (p.getNombre().equals(nombre)){
                return productos.indexOf(p);
            }
        }
        return -1;
    }

    public static String printMenu(Scanner s, String mensaje){
        limpiarPantalla();
        System.out.println("Menu de opciones");
        System.out.println("==== == ========");
        System.out.println("1- Listar productos");
        System.out.println("2- Agregar producto");
        System.out.println("3- Eliminar producto");
        System.out.println("4- Modificar producto");
        System.out.println("5- Salir");
        return EntradaConsola.leerTexto(s, mensaje);
    }

    public static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static Producto leerProducto(Scanner s){
        String codigo = EntradaConsola.leerTexto(s, "Ingrese el codigo del producto: ").trim();
        String nombre = EntradaConsola.leerTexto(s, "Ingrese el nombre del producto: ").trim();
        double precio = EntradaConsola.leerDouble(s, "Ingrese el precio del producto: ");
        return new Producto(codigo, nombre,precio);
    }

}
