package excepciones;

import materias.Materia;
import universidad.PlanDeEstudio;

/**
 * Excepsion que se utiliza cuando no se encuentra una Materia inscripta en un
 * Plan de Estudio determinada
 */
public class NoSeEncuentraMateriaEnPlanException extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoSeEncuentraMateriaEnPlanException(Materia materia, PlanDeEstudio plan) {
		new Exception("La materia " + materia.getNombre()
				+ " no esta Inscripta en el Plan de Estudio: " + plan.getNombre());
	}

}
