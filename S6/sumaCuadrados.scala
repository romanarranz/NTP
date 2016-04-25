def elevarCuadrado(x : Int): Int = x*x

def sumarCuadrados(desde : Int, hasta : Int) : Int = {
    if (desde > hasta)
        0
    else
        elevarCuadrado(desde) + sumarCuadrados(desde+1, hasta)
}

println(sumarCuadrados(2,3))
println(sumarCuadrados(2,5))
