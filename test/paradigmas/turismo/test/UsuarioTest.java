package paradigmas.turismo.test;

import paradigmas.turismo.models.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void descuentoTiempoYDineroAtraccion() {
		Usuario usuarioEsperado = new Usuario("Iron Man", 92, 380, "Aventura");
		Usuario usuarioObtenido = new Usuario("Iron Man", 100, 1000, "Aventura");

		Atraccion atraccion1 = new Atraccion("El Reino de Wakanda", 250, 2, "Aventura");
		Atraccion atraccion2 = new Atraccion("El Oasis de Gamora", 120, 1, "Aventura");
		Atraccion atraccion3 = new Atraccion("El Templo de la Viuda Negra", 250, 5, "Aventura");

		usuarioObtenido.compraAtraccion(atraccion1.getCostoVisita(), atraccion1.getPromedioDeTiempo());
		usuarioObtenido.compraAtraccion(atraccion2.getCostoVisita(), atraccion2.getPromedioDeTiempo());
		usuarioObtenido.compraAtraccion(atraccion3.getCostoVisita(), atraccion3.getPromedioDeTiempo());

		assertEquals(usuarioEsperado, usuarioObtenido);
	}

	@Test
	public void descuentoTiempoYDineroAPromocion() {
		Usuario usuarioEsperado = new Usuario("Iron Man", 92, 400, "Aventura");
		Usuario usuarioObtenido = new Usuario("Iron Man", 100, 1000, "Aventura");

		List<Atraccion> atracciones1 = new ArrayList<Atraccion>();
		atracciones1.add(new Atraccion("Excursión a la cascada", 250, 2, "Aventura"));
		atracciones1.add(new Atraccion("Paseo en carruaje por la ciudad", 120, 1, "Aventura"));
		atracciones1.add(new Atraccion("Excursión al bosque", 250, 5, "Aventura"));
		Promocion promocion = new PromocionAbsoluta(atracciones1, 20);


		usuarioObtenido.compraAtraccion(promocion.getCostoTotal(), promocion.getTiempoTotal());

		assertEquals(usuarioEsperado, usuarioObtenido);
	}

}
