package puma.peputils.thrift;

import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import puma.peputils.Action;
import puma.peputils.Environment;
import puma.peputils.Subject;
import puma.peputils.attributes.ActionAttributeValue;
import puma.peputils.attributes.DataType;
import puma.peputils.attributes.EnvironmentAttributeValue;
import puma.peputils.attributes.ObjectAttributeValue;
import puma.peputils.attributes.SubjectAttributeValue;

public class PEPServer implements RemotePEPService.Iface {
	
	private static final Logger logger = Logger
			.getLogger(PEPServer.class.getName());
	

	/*******************************
	 * SOME HELPER METHODS
	 * (c of construct)
	 */
	
	public Subject c(SubjectP sp) {
		Subject s = new Subject(sp.getId());
		for(AttributeValueP avp: sp.getAttributeValues()) {
			// remove the prefix to avoid double prefixes
			SubjectAttributeValue sav = new SubjectAttributeValue(StringUtils.removeStart(avp.id, SubjectAttributeValue.prefix + ":"));
			if(avp.getDataType() == DataTypeP.BOOLEAN) {
				sav.setDataType(DataType.Boolean);
				for(Boolean b: avp.getBooleanValues()) {
					sav.addValue(b);
				}
			} else if(avp.getDataType() == DataTypeP.DATETIME) {
				sav.setDataType(DataType.DateTime);
				for(Long l: avp.getDatetimeValues()) {
					sav.addValue(new Date(l));
				}
			} else if(avp.getDataType() == DataTypeP.INTEGER) {
				sav.setDataType(DataType.Integer);
				for(Integer i: avp.getIntValues()) {
					sav.addValue(i);
				}
			} else {
				// STRING
				sav.setDataType(DataType.String);
				for(String sv: avp.getStringValues()) {
					sav.addValue(sv);
				}
			}  
			s.addAttributeValue(sav);
		}
		return s;
	}
	
	public puma.peputils.Object c(ObjectP op) {
		puma.peputils.Object o = new puma.peputils.Object(op.getId());
		for(AttributeValueP avp: op.getAttributeValues()) {
			// remove the prefix to avoid double prefixes
			ObjectAttributeValue sav = new ObjectAttributeValue(StringUtils.removeStart(avp.id, ObjectAttributeValue.prefix + ":"));
			if(avp.getDataType() == DataTypeP.BOOLEAN) {
				sav.setDataType(DataType.Boolean);
				for(Boolean b: avp.getBooleanValues()) {
					sav.addValue(b);
				}
			} else if(avp.getDataType() == DataTypeP.DATETIME) {
				sav.setDataType(DataType.DateTime);
				for(Long l: avp.getDatetimeValues()) {
					sav.addValue(new Date(l));
				}
			} else if(avp.getDataType() == DataTypeP.INTEGER) {
				sav.setDataType(DataType.Integer);
				for(Integer i: avp.getIntValues()) {
					sav.addValue(i);
				}
			} else {
				// STRING
				sav.setDataType(DataType.String);
				for(String sv: avp.getStringValues()) {
					sav.addValue(sv);
				}
			}  
			o.addAttributeValue(sav);
		}
		return o;
	}
	
	public Action c(ActionP ap) {
		Action a = new Action(ap.getId());
		for(AttributeValueP avp: ap.getAttributeValues()) {
			// remove the prefix to avoid double prefixes
			ActionAttributeValue sav = new ActionAttributeValue(StringUtils.removeStart(avp.id, ActionAttributeValue.prefix + ":"));
			if(avp.getDataType() == DataTypeP.BOOLEAN) {
				sav.setDataType(DataType.Boolean);
				for(Boolean b: avp.getBooleanValues()) {
					sav.addValue(b);
				}
			} else if(avp.getDataType() == DataTypeP.DATETIME) {
				sav.setDataType(DataType.DateTime);
				for(Long l: avp.getDatetimeValues()) {
					sav.addValue(new Date(l));
				}
			} else if(avp.getDataType() == DataTypeP.INTEGER) {
				sav.setDataType(DataType.Integer);
				for(Integer i: avp.getIntValues()) {
					sav.addValue(i);
				}
			} else {
				// STRING
				sav.setDataType(DataType.String);
				for(String sv: avp.getStringValues()) {
					sav.addValue(sv);
				}
			}  
			a.addAttributeValue(sav);
		}
		return a;
	}
	
	public Environment c(EnvironmentP sp) {
		Environment e = new Environment();
		for(AttributeValueP avp: sp.getAttributeValues()) {
			// remove the prefix to avoid double prefixes
			EnvironmentAttributeValue sav = new EnvironmentAttributeValue(StringUtils.removeStart(avp.id, EnvironmentAttributeValue.prefix + ":"));
			if(avp.getDataType() == DataTypeP.BOOLEAN) {
				sav.setDataType(DataType.Boolean);
				for(Boolean b: avp.getBooleanValues()) {
					sav.addValue(b);
				}
			} else if(avp.getDataType() == DataTypeP.DATETIME) {
				sav.setDataType(DataType.DateTime);
				for(Long l: avp.getDatetimeValues()) {
					sav.addValue(new Date(l));
				}
			} else if(avp.getDataType() == DataTypeP.INTEGER) {
				sav.setDataType(DataType.Integer);
				for(Integer i: avp.getIntValues()) {
					sav.addValue(i);
				}
			} else {
				// STRING
				sav.setDataType(DataType.String);
				for(String sv: avp.getStringValues()) {
					sav.addValue(sv);
				}
			}  
			e.addAttributeValue(sav);
		}
		return e;
	}

	@Override
	public boolean isAuthorized(SubjectP subjectP, ObjectP objectP,
			ActionP actionP, EnvironmentP environmentP) throws TException {
		print(c(subjectP), c(objectP), c(actionP), c(environmentP));
		return false;
	}
	
	private void p(String s) {
		System.out.println(s);
	}
	
	private void print(Subject subject, puma.peputils.Object object, Action action, Environment environment) {
		p("Subject(" + subject.getId() + "):");
		for(SubjectAttributeValue sav: subject.getAttributeValues()) {
			p("  " + sav.getId() + " =");
			for(Object o: sav.getValues()) {
				p("    " + o);
			}
		}
		p("Object(" + subject.getId() + "):");
		for(ObjectAttributeValue sav: object.getAttributeValues()) {
			p("  " + sav.getId() + " =");
			for(Object o: sav.getValues()) {
				p("    " + o);
			}
		}
		p("Action(" + subject.getId() + "):");
		for(ActionAttributeValue sav: action.getAttributeValues()) {
			p("  " + sav.getId() + " =");
			for(Object o: sav.getValues()) {
				p("    " + o);
			}
		}
		p("Environment:");
		for(EnvironmentAttributeValue sav: environment.getAttributeValues()) {
			p("  " + sav.getId() + " =");
			for(Object o: sav.getValues()) {
				p("    " + o);
			}
		}
	}
	
	

}
