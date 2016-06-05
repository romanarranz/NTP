/**
  * Created by roman on 28/5/16.
  */
object generarArbolCodificacion {
  def generarArbolCodificacion(texto: List[Char]): Nodo =
    hasta(singleton, combinar)(generarListHojasOrdenadas(texto)).head

  /**
    *
    * Obtiene el numero de ocurrencias que tiene ese caracter en el texto
    */
  def obtenerTuplasOcurrencias(caracter: Char, texto: List[Char]): Int = texto.groupBy(identity).mapValues(_.size)(caracter)

  /**
    * Genera una lista con todos los nodos hoja del arbol de codificacion.
    *
    * Estan ordenados de forma ascendente
   */
  def generarListHojasOrdenadas(texto: List[Char]): List[NodoHoja] = generarListHojasOrdenadas0(texto, texto.distinct, List()).sortBy(_.cost);
  def generarListHojasOrdenadas0(texto: List[Char], textoSinRepetidos: List[Char], result: List[NodoHoja]): List[NodoHoja] ={
    if(textoSinRepetidos.isEmpty)
      result
    else {
      val nodoNuevo = NodoHoja(textoSinRepetidos.head, obtenerTuplasOcurrencias(textoSinRepetidos.head, texto))
      generarListHojasOrdenadas0(texto, textoSinRepetidos.tail, result ++ List(nodoNuevo))
    }
  }

  /**
    * Comprueba que  si una lista de nodos arboles contiene a un unico elemento
   */
  def singleton(arbol: List[Nodo]): Boolean = arbol.size == 1

  /**
    * Hace llamadas a las funciones definidas en pasos anteriores hasta que la lista de nodos contenga un unico elemento
    */
  def hasta(pred: List[Nodo] => Boolean, funcion: List[Nodo] => List[Nodo])(arboles: List[Nodo]) : List[Nodo] =
    if(pred(arboles))
      arboles
    else
      hasta(pred, funcion)(funcion(arboles))

  /**
    * - Elimina de la lista de nodos los dos con menos peso
    * - Los combina para crear un NodoIntermedio con ellos
    * - Inserta ese nodo en la lista de nodos a combinar, preservando el orden
    */
  def combinar(nodosTerminales: List[Nodo]): List[Nodo]  = {
    // ponemos el nuevo nodo intermedio generado al princiio de la lista nuevamente
    (Huffman.generarArbol(nodosTerminales.head, nodosTerminales.tail.head) :: nodosTerminales.tail.tail)
          // ordenamos la lista por coste
          .sortWith((nodoA, nodoB) => Huffman.calcularPeso(nodoA) < Huffman.calcularPeso(nodoB))
  }

  def stringAListaCaracteres(cadena: String): List[Char] = cadena.toList
}
