package gestionAlumPor.dto;

import java.util.Calendar;

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionPortatil;


/*
 * Interfaz para definir los métodos para el DTO
 */

public interface ADtoService {

	public GestionAlumnoDTO AGestionAlumnoDTO(Calendar md_date, String nombre,
			String telefono, GestionPortatil portatil);
	
	public GestionPortatilDTO AGestionPortatilDTO(Calendar md_date, String modelo, String marca);
}