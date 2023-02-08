package gestionAlumPor.controlador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import gestionAlumPor.dal.GestionAlumno;
import gestionAlumPor.dal.GestionPortatil;
//import dal.GestionAlumnos;
//import dal.GestionOrdenadores;
import gestionAlumPor.dto.ADaoService;
import gestionAlumPor.dto.ADaoServiceImpl;
import gestionAlumPor.dto.ADtoService;
import gestionAlumPor.dto.ADtoServiceImpl;
import gestionAlumPor.dto.GestionAlumnoDTO;
import gestionAlumPor.dto.GestionPortatilDTO;
import gestionAlumPor.impl.Consultas;

@Controller
public class Controlador {
	
		public static void main(String[] args) {
			
		//LLamamos a nuestro contexto.xml
		ApplicationContext context= new ClassPathXmlApplicationContext("contexto.xml");
		//LLamamos a la clase consultas y creamos una instancia 
		Consultas consulta = (Consultas) context.getBean(Consultas.class);
		
		//Creamos el md_uuid de forma que se genere de forma aleatoria dentro de la base de datos
		String md_uuid = java.util.UUID.randomUUID().toString();
		
		//Opcion del menu
		Integer opcion1;
		
		//Creamos una instancia de nuestras clases para Dao y Dto
		ADtoServiceImpl aDto = new ADtoServiceImpl();
		ADaoServiceImpl aDao = new ADaoServiceImpl();
		
		do {
		System.out.println("Escriba el valor a uno de los asignados:");
		System.out.println("");
		System.out.println("1.-Añadir un alumno.");
		System.out.println("2.-Baja de un alumno.");
		System.out.println("3.-Añadir un portatil.");
		System.out.println("4.-Consulta portatil asignado a un alumno.");
		System.out.println("5.-Consulta alumno asignado a un portátil.");
		System.out.println("6.-Ver todos los alumnos con su asignacion de portatil.");
		System.out.println("7.-Salir. ");
		
		System.out.println();
		System.out.print("Introduzca una opcion: ");
		
		//Escaner que lee los valores por consola
		Scanner scan = new Scanner(System.in);
		opcion1 = scan.nextInt();
		
		Calendar fecha = Calendar.getInstance();
		
		//Creamos la variable id 
		long id;
		
		//Creamos una lista para meter el id de portatil
		List<GestionPortatil> lista = new ArrayList<>();
		lista = consulta.buscarPortatil();
		
		//DTO para la gestion del alumno
		GestionAlumnoDTO DTOAlumno;
		GestionAlumno gestionAlumno = new GestionAlumno();
				
		//DTO para la gestion del portatil
		GestionPortatilDTO DTOPortatil;
		GestionPortatil gestionPortatil = new GestionPortatil();
		
		switch (opcion1) {
		case 1:
		System.out.println("Ha escogido la opcion de matricular a un alumno: ");
		//Añadimos los valores al DTO de alumnos
		DTOAlumno = aDto.AGestionAlumnoDTO(fecha, "Salva", "645607650", lista.get(1));
		//Convertimos la consulta a DAO
		gestionAlumno = aDao.GestionAlumnoDTOADAO(DTOAlumno);
		
		//Matricula al alumno
		consulta.insertarUnaMatricula(gestionAlumno);
		break;
		case 2:
		System.out.println("Ha escogido la opcion de dar de baja a un alumno: ");
		System.out.println("Indique el id del alumno que quiere eliminar");
		//Leemos el valor por consola
		id = scan.nextInt();
		
		//Dar de baja a un alumno por id
		consulta.eliminarUnAlumno(id);
		break;
		case 3:
		System.out.println("Has escogido la opcion de alta de un portatil: ");
		//Añadimos los valores al DTO de ordenadores
		DTOPortatil = aDto.AGestionPortatilDTO(fecha, "LG", "EG7");
		//Convertimos la consulta a DAO
		gestionPortatil = aDao.GestionPortatilDTOADAO(DTOPortatil);
		
		//Dar de alta a un portatil
		consulta.insertarUnPortatil(gestionPortatil);
		break;
		case 4:
		System.out.println("Ha escogido la opcion de consultar el portátil asignado a un alumno: ");
		System.out.println("Introduzca el id del alumno para buscar el portatil: ");
		//Leemos el id por la consola
		id = scan.nextInt();
		
		//Se llama a la consulta para buscar el portatil por el id del alumno
		gestionPortatil = consulta.buscarPortatilPorIdAlumno(id);
		System.out.println("El portatil asignado es: " +  "Id: " + gestionPortatil.getId_portatil()
		+ ", Marca: " + gestionPortatil.getMarca() + ", Modelo:  " + gestionPortatil.getModelo());
		break;
		case 5:
		System.out.println("Ha escogido la opcion de consultar el alumno asignado a un portatil: ");
		System.out.println("Introduzca el id del portatil para buscar el alumno: ");
		//Leemos el valor por la consola
		id = scan.nextInt();
		//Se llama a la consulta para buscar el alumno por el id del portatil asignado
		gestionAlumno = consulta.buscarAlumnoPorIdPortatil(id);
		System.out.println("El alumno asignado es: " +  "Id: " + gestionAlumno.getId_alumno()
		+ ", Nombre: " + gestionAlumno.getNombre() + ", Telefono: "+ gestionAlumno.getTelefono());
		break;
		case 6:
		//Se crea una lista donde se mete la consulta que busca a los alumnos
		List<GestionAlumno> listaAlumnos = consulta.buscarTodos();
		
		//Se muestran los atributos de alumnos y ordenadores
        for(GestionAlumno alumnos : listaAlumnos) {
            System.out.println("Alumno: " + "Nombre: " + alumnos.getNombre() +  ", Telefono:" + alumnos.getTelefono() + " // Portatil: " + "Marca: " + alumnos.getPortatil().getMarca() 
            + ", Modelo: " +alumnos.getPortatil().getModelo());
        }
		break;
		case 7:
		//Salir de la aplicación
		System.out.println("Hasta pronto!");
		break;
		default:
				
		}
		
		}while(opcion1 != 7);
	 }
}