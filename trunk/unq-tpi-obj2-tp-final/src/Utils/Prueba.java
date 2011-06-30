package Utils;

import java.util.Set;

import personal.Docente;
import personal.Persona;

import universidad.Area;
import universidad.Carrera;
import universidad.OficinaDeAlumnos;
import universidad.Universidad;

/**
 * TODO: description
 */
public class Prueba {

	public static void main(String[] args) {
		Universidad universidad = new Universidad("UNQ");
		
/*		private Set<Carrera> carreras;

		private Set<Area> areas;
		
		private OficinaDeAlumnos oficinaDeAlumnos;

		*/
		
		Carrera tpi = new Carrera("tpi");
		Area idiomas = new Area("Idiomas");
		OficinaDeAlumnos oficinaDeAlumnos = new OficinaDeAlumnos();
		
		Persona directorTPI = new Persona(12345678, "Pablo", "Lopez", "M");
		Persona alumnoPromedioTPI = new Persona(32640573, "Mariano", "Prieto", "M");
		
		oficinaDeAlumnos.nuevoDocente(directorTPI);
		oficinaDeAlumnos.nuevoAlumno(alumnoPromedioTPI);
		
	}

}
