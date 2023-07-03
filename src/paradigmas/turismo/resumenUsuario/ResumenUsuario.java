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
		this.usuario.compraAtraccion(atraccion.getCostoVisita(), atraccion.getPromedioDeTiempo());
//		this.usuario.disminuirDinero(atraccion.getCostoVisita());
//		this.usuario.disminuirTiempoDisponible(atraccion.getPromedioDeTiempo());

	}

	public List<Promocion> getPromocionesCompradas() {
		return this.promocionesCompradas;
	}

	public void agregarPromocion(final Promocion promocion) {
		this.promocionesCompradas.add(promocion);
		this.usuario.compraAtraccion(promocion.getCostoTotal(), promocion.getTiempoTotal());

//		this.usuario.disminuirDinero(promocion.getCostoTotal());
//		this.usuario.disminuirTiempoDisponible(promocion.getTiempoTotal());
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
		System.out.println(
				"\n******************************************************************************************");
		System.out.println("\u001B[1mRESUMEN DE COMPRA\u001B[0m \n ");

		System.out.println("\u001B[1mUSUARIO:\u001B[0m " + usuario.getNombreUsuario());

		if (!this.promocionesCompradas.isEmpty()) {
			System.out.println("\n\u001B[1mUsted compró las siguientes promociones: \u001B[0m");
		}

		for (Promocion promocion : this.promocionesCompradas) {
			System.out.println("\n" + promocion.toStringUI());
		}

		if (!this.atraccionesCompradas.isEmpty()) {
			System.out.println("\n\u001B[1mUsted compró las siguientes atracciones:\u001B[0m\n");
		}

		for (Atraccion atraccion : this.atraccionesCompradas) {
			System.out.println(atraccion.toStringUI());
		}

		System.out.println("\n\u001B[1m\u2022 Gastó en total: \u001B[0m" + this.gastoTotal);
		System.out.println("\u001B[1m\u2022 Tiempo a invertir \u001B[0m: " + this.tiempoTotal + " horas");

		System.out.println("\u001B[1m\n¡GRACIAS POR COMPRAR CON NOSOTROS!\u001B[0m \n ");
		System.out.println(
				"********************************************************************************************\n");

	}

	public boolean sugerenciaDisponible() {

		if (this.atraccionesCompradas.size() == 0 && this.promocionesCompradas.size() == 0) {
			System.out.println("\nNo es posible hacerle una sugerencia de compra.");
			System.out.println("Fin de la compra.\n");
			System.out.println(
					"********************************************************************************************\n");
			return false;
		}

		return true;
	}

}
