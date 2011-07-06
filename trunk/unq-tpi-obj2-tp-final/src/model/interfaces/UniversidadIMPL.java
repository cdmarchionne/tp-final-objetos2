package model.interfaces;

import java.util.List;

public interface UniversidadIMPL {
	public List<AlumnoIMPL> getAlumnos();

	public List<MateriaIMPL> getMaterias();

	public List<MateriaIMPL> materiasInscribibles(AlumnoIMPL alumno);

	public void inscribirAlumno(AlumnoIMPL alumno, CatedraIMPL catedra, MateriaIMPL materia);
}
