package com.crud.alumnos.servicio;

import java.util.List;
import com.crud.alumnos.modelo.Alumno;

public interface AlumnoServicioInterface {
	
	public List<Alumno> listar();
	public Alumno guardarAlumno(Alumno alumno);
	public Alumno obtenerAlumnoPorId(int id);
	public Alumno actualizarAlumno(Alumno alumno);
	public void eliminarAlumno(int id);

}
