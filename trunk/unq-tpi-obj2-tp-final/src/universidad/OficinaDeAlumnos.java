package universidad;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import personal.Persona;
import personal.Alumno;
import personal.Docente;
import materias.Catedra;

/**
 * TODO: description
 */
public class OficinaDeAlumnos {

	private Persona jefeOficina;
	private Set<Persona> secretarios;

	private Set<Alumno> alumnos;
	private Set<Docente> docentes;
	private Integer legajoDocente;
	
	public OficinaDeAlumnos(Persona jefeOficina){
		super();
		this.alumnos = new HashSet<Alumno>();
		this.secretarios = new HashSet<Persona>();
		this.jefeOficina = jefeOficina;
	}

	public void inscribirAlumnoEnCarrera(final Alumno alumno, final Carrera carrera) {
		if (alumno.cursoDeIngresoAprobado()) {
			alumno.addCarrerasInscriptas(carrera);
			alumno.addLegajo(carrera, carrera.obtenerLegajo());
		}
	}
	
	/** Creo un docente nuevo y lo agrego a la lista de docentes */
	public void nuevoDocente(Persona datosPersonales){
		Docente docente= new Docente(datosPersonales,incrementarLegajoDocente());
		docentes.add(docente);
	}

	private int incrementarLegajoDocente() {
		legajoDocente =legajoDocente +1;
		return legajoDocente;
	}

	public void nuevoAlumno(Persona datosPersonales) {
		Alumno alumno= new Alumno(datosPersonales);
		alumnos.add(alumno);
	}
	
	
	/** Cambia un alumno de una catedra a otra 	 */
	public void cambiarAlumnoDeCatedra(Catedra nuevaCatedra, Catedra catedraActual , Alumno alumno){
		catedraActual.removeAlumno(alumno);
		nuevaCatedra.agregarAlumnoInscripto(alumno);
	}

	public List entregarAnalitico(Alumno alumno){
		return alumno.getMateriasAprobadas();
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
	
	
}
