package p1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.TreeMap;

/**
 * Created by roman on 11/3/16.
 */
public class Listado {
    /**
     * Dato miembro para almacenar a los alumnos como mapa con pares
     * <dni - alumno>
     */
    private Map<String, Alumno> lista;

    public Listado(String rutaArchivo) throws IOException{

        // En primer lugar comprobamos que exista el archivo
        File f = new File(rutaArchivo);
        if(f.exists() && !f.isDirectory()) {
            lista = new HashMap<>();

            // Se define un patron que representa ,
            Pattern pattern = Pattern.compile("(,)");

            // obtenemos las lineas del archivo
            Stream<String> lineas = Files.lines(Paths.get(rutaArchivo), StandardCharsets.ISO_8859_1);

            // creamos los alumnos por cada linea
            lineas.forEach( linea -> crearAlumno(linea));
        }
        else {
            System.out.println("El archivo "+rutaArchivo+" no existe");
        }
    }

    public void cargarArchivoAsignacion(String rutaArchivo) throws IOException {

    }

    private void crearAlumno(String linea){
        // Se define el patron para las comas que hacen de separadores
        Pattern pattern = Pattern.compile("(,)");

        // Se procesa la linea
        List<String> infos = pattern.splitAsStream(linea).collect(Collectors.toList());

        lista.put(
                infos.get(0),
                new Alumno(
                        infos.get(0),
                        infos.get(1),
                        infos.get(2),
                        infos.get(3)
                )
        );

        System.out.println(infos.toString());
    }

    // recibe como argumento el codigo de una asignatura (uno de los posibles valores del enumerado) y devuelve los contadores de alumnos asignados a cada grupo.
    public Map<Integer,Long> obtenerContadoresGruposDeAsignatura(Asignatura asignatura){
        return null;
    }

    // obtener los contadores que indiquen el nu ́mero de alumnos asignados a cada grupo, para cada asignatura
    public Map<Asignatura, Map<Integer,Long>> obtenerContadoresGrupos(){
        // llamada a obtenerContadoresGruposDeAsignaturas
        return null;
    }

    // la clase permitira tambien obtener un listado de todos los alumnos que no estan asignados a una asignatura concreta,
    // cuyo nombre se pasara como argumento.
    public List<Alumno> buscarAlumnosNoAsignados(String asignatura){
        return null;
    }

    public int obtenerLongitud(){
        return 100;
    }
}
