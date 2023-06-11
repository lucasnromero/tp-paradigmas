package unlam.turismo.consola;

import unlam.turismo.models.Usuario;
import unlam.turismo.sugerencia.Sugerencia;

public class ManejoConsola {

	private Sugerencia sugerencia;
	private Usuario usuario;

	private ManejoConsola(Sugerencia sugerencia, Usuario usuario) {
		this.sugerencia = sugerencia;
		this.usuario = usuario;
	}
	
	public static void iniciarProcesamiento() {
		
		System.out.println("Bienvenido/a al Turismo en la Tierra Media");
		
		
		
	}
	
	
}
