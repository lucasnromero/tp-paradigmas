package paradigmas.turismo.iterator;

import java.util.List;

import paradigmas.turismo.models.Promocion;

public interface PromocionesIteratorInterface {

	public boolean hasNext();

	public Promocion getNext();
	
	public List<Promocion> getPromocionesCollection();
}
