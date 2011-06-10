package materias;

import java.util.List;

import Utils.Historial;
import entregas.Evaluacion;
import entregas.TrabajoPractico;

/**
 * Catedra
 */
// Almeceno el Historial del Staff Completo
public class Catedra {

	/** Guardar el historial de Docentes */
	private Historial<StaffCatedra> staff;
	// private StaffCatedra staff;

	private List<TrabajoPractico> tp;
	private List<Evaluacion> examenes;

}
