package gestionAlumPor.dal;

import java.util.List;

/*
 * Interfaz que contiene los métodos que hay que implementar 
 */

public interface GestionAlumnoService{
	
	public void insertarMatricula(GestionAlumno gestionAlumno);

	public List<GestionAlumno> buscarTodos();
	
	public void eliminarAlumno(long id);
	
	public GestionAlumno buscarAlumnoPorIdPortatil(long idPort);
}