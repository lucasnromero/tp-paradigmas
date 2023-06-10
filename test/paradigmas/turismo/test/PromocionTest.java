package paradigmas.turismo.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paradigmas.turismo.models.*;

public class PromocionTest {

	@Test
	public void descuentoCupo() {

		List<Atraccion> atraccionesPromEsperada = new ArrayList<Atraccion>();
		atraccionesPromEsperada.add(new Atraccion("Excursión a la cascada", 250, 2.5, 20, "Aventura"));
		atraccionesPromEsperada.add(new Atraccion("Paseo en carruaje por la ciudad", 120, 1.0, 30, "Aventura"));
		atraccionesPromEsperada.add(new Atraccion("Excursión al bosque", 250, 2.5, 15, "Aventura"));
		Promocion promocionEsperada = new PromocionAbsoluta(atraccionesPromEsperada, 20);

		List<Atraccion> atraccionesPromObtenida = new ArrayList<Atraccion>();
		atraccionesPromObtenida.add(new Atraccion("Excursión a la cascada", 250, 2.5, 21, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Paseo en carruaje por la ciudad", 120, 1.0, 31, "Aventura"));
		atraccionesPromObtenida.add(new Atraccion("Excursión al bosque", 250, 2.5, 16, "Aventura"));
		Promocion promocionObtenida = new PromocionAbsoluta(atraccionesPromObtenida, 20);

		promocionObtenida.reducirCupo();

		assertEquals(promocionEsperada, promocionObtenida);
	}

}
