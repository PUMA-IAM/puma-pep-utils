package puma.peputils;

import java.util.Collection;

import puma.peputils.attributes.EnvironmentAttributeValue;


/**
 * Class representing an environment for use in the queries to the PEP.
 * Unlinke the subject, object and action, an environment does not have an id.
 * 
 * @author Maarten Decat
 *
 */
public class Environment extends AttributeValueCollection<EnvironmentAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Environment() {
		super();
	}
	
	public Environment(EnvironmentAttributeValue... attributeValues) {
		super(attributeValues);
	}
	
	public Environment(Collection<EnvironmentAttributeValue> attributeValues) {
		super(attributeValues);
	}

}
