// funcion de alto orden, ya que recibe callbacks de otras funciones
def sumarGeneral(f: Int => Int, desde:Int, hasta:Int) : Int = {
    if (desde > hasta) 0
    else f(desde) + sumarGeneral(f, desde+1, hasta)
}

def identidad(x:Int) = x
def elevarCuadrado(x : Int): Int = x*x
def obtenerPotenciaDos(x:Int) : Int = if(x == 0) 1 else 2 * obtenerPotenciaDos(x-1)

// Funciones para sumar enteros
val id = identidad _
def sumarEnteros(desde:Int, hasta:Int) : Int = sumarGeneral(identidad, desde, hasta)
val sumarEnterosv2 = sumarEnteros _
def sumarEnterosv3(desde: Int, hasta:Int) : Int = sumarGeneral(x => x, desde, hasta)

// Funciones para sumar cuadrados
def sumarCuadrados(desde: Int, hasta:Int) : Int = sumarGeneral(elevarCuadrado, desde, hasta)
def sumarCuadradosv2(desde: Int, hasta:Int) : Int = sumarGeneral(x => x*x, desde, hasta)

println(sumarGeneral(elevarCuadrado, 2,3))
println(sumarGeneral(obtenerPotenciaDos, 3,5))
println(sumarEnteros(2,5))
println(sumarEnterosv2(2,5))
println(sumarEnterosv3(2,5))

println(sumarCuadrados(3,5))
println(sumarCuadradosv2(3,5))
