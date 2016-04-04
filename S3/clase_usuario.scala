class Usuario {
	// Atributos
	val nombre:String = "mgo"

	// Metodos
	def saludar:String = s"Saludo de $nombre"
	override def toString = s"Usuario($nombre)"
}

val us1 = new Usuario

println(us1.saludar)
println(us1)

// AnyRef y AnyVal heredan de Any
println(us1.isInstanceOf[Any])

// Usuario hereda de AnyRef
println(us1.isInstanceOf[AnyRef])
println(us1.isInstanceOf[Usuario])