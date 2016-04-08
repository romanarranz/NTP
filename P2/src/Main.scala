
/**
  * Objeto singleton para probar la funcionalidad del triangulo
  * de Pascal
  */
object Main {

  /**
    * Metodo main: en realidad no es necesario porque el desarrollo
    * deberia guiarse por los tests de prueba
    *
    * @param args
    */
  def main(args: Array[String]) {
    println("................... Triangulo de Pascal ...................")

    // Se muestran 10 filas del trinagulo de Pascal
    for (row <- 0 to 10) {
      // Se muestran 10 10 columnas
      for (col <- 0 to row)
        print(calcularValorTrianguloPascal(col, row) + " ")

      // Salto de linea final para mejorar la presentacion
      println()
    }

    // Se muestra el valor que debe ocupar la columna 5 en la fila 10
    println(calcularValorTrianguloPascal(10, 15))
    println(calcularValorTrianguloPascal(0, 0))

    println("................... Comprobar Balance ...................")
    //println(chequearBalance("(if (zero? x) max (/ 1 x))".toList))
    println(chequearBalance("(if (a ¿ b) (b/a) else (a/(b*b)))".toList))
    println(chequearBalance(":-)".toList))

    println("................... Contar cambios posibles ...................")
    println(contarCambiosPosibles(300,List(500,5,50,100,20,200,10)))
    println(contarCambiosPosibles(10,List(1,2,5)))
  }

  /**
    * Ejercicio 1: funcion para generar el triangulo de Pascal
    *
    * @param columna
    * @param fila
    * @return
    */
  def calcularValorTrianguloPascal(columna: Int, fila: Int): Int = {
     // caso base
     if(columna == 0 || columna == fila)
       1
     // caso recursivo, cogiendo la suma de los valores que tiene encima del elemento interno
     else
       calcularValorTrianguloPascal(columna-1, fila-1) + calcularValorTrianguloPascal(columna,fila-1)
  }

  /**
    * Ejercicio 2: funcion para chequear el balance de parentesis
    *
    * @param cadena cadena a analizar
    * @return valor booleano con el resultado de la operacion
    */

  def balance(cadena: List[Char]): Int = {
    if(!cadena.isEmpty) {
      if (cadena.last == '(')
        -1
      else if (cadena.head == '(')
        1 + balance(cadena.tail)
      else if (cadena.head != ')' && cadena.head != '(')
        0 + balance(cadena.tail)
      else if (cadena.head == ')')
        -1 + balance(cadena.tail)
      else
        0
    }
    else
      0
  }

  def chequearBalance(cadena: List[Char]): Boolean = {
     val resultado = balance(cadena)

     if(cadena.isEmpty || resultado == 0)
       true
     else
       false
  }

  /* El expuesto en clase */
  def chequearBalancev2(cadena : List[Char]): Boolean = {

    def contarParentesis(cadena : List[Char], contador : Int): Int = {
      if (cadena.isEmpty)
        contador
      else {
        val acumulador = cadena.head.match {
          case ')' => contador - 1
          case '(' => contador + 1
          case _ => contador
        }
        if (acumulador < 0)
          acumulador
        else
          contarParentesis(cadena.tail, acumulador)
      }
    }
    contarParentesis(cadena, 0) == 0
  }

  /**
    * Ejercicio 3: funcion para determinar las posibles formas de devolver el
    * cambio de una determinada cantidad con un conjunto de monedas
    *
    * @param cantidad
    * @param monedas
    * @return contador de numero de vueltas posibles
    */
  def contarCambiosPosibles(cantidad: Int, monedas: List[Int]): Int = {
     if(cantidad == 0)
       1
     else if(cantidad < 0 || monedas.length == 0)
       0
     else
       contarCambiosPosibles(cantidad - monedas.head, monedas) + contarCambiosPosibles(cantidad, monedas.tail);
  }
}
