package p1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

/**
 * Created by roman on 11/3/16.
 */
public class Listado {
    /**
     * Dato miembro para almacenar a los alumnos como mapa con pares
     * <dni - alumno>
     */
    private Map<String, Alumno> lista;
    private ArrayList<String> asignaturas;

    public Listado(String rutaArchivo) throws IOException{

        // En primer lugar comprobamos que exista el archivo
        File f = new File(rutaArchivo);
        if(f.exists() && !f.isDirectory()) {
            lista = new HashMap<>();
            asignaturas = new ArrayList<>();

            for(Asignatura asig : Asignatura.values())
                asignaturas.add(asig.toString());


            // obtenemos las lineas del archivo
            Stream<String> lineas = Files.lines(Paths.get(rutaArchivo), StandardCharsets.ISO_8859_1);

            // creamos los alumnos por cada linea
            lineas.forEach( linea -> crearAlumno(linea));

            lineas.close();
        }
        else {
            System.out.println("El archivo "+rutaArchivo+" no existe");
        }
    }

    public void cargarArchivoAsignacion(String rutaArchivo) throws IOException {
        // obtenemos las lineas del archivo
        Stream<String> lineas = Files.lines(Paths.get(rutaArchivo), StandardCharsets.ISO_8859_1);

        // flujo para obtener UNICAMENTE el codigo de la asignatura
        Stream<String> lineaAsignatura = Files.lines(Paths.get(rutaArchivo), StandardCharsets.ISO_8859_1);

        // a partir del flujo de lineas me quito las lineas vacias y las que sean del codigo de asignatura y me salto 1 byte
        // de una linea que recogia y no valia de nada
        Stream<String> lineasAlumnoGrupo = lineas
                .filter(linea -> !(asignaturas.contains(linea)))
                .filter(linea -> !linea.isEmpty())
                .skip(1);

        // recupero el codigo de asignatura, usando findfirst el flujo lineaAsignatura queda cerrado porque es una sentencia terminal
        Optional<String> asignatura = lineaAsignatura
                .filter(linea -> asignaturas.contains(linea))
                .findFirst();

        // se define el patron para los espacios en blanco que sirven como separador
        Pattern pattern = Pattern.compile("\\s");

        // obtengo el listado de dni, grupo
        lineasAlumnoGrupo.forEach(linea -> {
            List<String> infos = pattern.splitAsStream(linea).collect(Collectors.toList());

            // del alumno con dni infos.get(0) le añadimos la nueva asignacion
            lista.get(infos.get(0)).setAsignacion(asignatura, Integer.parseInt(infos.get(1)));
        });

        lineasAlumnoGrupo.close();
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
    }

    // recibe como argumento el codigo de una asignatura y devuelve los contadores de alumnos asignados a cada grupo.
    public Map<Integer,Long> obtenerContadoresGruposDeAsignatura(Asignatura asignatura){
        Map<Integer, Long> contadores = new HashMap<>();

        Long noAparecen = lista.entrySet()
                .stream()
                .filter(entrada -> !entrada.getValue().cursarAsignatura(asignatura.toString()))
                .count();
        contadores.put(-1,noAparecen);

        Long grupo1 = lista.entrySet()
                .stream()
                .filter(entrada -> entrada.getValue().cursaAsignaturaGrupo(asignatura.toString(), 1))
                .count();
        contadores.put(1,grupo1);

        Long grupo2 = lista.entrySet()
                .stream()
                .filter(entrada -> entrada.getValue().cursaAsignaturaGrupo(asignatura.toString(), 2))
                .count();
        contadores.put(2,grupo2);

        Long grupo3 = lista.entrySet()
                .stream()
                .filter(entrada -> entrada.getValue().cursaAsignaturaGrupo(asignatura.toString(), 3))
                .count();
        contadores.put(3,grupo3);

        return contadores;
    }

    // obtener los contadores que indiquen el numero de alumnos asignados a cada grupo, para cada asignatura
    public Map<Asignatura, Map<Integer,Long>> obtenerContadoresGrupos(){
        Map<Asignatura, Map<Integer,Long>> contadoresGrupos = new HashMap<>();

        for(Asignatura asig : Asignatura.values())
            contadoresGrupos.put(asig, obtenerContadoresGruposDeAsignatura(asig));

        return contadoresGrupos;
    }

    // la clase permitira tambien obtener un listado de todos los alumnos que no estan asignados a una asignatura concreta,
    // cuyo nombre se pasara como argumento.
    public List<Alumno> buscarAlumnosNoAsignados(String asignatura){
        List<Alumno> alumnos = lista.entrySet()
                .stream()
                .filter( e -> !e.getValue().cursarAsignatura(asignatura))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());

        return alumnos;
    }

    public int obtenerLongitud(){
        return lista.size();
    }
}
