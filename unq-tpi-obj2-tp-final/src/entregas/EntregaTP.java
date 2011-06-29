package entregas;

import personal.Alumno;
import personal.Docente;

/**
 * TODO: description
 */
public class EntregaTP {
	private TrabajoPractico tp;
	private int nota;
	private Docente profesorCorrector;
	private Alumno alumno;
	

	
	public EntregaTP(TrabajoPractico tp,Alumno alumno){
		this.setTp(tp);
		this.setAlumno(alumno);
		this.setProfesorCorrector(null);// Se inicia en null ya que no hay ningun profesor quue lo haya corregido.
		this.setNota(0);//Se inicia en 0 ya que no se corrigio aun.
		//Faltaria ver como hacer para que al crear la EntregaTP se agregue a la lista de ENTREGASTPS de la CATEDRA, 

	}



	public TrabajoPractico getTp() {
		return tp;
	}



	public void setTp(TrabajoPractico tp) {
		this.tp = tp;
	}



	public int getNota() {
		return nota;
	}



	public void setNota(int nota) {
		this.nota = nota;
	}



	public Docente getProfesorCorrector() {
		return profesorCorrector;
	}



	public void setProfesorCorrector(Docente profesorCorrector) {
		this.profesorCorrector = profesorCorrector;
	}



	public Alumno getAlumno() {
		return alumno;
	}



	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
}
