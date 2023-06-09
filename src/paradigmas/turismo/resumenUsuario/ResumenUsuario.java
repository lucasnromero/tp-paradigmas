package paradigmas.turismo.resumenUsuario;

import java.util.ArrayList;
import java.util.List;
import paradigmas.turismo.models.Atraccion;
import paradigmas.turismo.models.Promocion;
import paradigmas.turismo.models.Usuario;

public class ResumenUsuario {

	private List<Atraccion> atraccionesCompradas;
	private List<Promocion> promocionesCompradas;

	private Usuario usuario;
	private int gastoTotal;
	private double tiempoTotal;

	public ResumenUsuario(final Usuario usuario) {

		super();

		this.atraccionesCompradas = new ArrayList<Atraccion>();
		this.promocionesCompradas = new ArrayList<Promocion>();
		this.usuario = usuario;
	}

	private void setGastoTotal() {

		this.gastoTotal = 0;

		for (Atraccion atraccion : this.atraccionesCompradas)
			this.gastoTotal += atraccion.getCostoVisita();

		for (Promocion promocion : this.promocionesCompradas)
			this.gastoTotal += promocion.getCostoTotal();
	}

	private void setTiempoTotal() {

		this.tiempoTotal = 0;

		for (Atraccion atraccion : this.atraccionesCompradas)
			this.tiempoTotal += atraccion.getPromedioDeTiempo();

		for (Promocion promocion : this.promocionesCompradas)
			this.tiempoTotal += promocion.getTiempoTotal();
	}

	public List<Atraccion> getAtraccionesCompradas() {
		return this.atraccionesCompradas;
	}

	public void agregarAtraccion(final Atraccion atraccion) {
		this.atraccionesCompradas.add(atraccion);
		this.usuario.disminuirDinero(atraccion.getCostoVisita());
		this.usuario.disminuirTiempoDisponible(atraccion.getPromedioDeTiempo());
		atraccion.reducirCupo();
	}

	public List<Promocion> getPromocionesCompradas() {
		return this.promocionesCompradas;
	}

	public void agregarPromocion(final Promocion promocion) {
		this.promocionesCompradas.add(promocion);
		this.usuario.disminuirDinero(promocion.getCostoTotal());
		this.usuario.disminuirTiempoDisponible(promocion.getTiempoTotal());
		promocion.reducirCupo();
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public int getGastoTotal() {
		return this.gastoTotal;
	}

	public double getTiempoTotal() {
		return this.tiempoTotal;
	}

	public void crearResumenUsuario() {
		this.setGastoTotal();
		this.setTiempoTotal();
	}

	
	public void mostrarResumen() {
		
		System.out.println("\n*USUARIO: " + usuario.getNombreUsuario());
		
		if(!this.promocionesCompradas.isEmpty()){
			System.out.println("\nUsted Compró las siguientes promociones: ");
		}
		
		for(Promocion promocion: this.promocionesCompradas) {
			System.out.println("\n" + promocion.toString());
		}
		
		if(!this.atraccionesCompradas.isEmpty()) {
			System.out.println("\n*Usted Compró las siguientes atracciones:");
		}
		
		for(Atraccion atraccion: this.atraccionesCompradas) {
			System.out.println(atraccion.toString());
		}
		
		System.out.println("\n*Gastó en total: " + this.gastoTotal); 
		System.out.println("*Tiempo a invertir: " + this.tiempoTotal); 
		
	}


}
