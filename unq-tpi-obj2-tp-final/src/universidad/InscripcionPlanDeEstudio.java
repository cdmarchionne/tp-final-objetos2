package universidad;

import java.util.ArrayList;
import java.util.List;

import materias.Catedra;
import materias.InscripcionMateria;
import materias.Materia;
import materias.MateriaAsignadaAPlanDeEstudio;
import materias.MateriaCursada;
import model.interfaces.MateriaIMPL;

/**
 * Clase que coopera con los Alumnos para designar a que Plan de Estudio
 * pertenecen
 */
public class InscripcionPlanDeEstudio {

	private PlanDeEstudio planDeEstudio;

	private Integer legajo;

	private final List<InscripcionMateria> materiasInscriptas;

	private final List<MateriaCursada> materiasCursadas;

	private boolean recibido;

	public InscripcionPlanDeEstudio(PlanDeEstudio planDeEstudio, Integer legajo) {
		super();
		this.planDeEstudio = planDeEstudio;
		this.legajo = legajo;
		materiasInscriptas = new ArrayList<InscripcionMateria>();
		materiasCursadas = new ArrayList<MateriaCursada>();
		recibido = false;
	}

	public PlanDeEstudio getPlanDeEstudio() {
		return planDeEstudio;
	}

	public void setPlanDeEstudio(PlanDeEstudio planDeEstudio) {
		this.planDeEstudio = planDeEstudio;
	}

	public boolean isRecibido() {
		return recibido;
	}

	public void setRecibido() {
		recibido = true;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public List<InscripcionMateria> getMateriasInscriptas() {
		return materiasInscriptas;
	}

	public List<MateriaCursada> getMateriasCursadas() {
		return materiasCursadas;
	}

	/**
	 * Devuelve las materias a las cuales se puede inscribir un Alumno de un
	 * Plan de Estudio determinado
	 */
	public List<MateriaIMPL> getMateriasInscribibles() {
		List<MateriaIMPL> materiasInscribibles = new ArrayList<MateriaIMPL>();
		Materia materia = null;

		for (MateriaAsignadaAPlanDeEstudio materiaPlanDeEstudio : planDeEstudio.getMaterias()) {
			materia = materiaPlanDeEstudio.getMateria();
			if (!this.estaAprobada(materia) && !this.estaInscripto(materia)) {
				materiasInscribibles.add(materia);
			}
		}

		return materiasInscribibles;
	}

	/** Comprueba si una materia esta en la lista de Aprobadas */
	private boolean estaAprobada(Materia materia) {

		for (MateriaCursada materiaAprobada : this.getMateriasCursadas()) {
			if (materiaAprobada.getMateria().equals(materia))
				return true;
		}

		return false;
	}

	/** Comprueba si una materia esta en la lista de Inscriptas */
	public boolean estaInscripto(Materia materia) {

		for (InscripcionMateria materiaInscripto : this.getMateriasInscriptas()) {
			if (materiaInscripto.getMateriaElegida().equals(materia))
				return true;
		}

		return false;
	}

	// public void inscribirEnMateria(InscripcionMateria materiaInscripta) {
	public void inscribirEnMateria(Materia materia, Catedra catedra) {
		this.materiasInscriptas.add(new InscripcionMateria(materia, catedra));
	}

	/**
	 * agrega materia aprobada y setea fecha actual en lista de fechas para
	 * calcular regularidad
	 */
	public void agregarMateriaAprobada(Materia materia, float nota) {
		agregarMateriaAprobada(new MateriaCursada(materia, nota));
	}

	public void agregarMateriaAprobada(MateriaCursada materiaAprobada) {
		materiasCursadas.add(materiaAprobada);
	}

}
