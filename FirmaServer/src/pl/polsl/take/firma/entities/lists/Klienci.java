package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Klient;

@XmlRootElement
public class Klienci {

	private List<Klient> klienci = new ArrayList<Klient>();
	
	public Klienci(List<Klient> klienci) {
		super();
		this.klienci = klienci;
	}
	
	public Klienci() {}

	public List<Klient> getKlienci() {
		return klienci;
	}
	
	public void setKlienci(List<Klient> klienci) {
		this.klienci = klienci;
	}
}
