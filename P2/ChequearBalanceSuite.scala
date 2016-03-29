

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ChequearBalanceSuite extends FunSuite {
  import Main.chequearBalance

  // Prueba 1
  test("chequear balance: '(if (zero? x) max (/ 1 x))' esta balanceada") {
    assert(chequearBalance("(if (zero? x) max (/ 1 x))".toList))
  }

  // Prueba 2
  test("chequear balance: 'Te lo dije ...' esta balanceada") {
    assert(chequearBalance("Te lo dije (eso no esta (todavia) hecho).\n(Pero el no estaba escuchando)".toList))
  }

  // Prueba 3
  test("chequear balance: ':-)' no esta balanceada") {
    assert(!chequearBalance(":-)".toList))
  }

  // Prueba 4
  test("chequear balance: no basta con contar sin mas") {
    assert(!chequearBalance("())(".toList))
  }

  // Prueba 5
  test("(if (a > b) (b/a) else (a/(b*b)))"){
    assert(chequearBalance("(if (a > b) (b/a) else (a/(b*b)))".toList))
  }

  // Prueba 6
  test("(ccc(ccc)cc((ccc(c))))"){
    assert(chequearBalance("(ccc(ccc)cc((ccc(c))))".toList))
  }

  // Prueba 7
  test("(if (a > b) b/a) else (a/(b*b)))"){
    assert(!chequearBalance("(if (a > b) b/a) else (a/(b*b)))".toList))
  }

  // Prueba 7
  test("(ccc(ccccc((ccc(c))))"){
    assert(!chequearBalance("(ccc(ccccc((ccc(c))))".toList))
  }

  // Prueba 8
  test("())()())"){
    assert(!chequearBalance("())()())".toList))
  }
}
