// Hexadecimal
val hex = 0x16
val hex2 = 0x00FF

// Decimal
val dec = 31  // de tipo Int
val dec = 31l // de tipo Long

// Byte
val byte:Byte = 12

// Short
val short:Short = 12

/*
Si intentamos asignar un Int a una variable de tipo Byte o Short se produce una conversion automatica siempre y cuando el valor
este dentro de los valores permitidos. En este caso como nos pasamos del limite nos arroja un error

val short1:Short = 234567
val byte1:Byte = 234567
*/

// Float
val val1 = 1.2345
val val2 = 1.2345f

// Double
val val3 = 1.2E23

// Char
val c1 = 'A'
val c2 = '\n'

// String
val saludo = "Hola"

// tambien se pueden escribir en formato crudo
val cadena = """Hola, esto va en una linea.
Y esto en "otra" diferente"""