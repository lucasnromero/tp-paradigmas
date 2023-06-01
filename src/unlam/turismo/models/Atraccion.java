package unlam.turismo.models;

public class Atraccion extends Resumen {

	private int id;
	private TipoDeAtraccion tipoDeAtraccion;

	public Atraccion(String nombre, double costo, double tiempo, int cupo, int id, TipoDeAtraccion tipoDeAtraccion) {
		
		super(nombre, costo, tiempo, cupo);

		this.id = id;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	@Override
	public String toString() {
		return "Atraccion [id=" + id + ", tipoDeAtraccion=" + tipoDeAtraccion + ", nombre=" + nombre + ", costo="
				+ costo + ", tiempo=" + tiempo + ", cupo=" + cupo + "]";
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public int getId() {
		return this.id;
	}
	public double getCosto() {
		return this.costo;
	}
	
	public double getTiempo() {
		return this.tiempo;
	}
	public void leerAtraccion() {
		System.out.println("Nombre: " + "[" +this.nombre + "]");
		System.out.println("- Precio: $" + this.costo);
		System.out.println("- Duración: " +this.tiempo +" horas");
	}

}
