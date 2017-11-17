package fr.afcepf.dja.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import fr.afcepf.dja.ws.ServiceTva;

@MessageDriven(activationConfig = 
{ @ActivationConfigProperty(propertyName="destinationType", 
		propertyValue="javax.jms.Queue"), 
 @ActivationConfigProperty(propertyName="destination",
		propertyValue="queue/fileOu") } /*file de standalone-full.xml */
) 
/*
avec jboss wilfly 10 , dans standalone-full.xml
<jms-queue name="fileOu" entries="java:jboss/exported/jms/queue/fileOu"/>
*/
public class MyMdb implements javax.jms.MessageListener {
	
	@EJB
	private ServiceTva ejbServiceTva; //pour déléguer certains traitements

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("message recu: " + message);
			if(message instanceof TextMessage){
				TextMessage txtMsg = (TextMessage)message;
				System.out.println("texte du message recu:" 
				    + txtMsg.getText());
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
