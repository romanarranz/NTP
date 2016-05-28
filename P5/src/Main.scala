/**
  * Created by roman on 28/5/16.
  */
object Main extends App{

  println("### Nodos Hoja ###")

  // no es necesario usar new al tratarse de clases tipo case
  val A = NodoHoja('A',8)
  val B = NodoHoja('B',3)
  val C = NodoHoja('C',1)
  val D = NodoHoja('D',1)
  val E = NodoHoja('E',1)
  val F = NodoHoja('F',1)
  val G = NodoHoja('G',1)
  val H = NodoHoja('H',1)
  print(A)
  print(B)
  print(C)
  print(D)
  print(E)
  print(F)
  print(G)
  print(H)

  println("\n### Nodos Intermedios ###")
  val CD: Nodo = Huffman.generarArbol(C,D)
  val EF:Nodo = Huffman.generarArbol(E,F)
  val GH:Nodo = Huffman.generarArbol(G,H)
  print(CD)
  print(EF)
  print(GH)

  val BCD: Nodo = Huffman.generarArbol(B,CD)
  print(BCD)

  val EFGH: Nodo = Huffman.generarArbol(EF,GH)
  print(EFGH)

  val BCDEFGH:Nodo = Huffman.generarArbol(BCD,EFGH)
  print(BCDEFGH)

  println("\n### Nodo raiz ###")
  val raiz: Nodo = Huffman.generarArbol(A,BCDEFGH)
  print(raiz)
}
