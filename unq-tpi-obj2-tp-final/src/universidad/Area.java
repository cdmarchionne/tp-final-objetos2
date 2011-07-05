package universidad;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import materias.Materia;
import personal.Docente;
import Utils.Historial;
import Utils.Nombrable;

/**
 * Area: Agrupo bajo un mismo concepto las materias y los docentes de temas
 * relacionados.
 */
@SuppressWarnings("unused")
public class Area implements Nombrable{

	private String nombre;
	private Docente director;

	/** Guardar el historial de Docentes */
	private Historial<Docente> staffDocente;

	/** Guardar el historial de Materias */
	private Historial<Materia> materiasDictadas;

	// ***************** 
	// * Constructores *
	// *****************

	public Area(final String nombre) {
		super();
		this.nombre = nombre;
		this.director = null;
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

	@Override
	public String getNombre() {
		return nombre;
	}

	/** Devuelvo el Historial del Staff Docente */
	private Historial<Docente> getHistorialDocente() {
		return staffDocente;
	}

	private Historial<Docente> getHistorialDocente(Docente docente) {
		return getHistorialDocente().getHistorialDelElemento(docente);
	}

	/** Devuelvo el Historial de Materias Dictadas */
	private Historial<Materia> getMateriasDictadas() {
		return materiasDictadas;
	}
	
	private Historial<Materia> getMateriasDictadas(Materia materia) {
		return getMateriasDictadas().getHistorialDelElemento(materia);
	}

	// ********************
	// * Funciones Utiles *
	// ********************
	
	/** Devuelvo el Staff Docente en una Fecha determinada */
	public Set<Docente> getDocentes(Date fecha) {
		return getHistorialDocente().getElementos(fecha);
	}
	
	public Set<Docente> getDocentes() {
		return getDocentes(new Date());
	}
	
	/** Devuelvo las Materias que se dictaban en una Fecha determinada */
	public Set<Materia> getMaterias(Date fecha) {
		return getMateriasDictadas().getElementos(fecha);
	}
	
	public Set<Materia> getMaterias() {
		return getMaterias(new Date());
	}
	
	/** Agrego un docente nuevo al Staff */
	public void addDocente(Docente docente, Date fecha){
		getHistorialDocente().addAntecedente(fecha, null, docente);
	}
	
	/** Saco a un docente del Staff */
	public void removeDocente(Docente docente, Date fecha){
		getHistorialDocente(docente).closeAntecedente(fecha);
	}
	
	/** Agrego una Materia */
	public void addMateria(Materia materia, Date fecha){
		getMateriasDictadas().addAntecedente(fecha, null, materia);
	}
	
	/** Saco una Materia */
	public void removeMateria(Materia materia, Date fecha){
		getMateriasDictadas(materia).closeAntecedente(fecha);
	}
	
}
