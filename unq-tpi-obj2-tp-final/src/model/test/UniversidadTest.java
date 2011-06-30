package model.test;

import java.util.List;
import java.util.Vector;

import junit.framework.Assert;
import junit.framework.TestCase;

import model.Alumno;
import model.Catedra;
import model.Materia;
import model.Universidad;
import model.interfaces.AlumnoIMPL;
import model.interfaces.MateriaIMPL;


public class UniversidadTest extends TestCase{
	public void testMateriasInscribibles() throws Exception {
		Materia materia1 = new Materia("");
		Materia materia2 = new Materia("");
		Catedra catedra = new Catedra("", materia1);
		Alumno alumno = new Alumno("");
		
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
