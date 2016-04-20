
def imprimirTablas(): Unit = {
  var i=1

  // Se generan las tablas del 1 al 10
  while(i <= 10){
    var j=1

    // Se consideran los valores desde
    // 1 hasta 10
    while(j <= 10){
      // Se calcula i*j y se convierte a
      // cadena
      val prod=(i*j).toString

      // Se determina la longitud de la
      // cadena generada
      var k=prod.length

      // Se rellena con espacios en blanco
      while(k < 4){
        print(" ")
        k+=1
      }

      // Se imprime el producto
      print(prod)
      j+=1
    }

    // Al final de cada tabla se salta de
    // linea
    println()

    // Se incrementa el valor de i para generar
    // la siguiente tabla
    i+=1
  }

  // Ambito: i
}

imprimirTablas()


