// Calcular el area de un circulo
def calcularAreaCirculo(radio: Double) : Double = math.Pi*math.pow(radio,2)
def calcularAreaCirculo(s: String) : Double ={
	
	s.isEmpty match {
		case true => 0
		case false => math.Pi*math.pow(s.toDouble,2)
	}
} 
if(args.length > 0){
	val radio = args(0).toDouble
	println(calcularAreaCirculo(radio))
	println(calcularAreaCirculo(args(0)))
}
else
	Console.err.println("Introduzca argumento como numero real")