package gestionAlumPor.dto;

import java.util.Calendar;

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionPortatil;

/*
 * Clase que recoge los datos del DTO
 */

public class ADtoServiceImpl  implements ADtoService{

	public GestionAlumnoDTO AGestionAlumnoDTO(Calendar md_date, String nombre,
			String telefono, GestionPortatil portatil) {

		GestionAlumnoDTO DTO = new GestionAlumnoDTO(md_date, nombre,  
				telefono, portatil);
		
		return DTO;
	}

	public GestionPortatilDTO AGestionPortatilDTO(Calendar md_date, String modelo, String marca) {
		
		GestionPortatilDTO DTO = new GestionPortatilDTO(md_date, modelo, marca);
		
		return DTO;
	}

}