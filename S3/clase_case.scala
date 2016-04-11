// clases case son clases que nos interesan cuando tenemos que hacer un match
// la clase pasa a derivar de companion que incluye el metodo apply, entre otras cosas se nos permite crear objetos sin poner new
// el metodo unapply del objeto companion permite descomponer cada objeto en sus datos miembro
case class Personaje(nombre:String, esLadron: Boolean)

val personaje1 = Personaje("Gilito", false)
val personaje2 = Personaje("Apandador", true)

println(personaje1)

personaje1 match {
	case Personaje(x, true) => println(x+" es ladron")
	case Personaje(x, false) => println(x+" no es ladron")
}