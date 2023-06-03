package paradigmas.turismo.iterator;

public interface SugerenciaInterface {
	
	public AtraccionesPreferidasIteratorInterface crearAtraccionesPreferidasIterator();
	public PromocionesPreferidasIteratorInterface crearPromocionesPreferidasIterator();
	public AtraccionesNoPreferidasIteratorInterface crearAtraccionesNoPreferidasIterator();
	public PromocionesNoPreferidasIteratorInterface crearPromocionesNoPreferidasIterator();

}
