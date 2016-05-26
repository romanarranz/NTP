/**
  * Created by roman on 27/5/16.
  */
class Huffman {

  type TablaCodigo = List[(Char, List[Int])]

  def decodificar(arbol : Node, bits : List[Int]) : List[Char]
  def codificar(arbol : Node, texto : List[Char]) : List[Int]

  def codificarConTabla(tabla : TablaCodigo)(caracter : Char) : List[Int]
  def convertirArbolTabla(arbolCodificacion : Node) : TablaCodigo

}
