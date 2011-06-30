package Utils;

import personal.Persona;
import universidad.Area;
import universidad.Carrera;
import universidad.Universidad;

/**
 * TODO: description
 */
public class Prueba {

	private static final int DNI_PRIETO = 32640573;

	public static void main(String[] args) {
		Persona directorOA = new Persona(1345672, "Juan", "Petrolas", "M");
		Universidad unq = new Universidad("UNQ", directorOA);

		Carrera tpi = new Carrera("tpi");
		Area idiomas = new Area("Idiomas");

		// OficinaDeAlumnos oficinaDeAlumnos = unq.getOficinaDeAlumnos();
		//
		// Persona directorTPI = new Persona(12345678, "Pablo", "Lopez", "M");
		// Persona alumnoPromedioTPI = new Persona(DNI_PRIETO, "Mariano",
		// "Prieto", "M");
		//
		// oficinaDeAlumnos.nuevoDocente(directorTPI);
		// oficinaDeAlumnos.nuevoAlumno(alumnoPromedioTPI);
		//
		// Iterator<Alumno> alumnosIterator =
		// oficinaDeAlumnos.getAlumnos().iterator();
		// alumnosIterator.next().setCursoDeIngreso(true);
		//
		// Iterator<Docente> docenteIterator =
		// oficinaDeAlumnos.getDocentes().iterator();
		// Docente docente = docenteIterator.next();
		//
		// // PlanDeEstudio planViejo = new PlanDeEstudio("Plan TPI 2007", new
		// // Date(2007, 08, 01),docente);
		//
		// Materia analisis = new Materia("Analisis Matematico I", 5);
		// analisis.setHorasSemanales(6);
		// analisis.setPromocionable(true);
		//
		// Catedra catedraAnalisis = new Catedra("Gomez");
		//
		// analisis.addCatedra(catedraAnalisis);

	}

}
