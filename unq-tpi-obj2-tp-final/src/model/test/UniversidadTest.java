package model.test;



import junit.framework.TestCase;
import universidad.Universidad;

//@SuppressWarnings("unused")
public class UniversidadTest extends TestCase {

	public void testMateriasInscribibles() throws Exception {

		/* Creo la Universidad */
		Utils.GeneradorDeDatos.loadDataSystem();
		Universidad universidad = Universidad.getInstance();
		assertNotNull("La universidad se creo correctamente", Universidad.getInstance());

		/* Agrego una Oficina de Alumnos a la universidad */
		assertNotNull("Existe una Oficina de Alumnos en la Universidad",
				universidad.getOficinaDeAlumnos());

		/* Creo un Area de la Universidad */
		assertNotNull("Existe una Area en la Universidad", universidad.getAreas());

		/* Ingreso un Docente y un Alumno al sistema */
		assertNotNull("Existe un Docente registrado en la Universidad", universidad
				.getOficinaDeAlumnos().getDocentes());
		assertNotNull("Existe un Alumno registrado en la Universidad", universidad
				.getOficinaDeAlumnos().getAlumnos());

		/* Creo una Carrera */
		assertNotNull("Existe la carrera en la Universidad", universidad.getCarreras());

		/* Asocio un Plan de Estudio que pertenece a una Carrera */
		// assertNotNull("La carrera tiene un Plan de Estudio",
		// carreraTPI.getPlanesVigentes());

		/* Creo Materias y Catedras */
		// assertEquals("Verifico que se cargo la materia en el area",ingles1,idiomas.getMateriasDictadas().getElemento(new
		// Date()));

		// assertTrue("el alumno no esta inscripto en materias",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));

		/* Inscribo al alumno para que curse una materia */
		// assertTrue("El alumno esta inscripto en una materia",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));
		// assertTrue("El alumno esta inscripto en Analisis",alumno1.estaInscripto(analisis1));
	}

}
