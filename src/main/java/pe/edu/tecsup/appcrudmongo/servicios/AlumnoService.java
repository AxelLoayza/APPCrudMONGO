package pe.edu.tecsup.appcrudmongo.servicios;


import pe.edu.tecsup.appcrudmongo.modelo.documents.Alumno;

import java.util.List;

public interface AlumnoService {

    public List<Alumno> listar();

    public void grabar(Alumno alumno);

    public Alumno buscar(String id);

    public void eliminar(String id);
}