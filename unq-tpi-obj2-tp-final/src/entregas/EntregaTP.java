package entregas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import personal.Alumno;
import personal.Docente;

/**
 * TODO: description
 */
public class EntregaTP {

	private final TrabajoPractico tp;
	private int nota;
	private Docente profesorCorrector;
	private final List<Alumno> alumnos;
	private Map<String, String> listaEjercicios;// En la clave va el ejercicio,
												// en el valor va la correccion.
	private Date fechaEntregado;
	private boolean aprobado;

	/** Constructor con UN alumno en la entrega */
	public EntregaTP(TrabajoPractico tp, Alumno alumno) {

		this.tp = tp;
		this.setProfesorCorrector(null);// Se inicia en null ya que no hay
										// ningun profesor quue lo haya
										// corregido.
		this.setNota(0);// Se inicia en 0 ya que no se corrigio aun.
		// Faltaria ver como hacer para que al crear la EntregaTP se agregue a
		// la lista de ENTREGASTPS de la CATEDRA,
		this.alumnos = new ArrayList<Alumno>();// se genera el array y se agrega
												// el unico alumno.
		this.alumnos.add(alumno);
	}

	/**
	 * Constructor con MAS de UN alumno. Se pasa una lista de alumnos para
	 * crearlo. ( TP GRUPAL )
	 */
	public EntregaTP(TrabajoPractico tp, List<Alumno> alumnos) {

		this.tp = tp;
		this.setProfesorCorrector(null);// Se inicia en null ya que no hay
										// ningun profesor quue lo haya
										// corregido.
		this.setNota(0);// Se inicia en 0 ya que no se corrigio aun.
		// Faltaria ver como hacer para que al crear la EntregaTP se agregue a
		// la lista de ENTREGASTPS de la CATEDRA,

		this.alumnos = alumnos;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public TrabajoPractico getTP() {
		return tp;
	}

	public Docente getProfesorCorrector() {
		return profesorCorrector;
	}

	private void setProfesorCorrector(Docente profesorCorrector) {
		this.profesorCorrector = profesorCorrector;
	}

	public List<Alumno> getAlumno() {
		return alumnos;
	}

	/** Devuelve true si la lista de alumnos tiene UN solo integrante */
	public boolean isIndividual() {
		return this.alumnos.size() == 1;
	}

	public void setListaEjercicios(Map<String, String> listaEjercicios) {
		this.listaEjercicios = listaEjercicios;
	}

	public Map<String, String> getListaEjercicios() {
		return listaEjercicios;
	}

	public void setAprobado() {
		aprobado = true;
	}

	public void setDesaprobado() {
		aprobado = false;
	}

	public Date getFechaEntregado() {
		return this.fechaEntregado;
	}

	/** Devuelve true si encuentra el alumno en su lista */
	public boolean tieneAlumno(Alumno alumno) {
		for (Alumno supuestoAlumno : this.alumnos) {
			if (supuestoAlumno.equals(alumno)) {
				return true;
			}
		}
		return false;
	}

	public Alumno comprarPorApellido(Alumno alumno1, Alumno alumno2) {
		int compApellido = alumno1.getApellido().compareTo(alumno2.getApellido());
		if (compApellido > 0) {
			return alumno2;
		} else {
			return alumno1;
		}

	}

	/**
	 * Devuelve el alumno con apellido anterior alfabeticamente, tiene utilidad
	 * para entregas con mas de un alumno
	 */
	public Alumno getAlumnoMenorNombre() {

		Alumno alumnoGanador = this.getAlumno().get(0);// Agarro el primero
		for (Alumno alumno : this.getAlumno()) {

			int compApellido = alumnoGanador.getApellido().compareTo(alumno.getApellido());
			if (compApellido > 0) {
				alumnoGanador = alumno;

			} else {
				if (compApellido == 0) {// Si son iguales los apellidos Comparo
										// por nombre
					int compNombre = alumnoGanador.getNombre().compareTo(alumno.getNombre());
					if (compNombre > 0) {
						alumnoGanador = alumno;
					}

				}
			}
		}

		return alumnoGanador;

	}
}
