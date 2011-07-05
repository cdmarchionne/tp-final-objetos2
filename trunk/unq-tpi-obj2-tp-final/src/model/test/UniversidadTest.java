package model.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utils.GeneradorDeDatos;

import junit.framework.TestCase;

import materias.Anual;
import materias.Catedra;
import materias.Cuatrimestral;
import materias.InscripcionMateria;
import materias.Materia;
import materias.MateriaAsignadaAPlanDeEstudio;
import materias.Obligatoria;
import materias.Optativa;
import personal.Alumno;
import personal.Docente;
import personal.Persona;
import universidad.Area;
import universidad.Carrera;
import universidad.OficinaAlumnos;
import universidad.PlanDeEstudio;
import universidad.Universidad;

@SuppressWarnings("unused")
public class UniversidadTest extends TestCase{

	public void testMateriasInscribibles() throws Exception {
		
		/* Creo la Universidad */
		Utils.GeneradorDeDatos.loadDataSystem();
		Universidad universidad = Universidad.getInstance();
		assertNotNull("La universidad se creo correctamente", Universidad.getInstance());
		
		/* Agrego una Oficina de Alumnos a la universidad */
		assertNotNull("Existe una Oficina de Alumnos en la Universidad", universidad.getOficinaDeAlumnos());

		/* Creo un Area de la Universidad */
		assertNotNull("Existe una Area en la Universidad", universidad.getAreas());

		/* Ingreso un Docente y un Alumno al sistema */
		assertNotNull("Existe un Docente registrado en la Universidad", universidad.getOficinaDeAlumnos().getDocentes());
		assertNotNull("Existe un Alumno registrado en la Universidad", universidad.getOficinaDeAlumnos().getAlumnos());

		/* Creo una Carrera */
		assertNotNull("Existe la carrera en la Universidad", universidad.getCarreras());
		
		
		/* Asocio un Plan de Estudio que pertenece a una Carrera */
//		assertNotNull("La carrera tiene un Plan de Estudio", carreraTPI.getPlanesVigentes());
		
		/* Creo Materias y Catedras */
//		assertEquals("Verifico que se cargo la materia en el area",ingles1,idiomas.getMateriasDictadas().getElemento(new Date()));
		
//		assertTrue("el alumno no esta inscripto en materias",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));
		
		/* Inscribo al alumno para que curse una materia */
//		assertTrue("El alumno esta inscripto en una materia",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));
//		assertTrue("El alumno esta inscripto en Analisis",alumno1.estaInscripto(analisis1));
	}

//	public void testMateriasInscribibles() throws Exception {
//		Persona directorOA = new Persona(1345672, "Juan", "Petrolas", "M");
//		Persona directorCarrera = new Persona(12345678, "Pablo", "Lopez", "M");
//		Persona alumnoPromedio = new Persona(32640573, "Mariano", "Prieto", "M");
//		
//		/* Creo la Universidad */
//		Universidad universidad = Universidad.getInstance("UNQ", directorOA);
//		assertNotNull("La universidad se creo correctamente", Universidad.getInstance());
//		
//		/* Agrego una Oficina de Alumnos a la universidad */
//		OficinaAlumnos oficinaDeAlumnos = universidad.getOficinaDeAlumnos();
//		assertNotNull("Existe una Oficina de Alumnos en la Universidad", universidad.getOficinaDeAlumnos());
//
//		/* Creo un Area de la Universidad */
//		Area idiomas = new Area("Idiomas");
//		universidad.addArea(idiomas);
//		assertNotNull("Existe una Area en la Universidad", universidad.getAreas());
//
//		/* Ingreso un Docente y un Alumno al sistema */
//		oficinaDeAlumnos.nuevoDocente(directorCarrera);
//		oficinaDeAlumnos.nuevoAlumno(alumnoPromedio);
//		assertNotNull("Existe un Docente registrado en la Universidad", universidad.getOficinaDeAlumnos().getDocentes());
//		assertNotNull("Existe un Alumno registrado en la Universidad", universidad.getOficinaDeAlumnos().getAlumnos());
//
//		/* Creo una Carrera */
//		Carrera carreraTPI = new Carrera("TPI");
//		
//		/* Agrego la Carrera a la Universidad */
//		universidad.addCarrera(carreraTPI);
//		assertNotNull("Existe la carrera en la Universidad", universidad.getCarreras());
//		
//		/* Creo Planes de Estudio para una Carrera */
//		Object[] docentes = oficinaDeAlumnos.getDocentes().toArray();
//		Docente docente1 = (Docente) docentes[docentes.length-1];
//		PlanDeEstudio planDeEstudio = new PlanDeEstudio("Plan Nuevo", new Date(), docente1);
//		
//		/* Asocio un Plan de Estudio que pertenece a una Carrera */
//		carreraTPI.addPlanDeEstudio(planDeEstudio,true);
//		assertNotNull("La carrera tiene un Plan de Estudio", carreraTPI.getPlanesVigentes());
//		
//		/* Creo Materias y Catedras */
//		Materia analisis1 = new Materia("Analisis I",3);
//		analisis1.setHorasSemanales(8);
//		//analisis1.setPromocionable(false);
//		Catedra catedraAnalisis1 = new Catedra("Baragati",analisis1);
//
//		Materia ingles1 = new Materia("Ingles I", 2);
//		ingles1.setHorasSemanales(4); 
//		ingles1.setPromocionable(true);
//		Catedra catedraIngles1= new Catedra("Duch",ingles1);
//		
//		/* Agrego una Materia en un Area*/
//		idiomas.getMateriasDictadas().addAntecedente(new Date(), null, ingles1);
//		assertEquals("Verifico que se cargo la materia en el area",ingles1,idiomas.getMateriasDictadas().getElemento(new Date()));
//		
//		/* Agrego las materias al Plan de Estudio */
//		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(analisis1, new Obligatoria(), new Cuatrimestral()));
//		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(ingles1, new Optativa(), new Anual()));
//		
//		/* Inscribo a un alumno en una carrera */
//		Object[] alumnos = oficinaDeAlumnos.getAlumnos().toArray();
//		Alumno alumno1 = (Alumno) alumnos[alumnos.length-1];
//		alumno1.setCursoDeIngreso(true);
//		universidad.getOficinaDeAlumnos().inscribirAlumnoEnCarrera(alumno1, planDeEstudio);
//		
//		//El alumno no se inscribio en materias
//		List<Materia> materiasInscribibles= new ArrayList<Materia>();
//		materiasInscribibles.add(analisis1);
//		materiasInscribibles.add(ingles1);
//		assertTrue("el alumno no esta inscripto en materias",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));
//		
//		/* Inscribo al alumno para que curse una materia */
//		alumno1.inscribirEnMateria(new InscripcionMateria(analisis1, catedraAnalisis1, alumno1));
//		materiasInscribibles.remove(analisis1);
//		assertTrue("El alumno esta inscripto en una materia",alumno1.getMateriasInscribibles().containsAll(materiasInscribibles));
//		assertTrue("El alumno esta inscripto en Analisis",alumno1.estaInscripto(analisis1));
//	}
	
}
