package gestionAlumPor.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*
 * Clase para implementar los métodos de la interfaz para hacer las consultas
 */

@Repository
public class GestionAlumnoServiceImpl implements GestionAlumnoService{

	//Creación de la persistencia con Entity Manager
	
	@PersistenceContext
	private EntityManager em;
	
	//Método para insertar la matrícula de un alumno
	
	public void insertarMatricula(GestionAlumno gestionAlumno) {
		try {
		em.persist(gestionAlumno);
		em.clear();
		}catch(Exception e) {
			System.out.println("[insertarMatricula]: " + e);
		}
	}
	
	//Método para buscar todos los alumnos con su portatil asignado

	public List<GestionAlumno> buscarTodos() {
		try {
		return em.createQuery("SELECT alumnos FROM GestionAlumno alumnos").getResultList();
		}catch(Exception e) {
			System.out.println("[buscarTodos]");
		}
		return null;
    }
	
	//Método para eliminar un alumno por su id

	public void eliminarAlumno(long id) {
		try {
		String jpql ="DELETE FROM GestionAlumno ga WHERE ga.id_alumno = :id_al";
        Query query = em.createQuery(jpql);
        query.setParameter("id_al", id);
        int numeroEliminados = query.executeUpdate();
        System.out.println("Numero de eliminados: " + numeroEliminados);
		}catch(Exception e) {
			System.out.println("[eliminarAlumno]: " + e);
		}
	}
	
	//Método que busca un alumno por el id portatil

	public GestionAlumno buscarAlumnoPorIdPortatil(long idPort) {
		try {
		String jpql = "SELECT ord FROM GestionPortatil port WHERE port.id_portatil = :idPort";
		Query query = em.createQuery(jpql);
		query.setParameter("idPort", idPort);
		ArrayList<GestionPortatil> listaPortatil = (ArrayList<GestionPortatil>) query.getResultList();
		GestionAlumno alumnos = listaPortatil.get(0).getAlumno();
		return alumnos;
		}catch(Exception e) {
			System.out.println("[buscarAlumnoPorIdPortatil]");
		}
		return null;
	}
	
	
}