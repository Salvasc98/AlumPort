package gestionAlumPor.dto;

import java.util.Random;

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionPortatil;


/*
 * Clase que implementa los metodos de nuestra interfaz aDao 
 */

public class ADaoServiceImpl implements ADaoService{

	public GestionAlumno GestionAlumnoDTOADAO(GestionAlumnoDTO gestionAlumnoDTO){
		String md_uuid = java.util.UUID.randomUUID().toString();
		Random numero = new Random(5000);
		GestionAlumno gestionAlumno = new GestionAlumno();
		if(gestionAlumnoDTO != null) {
			gestionAlumno.setMd_uuid(md_uuid);
			gestionAlumno.setMd_date(gestionAlumnoDTO.getMd_date());
			gestionAlumno.setNombre(gestionAlumnoDTO.getNombre());
			gestionAlumno.setTelefono(gestionAlumnoDTO.getTelefono());
			gestionAlumno.setPortatil(gestionAlumnoDTO.getPortatil());
		}
		return gestionAlumno;
	}

	
	
	public GestionPortatil GestionPortatilDTOADAO(GestionPortatilDTO gestionPortatilDTO) {
		String md_uuid = java.util.UUID.randomUUID().toString();
		GestionPortatil gestionPortatil = new GestionPortatil();
		if(gestionPortatilDTO != null) {
			gestionPortatil.setMd_uuid(md_uuid);
			gestionPortatil.setMd_date(gestionPortatilDTO.getMd_date());
			gestionPortatil.setMarca(gestionPortatilDTO.getMarca());;
			gestionPortatil.setModelo(gestionPortatilDTO.getModelo());
		}
		return gestionPortatil;
	}



}