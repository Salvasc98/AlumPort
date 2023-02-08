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
 * Clase de la tabla de portatil
 * Esta tabla contendra la marca del portatil, el modelo y el identificador
 */

@Entity
@Table(name= "portatil", schema= "alumno-portatil")
public class GestionPortatil {
	
	//ATRIBUTOS
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_portatil", unique=true, nullable=false)
	private long id_portatil;
	@Column(name="md_uuid",nullable=false)
	private String md_uuid;
	@Column(name="md_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	@Column(name="marca",nullable=false)
	private String marca;
	@Column(name="modelo",nullable=false)
	private String modelo;
	@OneToOne(mappedBy="portatil")
	GestionAlumno alumno;
	
	//GETTERS Y SETTERS

	public long getId_portatil() {
		return id_portatil;
	}
	public void setId_portatil(long id_portatil) {
		this.id_portatil = id_portatil;
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
		return "GestionPortatil [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime()
				+ ", modelo=" + modelo + ", marca=" + marca + ", alumno=" + alumno + "]";
	}

}