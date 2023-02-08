package gestionAlumPor.dto;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import gestionAlumPor.dal.GestionAlumno;

/*
 * Clase de portatil en la que recogemos la información necesaria
 */


@Component
public class GestionPortatilDTO {
	
	//ATRIBUTOS
	private Calendar md_date;
	private String modelo;
	private String marca;
	GestionAlumno alumno;
		
	//CONSTRUCTORES
		
	//Constructor vacío
		
	public GestionPortatilDTO() {
	super();
	}
		
	//Constructor para los portatiles
		
	public GestionPortatilDTO(Calendar md_date, String modelo, String marca) {
		super();
		this.md_date = md_date;
		this.modelo = modelo;
		this.marca = marca;
	}
		
	//GETTERS Y SETTERS

	public Calendar getMd_date() {
		return md_date;
	}
	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public GestionAlumno getAlumno() {
		return alumno;
	}
	public void setAlumno(GestionAlumno alumno) {
		this.alumno = alumno;
	}
		
	//TOSTRING
		
	@Override
	public String toString() {
		return "Portatil: " + "md_date=" + md_date + ", modelo=" + modelo + ", marca=" + marca 
				+ ", alumno=" + alumno + "]";
	}

}