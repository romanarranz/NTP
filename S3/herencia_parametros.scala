class Coche(val marca:String, var reservado:Boolean = false, val anno:Int = 2015){
	def reservar(r : Boolean): Unit = {reservado = r}
	override def toString = s"$anno, $marca, $reservado"
}

class Renault (val color:String, reservado:Boolean) extends Coche("Renault", reservado)

val c3 = new Coche("Citroen")
c3.reservar(true)
println(c3)

val c4 = new Coche("Opel", anno = 2016)
println(c4)

val c5 = new Coche(reservado = true, marca = "Toyota")
println(c5)

val c6 = new Renault("rojo", true)
println(c6)