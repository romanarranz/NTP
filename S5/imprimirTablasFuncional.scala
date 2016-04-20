import scala.collection.immutable.IndexedSeq
// Funcion auxiliar para generar la tabla
// completa de un determinado valor, pasado
// como argumento
def generarTablaNumero(fila: Int) : IndexedSeq[String] =
  // Se considera cada posible valor a multiplicar
  for (columna <- 1 to 10) yield {
    // Como resultado de cada iteracion se
    // produce una cadena
    val producto=(fila*columna).toString
    val relleno=" "*(4-producto.length)
    relleno + producto
  }

def imprimirTablas() = {
  val tablas: IndexedSeq[String] =
    for(fila <- 1 to 10) yield generarTablaNumero(fila).mkString

  // La secuencia de cadenas, con la cadena
  // de cada tabla, se convierte en un unico
  // string, separando cada uno de ellos por
  // un salto de linea
  tablas.mkString("\n")
}

println(imprimirTablas())

