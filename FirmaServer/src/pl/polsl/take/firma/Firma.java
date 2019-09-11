package pl.polsl.take.firma;

import javax.ejb.Local;

import pl.polsl.take.firma.entities.Trasa;
import pl.polsl.take.firma.entities.Autobus;
import pl.polsl.take.firma.entities.Klient;
import pl.polsl.take.firma.entities.Rezerwacja;
import pl.polsl.take.firma.entities.Przewoz;
import pl.polsl.take.firma.entities.lists.Autobusy;
import pl.polsl.take.firma.entities.lists.Trasy;
import pl.polsl.take.firma.entities.lists.Klienci;
import pl.polsl.take.firma.entities.lists.Rezerwacje;
import pl.polsl.take.firma.entities.lists.Przewozy;

@Local
public interface Firma {

    // Klienci =======================================================================
	public abstract String createKlient(Klient klient);
	public abstract Klient findKlient(int idklienta);	
	public abstract String updateKlient(Klient klient);
	public abstract void deleteKlient(int idklienta);
	public abstract Klienci getKlienci();
	
    // Autobusy ======================================================================
	public abstract String createAutobus(Autobus autobus);
	public abstract Autobus findAutobus(int idautobusu);
	public abstract String updateAutobus(Autobus autobus);
	public abstract void deleteAutobus(int idautobusu);
	public abstract Autobusy getAutobusy();
	
    // Trasy =========================================================================
	public abstract String createTrasa(Trasa trasa);
	public abstract Trasa findTrasa(int idtrasy);
	public abstract String updateTrasa(Trasa trasa);
	public abstract void deleteTrasa(int idtrasy);
	public abstract Trasy getTrasy();
	
    // Rezerwacje ====================================================================
	public abstract String createRezerwacja(Rezerwacja rezerwacja);
	public abstract Rezerwacja findREzerwacje(int idrecepty);
	public abstract String updateRezerwacje(Rezerwacja rezerwacja);
	public abstract void deleteRezerwacja(int idrecepty);
	public abstract Rezerwacje getRezerwacje();
	
    // Przewozy ======================================================================
	public abstract String createPrzewoz(Przewoz przewoz);
	public abstract Przewoz findPrzewoz(int idprzewozu);
	public abstract String updatePrzewoz(Przewoz przewoz);
	public abstract void deletePrzewoz(int idprzewozu);
	public abstract Przewozy getPrzewoz();
	
    // Zapytania zlozone =============================================================
	public abstract Przewozy getPrzewozyAutobusu(int idautobusu);
	public abstract Rezerwacje getRezerwacjeKlienta(int idklienta);
	public abstract Rezerwacje getRezerwacjePrzewozu(int idprzewozu);
	public abstract Przewozy getPrzewozyTrasy(int idtrasy);

}
