/**
  * Created by roman on 27/5/16.
  */
case class NodoIntermedio(hijoIzda: Nodo, hijoDcha: Nodo, characters: List[Char], cost: Int) extends Nodo {

  override def toString: String = "characters: " + characters + ", cost: " + cost + "\n"
}