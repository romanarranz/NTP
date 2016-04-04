// Define metodos a los que le agrega una implementacion
class Multiplicador(factor:Int){
	def apply(valor: Int) = valor*factor
}

val porTres = new Multiplicador(3)
println(porTres)

val res = porTres(10)
println(res)