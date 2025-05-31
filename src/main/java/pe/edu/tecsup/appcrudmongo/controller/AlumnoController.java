package pe.edu.tecsup.appcrudmongo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.tecsup.appcrudmongo.modelo.documents.Alumno;
import pe.edu.tecsup.appcrudmongo.servicios.AlumnoService;

import java.util.Map;


@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;

    @RequestMapping("/")
    public String home() {
        return "redirect:/listarAlumnos";
    }

    @RequestMapping(value = "/listarAlumnos", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos");
        model.addAttribute("alumnos", servicio.listar());
        return "listarAlumnosView";
    }

    @RequestMapping(value = "/formAlumno/{id}")
    public String editar(@PathVariable(value = "id") String id, Map<String, Object> model) {
        Alumno alumno = servicio.buscar(id);

        if (alumno == null) {
            return "redirect:/listarAlumnos";
        }

        model.put("alumno", alumno);
        model.put("titulo", "Editar Alumno");
        return "formAlumnoView";
    }

    @RequestMapping(value = "/formAlumno", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Alumno");
            return "formAlumnoView";
        }

        servicio.grabar(alumno);
        status.setComplete();
        return "redirect:/listarAlumnos";
    }

    @RequestMapping(value = "/eliminarAlumno/{id}")
    public String eliminar(@PathVariable(value = "id") String id) {
        if (servicio.buscar(id) != null) {
            servicio.eliminar(id);
        }
        return "redirect:/listarAlumnos";
    }

    @RequestMapping(value = "/formAlumno")
    public String crear(Map<String, Object> model) {
        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        model.put("titulo", "Nuevo Alumno");
        return "formAlumnoView";
    }

}