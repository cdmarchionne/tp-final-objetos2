package Utils;

public class NoSeEncuentraTPException extends Exception {

	public NoSeEncuentraTPException() {
		new Exception("No hay ningun TP con ese nombre");
	}
}
