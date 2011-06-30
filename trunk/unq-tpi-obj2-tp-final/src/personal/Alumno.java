package personal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import materias.InscripcionMateria;
import materias.Materia;
import materias.MateriaAprobada;
import materias.MateriaAsignadaAPlanDeEstudio;
import model.interfaces.AlumnoIMPL;
import model.interfaces.MateriaIMPL;
import universidad.Carrera;
import universidad.InscripcionCarrera;
import universidad.PlanDeEstudio;
import entregas.EntregaTP;

public class Alumno implements AlumnoIMPL {

	private Persona datosPersonales;
	private List<EntregaTP> entregas;
	private List<InscripcionCarrera> carrerasInscriptas;
	private List<InscripcionMateria> materiasInscriptas;
	private List<MateriaAprobada> materiasAprobadas;
	private Boolean cursoDeIngreso;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(final Persona datosPersonales) {

		super();
		this.datosPersonales = datosPersonales;
		entregas = new ArrayList<EntregaTP>();
		carrerasInscriptas = new ArrayList<InscripcionCarrera>();
		materiasInscriptas = new ArrayList<InscripcionMateria>();
		materiasAprobadas = new ArrayList<MateriaAprobada>();
		cursoDeIngreso = false;
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public List<EntregaTP> getEntregas() {
		return entregas;
	}

	public void setEntregas(final List<EntregaTP> entregas) {
		this.entregas = entregas;
	}

	public List<InscripcionCarrera> getCarrerasInscriptas() {
		return carrerasInscriptas;
	}

	public void addCarrerasInscriptas(final InscripcionCarrera carreraInscripta) {
		carrerasInscriptas.add(carreraInscripta);
	}

	public List<InscripcionMateria> getMateriasInscriptas() {
		return materiasInscriptas;
	}

	public void setMateriasInscriptas(final List<InscripcionMateria> materiasInscriptas) {
		this.materiasInscriptas = materiasInscriptas;
	}

	public List<MateriaAprobada> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(final List<MateriaAprobada> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	/**
	 * Obtengo la inscripcion de una carrera para poder trabajar mas comodo con
	 * los datos del Adapter
	 */
	private InscripcionCarrera getCarreraInscripta(PlanDeEstudio planDeEstudio) {
		InscripcionCarrera carreraBuscada = null;

		for (InscripcionCarrera carreraInscripta : carrerasInscriptas) {
			if (carreraInscripta.getPlanDeEstudio().equals(planDeEstudio)) {
				carreraBuscada = carreraInscripta;
				break;
			}
		}

		return carreraBuscada;
	}

	private InscripcionCarrera getCarreraInscripta(Carrera carrera) {
		InscripcionCarrera carreraBuscada = null;

		for (PlanDeEstudio plan : carrera.getPlanesVigentes()) {
			if (this.getCarreraInscripta(plan) != null) {
				carreraBuscada = this.getCarreraInscripta(plan);
				break;
			}
		}

		return carreraBuscada;
	}

	/** Averiguo el legajo de un Alumno */
	public Integer getLegajo(final PlanDeEstudio planDeEstudio) {
		return this.getCarreraInscripta(planDeEstudio).getLegajo();
	}

	public Integer getLegajo(final Carrera carrera) {
		return this.getCarreraInscripta(carrera).getLegajo();
	}

	/** Agrego el legajo de un Alumno */
	public void addLegajo(final PlanDeEstudio planDeEstudio, final Integer legajo) {
		this.getCarreraInscripta(planDeEstudio).setLegajo(legajo);
	}

	public void addLegajo(final Carrera carrera, final Integer legajo) {
		this.getCarreraInscripta(carrera).setLegajo(legajo);
	}

	public void calcularRegularidad() {

	}

	public String getNombre() {
		return this.getDatosPersonales().getNombre();
	}

	public String getApellido() {
		return this.getDatosPersonales().getApellido();
	}

	public void setCursoDeIngreso(final Boolean boolie) {
		cursoDeIngreso = boolie;
	}

	public Boolean cursoDeIngresoAprobado() {
		return cursoDeIngreso;
	}

	public void inscribirEnMateria(final InscripcionMateria materia) {
		// El alumno no se inscribe en la catedra eso lo sabe la materia.

		materiasInscriptas.add(materia);

	}

	public void agregarMateriaAprobada(final Materia materia, float nota) {
		materiasAprobadas.add(new MateriaAprobada(materia, nota));
	}

	/** Calcula el promedio de las materias aprobadas */
	public float calcularPromedio() {
		float notas = 0;

		for (MateriaAprobada materiaAprobada : materiasAprobadas) {
			notas = notas + materiaAprobada.getNota();
		}

		return notas / materiasAprobadas.size();
	}

	/** Obtengo todos los planes de estudio del alumno */
	public Set<PlanDeEstudio> getPlanDeEstudio() {
		Set<PlanDeEstudio> planDeEstudio = new HashSet<PlanDeEstudio>();
		for (InscripcionCarrera carreraInscripta : carrerasInscriptas) {
			planDeEstudio.add(carreraInscripta.getPlanDeEstudio());
		}

		return planDeEstudio;
	}

	/**
	 * Devuelve todas las materias de los planes de estudio a las cuales se
	 * puede inscribir un Alumno
	 */
	public List<MateriaIMPL> getMateriasInscribibles() {
		List<MateriaIMPL> materiasInscribibles = new ArrayList<MateriaIMPL>();

		for (PlanDeEstudio planDeEstudio : this.getPlanDeEstudio()) {
			materiasInscribibles.addAll(this.getMateriasInscribibles(planDeEstudio));
		}

		return materiasInscribibles;
	}

	/**
	 * Devuelve las materias a las cuales se puede inscribir un Alumno de un
	 * Plan de Estudio determinado
	 */
	public List<MateriaIMPL> getMateriasInscribibles(PlanDeEstudio planDeEstudio) {
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

		for (MateriaAprobada materiaAprobada : this.getMateriasAprobadas()) {
			if (materiaAprobada.getMateria().equals(materia))
				return true;
		}

		return false;
	}

	/** Comprueba si una materia esta en la lista de Inscriptas */
	private boolean estaInscripto(Materia materia) {

		for (InscripcionMateria materiaInscripto : this.getMateriasInscriptas()) {
			if (materiaInscripto.getMateriaElegida().equals(materia))
				return true;
		}

		return false;
	}
}
