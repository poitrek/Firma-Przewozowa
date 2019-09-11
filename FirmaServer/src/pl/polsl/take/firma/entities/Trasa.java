package pl.polsl.take.firma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import pl.polsl.take.firma.entities.lists.Przewozy;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table (name = "trasy")
public class Trasa {
	
	@Id
	@TableGenerator(
		name="trasaIdGen", 
        table="ID_GEN", 
        pkColumnName="GEN_KEY", 
        valueColumnName="GEN_VALUE", 
        pkColumnValue="IDTRASY", 
        allocationSize=1
    )
    @GeneratedValue(generator = "trasaIdGen", strategy=GenerationType.TABLE)
	int id_trasy;
	String stacja_poczatkowa;
	String stacja_koncowa;
	double dlugosc_trasy;
	double cena_biletu;
	
	@XmlTransient
	@OneToMany(mappedBy = "trasa", fetch = FetchType.LAZY)
	List<Przewoz> przewozy = new ArrayList<Przewoz>();
	
	public int getIdtrasy() {
		return id_trasy;
	}
	public void setIdtrasy(int idtrasy) {
		this.id_trasy = idtrasy;
	}
	public String getStacjaPocz() {
		return stacja_poczatkowa;
	}
	public void setStacjaPocz(String stacja_poczatkowa) {
		this.stacja_poczatkowa = stacja_poczatkowa;
	}
	public String getStacjaKonc() {
		return stacja_koncowa;
	}
	public void setStacjaKonc(String stacja_koncowa) {
		this.stacja_koncowa = stacja_koncowa;
	}
	public double getDlugoscTrasy() {
		return dlugosc_trasy;
	}
	public void setDlugoscTrasy(double dlugosc_trasy) {
		this.dlugosc_trasy = dlugosc_trasy;
	}
	public double getCenaBiletu() {
		return cena_biletu;
	}
	public void setCenaBiletu(double cena_biletu) {
		this.cena_biletu = cena_biletu;
	}
	
	public List<Przewoz> getPrzewozy() {
		return przewozy;
	}
	public void setPrzewozy(List<Przewoz> przewozy) {
		this.przewozy = przewozy;
	}
	@Override
	public String toString() {
		return getIdtrasy()+" "+getStacjaPocz()+" "+getStacjaKonc()+" "+getDlugoscTrasy()+" "+getCenaBiletu();
	}
}
