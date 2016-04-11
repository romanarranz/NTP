// Necesita ser compilado y posteriormente ejecutado

// Compilacion: scalac ejemplo_main.scala
// Ejecucion: scala Ejemplo Hola Mundo

object Ejemplo extends App {
	for(arg <- args)
		println(arg)
}