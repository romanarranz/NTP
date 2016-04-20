// RECORRER TODOS LOS ARCHIVOS DEL DIRECTORIO ACTUAL
// archivo <- archivos es un generador, en cada iteracion se inicializa una nueva variable tipo val File archivo
// interpretado por el compilador a través de la colección de Array[File] archivos
val archivos = new java.io.File("./").listFiles
for(archivo <- archivos)
	println(archivo)
