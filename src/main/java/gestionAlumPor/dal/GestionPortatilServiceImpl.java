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
public class GestionPortatilServiceImpl implements GestionPortatilService{
	
	//Creación de la persistencia con Entity Manager
	
	@PersistenceContext
	private EntityManager emPort;
	
	//Método para insertar un portatil
	
	public void insertarPortatil(GestionPortatil gestionPortatil) {
		try {
		emPort.persist(gestionPortatil);
		emPort.clear();
		}catch(Exception e) {
			System.out.println("[insertarOrdenador]: " + e);
		}
	}
	
	//Método para buscar un portatil 

	public List<GestionPortatil> buscarPortatil() {
		try {
		String jpql = "SELECT port FROM GestionPortatil port";
		Query query = emPort.createQuery(jpql);
		return query.getResultList();
		}catch(Exception e) {
			System.out.println("[insertarPortatil]: " + e);
		}
		return null;
	}

	//Método para buscar un portatil por el id de alumno
	
	public GestionPortatil buscarPortatilPorIdAlum(long idAlum) {
		try {
		String jpql = "SELECT alum FROM GestionAlumno alum WHERE alum.id_alumno = :idAlum";
        Query query = emPort.createQuery(jpql);
        query.setParameter("idAlum", idAlum);
		ArrayList<GestionAlumno> listaAlumno = (ArrayList<GestionAlumno>) query.getResultList();
		GestionPortatil portatil = listaAlumno.get(0).getPortatil();
		return portatil;
		}catch(Exception e) {
			System.out.println("[buscarPortatilporIdAlum]");
		}
		return null;
	}

}