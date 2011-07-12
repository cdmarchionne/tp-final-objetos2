package excepciones;

import personal.Alumno;
import universidad.Carrera;

public class NoHayInscripcionDelAlumnoEnCarreraExcepcion extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoHayInscripcionDelAlumnoEnCarreraExcepcion(Alumno alumno, Carrera carrera) {
		new Exception("El alumno " + alumno.getNombre()
				+ " no se encuentra inscripto en ningun Plan de Estudio de la Carrera: "
				+ carrera.getNombre());
	}

}
