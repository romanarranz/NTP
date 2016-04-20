import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException

def foo: String = {
  	val in = new BufferedReader(new InputStreamReader(System.in))
 	try {
		print("Escribe texto: ")
		in.readLine
  	}
  	catch {
    	case e: IOException => { e.printStackTrace(); e.toString() }
  	}
  	finally {
    	in.close()
  	}
}

println("Return value: " + foo)
