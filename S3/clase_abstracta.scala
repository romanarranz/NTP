abstract class Coche {
	val anno:Int
	val automatico:Boolean=true
	def color:String
}

class Seat(val anno:Int, val color:String) extends Coche

val coche1 = new Seat(2015, "Rojo")
println(coche1.color)

// nos genera un error ya que es una clase abstracta
//val coche2 = new Coche()
