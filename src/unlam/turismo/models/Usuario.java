package unlam.turismo.models;

public class Usuario {
	
	private int id;
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private TipoDeAtraccion atraccionPreferida;
	private ResumenUsuario resumenUsuario;
	
	public Usuario(int id, String nombre, double presupuesto, double tiempo, TipoDeAtraccion atraccionPreferida,
			ResumenUsuario resumenUsuario) {
		
		this.id = id;
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atraccionPreferida = atraccionPreferida;
		this.resumenUsuario = null;
	}

	public Usuario() {
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempo() {
		return tiempo;
	}

	public TipoDeAtraccion getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public ResumenUsuario getResumenUsuario() {
		return resumenUsuario;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public void setAtraccionPreferida(TipoDeAtraccion atraccionPreferida) {
		this.atraccionPreferida = atraccionPreferida;
	}

	public void setResumenUsuario(ResumenUsuario resumenUsuario) {
		this.resumenUsuario = resumenUsuario;
	}
	
	public void leerUsuario() {
		System.out.println("ID:" + this.id);
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Tipo de atracción preferida: " + this.atraccionPreferida);
		System.out.println("Presupuesto: " + this.presupuesto);
		System.out.println("Tiempo disponible: " + this.tiempo);
		
	}
	
	
	
}
