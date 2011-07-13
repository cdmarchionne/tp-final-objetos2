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

	public Pasantia(String nombre, Alumno alumno, Date fecha, String empresa) {
		super(nombre, alumno, fecha, fecha);
		this.empresa = empresa;
	}

	public String getEmpresa() {
		return empresa;
	}

	@Override
	public boolean esBeca() {
		return false;
	}

	@Override
	public boolean esPasantia() {
		return true;
	}

}
