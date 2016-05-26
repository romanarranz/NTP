/**
  * Created by roman on 27/5/16.
  */
class LeafNode(val letter: Char, val cost: Integer) extends Node {
  /**
    * Sebrescritura del metodo toString
    * @return
    */
    override def toString: String =
    "letter: " + letter + ", cost: " + cost + "\n"
}
