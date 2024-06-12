package com.crud.alumnos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.alumnos.modelo.Alumno;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer>{

}
