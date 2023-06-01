package unlam.turismo.sugerencia;

import java.util.ArrayList;
import java.util.List;

import unlam.turismo.models.Atraccion;
import unlam.turismo.models.Promocion;

public class Sugerencia {
	
	private List<Promocion> listaPromociones = new ArrayList<Promocion>();
	private List<Atraccion> listaAtracciones = new ArrayList<Atraccion>();
	
	public Sugerencia(List<Promocion> listaPromociones, List<Atraccion> listaAtracciones) {
		
		super();
		
		this.listaPromociones = listaPromociones;
		this.listaAtracciones = listaAtracciones;
		
	}	
	
	public Sugerencia() {
		
	}
	public void setListaPromociones(List<Promocion> promociones) {
		this.listaPromociones = promociones;
	}
	
	public void setListaAtracciones(List<Atraccion> atracciones) {
		this.listaAtracciones = atracciones;
	}

	public List<Promocion> getListaPromociones() {
		return listaPromociones;
	}
	
	public List<Atraccion> getListaAtracciones() {
		return listaAtracciones;
	}
}
