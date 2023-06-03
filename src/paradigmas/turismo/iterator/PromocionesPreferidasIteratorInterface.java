package paradigmas.turismo.iterator;

import paradigmas.turismo.models.Promocion;

public interface PromocionesPreferidasIteratorInterface {
	
	public boolean hasNext();

	public Promocion getNext();

	public void reset();
	
}
