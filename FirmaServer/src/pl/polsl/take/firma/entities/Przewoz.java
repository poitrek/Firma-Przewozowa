package pl.polsl.take.firma.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import pl.polsl.take.firma.utils.TimestampAdapter;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table (name = "przewozy")
public class Przewoz {

//	@TableGenerator(
//		name="przewozIdGen", 
//        table="ID_GEN", 
//        pkColumnName="GEN_KEY", 
//        valueColumnName="GEN_VALUE", 
//        pkColumnValue="IDPRZEWOZU", 
//        allocationSize=1
//    )
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_przewozu;

	@ManyToOne
	@JoinColumn(name="id_trasy")
	Trasa trasa;
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@Temporal(TemporalType.TIMESTAMP)
	Date data;
	
	@XmlJavaTypeAdapter(TimestampAdapter.class)
	@Temporal(TemporalType.TIMESTAMP)
	Date godzina;

	@ManyToOne
	@JoinColumn(name="id_autobusu")
	Autobus autobus;

	int liczba_wolnych_miejsc;
	
	@XmlTransient
	@OneToMany(mappedBy="przewoz", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();

	public int getIdprzewozu() {
		return id_przewozu;
	}

	public void setIdprzewozu(int idprzewozu) {
		this.id_przewozu = idprzewozu;
	}

	public Trasa getTrasa() {
		return trasa;
	}

	public void setTrasa(Trasa trasa) {
		this.trasa = trasa;
	}

	public Autobus getAutobus() {
		return autobus;
	}

	public void setAutobus(Autobus autobus) {
		this.autobus = autobus;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getGodzina() {
		return godzina;
	}

	public void setGodzina(Date godzina) {
		this.godzina = godzina;
	}
	
	public int getLiczbaWolnychMiejsc() {
		return liczba_wolnych_miejsc;
	}

	public void setLiczbaWolnychMiejsc(int liczba_wolnych_miejsc) {
		this.liczba_wolnych_miejsc = liczba_wolnych_miejsc;
	}

	public List<Rezerwacja> getRezerwacje() {
		return rezerwacje;
	}

	public void setRezerwacje(List<Rezerwacja> rezerwacje) {
		this.rezerwacje = rezerwacje;
	}

	@Override
	public String toString() {
		return getIdprzewozu() + " " + getTrasa() + " " + getData() + " " + getGodzina() + " " + getAutobus() + " " + getLiczbaWolnychMiejsc();
	}
}