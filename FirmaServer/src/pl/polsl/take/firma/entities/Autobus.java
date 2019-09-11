package pl.polsl.take.firma.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pl.polsl.take.firma.utils.DateAdapter;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Entity;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table (name = "autobusy")
public class Autobus {
	
	@Id
	@TableGenerator(
		name="autobusIdGen", 
        table="ID_GEN", 
        pkColumnName="GEN_KEY",
        valueColumnName="GEN_VALUE", 
        pkColumnValue="IDAUTOBUSU", 
        allocationSize=1
    )
    @GeneratedValue(generator = "autobusIdGen", strategy=GenerationType.TABLE)
	int id_autobusu;
	String nr_rejestracyjny;
	int liczba_miejsc;

	@XmlTransient
	@OneToMany(mappedBy = "autobus", fetch = FetchType.LAZY)
	List<Przewoz> przewozy = new ArrayList<Przewoz>();

	public List<Przewoz> getPrzewozy() {
		return przewozy;
	}

	public void setPrzewozy(List<Przewoz> przewozy) {
		this.przewozy = przewozy;
	}

	public int getIdAutobusu() {
		return id_autobusu;
	}

	public void setIdAutobusu(int idautobusu) {
		this.id_autobusu = idautobusu;
	}

	public String getNrRejestracyjny() {
		return nr_rejestracyjny;
	}

	public void setNrRejestracyjny(String nrrejestracyjny) {
		this.nr_rejestracyjny = nrrejestracyjny;
	}

	public int getLiczbaMiejsc() {
		return liczba_miejsc;
	}

	public void setLiczbaMiejsc(int liczba_miejsc) {
		this.liczba_miejsc = liczba_miejsc;
	}


	@Override
	public String toString() {
		return getIdAutobusu() + " " + getNrRejestracyjny() + " " + getLiczbaMiejsc(); 
	}
}
