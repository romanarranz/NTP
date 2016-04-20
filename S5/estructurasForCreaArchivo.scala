val archivos = new java.io.File("./").listFiles
def archivosScala = for {
	archivo <- archivos
	if archivo.getName.endsWith(".scala")
} yield archivo // guarda cada resultado en una coleccion de archivo
