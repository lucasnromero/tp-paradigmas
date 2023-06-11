package paradigmas.turismo.iterator;

public interface SugerenciaInterface {

	public AtraccionesIteratorInterface crearAtraccionesPreferidasIterator();

	public PromocionesIteratorInterface crearPromocionesPreferidasIterator();

	public AtraccionesIteratorInterface crearAtraccionesNoPreferidasIterator();

	public PromocionesIteratorInterface crearPromocionesNoPreferidasIterator();

}
