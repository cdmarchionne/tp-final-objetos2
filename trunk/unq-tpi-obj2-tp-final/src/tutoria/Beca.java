package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * Controla las Becas otorgadas
 */
public class Beca extends Tutoria {

	private Integer monto;

	// *****************
	// * Constructores *
	// *****************

	public Beca(String nombre, Alumno alumno, Date fechaInicio, Integer monto) {
		super(nombre, alumno, fechaInicio);
		this.monto = monto;
	}

	public Integer getMonto() {
		return monto;
	}

}
