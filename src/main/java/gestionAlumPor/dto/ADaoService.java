package gestionAlumPor.dto;

/*
 * Interfaz que contiene los metodos para pasar de DTO a DAO
 */

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionPortatil;

public interface ADaoService {
	
	public GestionAlumno GestionAlumnoDTOADAO(GestionAlumnoDTO gestionAlumnoDTO);
	
	public GestionPortatil GestionPortatilDTOADAO(GestionPortatilDTO gestionPortatilDTO);
	
}