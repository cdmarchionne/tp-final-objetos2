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
import tutoria.Tutoria;
import universidad.Carrera;
import universidad.InscripcionPlanDeEstudio;
import universidad.PlanDeEstudio;
import Utils.GeneradorDeDatos;
import Utils.Nombrable;
import entregas.EntregaTP;
import excepciones.FaltanEquivalenciasExcepcion;
import excepciones.NoHayInscripcionDelAlumnoEnCarreraExcepcion;
import excepciones.NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion;
import excepciones.NoSeEncuentraInscripcionDeCarreraExcepcion;
import excepciones.NoSeEncuentraPlanDeEstudioException;

public class Alumno implements Nombrable, AlumnoIMPL {

	private Persona datosPersonales;
	private List<EntregaTP> entregas;
	private List<InscripcionPlanDeEstudio> planesInscriptos;
	private Boolean cursoDeIngreso;
	private List<Date> arrayFechasAprobadas;
	private int cantAusentes;
	private Boolean regularidad;
	private final List<Integer> aniosLicencia;
	private int cantLicencias;
	private Tutoria tutoria;
	private Boolean tutoriaHabilitada;

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
		aniosLicencia = new ArrayList<Integer>();
		cantLicencias = 0;
		tutoria = null;
		tutoriaHabilitada = false;
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public void setTutoria(Tutoria tutoria) {
		this.tutoria = tutoria;
	}

	public Tutoria getTutoria() {
		return tutoria;
	}

	public void setCantLicencias(int cantLicencias) {
		this.cantLicencias = cantLicencias;
	}

	public void sumCantLicencias() {
		cantLicencias = cantLicencias + 1;
	}

	public int getCantLicencias() {
		return cantLicencias;
	}

	public void addAniosLicencia(Integer anio) {
		aniosLicencia.add(anio);
	}

	public List<Integer> getAniosLicencia() {
		return aniosLicencia;
	}

	public void inscribirEnMateria(PlanDeEstudio plan, Materia materia, Catedra catedra) {
		try {
			this.getPlanInscripto(plan).inscribirEnMateria(this, materia, catedra);
		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		} catch (FaltanEquivalenciasExcepcion e) {
			e.printStackTrace();
			// System.err.println(e.getMessage());
		}
	}

	public void setArrayFechasAprobadas(List<Date> arrayFechasAprobadas) {
		this.arrayFechasAprobadas = arrayFechasAprobadas;
	}

	public List<EntregaTP> getEntregas() {
		return entregas;
	}

	public void addEntregas(EntregaTP entrega) {
		entregas.add(entrega);
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
		return cantAusentes;
	}

	public void setCantAusentes(int cant) {
		cantAusentes = cant;
	}

	public void setRegularidad(Boolean bool) {
		regularidad = bool;
	}

	public Boolean getRegularidad() {
		return regularidad;
	}

	/**
	 * Obtengo la inscripcion de una plan para poder trabajar mas comodo con
	 * los datos
	 */
	public InscripcionPlanDeEstudio getPlanInscripto(PlanDeEstudio planDeEstudio)
			throws NoSeEncuentraPlanDeEstudioException
	{
		InscripcionPlanDeEstudio planBuscado = null;

		for (InscripcionPlanDeEstudio planInscripto : planesInscriptos) {
			if (planInscripto.getPlanDeEstudio().equals(planDeEstudio)) {
				planBuscado = planInscripto;
				break;
			}
		}

		if (planBuscado != null)
			return planBuscado;
		else
			throw new NoSeEncuentraPlanDeEstudioException(planDeEstudio);
	}

	private InscripcionPlanDeEstudio getInscripcionDeCarrera(Carrera carrera) {
		InscripcionPlanDeEstudio inscripcionBuscada = null;

		for (PlanDeEstudio plan : carrera.getPlanesVigentes()) {
			try {
				if (this.getPlanInscripto(plan) != null) {
					inscripcionBuscada = this.getPlanInscripto(plan);
					return inscripcionBuscada;
				}
			} catch (NoSeEncuentraPlanDeEstudioException e) {
			}
		}

		throw new NoSeEncuentraInscripcionDeCarreraExcepcion(carrera);
	}

	/**
	 * Averiguo el legajo de un Alumno
	 */
	public Integer getLegajo(PlanDeEstudio plan) {
		try {
			return this.getPlanInscripto(plan).getLegajo();
		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		}
	}

	public Integer getLegajo(Carrera carrera) {
		try {
			return this.getInscripcionDeCarrera(carrera).getLegajo();
		} catch (NoSeEncuentraInscripcionDeCarreraExcepcion e) {
			throw new NoHayInscripcionDelAlumnoEnCarreraExcepcion(this, carrera);
		}
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

		this.setRegularidad(!(this.getCantAusentes() > 6 && var < 2));

		if (this.getRegularidad()) {
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
		return this.getNombre();
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
		return arrayFechasAprobadas;
	}

	/**
	 * agrega materia aprobada y setea fecha actual en lista de fechas para
	 * calcular regularidad
	 * 
	 * @throws NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion
	 */
	public void agregarMateriaAprobada(PlanDeEstudio plan, Materia materia, float nota)
			throws NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion
	{
		try {
			this.getPlanInscripto(plan).agregarMateriaAprobada(materia, nota);
			this.getArrayFechasAprobadas().add(new Date());
		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		}
	}

	/** Calcula el promedio de las materias aprobadas */
	public float calcularPromedio() {
		float promedio = 0;

		if (this.getPlanesDeEstudio().size() > 0) {

			for (PlanDeEstudio planDeEstudio : this.getPlanesDeEstudio()) {
				try {
					promedio = promedio + this.calcularPromedio(planDeEstudio);
				} catch (NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion e) {
				}
			}

			promedio = promedio + this.getPlanesDeEstudio().size();
		}

		return promedio;
	}

	public float calcularPromedio(PlanDeEstudio plan) {
		float notas = 0;

		try {
			List<MateriaCursada> materiasAprobadas = this.getPlanInscripto(plan)
					.getMateriasCursadas();

			if (materiasAprobadas.size() > 0) {
				for (MateriaCursada materiaAprobada : materiasAprobadas) {
					notas = notas + materiaAprobada.getNota();
				}

				notas = notas / materiasAprobadas.size();
			}

			return notas;

		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		}
	}

	/** Obtengo todos los planes de estudio del alumno */
	@Override
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
			try {
				materiasInscribibles.addAll(this.getMateriasInscribibles(planDeEstudio));
			} catch (NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion e) {
			}
		}

		return materiasInscribibles;
	}

	/**
	 * Devuelve las materias a las cuales se puede inscribir un Alumno de un
	 * Plan de Estudio determinado
	 */
	public List<MateriaIMPL> getMateriasInscribibles(PlanDeEstudio plan) {
		try {
			return this.getPlanInscripto(plan).getMateriasInscribibles();
		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		}
	}

	/**
	 * Devuelve los creditos de las materias aprobadas de un plan de estudio
	 */
	public float getCreditos(PlanDeEstudio plan) {
		float creditos = 0;

		try {
			for (MateriaCursada materiaCursada : this.getMateriasAprobadas(plan)) {
				creditos = creditos + materiaCursada.getMateria().getCreditos();
			}
		} catch (NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion e) {
		}

		return creditos;
	}

	/**
	 * Devuelve las materias cursadas de un plan de estudio determinado
	 */
	public List<MateriaCursada> getMateriasCursadas(PlanDeEstudio plan) {
		try {
			return this.getPlanInscripto(plan).getMateriasCursadas();
		} catch (NoSeEncuentraPlanDeEstudioException e) {
			throw new NoHayInscripcionDelAlumnoEnPlanDeEstudioExcepcion(this, plan);
		}
	}

	/**
	 * Devuelvo las materias Desaprobadas de un plan de estudio determinado
	 */
	public List<MateriaCursada> getMateriasDesaprobadas(PlanDeEstudio plan) {
		List<MateriaCursada> materiasDesaprobadas = new ArrayList<MateriaCursada>();

		for (MateriaCursada materiaCursada : this.getMateriasCursadas(plan)) {
			if (materiaCursada.getNota() < GeneradorDeDatos.NOTA_MATERIA_APROBADA) {
				materiasDesaprobadas.add(materiaCursada);
			}
		}

		return materiasDesaprobadas;
	}

	/**
	 * Devuelvo las materias aprobadas de un plan de estudio determinado
	 */
	public List<MateriaCursada> getMateriasAprobadas(PlanDeEstudio plan) {
		List<MateriaCursada> materiasAprobadas = new ArrayList<MateriaCursada>();

		for (MateriaCursada materiaCursada : this.getMateriasCursadas(plan)) {
			if (materiaCursada.getNota() >= GeneradorDeDatos.NOTA_MATERIA_APROBADA) {
				materiasAprobadas.add(materiaCursada);
			}
		}

		return materiasAprobadas;
	}

	/**
	 * Devuelvo las materias aprobadas de un plan de estudio determinado
	 */
	public List<MateriaCursada> getMateriasPromocionadas(PlanDeEstudio plan) {
		List<MateriaCursada> materiasPromocionadas = new ArrayList<MateriaCursada>();

		for (MateriaCursada materiaCursada : this.getMateriasCursadas(plan)) {
			if (materiaCursada.getNota() >= GeneradorDeDatos.NOTA_MATERIA_PROMOCIONADA) {
				materiasPromocionadas.add(materiaCursada);
			}
		}

		return materiasPromocionadas;
	}

	public boolean tieneTutoria() {
		return tutoria != null;
	}

	public boolean getTutoriaHabilitada() {
		return tutoriaHabilitada;
	}

	public void setTutoriaHabilitada(Boolean tutoriaHabilitada) {
		this.tutoriaHabilitada = tutoriaHabilitada;
	}

}
