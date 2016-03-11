import com.sun.xml.internal.bind.api.impl.NameConverter;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.List;

/**
 * Created by roman on 7/3/16.
 */
public class FlujoLineas {

    public static void main(String [] args) throws IOException{
        // Se define un patron que representa varios espacios en blanco
        Pattern pattern = Pattern.compile("\\s+");

        // Se cuentan las ocurrencias de cada palabra
        // Se usa un mapa para almacenar pares tipo <palabra - contador>
        // 1. las lineas se toman del archivo de texto. El metodo lines crea un flujo con el texto de cada linea
        // 2. cada linea se trata como una cadena, un objeto de la clase String
        // 3. se hace mapeo para quitar de cada linea los apostrofes y cualquier signo de puntuacion
        // 4. separa cada linea en las palabras que contiene
        // 5. itera sobre el flujo

        // Path absolute
        Files.lines(Paths.get("alicia.txt"), StandardCharsets.ISO_8859_1)
                .forEach(System.out::prinln);

        Map<String, Long> contadores = Files.lines(Paths.get("alicia.txt"), StandardCharsets.ISO_8859_1)
                .map(linea -> linea.replaceAll("(?!')\\p{Punct}", ""))
                .flatMap(linea -> pattern.splitAsStream(linea))
                .filter(palabra -> !palabra.isEmpty())
                .collect(
                        Collectors.groupingBy(
                                String::toLowerCase,
                                TreeMap::new,
                                Collectors.counting()
                        )
                );

        // 1. obtenemos las lineas del archivo
        Stream<String> lineas = Files.lines(Paths.get("alicia.txt"), StandardCharsets.ISO_8859_1);

        // 2. mapeo para obtener las lineas quitando los signos de puntuacion
        Stream<String> flujoLineas = lineas.map( linea -> linea.replaceAll("(?!')\\p{Punct}", ""));

        // 3. flatMap para pasar de cadenas que representan lineas a cadenas que representan las palaras sueltas, una a una
        // cada vez que encontramos un espacio en blanco recogemos el string
        Stream<String> flujoPalabras = flujoLineas.flatMap(linea -> pattern.splitAsStream(linea));

        // 4. se eliminan las palabras vacias
        Stream<String> flujoPalabrasOk = flujoPalabras.filter(palabra -> !palabra.isEmpty());

        // 5. agrupamiento: se agrupan sus contenidos en minuscula (todas las apariciones de una misma palabra estaran agrupadas)
        TreeMap<String, Long> coleccion = flujoPalabrasOk.collect(
                Collectors.groupingBy(
                        String::toLowerCase,
                        TreeMap::new,
                        Collectors.counting()
                )
        );

        /******************** E3 ********************/
        // Muestra las entradas de la coleccion
        // 1. creacion del flujo sobre las entradas del mapa (palabras)
        // 2. agrupa las palabras por su primera letra
        // 3. iteracion sobre cada entrada del agrupamiento formado (letra - lista de palabras)
        // 4. muestra todas las palabras debidamente agrupadas
        contadores.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                entrada -> entrada.getKey().charAt(0),
                                TreeMap::new,
                                Collectors.toList()
                        )
                )
                .forEach((letra, listaPalabras) -> {
                    System.out.printf("%n%C%n", letra);
                    listaPalabras.stream().forEach(entrada -> System.out.printf(
                       "%13s: %d%n", entrada.getKey(), entrada.getValue()
                    ));
                });

        // De nuevo se podria descomponer la operacion paso a paso
        // 1. creacion de flujo con las entradas del mapa de contadores
        Stream<Map.Entry<String, Long>> flujoEntradas = contadores.entrySet().stream();

        // 2. recogemos todas las entradsa con otra estructura; un mapa donde la clave
        // sera la primera letra y el valor una lista de aentradas del mapa anterior,
        // tipo <String , Long>
        TreeMap<Character, List<Map.Entry<String, Long>>> coleccionFinal = flujoEntradas.collect(
                Collectors.groupingBy(entrada -> entrada.)
        );
    }
}
