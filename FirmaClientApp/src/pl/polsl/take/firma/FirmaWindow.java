package pl.polsl.take.firma;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import pl.polsl.take.firma.entities.Trasa;
import pl.polsl.take.firma.entities.Klient;
import pl.polsl.take.firma.entities.Przewoz;
import pl.polsl.take.firma.entities.Autobus;
import pl.polsl.take.firma.entities.Rezerwacja;
import pl.polsl.take.firma.entities.TableElemDAO;
import pl.polsl.take.firma.entities.Rezerwacja;
import pl.polsl.take.firma.entities.lists.ElemListDAO;
import pl.polsl.take.firma.entities.lists.Klienci;
import pl.polsl.take.firma.entities.lists.Autobusy;
import pl.polsl.take.firma.entities.lists.Przewozy;
import pl.polsl.take.firma.entities.lists.Rezerwacje;
import pl.polsl.take.firma.entities.lists.Trasy;

public class FirmaWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static <E extends TableElemDAO, EL extends ElemListDAO<E>> FirmaTablePanel
			initPanel(Class<E> classE, Class<EL> classEL, E elem) {
		elem.getClass();
		FirmaDAO<E, EL> DAO = new FirmaDAO<E, EL>(classE, classEL, elem);
		FirmaTableModel<E> model = new FirmaTableModel<E>(DAO);
		FirmaTablePanel panel = new FirmaTablePanel(model);
		return panel;
	}
	
	public static FirmaWindow createFirma() {
		FirmaTablePanel przewozCRUD =	initPanel(Przewoz.class, Przewozy.class, new Przewoz());
		FirmaTablePanel klientCRUD = initPanel(Klient.class, Klienci.class, new Klient());
		FirmaTablePanel autobusCRUD =	initPanel(Autobus.class, Autobusy.class, new Autobus());
		FirmaTablePanel trasaCRUD = initPanel(Trasa.class, Trasy.class, new Trasa());
		FirmaTablePanel rezerwacjaCRUD =	initPanel(Rezerwacja.class, Rezerwacje.class, new Rezerwacja());
		FirmaWindow okno = new FirmaWindow(
				przewozCRUD, klientCRUD, autobusCRUD, trasaCRUD, rezerwacjaCRUD
		);
		
		return okno;
	}
	
	JButton fillingButton;
	
	public FirmaWindow(
			FirmaTablePanel przewozCRUD,
			FirmaTablePanel klientCRUD,
			FirmaTablePanel autobusCRUD,
			FirmaTablePanel trasaCRUD,
			FirmaTablePanel rezerwacjaCRUD) {
		setTitle("Firma przewozowa App");
		setLayout(new BorderLayout());
		JTabbedPane tabs = new JTabbedPane();
		tabs.addTab("Przewozy", null, przewozCRUD, null);
		tabs.addTab("Klienci", null, klientCRUD, null);
		tabs.addTab("Rezerwacje", null, rezerwacjaCRUD, null);
		tabs.addTab("Trasy", null, trasaCRUD, null);
		tabs.addTab("Autobusy", null, autobusCRUD, null);
		add(tabs, BorderLayout.CENTER);
		fillingButton = new JButton("Fill database");
//		ActionListener fillCommandListener = new DatabaseFiller(
//				przewozCRUD, klientCRUD, autobusCRUD, trasaCRUD, rezerwacjaCRUD
//		);
		if (przewozCRUD.getTableModel().getRowCount() == 0
				&& klientCRUD.getTableModel().getRowCount() == 0
				&& autobusCRUD.getTableModel().getRowCount() == 0
				&& trasaCRUD.getTableModel().getRowCount() == 0
				&& rezerwacjaCRUD.getTableModel().getRowCount() == 0) {
//			fillingButton.addActionListener(fillCommandListener);
			fillingButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					FirmaWindow.this.remove(fillingButton);
					pack();
				}
			});
			add(fillingButton, BorderLayout.SOUTH);	
		}
		pack();
		setLocationRelativeTo(null);
	}

}
