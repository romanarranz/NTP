object LineasLargas {
    def procesarArchivo(nombre : String, ancho : Int): Unit = {
        val origen=Source.fromFile(nombre)
            for(linea <- origen.getLines())
                procesarLinea(nombre, ancho, linea)
    }

    private def procesarLinea(nombre : String, ancho :Int, linea : String): Unit = {
        if (linea.length > ancho)
            println(nombre + " : " + linea.trim)
    } 
}
