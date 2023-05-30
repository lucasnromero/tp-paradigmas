package unlam.turismo.models;

public class Atraccion extends Resumen {

	private int id;
	private TipoDeAtraccion tipoDeAtraccion;

	public Atraccion(String nombre, double costo, double tiempo, int cupo, int id, TipoDeAtraccion tipoDeAtraccion) {
		
		super(nombre, costo, tiempo, cupo);

		this.id = id;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

}
