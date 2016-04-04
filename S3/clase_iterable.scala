class Coleccion[A](element : A) extends Traversable[A]{
	// se pasa el tipo de parametro A a la clase base
	def foreach[B](f:A => B) = f(element)
}

val col = new Coleccion("Elemento1","Elemento2")
// como extiende de Traversable podemos usar el el metodo foreach
col foreach println

println(col.head)
println(col.tail)