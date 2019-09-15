package pl.polsl.take.firma.entities;

import java.io.Serializable;

public interface TableElemDAO extends Serializable {

	// Zwraca liczbę kolumn (pól)
	int getTableColumnCount();
	// Zwraca wartość atrybutu o podanym indeksie kolumny
	Object getProperty(int columnIndex);
	// Zwraca nazwę atrybutu o podanym indeksie kolumny
	String getPropertyName(int columnIndex);
	// Ustawia atrybut dla kolumny o danym indeksie
	void setProperty(int columnIndex, String value);
	// Zwraca id obiektu w tabeli
	int getId();
	// Zwraca url encji/tabeli na serwerze
	String getUrlString();
	
}
