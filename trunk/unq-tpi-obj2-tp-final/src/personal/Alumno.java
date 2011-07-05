package personal;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	private List<Date> arrayFechasAprobadas;
	private int cantAusentes;
	private Boolean regularidad;
	private List<Integer> añosLicencia;
	private int cantLicencias;

	// *****************
	// * Constructores *
	// *****************
	public Alumno(Persona datosPersonales) {

		super();
		this.datosPersonales = datosPersonales;
		entregas = new ArrayList<EntregaTP>();
		carrerasInscriptas = new ArrayList<InscripcionCarrera>();
		materiasInscriptas = new ArrayList<InscripcionMateria>();
		materiasAprobadas = new ArrayList<MateriaAprobada>();
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

	public int getCantLicencias() {
		return cantLicencias;
	}
	
	public void setAñosLicencia(List<Integer> añosLicencia) {
		this.añosLicencia = añosLicencia;
	}

	public List<Integer> getAñosLicencia() {
		return añosLicencia;
	}

	public void setCarrerasInscriptas(List<InscripcionCarrera> carrerasInscriptas) {
		this.carrerasInscriptas = carrerasInscriptas;
	}

	public void setMateriasInscriptas(List<InscripcionMateria> materiasInscriptas) {
		this.materiasInscriptas = materiasInscriptas;
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

	public List<InscripcionCarrera> getCarrerasInscriptas() {
		return carrerasInscriptas;
	}

	public void addCarreraIncripta(InscripcionCarrera carreraInscripta) {
		carrerasInscriptas.add(carreraInscripta);
	}
	
	public void removeCarreras(InscripcionCarrera carreraInscripta) {
		carrerasInscriptas.remove(carreraInscripta);
	}

	public List<InscripcionMateria> getMateriasInscriptas() {
		return materiasInscriptas;
	}

	public List<MateriaAprobada> getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(List<MateriaAprobada> materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	
	public int getCantAusentes(){
		return this.cantAusentes;
	}
	public void setCantAusentes(int cant){
		this.cantAusentes = cant;
	}
	public void setRegularidad(Boolean bool){
		this.regularidad = bool;
	}
	public Boolean getRegularidad(){
		return this.regularidad;
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
	public Integer getLegajo( PlanDeEstudio planDeEstudio) {
		return this.getCarreraInscripta(planDeEstudio).getLegajo();
	}

	public Integer getLegajo( Carrera carrera) {
		return this.getCarreraInscripta(carrera).getLegajo();
	}

	/** Modofico el legajo de un Alumno */
	public void setLegajo( PlanDeEstudio planDeEstudio,  Integer legajo) {
		boolean existe=false;
		for (InscripcionCarrera carreraInscripta : carrerasInscriptas) {
			if(carreraInscripta.getPlanDeEstudio().equals(planDeEstudio)){
				carreraInscripta.setLegajo(legajo);
				existe=true;
			}
		}
		
		if(!existe){
			this.addCarreraIncripta(new InscripcionCarrera(planDeEstudio, legajo));
		}
	}


	public void calcularRegularidad() {
		Date date = new Date();
		int var = 0;	
		for (int i = 0; i < (this.getArrayFechasAprobadas()).size(); i++) {
			if ((this.getArrayFechasAprobadas().get(i)).getYear() == date.getYear()){
				var = var + 1;
				}
		}
			
		if ((this.getCantAusentes() > 6) &&(var < 2)){
			this.setRegularidad(false);
			System.out.println("El Alumno esta libre.");}
			else
			{System.out.println("El Alumno es regular.");}
		}
	public String getNombre() {
		return this.getDatosPersonales().getNombre();
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
	/** es un getter de las fechas de las materias aprobadas*/
	public List<Date> getArrayFechasAprobadas(){
		return this.arrayFechasAprobadas;
	}
	
	/** agrega materia aprobada y setea fecha actual en lista de fechas para calcular regularidad */
	public void agregarMateriaAprobada(Materia materia, float nota) {
		Date date = new Date();
		materiasAprobadas.add(new MateriaAprobada(materia, nota));
		this.getArrayFechasAprobadas().add(date);
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
	public boolean estaInscripto(Materia materia) {

		for (InscripcionMateria materiaInscripto : this.getMateriasInscriptas()) {
			if (materiaInscripto.getMateriaElegida().equals(materia))
				return true;
		}

		return false;
	}





}
