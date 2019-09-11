package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Przewoz;

@XmlRootElement
public class Przewozy {
	private List<Przewoz> przewozy = new ArrayList<Przewoz>();
	
	public Przewozy(List<Przewoz> przewozy){
		super();
		this.przewozy = przewozy;
	}

	public Przewozy(){}
	
	public List<Przewoz> getPrzewozy(){
		return this.przewozy;
	}
	
	public void setPrzewozy(List<Przewoz> przewozy){
		this.przewozy = przewozy;
	}
}
