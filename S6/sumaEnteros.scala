def sumaEnteros( desde: Int, hasta : Int) : Int = {
    if (desde > hasta)
        0
    else
        desde + sumaEnteros(desde+1, hasta)
}

println(sumaEnteros(4,8))
println(sumaEnteros(1,10))
