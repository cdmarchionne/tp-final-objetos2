package excepciones;

import universidad.PlanDeEstudio;

/**
 * Excepsion que se utiliza cuando no se encuentra un Plan de Estudio Buscado
 */
public class NoSeEncuentraPlanDeEstudioException extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoSeEncuentraPlanDeEstudioException(PlanDeEstudio plan) {
		new Exception("No se pudo encontrar el Plan de Estudio Buscado: " + plan.getNombre());
	}

}
