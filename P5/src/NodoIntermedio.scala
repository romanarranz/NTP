/**
  * Created by roman on 27/5/16.
  */
case class NodoIntermedio(val hijoIzda: Nodo, val hijoDcha: Nodo, override val characters: List[Char], val cost: Int) extends Nodo {

  /**
    * Sebrescritura del metodo toString
    *
    * @return
    */
  override def toString: String =
    "characters: " + characters + ", cost: " + cost + "\n"
}