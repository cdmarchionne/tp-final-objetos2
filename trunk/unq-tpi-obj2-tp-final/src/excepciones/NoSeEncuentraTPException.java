package excepciones;

public class NoSeEncuentraTPException extends UnsupportedOperationException {
	private static final long serialVersionUID = 1L;

	public NoSeEncuentraTPException() {
		new Exception("No hay ningun TP con ese nombre");
	}
}
