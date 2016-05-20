
/**
  * Clase de utilidad para representar conjuntos de tweets con temas de
  * google y apple, junto con un objeto de la clase Tendencia con todos
  * ellos
  */
object TerminosGoogleApple {
  // Lista de terminos de interes para google
  val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")

  // Lista de terminos de interes para apple
  val apple = List("ios", "iOS", "iphone", "iPhone", "ipad", "iPad")

  // Conjuntos de tweets para ambas listas de terminos
  // ------------------------ A IMPLEMENTAR -------------------------

  val mensajesGoogle: ConjuntoTweet = LectorTweets.obtenerConjuntoConTerminos(google)
  val mensajesApple: ConjuntoTweet = LectorTweets.obtenerConjuntoConTerminos(apple)

  // Se genera la lista completa de mensajes de ambos temas
  val tendencia: Tendencia = mensajesGoogle.union(mensajesApple).ordenacionAscendentePorRetweet
  val comunes: Tendencia = mensajesGoogle.interseccion(mensajesApple).ordenacionAscendentePorRetweet
}

/**
  * Clase para probar la funcionalidad
  */
object Main extends App {

  // A obtener informacion sobre

  println("1. Numero de mensajes en mensajesGoogle y mensajesApple")
  println("mensajesGoogle: "+TerminosGoogleApple.mensajesGoogle.numeroMensajes)
  println("mensajesApple: "+TerminosGoogleApple.mensajesApple.numeroMensajes)
  print("\n")

  println("2. Numero de mensajes en la tendencia")
  println(TerminosGoogleApple.tendencia.length)
  print("\n")

  println("3. Numero de mensajes comunes")
  println(TerminosGoogleApple.comunes.length+"\n")

  println("4. Orden de influencia de los mensajes comunes")
  TerminosGoogleApple.comunes.foreach(tweet => println(tweet))
  print("\n")

  println("5. Maximo y minimo numero de retweets en los mensajes comunes")
  def maxRT(t: Tendencia): Integer = {
    if(t.length>1) {
      maxRT(t.tail)
    }
    else
      t.head.retweets
  }

  println("Min: "+TerminosGoogleApple.comunes.head.retweets)
  println("Max: "+maxRT(TerminosGoogleApple.comunes))
  print("\n")

  println("6. Maximo y minimo de retweets en toda la coleccion de tendencia")
  println("Min: "+TerminosGoogleApple.tendencia.head.retweets)
  println("Max: "+maxRT(TerminosGoogleApple.tendencia))
  print("\n")
}
