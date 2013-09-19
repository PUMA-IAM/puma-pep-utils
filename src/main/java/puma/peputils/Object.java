package puma.peputils;

import java.util.Collection;

import puma.peputils.attributes.ObjectAttributeValue;


/**
 * Class representing an object for use in the queries to the PEP.
 * An object has an id and possible some attributes attached.
 * 
 * @author Maarten Decat
 *
 */
public class Object extends NamedAttributeValueCollection<ObjectAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Object(String id) {
		super(id);
	}
	
	public Object(String id, ObjectAttributeValue... attributeValues) {
		super(id, attributeValues);
	}
	
	public Object(String id, Collection<ObjectAttributeValue> attributeValues) {
		super(id, attributeValues);
	}

	@Override
	protected void addIdAttribute(String id) {
		this.addAttributeValue(new ObjectAttributeValue("id", id));
	}

}
