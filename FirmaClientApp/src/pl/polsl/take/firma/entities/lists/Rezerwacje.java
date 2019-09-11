package pl.polsl.take.firma.entities.lists;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import pl.polsl.take.firma.entities.Rezerwacja;

@XmlRootElement
public class Rezerwacje implements ElemListDAO<Rezerwacja> {
	
	private static final long serialVersionUID = 1L;
	private List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
	
	public Rezerwacje(List<Rezerwacja> rezerwacje){
		super();
		this.rezerwacje = rezerwacje;
	}
	
	public Rezerwacje(){}
	
	public List<Rezerwacja> getRezerwacje(){
		return rezerwacje;
	}
	
	public void setRezerwacje(List<Rezerwacja> rezerwacje){
		this.rezerwacje = rezerwacje;
	}

	@Override
	public List<Rezerwacja> getElemList() {
		return rezerwacje;
	}
}
