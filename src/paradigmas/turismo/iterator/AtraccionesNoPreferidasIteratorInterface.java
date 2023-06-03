package paradigmas.turismo.iterator;

import paradigmas.turismo.models.Atraccion;

public interface AtraccionesNoPreferidasIteratorInterface {
	
	public boolean hasNext();

	public Atraccion getNext();

	public void reset();
	
}
