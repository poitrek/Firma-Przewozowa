package pl.polsl.take.firma.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.internal.NotNull;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Table (name = "rezerwacje")
public class Rezerwacja {
	
//	@TableGenerator(
//		name="rezerwacjaIdGen", 
//        table="ID_GEN", 
//        pkColumnName="GEN_KEY", 
//        valueColumnName="GEN_VALUE", 
//        pkColumnValue="IDREZERWACJI", 
//        allocationSize=1
//    )
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id_rezerwacji;
	
	@ManyToOne
	@JoinColumn(name="id_klienta")
	Klient klient;
	
	@ManyToOne
	@JoinColumn(name="id_przewozu")
	Przewoz przewoz;
	
	private int liczba_zarezerw_miejsc;
	
	private double cena_calkowita;
	
	public int getIdrezerwacji() {
		return id_rezerwacji;
	}

	public void setIdrezerwacji(int idrezerwacji) {
		this.id_rezerwacji = idrezerwacji;
	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}
	
	public Przewoz getPrzewoz() {
		return przewoz;
	}

	public void setPrzewoz(Przewoz przewoz) {
		this.przewoz = przewoz;
	}
	
	public int getLiczbaZarMiejsc() {
		return liczba_zarezerw_miejsc;
	}
	
	public void setLiczbaZarMiejsc(int liczba_zarezerwowanych_miejsc) {
		this.liczba_zarezerw_miejsc = liczba_zarezerwowanych_miejsc;
	}
	
	public double getCenaCalkowita() {
		return cena_calkowita;
	}
	
	public void setCenaCalkowita(double cena_calkowita) {
		this.cena_calkowita = cena_calkowita;
	}
	
	
	@Override
	public String toString() {
		return getIdrezerwacji() + " " + getKlient() + " " + getPrzewoz() + " " + getLiczbaZarMiejsc() + " " + getCenaCalkowita();
	}
	
}