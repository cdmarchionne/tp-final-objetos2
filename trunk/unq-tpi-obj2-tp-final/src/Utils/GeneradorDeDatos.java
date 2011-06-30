package Utils;

import java.util.Date;

import materias.Catedra;
import materias.Materia;
import personal.Persona;
import universidad.Area;
import universidad.Carrera;
import universidad.OficinaAlumnos;
import universidad.Universidad;

/**
 * TODO: description
 */
public class GeneradorDeDatos {

	private static final int DNI_PRIETO = 32640573;

	public static void datosMinimos() {
		Persona directorOA = new Persona(1345672, "Juan", "Petrolas", "M");
		Universidad unq = new Universidad("UNQ", directorOA);

		Carrera tpi = new Carrera("tpi");
		Area idiomas = new Area("Idiomas");

		OficinaAlumnos oficinaDeAlumnos = unq.getOficinaDeAlumnos();

		Persona directorTPI = new Persona(12345678, "Pablo", "Lopez", "M");
		Persona alumnoPromedioTPI = new Persona(DNI_PRIETO, "Mariano", "Prieto", "M");

		// OficinaAlumnos.nuevoDocente(directorTPI);
		// OficinaAlumnos.nuevoAlumno(alumnoPromedioTPI);
		//
		// Iterator<Alumno> alumnosIterator =
		// oficinaDeAlumnos.getAlumnos().iterator();
		// alumnosIterator.next().setCursoDeIngreso(true);
		//
		// Iterator<Docente> docenteIterator =
		// oficinaDeAlumnos.getDocentes().iterator();
		// Docente docente = docenteIterator.next();

		// PlanDeEstudio planViejo = new PlanDeEstudio("Plan TPI 2007", new
		// Date(2007, 08, 01),docente);

		Materia analisis = new Materia("Analisis Matematico I", 5);
		analisis.setHorasSemanales(6);
		analisis.setPromocionable(true);

		Catedra catedraAnalisis = new Catedra("Gomez");

		analisis.addCatedra(catedraAnalisis);

		Materia ingles = new Materia("Ingles I", 2);
		ingles.setHorasSemanales(3);
		ingles.setPromocionable(true);

		ingles.addCatedra(new Catedra("Silvina"));

		idiomas.getMateriasDictadas().addAntecedente(new Date(), null, ingles);

	}

}
