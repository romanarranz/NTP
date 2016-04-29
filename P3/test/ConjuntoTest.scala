
import org.scalatest.junit.JUnitSuite
import org.junit.Test
import org.junit.Before

/**
  * Created by roman on 22/4/16.
  */
class ConjuntoTest extends JUnitSuite{

  import ConjuntoFuncional._

  var cNeg1: Conjunto = _
  var c0: Conjunto = _
  var c1: Conjunto = _
  var c2: Conjunto = _
  var c3: Conjunto = _

  @Before def initialize(){

    cNeg1 = conjuntoUnElemento(-1)
    c0 = conjuntoUnElemento(0)
    c1 = conjuntoUnElemento(1)
    c2 = conjuntoUnElemento(2)
    c3 = conjuntoUnElemento(3)
  }

  @Test def testContiene(){
    println("Test de contiene")

    assert(contiene(c0, 0), "Error: c0 no contiene a 0")
    assert(contiene(cNeg1, -1), "Error: cNeg1 no contiene a -1")
    assert(!contiene(c2, -23), "Error: c2 contiene a -23")
  }

  @Test def testUnion(): Unit ={
    println("Test de union")
    val s = union(c1,c2)
    assert(contiene(s, 1), "Error: s no contiene a 1")
    assert(contiene(s, 2), "Error: s no contiene a 2")
    assert(!contiene(s, 3), "Error: s contiene a 3")

    val conjunto1 = (x: Int) => x > 3
    val conjunto2 = (x: Int) => x > 5

    // Conjunto union: enteros mayores de 3
    val conjuntoUnion = union(conjunto1, conjunto2)

    // 4, 5, 6 y 7  pertenecen a la union
    assert(contiene(conjuntoUnion, 4), "Error: conjuntoUnion no contiene a 4")
    assert(contiene(conjuntoUnion, 5), "Error: conjuntoUnion no contiene a 5")
    assert(contiene(conjuntoUnion, 6), "Error: conjuntoUnion no contiene a 6")
    assert(contiene(conjuntoUnion, 7), "Error: conjuntoUnion no contiene a 7")

    // 3 y 0 no pertenecen a la union
    assert(!contiene(conjuntoUnion, 3), "Error: conjuntoUnion si contiene a 3")
    assert(!contiene(conjuntoUnion, 0), "Error: conjuntoUnion si contiene a 0")
  }

  @Test def testInterseccion(){
      val conjunto1 = (x: Int) => x > 3
      val conjunto2 = (x: Int) => x > 5

      // Formacion de la interseccion: solo a partir de 5
      val conjuntoInterseccion = interseccion(conjunto1, conjunto2)

      // 6 pertenece
      assert(contiene(conjuntoInterseccion, 6), "Error: conjuntoInterseccion no contiene a 6")

      // no 4 ni 5 pertenecen
      assert(!contiene(conjuntoInterseccion, 4), "Error: conjuntoInterseccion si contiene a 4")
      assert(!contiene(conjuntoInterseccion, 5), "Error: conjuntoInterseccion si contiene a 5")
  }

  @Test def testDiferencia(){
      val conjunto1 = (x: Int) => x > 3
      val conjunto2 = (x: Int) => x < 10

      // Diferencia: mayores de 3 pero no menores de 10
      val conjuntoDiferencia = diferencia(conjunto1, conjunto2)

      // 6 no pertenece y 11 si
      assert(!contiene(conjuntoDiferencia, 6), "Error: conjuntoDiferencia si contiene a 6")
      assert(contiene(conjuntoDiferencia, 11), "Error: conjuntoDiferencia no contiene a 11")
  }

  @Test def testFilter(){
      val conjunto1 = (x: Int) => x > 3
      val conjunto2 = (x: Int) => x < 10

      // Deja en conjunto1 los elementos de conjunto2
      val conjuntoFiltrado = filter(conjunto1, conjunto2)

      // 6 debe pertenecer y 11 no
      assert(contiene(conjuntoFiltrado, 6), "Error: conjuntoFiltrado no contiene a 6")
      assert(!contiene(conjuntoFiltrado, 11), "Error: conjuntoFiltrado si contiene a 11")
  }

  @Test def testExist(){
    println("Test de existe")

    val conjunto = (x:Int) => x<10

    assert(!existe(conjunto, x=>x>10), "Error: conjunto tiene algun elemento mayor a 10")
    assert(existe(conjunto, x=>x<15), "Error: conjunto tiene algun elemento mayor a 15")
  }

  @Test def testParaTodo(){
    println("Test de para todo")

    val conjunto = (x:Int) => x < 10

    assert(!paraTodo(c0, x => x>0), "Error: algun elemento es mayor que 0 ")
    assert(paraTodo(c0, x => x<15), "Error: algun elemento es mayor que 15")

    assert(paraTodo(conjunto, x => x<20), "Error: algun elemento es mayor que 20")
    assert(!paraTodo(conjunto, x => x>0), "Error: algun elemento es mayor a 0")
  }

  @Test def testMap(){
    println("Test de map")

    // Definicion del conjunto
    val conjunto = (x:Int) => x<10

    // Mapeo: sumar 25 a todos los elementos del conjunto
    val resultado = map(conjunto, x=> x+25)
    assert(contiene(resultado, 30), "Error: resultado no contiene a 30")
    assert(!contiene(resultado,36), "Error: resultado si contiene a 36")

    // 125 no pertenece, porque 100 no esta en el conjunto de partida
    assert(!contiene(resultado, 125), "Error: resultado si contiene a 125")
  }
}