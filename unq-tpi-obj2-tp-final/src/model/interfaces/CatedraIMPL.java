package model.interfaces;

import java.util.List;

public interface CatedraIMPL {
	public List<AlumnoIMPL> getInscriptos();

	@Override
	public String toString();
}
