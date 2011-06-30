package universidad;

import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import personal.Alumno;
import personal.Persona;
import materias.Catedra;

/**
 * TODO: description
 */
public class OficinaDeAlumnos {
	private Persona jefeOficina;
	private List<Alumno> alumnos;
	private List<Persona> secretarios;
	
	public OficinaDeAlumnos(Persona jefeOficina){
		super();
		this.alumnos = new ArrayList<Alumno>();
		this.secretarios = new ArrayList<Persona>();
		this.jefeOficina = jefeOficina;
	}
	public void inscribirAlumnoEnCarrera(Alumno alumno, final Carrera carrera) {
		if (alumno.cursoDeIngresoAprobado()) {
			alumno.addCarrerasInscriptas(carrera);
			alumno.addLegajo(carrera, carrera.obtenerLegajo());
		}
		}
	public void altaAlumno(Persona persona){
		Alumno alumno = new Alumno(persona);
		this.alumnos.add(alumno);		
	}
	/** Cambia un alumno de una catedra a otra 	 */
	public void cambiarAlumnoDeCatedra(Catedra nuevaCatedra, Catedra catedraActual , Alumno alumno){
		catedraActual.removeAlumno(alumno);
		nuevaCatedra.agregarAlumnoInscripto(alumno);
	}

	public List entregarAnalitico(Alumno alumno){
		return alumno.getMateriasAprobadas();
	}
	
	
}
