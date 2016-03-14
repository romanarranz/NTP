import scala.io.Source

def calcularAnchoTamLinea(s: String) = s.length.toString.length

if (args.length > 0){
	for(linea <- Source.fromFile(args(0)).getLines())
		println(linea.length+" "+linea)

	val lineas = Source.fromFile(args(0)).getLines().toList
	var maximoAnchoTam = 0
	println("-----Forma2-----")
	println("Calcular lo que le falta de sangrado a cada linea")
	for(linea <- lineas){
		maximoAnchoTam = maximoAnchoTam.max(calcularAnchoTamLinea(linea))
		println(maximoAnchoTam+" "+linea)
	}

	println("-----Forma3-----")
	println("Lo mismo pero mas elegante")
	val lineaMasLarga = lineas.reduceLeft((a,b) => if(a.length > b.length) a else b)
	maximoAnchoTam = calcularAnchoTamLinea(lineaMasLarga)
	println(maximoAnchoTam)
	// finalmente se muestra el contenido debidamente formateado
	for(linea <- lineas){
		// Se calcula el numero de espacios en blanco para iugalar  con el maximo tamaño ancho
		val numeroEspacios = maximoAnchoTam - calcularAnchoTamLinea(linea)

		// Se construye ña cadena de blancos de relleno
		val relleno = " "*numeroEspacios

		// Se muestra la liena
		println(relleno+linea.length+"|"+linea)
	}
}
else
	Console.err.println("Introduzca nombre de archivo")