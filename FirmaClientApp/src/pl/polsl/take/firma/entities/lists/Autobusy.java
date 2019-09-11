package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Autobus;

@XmlRootElement
public class Autobusy implements ElemListDAO<Autobus> {
	
	private static final long serialVersionUID = 1L;
	private List<Autobus> autobusy = new ArrayList<Autobus>();
	
	public Autobusy(List<Autobus> autobusy) {
		super();
		this.autobusy = autobusy;
	}
	
	public Autobusy() {}
	
	public List<Autobus> getAutobusy() {
		return autobusy;
	}
	
	public void setAutobusy(List<Autobus> autobusy) {
		this.autobusy = autobusy;
	}
	
	@Override
	public List<Autobus> getElemList() {
		return getAutobusy();
	}
}
