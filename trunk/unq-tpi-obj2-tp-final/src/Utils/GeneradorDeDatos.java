package Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

/**
 * Genero los datos minimos de las Clases
 */
@SuppressWarnings("unused")
public class GeneradorDeDatos {

	private static final String AREA_MATEMATICA = "Matematicas";
	private static final String AREA_FISICA = "Fisica";
	private static final String AREA_IDIOMA = "Idiomas";

	private static final String CARRERA_VIEJA = "Carrera Vieja";
	private static final String CARRERA_NUEVA = "Carrera Nueva";
	private static final String PLAN_DE_ESTUDIO = "Plan Nuevo";

	private static final String MATERIA_INGLES_I = "Ingles I";
	private static final String MATERIA_ANALISIS_I = "Analisis I";

	private static final String CATEDRA_INGLES_1 = "Duch";
	private static final String CATEDRA_ANALISIS_1 = "Baragati";

	/** Cargo el sistema con Datos para que funcione */
	public static void loadDataSystem() {
		initUniversidad();
		initArea();
		initCargarPersonas();

		// initCarreraYPlanDeEstudio();
		// initMateriaYCatedra();
		// inscribirAlumnoEnCatedra();
	}

	/** Lista de datos personales de Alumnos */
	private static List<Persona> listaAlumnos() {
		List<Persona> alumnos = new ArrayList<Persona>();

		alumnos.add(new Persona(32640573, "Mariano", "Prieto", "M"));
		alumnos.add(new Persona(18597326, "Toto", "Gomez", "M"));
		alumnos.add(new Persona(26418759, "Julian", "Perez", "M"));
		alumnos.add(new Persona(23658974, "Agustin", "Diaz", "M"));
		alumnos.add(new Persona(41578942, "Pocho", "Goncalez", "M"));

		return alumnos;
	}

	/** Lista de datos personales de Docentes */
	private static List<Persona> listaDocentes() {
		List<Persona> docentes = new ArrayList<Persona>();

		docentes.add(new Persona(1345672, "Juan", "Petrolas", "M"));
		docentes.add(new Persona(12345678, "Pablo", "Lopez", "M"));
		docentes.add(new Persona(21587149, "Eduardo", "Frente", "M"));

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

	private static void inscribirAlumnoEnCatedra() {

		PlanDeEstudio planDeEstudio = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, Universidad
				.getInstance().getAreas().toArray());

		/* Inscribo a un alumno en una carrera */
		OficinaAlumnos oficinaDeAlumnos = Universidad.getInstance().getOficinaDeAlumnos();

		Alumno[] alumnos = (Alumno[]) oficinaDeAlumnos.getAlumnos().toArray();
		if (alumnos.length > 0) {
			Alumno alumno = alumnos[0];
			alumno.setCursoDeIngreso(true);
			oficinaDeAlumnos.inscribirAlumnoEnCarrera(alumno, planDeEstudio);

			/* Inscribo al alumno para que curse una materia */
			Materia analisis1 = (Materia) buscar(MATERIA_ANALISIS_I, Universidad.getInstance()
					.getMaterias().toArray());
			Catedra catedraAnalisis1 = ((Catedra[]) analisis1.getCatedras().toArray())[0];

			// alumno.inscribirEnMateria(new InscripcionMateria(analisis1,
			// catedraAnalisis1, alumno));
			new InscripcionMateria(analisis1, catedraAnalisis1, alumno);
		}

	}

	/** Creo una Carrera */
	private static void initCarreraYPlanDeEstudio() {
		Carrera carreraVieja = new Carrera(CARRERA_VIEJA);
		Carrera carreraNueva = new Carrera(CARRERA_NUEVA);

		Universidad.getInstance().addCarrera(carreraVieja);
		Universidad.getInstance().addCarrera(carreraNueva);

		// initPlanDeEstudio(carreraNueva,PLAN_DE_ESTUDIO);
	}

	/** Creo una Plan de Estudio Nuevo para una Carrera existente */
	private static void initPlanDeEstudio(Carrera carrera, String nombrePlan) {

		Docente[] docentes = (Docente[]) Universidad.getInstance().getOficinaDeAlumnos()
				.getDocentes().toArray();
		if (docentes.length > 0) {
			/* Creo Planes de Estudio para una Carrera */
			carrera.addPlanDeEstudio(new PlanDeEstudio(nombrePlan, new Date(), docentes[0]), true);
		}

	}

	/** Creo una Materias y Catedras */
	private static void initMateriaYCatedra() {
		/* Creo Materias y Catedras */
		Materia analisis1 = new Materia(MATERIA_ANALISIS_I, 3);
		analisis1.setHorasSemanales(8);
		// analisis1.setPromocionable(false);
		new Catedra(CATEDRA_ANALISIS_1, analisis1);

		Materia ingles1 = new Materia(MATERIA_INGLES_I, 2);
		ingles1.setHorasSemanales(4);
		ingles1.setPromocionable(true);
		new Catedra(CATEDRA_INGLES_1, ingles1);

		/* Agrego Materias a las Areas */
		Area areaIdioma = (Area) buscar(AREA_IDIOMA, Universidad.getInstance().getAreas().toArray());
		Area areaMatematica = (Area) buscar(AREA_MATEMATICA, Universidad.getInstance().getAreas()
				.toArray());

		areaIdioma.addMateria(ingles1, new Date());
		areaMatematica.addMateria(analisis1, new Date());

		/* Agrego las materias al Plan de Estudio */
		PlanDeEstudio planDeEstudio = (PlanDeEstudio) buscar(PLAN_DE_ESTUDIO, Universidad
				.getInstance().getAreas().toArray());

		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(analisis1, new Obligatoria(),
				new Cuatrimestral()));
		planDeEstudio.addMaterias(new MateriaAsignadaAPlanDeEstudio(ingles1, new Optativa(),
				new Anual()));
	}

	/** Metodo que ayuda a encontrar objectos en una lista de elementos */
	private static Nombrable buscar(String nombre, Object[] lista) {
		Nombrable objetoBuscado = null;
		Nombrable[] objetos = (Nombrable[]) lista;

		for (Nombrable objeto : objetos) {
			if (objeto.getNombre().equals(nombre)) {
				objetoBuscado = objeto;
			}
		}

		return objetoBuscado;
	}

	// private static Carrera buscarCarrera(String nombre) {
	// Carrera carreraBuscado = null;
	// Carrera[] carreras = (Carrera[])
	// Universidad.getInstance().getCarreras().toArray();
	//
	// for (Carrera carrera: carreras) {
	// if(carrera.getNombre().equals(nombre)){
	// carreraBuscado = carrera;
	// }
	// }
	//
	// return carreraBuscado;
	// }

}
