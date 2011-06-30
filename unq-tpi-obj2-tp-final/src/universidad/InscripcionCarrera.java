package universidad;

/**
 * TODO: description
 */
public class InscripcionCarrera {

	private PlanDeEstudio planDeEstudio;

	private Integer legajo;

	public InscripcionCarrera(PlanDeEstudio planDeEstudio, Integer legajo) {
		super();
		this.planDeEstudio = planDeEstudio;
		this.legajo = legajo;
	}

	public PlanDeEstudio getPlanDeEstudio() {
		return planDeEstudio;
	}

	public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		this.planDeEstudio = planDeEstudio;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

}
