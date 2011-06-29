package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * TODO: description
 */
public abstract class Tutoria {

	private String nombre;

	private Alumno alumno;

	private Date fechaInicio;

	private Date fechaFinal;

	// *****************
	// * Constructores *
	// *****************

	protected Tutoria(final String nombre, final Alumno alumno, final Date fechaInicio) {
		super();
		this.nombre = nombre;
		this.alumno = alumno;
		this.fechaInicio = fechaInicio;
		fechaFinal = fechaInicio.setYear(fechaInicio.getYear() + 1);
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

}
