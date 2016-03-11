package p1;

/**
 * Created by roman on 11/3/16.
 */
public enum Asignatura {
    MP(1), TOC(2), LMD(3), ES(4);

    protected int tipo;
    Asignatura(int tipo){
        this.tipo = tipo;
    }

    public int getTipo(){
        return tipo;
    }
}
