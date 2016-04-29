
/**
  * Practica de conjuntos funcionales
  */
object ConjuntoFuncional {
  /**
    * Un conjunto funcional se representa mediante una funcion
    * caracteristica, un predicado. De esta forma, se declara
    * el tipo conjunto como un predicado que recibe un entero
    * (elemento) como argumento y devuelve un valor booleano
    * que indica si pertenece o no al conjunto
    */
  type Conjunto = Int => Boolean

  /**
    * Metodo para determinar si un elemento pertenece al conjunto
    * @param conjunto
    * @param elemento
    * @return
    */
  def contiene(conjunto: Conjunto, elemento: Int): Boolean = conjunto(elemento)

  /**
    * Devuelve un conjunto asociado al elemento pasado como
    * argumento
    * @param elemento
    * @return
    *
    */
  def conjuntoUnElemento(elemento: Int): Conjunto = (x:Int) => x == elemento

  /**
    * Union de dos conjuntos
    * @param conjunto1
    * @param conjunto2
    * @return
    */
  def union(conjunto1: Conjunto, conjunto2: Conjunto): Conjunto = (x:Int) => conjunto1(x) || conjunto2(x)

  /**
    * Interseccion de dos conjuntos
    * @param conjunto1
    * @param conjunto2
    * @return
    */
  def interseccion(conjunto1: Conjunto, conjunto2: Conjunto): Conjunto = (x:Int) => conjunto1(x) && conjunto2(x)

  /**
    * Diferencia entre dos conjuntos
    * @param conjunto1
    * @param conjunto2
    * @return
    */
  def diferencia(conjunto1: Conjunto, conjunto2: Conjunto): Conjunto = (x:Int) => conjunto1(x) && !conjunto2(x)

  /**
    * Filtrado para obtener el conjunto de los elementos que cumplen
    * el predicado pasado como argumento
    * @param conjunto
    * @param p
    * @return
    */
  def filter(conjunto: Conjunto, p: Int => Boolean): Conjunto = (x:Int) => conjunto(x) && p(x)

  /**
    * Limite para la iteracion necesaria con paraTodo y existe,
    * entre -1000 y 1000
    */
  private val LIMITE = 1000

  /**
    * Determina si todos los elementos del conjunto cumplen
    * la condicion indicada por el predicado
    * @param conjunto
    * @param p
    * @return
    */
  def paraTodo(conjunto: Conjunto, p: Int => Boolean): Boolean = {
    // Funcion auxiliar para iterar sobre los valores desde
    // -LIMITE a LIMITE
    def iter(elemento: Int): Boolean = {
      // si elemento hubiera superado el LIMITE quiere decir que se han recorrido todos los elementos del conjunto y que cumplen la condicion del predicado p
      if (elemento > LIMITE) true
      else if (!conjunto(elemento)) iter(elemento+1)  // si el elemento no perteneciera al conjunto mirariamos el siguiente
      else iter(elemento + 1) && p(elemento)
    }

    iter(-LIMITE)
  }

  /**
    * Determina si existe al menos un elemento en el conjunto
    * que cumple el predicado indicado
    * @param conjunto
    * @param p
    * @return
    */
    // ejemplo para el conjunto de numeros naturales {1, 2, 3, 4...} veamos si se cumple el predicado x > 0 que realmente es asi
    // !(x>0) = x<=0 veamos si se cumple para todo el conjunto, que exista alguno con esta condicion.
    // como nos devuelve false, negandolo obtenemos true ya que en este conjunto no hay ninguno que cumpla esa condicion
  def existe(conjunto: Conjunto, p: Int => Boolean): Boolean = !paraTodo(conjunto, x => !p(x))

  /**
    * Genera un nuevo conjunto transformando los elementos del
    * conjunto pasado como argumento y aplicando la transformacion
    * dada por la funcion pasada como segundo argumento
    * @param conjunto
    * @param funcion
    * @return
    */
  def map(conjunto: Conjunto, funcion: Int => Int): Conjunto = (x:Int) => existe(conjunto, y => funcion(y) == x )

  /**
    * Crea una cadena con el contenido completo del conjunto
    * @param conjunto
    * @return
    */
  def toString(conjunto: Conjunto): String = {
    val elementos = for (
      i <- -LIMITE to LIMITE if contiene(conjunto, i)) yield i
    elementos.mkString("{", ",", "}")
  }

  /**
    * Muestra el contenido completo del conjunto por pantalla
    * @param conjunto
    */
  def printSet(conjunto: Conjunto) {
    println(toString(conjunto))
  }
}
