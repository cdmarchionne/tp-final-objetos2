package excepciones;

import personal.Alumno;
import universidad.PlanDeEstudio;

public class NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion extends
		UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(Alumno alumno, PlanDeEstudio plan) {
		new Exception("El alumno " + alumno.getNombre()
				+ " no se encuentra inscripto en el Plan de Estudio: " + plan.getNombre());
	}

}
