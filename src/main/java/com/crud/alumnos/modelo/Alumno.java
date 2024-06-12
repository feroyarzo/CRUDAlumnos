package com.crud.alumnos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "alumnos")
public class Alumno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "apeynom", nullable = false, length = 30)
	public String apeynom;
	
	// definición atributo email y propiedades
	@Column(name = "email", nullable = false, length = 60)
	public String email;
		
	// definición de constructor/setter/getter/
	public String getApeynom() {
        return apeynom;
    }
    
    public void setApeynom(String apeynom) {
        this.apeynom = apeynom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
}


