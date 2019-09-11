package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Przewoz;

@XmlRootElement
public class Przewozy implements ElemListDAO<Przewoz> {
	
	private static final long serialVersionUID = 1L;
	private List<Przewoz> przewozy = new ArrayList<Przewoz>();

	public Przewozy(List<Przewoz> przewozy) {
		super();
		this.przewozy = przewozy;
	}

	public Przewozy() {	}

	public List<Przewoz> getPrzewozy() {
		return przewozy;
	}

	public void setPrzewozy(List<Przewoz> przewozy) {
		this.przewozy = przewozy;
	}

	@Override
	public List<Przewoz> getElemList() {
		return getPrzewozy();
	}
	
}
