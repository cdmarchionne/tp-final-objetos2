package excepciones;

import universidad.Carrera;

/**
 * Excepsion que se utiliza cuando no se encuentra la Inscripcion a un Plan de
 * Estudio de una Carrera determinada
 */
public class NoSeEncuentraInscripcionDeCarreraExcepcion extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoSeEncuentraInscripcionDeCarreraExcepcion(Carrera carrera) {
		new Exception(
				"No se pudo encontrar ninguna Inscripcion a un Plan de Estudio de la carrera: "
						+ carrera.getNombre());
	}

}
