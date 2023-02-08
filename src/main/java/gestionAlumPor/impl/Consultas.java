package gestionAlumPor.impl;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionAlumnoServiceImpl;
import gestionAlumPor.dal.GestionPortatil;
import gestionAlumPor.dal.GestionPortatilServiceImpl;

/*
 * Clase que contiene las transacciones a nuestra base de datos
 */

@Service
public class Consultas{

	@Autowired
	private GestionAlumnoServiceImpl gai;
	@Autowired
	private GestionPortatilServiceImpl gpi;
	
	//Consultas de gestión de alumnos
	
	//Consulta para insertar una matrícula
	
	@Transactional
	public void insertarUnaMatricula(GestionAlumno gestionAlumno) {
		gai.insertarMatricula(gestionAlumno);
	}
	
	//Consulta para buscar todos los alumnos 
	
	public List<GestionAlumno> buscarTodos(){
        return gai.buscarTodos();
    }
	
	//Consulta para eliminar a un alumno
	
	@Transactional
	public void eliminarUnAlumno(long id) {
		gai.eliminarAlumno(id);
	}
	
	//COnsulta para buscar un alumno por id de portatil
	
	@Transactional
	public GestionAlumno buscarAlumnoPorIdPortatil(long idPort) {
		return gai.buscarAlumnoPorIdPortatil(idPort);
	}
	
	
	
	//Consultas de gestión de portatil

	//Consulta para insertar un portatil
	
	@Transactional
	public void insertarUnPortatil(GestionPortatil gestionPortatil) {
		gpi.insertarPortatil(gestionPortatil);
	}

	//Consulta para buscar un portatil por id de alumno
	
	public GestionPortatil buscarPortatilPorIdAlumno(long idAlum) {
		return gpi.buscarPortatilPorIdAlum(idAlum);
	}
	
	//Consulta para buscar un portatil
	public List<GestionPortatil> buscarPortatil() {
		return gpi.buscarPortatil();
	}
	
}