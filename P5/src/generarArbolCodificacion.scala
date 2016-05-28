/**
  * Created by roman on 28/5/16.
  */
object generarArbolCodificacion {
  def generarArbolCodificacion(texto: List[Char]): Nodo = ???

  def obtenerTuplasOcurrencias(caracter: Char, texto: List[Char]): Int = texto.groupBy(identity).mapValues(_.size)(caracter)

  def generarListHojasOrdenadas(texto: List[Char]): List[Char] = ???

  def singleton(arbol: Nodo, elemento: Char): Boolean = arbol.characters.contains(elemento)

  def combinar(nodosTerminales: List[Nodo]) = {
    // eliminar los nodos con menos peso

    // formar nodo intermedio con ellos dos

    // inserta este nodo en la lista de nodos a combinar. Preservar el orden de insercion

    // funcion hasta, que haga llamdas a las 3 acciones anteriores hasta que quede un unico nodo
    // hasta(singleton,combinar)(nodosTerminales)
  }

  def stringAListaCaracteres(cadena: String): List[Char] = cadena.toList
}
