/**
  * Created by roman on 27/5/16.
  */

object Huffman {

  type TablaCodigo = List[(Char, List[Int])]

  def calcularPeso(n : Nodo) : Int = n match {
    case NodoHoja(_, peso) => peso
    case NodoIntermedio(nodoIzda, nodoDcha, _, _) => calcularPeso(nodoIzda) + calcularPeso(nodoDcha)
  }

  def obtenerCaracteres(n : Nodo) : List[Char] = n match {
    case NodoHoja(caracter, _) => List(caracter)
    case NodoIntermedio(nodoIzda, nodoDcha, _, _) => List.concat(obtenerCaracteres(nodoIzda),obtenerCaracteres(nodoDcha))
  }

  def generarArbol(izq: Nodo, der: Nodo) : Nodo =
    new NodoIntermedio(izq,der,List.concat(izq.characters,der.characters),izq.cost+der.cost)

  def decodificar(arbol : Nodo, bits : List[Int]): List[Char] = {
    // si el peso es mayor a 1 quiere decir que al menos consta de un nodo intermedio
    if(calcularPeso(arbol) > 1) {
      if (bits.head == 0)
        obtenerCaracteres(arbol.asInstanceOf[NodoIntermedio].hijoIzda) ++ decodificar(arbol, bits.tail)
      else
        obtenerCaracteres(arbol.asInstanceOf[NodoIntermedio].hijoDcha) ++ decodificar(arbol, bits.tail)
    }
    else {
      obtenerCaracteres(arbol) ++ decodificar(arbol, bits.tail)
    }
  }

  def codificar(arbol : Nodo, texto : List[Char]) : List[Int] = List(' ')
  def codificarConTabla(tabla : TablaCodigo)(caracter : Char) : List[Int] = List(0)
  def convertirArbolTabla(arbolCodificacion : Nodo) : TablaCodigo = null

  def codificacionRapida(arbol: Nodo)(texto: List[Char]) : List[Int] = {
    if(texto.length > 0){
      if(obtenerCaracteres(arbol).head == texto.head)
        List(0) ++ codificacionRapida(arbol)(texto.tail)
      else
        List(1) ++ codificacionRapida(arbol)(texto.tail)
    }
    else null
  }
}
