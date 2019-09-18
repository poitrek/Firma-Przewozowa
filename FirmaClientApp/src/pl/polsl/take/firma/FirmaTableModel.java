package pl.polsl.take.firma;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import pl.polsl.take.firma.entities.TableElemDAO;

//E - Element class, E - Element List class
public class FirmaTableModel<E extends TableElemDAO> extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private FirmaDAO<E, ?> DAO;
	private List<E> elements;

	public FirmaTableModel(FirmaDAO<E, ?> firmaDAO) {
		this.DAO = firmaDAO;
		updateModel();
	}
	
	private void updateModel() {
		elements = DAO.getElements().getElemList();
		fireTableDataChanged();
	}

	@Override
	public int getColumnCount() {
		return DAO.getEmptyElem().getTableColumnCount();
	}

	@Override
	public int getRowCount() {
		return elements.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return elements.get(rowIndex).getProperty(columnIndex);
	}

	public String getColumnName(int columnIndex) {
		return DAO.getEmptyElem().getPropertyName(columnIndex);
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public void setValueAt(Object o, int rowIndex, int columnIndex) {
		try {
			E elem = elements.get(rowIndex);
			String txt = (String) o;
			elem.setProperty(columnIndex, txt);
			DAO.updateElement(elem);
		} catch (Exception e) {
			// w przypadku błędu zmiana odrzucona i komunikat o błędzie
			JOptionPane.showMessageDialog(null, "Błędna wartość wpisana do pola!", "Błąd", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void add(E elem) throws Exception {
		String result = DAO.createElement(elem);
		if (result.equals("ERR")) {
			throw new Exception ("Nie udało się utworzyć elementu");
		}
		updateModel();
	}

	public void addNew() throws Exception {
		E elem = DAO.classE.newInstance();
		add(elem);
	}
	
	// Dodaje nowy element i nadaje mu wartości atrybutów z listy stringów
	// w takiej kolejności, w jakiej są na liście
	public void addNew(List<String> attributeList) throws Exception {
		E elem = DAO.classE.newInstance();
		// Startujemy od atrybutu od indeksie 1, bo na początku jest
		// klucz główny, który pomijamy
		int counter = 1;
		for (String att : attributeList) {
			elem.setProperty(counter, att);
			counter++;
		}
		add(elem);
	}

	public void del(int rowIndex) throws Exception {
		E elem = elements.get(rowIndex);
		String result = DAO.deleteElement(elem.getId());
		if (result.equals("ERR"))
			throw new Exception("Nie udało się usunąć elementu!");
		updateModel();
	}
}
