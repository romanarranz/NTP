/**
  * Created by roman on 27/5/16.
  */
case class NodoHoja(val letter: Char, val cost: Int) extends Nodo {
  override val characters:List[Char] = List(letter)
  /**
    * Sebrescritura del metodo toString
 *
    * @return
    */
    override def toString: String =
    "letter: " + letter + ", cost: " + cost + "\n"
}