package universidad;

import java.util.HashSet;
import java.util.Set;

import personal.Autoridad;
import personal.Docente;

/**
 * Modela un Pase de Docente de un Area a otra
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

	public PaseDocente(String descripcion, Docente solicitante, Area areaOrigen, Area areaDestino) {
		super();
		concejo = new HashSet<Autoridad>();
		this.descripcion = descripcion;
		this.solicitante = solicitante;
		this.areaOrigen = areaOrigen;
		this.areaDestino = areaDestino;
		resultado = new PaseSolicitado(this);
	}

	public PaseDocente(Set<Autoridad> concejo, String descripcion, Docente solicitante,
			Area areaOrigen, Area areaDestino) {
		super();
		this.concejo = concejo;
		this.descripcion = descripcion;
		this.solicitante = solicitante;
		this.areaOrigen = areaOrigen;
		this.areaDestino = areaDestino;
		resultado = new PaseSolicitado(this);
	}

	// ********************
	// * Getter & Setters *
	// ********************

	public Set<Autoridad> getConcejo() {
		return concejo;
	}

	public void addAutoridad(Autoridad autoridad) {
		concejo.add(autoridad);
	}

	public void removeAutoridad(Autoridad autoridad) {
		concejo.remove(autoridad);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
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

	public void setPase(Autoridad autoridad, EstadoPase pase) {
		if (concejo.contains(autoridad)) {
			resultado = pase;
			resultado.run();
		}
	}

	public void setPaseAprobado(Autoridad autoridad) {
		this.setPase(autoridad, new PaseAprobado(this));
	}

	public void setPaseEnConcejo(Autoridad autoridad) {
		this.setPase(autoridad, new PaseEnConsejo(this));
	}

	public void setPaseRechazado(Autoridad autoridad) {
		this.setPase(autoridad, new PaseRechazado(this));
	}

	public void setPaseSolicitado(Autoridad autoridad) {
		this.setPase(autoridad, new PaseSolicitado(this));
	}

}
