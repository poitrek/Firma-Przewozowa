package pl.polsl.take.firma.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.polsl.take.firma.utils.DateAdapter;

import javax.persistence.Entity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "klienci")
public class Klient {
	
	@Id
//	@TableGenerator(
//		name="klientIdGen", 
//        table="ID_GEN", 
//        pkColumnName="GEN_KEY", 
//        valueColumnName="GEN_VALUE", 
//        pkColumnValue="IDKLIENTA", 
//        allocationSize=1
//    )
    @GeneratedValue(generator = "klientIdGen", strategy=GenerationType.AUTO)
    int id_klienta;
	String imie;
	String nazwisko;
	String nr_tel;
	String haslo;

	@XmlTransient
	@OneToMany(mappedBy = "klient", fetch = FetchType.LAZY)
	List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();

	public List<Rezerwacja> getRezerwacje() {
		return rezerwacje;
	}

	public void setRezerwacje(List<Rezerwacja> rezerwacje) {
		this.rezerwacje = rezerwacje;
	}

	public int getIdklienta() {
		return id_klienta;
	}

	public void setIdklienta(int idklienta) {
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

	public String getNrTel() {
		return nr_tel;
	}

	public void setNrTel(String nr_tel) {
		this.nr_tel = nr_tel;
	}
	
	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Override
	public String toString() {
		return getIdklienta() + " " + getNazwisko() + " " + getImie() + " " + getNrTel() + " " + getHaslo();
	}
}
