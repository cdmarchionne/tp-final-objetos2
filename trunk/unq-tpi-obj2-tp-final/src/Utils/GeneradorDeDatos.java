package Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import materias.Anual;
import materias.Catedra;
import materias.Cuatrimestral;
import materias.Materia;
import materias.MateriaAsignadaAPlanDeEstudio;
import materias.Obligatoria;
import materias.Optativa;
import model.interfaces.MateriaIMPL;
import personal.Alumno;
import personal.Docente;
import personal.Persona;
import universidad.Area;
import universidad.Carrera;
import universidad.OficinaAlumnos;
import universidad.PlanDeEstudio;
import universidad.Universidad;

/**
 * Genero los datos minimos de las Clases
 */
public class GeneradorDeDatos {

	public static final int NOTA_MATERIA_PROMOCIONADA = 7;
	public static final int NOTA_MATERIA_APROBADA = 4;

	private static final int DNI_ALUMNO1 = 32640573;
	private static final int DNI_DOC1 = 1345672;
	private static final int DNI_DOC2 = 12345678;
	private static final int DNI_DOC3 = 21587149;

	private static final String APELLIDO_ALUMNO1 = "Prieto";
	private static final String APELLIDO_DOC1 = "Petrolas";
	private static final String APELLIDO_DOC2 = "Lopez";
	private static final String APELLIDO_DOC3 = "Frente";

	private static final String NOMBRE_ALUMNO1 = "Mariano";
	private static final String NOMBRE_DOC1 = "Juan";
	private static final String NOMBRE_DOC2 = "Pablo";
	private static final String NOMBRE_DOC3 = "Eduardo";

	private static final String AREA_MATEMATICA = "Matematicas";
	private static final String AREA_FISICA = "Fisica";
	private static final String AREA_IDIOMA = "Idiomas";

	private static final String CARRERA_VIEJA = "Carrera Vieja";
	private static final String CARRERA_NUEVA = "Carrera Nueva";
	private static final String PLAN_DE_ESTUDIO = "Plan Nuevo";

	private static final String MATERIA_INGLES_I = "Ingles I";
	private static final String MATERIA_INGLES_II = "Ingles II";
	private static final String MATERIA_ANALISIS_I = "Analisis I";
	private static final String MATERIA_ANALISIS_II = "Analisis II";

	private static final String CATEDRA_INGLES_1 = "Grieta";
	private static final String CATEDRA_INGLES_2 = "Duch";
	private static final String CATEDRA_ANALISIS_1 = "Serra";
	private static final String CATEDRA_ANALISIS_2 = "Baragati";

	/** Cargo el sistema con Datos para que funcione */
	public static void loadDataSystem() {
		initUniversidad();
		initArea();
		initCargarPersonas();

		initCarreraYPlanDeEstudio();
		initMatematicas();
		initIdiomas();
		inscribirAlumnoEnCarrera();
		inscribirAlumnoEnCatedra();
	}

	/** Lista de datos personales de Alumnos */
	private static List<Persona> listaAlumnos() {
		List<Persona> alumnos = new ArrayList<Persona>();

		alumnos.add(new Persona(DNI_ALUMNO1, NOMBRE_ALUMNO1, APELLIDO_ALUMNO1, "M"));
		alumnos.add(new Persona(18597326, "Toto", "Gomez", "M"));
		alumnos.add(new Persona(26418759, "Julian", "Perez", "M"));
		alumnos.add(new Persona(23658974, "Agustin", "Diaz", "M"));
		alumnos.add(new Persona(41578942, "Pocho", "Goncalez", "M"));

		return alumnos;
	}

	/** Lista de datos personales de Docentes */
	private static List<Persona> listaDocentes() {
		List<Persona> docentes = new ArrayList<Persona>();

		docentes.add(new Persona(DNI_DOC1, NOMBRE_DOC1, APELLIDO_DOC1, "M"));
		docentes.add(new Persona(DNI_DOC2, NOMBRE_DOC2, APELLIDO_DOC2, "M"));
		docentes.add(new Persona(DNI_DOC3, NOMBRE_DOC3, APELLIDO_DOC3, "M"));

		return docentes;
	}

	/** Creo la Universidad */
	private static void initUniversidad() {
		Universidad.getInstance("UNQ", listaDocentes().get(0));
	}

	/** Creo un Area de la Universidad */
	private static void initArea() {
		Universidad.getInstance().addArea(new Area(AREA_IDIOMA));
		Universidad.getInstance().addArea(new Area(AREA_FISICA));
		Universidad.getInstance().addArea(new Area(AREA_MATEMATICA));
	}

	/** Ingreso Alumnos y Docentes al sistema */
	private static void initCargarPersonas() {
		OficinaAlumnos oficinaDeAlumnos = Universidad.getInstance().getOficinaDeAlumnos();

		if (oficinaDeAlumnos.getDocentes().isEmpty()) {
			for (Persona datosDocente : listaDocentes()) {
				oficinaDeAlumnos.nuevoDocente(datosDocente);
			}
		}

		if (oficinaDeAlumnos.getAlumnos().isEmpty()) {
			for (Persona datosAlumno : listaAlumnos()) {
				oficinaDeAlumnos.nuevoAlumno(datosAlumno);
			}
		}
	}

	private static void inscribirAlumnoEnCarrera() {

		OficinaAlumnos oficinaDeAlumnos = Universidad.getInstance().getOficinaDeAlumnos();
		PlanDeEstudio plan = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, oficinaDeAlumnos
				.getPlanesDeEstudio().toArray());

		/* Inscribo a un alumno en una carrera */
		for (Alumno alumno : oficinaDeAlumnos.getAlumnos()) {
			alumno.setCursoDeIngreso(true);
			oficinaDeAlumnos.inscribirAlumnoEnCarrera(alumno, plan);
		}

	}

	private static void inscribirAlumnoEnCatedra() {

		Alumno alumno1 = (Alumno) buscar(NOMBRE_ALUMNO1, Universidad.getInstance().getAlumnos()
				.toArray());
		PlanDeEstudio plan = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, Universidad.getInstance()
				.getPlanesDeEstudio(alumno1).toArray());

		/* Inscribo al alumno para que curse una materia */
		List<MateriaIMPL> materiasInscribibles = Universidad.getInstance().materiasInscribibles(
				alumno1, plan);
		Materia ingles1 = (Materia) buscar(MATERIA_INGLES_I, materiasInscribibles.toArray());
		Catedra catedraIngles1 = (Catedra) buscar(CATEDRA_INGLES_1, ingles1.getTodasLasCatedras()
				.toArray());

		Materia analisis1 = (Materia) buscar(MATERIA_ANALISIS_I, materiasInscribibles.toArray());
		Catedra catedraAnalisis1 = (Catedra) buscar(CATEDRA_ANALISIS_1, analisis1
				.getTodasLasCatedras().toArray());

		Materia analisis2 = (Materia) buscar(MATERIA_ANALISIS_II, materiasInscribibles.toArray());
		Catedra catedraAnalisis2 = (Catedra) buscar(CATEDRA_ANALISIS_2, analisis2
				.getTodasLasCatedras().toArray());

		/* Inscribo al Alumno en una materia y se la apruebo */
		OficinaAlumnos oficinaDeAlumnos = Universidad.getInstance().getOficinaDeAlumnos();

		oficinaDeAlumnos.inscribirAlumnoEnCatedra(alumno1, catedraIngles1, ingles1, plan);
		alumno1.agregarMateriaAprobada(plan, ingles1, 8);

		oficinaDeAlumnos.inscribirAlumnoEnCatedra(alumno1, catedraAnalisis1, analisis1, plan);
		alumno1.agregarMateriaAprobada(plan, analisis1, 6);

		oficinaDeAlumnos.inscribirAlumnoEnCatedra(alumno1, catedraAnalisis2, analisis2, plan);
		alumno1.agregarMateriaAprobada(plan, analisis2, 4);
	}

	/** Creo una Carrera */
	private static void initCarreraYPlanDeEstudio() {

		Docente docente = (Docente) buscar(NOMBRE_DOC1, Universidad.getInstance()
				.getOficinaDeAlumnos().getDocentes().toArray());

		Carrera carreraVieja = new Carrera(CARRERA_VIEJA, docente);
		Carrera carreraNueva = new Carrera(CARRERA_NUEVA, docente);

		Universidad.getInstance().addCarrera(carreraVieja);
		Universidad.getInstance().addCarrera(carreraNueva);

		initPlanDeEstudio(carreraNueva, PLAN_DE_ESTUDIO);
	}

	/** Creo una Plan de Estudio Nuevo para una Carrera existente */
	private static void initPlanDeEstudio(Carrera carrera, String nombrePlan) {

		Docente docente = (Docente) buscar(NOMBRE_DOC1, Universidad.getInstance()
				.getOficinaDeAlumnos().getDocentes().toArray());

		/* Creo Planes de Estudio para una Carrera */
		carrera.addPlanDeEstudio(new PlanDeEstudio(nombrePlan, new Date(), docente), true);
	}

	/**
	 * Creo Materias Y Catedras .
	 * Las agrego a su correspondiente Area
	 * Las inscribo en un Plan de Estudio junto con sus correlatrividades
	 */
	private static void initMatematicas() {
		/* Creo Materias y Catedras */
		Materia analisis1 = new Materia(MATERIA_ANALISIS_I, 3);
		analisis1.setHorasSemanales(8);
		analisis1.setPromocionable(false);
		new Catedra(CATEDRA_ANALISIS_1, analisis1);

		Materia analisis2 = new Materia(MATERIA_ANALISIS_II, 4);
		analisis1.setHorasSemanales(8);
		analisis1.setPromocionable(false);
		new Catedra(CATEDRA_ANALISIS_2, analisis2);

		/* Agrego Materias a las Areas */
		Area areaMatematica = (Area) buscar(AREA_MATEMATICA, Universidad.getInstance().getAreas()
				.toArray());

		areaMatematica.addMateria(analisis1, new Date());
		areaMatematica.addMateria(analisis2, new Date());

		/* Agrego las materias al Plan de Estudio */
		PlanDeEstudio planDeEstudio = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, Universidad
				.getInstance().getOficinaDeAlumnos().getPlanesDeEstudio().toArray());

		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(analisis1, new Obligatoria(),
				new Cuatrimestral()));

		MateriaAsignadaAPlanDeEstudio analisis2AsignadaAPlan = new MateriaAsignadaAPlanDeEstudio(
				analisis2, new Optativa(), new Anual());
		analisis2AsignadaAPlan.addMateriaCorrelativa(analisis1);

		planDeEstudio.addMaterias(analisis2AsignadaAPlan);
	}

	/**
	 * Creo Materias Y Catedras .
	 * Las agrego a su correspondiente Area
	 * Las inscribo en un Plan de Estudio junto con sus correlatrividades
	 */
	private static void initIdiomas() {
		/* Creo Materias y Catedras */
		Materia ingles1 = new Materia(MATERIA_INGLES_I, 2);
		ingles1.setHorasSemanales(4);
		ingles1.setPromocionable(true);
		new Catedra(CATEDRA_INGLES_1, ingles1);

		Materia ingles2 = new Materia(MATERIA_INGLES_II, 3);
		ingles1.setHorasSemanales(5);
		ingles1.setPromocionable(true);
		new Catedra(CATEDRA_INGLES_2, ingles2);

		/* Agrego Materias a las Areas */
		Area areaIdioma = (Area) buscar(AREA_IDIOMA, Universidad.getInstance().getAreas().toArray());

		areaIdioma.addMateria(ingles1, new Date());
		areaIdioma.addMateria(ingles2, new Date());

		/* Agrego las materias al Plan de Estudio */
		PlanDeEstudio planDeEstudio = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, Universidad
				.getInstance().getOficinaDeAlumnos().getPlanesDeEstudio().toArray());

		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(ingles1, new Optativa(),
				new Anual()));

		MateriaAsignadaAPlanDeEstudio ingles2AsignadaAPlan = new MateriaAsignadaAPlanDeEstudio(
				ingles2, new Optativa(), new Anual());
		ingles2AsignadaAPlan.addMateriaCorrelativa(ingles1);

		planDeEstudio.addMaterias(ingles2AsignadaAPlan);
	}

	/** Metodo que ayuda a encontrar objectos en una lista de elementos */
	private static Object buscar(Object objetoBuscado, Object[] lista) {
		Object objetoEncontrado = null;
		Object[] objetos = lista;

		for (Object objeto : objetos) {
			if (((Nombrable) objeto).getNombre().equals(objetoBuscado)) {
				objetoEncontrado = objeto;
			}
		}

		return objetoEncontrado;
	}

}
