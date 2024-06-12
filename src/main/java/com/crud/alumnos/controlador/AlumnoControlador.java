package com.crud.alumnos.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.crud.alumnos.servicio.AlumnoServicio;
import com.crud.alumnos.modelo.Alumno;

@Controller
public class AlumnoControlador {
	
	@Autowired
	private AlumnoServicio servicio;

	@GetMapping({ "/alumnos", "/" })
	public String listarAlumnos(Model modelo) {
		List<Alumno> alumnos = servicio.listar();
		modelo.addAttribute("alumnos", alumnos);
		return "index"; // retorna al archivo index.html
	}
	
	@GetMapping("/alumnos/nuevo")
	public String FormularioDeRegistrarAlumno(Model modelo) {
		Alumno alumno = new Alumno();
		modelo.addAttribute("alumno", alumno);
		return "crear"; // abre la pagina crear.html
	}
	
	@PostMapping("/alumnos")
	public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		servicio.guardarAlumno(alumno);
		return "redirect:/alumnos"; // llama a la pagina ppal.
	}
	
	@GetMapping("/alumnos/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("alumno", servicio.obtenerAlumnoPorId(id));
		return "editar";
	}
	
	@PostMapping("/alumnos/{id}")
	public String actualizarAlumno(@PathVariable int id, @ModelAttribute("alumno") Alumno alumno, Model modelo) {
		Alumno alumnoExistente = servicio.obtenerAlumnoPorId(id);
		alumnoExistente.setId(id);
		alumnoExistente.setApeynom(alumno.getApeynom());
		alumnoExistente.setEmail(alumno.getEmail());
		servicio.actualizarAlumno(alumnoExistente);
		return "redirect:/alumnos";
	}
	
	@GetMapping("/alumnos/{id}")
	public String eliminarAlumno(@PathVariable int id) {
		servicio.eliminarAlumno(id);
		return "redirect:/alumnos";
	}		
}