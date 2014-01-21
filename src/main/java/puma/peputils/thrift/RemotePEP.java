package puma.peputils.thrift;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import puma.peputils.Action;
import puma.peputils.Environment;
import puma.peputils.Object;
import puma.peputils.PEP;
import puma.peputils.Subject;
import puma.peputils.attributes.AttributeValue;
import puma.peputils.attributes.DataType;

public class RemotePEP implements PEP {
	
	private static final Logger logger = Logger
			.getLogger(RemotePEP.class.getName());
	
	/*******************************
	 * SOME HELPER METHODS
	 * (c of construct)
	 */
	
	public AttributeValueP c(AttributeValue av) {
		AttributeValueP avp = new AttributeValueP();
		avp.setId(av.getId());
		if(av.getDataType() == DataType.Boolean) {
			avp.setDataType(DataTypeP.BOOLEAN);
			for(java.lang.Object v: av.getValues()) {
				avp.addToBooleanValues((Boolean) v);
			}
		} else if(av.getDataType() == DataType.DateTime) {
			avp.setDataType(DataTypeP.DATETIME);
			for(java.lang.Object v: av.getValues()) {
				// NOTE: we store the time as the long resulting from getTime()
				// This long is the number of milliseconds since 1970. 
				// Also note that UNIX time is the number of *seconds* since 1970. 
				Date d = (Date) v;
				avp.addToDatetimeValues(d.getTime());
			}
		} else if(av.getDataType() == DataType.Integer) {
			avp.setDataType(DataTypeP.INTEGER);
			for(java.lang.Object v: av.getValues()) {
				avp.addToIntValues((Integer) v);
			}
		} else {
			// string
			avp.setDataType(DataTypeP.STRING);
			for(java.lang.Object v: av.getValues()) {
				avp.addToStringValues((String) v);
			}
		}
		return avp;
	}
	
	public SubjectP c(Subject s) {
		SubjectP sp = new SubjectP();
		sp.setId(s.getId());
		for(AttributeValue av: s.getAttributeValues()) {
			sp.addToAttributeValues(c(av));
		}
		return sp;
	}
	
	public ObjectP c(Object o) {
		ObjectP op = new ObjectP();
		op.setId(o.getId());
		for(AttributeValue av: o.getAttributeValues()) {
			op.addToAttributeValues(c(av));
		}
		return op;
	}
	
	public ActionP c(Action a) {
		ActionP ap = new ActionP();
		ap.setId(a.getId());
		for(AttributeValue av: a.getAttributeValues()) {
			ap.addToAttributeValues(c(av));
		}
		return ap;
	}
	
	public EnvironmentP c(Environment e) {
		EnvironmentP ep = new EnvironmentP();
		for(AttributeValue av: e.getAttributeValues()) {
			ep.addToAttributeValues(c(av));
		}
		return ep;
	}

	@Override
	public boolean isAuthorized(Subject subject, Object object, Action action,
			Environment environment) {
		TTransport transport = new TSocket("localhost", 9090);
		try {
			transport.open();
		} catch (TTransportException e) {
			logger.log(Level.SEVERE, "Error opening the Thrift transport?", e);
			return false;
		}

		TProtocol protocol = new TBinaryProtocol(transport);
		RemotePEPService.Client client = new RemotePEPService.Client(protocol);
		
		try {
			boolean authorized = client.isAuthorized(c(subject), c(object), c(action), c(environment));
			transport.close();
			return authorized;
		} catch (TException e) {
			logger.log(Level.SEVERE, "Error with Thrift communication, retuning Deny", e);
			transport.close();
			return false;
		}
	}

}