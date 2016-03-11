import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by roman on 4/3/16.
 */
public class FlujoArrayCadenas {

    public static void main( String [] args){
        // Definimos el array de obejtos de la clase String
        String [] cadenas = {"Rojo", "Naranja", "Amarillo", "Verde" , "azul", "indigo", "Violeta"};

        // Se muestra las cadenas almacenadas
        System.out.printf("Cadenas originales: %s%n", Arrays.asList(cadenas));

        /**************** E1 *****************/
        // upperCase
        System.out.printf("Cadenas en mayuscula: %s%n", Arrays.stream(cadenas)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));

        /**************** E2 *****************/
        // las cadenas mayores que "m" (sin tener en cuenta mayuscula o minusculas) se ordenan de forma ascendente
        System.out.printf("Cadenas filtradas y ordenadas (orden asc): %s%n", Arrays.stream(cadenas)
                // ordenacion lexicografica detras de la m, osea las palabras que quedan detras de la m
                .filter(s -> s.compareToIgnoreCase("m") > 0)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList()));

        /**************** E2 *****************/
        // las cadenas mayores que "m" (sin tener en cuenta mayuscula o minusculas) se ordenan de forma ascendente
        System.out.printf("Cadenas filtradas y ordenadas (orden desc): %s%n", Arrays.stream(cadenas)
                .filter(s -> s.compareToIgnoreCase("m") > 0)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList()));
    }
}
