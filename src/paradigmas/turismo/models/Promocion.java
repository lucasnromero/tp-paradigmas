package paradigmas.turismo.models;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Promocion implements Comparable<Promocion> {

	private List<Atraccion> listaAtracciones;

	public Promocion(final List<Atraccion> listaAtracciones) {

		super();

		this.listaAtracciones = listaAtracciones;
	}

	public int getCostoTotal() {

		int costoTotal = 0;

		for (Atraccion atraccion : this.listaAtracciones)
			costoTotal += atraccion.getCostoVisita();

		return costoTotal;
	}

	public double getTiempoTotal() {

		double tiempoTotal = 0;

		for (Atraccion atraccion : this.listaAtracciones)
			tiempoTotal += atraccion.getPromedioDeTiempo();

		return tiempoTotal;
	}

	public int getCupoTotal() {

		int cupoTotal = 0;

		for (Atraccion atraccion : this.listaAtracciones)
			cupoTotal += atraccion.getCupo();

		return cupoTotal;
	}

	public boolean hayCupo() {

		for (Atraccion atraccion : this.listaAtracciones)
			if (atraccion.getCupo() == 0)
				return false;

		return true;
	}

	public String getTipoAtracciones() {
		return this.listaAtracciones.get(0).getTipoAtraccion();
	}

	public List<Atraccion> getAtracciones() {
		return this.listaAtracciones;
	}

	public void reducirCupo() {

		for (Atraccion atraccion : this.listaAtracciones)
			atraccion.reducirCupo();
	}
	
	public boolean mismoCupo(Promocion other) { //para test

		for(Atraccion atraccionOther : other.listaAtracciones) {
			for (Atraccion atraccionThis : this.listaAtracciones) {
				if(atraccionOther.getNombreAtraccion() == atraccionThis.getNombreAtraccion() && atraccionOther.getCupo() != atraccionThis.getCupo()){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "PACK " + this.getTipoAtracciones() + "\n" + "-Atracciones incluidas: " + Arrays.toString(this.getNombresAtracciones()) + "\n";
	}
	
	@Override
	public boolean equals(Object obj) { //para test
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promocion other = (Promocion) obj;
		if(!Objects.equals(this.toString(), other.toString()))
			return false;
		
		return this.mismoCupo(other);
				
	}

	public String[] getNombresAtracciones() {

		String[] nombresAtracciones = new String[this.listaAtracciones.size()];
		int i = 0;

		for (Atraccion atraccion : this.listaAtracciones) {
			nombresAtracciones[i] = atraccion.getNombreAtraccion();
			i++;
		}

		return nombresAtracciones;
	}

}
