package pl.polsl.take.firma.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.FirmaDAO;
import pl.polsl.take.firma.entities.lists.Autobusy;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Autobus implements TableElemDAO {

	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = 
		{ "Id autobusu", "Nr rejestracyjny","Liczba miejsc" };

	public static final FirmaDAO<Autobus, Autobusy> DAO =
			new FirmaDAO<Autobus, Autobusy>(Autobus.class, Autobusy.class, new Autobus());
	
	int id_autobusu;
	String nr_rejestracyjny;
	int liczba_miejsc;
	
	public int getIdAutobusu() {
		return id_autobusu;
	}
	public void setIdAutobusu(int idautobusu) {
		this.id_autobusu = idautobusu;
	}
	public String getNrRejestracyjny() {
		return nr_rejestracyjny;
	}
	public void setNrRejestracyjny(String numer) {
		this.nr_rejestracyjny = numer;
	}
	public int getLiczbaMiejsc() {
		return liczba_miejsc;
	}
	public void setLiczbaMiejsc(int liczba) {
		this.liczba_miejsc=liczba;
	}
	@Override
	public String toString() {
		return getIdAutobusu()+" "+getNrRejestracyjny()+" "+getLiczbaMiejsc();
	}
	
	@Override
	public int getTableColumnCount() {
		return 3;
	}

	@Override
	public Object getProperty(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return getIdAutobusu();
		case 1:
			return getNrRejestracyjny();
		case 2:
			return getLiczbaMiejsc();
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
			setIdAutobusu(Integer.parseInt(value));
			break;
		case 1:
			setNrRejestracyjny(value);
			break;
		case 2:
			setLiczbaMiejsc(Integer.parseInt(value));
		}
	}

	@Override
	public int getId() {
		return getIdAutobusu();
	}
	
	@Override
	public String getUrlString() {
		return "/autobusy";
	}
}