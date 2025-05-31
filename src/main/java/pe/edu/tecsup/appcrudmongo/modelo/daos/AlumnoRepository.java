package pe.edu.tecsup.appcrudmongo.modelo.daos;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.edu.tecsup.appcrudmongo.modelo.documents.Alumno;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

}