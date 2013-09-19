package puma.peputils;

import java.util.Collection;

import puma.peputils.attributes.ActionAttributeValue;


/**
 * Class representing an action for use in the queries to the PEP.
 * An action has an id and possible some attributes attached.
 * 
 * @author Maarten Decat
 *
 */
public class Action extends NamedAttributeValueCollection<ActionAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Action(String id) {
		super(id);
	}
	
	public Action(String id, ActionAttributeValue... attributeValues) {
		super(id, attributeValues);
	}
	
	public Action(String id, Collection<ActionAttributeValue> attributeValues) {
		super(id, attributeValues);
	}

	@Override
	protected void addIdAttribute(String id) {
		this.addAttributeValue(new ActionAttributeValue("id", id));
	}

}
