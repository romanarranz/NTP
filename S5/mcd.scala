// <== Froma tradicional
// ==============================>
// MCD de forma procedural
def calcularMCD(x :Long, y: Long) : Long = {
	var a = x
    var b = y

	// la estructura while no genera ningun valor como resultado, no como las estructuras if
    while(a != 0){
    	val temp = a
      	a = b % a
      	b = temp
	}

	// Devolucion de la funcion
	b
}

// <== Usando programacion funcional
// ==============================>
// Como norma general debemos evitar hacer uso de var y de los bucles

// MCD de forma recursiva
def calcularMCDR(x : Long, y : Long) : Long = {
	if(y == 0) x
	else calcularMCDR(y, x%y)
}
