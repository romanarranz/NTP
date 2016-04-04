class A {
	def saludar = "Saludo desde clase A"
	override def toString = "Clase: " + getClass.getName
}

class B extends A

class C extends B {
	override def saludar = "saludo desde C y " + super.saludar
}

val objA = new A
val objB = new B
val objC = new C

println(objA)
println(objA.saludar+"\n")

println(objB)
println(objB.saludar+"\n")

println(objC)
println(objC.saludar+"\n")