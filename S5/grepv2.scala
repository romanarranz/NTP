// En la version1 de grep necesitabamos ejecutar dos veces la opracion trim sobre cada linea, de esta manera usando una variable
// intermedia lo evitamos
def obtenerLineasArchivo(archivo : java.io.File) = scala.io.Source.fromFile(archivo).getLines().toList
val ficheros = new java.io.File("./").listFiles
def grep(patron : String) = for {
	fichero <- ficheros
    if fichero.getName.endsWith(".scala")
		linea <- obtenerLineasArchivo(fichero)
		sinBlancos <- linea.trim
		if sinBlancos.matches(patron)
}
println(fichero.getName + ": " + sinBlancos)

grep(".*val.*")
