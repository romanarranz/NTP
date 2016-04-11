case class Direccion (calle : String, ciudad : String, estado : String, codigo : String)

case class Persona (nombre : String, edad : Option[Int], direccion : Option[Direccion]) {
	def this(nombre : String) = this(nombre, None, None)
	def this(nombre : String, edad : Int) = this(nombre, Some(edad), None)
	def this(nombre : String, edad : Int, direccion : Direccion) = this(nombre, Some(edad), Some(direccion))
	def this(nombre : String, direccion : Direccion) = this(nombre, None, Some(direccion))
}


case class Persona2(nombre : String, edad : Option[Int] = None, direccion : Option[Direccion] = None)
object Persona2{
  	def apply(nombre : String) : Persona2 = new Persona2(nombre)
  	def apply(nombre : String, edad : Int) : Persona2 = new Persona2(nombre, Some(edad))
  	def apply(nombre : String, edad : Int, direccion : Direccion) : Persona2 = new Persona2(nombre, Some(edad), Some(direccion))
  	def apply(nombre: String, direccion : Direccion) : Persona2 = new Persona2(nombre, direccion=Some(direccion))
}

val direccion1 = new Direccion("Daniel Saucedo Aranda", "Granada", "España", "18071")
val persona1 = new Persona("Antonio Lopez Martinez")
val persona2 = new Persona("Juan Martinez Hidalgo", Some(20), Some(direccion1))
val persona3 = Persona2("Antonio Lopez Martinez")
val persona4 = Persona2("Juan Martinez Hidalgo", Some(20), Some(direccion1))

println(direccion1)
println(persona1)
println(persona2)
println(persona3)
println(persona4)