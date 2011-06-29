package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * TODO: description
 */
public class Beca extends Tutoria {

	private Integer monto;

	// *****************
	// * Constructores *
	// *****************

	public Beca(final String nombre, final Alumno alumno, final Date fechaInicio,
			final Integer monto) {
		super(nombre, alumno, fechaInicio);
		this.monto = monto;
	}

}
