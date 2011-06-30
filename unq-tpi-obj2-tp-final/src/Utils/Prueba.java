package Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import personal.Alumno;
import personal.Docente;
import personal.Persona;

import universidad.Area;
import universidad.Carrera;
import universidad.OficinaDeAlumnos;
import universidad.PlanDeEstudio;
import universidad.Universidad;

/**
 * TODO: description
 */
public class Prueba {

	private static final int DNI_PRIETO = 32640573;

	public static void main(String[] args) {
		Universidad universidad = new Universidad("UNQ");
			
		Carrera tpi = new Carrera("tpi");
		Area idiomas = new Area("Idiomas");
		Persona directorOA = new Persona(1345672, "Juan", "Petrolas", "M");
		
		OficinaDeAlumnos oficinaDeAlumnos = new OficinaDeAlumnos(directorOA);
		
		Persona directorTPI = new Persona(12345678, "Pablo", "Lopez", "M");
		Persona alumnoPromedioTPI = new Persona(DNI_PRIETO, "Mariano", "Prieto", "M");
		
		oficinaDeAlumnos.nuevoDocente(directorTPI);
		oficinaDeAlumnos.nuevoAlumno(alumnoPromedioTPI);
		
		Iterator<Alumno> alumnosIterator = oficinaDeAlumnos.getAlumnos().iterator();
		alumnosIterator.next().setCursoDeIngreso(true);
		
		PlanDeEstudio planViejo = new PlanDeEstudio();
		
		
		
	}

}
