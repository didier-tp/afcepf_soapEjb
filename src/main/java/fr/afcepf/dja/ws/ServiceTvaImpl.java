package fr.afcepf.dja.ws;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.dja.data.ResCalculTva;

@Stateless
@Remote //ou bien @Local (NB: @Local ou @Remote sur interface ou bien sur classe) 
@WebService(endpointInterface="fr.afcepf.dja.ws.ServiceTva")
//NB: url du WS soap (et du ?wsdl) affichée dans la console jboss au démarrage
//pas besoin de Endpoint.publish() , ce sera fait automatiquement par le serveur JEE jboss
public class ServiceTvaImpl implements ServiceTva {

	@Override
	public double tva(double ht, double taux) {
		return ht*taux/100.0;
	}

	@Override
	public String getAuteur() {
		return "didier defrance / formateur fou";
	}

	@Override
	public ResCalculTva calculerTvaEtTtc(double ht, double taux) {
		ResCalculTva resCalculTva = new ResCalculTva();
		resCalculTva.setHt(ht);
		resCalculTva.setTaux(taux);
		resCalculTva.setTva(ht*taux/100.0);
		resCalculTva.setTtc(ht + resCalculTva.getTva());
		return resCalculTva;
	}

}
