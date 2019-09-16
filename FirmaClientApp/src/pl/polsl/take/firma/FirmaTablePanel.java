package pl.polsl.take.firma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.GroupLayout.SequentialGroup;

public class FirmaTablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private FirmaTableModel<?> tableModel;
	private JTable table;
	private AddItemForm addItemForm;

	public FirmaTablePanel(FirmaTableModel<?> tableModel) {
		this.tableModel = tableModel;
		table = new JTable(tableModel);
//		table.setPreferredSize(new Dimension(400, 200));
		setLayout(new BorderLayout());
//		JPanel centerPanel = new JPanel(new BorderLayout());
//		centerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
//		centerPanel.add(getAddItemForm(), BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(530, 220));
		add(scrollPane, BorderLayout.NORTH);
		
		// Tworzymy formę dodawania elementu i dodajemy ją do panelu
		this.addItemForm = new AddItemForm(tableModel);
		add(addItemForm, BorderLayout.CENTER);
//		add(centerPanel, BorderLayout.CENTER);
		// Tworzymy i dodajemy do panelu przyciski
		add(getPrzyciski(), BorderLayout.SOUTH);
//		table.add(getAddItemForm(), BorderLayout.PAGE_END);
	}

	public FirmaTableModel<?> getTableModel() {
		return tableModel;
	}
	
	// Tworzy panel dodawania elementu na podstawie jego modelu tabeli
	@Deprecated
	private JPanel createAddItemForm(FirmaTableModel<?> tableModel) {
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		// Tablica etykiet
		JLabel labels[] = new JLabel[tableModel.getColumnCount() - 1];
		// Tablica pól tekstowych
		JTextField textFields[] = new JTextField[tableModel.getColumnCount() - 1];
		// Inicjujemy etykiety i pola
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
		
		return panel;
	}
	
	
	// Jeszcze nie dokończona, zwraca listę wartości wpisanych do formy dodawania
	public List<String> getAddItemFormValues(){
		List<String> formValues = new ArrayList<String>();
		return formValues;
	}
	
	
	private JPanel sampleTextField() {
		JPanel pnAddForm = new JPanel(new FlowLayout());
		JTextField textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(120, 24));
		pnAddForm.add(textField1);
		
		JTextField textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(120, 24));
		pnAddForm.add(textField2);
		
		JTextField textField3 = new JTextField();
		textField3.setPreferredSize(new Dimension(120, 24));
		pnAddForm.add(textField3);
		
		return pnAddForm;
	}
	
	private JPanel getPrzyciski() {
		JPanel pnPrzyciski = new JPanel();

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(new Dimension(80, 24));
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tableModel.addNew(addItemForm.getFormInputValues());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Nie mozna utworzyć nowego elementu !",
							"Błąd", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		pnPrzyciski.add(btnDodaj);

		JButton btnUsun = new JButton("Usuń");
		btnUsun.setPreferredSize(new Dimension(80, 24));
		btnUsun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index >= 0)
				{
					try {
						tableModel.del(index);
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Nie mozna usunac tego elementu !",
								"Błąd", JOptionPane.ERROR_MESSAGE);
					}
				}
					
			}
		});
		pnPrzyciski.add(btnUsun);

		return pnPrzyciski;
	}

}
