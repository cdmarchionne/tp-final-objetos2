package universidad;

/**
 * En Consejo
 */
public class PaseEnConsejo extends EstadoPase {

	public PaseEnConsejo(PaseDocente memorandum) {
		super(memorandum);
	}

	@Override
	public String getNombre() {
		return "En Consejo";
	}

	@Override
	public void run() {
		
	}
	
}
