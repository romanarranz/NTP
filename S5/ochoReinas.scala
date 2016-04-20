/**
  * Funcion para solucionar el problema de colocacion de reinas en un
  * tablero de ajedrez, una fila
  * @param n
  * @return
  */
def solucionarProblemaReinas(n : Int) : List[List[(Int, Int)]] = {
  // Funcion para posicionar una reina en una fila
  def posicionarReinas(fila : Int) : List[List[(Int, Int)]] = {
    // Si la fila es la 0 hemos terminado
    if (fila == 0) List(List())
    else for {solucion <- posicionarReinas(fila - 1)
              // Considera posibles ubicaciones de la reina
              // en la fila k (desde 1 hasta n)
              columna <- 1 to n
              reina = (fila, columna)
              if posicionCorrecta(reina, solucion)
    } yield reina :: solucion

  }
  posicionarReinas(n)
}

/**
  * Determinar si la posicion de una nueva reina es compatible con una
  * solucion parcial
  * @param reinaNueva
  * @param solucionParcial
  * @return
  */
def posicionCorrecta(reinaNueva : (Int, Int), solucionParcial : List[(Int, Int)]) : Boolean =
  // chequeo de cada reina en la solucion parcial con la nueva reina
  solucionParcial forall (reinaPuesta => !enJaque(reinaPuesta, reinaNueva))

/**
  * Funcion para determinar si se produce un jaque entre dos reinas
  * posicionadas en el tablero
  * @param reina1
  * @param reina2
  * @return
  */
def enJaque(reina1 : (Int, Int), reina2 : (Int, Int)) : Boolean = {
  // que no esten en la misma fila
  reina1._1 == reina2._1 ||
    // que no esten en la misma columna
  reina1._2 == reina2._2 ||
  // que no esten en diagonal
    (reina1._1 - reina2._1).abs == (reina1._2 - reina2._2).abs
}

val soluciones: List[List[(Int, Int)]] =solucionarProblemaReinas(8)
println(soluciones.size)
