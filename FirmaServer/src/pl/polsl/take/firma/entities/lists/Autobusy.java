package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Autobus;

@XmlRootElement
public class Autobusy {
	private List<Autobus> autobusy = new ArrayList<Autobus>();
	
	public Autobusy(List<Autobus> autobusy){
		super();
		this.autobusy = autobusy;
	}
	
	public Autobusy(){}

	public List<Autobus> getAutobusy(){
		return this.autobusy;
	}
	
	public void setAutobusy(List<Autobus> autobusy){
		this.autobusy = autobusy;
	}
}
