package universidad;

/**
 * Solicitado
 */
public class PaseSolicitado extends EstadoPase {

	public PaseSolicitado(PaseDocente memorandum) {
		super(memorandum);
	}

	@Override
	public String getNombre() {
		return "Solicitado";
	}

	@Override
	public void run() {
		
	}

}
