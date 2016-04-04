class A {
	def saludar = "Saludo desde clase A"
	override def toString = "Clase: " + getClass.getName
}

class B extends A {
	override def saludar = "saludo desde B"
}

class C extends B {
	override def saludar = "saludo desde C y " + super.saludar
}

val obj1:A = new A

// Obj2 es de tipo A que encapsula el tipo hijo B
val obj2:A = new B

println(obj1.saludar)
println(obj2.saludar)