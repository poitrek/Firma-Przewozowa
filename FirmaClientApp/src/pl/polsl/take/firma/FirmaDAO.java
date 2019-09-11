package pl.polsl.take.firma;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import pl.polsl.take.firma.entities.TableElemDAO;
import pl.polsl.take.firma.entities.lists.ElemListDAO;
import pl.polsl.take.firma.utils.HttpHelper;

//E - Element class, E - Element List class
public class FirmaDAO<E extends TableElemDAO, EL extends ElemListDAO<E>> {

	private String base_url = "http://localhost:8080/FirmaServer/firma";
	private String marshal_format = "application/xml";
	
	protected final Class<E> classE;
	protected final Class<EL> classEL;
	private final E emptyElem;
	private final String urlPart;
	
	public final E getEmptyElem() {
		return emptyElem;
	}
	
	public FirmaDAO(Class<E> classE, Class<EL> classEL, E emptyElem) {
		this.emptyElem = emptyElem;
		urlPart = emptyElem.getUrlString();
		this.classE = classE;
		this.classEL = classEL;
	}
	
	public void createElement(E elem) {
		String url = base_url + urlPart;
		StringWriter sw = new StringWriter();
		JAXB.marshal(elem, sw);
		HttpHelper.doPost(url, sw.toString(), marshal_format);
	}
	
	public E findElement(int id) {
		String url = base_url + urlPart + "/" + id;
		String txt = HttpHelper.doGet(url);
		E elem = JAXB.unmarshal(new StringReader(txt), classE);
		return elem;
	}

	
	public void updateElement(E elem) {
		String url = base_url + urlPart;
		StringWriter sw = new StringWriter();
		JAXB.marshal(elem, sw);
		HttpHelper.send("PUT", url, sw.toString(), marshal_format);
	}

	
	public void deleteElement(int id) {
		String url = base_url + urlPart + "/" + id;
		HttpHelper.send("DELETE", url, null, marshal_format);
	}

	
	public EL getElements() {
		String url = base_url + urlPart;
		String txt = HttpHelper.doGet(url);
		EL elemList = JAXB.unmarshal(new StringReader(txt), classEL);
		return elemList;
	}

}
