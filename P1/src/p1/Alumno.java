package p1;

import java.util.HashMap;

/**
 * Created by roman on 11/3/16.
 */
public class Alumno {
    private String dni,
                   nombre,
                   apellidos,
                   correo;

    /*
    clave asignatura, valor grupo asignado
    valor −1 para indicar que el alumno no esta asignado a ningun grupo.
    */
    private HashMap<Asignatura, Integer> asignacion;

    public Alumno(String dni, String nombre, String apellidos, String correo){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        asignacion = new HashMap<>();
    }

    public String getDni(){
        return dni;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellidos(){
        return apellidos;
    }

    public String getCorreo(){
        return correo;
    }

    // ver si un alumno esta en esa asignatura
    public boolean cursarAsignatura(Asignatura asignatura) {
        return asignacion.containsKey(asignatura);
    }

    @Override
    public String toString() {
        return String.format(
                "%-8s %-8s %8.2f   %s", getDni(), getNombre(), getApellidos(), getCorreo()
        );
    }
}
