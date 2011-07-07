package Utils;

public class IngresoNoAprobadoExcepcion extends Exception {
	
	
	public IngresoNoAprobadoExcepcion(){
		new Exception("No se puede inscribir el alumno, no aprobo el curso de ingreso aun"); 
	}

}
