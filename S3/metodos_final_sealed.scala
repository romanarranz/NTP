// las clases finales no se pueden heredar
final class NumeroPi{
	final val pi = 3.1415
}

/*
DARÁ ERROR YA QUE NO ES HEREDABLE LA CLASE NumeroPi
class NumeroPiPrint extends NumeroPi{
	def imprimir(){
		println(super.pi)
	}
}
*/

class NumeroAureo{
	// los atributos final no se pueden modificar
	final val phi = 1.6180339
}

sealed class NumeroAureoPrint extends NumeroAureo{
	def imprimir(){
		println(super.phi)
	}
}

class NumeroComplejo{

	// modificadores de visibilidad: private, protected
	private var real = 0.0
	private var imaginaria = 0.0

	// los argumentos de los metodos siempre son val, por lo que no pueden modificarse
	def asignarReal(vReal : Double): Unit = {
		real = vReal
	}

	// omitimos el tipo de devolucion, eso hace que el tipo sea Unit
	def asignarImaginaria(vImaginaria : Double){
		imaginaria = vImaginaria
	}

	// estilo funcional de calculo
	def calcularModulo() : Double = math.sqrt(real*real+imaginaria*imaginaria)
}

val numero1 = new NumeroComplejo
numero1.asignarReal(23.5)
numero1.asignarImaginaria(23.1)

val modulo = numero1.calcularModulo()
println(modulo)

val imprimeAureo = new NumeroAureoPrint
imprimeAureo.imprimir