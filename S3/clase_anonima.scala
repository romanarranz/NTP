// Clase anonima
abstract class GestorEventos{
	def invocar
}

class Boton {
	var gestor: GestorEventos = null
	def registrar(gestor : GestorEventos){
		this.gestor = gestor
	}
	def notificar(){
		gestor.invocar
	}
}

// instanciamos la clase base (abstracta)
val miGestor = new GestorEventos{
	// incluimos la implementacion del metodo
	def invocar: Unit = {
		println("Invocar desde miGestor")
	}
}

miGestor.invocar

// instanciacion de la clase con un metodo sin implementar
val botonMio = new Boton()
// implementacion del metodo desde el objeto
botonMio.registrar(new GestorEventos(){
	def invocar{
		println("Llamada desde clase anonima")
	}
})

botonMio.notificar