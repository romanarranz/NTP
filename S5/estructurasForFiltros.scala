// FILTROS
val archivos = new java.io.File("./").listFiles
for(archivo <- archivos
	if archivo.isFile
	if archivo.getName.endsWith("log")
)
println(archivo)
