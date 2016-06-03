/**
  * Created by roman on 27/5/16.
  */
case class NodoHoja(letter: Char, cost: Int) extends Nodo {
  override def toString: String = "letter: " + letter + ", cost: " + cost + "\n"
}
