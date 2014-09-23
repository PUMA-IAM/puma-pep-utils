/*******************************************************************************
 * Copyright 2014 KU Leuven Research and Developement - iMinds - Distrinet 
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 *    Administrative Contact: dnet-project-office@cs.kuleuven.be
 *    Technical Contact: maarten.decat@cs.kuleuven.be
 *    Author: maarten.decat@cs.kuleuven.be
 ******************************************************************************/
package puma.peputils.thrift;

import java.util.Date;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;

import puma.peputils.Action;
import puma.peputils.Environment;
import puma.peputils.PEP;
import puma.peputils.Subject;
import puma.peputils.attributes.ActionAttributeValue;
import puma.peputils.attributes.DataType;
import puma.peputils.attributes.EnvironmentAttributeValue;
import puma.peputils.attributes.Multiplicity;
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
		// FIXME we now add the id attribute twice. I guess this will not be a problem, but still...
		Subject s = new Subject(sp.getId());
		for(AttributeValueP avp: sp.getAttributeValues()) {
			// remove the prefix to avoid double prefixes                 FIXME WE DON'T KNOW MULTIPLICITY YET !!!
			SubjectAttributeValue sav = new SubjectAttributeValue(StringUtils.removeStart(avp.id, SubjectAttributeValue.prefix + ":"), Multiplicity.GROUPED);
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
		// FIXME we now add the id attribute twice. I guess this will not be a problem, but still...
		puma.peputils.Object o = new puma.peputils.Object(op.getId());
		for(AttributeValueP avp: op.getAttributeValues()) {
			// remove the prefix to avoid double prefixes                 FIXME WE DON'T KNOW MULTIPLICITY YET !!!
			ObjectAttributeValue sav = new ObjectAttributeValue(StringUtils.removeStart(avp.id, ObjectAttributeValue.prefix + ":"), Multiplicity.GROUPED);
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
		// FIXME we now add the id attribute twice. I guess this will not be a problem, but still...
		Action a = new Action(ap.getId());
		for(AttributeValueP avp: ap.getAttributeValues()) {
			// remove the prefix to avoid double prefixes                 FIXME WE DON'T KNOW MULTIPLICITY YET !!!
			ActionAttributeValue sav = new ActionAttributeValue(StringUtils.removeStart(avp.id, ActionAttributeValue.prefix + ":"), Multiplicity.GROUPED);
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
			// remove the prefix to avoid double prefixes                 FIXME WE DON'T KNOW MULTIPLICITY YET !!!
			EnvironmentAttributeValue sav = new EnvironmentAttributeValue(StringUtils.removeStart(avp.id, EnvironmentAttributeValue.prefix + ":"), Multiplicity.GROUPED);
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
	
	/**************************
	 * FUNCTIONALITY
	 */
	
	private PEP pep;
	
	/**
	 * Initialize this new PEPServer with given PEP to pass the retrieved
	 * requests to.
	 */
	public PEPServer(PEP pep) {
		if(pep == null) {
			throw new NullPointerException("The PEP cannot be null");
		}
		this.pep = pep;
	}

	@Override
	public boolean isAuthorized(SubjectP subjectP, ObjectP objectP,
			ActionP actionP, EnvironmentP environmentP) throws TException {
		// Here we should call the PDP. For now, just print the stuff that we received. 
		Subject subject = c(subjectP);
		puma.peputils.Object object = c(objectP);
		Action action = c(actionP);
		Environment environment = c(environmentP);
		printFine(subject, object, action, environment);
		return pep.isAuthorized(subject, object, action, environment);
	}
	
	private void print(Subject subject, puma.peputils.Object object, Action action, Environment environment) {
		logger.info("New thrift message received: Subject #" + subject.getId() + ", Object #" + object.getId() + ", Action #" + action.getId());
	}
	
	private void printFine(Subject subject, puma.peputils.Object object, Action action, Environment environment) {
		String toPrint = "";
		toPrint += "Subject(" + subject.getId() + "):\n";
		for(SubjectAttributeValue sav: subject.getAttributeValues()) {
			toPrint += "  " + sav.getId() + " =\n";
			for(Object o: sav.getValues()) {
				toPrint += "    " + o + "\n";
			}
		}
		toPrint += "Object(" + subject.getId() + "):\n";
		for(ObjectAttributeValue sav: object.getAttributeValues()) {
			toPrint += "  " + sav.getId() + " =\n";
			for(Object o: sav.getValues()) {
				toPrint += "    " + o + "\n";
			}
		}
		toPrint += "Action(" + subject.getId() + "):\n";
		for(ActionAttributeValue sav: action.getAttributeValues()) {
			toPrint += "  " + sav.getId() + " =\n";
			for(Object o: sav.getValues()) {
				toPrint += "    " + o + "\n";
			}
		}
		toPrint += "Environment:\n";
		for(EnvironmentAttributeValue sav: environment.getAttributeValues()) {
			toPrint += "  " + sav.getId() + " =\n";
			for(Object o: sav.getValues()) {
				toPrint += "    " + o + "\n";
			}
		}
		logger.info("New thrift message received:\n" + toPrint);
	}
	
	

}
