package pl.polsl.take.firma.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.polsl.take.firma.FirmaDAO;
import pl.polsl.take.firma.entities.lists.Klienci;
import pl.polsl.take.firma.utils.DateAdapter;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Klient implements TableElemDAO {

	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = 
		{ "Id klienta","Imię", "Nazwisko", "Nr telefonu", "Hasło" };
	
	private static final DateAdapter dateAdapter = new DateAdapter();
	public static final FirmaDAO<Klient, Klienci> DAO =
			new FirmaDAO<Klient, Klienci>(Klient.class, Klienci.class, new Klient());
	
	int id_klienta;
	String imie;
	String nazwisko;
	String nr_tel;
	String haslo;

	public int getIdKlienta() {
		return id_klienta;
	}

	public void setIdKlienta(int idklienta) {
		this.id_klienta = idklienta;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getTelefon() {
		return nr_tel;
	}

	public void setTelefon(String telefon) {
		this.nr_tel = telefon;
	}
	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.nr_tel = haslo;
	}
	@Override
	public String toString() {
		return getIdKlienta() + " " + getNazwisko() + " " + getImie() + " " + getTelefon()+" "+getHaslo() ;
	}
	
	@Override
	public int getTableColumnCount() {
		return 5;
	}

	@Override
	public Object getProperty(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return getIdKlienta();
		case 1:
			return getImie();
		case 2:
			return getNazwisko();
		case 3:
			return getTelefon();
		case 4:
			return getHaslo();
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
			setIdKlienta(Integer.parseInt(value));
			break;
		case 1:
			setImie(value);
			break;
		case 2:
			setNazwisko(value);
			break;
		case 3:
			setTelefon(value);
			break;
		case 4:
			setHaslo(value);
			break;
		}
	}

	@Override
	public int getId() {
		return getIdKlienta();
	}
	
	@Override
	public String getUrlString() {
		return "/klienci";
	}
}
