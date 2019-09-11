package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Klient;

@XmlRootElement
public class Klienci implements ElemListDAO<Klient> {
	
	private static final long serialVersionUID = 1L;
	private List<Klient> klienci = new ArrayList<Klient>();
	
	public Klienci(List<Klient> klienci){
		super();
		this.klienci = klienci;
	}
	
	public Klienci(){}
	
	public List<Klient> getKlienci(){
		return this.klienci;
	}
	
	public void setKlienci(List<Klient> klienci){
		this.klienci = klienci;
	}
	
	@Override
	public List<Klient> getElemList() {
		return getKlienci();
	}
}
