def suma5(inicio : Int, fin : Int) : Unit = {
	if(inicio <= fin){
		println(inicio)
		suma5(inicio+5, fin)
	}
}

if(args.length > 0){
	suma5(args(0).toInt, args(0).toInt*10)
}
else
	Console.err.println("Introduzca argumento como numero real")