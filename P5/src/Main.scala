/**
  * Created by roman on 28/5/16.
  */
object Main extends App{

  print("### Nodos Hoja ###")

  // no es necesario usar new al tratarse de clases tipo case
  val A = NodoHoja('A',8)
  val B = NodoHoja('B',3)
  val C = NodoHoja('C',1)
  val D = NodoHoja('D',1)
  val E = NodoHoja('E',1)
  val F = NodoHoja('F',1)
  val G = NodoHoja('G',1)
  val H = NodoHoja('H',1)

  print("\n\n### Nodos Intermedios ###\n")
  val CD: Nodo = Huffman.generarArbol(C,D)
  val EF: Nodo = Huffman.generarArbol(E,F)
  val GH: Nodo = Huffman.generarArbol(G,H)
  val CDB: Nodo = Huffman.generarArbol(CD,B)
  val GHEF: Nodo = Huffman.generarArbol(GH,EF)
  val GHEFCDB: Nodo = Huffman.generarArbol(GHEF,CDB)
  print(CD)
  print(EF)
  print(GH)
  print(CDB)
  print(GHEF)
  print(GHEFCDB)

  println("\n### Nodo raiz ###")
  val raiz: Nodo = Huffman.generarArbol(A,GHEFCDB)
  print(raiz)

  val texto = "ABCABBADAEAAFGHAA"
  print("\nOcurrencias de la letra A: "+generarArbolCodificacion.obtenerTuplasOcurrencias('A', texto.toList)+"\n")

  val nodosTerminales = generarArbolCodificacion.generarListHojasOrdenadas(texto.toList)
  println(nodosTerminales)

  val combinar = generarArbolCodificacion.generarArbolCodificacion(texto.toList)
  println("\n## Resutado ##")
  print(combinar)

  val d1 = combinar.asInstanceOf[NodoIntermedio].hijoDcha
  val i1 = combinar.asInstanceOf[NodoIntermedio].hijoIzda
  println(d1)
  println(i1)

  val d2 = d1.asInstanceOf[NodoIntermedio].hijoDcha
  val i2 = d1.asInstanceOf[NodoIntermedio].hijoIzda
  println(d2)
  println(i2)

  val d3 = d2.asInstanceOf[NodoIntermedio].hijoDcha
  val i3 = d2.asInstanceOf[NodoIntermedio].hijoIzda
  val d4 = i2.asInstanceOf[NodoIntermedio].hijoDcha
  val i4 = i2.asInstanceOf[NodoIntermedio].hijoIzda
  println(d3)
  println(i3)
  println(d4)
  println(i4)

  println("¿Son iguales el arbol generado y el que hemos hecho manualmente?")
  println(raiz.equals(combinar))

}
