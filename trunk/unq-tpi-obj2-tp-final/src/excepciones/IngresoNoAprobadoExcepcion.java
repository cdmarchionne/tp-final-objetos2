package excepciones;

public class IngresoNoAprobadoExcepcion extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public IngresoNoAprobadoExcepcion() {
		new Exception("No se puede inscribir el alumno, no aprobo el curso de ingreso aun");
	}

}
