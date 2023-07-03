package paradigmas.turismo.iterator;

import java.util.List;

import paradigmas.turismo.models.Atraccion;

public interface AtraccionesIteratorInterface {

	public boolean hasNext();

	public Atraccion getNext();

	public List<Atraccion> getAtraccionesCollection();
}
