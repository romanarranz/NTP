package p1;

/**
 * Created by roman on 11/3/16.
 */
public enum Asignatura {
    MP(1), TOC(2), LMD(3), ES(4);

    protected int tipo;
    Asignatura(int tipo)
    {
        this.tipo = tipo;
    }

    public static Asignatura getTipo(String asig)
    {
        Asignatura tipo;
        switch(asig)
        {
            case "ES":
                tipo = Asignatura.ES;
                break;

            case "LMD":
                tipo = Asignatura.LMD;
                break;

            case "MP":
                tipo = Asignatura.MP;
                break;

            default:
                tipo = Asignatura.TOC;
                break;
        }
        return tipo;
    }

    @Override
    public String toString()
    {
        String s;
        switch (tipo)
        {
            case 1:
                s = "MP";
                break;

            case 2:
                s = "TOC";
                break;

            case 3:
                s = "LMD";
                break;

            default:
                s = "ES";
                break;
        }
        return s;
    }
}
