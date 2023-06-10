package testClases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import paradigmas.turismo.models.*;
import paradigmas.turismo.iterator.Sugerencia;
import paradigmas.turismo.resumenUsuario.*;

public class testSugerencia {

	@Test
	public void MostrarPromocionesDePreferencia() {
		
		Usuario user = new Usuario(	"Fernando", 20.5 , 4000, "Aventura");
		
		List <Atraccion> atracciones1 = new ArrayList<Atraccion>();
		atracciones1.add(new Atraccion("Excursión a la cascada",250,2.5,20,"Aventura"));
		atracciones1.add(new Atraccion("Paseo en carruaje por la ciudad",120,1.0,30,"Aventura"));
		atracciones1.add(new Atraccion("Excursión al bosque",250,2.5,15,"Aventura"));
		Promocion promocion1 = new PromocionAbsoluta(atracciones1, 20);
		
		List <Atraccion> atracciones2 = new ArrayList<Atraccion>();
		atracciones2.add(new Atraccion("viaje en dragon",250,2.5,21,"paisaje"));
		atracciones2.add(new Atraccion("laberinthia",120,1.0,31,"paisaje"));
		atracciones2.add(new Atraccion("ruinas de aragon",250,2.5,16,"paisaje"));
		Promocion promocion2 = new PromocionAbsoluta(atracciones2, 20);
		
		List <Atraccion> atracciones3 = new ArrayList<Atraccion>();
		atracciones3.add(new Atraccion("lucha con dragon",250,2.5,21,"Aventura"));
		atracciones3.add(new Atraccion("lucha con orco",120,1.0,31,"Aventura"));
		atracciones3.add(new Atraccion("espartanos",250,2.5,16,"Aventura"));
		Promocion promocion3 = new PromocionAbsoluta(atracciones3, 20);
		
		List <Atraccion> atracciones4= new ArrayList<Atraccion>();
		atracciones4.add(new Atraccion("Degustación de vinos",200,2.0,15,"Degustación"));
		atracciones4.add(new Atraccion("Cata de quesos",120,1.0,31,"Degustación"));
		atracciones4.add(new Atraccion("Degustación de chocolate",250,2.5,16,"Degustación"));
		Promocion promocion4 = new PromocionAbsoluta(atracciones4, 20);
		
		List <Promocion> promocionesEsperadas = new ArrayList<Promocion>(); 
		promocionesEsperadas.add(promocion1);
		promocionesEsperadas.add(promocion3);
		
		List <Promocion> promocionesObtenidas = new ArrayList<Promocion>(); 
		promocionesObtenidas.add(promocion1);
		promocionesObtenidas.add(promocion2);
		promocionesObtenidas.add(promocion3);
		promocionesObtenidas.add(promocion4);

		ResumenUsuario resumen = null;
		Sugerencia sugerenciaEsperada = new Sugerencia(atracciones1 , promocionesEsperadas, user ,resumen);
		
		Sugerencia sugerenciaObtenida = new Sugerencia(atracciones1 , promocionesObtenidas, user ,resumen);
		
		//terminar
	
	}
	
	@Test
	public void MostrarPromocionesNoPreferencia() {
		
		Usuario user = new Usuario(	"Fernando", 20.5 , 4000, "Aventura");
		
		List <Atraccion> atracciones1 = new ArrayList<Atraccion>();
		atracciones1.add(new Atraccion("Excursión a la cascada",250,2.5,20,"Aventura"));
		atracciones1.add(new Atraccion("Paseo en carruaje por la ciudad",120,1.0,30,"Aventura"));
		atracciones1.add(new Atraccion("Excursión al bosque",250,2.5,15,"Aventura"));
		Promocion promocion1 = new PromocionAbsoluta(atracciones1, 20);
		
		List <Atraccion> atracciones2 = new ArrayList<Atraccion>();
		atracciones2.add(new Atraccion("viaje en dragon",250,2.5,21,"paisaje"));
		atracciones2.add(new Atraccion("laberinthia",120,1.0,31,"paisaje"));
		atracciones2.add(new Atraccion("ruinas de aragon",250,2.5,16,"paisaje"));
		Promocion promocion2 = new PromocionAbsoluta(atracciones2, 20);
		
		List <Atraccion> atracciones3 = new ArrayList<Atraccion>();
		atracciones3.add(new Atraccion("lucha con dragon",250,2.5,21,"Aventura"));
		atracciones3.add(new Atraccion("lucha con orco",120,1.0,31,"Aventura"));
		atracciones3.add(new Atraccion("espartanos",250,2.5,16,"Aventura"));
		Promocion promocion3 = new PromocionAbsoluta(atracciones3, 20);
		
		List <Atraccion> atracciones4= new ArrayList<Atraccion>();
		atracciones4.add(new Atraccion("Degustación de vinos",200,2.0,15,"Degustación"));
		atracciones4.add(new Atraccion("Cata de quesos",120,1.0,31,"Degustación"));
		atracciones4.add(new Atraccion("Degustación de chocolate",250,2.5,16,"Degustación"));
		Promocion promocion4 = new PromocionAbsoluta(atracciones4, 20);
		
		List <Promocion> promocionesEsperadas = new ArrayList<Promocion>(); 
		promocionesEsperadas.add(promocion1);
		promocionesEsperadas.add(promocion3);
		
		List <Promocion> promocionesObtenidas = new ArrayList<Promocion>(); 
		promocionesObtenidas.add(promocion1);
		promocionesObtenidas.add(promocion2);
		promocionesObtenidas.add(promocion3);
		promocionesObtenidas.add(promocion4);

		ResumenUsuario resumen = null;
		Sugerencia sugerenciaEsperada = new Sugerencia(atracciones1 , promocionesEsperadas, user ,resumen);
		
		Sugerencia sugerenciaObtenida = new Sugerencia(atracciones1 , promocionesObtenidas, user ,resumen);
		
		//terminar
	
	}
	
	@Test
	public void MostrarAtraccionesDePreferencia() {
		
		Usuario user = new Usuario(	"Fernando", 20.5 , 4000, "Aventura");
		
		//terminar
	
	}
	
	@Test
	public void MostrarAtraccionesNoPreferencia() {
		
		Usuario user = new Usuario(	"Fernando", 20.5 , 4000, "Aventura");
		
		//terminar
	
	}

}
