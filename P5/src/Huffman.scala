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

  def decodificar(arbol : Nodo, bits : List[Int]) : List[Char] = List(' ')
  def codificar(arbol : Nodo, texto : List[Char]) : List[Int] = List(' ')

  def codificarConTabla(tabla : TablaCodigo)(caracter : Char) : List[Int] = List(0)
  def convertirArbolTabla(arbolCodificacion : Nodo) : TablaCodigo = null
  def codificacionRapida(arbol: Nodo)(texto: List[Char]) : List[Int] = List(0)

}
