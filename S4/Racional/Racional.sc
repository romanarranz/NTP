class Racional(n : Int, d : Int){
  require(d != 0)

  private val factor = mcd(n,d)

  val numerador : Int = n/factor
  val denominador : Int = d/factor

  // Constructor distinto con un parametro
  def this(n : Int) = this(n,1)

  override def equals(otro : Any) = {
    // otro sea una instancia de Racional y
    otro.isInstanceOf[Racional] &&
    // que tratemos a otro como una instancia de Racional para obtener su numerador y
    otro.asInstanceOf[Racional].numerador == numerador &&
    // que tratemos a otro como una instancia de Racional para obtener su numerador
    otro.asInstanceOf[Racional].denominador == denominador
  }

  // si no devolviera nada devolveria Unit, pero aqui como devolvemos Racional no es necesario
  // indicar el tipo
  def sumar(num : Racional) = {
    new Racional(
      (numerador * num.denominador) + (num.numerador * denominador),
      denominador * num.denominador
    )
  }

  // sobrecarga del operador +
  def +(num : Racional) = {
    new Racional(
      (numerador * num.denominador) + (num.numerador * denominador),
      denominador * num.denominador
    )
  }

  def menorQue(otro : Any) = {
    // otro sea una instancia de Racional y
    otro.isInstanceOf[Racional] &&
    // que tratemos a otro como una instancia de Racional para obtener su numerador y
    otro.asInstanceOf[Racional].denominador * numerador <
    // que tratemos a otro como una instancia de Racional para obtener su numerador
    otro.asInstanceOf[Racional].numerador * denominador
  }

  def max(otro : Any) : Racional = {
    if(this.menorQue(otro))
      otro.asInstanceOf[Racional]
    else
      this
  }

  private def mcd(a : Int, b : Int): Int = {
    if(b == 0) a
    else mcd(b, a%b)
  }

  override def toString = numerador + "/" + denominador +" - mcd " + mcd(n,d)
}

val obj1 = new Racional(2,3)
val obj2 = new Racional(4,7)

// obtenemos un error debido al require
// val objCero = new Racional(4,0)

obj1
obj1.sumar(new Racional(4,2))
obj1.equals(new Racional(2,3))
obj1.equals(new Racional(2,312))
obj1.menorQue(new Racional(2,2))
obj2.max(obj1)

val obj3 = new Racional(3)

obj1+obj3