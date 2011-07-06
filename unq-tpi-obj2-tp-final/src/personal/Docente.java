package personal;

import java.util.HashSet;
import java.util.Set;

import materias.Materia;
import universidad.Carrera;
import Utils.Antecedente;
import Utils.Historial;
import Utils.Nombrable;

/**
 * Docente
 */
public class Docente implements Nombrable {

	private Persona datosPersonales;

	private Integer legajo;

	private Set<String> titulos;

	private Set<Carrera> carreras;

	private Historial<Materia> materiasDictadas;

	/** Si el docente es alumno conoce sus propios datos */
	private Alumno alumno;

	// *****************
	// * Constructores *
	// *****************
	public Docente(Persona datosPersonales, Integer legajo) {
		super();
		this.datosPersonales = datosPersonales;
		this.legajo = legajo;
		titulos = new HashSet<String>();
		carreras = new HashSet<Carrera>();
		materiasDictadas = new Historial<Materia>();
		alumno = null;
	}

	// ********************
	// * Getter & Setters *
	// ********************
	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	@Override
	public String getNombre() {
		return this.getDatosPersonales().getNombre();
	}

	@Override
	public String toString() {
		return getNombre();
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public Set<String> getTitulos() {
		return titulos;
	}

	public void setTitulos(Set<String> titulos) {
		this.titulos = titulos;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public void removeAlumno() {
		alumno = null;
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void addCarreras(Carrera carrera) {
		carreras.add(carrera);
	}

	public Historial<Materia> getMateriasDictadas() {
		return materiasDictadas;
	}

	public void addMateriasDictadas(Antecedente<Materia> materiasDictadas) {
		this.materiasDictadas.addAntecedente(materiasDictadas);
	}

	@Override
	public int hashCode() {
		return legajo.hashCode() + datosPersonales.hashCode();
	}

	// ********************
	// * Funciones Utiles *
	// ********************
	public boolean isAlumno() {
		return alumno != null;
	}

	public boolean isSameAlumno(Alumno alumno) {
		return this.isAlumno() && this.alumno.equals(alumno);
	}

	public boolean isSamePerson(Alumno alumno) {
		return this.getDatosPersonales().equals(alumno.getDatosPersonales());
	}

	public boolean isSamePerson(Persona datosPersonales) {
		return this.getDatosPersonales().equals(datosPersonales);
	}
}
