class PuntoAleatorio{
	val x = {
		// el signo ';' solo es obligatorio si escribimos varias sentencias en la misma linea
		println("Creacion x"); util.Random.nextInt()
	}

	/* sirve para retrasar la asignacion de valores dato miembro. 

	Retrasa la declaracion de un dato mimembro hasta el momento en el que se vaya a utilizar (se usa para datos miembros muy pesados, objetos robustos)
	*/

	lazy val y = {
		println("Creacion y"); util.Random.nextInt()
	}
}

val p1 = new PuntoAleatorio
val p2 = new PuntoAleatorio

println(s"Ubicacion p1: ${p1.x} - ${p1.y}")
println(s"Ubicacion p2: ${p2.x} - ${p2.y}")