package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Trasa;

@XmlRootElement
public class Trasy implements ElemListDAO<Trasa> {
	
	private static final long serialVersionUID = 1L;
	private List<Trasa> trasy = new ArrayList<Trasa>();
	
	public Trasy(List<Trasa> trasy){
		super();
		this.trasy = trasy;
	}

	public Trasy(){}
	
	public List<Trasa> getTrasy(){
		return this.trasy;
	}
	
	public void setTrasy(List<Trasa> trasy){
		this.trasy = trasy;
	}

	@Override
	public List<Trasa> getElemList() {
		return getTrasy();
	}
}
