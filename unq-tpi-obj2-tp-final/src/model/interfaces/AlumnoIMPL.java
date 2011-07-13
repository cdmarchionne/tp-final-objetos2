package model.interfaces;

import java.util.Set;

import universidad.PlanDeEstudio;

public interface AlumnoIMPL {
	@Override
	public String toString();
	
	public Set<PlanDeEstudio> getPlanesDeEstudio();//AGERGADO RECIEN
	
}
