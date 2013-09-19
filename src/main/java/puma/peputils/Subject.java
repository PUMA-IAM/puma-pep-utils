package puma.peputils;

import java.util.Collection;

import puma.peputils.attributes.SubjectAttributeValue;


/**
 * Class representing a subject for use in the queries to the PEP.
 * A subject has an id and possible some attributes attached.
 * 
 * @author Maarten Decat
 *
 */
public class Subject extends NamedAttributeValueCollection<SubjectAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Subject(String id) {
		super(id);
	}
	
	public Subject(String id, SubjectAttributeValue... attributeValues) {
		super(id, attributeValues);
	}
	
	public Subject(String id, Collection<SubjectAttributeValue> attributeValues) {
		super(id, attributeValues);
	}

	@Override
	protected void addIdAttribute(String id) {
		this.addAttributeValue(new SubjectAttributeValue("id", id));
	}

}
