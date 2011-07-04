package personal;

/**
 * Clase que utilizamos para manejar a las Autoridades
 */
public class Autoridad {

	private Persona datosPersonales;

	public Autoridad(Persona datosPersonales) {
		super();
		this.datosPersonales = datosPersonales;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

}
