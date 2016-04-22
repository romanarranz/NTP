
import org.scalatest.junit.JUnitSuite
import org.scalatest.junit.ShouldMatchersForJUnit
import scala.collection.mutable.ListBuffer
import org.junit.Test
import org.junit.Before

/**
  * Created by roman on 22/4/16.
  */
class ConjuntoTest extends JUnitSuite with ShouldMatchersForJUnit{

  var sb: StringBuilder = _
  var lb: ListBuffer[String] = _

  @Before def initialize(){
    /*val conjunto = new Conjunto (x:Int) => x < 10
    assert(!paraTodo(conjunto, x=>x>0))
    assert(paraTodo(conjunto, x=>x<15))*/
    sb = new StringBuilder("ScalaTest is ")
    lb = new ListBuffer[String]
  }

  @Test def test("Test de existe"){
    /*val conjunto = (x:Int) => x<10
    assert(!existe(conjunto, x=>x>10))
    assert(existe(conjunto, x=>x<15))*/

    sb.append("easy!")
    assert(sb.toString === "ScalaTest is easy!")
    assert(lb.isEmpty)
    lb += "sweet"
    intercept[StringIndexOutOfBoundsException] {
      "concise".charAt(-1)
    }
  }

  @Test def verifyFun("Test de map"){
    /*val conjunto = (x:Int) => x<10
    val resultado = map(conjunto, x=> x+25)
    assert(contiene(resultado, 30))
    assert(!contiene(resultado,36))*/
  }
}