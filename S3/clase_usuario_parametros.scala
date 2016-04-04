class Usuario(nom : String) {
	// Atributos
	val nombre:String = nom

	// Metodos
	def saludar:String = s"Saludo de $nombre"
	override def toString = s"Usuario($nombre)"
}

// Parametro del constructor convertido a atributo
class UsuarioMaligno(val nombre: String) {
	def saludar:String = s"Saludo tenebroso de $nombre"
	override def toString = s"Usuario maligno($nombre)"
}

val us1 = new Usuario("pepe")
val us2 = new UsuarioMaligno("saruman")

println(us1)
println(us2)

val usuarios = List(us1, new Usuario("alvaro"))
println(usuarios)

// Hace un mapeo de cada usuario de la lista con su size del nombre
val tam = usuarios map (_.nombre.size)
println(tam)

val ordenados = usuarios sortBy (_.nombre)
println(ordenados)

val cong = usuarios find (_.nombre contains "g")
// son equivalentes cong y cong2
val cong2 = usuarios find(usuario => usuario.nombre contains "g")
println(cong)
println(cong2)

// Su no hubiera objeto alguno en cong imprime "no usuario"
val saludo = cong map (_.saludar) getOrElse "no usuario"
println(saludo)