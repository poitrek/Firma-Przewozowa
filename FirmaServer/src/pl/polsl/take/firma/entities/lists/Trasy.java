package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Trasa;

@XmlRootElement
public class Trasy {
	private List<Trasa> trasy = new ArrayList<Trasa>();
	
	public Trasy(List<Trasa> trasy){
		super();
		this.trasy = trasy;
	}
	
	public Trasy(){}
	
	public List<Trasa> getTrasy(){
		return trasy;
	}
	
	public void setTrasy(List<Trasa> trasy){
		this.trasy = trasy;
	}
}
