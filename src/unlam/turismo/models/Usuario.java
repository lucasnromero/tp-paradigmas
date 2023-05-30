package unlam.turismo.models;

public class Usuario {
	
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private TipoDeAtraccion atraccionPreferida;
	private ResumenUsuario resumenUsuario;
	
	private Usuario(String nombre, double presupuesto, double tiempo, TipoDeAtraccion atraccionPreferida,
			ResumenUsuario resumenUsuario) {
		
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atraccionPreferida = atraccionPreferida;
		this.resumenUsuario = null;
	}

	public Usuario inicializarUsuarioDesdeArchivo() {
		return new Usuario(nombre, presupuesto, tiempo, atraccionPreferida, resumenUsuario);
	}
	
}
