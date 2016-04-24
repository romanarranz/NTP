
import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.junit.Before

/**
  * Created by roman on 22/4/16.
  */
class ConjuntoTest extends JUnitSuite{

  import ConjuntoFuncional._

  var c2: Conjunto = _
  var cNeg1: Conjunto = _
  var c0: Conjunto = _


  @Before def initialize(){
    c2 = conjuntoUnElemento(2)
    cNeg1 = conjuntoUnElemento(-1)
    c0 = conjuntoUnElemento(0)
  }

  @Test def testContiene(){
    println("Test de contiene")
    assert(contiene(c0, 0), "fallo: c0 no contiene a 0")
    assert(contiene(cNeg1, -1), "fallo: cNeg1 no contiene a -1")
    assert(!contiene(c2, -23), "fallo: c2 contiene a -23")
  }

  @Test def testExist(){
    println("Test de existe")
    val conjunto = (x:Int) => x<10
    assert(!existe(conjunto, x=>x>10))
    assert(existe(conjunto, x=>x<15))
  }

  @Test def testParaTodo(){
    println("Test de para todo")
    assert(!paraTodo(c0, x=>x>0))
    assert(paraTodo(c0, x=>x<15))
  }

  @Test def testMap(){
    println("Test de map")
    val conjunto = (x:Int) => x<10
    val resultado = map(conjunto, x=> x+25)
    assert(contiene(resultado, 30))
    assert(!contiene(resultado,36))
  }
}