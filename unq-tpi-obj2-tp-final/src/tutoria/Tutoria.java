package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * Manejo de Tutorias
 */
// TODO: Verificar el funcionamiento de las Tutorias
public abstract class Tutoria {

	private String nombre;

	private Alumno alumno;

	private Date fechaInicio;

	private Date fechaFinal;

	// *****************
	// * Constructores *
	// *****************

	protected Tutoria(String nombre, Alumno alumno, Date fechaInicio) {
		super();
		this.nombre = nombre;
		this.alumno = alumno;
		this.fechaInicio = fechaInicio;
		// fechaFinal = fechaInicio.setYear(fechaInicio.getYear() + 1);
	}

	protected Tutoria(String nombre, Alumno alumno, Date fechaInicio, Date fechaFinal) {
		this(nombre, alumno, fechaInicio);
		this.fechaFinal = fechaFinal;
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public String getNombre() {
		return nombre;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public abstract boolean esBeca();

	public abstract boolean esPasantia();

}
