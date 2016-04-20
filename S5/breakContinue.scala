// Aun sin tener sentencias break y continue podemos obtener los mismos resultados haciendo uso de variables booleanas
/*
CODIGO JAVA QUE SE QUIERE TRADUCIR A SCALA

int i=0;
boolean encontrado=false;
while(i < args.length){
	if(args[i].startsWith("-")){
		i=i+1;
		continue;
	}
   	if (args[i].endsWith(".scala")){
    	encontrado=true;
      	break;
	}
	i=i+1;
}
*/

/*
CODIGO SCALA

Pero recordemos que el codigo de scala debe ser lo mas funcional posible y como sabemos que los bucles while podemos
evitarlos usando recursividad

var i=0
var encontrado=false
while(i < args.length && !encontrado){
	if(!args(i).startsWith("-")){
    	if(args(i).endsWith(".scala"))
        	encontrado=true
   	}
	else i=i+1
}
*/

// CODIGO SCALA RECURSIVO
def buscarArgumentosDesde(i : Int) : Int =
	if (i >= args.length) -1
	else if(args(i).endsWith(".scala")) i
	else buscarArgumentosDesde(i+1)

val indice = buscarArgumentosDesde(0)

println(indice)
