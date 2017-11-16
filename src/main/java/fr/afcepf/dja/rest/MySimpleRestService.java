package fr.afcepf.dja.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.dja.data.ResCalculTva;

@Path("tva")
@Produces("application/json")
public class MySimpleRestService {
	
	@GET
	@Path("/calculerTvaEtTtc")
	// http:localhost:8080/soapEjb/services/rest/tva/calculerTvaEtTtc?ht=200&taux=20
	public ResCalculTva getResCalculTva(@QueryParam("ht")double ht,
			                            @QueryParam("taux")double taux){
		ResCalculTva resCalculTva = new ResCalculTva();
		resCalculTva.setHt(ht);
		resCalculTva.setTaux(taux);
		resCalculTva.setTva(ht*taux/100.0);
		resCalculTva.setTtc(ht + resCalculTva.getTva());
		return resCalculTva;
	}

}
