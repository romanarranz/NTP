def obtenerPotenciaDos(x:Int) : Int = {
    if(x == 0)
        1
    else
        2 * obtenerPotenciaDos(x-1)

}

def sumarPotenciaDos(desde:Int, hasta:Int) : Int = {
    if(desde > hasta)
        0
    else
        obtenerPotenciaDos(desde) + sumarPotenciaDos(desde+1, hasta)
}

println(obtenerPotenciaDos(3))
println(sumarPotenciaDos(3,5))
