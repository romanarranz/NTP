import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * Created by roman on 4/3/16.
 */
public class ProcesarEmpleados {
    public static void main (String [] args){
        Empleado[] empleados = {
                new Empleado("Juan", "Lopez", 5000, "IT"),
                new Empleado("Antonio", "Garcia", 7600, "IT"),
                new Empleado("Mateo", "Insausti", 3587.5, "Ventas"),
                new Empleado("Joaquín", "Fernandez", 4700.77, "Marketing"),
                new Empleado("Lucas", "Martinez", 6200, "IT"),
                new Empleado("Pedro", "Garcia", 3200, "Ventas"),
                new Empleado("Fernado", "Gonzalez", 4236.4, "Marketing")};

        /**************** E1 *******************/
        List<Empleado> lista = Arrays.asList(empleados);
        // Tambien se puede hacer asi
        // Arrays.stream(empleados); // devuelve un stream de empleados

        /**************** E2 *******************/
        // Se crea un flujo sobre la lista
        Stream<Empleado> flujo= lista.stream();

        /**************** E3 *******************/
        System.out.println("Lista completa de empleados: ");
        // Es necesario tener el toString de la clase empleado
        flujo.forEach(System.out::println);

        /**************** E4 *******************/
        // Predicado que devuelve verdadero si los salarios estan en el rango 4000-6000
        Predicate<Empleado> condicion
                = empleado -> (empleado.obtenerSueldo() >= 4000 && empleado.obtenerSueldo() <= 6000);

        /**************** E5 *******************/
        System.out.printf("%nEmpleados seleccionados y ordenados: %n");
        lista.stream()
                .filter(condicion)
                .sorted(Comparator.comparing(Empleado::obtenerSueldo))
                .forEach((System.out::println));

        /**************** E6 *******************/
        System.out.printf("%nPrimer empleado con sueldo rango entre 4000 y 6000: %n%s%n",
                lista.stream()
                .filter(condicion)
                .findFirst()
                .get());

        /**************** E7 *******************/
        // Funciones para obtener el nombre y apellido de un empleado
        Function<Empleado, String> refNombre = Empleado::obtenerNombre;
        Function<Empleado, String> refPrimerApellido = Empleado::obtenerPrimerApellido;

        /**************** E8 *******************/
        // Comparador para comparar Empleados, por nombre y primerApellido
        // si hay 2 personas que se llaman martinez, la comparacion pasa a hacerla por el nombre
        Comparator<Empleado> comparador = Comparator.comparing(refPrimerApellido).thenComparing(refNombre);

        /**************** E9 *******************/
        // Ordena los empleados por primerApellido + nombre
        System.out.printf("%nEmpleados en orden asc por apellido + nombre: %n");
                lista.stream()
                .sorted(comparador)
                .forEach(System.out::println);

        /**************** E10 *******************/
        // Ordena los empleados en orden desc primerApellido
        System.out.printf("%nEmpleados en orden desc por apellido + nombre: %n");
                lista.stream()
                        .sorted(comparador.reversed())
                        .forEach(System.out::println);

        /**************** E11 *******************/
        // Muestra los apellidos de los empleados sin repeticiones
        System.out.printf("%nApellidos sin repeticiones y ordenados: %n");
                lista.stream()
                        // Ahora quiero trabajar solo con la coleccion de apellidos
                        .map(Empleado::obtenerPrimerApellido)
                        .distinct() // quita los repetidos
                        .sorted()
                        .forEach(System.out::println);

        /**************** E13 *******************/
        // Agrupa los empleados por departamentos
        System.out.printf("%nEmpleados por departamentos: %n");
        Map<String, List<Empleado>> agrupadosPorDepartamentos =
                lista.stream()
                        .collect(Collectors.groupingBy(Empleado::obtenerDepartamento));

        // primer foreach de coleccion
        agrupadosPorDepartamentos.forEach(
                // clave del dpto, listaEmpleadosDpto
                (departamento, empleadosEnDepartamento) -> {
                    System.out.println(departamento);
                    empleadosEnDepartamento.forEach(System.out::println); // iteracion de coleccion
                }
        );

        /**************** E14 *******************/
        // Cuenta el numero de empleados en cada departamento
        System.out.printf("%nCuenta de empleados por departamento: %n");
        Map<String, Long> cuentaEmpleadosPorDepartamento =
                lista.stream()
                        .collect(Collectors.groupingBy(Empleado::obtenerDepartamento,
                                TreeMap::new, Collectors.counting()));
        // voy a obtener un treemap(map ordenado) donde van a aparecer todos los departamentos ordenados por orden alfabetico
        // donde la clave sera el dpto y el valor sera el resultado de contar los empleados. Algo asi:
        // dpto1 -> Empleado1, Empleado2, Empleado3   =>          dpto1  -> 3
        // dpto2 -> Empleado4, Empleado5              =>          dpto2  -> 2

        cuentaEmpleadosPorDepartamento.forEach(
                (departamento, cuenta) -> System.out.printf(
                        "%s tiene %d empleado(s)%n", departamento, cuenta
                )
        );

        /**************** E15 *******************/
        // Suma de sueldos de empleados
        System.out.printf("%nSuma de sueldos de empleados: %.21f%n",
                lista.stream()
                .mapToDouble(Empleado::obtenerSueldo)
                .sum()); // suma todos los valores de la nueva coleccion

        // Calculo de suma de sueldos mediante reduce
        System.out.printf(
                "Suma de sueldos de empleados con reduce: %.21f%n",
                lista.stream()
                .mapToDouble(Empleado::obtenerSueldo) // equivalente a .mapToDouble(empleado -> emplead.obtenerSueldo())
                .reduce(0, (value1, value2) -> value1 + value2)
        );

        /**************** E16 *******************/
        // Media de sueldos de empleados
        System.out.printf("%nSueldo medio: %.2f%n",
                lista.stream()
                        .mapToDouble(Empleado::obtenerSueldo)
                        .average()
                        .getAsDouble());

        // Objeto para procesar estadisticas con doubles
        DoubleSummaryStatistics estadisticas = lista.stream()
                .mapToDouble(Empleado::obtenerSueldo)
                .summaryStatistics();
        System.out.print(estadisticas.getAverage());

    }
}
