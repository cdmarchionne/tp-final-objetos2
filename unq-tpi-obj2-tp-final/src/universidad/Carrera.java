package universidad;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import personal.Docente;
import Utils.Nombrable;

public class Carrera implements Nombrable {

	private String nombre;
	private Integer legajoCarrera;
	private Docente director;

	private Map<PlanDeEstudio, Boolean> planesVigentes;

	public Carrera(String nombre, Docente director) {
		super();
		this.nombre = nombre;
		legajoCarrera = 0;
		this.director = director;
		planesVigentes = new HashMap<PlanDeEstudio, Boolean>();
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	// public void setNombre( String nombre) {
	// this.nombre = nombre;
	// }

	public Docente getDirector() {
		return director;
	}

	public void setDirector(Docente director) {
		this.director = director;
	}

	/** Devuelvo la Lista de Plan de Estudio */
	public Set<PlanDeEstudio> getPlanesDeEstudio() {
		return planesVigentes.keySet();
	}

	/** Devuelvo la Lista de Plan de Estudio Vigentes */
	public Set<PlanDeEstudio> getPlanesVigentes() {
		Set<PlanDeEstudio> planes = new HashSet<PlanDeEstudio>();

		for (PlanDeEstudio planDeEstudio : planesVigentes.keySet()) {
			if (planesVigentes.get(planDeEstudio)) {
				planes.add(planDeEstudio);
			}
		}

		return planes;
	}

	/** devuelvo el numero de legajo de la carrera y lo incremento en 1 */
	public Integer obtenerLegajo() {
		legajoCarrera = legajoCarrera + 1;
		return legajoCarrera;
	}

	/** Agrego un Plan de Estudio */
	public void addPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		planesVigentes.put(planDeEstudio, false);
	}

	public void addPlanDeEstudio(PlanDeEstudio planDeEstudio, Boolean vigencia) {
		planesVigentes.put(planDeEstudio, vigencia);
	}

	/** Seteo a un Plan de Estudio como Vigente */
	public void setVigenteOn(PlanDeEstudio planDeEstudio) {
		this.setVigenciaDelPlan(planDeEstudio, true);
	}

	/** Seteo a un Plan de Estudio como No Vigente */
	public void setVigenteOff(PlanDeEstudio planDeEstudio) {
		this.setVigenciaDelPlan(planDeEstudio, false);
	}

	/** Cambio la vigencia de un Plan de Estudio */
	private void setVigenciaDelPlan(PlanDeEstudio planDeEstudio, Boolean vigencia) {
		if (planesVigentes.containsKey(planDeEstudio)
				&& planesVigentes.get(planDeEstudio) != vigencia) {
			this.addPlanDeEstudio(planDeEstudio, vigencia);
		}
	}

	/** Verifica si un plan de estudio esta vigente */
	public boolean contains(PlanDeEstudio planDeEstudio) {
		return planesVigentes.get(planDeEstudio);
	}

}
