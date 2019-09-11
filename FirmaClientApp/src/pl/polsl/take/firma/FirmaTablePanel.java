package pl.polsl.take.firma;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FirmaTablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private FirmaTableModel<?> tableModel;
	private JTable table;

	public FirmaTablePanel(FirmaTableModel<?> tableModel) {
		this.tableModel = tableModel;
		table = new JTable(tableModel);
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
		add(getPrzyciski(), BorderLayout.SOUTH);
	}

	public FirmaTableModel<?> getTableModel() {
		return tableModel;
	}
	
	private JPanel getPrzyciski() {
		JPanel pnPrzyciski = new JPanel();

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setPreferredSize(new Dimension(80, 24));
		btnDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tableModel.addNew();
				} catch (Exception e1) {
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
					tableModel.del(index);
			}
		});
		pnPrzyciski.add(btnUsun);

		return pnPrzyciski;
	}

}
