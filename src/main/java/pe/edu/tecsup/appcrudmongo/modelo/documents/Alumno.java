package pe.edu.tecsup.appcrudmongo.modelo.documents;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumnos")
public class Alumno {
    @Id
    private String id;
    private String codigo;
    private String nombre;
    private String apellidos;
    private int ciclo;
    private String seccion;

    public Alumno() {
    }

    public Alumno(String id, String codigo, String nombre, String apellidos, int ciclo, String seccion) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciclo = ciclo;
        this.seccion = seccion;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getCiclo() { return ciclo; }
    public void setCiclo(int ciclo) { this.ciclo = ciclo; }

    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    @Override
    public String toString() {
        return "Alumno{" + "id=" + id +
                ", codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciclo=" + ciclo +
                ", seccion='" + seccion + '\'' +
                '}';
    }
}