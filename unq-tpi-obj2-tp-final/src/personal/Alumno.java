package personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import materias.Catedra;
import materias.Materia;
import materias.MateriaCursada;
import model.interfaces.AlumnoIMPL;
import model.interfaces.MateriaIMPL;
import universidad.Carrera;
import universidad.InscripcionPlanDeEstudio;
import universidad.PlanDeEstudio;
import Utils.Nombrable;
import entregas.EntregaTP;

public class Alumno implements Nombrable, AlumnoIMPL {

	private Persona datosPersonales;
	private List<EntregaTP> entregas;
	private List<InscripcionPlanDeEstudio> planesInscriptos;
	private Boolean cursoDeIngreso;
	private List<Date> arrayFechasAprobadas;
	private int cantAusentes;
	private Boolean regularidad;
	private final List<Integer> añosLicencia;
	private int cantLicencias;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(Persona datosPersonales) {
		super();
		this.datosPersonales = datosPersonales;
		entregas = new ArrayList<EntregaTP>();
		planesInscriptos = new ArrayList<InscripcionPlanDeEstudio>();
		cursoDeIngreso = false;
		cantAusentes = 0;
		regularidad = true;
		arrayFechasAprobadas = new ArrayList<Date>();
		añosLicencia = new ArrayList<Integer>();
		cantLicencias = 0;
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public void setCantLicencias(int cantLicencias) {
		this.cantLicencias = cantLicencias;
	}

	public void sumCantLicencias() {
		this.cantLicencias = this.cantLicencias + 1;
	}

	public int getCantLicencias() {
		return cantLicencias;
	}

	public void addAñosLicencia(Integer año) {
		this.añosLicencia.add(año);
	}

	public List<Integer> getAñosLicencia() {
		return añosLicencia;
	}

	public void setCarrerasInscriptas(List<InscripcionPlanDeEstudio> carrerasInscriptas) {
		this.planesInscriptos = carrerasInscriptas;
	}

	// public void setMateriasInscriptas(List<InscripcionMateria>
	// materiasInscriptas) {
	// this.materiasInscriptas = materiasInscriptas;
	// }

	public void inscribirEnMateria(PlanDeEstudio plan, Materia materia, Catedra catedra) {
		getPlanInscripto(plan).inscribirEnMateria(materia, catedra);
		catedra.agregarAlumnoInscripto(this);
	}

	public void setArrayFechasAprobadas(List<Date> arrayFechasAprobadas) {
		this.arrayFechasAprobadas = arrayFechasAprobadas;
	}

	public List<EntregaTP> getEntregas() {
		return entregas;
	}

	public void addEntregas(EntregaTP entrega) {
		this.entregas.add(entrega);
	}

	public void setEntregas(List<EntregaTP> entregas) {
		this.entregas = entregas;
	}

	public List<InscripcionPlanDeEstudio> getCarrerasInscriptas() {
		return planesInscriptos;
	}

	public void addCarreraIncripta(InscripcionPlanDeEstudio carreraInscripta) {
		planesInscriptos.add(carreraInscripta);
	}

	public void removeCarreras(InscripcionPlanDeEstudio carreraInscripta) {
		planesInscriptos.remove(carreraInscripta);
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public int getCantAusentes() {
		return this.cantAusentes;
	}

	public void setCantAusentes(int cant) {
		this.cantAusentes = cant;
	}

	public void setRegularidad(Boolean bool) {
		this.regularidad = bool;
	}

	public Boolean getRegularidad() {
		return this.regularidad;
	}

	/**
	 * Obtengo la inscripcion de una carrera para poder trabajar mas comodo con
	 * los datos del Adapter
	 */
	private InscripcionPlanDeEstudio getPlanInscripto(PlanDeEstudio planDeEstudio) {
		InscripcionPlanDeEstudio carreraBuscada = null;

		for (InscripcionPlanDeEstudio carreraInscripta : planesInscriptos) {
			if (carreraInscripta.getPlanDeEstudio().equals(planDeEstudio)) {
				carreraBuscada = carreraInscripta;
				break;
			}
		}

		return carreraBuscada;
	}

	private InscripcionPlanDeEstudio getCarreraInscripta(Carrera carrera) {
		InscripcionPlanDeEstudio carreraBuscada = null;

		for (PlanDeEstudio plan : carrera.getPlanesVigentes()) {
			if (this.getPlanInscripto(plan) != null) {
				carreraBuscada = this.getPlanInscripto(plan);
				break;
			}
		}

		return carreraBuscada;
	}

	/** Averiguo el legajo de un Alumno */
	public Integer getLegajo(PlanDeEstudio planDeEstudio) {
		return this.getPlanInscripto(planDeEstudio).getLegajo();
	}

	public Integer getLegajo(Carrera carrera) {
		return this.getCarreraInscripta(carrera).getLegajo();
	}

	/** Modofico el legajo de un Alumno */
	public void setLegajo(PlanDeEstudio planDeEstudio, Integer legajo) {
		boolean existe = false;
		for (InscripcionPlanDeEstudio carreraInscripta : planesInscriptos) {
			if (carreraInscripta.getPlanDeEstudio().equals(planDeEstudio)) {
				carreraInscripta.setLegajo(legajo);
				existe = true;
			}
		}

		if (!existe) {
			this.addCarreraIncripta(new InscripcionPlanDeEstudio(planDeEstudio, legajo));
		}
	}

	/**
	 * Calcula la regularidad de un alumno en base a sus ausentes y materias
	 * aprobadas
	 */
	@SuppressWarnings("deprecation")
	public void calcularRegularidad() {
		Date date = new Date();
		int var = 0;
		for (Date fecha : this.getArrayFechasAprobadas()) {
			if (fecha.getYear() == date.getYear()) {
				var = var + 1;
			}
		}

		this.setRegularidad(!((this.getCantAusentes() > 6) && (var < 2)));

		if (getRegularidad()) {
			System.out.println("El Alumno esta libre.");
		} else {
			System.out.println("El Alumno es regular.");
		}

	}

	@Override
	public String getNombre() {
		return this.getDatosPersonales().getNombre();
	}

	@Override
	public String toString() {
		return getNombre();
	}

	public String getApellido() {
		return this.getDatosPersonales().getApellido();
	}

	public void setCursoDeIngreso(Boolean boolie) {
		cursoDeIngreso = boolie;
	}

	public Boolean getCursoDeIngreso() {
		return cursoDeIngreso;
	}

	/** es un getter de las fechas de las materias aprobadas */
	public List<Date> getArrayFechasAprobadas() {
		return this.arrayFechasAprobadas;
	}

	/**
	 * agrega materia aprobada y setea fecha actual en lista de fechas para
	 * calcular regularidad
	 */
	public void agregarMateriaAprobada(PlanDeEstudio plan, Materia materia, float nota) {
		getPlanInscripto(plan).agregarMateriaAprobada(materia, nota);
		this.getArrayFechasAprobadas().add(new Date());
	}

	/** Calcula el promedio de las materias aprobadas */
	public float calcularPromedio() {
		float promedio = 0;

		if (getPlanesDeEstudio().size() > 0) {

			for (PlanDeEstudio planDeEstudio : getPlanesDeEstudio()) {
				promedio = promedio + calcularPromedio(planDeEstudio);
			}

			promedio = promedio + getPlanesDeEstudio().size();
		}

		return promedio;
	}

	public float calcularPromedio(PlanDeEstudio planDeEstudio) {
		float notas = 0;

		List<MateriaCursada> materiasAprobadas = getPlanInscripto(planDeEstudio)
				.getMateriasCursadas();

		if (materiasAprobadas.size() > 0) {
			for (MateriaCursada materiaAprobada : materiasAprobadas) {
				notas = notas + materiaAprobada.getNota();
			}

			notas = notas / materiasAprobadas.size();
		}

		return notas;

	}

	/** Obtengo todos los planes de estudio del alumno */
	public Set<PlanDeEstudio> getPlanesDeEstudio() {
		Set<PlanDeEstudio> planDeEstudio = new HashSet<PlanDeEstudio>();
		for (InscripcionPlanDeEstudio carreraInscripta : planesInscriptos) {
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

		for (PlanDeEstudio planDeEstudio : this.getPlanesDeEstudio()) {
			materiasInscribibles.addAll(this.getMateriasInscribibles(planDeEstudio));
		}

		return materiasInscribibles;
	}

	/**
	 * Devuelve las materias a las cuales se puede inscribir un Alumno de un
	 * Plan de Estudio determinado
	 */
	public List<MateriaIMPL> getMateriasInscribibles(PlanDeEstudio planDeEstudio) {
		return getPlanInscripto(planDeEstudio).getMateriasInscribibles();
	}

	/**
	 * Devuelve los creditos de las materias aprobadas
	 */
	public float getCreditos(PlanDeEstudio plan) {
		// DEL PLAN De ESTUDIO
		return 0;
	}

	public List<MateriaCursada> getMateriasCursadas(PlanDeEstudio planDeEstudio) {
		return getPlanInscripto(planDeEstudio).getMateriasCursadas();
	}

}
