/**
 * Created by roman on 26/2/16.
 */

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;

public class intStreamOperations {
    private int valores[];

    public intStreamOperations(int numeroValores) {
        valores = new int[numeroValores];
        for (int i = 0; i < valores.length; i++)
            valores[i] = i+1;
    }

    public void mostrarValores(){
        for(int i = 0; i<valores.length; i++)
            System.out.printf("%d ",valores[i]);
        System.out.println();
    }

    public void mostrarValoresFuncional(){
        // Se muestran los valores almacenados mediante una expresion lambda trabajando sobre
        // un flujo de la clase IntStream: se crea el flujo, se itera mediante forEach y cada valor
        // se aplica la expresion lambda
        IntStream.of(this.valores).forEach(
                value-> System.out.printf("%d ",value)
        );

        IntStream flujo = IntStream.of(this.valores);
        flujo.forEach(
                System.out::println
        );

        // lo mismo pero con un bloque de sentencias
        /*
        flujo.forEach(value->{
           System.out.println(value);
        });
        */
    }

    public long contarValores(){
        return valores.length;
    }

    public long contarValoresFuncional(){
        // Se obtiene el numero de elementos y se devuelve
        long contadorValores = IntStream.of(valores).count();
        return contadorValores;
    }

    // Metodo para obtener el minimo con aproximacion usual
    public int obtenerMinimo(){
        int minimo = valores[0];

        // Se considera el resto de valores
        for(int i =1; i<valores.length; i++){
            if(valores[i] < minimo)
                minimo = valores[i];
        }

        return minimo;
    }

    // Metodo para obtener el minimo con aproximacion funcional
    public int obtenerMinimoFuncional() {
        int minimo = IntStream.of(valores).min().getAsInt();
        return minimo;
    }

    // Metodo para obtener el minimo con aproximacion usual
    public int obtenerMaximo(){
        int maximo = valores[0];

        // Se considera el resto de valores
        for(int i =1; i<valores.length; i++){
            if(valores[i] > maximo)
                maximo = valores[i];
        }

        return maximo;
    }

    // Metodo para obtener el minimo con aproximacion funcional
    public int obtenerMaximoFuncional() {
        int maximo = IntStream.of(valores).max().getAsInt();
        return maximo;
    }

    // Metodo para obtener la suma de todos los valores con aproximacion usual
    public long obtenerSuma(){
        long suma = 0;

        for(int i = 0; i<valores.length; i++)
            suma += valores[i];

        return suma;
    }

    // Metodo para obtener la suma de todos los valores con aproximacion funcional
    public long obtenerSumaFuncional(){
        long suma = IntStream.of(valores).sum();
        return suma;
    }

    // Metodo para obtener la suma con reduce y expresiones
    public long obtenerSumaReduceExpresionesLambda(){
        long suma = IntStream.of(valores).reduce(0, (x,y) -> x + y);
        // .reduce(valorInicial, (expresionLambda))
        // Iteracion 1 => x = 0, y = valores[0]
        // Iteracion 2 => x = xAnt, y = valores[1]
        return suma;
    }

    // Metodo para obtener la media con aproximacion funcional
    public double obtenerMediaFuncional(){
        double media = IntStream.of(valores).average().getAsDouble();
        return media;
    }

    public long obtenerProductoReduceExpresionesLambda(){
        long producto = IntStream.of(valores).reduce(1, (x,y) -> x * y);
        return producto;
    }

    public long obtenerSumaValoresCuadradoReduceExpresionesLambda(){
        long sumaCuadrados = IntStream.of(valores).reduce(0, (x,y) -> x + (y*y));
        // .reduce(valorInicial, (expresionLambda))
        // Iteracion 1 => x = 0 +  y = valores[0] * valores[0]
        // Iteracion 2 => x = xAnt + y = valores[1] * valores[1]
        return sumaCuadrados;
    }

    public long obtenerSumaValoresCuadradosMapping(){
        long sumaCuadrados = IntStream.of(valores).map(x -> x*x).sum();
        // .map(x -> x*x) => crea las siguientes clave-valor y las suma
        // 1 -> 1*1 = 1
        // 2 -> 2*2 = 4
        // 3 -> 3*3 = 9
        // luego se hace sum y obtenemos 1 + 4 + 9 = 14
        return sumaCuadrados;
    }

    public void ordenarPares(){
        int [] pares = new int[valores.length];
        int contadorPares = 0;

        for(int i = 0; i<valores.length; i++){
            if(valores[i]%2 == 0) {
                pares[contadorPares] = valores[i];
                contadorPares++;
            }
        }

        Arrays.sort(pares,0,contadorPares-1);

        System.out.printf("ordenarPares(): ");
        for(int i = 0; i<contadorPares; i++)
            System.out.printf("%d ", pares[i]);
        System.out.println();
    }

    public void ordenarParesFuncional(){
        IntStream.of(valores).filter(value -> value%2 == 0).sorted().forEach(
                value -> System.out.printf("%d ", value)
        );
        System.out.println();
    }

    /* Ejercicio 1: Funcion que
        multiplique por factor
        se quede con los pares
        ordene
        muestre
    */
    public void funcionEjer1Funcional(int factorMultiplicacion){
        IntStream.of(valores)
                .map(x -> x*factorMultiplicacion)
                .filter(x -> x%2 == 0)
                .sorted()
                .forEach(
                    value -> System.out.printf("%d ",value)
                );
    }

    // Metodo para coger los pares pero que permita guardarlos en otra lista
    public void ordenarParesFuncionalGuardadoLista(){
        List<Integer> lista = IntStream.of(valores)
                .filter(x -> x%2 == 0)
                .sorted()
                .boxed()
                .collect(Collectors.toList());
        System.out.println("ordenarParesFuncionalGuardadoLista(): "+lista.toString());
    }

    public static void main(String [] args){
        intStreamOperations var = new intStreamOperations(20);

        var.mostrarValores();
        System.out.println("Suma de Cuadrados: " + var.obtenerSumaValoresCuadradoReduceExpresionesLambda());
        System.out.println("Suma de Cuadrados Mapping: " + var.obtenerSumaValoresCuadradosMapping());
        var.ordenarPares();
        //var.funcionEjer1Funcional(2);
        var.ordenarParesFuncionalGuardadoLista();
    }
}
