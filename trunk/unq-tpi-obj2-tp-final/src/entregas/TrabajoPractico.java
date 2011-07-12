package entregas;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import personal.Alumno;

/**
 * Trabajo Practico contendra las correciones y los alumnos, y ademas conocera
 * las entregas relacionadas a el.
 */
public class TrabajoPractico {

	private final String nombre;
	private final Date fechaLimite; // Fecha MAXIMA para entregar
	private final Set<EntregaTP> entregas;

	/**
	 * Consutrctor de TPS, se necesita un nombre y una fecha, genera
	 * automaticamente una lista de entregas pero vacia.
	 */
	public TrabajoPractico(String nombre, Date fechaLimite) {
		this.nombre = nombre;
		this.fechaLimite = fechaLimite;

		// Genero la lista de entregas como una lista vacia.
		entregas = new HashSet<EntregaTP>();
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public Set<EntregaTP> getEntregas() {
		return entregas;
	}

	/** Agrega una entrega al TP */
	public void addEntrega(EntregaTP entrega) {
		entregas.add(entrega);
	}

	/** Devuelve la entrega de un alumno en particular */
	public EntregaTP getEntregaDe(Alumno alumno) {

		for (EntregaTP entrega : entregas) {
			if (entrega.contains(alumno))
				return entrega;
		}

		return null;
	}

	/**
	 * Devuelve true si en la lista de entregas hay alguna hecha por el alumno.
	 */
	public boolean alumnoHizoEntrega(Alumno alumno) {

		for (EntregaTP entrega : entregas) {
			if (entrega.contains(alumno))
				return true;
		}

		return false;
	}

	/**
	 * Devuelvo una lista con todos los alumnos que entregaron el TP
	 */
	public Set<Alumno> alumnosQueEntregaron() {
		Set<Alumno> resultado = new HashSet<Alumno>();

		for (EntregaTP entrega : entregas) {
			/** Agrega los alumnos que entregaron */
			for (Alumno alumno : entrega.getAlumno()) {
				resultado.add(alumno);
			}

		}

		return resultado;
	}
}
