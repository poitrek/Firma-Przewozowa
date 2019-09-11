package pl.polsl.take.firma.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.FirmaDAO;
import pl.polsl.take.firma.entities.lists.Rezerwacje;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Rezerwacja implements TableElemDAO {

	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = 
		{ "Id rezerwacji", "Id klienta", "Id przewozu", "Zarezerwowanych miejsc","Cena całkowita"};

	public static final FirmaDAO<Rezerwacja, Rezerwacje> DAO =
			new FirmaDAO<Rezerwacja, Rezerwacje>(Rezerwacja.class, Rezerwacje.class, new Rezerwacja());

	int id_rezerwacji;
	Klient klient;
	Przewoz przewoz;
	int liczba_zarezerw_miejsc;
	double cena_calkowita;
	
	public int getIdRezerwacji() {
		return id_rezerwacji;
	}

	public void setIdRezerwacji(int idrezerwacji) {
		this.id_rezerwacji = idrezerwacji;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public void setKlient(int id) {
		this.klient = Klient.DAO.findElement(id);
	}
	
	public Przewoz getPrzewoz() {
		return przewoz;
	}

	public void setPrzewoz(Przewoz przewoz) {
		this.przewoz = przewoz;
	}
	
	public void setPrzewoz(int id) {
		this.przewoz = Przewoz.DAO.findElement(id);
	}
	
	public int getLiczbaZarezerwowanychMiejsc() {
		return liczba_zarezerw_miejsc;
	}

	public void setLiczbaZarezerwowanychMiejsc(int liczba_zarezerw_miejsc) {
		this.liczba_zarezerw_miejsc = liczba_zarezerw_miejsc;
	}
	
	public double getCenaCalkowita() {
		return cena_calkowita;
	}

	public void setCenaCalkowita(double cena_calkowita) {
		this.cena_calkowita = cena_calkowita;
	}
	
	@Override
	public String toString() {
		return Integer.toString(getIdRezerwacji());
	}
	
	@Override
	public int getTableColumnCount() {
		return 5;
	}

	@Override
	public Object getProperty(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return getIdRezerwacji();
		case 1:
			try {
				return getKlient().getIdKlienta();
			} catch(NullPointerException e) {
				return 0;
			}
		case 2:
			try {
				return getPrzewoz().getIdprzewozu();
			} catch(NullPointerException e) {
				return 0;
			}
		case 3:
			return getLiczbaZarezerwowanychMiejsc();
		case 4:
			return getCenaCalkowita();
		}
		return null;
	}

	@Override
	public String getPropertyName(int columnIndex) {
		return COLUMN_NAMES[columnIndex];
	}

	@Override
	public void setProperty(int columnIndex, String value) {
		switch(columnIndex) {
		case 0:
			setIdRezerwacji(Integer.parseInt(value));
			break;
		case 1:
			setKlient(Integer.parseInt(value));
			break;
		case 2:
			setPrzewoz(Integer.parseInt(value));
			break;
		case 3:	
			setLiczbaZarezerwowanychMiejsc(Integer.parseInt(value));
		case 4:
			setCenaCalkowita(Double.parseDouble(value));
		}
	}

	@Override
	public int getId() {
		return getIdRezerwacji();
	}
	
	@Override
	public String getUrlString() {
		return "/rezerwacje";
	}
	
}