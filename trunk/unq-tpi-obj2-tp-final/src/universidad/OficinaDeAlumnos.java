package universidad;

import java.util.Set;

import personal.Alumno;

/**
 * TODO: description
 */
public class OficinaDeAlumnos {

	private Set<Alumno> alumnos;

	public void inscribirEnCarrera(final Alumno alumno, final Carrera carrera) {
		if (alumno.cursoDeIngresoAprobado()) {
			alumno.addCarrerasInscriptas(carrera);
			alumno.addLegajo(carrera, carrera.obtenerLegajo());
		}
	}
}
