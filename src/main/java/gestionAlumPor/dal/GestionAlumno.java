package gestionAlumPor.dal;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Clase de la tabla de alumnos
 * Esta tabla contendra el teléfono del alumno, el nombre y apellidos y el identificador
 */

@Entity
@Table(name= "alumno", schema= "alumno-portatil")
public class GestionAlumno {
	
	//ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alumno", unique=true, nullable=false)
	private long id_alumno;
	@Column(name="md_uuid",nullable=false)
	private String md_uuid;
	@Column(name="md_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="telefono",nullable=false)
	private String telefono;
	@OneToOne
	GestionPortatil portatil;
	
	//GETTERS Y SETTERS
	
	public long getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(long id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getMd_uuid() {
		return md_uuid;
	}
	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}
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
		return "GestionAlumnos [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime() 
				+ ", nombre_alumno=" + nombre + ", telefono=" + telefono + ", portatil=" + portatil + "]";
	}
	
}