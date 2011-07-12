package model.interfaces;

import java.util.List;

public interface UniversidadIMPL {
	public List<AlumnoIMPL> getAlumnos();

	public List<MateriaIMPL> getMaterias();

	public List<MateriaIMPL> materiasInscribibles(AlumnoIMPL alumno, PlanDeEstudioIMPL plan);

	public List<PlanDeEstudioIMPL> getPlanesDeEstudio(AlumnoIMPL alumno);

	public void inscribirAlumno(AlumnoIMPL alumno, CatedraIMPL catedra, MateriaIMPL materia,
			PlanDeEstudioIMPL plan);

}
