package unlam.turismo.models;

public class Resumen {

	protected String nombre;
	protected double costo;
	protected double tiempo;
	protected int cupo;

	public Resumen(String nombre, double costo, double tiempo, int cupo) {
		
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
	}

}
