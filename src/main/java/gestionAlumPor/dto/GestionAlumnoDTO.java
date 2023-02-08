package gestionAlumPor.dto;


import java.util.Calendar;

import org.springframework.stereotype.Component;

import gestionAlumPor.dal.GestionPortatil;

/*
 * Clase de alumno en la que recogemos la información necesaria
 */

@Component
public class GestionAlumnoDTO {
	
	//ATRIBUTOS
	
	private Calendar md_date;
	private String nombre;
	private String telefono;
	GestionPortatil portatil;
	
	
	//CONSTRUCTORES
	
	//Constructor vacío
	
	public GestionAlumnoDTO() {
		super();
	}
	
	//Constructor para los alumnos
	
	public GestionAlumnoDTO(Calendar md_date, String nombre,
			 String telefono, GestionPortatil portatil) {
		super();
		this.md_date = md_date;
		this.nombre = nombre;
		this.telefono = telefono;
		this.portatil = portatil;
	}
	
	//GETTERS Y SETTERS
	
	public Calendar getMd_date() {
		return md_date;
	}
	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public GestionPortatil getPortatil() {
		return portatil;
	}
	public void setPortatil(GestionPortatil portatil) {
		this.portatil = portatil;
	}
	
	//TOSTRING
	
	@Override
	public String toString() {
		return "Alumno: " + "md_date=" + md_date + ", nombre=" + nombre	+ ", telefono=" + telefono + ", portatil=" + portatil + "]";
	}
}