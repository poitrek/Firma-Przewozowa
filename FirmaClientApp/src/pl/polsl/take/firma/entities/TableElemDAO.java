package pl.polsl.take.firma.entities;

import java.io.Serializable;

public interface TableElemDAO extends Serializable {

	int getTableColumnCount();
	Object getProperty(int columnIndex);
	String getPropertyName(int columnIndex);
	void setProperty(int columnIndex, String value);
	int getId();
	String getUrlString();
	
}
