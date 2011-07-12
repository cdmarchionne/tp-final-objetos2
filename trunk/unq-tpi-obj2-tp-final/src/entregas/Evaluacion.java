package entregas;

import java.util.Date;

import personal.Alumno;

/**
 * Evaluacion
 */
public abstract class Evaluacion {

	private String titulo;

	private Date fecha;

	private Alumno alumno;

	private Integer nota;

	public Evaluacion(String titulo, Date fecha) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
	}

	public Evaluacion(String titulo, Date fecha, Alumno alumno, Integer nota) {
		this(titulo, fecha);
		this.alumno = alumno;
		this.nota = nota;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}
