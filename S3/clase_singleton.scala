class NumeroComplejo{
	private var real = 0.0
	private var imaginaria = 0.0

	def asignarReal(vReal : Double): Unit = {
		real = vReal
	}

	def asignarImaginaria(vImaginaria : Double){
		imaginaria = vImaginaria
	}

	def calcularModulo() : Double = math.sqrt(real*real+imaginaria*imaginaria)

	def print(): Unit = {
		println(real + " + " + imaginaria + NumeroComplejo.etiquetaImaginaria)
	}
}


// para definir clases usando el patron singleton solamente tenemos que poner object
// ya que no se proporciona el uso de static
object NumeroComplejo{
	private var contador = 0
	private val etiquetaImaginaria = "i"

	def crearCompleto(vReal: Double, vImaginaria: Double) : NumeroComplejo = {
		val resultado = new NumeroComplejo
		resultado.real = vReal
		resultado.imaginaria = vImaginaria
		contador = contador+1
		return resultado
	}

	def crearReal(vReal: Double) : NumeroComplejo = {
		val resultado = new NumeroComplejo
		resultado.real = vReal
		resultado.imaginaria = 0
		contador = contador + 1
		return resultado
	}

	def crearImaginaria(vImaginaria: Double) : NumeroComplejo = {
		val resultado = new NumeroComplejo
		resultado.real = 0
		resultado.imaginaria = vImaginaria
		contador = contador + 1
		return resultado
	}

	def printContador(): Unit = {
		println("Hay definidos un total de "+contador+" numeros complejos")
	}
}

val num1 = NumeroComplejo.crearCompleto(23.6, 11.3)
val num2 = NumeroComplejo.crearReal(7.9)

num1.print
num2.print

NumeroComplejo.printContador