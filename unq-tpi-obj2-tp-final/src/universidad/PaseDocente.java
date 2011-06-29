package universidad;

import java.util.HashSet;
import java.util.Set;

import personal.Autoridad;
import personal.Docente;

/**
 * TODO: description
 */
public class PaseDocente {

	private Set<Autoridad> concejo;

	private String descripcion;

	private Docente solicitante;

	private Area areaOrigen;

	private Area areaDestino;

	private EstadoPase resultado;

	// *****************
	// * Constructores *
	// *****************

	public PaseDocente(final String descripcion, final Docente solicitante, final Area areaOrigen,
			final Area areaDestino) {
		super();
		concejo = new HashSet<Autoridad>();
		this.descripcion = descripcion;
		this.solicitante = solicitante;
		this.areaOrigen = areaOrigen;
		this.areaDestino = areaDestino;
		resultado = new PaseSolicitado();
	}

	public PaseDocente(final Set<Autoridad> concejo, final String descripcion,
			final Docente solicitante, final Area areaOrigen, final Area areaDestino) {
		super();
		this.concejo = concejo;
		this.descripcion = descripcion;
		this.solicitante = solicitante;
		this.areaOrigen = areaOrigen;
		this.areaDestino = areaDestino;
		resultado = new PaseSolicitado();
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public Set<Autoridad> getConcejo() {
		return concejo;
	}

	public void addAutoridad(final Autoridad autoridad) {
		concejo.add(autoridad);
	}

	public void removeAutoridad(final Autoridad autoridad) {
		concejo.remove(autoridad);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	public EstadoPase getResultado() {
		return resultado;
	}

	public Docente getSolicitante() {
		return solicitante;
	}

	public Area getAreaOrigen() {
		return areaOrigen;
	}

	public Area getAreaDestino() {
		return areaDestino;
	}

	// ********************
	// * Funciones Utiles *
	// ********************

	private void setPase(final Autoridad autoridad, final EstadoPase pase) {
		if (concejo.contains(autoridad)) {
			resultado = new PaseAprobado();
		}
	}

	public void setPaseAprobado(final Autoridad autoridad) {
		this.setPase(autoridad, new PaseAprobado());
	}

	public void setPaseEnConcejo(final Autoridad autoridad) {
		this.setPase(autoridad, new PaseEnConsejo());
	}

	public void setPaseRechazado(final Autoridad autoridad) {
		this.setPase(autoridad, new PaseRechazado());
	}

	public void setPaseSolicitado(final Autoridad autoridad) {
		this.setPase(autoridad, new PaseSolicitado());
	}

}
