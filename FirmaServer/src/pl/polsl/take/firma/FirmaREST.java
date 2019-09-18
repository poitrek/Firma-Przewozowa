package pl.polsl.take.firma;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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

@Path("/firma")
@Consumes({ "application/xml" })
@Produces({ "application/xml" })

public class FirmaREST implements Firma {

	private static final String OK_RESULT = "OK";
	private static final String ERR_RESULT = "ERR";
	// Bean
	// ==========================================================================
	@EJB
	FirmaEJB bean;

	// Klienci
	// =======================================================================
	@Override
	@POST
	@Path("/klienci")
	public String createKlient(Klient klient) {
		try {
			bean.createKlient(klient);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	@Override
	@GET
	@Path("klienci/{idklienta}")
	public Klient findKlient(@PathParam("idklienta") int idklienta) {
		Klient klient = bean.findKlient(idklienta);
		return klient;
	}

	@Override
	@GET
	@Path("/klienci")
	public Klienci getKlienci() {
		List<Klient> klienciList = bean.getKlienci();
		Klienci klienci = new Klienci(klienciList);
		return klienci;
	}

	@Override
	@PUT
	@Path("/klienci")
	public String updateKlient(Klient klient) {
		try {
			bean.updateKlient(klient);
			return "klient updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "klient not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("klienci/{idklienta}")
	public String deleteKlient(@PathParam("idklienta") int idklienta) {
		try {
			bean.deleteKlient(idklienta);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	// Autobusy
	// ======================================================================
	@Override
	@POST
	@Path("/autobusy")
	public String createAutobus(Autobus autobus) {
		try {
			bean.createAutobus(autobus);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	@Override
	@GET
	@Path("autobusy/{id_autobusu}")
	public Autobus findAutobus(@PathParam("id_autobusu") int idautobusu) {
		Autobus autobus = bean.findAutobus(idautobusu);
		return autobus;
	}

	@Override
	@GET
	@Path("/autobusy")
	public Autobusy getAutobusy() {
		List<Autobus> autobusyList = bean.getAutobusy();
		Autobusy autobusy = new Autobusy(autobusyList);
		return autobusy;
	}

	@Override
	@PUT
	@Path("/autobusy")
	public String updateAutobus(Autobus autobus) {
		try {
			bean.updateAutobus(autobus);
			return "autobus updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "autobus not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("autobusy/{id_autobusu}")
	public String deleteAutobus(@PathParam("id_autobusu") int idautobusu) {
		try {
			bean.deleteAutobus(idautobusu);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	// Trasy
	// =========================================================================
	@Override
	@POST
	@Path("/trasy")
	public String createTrasa(Trasa trasa) {
		try {
			bean.createTrasa(trasa);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	@Override
	@GET
	@Path("trasy/{idtrasy}")
	public Trasa findTrasa(@PathParam("idtrasy") int idtrasy) {
		Trasa trasa = bean.findTrasa(idtrasy);
		return trasa;
	}

	@Override
	@GET
	@Path("/trasy")
	public Trasy getTrasy() {
		List<Trasa> trasyList = bean.getTrasy();
		Trasy trasy = new Trasy(trasyList);
		return trasy;
	}

	@Override
	@PUT
	@Path("/trasy")
	public String updateTrasa(Trasa trasa) {
		try {
			bean.updateTrasa(trasa);
			return "trasa updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "trasa not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("trasy/{idtrasy}")
	public String deleteTrasa(@PathParam("idtrasy") int idtrasy) {
		try {
			bean.deleteTrasa(idtrasy);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	// Rezerwacje
	// ====================================================================
	@Override
	@POST
	@Path("/rezerwacje")
	public String createRezerwacja(Rezerwacja rezerwacja) {
		try {
			bean.createRezerwacja(rezerwacja);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	@Override
	@GET
	@Path("rezerwacje/{idrezerwacji}")
	public Rezerwacja findREzerwacje(@PathParam("idrezerwacji") int idrezerwacji) {
		Rezerwacja rezerwacja = bean.findRezerwacje(idrezerwacji);
		return rezerwacja;
	}

	@Override
	@GET
	@Path("/rezerwacje")
	public Rezerwacje getRezerwacje() {
		List<Rezerwacja> rezerwacjaList = bean.getRezerwacje();
		Rezerwacje rezerwacje = new Rezerwacje(rezerwacjaList);
		return rezerwacje;
	}

	@Override
	@PUT
	@Path("/rezerwacje")
	public String updateRezerwacje(Rezerwacja rezerwacja) {
		try {
			bean.updateRezerwacje(rezerwacja);
			return "Rezerwacja updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Rezerwacja not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("rezerwacje/{idrezerwacji}")
	public String deleteRezerwacja(@PathParam("idrezerwacji") int idrezerwacji) {
		try {
			bean.deleteRezerwacja(idrezerwacji);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	// Przewozy
	// ======================================================================
	@Override
	@POST
	@Path("/przewozy")
	public String createPrzewoz(Przewoz przewoz) {
		try {
			bean.createPrzewoz(przewoz);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	@Override
	@GET
	@Path("przewozy/{idprzewozu}")
	public Przewoz findPrzewoz(@PathParam("idprzewozu") int idprzewozu) {
		Przewoz przewoz = bean.findPrzewoz(idprzewozu);
		return przewoz;
	}

	@Override
	@GET
	@Path("/przewozy")
	public Przewozy getPrzewoz() {
		List<Przewoz> przewozList = bean.getPrzewoz();
		Przewozy przewozy = new Przewozy(przewozList);
		return przewozy;
	}

	@Override
	@PUT
	@Path("/przewozy")
	public String updatePrzewoz(Przewoz przewoz) {
		try {
			bean.updatePrzewoz(przewoz);
			return "przewoz updated!";
		} catch (Exception e) {
			e.printStackTrace();
			return "przewoz not updated :(";
		}
	}

	@Override
	@DELETE
	@Path("przewozy/{idprzewozu}")
	public String deletePrzewoz(@PathParam("idprzewozu") int idprzewozu) {
		try {
			bean.deletePrzewoz(idprzewozu);
			return OK_RESULT;
		} catch (Exception e) {
			return ERR_RESULT;
		}
	}

	// Zapytania zlozone
	// =============================================================
	@Override
	@GET
	@Path("/autobusy/{id_autobusu}/przewozy")
	public Przewozy getPrzewozyAutobusu(@PathParam("id_autobusu") int idautobusu) {
		List<Przewoz> listaPrzewozow = bean.getPrzewozyAutobusu(idautobusu);
		Przewozy przewozyAutobusu = new Przewozy(listaPrzewozow);
		return przewozyAutobusu;
	}

	@Override
	@GET
	@Path("/klienci/{idklienta}/rezerwacje")
	public Rezerwacje getRezerwacjeKlienta(@PathParam("idklienta") int idklienta) {
		List<Rezerwacja> listaRezerwacji = bean.getRezerwacjeKlienta(idklienta);
		Rezerwacje rezerwacjeKlienta = new Rezerwacje(listaRezerwacji);
		return rezerwacjeKlienta;
	}

	@Override
	@GET
	@Path("/przewozy/{idprzewozu}/rezerwacje")
	public Rezerwacje getRezerwacjePrzewozu(@PathParam("idprzewozu") int idprzewozu) {
		List<Rezerwacja> listaRezerwacji = bean.getRezerwacjePrzewozu(idprzewozu);
		Rezerwacje rezerwacjePrzewozu = new Rezerwacje(listaRezerwacji);
		return rezerwacjePrzewozu;
	}

	@Override
	@GET
	@Path("/trasy/{idtrasy}/przewozy")
	public Przewozy getPrzewozyTrasy(@PathParam("idtrasy") int idtrasy) {
		List<Przewoz> listaPrzewozow = bean.getPrzewozyTrasy(idtrasy);
		Przewozy przewozyTrasy = new Przewozy(listaPrzewozow);
		return przewozyTrasy;
	}
}
