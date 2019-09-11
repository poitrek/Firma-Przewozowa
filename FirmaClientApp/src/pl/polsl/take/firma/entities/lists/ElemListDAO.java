package pl.polsl.take.firma.entities.lists;

import java.io.Serializable;
import java.util.List;

import pl.polsl.take.firma.entities.TableElemDAO;

public interface ElemListDAO<E extends TableElemDAO> extends Serializable {
	
	List<E> getElemList();

}
