package pl.polsl.take.firma.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.polsl.take.firma.FirmaDAO;
import pl.polsl.take.firma.entities.lists.Przewozy;
import pl.polsl.take.firma.utils.DateAdapter;
import pl.polsl.take.firma.utils.TimestampAdapter;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Przewoz implements TableElemDAO {

	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = 
		{ "Id przewozu", "Id trasy", "Data", "Godzina", "Id autobusu", "Liczba wolnych miejsc" };
	
	private static final DateAdapter dateAdapter = new DateAdapter();
	private static final TimestampAdapter timeAdapter = new TimestampAdapter();
	public static final FirmaDAO<Przewoz, Przewozy> DAO =
			new FirmaDAO<Przewoz, Przewozy>(Przewoz.class, Przewozy.class, new Przewoz());
	
	int id_przewozu;
	Trasa trasa;
	@XmlJavaTypeAdapter(DateAdapter.class)
	Date data;
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	Date godzina;
	Autobus autobus;
	int liczba_wolnych_miejsc;

	public int getIdprzewozu() {
		return id_przewozu;
	}

	public void setIdprzewozu(int id) {
		this.id_przewozu = id;
	}
	
	public Trasa getTrasa() {
		return trasa;
	}
	public void setTrasa(Trasa trasa) {
		this.trasa=trasa;
	}
	public void setTrasa(int id) {
		this.trasa = Trasa.DAO.findElement(id);
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data=data;
	}
	
	public Date getGodzina() {
		return godzina;
	}
	public void setGodzina(Date godzina) {
		this.godzina=godzina;
	}
	
	public Autobus getAutobus() {
		return autobus;
	}
	public void setAutobus(Autobus autobus) {
		this.autobus=autobus;
	}
	public void setAutobus(int id) {
		this.autobus = Autobus.DAO.findElement(id);
	}
	
	public int getLiczbaMiejsc() {
		return liczba_wolnych_miejsc;
	}
	public void setLiczbaMiejsc(int liczba) {
		this.liczba_wolnych_miejsc=liczba;
	}

	@Override
	public String toString() {
		return getIdprzewozu() + " " + getData();
	}

	@Override
	public int getTableColumnCount() {
		return 6;
	}

	@Override
	public Object getProperty(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return getIdprzewozu();
		case 1:
			try {
				return getTrasa().getIdTrasy();
			} catch(NullPointerException e) {
				return 0;
			}
		case 2:
			synchronized(dateAdapter) {
				return dateAdapter.marshal(getData());
			}
		case 3:
			synchronized(timeAdapter) {
				return timeAdapter.marshal(getGodzina());
			}
		case 4:
			try {
				return getAutobus().getIdAutobusu();
			} catch(NullPointerException e) {
				return 0;
			}
		case 5:
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
			setIdprzewozu(Integer.parseInt(value));
			break;
		case 1:
			setTrasa(Integer.parseInt(value));
			break;
		case 2:
			synchronized(dateAdapter) {
				setData(dateAdapter.unmarshal(value));
			}
			break;
		case 3:
			synchronized(timeAdapter) {
				setGodzina(timeAdapter.unmarshal(value));
			}
			break;
		case 4:
			setAutobus(Integer.parseInt(value));
			break;
		case 5:
			setLiczbaMiejsc(Integer.parseInt(value));
			break;
		}
	}

	@Override
	public int getId() {
		return getIdprzewozu();
	}
	
	@Override
	public String getUrlString() {
		return "/przewozy";
	}
}
