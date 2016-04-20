// <== Forma tradicional
// ==================================>
var nombreArchivo="base.txt"
if (!args.isEmpty)
	nombreArchivo=args(0)

// <== Usando programacion funcional
// ==================================>
// como usamos val nos aseguramos de que esta variable nunca cambiará
val nombreArchivo = if(!args.isEmpty) args(0) else "base.txt"
