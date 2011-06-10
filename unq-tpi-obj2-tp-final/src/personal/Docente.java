package personal;

import materias.Materia;
import Utils.Historial;

/**
 * Docente
 */
public class Docente {

	private Persona datosPersonales;

	private Integer legajo;

	private Historial<Materia> materiasDictadas;

	public Docente(final Persona datosPersonales, final Integer legajo) {
		super();
		this.datosPersonales = datosPersonales;
		this.legajo = legajo;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(final Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(final Integer legajo) {
		this.legajo = legajo;
	}
}
