package puma.peputils;

import java.util.Arrays;
import java.util.Collection;

import puma.peputils.attributes.AttributeValue;


/**
 * Just an abstract superclass for all classes that require an id and a collection
 * of attribute values, like Subject, Object and Action.
 * 
 * @author Maarten Decat
 *
 */
public abstract class NamedAttributeValueCollection<T extends AttributeValue> extends AttributeValueCollection<T> {
	
	private String id;

	public String getId() {
		return id;
	}
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public NamedAttributeValueCollection(String id) {
		super();
		this.id = id;
		// IMPORTANT: Java does not let me instantiate T here, although every subclass of
		// AttributeValue provides a non-abstract constructor. Therefore: add the correct
		// attribute in the subclasses!
		this.addIdAttribute(id);
	}
	
	public NamedAttributeValueCollection(String id, T... attributeValues) {
		this(id);
		this.attributeValues.addAll(Arrays.asList(attributeValues));
	}
	
	public NamedAttributeValueCollection(String id, Collection<T> attributeValues) {
		this(id);
		this.attributeValues.addAll(attributeValues);
	}
	
	protected abstract void addIdAttribute(String id);

}
