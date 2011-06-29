package universidad;

import materias.Materia;
import personal.Docente;
import Utils.Historial;

/**
 * Area: Agrupo bajo un mismo concepto las materias y los docentes de temas
 * relacionados.
 */
public class Area {

	private String nombre;

	private Docente director;

	/** Guardar el historial de Docentes */
	private Historial<Docente> staffDocente;

	/** Guardar el historial de Materias */
	private Historial<Materia> materiasDictadas;

	// *****************
	// * Constructores *
	// *****************

	public Area(final String nombre, final Docente director) {
		super();
		this.nombre = nombre;
		this.director = director;
		staffDocente = new Historial<Docente>();
		materiasDictadas = new Historial<Materia>();
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public Docente getDirector() {
		return director;
	}

	public void setDirector(final Docente director) {
		this.director = director;
	}

	public String getNombre() {
		return nombre;
	}

	public Historial<Docente> getStaffDocente() {
		return staffDocente;
	}

	public Historial<Materia> getMateriasDictadas() {
		return materiasDictadas;
	}

	// ********************
	// * Funciones Utiles *
	// ********************
}
