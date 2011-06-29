package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * TODO: description
 */
public class Pasantia extends Tutoria {

	private String empresa;

	// *****************
	// * Constructores *
	// *****************

	public Pasantia(final String nombre, final Alumno alumno, final Date fechaInicio,
			final String empresa) {
		super(nombre, alumno, fechaInicio);
		this.empresa = empresa;
	}

}
