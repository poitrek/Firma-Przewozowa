package pl.polsl.take.firma;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import pl.polsl.take.firma.entities.Trasa;
import pl.polsl.take.firma.entities.Autobus;
import pl.polsl.take.firma.entities.Klient;
import pl.polsl.take.firma.entities.Rezerwacja;
import pl.polsl.take.firma.entities.Przewoz;

@Stateful
//@Stateless
public class FirmaEJB {

    // Bean ==========================================================================
	@PersistenceContext(name="firma",type=PersistenceContextType.EXTENDED)
	EntityManager manager;

    // Klienci =======================================================================
	public void createKlient(Klient klient) {
		System.out.println("Creating klient!");
		manager.persist(klient);
	}
	
	public void deleteKlient(int idklienta) {
		Klient klient = manager.find(Klient.class, idklienta);
		manager.remove(klient);
	}
	
	public Klient findKlient(int idklienta){
		return manager.find(Klient.class, idklienta);
	}
	
	public List<Klient> getKlienci(){
		Query q = manager.createQuery("select k from Klient k");
		@SuppressWarnings("unchecked")
		List<Klient> list = q.getResultList();
		return list;
	}
	
	public void updateKlient(Klient klient){
		klient = manager.merge(klient);
	}

	
    // Autobusy ======================================================================
	public void createAutobus(Autobus autobus){
		System.out.println("Creating autobus!");
		manager.persist(autobus);
	}
	
	public void deleteAutobus(int idautobusu) {
		Autobus autobus = manager.find(Autobus.class, idautobusu);
		manager.remove(autobus);
	}
	
	public Autobus findAutobus(int idautobusu){
		return manager.find(Autobus.class, idautobusu);
	}
	
	public List<Autobus> getAutobusy(){
		Query q = manager.createQuery("select a from Autobus a");
		@SuppressWarnings("unchecked")
		List<Autobus> list = q.getResultList();
		return list;
	}
	
	public void updateAutobus(Autobus autobus){
		autobus = manager.merge(autobus);
	}
	
    // Trasy =========================================================================
	public void createTrasa(Trasa trasa){
		System.out.println("Creating trasa!");
		manager.persist(trasa);
	}
	
	public void deleteTrasa(int idtrasy) {
		Trasa trasa = manager.find(Trasa.class, idtrasy);
		manager.remove(trasa);
	}
	
	public Trasa findTrasa(int idtrasy){
		return manager.find(Trasa.class, idtrasy);
	}
	
	public List<Trasa> getTrasy(){
		Query q = manager.createQuery("select t from Trasa t");
		@SuppressWarnings("unchecked")
		List<Trasa> list = q.getResultList();
		return list;
	}
	
	public void updateTrasa(Trasa trasa){
		trasa = manager.merge(trasa);
	}
	
    // Rezerwacje ====================================================================
	public void createRezerwacja(Rezerwacja rezerwacja){
		System.out.println("Creating rezerwacja!");
		manager.persist(rezerwacja);
	}
	
	public void deleteRezerwacja(int idrezerwacji) {
		Rezerwacja rezerwacja = manager.find(Rezerwacja.class, idrezerwacji);
		manager.remove(rezerwacja);
	}
	
	public Rezerwacja findRezerwacje(int idrezerwacji){
		return manager.find(Rezerwacja.class, idrezerwacji);
	}
	
	public List<Rezerwacja> getRezerwacje(){
		Query q = manager.createQuery("select r from Rezerwacja r");
		@SuppressWarnings("unchecked")
		List<Rezerwacja> list = q.getResultList();
		return list;
	}
	
	public void updateRezerwacje(Rezerwacja rezerwacja){
		rezerwacja = manager.merge(rezerwacja);
	}
	
    // Przewozy ======================================================================
	public void createPrzewoz(Przewoz przewoz){
		System.out.println("Creating przewoz!");
		manager.persist(przewoz);
	}
	
	public void deletePrzewoz(int idprzewozu) {
		Przewoz przewoz = manager.find(Przewoz.class, idprzewozu);
		manager.remove(przewoz);
	}
	
	public Przewoz findPrzewoz(int idprzewozu){
		return manager.find(Przewoz.class, idprzewozu);
	}
	
	public List<Przewoz> getPrzewoz(){
		Query q = manager.createQuery("select p from Przewoz p");
		@SuppressWarnings("unchecked")
		List<Przewoz> list = q.getResultList();
		return list;
	}
	
	public void updatePrzewoz(Przewoz przewoz){
		przewoz = manager.merge(przewoz);
	}
	
    // Zapytania zlozone =============================================================
	public List<Przewoz> getPrzewozyAutobusu(int idautobusu){
		Query q = manager.createQuery("SELECT p FROM Przewoz p JOIN FETCH p.autobus a WHERE a.id_autobusu =: idautobusu").setParameter("idautobusu", idautobusu);
		@SuppressWarnings("unchecked")
		List<Przewoz> lista = q.getResultList();
		return lista;
	}

	public List<Rezerwacja> getRezerwacjeKlienta(int idklienta) {
		Query q = manager.createQuery("SELECT r FROM Rezerwacja r JOIN FETCH r.klient k WHERE k.id_klienta =: idklienta").setParameter("idklienta", idklienta);
		@SuppressWarnings("unchecked")
		List<Rezerwacja> lista = q.getResultList();
		return lista;
	}

	public List<Rezerwacja> getRezerwacjePrzewozu(int idprzewozu) {
		Query q = manager.createQuery("SELECT r FROM Rezerwacja r JOIN FETCH r.przewoz p WHERE p.id_przewozu =: idprzewozu").setParameter("idprzewozu", idprzewozu);
		@SuppressWarnings("unchecked")
		List<Rezerwacja> lista = q.getResultList();
		return lista;
	}

	public List<Przewoz> getPrzewozyTrasy(int idtrasy) {
		Query q = manager.createQuery("SELECT p FROM Przewoz p JOIN FETCH p.trasa t WHERE t.id_trasy =: idtrasy").setParameter("idtrasy", idtrasy);
		@SuppressWarnings("unchecked")
		List<Przewoz> lista = q.getResultList();
		return lista;
	}

}
