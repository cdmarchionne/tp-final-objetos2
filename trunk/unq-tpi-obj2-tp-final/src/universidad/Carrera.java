package src.universidad;

import java.util.Map;
import java.util.Set;

import personal.Docente;
import src.Utils.Nombrable;

public class Carrera implements Nombrable {

	private String nombre;
	private int legajoCarrera;
	private Docente director;

	private Map<PlanDeEstudio, Boolean> planesVigentes;

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public Docente getDirector() {
		return director;
	}

	public void setDirector(final Docente director) {
		this.director = director;
	}

	/** Devuelvo la Lista de Plan de Estudio */
	public Set<PlanDeEstudio> getPlanesVigentes() {
		return planesVigentes.keySet();
	}
	/** devuelvo el numero de legajo de la carrera y lo incremento en 1	 */
		public int giveLegajo(){
		this.legajoCarrera = this.legajoCarrera + 1;
		return legajoCarrera;
	}

	/** Agrego un Plan de Estudio */
	public void addPlanDeEstudio(final PlanDeEstudio planDeEstudio) {
		planesVigentes.put(planDeEstudio, false);
	}

	public void addPlanDeEstudio(final PlanDeEstudio planDeEstudio, final Boolean vigencia) {
		planesVigentes.put(planDeEstudio, vigencia);
	}

	/** Seteo a un Plan de Estudio como Vigente */
	public void setVigenteOn(final PlanDeEstudio planDeEstudio) {
		this.setVigenciaDelPlan(planDeEstudio, true);
	}

	/** Seteo a un Plan de Estudio como No Vigente */
	public void setVigenteOff(final PlanDeEstudio planDeEstudio) {
		this.setVigenciaDelPlan(planDeEstudio, false);
	}

	/** Cambio la vigencia de un Plan de Estudio */
	private void setVigenciaDelPlan(final PlanDeEstudio planDeEstudio, final Boolean vigencia) {
		if (planesVigentes.containsKey(planDeEstudio)
				&& planesVigentes.get(planDeEstudio) != vigencia) {
			this.addPlanDeEstudio(planDeEstudio, vigencia);
		}
	}

}
