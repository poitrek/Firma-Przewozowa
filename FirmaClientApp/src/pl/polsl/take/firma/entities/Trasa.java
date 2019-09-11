package pl.polsl.take.firma.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.polsl.take.firma.FirmaDAO;
import pl.polsl.take.firma.entities.lists.Trasy;
import pl.polsl.take.firma.utils.TimestampAdapter;

import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Trasa implements TableElemDAO {

	private static final long serialVersionUID = 1L;
	private static final String[] COLUMN_NAMES = 
		{ "Id trasy", "Stacja początkowa", "Stacja końcowa", "Długość trasy","Cena biletu" };
	
	private static final TimestampAdapter dateAdapter = new TimestampAdapter();
	public static final FirmaDAO<Trasa, Trasy> DAO =
			new FirmaDAO<Trasa, Trasy>(Trasa.class, Trasy.class, new Trasa());
	
	int id_trasy;
	String stacja_poczatkowa;
	String stacja_koncowa;
	double dlugosc_trasy;
	double cena_biletu;
	
	public int getIdTrasy() {
		return id_trasy;
	}

	public void setIdTrasy(int idTrasy) {
		this.id_trasy = idTrasy;
	}
	
	public String getStacjaPoczatkowa() {
		return stacja_poczatkowa;
	}
	public void setStacjaPoczatkowa(String stacja) {
		this.stacja_poczatkowa=stacja;
	}
	
	public String getStacjaKoncowa() {
		return stacja_koncowa;
	}
	public void setStacjaKoncowa(String stacja) {
		this.stacja_koncowa=stacja;
	}
	
	public double getDlugoscTrasy() {
		return dlugosc_trasy;
	}
	public void setDlugoscTrasy(double dlugosc) {
		this.dlugosc_trasy=dlugosc;
	}
	
	public double getCenaBiletu() {
		return cena_biletu;
	}
	public void setCenaBiletu(double cena) {
		this.cena_biletu=cena;
	}

	@Override
	public String toString() {
		return getIdTrasy() + " " + getStacjaPoczatkowa()+" "+ getStacjaKoncowa()+ " "+ getDlugoscTrasy()+ " "+ getCenaBiletu();
	}
	
	@Override
	public int getTableColumnCount() {
		return 5;
	}

	@Override
	public Object getProperty(int columnIndex) {
		switch(columnIndex) {
		case 0:
			return getIdTrasy();
		case 1:
			return getStacjaPoczatkowa();
		case 2:
			return getStacjaKoncowa();
		case 3:
			return getDlugoscTrasy();
		case 4:
			return getCenaBiletu();
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
			setIdTrasy(Integer.parseInt(value));
			break;
		case 1:
			setStacjaPoczatkowa(value);
			break;
		case 2:
			setStacjaKoncowa(value);
			break;	
		case 3:
			setDlugoscTrasy(Double.parseDouble(value));
			break;
		case 4:
			setCenaBiletu(Double.parseDouble(value));
			break;
		}
	}

	@Override
	public int getId() {
		return getIdTrasy();
	}
	
	@Override
	public String getUrlString() {
		return "/trasy";
	}
}