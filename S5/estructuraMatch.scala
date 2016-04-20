val primerArgumento = if (args.length > 0) args(0) else ""

// similar al switch, pero no necesita breaks y genera un valor directamente que se infiere
val ayuda = primerArgumento match { // ayuda sera de tipo String, inferido por el compilador
  case "l" => "formato largo"
  case "f" => "formato impresion"
  case _ => "por defecto"
}

println(ayuda)
