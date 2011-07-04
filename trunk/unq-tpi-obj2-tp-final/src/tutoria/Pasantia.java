package tutoria;

import java.util.Date;

import personal.Alumno;

/**
 * Controla las Pasantias otorgadas
 */
public class Pasantia extends Tutoria {

	private String empresa;

	// *****************
	// * Constructores *
	// *****************

	public Pasantia(String nombre, Alumno alumno, Date fechaInicio,	String empresa) {
		super(nombre, alumno, fechaInicio);
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

}
