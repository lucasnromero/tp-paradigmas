package testClases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import paradigmas.turismo.models.*;

import org.junit.Test;

public class testUsuario {

	@Test
	public void descuentoTiempoYDineroAtraccion() {
		Usuario usuarioEsperado = new Usuario("Iron Man",92,380,"Aventura");
		Usuario usuarioObtenido = new Usuario("Iron Man",100,1000,"Aventura");
		
		Atraccion atraccion1 = new Atraccion("El Reino de Wakanda",250,2,20,"Aventura");
		Atraccion atraccion2 = new Atraccion("El Oasis de Gamora",120,1,30,"Aventura");
		Atraccion atraccion3 = new Atraccion("El Templo de la Viuda Negra",250,5,15,"Aventura");
		
		usuarioObtenido.disminuirDinero(atraccion1.getCostoVisita());
		usuarioObtenido.disminuirDinero(atraccion2.getCostoVisita());
		usuarioObtenido.disminuirDinero(atraccion3.getCostoVisita());
		
		usuarioObtenido.disminuirTiempoDisponible(atraccion1.getPromedioDeTiempo());
		usuarioObtenido.disminuirTiempoDisponible(atraccion2.getPromedioDeTiempo());
		usuarioObtenido.disminuirTiempoDisponible(atraccion3.getPromedioDeTiempo());
		
		assertEquals(usuarioEsperado, usuarioObtenido);
	}
	
	@Test
	public void descuentoTiempoYDineroAPromocion() {
		Usuario usuarioEsperado = new Usuario("Iron Man",92,400,"Aventura");
		Usuario usuarioObtenido = new Usuario("Iron Man",100,1000,"Aventura");
		
		List <Atraccion> atracciones1 = new ArrayList<Atraccion>();
		atracciones1.add(new Atraccion("Excursión a la cascada",250,2,20,"Aventura"));
		atracciones1.add(new Atraccion("Paseo en carruaje por la ciudad",120,1,30,"Aventura"));
		atracciones1.add(new Atraccion("Excursión al bosque",250,5,15,"Aventura"));
		Promocion promocion = new PromocionAbsoluta(atracciones1, 20);

		usuarioObtenido.disminuirDinero(promocion.getCostoTotal());
		
		usuarioObtenido.disminuirTiempoDisponible(promocion.getTiempoTotal());

		assertEquals(usuarioEsperado, usuarioObtenido);
	}

}
