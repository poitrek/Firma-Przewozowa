package pl.polsl.take.firma;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class AddItemForm extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	// Tabica pól tekstowych
	JTextField textFields[];
	// Tablica etykiet
	JLabel labels[];

	/**
	 * Konstruktor
	 * @param tableModel model tabeli, na jego podstawie zostaną utworzone
	 * odpowiednie etykiety i pola do wypełnienia
	 */
	public AddItemForm(FirmaTableModel<?> tableModel) {
//		JPanel panel = new JPanel();
		
		// Tworzymy grupowy layout
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		// Inicjujemy etykiety i pola
		this.labels = new JLabel[tableModel.getColumnCount() - 1];
		this.textFields = new JTextField[tableModel.getColumnCount() - 1];
		for (int i = 0; i < tableModel.getColumnCount() - 1; i++) {
			labels[i] = new JLabel(tableModel.getColumnName(i + 1) + ":");
			textFields[i] = new JTextField();
			textFields[i].setPreferredSize(new Dimension(150, 22));
			textFields[i].setMaximumSize(new Dimension(150, 22));
		}
		// Tworzymy sekwencyjną grupę pionową
		SequentialGroup verticalGroup = layout.createSequentialGroup();
		for (int i = 0; i < tableModel.getColumnCount() - 1; i++) {
			// Tworzymy równoległą grupę z etykietą i polem tekstowym
			verticalGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(labels[i])
				.addComponent(textFields[i]));
		}
		// Ustawiamy grupę pionową
		layout.setVerticalGroup(verticalGroup);
		
		// Tworzymy sekwencyjną grupę poziomą
		SequentialGroup horizontalGroup = layout.createSequentialGroup();
		// Dwie grupy równoległe - etykiety i pola tekstowe
		ParallelGroup labelGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		ParallelGroup textFieldGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		for (int i = 0; i < tableModel.getColumnCount() - 1; i++) {
			labelGroup.addComponent(labels[i]);
			textFieldGroup.addComponent(textFields[i]);
		}
		// Ustawiamy grupę poziomą
		layout.setHorizontalGroup(horizontalGroup
			.addGroup(labelGroup)
			.addGroup(textFieldGroup));
	}
	
	// Zwraca listę wartości, jakimi wypełniono pola tekstowe
	public List<String> getFormInputValues() {
		List<String> formValues = new ArrayList<String>();
		for (int i = 0; i < textFields.length; i++) {
			formValues.add(textFields[i].getText());
		}
		return formValues;
	}

}
