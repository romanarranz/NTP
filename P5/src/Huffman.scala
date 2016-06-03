/**
  * Created by roman on 27/5/16.
  */

object Huffman {

  type TablaCodigo = List[(Char, List[Int])]

  /*
    Metodo para obtener el peso de un nodo
   */
  def calcularPeso(n : Nodo) : Int = n match {
    case NodoHoja(_, peso) => peso
    case NodoIntermedio(nodoIzda, nodoDcha, _, _) => calcularPeso(nodoIzda) + calcularPeso(nodoDcha)
  }

  /*
    Metodo para obtener los caracteres de un nodo
   */
  def obtenerCaracteres(n : Nodo) : List[Char] = n match {
    case NodoHoja(caracter, _) => List(caracter)
    case NodoIntermedio(nodoIzda, nodoDcha, _, _) => List.concat(obtenerCaracteres(nodoIzda),obtenerCaracteres(nodoDcha))
  }

  def generarArbol(izq: Nodo, der: Nodo) : Nodo = NodoIntermedio(izq, der, obtenerCaracteres(izq) ++ obtenerCaracteres(der), calcularPeso(izq) + calcularPeso(der))

  def decodificar(arbol : Nodo, bits : List[Int]): List[Char] = decodificar0(arbol, arbol, bits, List())
  def decodificar0(arbol: Nodo, actual: Nodo, bits: List[Int], result: List[Char]): List[Char] ={
    actual match {
      case NodoHoja(caracter,_) =>
        if(bits.isEmpty)
          List(caracter)
        else
          List(caracter) ++ decodificar0(arbol, arbol, bits, result)
      case NodoIntermedio(hijoIzda, hijoDcha, _, _) =>
        if(bits.head == 0)
          decodificar0(arbol, hijoIzda, bits.tail, result)
        else
          decodificar0(arbol, hijoDcha, bits.tail, result)
    }
  }

  def codificar(arbol : Nodo, texto : List[Char]) : List[Int] = List(' ')
  def codificarConTabla(tabla : TablaCodigo)(caracter : Char) : List[Int] = List(0)

  def convertirArbolTabla(arbolCodificacion : Nodo) : TablaCodigo = convertirArbolTabla0(arbolCodificacion, List())
  def convertirArbolTabla0(nodo: Nodo, lista: List[Int]): TablaCodigo = {
    nodo match {
      case NodoHoja(caracter, _) => List((caracter, lista))
      case NodoIntermedio(hijoIzda, hijoDcha, _, _) => convertirArbolTabla0(hijoIzda, lista ++ List(0)) ++ convertirArbolTabla0(hijoDcha, lista ++ List(1))
    }
  }

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
