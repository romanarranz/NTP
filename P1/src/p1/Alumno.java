package p1;

import java.util.HashMap;
import java.util.Optional;

/**
 * Created by roman on 11/3/16.
 */
public class Alumno {
    private String dni,
                   nombre,
                   apellidos,
                   correo;

    private HashMap<Asignatura, Integer> asignacion;

    public Alumno(String dni, String nombre, String apellidos, String correo)
    {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.asignacion = new HashMap<>();
    }

    public String getDni()
    {
        return dni;
    }

    public String getNombre()
    {
        return nombre;
    }

    public String getApellidos()
    {
        return apellidos;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setAsignacion(Optional<String> asignatura, Integer grupo)
    {
        asignacion.put(Asignatura.getTipo(asignatura.get()),grupo);
    }

    // ver si un alumno esta en esa asignatura
    public boolean cursarAsignatura(String asignatura)
    {
        return asignacion.containsKey(Asignatura.getTipo(asignatura));
    }

    public boolean cursaAsignaturaGrupo(String asignatura, Integer grupo)
    {
        boolean result = false;
        Asignatura a = Asignatura.getTipo(asignatura);
        if(asignacion.containsKey(a) && (asignacion.get(a) == grupo))
            result = true;

        return  result;
    }

    @Override
    public String toString()
    {
        return getDni() + "\t" + getNombre() + "\t\t" + getApellidos() + "\t" + getCorreo() + "\t" + asignacion.toString();
    }
}
