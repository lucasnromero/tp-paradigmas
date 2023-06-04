package paradigmas.turismo.iterator;

import paradigmas.turismo.models.Atraccion;

public interface AtraccionesIteratorInterface {
	
	public boolean hasNext();

	public Atraccion getNext();

	public void reset();
	
}
