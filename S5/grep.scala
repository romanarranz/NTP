// BUCLES ANIDADOS
def obtenerLineasArchivo(archivo : java.io.File) = scala.io.Source.fromFile(archivo).getLines().toList
val ficheros = new java.io.File("./").listFiles
def grep(patron : String) = for {
	fichero <- ficheros
	if fichero.getName.endsWith(".scala")
    	linea <- obtenerLineasArchivo(fichero)
    		if linea.trim.matches(patron)
} // hasta aqui es la cabecera del bucle for
println(fichero.getName + ": " + linea.trim) // y esto es el cuerpo del bucle for, es decir lo que en programacion tradicional iria entre {}

grep(".*val.*")
