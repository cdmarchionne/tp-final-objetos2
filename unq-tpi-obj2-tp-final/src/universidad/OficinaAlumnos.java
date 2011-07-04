package universidad;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import materias.Catedra;
import materias.InscripcionMateria;
import materias.Materia;
import model.interfaces.AlumnoIMPL;
import model.interfaces.OficinaAlumnosIMPL;
import personal.Alumno;
import personal.Docente;
import personal.Persona;

/**
 * TODO: description
 */
public class OficinaAlumnos implements OficinaAlumnosIMPL {

	
	private Persona jefeOficina;
	private Set<Persona> secretarios;

	private Set<Alumno> alumnos;
	private Set<Docente> docentes;
	private Integer legajoDocente;

	private Set<Carrera> carreras;
	
	public OficinaAlumnos() {
//		super();
	}
	
	public OficinaAlumnos(Persona jefeOficina) {
		this();
		this.jefeOficina = jefeOficina;
		secretarios = new HashSet<Persona>();
		alumnos = new HashSet<Alumno>();
		docentes= new HashSet<Docente>();
		legajoDocente=0;
		carreras= new HashSet<Carrera>();		
	}

	/** Inscribo a un alumno en un Plan de Estudio especifico de una Carrera */
	public void inscribirAlumnoEnCarrera(Alumno alumno, PlanDeEstudio planDeEstudio) {
		if (alumno.getCursoDeIngreso()) {
			Carrera carrera = getCarrera(planDeEstudio);
			if(carrera.getPlanesVigentes().contains(planDeEstudio)){
				alumno.addCarreraIncripta(new InscripcionCarrera(planDeEstudio,carrera.obtenerLegajo()));
			}
		}
	}
	
//	public void inscribirAlumnoEnCarrera(Alumno alumno, Carrera carrera) {
//		if(!carrera.getPlanesVigentes().isEmpty()){
//			Object[] planDeEstudio = carrera.getPlanesVigentes().toArray();
//			inscribirAlumnoEnCarrera(alumno, (PlanDeEstudio) planDeEstudio[0]);
//		}
//	}

	/** Inscribo a un alumno en un Catedra especifico de una Materia */
	public void inscribirAlumnoEnCatedra(Alumno alumno, Catedra catedra) {
		for (Materia materia : (Materia[]) alumno.getMateriasInscribibles().toArray()) {
			if(materia.getCatedras().contains(catedra)){
				new InscripcionMateria(materia, catedra, alumno);
				break;
			}
		}
	}
	
	/** Creo un docente nuevo y lo agrego a la lista de docentes */
	public void nuevoDocente(Persona datosPersonales) {
		Docente docente = new Docente(datosPersonales, this.incrementarLegajoDocente());
		docentes.add(docente);
	}

	private int incrementarLegajoDocente() {
		legajoDocente = legajoDocente + 1;
		return legajoDocente;
	}

	public void nuevoAlumno(Persona datosPersonales) {
		Alumno alumno = new Alumno(datosPersonales);
		alumnos.add(alumno);
	}

	/** Cambia un alumno de una catedra a otra */
	public void cambiarAlumnoDeCatedra(Catedra nuevaCatedra, Catedra catedraActual, Alumno alumno) {
		catedraActual.removeAlumno(alumno);
		nuevaCatedra.agregarAlumnoInscripto(alumno);
	}

	public String entregarAnalitico(Alumno alumno) {
		return alumno.getMateriasAprobadas().toString();
	}

	public Persona getJefeOficina() {
		return jefeOficina;
	}

	public Set<Persona> getSecretarios() {
		return secretarios;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public Set<Docente> getDocentes() {
		return docentes;
	}

	public Integer getLegajoDocente() {
		return legajoDocente;
	}

	public float getCoeficiente(Alumno alumno) {
		return alumno.calcularPromedio();
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	@Override
	public String analiticoDe(AlumnoIMPL alumno) {
		return this.entregarAnalitico((Alumno) alumno);
	}

	@Override
	public float coeficienteDe(AlumnoIMPL alumno) {
		return this.getCoeficiente((Alumno) alumno);
	}

	public Carrera getCarrera(PlanDeEstudio planDeEstudio){
		Carrera carreraBuscada = null;

		Iterator<Carrera> iteradorCarrera = carreras.iterator();
		Carrera carrera=null;
		while(iteradorCarrera.hasNext()){
			carrera=iteradorCarrera.next();
			if (carrera.contains(planDeEstudio)) {
				carreraBuscada = carrera;
				break;
			}
		}

		return carreraBuscada;
	}
	
	public void addCarrera(Carrera carrera ){
		carreras.add(carrera);
	}
	
	public void removeCarrera(Carrera carrera ){
		carreras.remove(carrera);
	}

}
