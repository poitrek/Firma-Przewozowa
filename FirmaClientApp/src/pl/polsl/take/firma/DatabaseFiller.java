//package pl.polsl.take.firma;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Random;
//
//import pl.polsl.take.firma.entities.Autobus;
//import pl.polsl.take.firma.entities.Klient;
//import pl.polsl.take.firma.entities.Przewoz;
//import pl.polsl.take.firma.entities.Rezerwacja;
//import pl.polsl.take.firma.entities.Trasa;
//import pl.polsl.take.firma.utils.DateAdapter;
//import pl.polsl.take.firma.utils.TimestampAdapter;
//
//public class DatabaseFiller implements ActionListener {
//
//	private FirmaTablePanel przewozCRUD;
//	private FirmaTablePanel klientCRUD;
//	private FirmaTablePanel autobusCRUD;
//	private FirmaTablePanel trasaCRUD;
//	private FirmaTablePanel rezerwacjaCRUD;
//	
//	private DateAdapter dateAdapter = new DateAdapter();
//	private TimestampAdapter timestampAdapter = new TimestampAdapter();
//	
//	public DatabaseFiller(
//			FirmaTablePanel przewozCRUD,
//			FirmaTablePanel klientCRUD,
//			FirmaTablePanel autobusCRUD,
//			FirmaTablePanel trasaCRUD,
//			FirmaTablePanel rezerwacjaCRUD) {
//		this.przewozCRUD = przewozCRUD;
//		this.klientCRUD = klientCRUD;
//		this.autobusCRUD = autobusCRUD;
//		this.trasaCRUD = trasaCRUD;
//		this.rezerwacjaCRUD = rezerwacjaCRUD;
//		randomGenerator.setSeed(42);
//	}
//	
//	private Random randomGenerator = new Random();
//
//	protected String randomTelephone() {
//		int a1 = randomGenerator.nextInt(999) + 1;
//		int a2 = randomGenerator.nextInt(999) + 1;
//		int a3 = randomGenerator.nextInt(999) + 1;
//		return String.format("%03d %03d %03d", a1, a2, a3);
//	}
//
//	@SuppressWarnings("unchecked")
//	private void fillPrzewozy() {
//		FirmaTableModel<Przewoz> entityTable = 
//				((FirmaTableModel<Przewoz>)przewozCRUD.getTableModel());
//		Przewoz entity = new Przewoz();
//		entity.setTrasa(randomGenerator.nextInt(2) + 1);
//		entity.setData(dateAdapter.unmarshal("04.02.2019"));
//		entity.setGodzina(timestampAdapter.unmarshal("04.02.2019 8"));
//		entity.setAutobus(randomGenerator.nextInt(5) + 1);
//		entity.setLiczbaMiejsc(20);
//		entityTable.add(entity);
//		
//		entity.setTrasa(randomGenerator.nextInt(2) + 1);
//		entity.setData(dateAdapter.unmarshal("05.02.2019"));
//		entity.setGodzina(timestampAdapter.unmarshal("05.02.2019 9"));
//		entity.setAutobus(randomGenerator.nextInt(5) + 1);
//		entity.setLiczbaMiejsc(23);
//		entityTable.add(entity);
//		
//		entity.setTrasa(randomGenerator.nextInt(2) + 1);
//		entity.setData(dateAdapter.unmarshal("06.02.2019"));
//		entity.setGodzina(timestampAdapter.unmarshal("06.02.2019 8"));
//		entity.setAutobus(randomGenerator.nextInt(5) + 1);
//		entity.setLiczbaMiejsc(2);
//		entityTable.add(entity);
//		
//		entity.setTrasa(randomGenerator.nextInt(2) + 1);
//		entity.setData(dateAdapter.unmarshal("06.02.2019"));
//		entity.setGodzina(timestampAdapter.unmarshal("06.02.2019 11"));
//		entity.setAutobus(randomGenerator.nextInt(5) + 1);
//		entity.setLiczbaMiejsc(11);
//		entityTable.add(entity);
//		
//		entity.setTrasa(randomGenerator.nextInt(2) + 1);
//		entity.setData(dateAdapter.unmarshal("08.02.2019"));
//		entity.setGodzina(timestampAdapter.unmarshal("08.02.2019 11"));
//		entity.setAutobus(randomGenerator.nextInt(5) + 1);
//		entity.setLiczbaMiejsc(7);
//		entityTable.add(entity);
//		
//		
//	}
//	
//	@SuppressWarnings("unchecked")
//	private void fillKlienci() {
//		FirmaTableModel<Klient> entityTable = 
//				((FirmaTableModel<Klient>)klientCRUD.getTableModel());
//		Klient entity = new Klient();
//		entity.setImie("Agnieszka");
//		entity.setNazwisko("Kwiatkowska");
//		entity.setTelefon(randomTelephone());
//		entity.setHaslo("serduszko123");
//		entityTable.add(entity);
//		
//		entity.setImie("Piotr");
//		entity.setNazwisko("Wozniak");
//		entity.setTelefon(randomTelephone());
//		entity.setHaslo("kwiatuszek222");
//		entityTable.add(entity);
//		
//		entity.setImie("Maja");
//		entity.setNazwisko("Kowalska");
//		entity.setTelefon(randomTelephone());
//		entity.setHaslo("sloneczko999");
//		entityTable.add(entity);
//		
//		entity.setImie("Pawel");
//		entity.setNazwisko("Nowak");
//		entity.setTelefon(randomTelephone());
//		entity.setHaslo("piesek453");
//		entityTable.add(entity);
//	}
//
//	@SuppressWarnings("unchecked")
//	private void fillAutobusy() {
//		FirmaTableModel<Autobus> entityTable = 
//				((FirmaTableModel<Autobus>)autobusCRUD.getTableModel());
//		Autobus entity = new Autobus();
//		entity.setNrRejestracyjny("SK123C");
//		entity.setLiczbaMiejsc(55);
//		entityTable.add(entity);
//		entity.setNrRejestracyjny("SO123S");
//		entity.setLiczbaMiejsc(55);
//		entityTable.add(entity);
//		entity.setNrRejestracyjny("KR111N");
//		entity.setLiczbaMiejsc(55);
//		entityTable.add(entity);
//		entity.setNrRejestracyjny("KR122N");
//		entity.setLiczbaMiejsc(55);
//		entityTable.add(entity);
//		entity.setNrRejestracyjny("SK133R");
//		entity.setLiczbaMiejsc(55);
//		entityTable.add(entity);
//	}
//
//	@SuppressWarnings("unchecked")
//	private void fillTrasy() {
//		FirmaTableModel<Trasa> entityTable = 
//				((FirmaTableModel<Trasa>)trasaCRUD.getTableModel());
//		Trasa entity = new Trasa();
//		entity.setStacjaPoczatkowa("Katowice");
//		entity.setStacjaKoncowa("Krakow");
//		entity.setDlugoscTrasy(120.1);
//		entity.setCenaBiletu(12.0);
//		entityTable.add(entity);
//		
//		entity.setStacjaPoczatkowa("Katowice");
//		entity.setStacjaKoncowa("Warszawa");
//		entity.setDlugoscTrasy(320.8);
//		entity.setCenaBiletu(35.0);
//		entityTable.add(entity);
//		
//		entity.setStacjaPoczatkowa("Gdansk");
//		entity.setStacjaKoncowa("Warszawa");
//		entity.setDlugoscTrasy(418.8);
//		entity.setCenaBiletu(45.0);
//		entityTable.add(entity);
//		
//		entity.setStacjaPoczatkowa("Gdansk");
//		entity.setStacjaKoncowa("Torun");
//		entity.setDlugoscTrasy(170.0);
//		entity.setCenaBiletu(25.0);
//		entityTable.add(entity);
//		
//		entity.setStacjaPoczatkowa("Katowice");
//		entity.setStacjaKoncowa("Wroclaw");
//		entity.setDlugoscTrasy(191.0);
//		entity.setCenaBiletu(33.0);
//		entityTable.add(entity);
//	}
//
//	@SuppressWarnings("unchecked")
//	private void fillRezerwacje() {
//		FirmaTableModel<Rezerwacja> entityTable = 
//				((FirmaTableModel<Rezerwacja>)rezerwacjaCRUD.getTableModel());
//		Rezerwacja entity = new Rezerwacja();
//		entity.setKlient(1);
//		entity.setPrzewoz(randomGenerator.nextInt(3) + 1);
//		entity.setLiczbaZarezerwowanychMiejsc(2);
//		entity.setCenaCalkowita(70.0);
//		entityTable.add(entity);
//
//		entity.setKlient(2);
//		entity.setPrzewoz(randomGenerator.nextInt(3) + 1);
//		entity.setLiczbaZarezerwowanychMiejsc(3);
//		entity.setCenaCalkowita(105.0);
//		entityTable.add(entity);
//
//		entity.setKlient(4);
//		entity.setPrzewoz(randomGenerator.nextInt(3) + 1);
//		entity.setLiczbaZarezerwowanychMiejsc(5);
//		entity.setCenaCalkowita(60.0);
//		entityTable.add(entity);
//
//		entity.setKlient(5);
//		entity.setPrzewoz(1);
//		entity.setLiczbaZarezerwowanychMiejsc(2);
//		entity.setCenaCalkowita(70.0);
//		entityTable.add(entity);
//
//		entity.setKlient(5);
//		entity.setPrzewoz(3);
//		entity.setLiczbaZarezerwowanychMiejsc(1);
//		entity.setCenaCalkowita(35.0);
//		entityTable.add(entity);
//		
//		for(int i = 1; i <= 3; ++i) {
//			entity.setKlient(7);
//			entity.setPrzewoz(i);
//			entityTable.add(entity);
//		}
//	}
//	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		fillPrzewozy();
//		fillKlienci();
//		fillAutobusy();
//		fillTrasy();
//		fillRezerwacje();
//	}
//	
//}