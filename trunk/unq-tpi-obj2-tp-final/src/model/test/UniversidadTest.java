package model.test;

import java.util.List;
import java.util.Vector;

import junit.framework.TestCase;

import materias.Catedra;
import materias.Materia;
import model.interfaces.AlumnoIMPL;
import model.interfaces.MateriaIMPL;
import personal.Alumno;
import personal.Persona;
import universidad.Universidad;


public class UniversidadTest extends TestCase{

	private static final int DNI_PRIETO = 32640573;

	public void testMateriasInscribibles() throws Exception {
		Materia materia1 = new Materia("Analisis I",3);
		Materia materia2 = new Materia("Ingles I", 2);
		Catedra catedra = new Catedra("", materia1);
		
		Persona directorOA = new Persona(1345672, "Juan", "Petrolas", "M");
		Persona directorTPI = new Persona(12345678, "Pablo", "Lopez", "M");
		Persona alumnoPromedioTPI = new Persona(DNI_PRIETO, "Mariano", "Prieto", "M");
		
		Alumno alumno = new Alumno(alumnoPromedioTPI);
		
		List<MateriaIMPL> materias = new Vector<MateriaIMPL>();
		materias.add(materia1);
		materias.add(materia2);
		
		List<AlumnoIMPL> alumnos = new Vector<AlumnoIMPL>();
		alumnos.add(alumno);
		
		Universidad universidad = Universidad.getInstance();
		universidad.setAlumnos(alumnos);
		universidad.setMaterias(materias);
		
		//el alumno no se inscribio en materias
		Assert.assertEquals("el alumno esta inscripto en una materia",
				2, universidad.materiasInscribibles(alumno).size());
		
		catedra.inscribirAlumno(alumno);
		
		Assert.assertEquals("el alumno esta inscripto en una materia",
				1, universidad.materiasInscribibles(alumno).size());
	}
}
