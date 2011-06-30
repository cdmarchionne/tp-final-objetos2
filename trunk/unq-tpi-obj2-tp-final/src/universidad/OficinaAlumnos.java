package universidad;

import java.util.HashSet;
import java.util.Set;

import materias.Catedra;
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

	public OficinaAlumnos() {
		super();
	}

	public OficinaAlumnos(Persona jefeOficina) {
		this();
		alumnos = new HashSet<Alumno>();
		secretarios = new HashSet<Persona>();
		this.jefeOficina = jefeOficina;
	}

	public void inscribirAlumnoEnCarrera(final Alumno alumno, final Carrera carrera) {
		if (alumno.cursoDeIngresoAprobado()) {
			alumno.addCarrerasInscriptas(carrera);
			alumno.addLegajo(carrera, carrera.obtenerLegajo());
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

	@Override
	public String analiticoDe(AlumnoIMPL alumno) {
		return this.entregarAnalitico((Alumno) alumno);
	}

	@Override
	public float coeficienteDe(AlumnoIMPL alumno) {
		return this.getCoeficiente((Alumno) alumno);
	}

}
