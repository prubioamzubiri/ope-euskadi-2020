import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        List<Vehiculo> coches = new ArrayList<Vehiculo>();
        List<Vehiculo> motos = new ArrayList<Vehiculo>();

        int seguir;
        Vehiculo vehiculoAIntroducir;

        //Si devuelve 0 no quiere continuar, en cualquier otro numero continua.
        while((seguir = preguntarSeguir()) != 0)
        {
            //Si el no es ni coche ni moto devuelve null
            vehiculoAIntroducir = crearVehiculo();

            if(vehiculoAIntroducir != null)
            {
                if(vehiculoAIntroducir.getTipo().compareTo("moto") == 0)
                {
                    motos.add(vehiculoAIntroducir);
                }
                else
                {
                    coches.add(vehiculoAIntroducir);
                }
            }
        }
        ordenarCoches(coches);
        ordenarMotos(motos);

        System.out.println("Coches: " + coches.size());
        mostrarVehiculos(coches);
        System.out.println("Moto: " + motos.size());
        mostrarVehiculos(motos);

    }

    public static int preguntarSeguir() {
        System.out.println("Desea continuar? introduce 0 para no continuar, cualquier otro numero en caso contrario");
        return scanner.nextInt();
    }

    public static Vehiculo crearVehiculo() {
        
        
        scanner.nextLine(); //limpia buffer
        
        System.out.println("Indica el tipo de vechiculo");
        String tipo = scanner.nextLine().toLowerCase();
        System.out.println("Indica la Marca");
        String marca = scanner.nextLine().toLowerCase();
        System.out.println("Indica su precio");
        float precio = scanner.nextFloat();

        if (tipo.compareTo("moto") == 0 || tipo.compareTo("coche") == 0) {
            return new Vehiculo(tipo, marca, precio);
        }

        return null;
    }

    public static void intercambiarVehiculos(List<Vehiculo> lista, int posicion_a, int posicion_b) {
        Vehiculo aux = lista.get(posicion_a);
        lista.set(posicion_a, lista.get(posicion_b));
        lista.set(posicion_b, aux);
    }

    public static void ordenarCoches(List<Vehiculo> coches) {
        int tamano = coches.size();
        for (int i = 0; i < tamano; i++) {
            for (int j = i; j < tamano; j++) {
                if (coches.get(i).getMarca().compareTo(coches.get(j).getMarca())> 0) {
                    intercambiarVehiculos(coches, i, j);
                }
            }
        }
    }

    public static void ordenarMotos(List<Vehiculo> motos) {
        int tamano = motos.size();
        for (int i = 0; i < tamano; i++) {
            for (int j = i; j < tamano; j++) {
                if (motos.get(i).getPrecio() < motos.get(j).getPrecio()) {
                    intercambiarVehiculos(motos, i, j);
                }
            }
        }
    }

    public static void mostrarVehiculos(List<Vehiculo> lista) {

        int tamano = lista.size();

        for(int i = 0; i < tamano; i++)
        {
            System.out.println(lista.get(i).toString());
        }
    }

}