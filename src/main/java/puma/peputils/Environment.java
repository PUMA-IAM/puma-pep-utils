package puma.peputils;

import java.util.Collection;

import puma.peputils.attributes.EnvironmentAttributeValue;


/**
 * Class representing a subject for use in the queries to the PEP.
 * A subject has an id and possible some attributes attached.
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
