package gestionAlumPor.dal;

import java.util.List;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

public interface GestionPortatilService {

	public void insertarPortatil(GestionPortatil gestionPortatil);

	public List<GestionPortatil> buscarPortatil();
	
	public GestionPortatil buscarPortatilPorIdAlum(long idALum);
}