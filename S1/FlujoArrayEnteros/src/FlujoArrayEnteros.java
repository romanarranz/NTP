import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;

/**
 * Created by roman on 4/3/16.
 */
public class FlujoArrayEnteros {

    public static void main(String [] args){
        /************* E1 *************/
        // Se rellena un array de objetos de la clase Integer y se observa como los literales se conviernten en objetos
        Integer [] valores = {2,9,5,0,3,7,0,4,8,6};

        // Se muestran los valores originales
        System.out.printf("Valores originales: %s%n",Arrays.asList(valores));

        /************* E2 *************/
        // Se ordenan los valores en orden asc el resultado se muestra directamente en pantalla
        System.out.printf("VAlores ordenados: %s%n", Arrays.stream(valores)
                .sorted()
                .collect(Collectors.toList()));

        /************* E3 *************/
        // Filtrado: se quedan solo los valores > 4
        List<Integer> mayores4 = Arrays.stream(valores)
                .filter(valor -> valor > 4)
                .collect(Collectors.toList());

        // Se muestran los valores filtrados
        System.out.printf("Valores mayores que 4: %s%n", mayores4);

        /************* E4 *************/
        // Se muestran los valores mayores que 4  y ordenados
        System.out.printf("Valores mayores que 4 y ordenados: %s%n", Arrays.stream(valores)
                .filter(valor -> valor > 4)
                .sorted()
                .collect(Collectors.toList()));

        /************* E5 *************/
        // Se ordena la coleccion almacenada en mayores4
        System.out.printf("Valores mayores que 4 y ordenados (sobre coleccion): %s%n",
                mayores4.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
