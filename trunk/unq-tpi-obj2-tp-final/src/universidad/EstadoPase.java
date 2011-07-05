package universidad;

import Utils.Nombrable;

/**
 * Regulacion de los estados del pase
 */
public abstract class EstadoPase implements Nombrable,Runnable {
	
	private PaseDocente memorandum;

	public EstadoPase(PaseDocente memorandum) {
		super();
		this.memorandum = memorandum;
	}

	@Override
	public abstract String getNombre();

	@Override
	public abstract void run();

	protected PaseDocente getMemorandum() {
		return memorandum;
	}

}
