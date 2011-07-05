package universidad;

/**
 * Rechazado
 */
public class PaseRechazado extends EstadoPase {

	public PaseRechazado(PaseDocente memorandum) {
		super(memorandum);
	}

	@Override
	public String getNombre() {
		return "Rechazado";
	}

	@Override
	public void run() {
		
	}

}