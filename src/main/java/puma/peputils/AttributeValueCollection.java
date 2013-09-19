package puma.peputils;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import puma.peputils.attributes.AttributeValue;

import com.sun.xacml.ctx.CachedAttribute;


/**
 * Just an abstract superclass for all classes that require a collection
 * of attribute values, like Subject, Object and Action and Environment.
 * 
 * @author Maarten Decat
 *
 */
public class AttributeValueCollection<T extends AttributeValue> {
	
	protected Collection<T> attributeValues = new LinkedList<T>();

	public Collection<T> getAttributeValues() {
		return attributeValues;
	}
	
	public void addAttributeValue(T value) {
		this.attributeValues.add(value);
	}
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public AttributeValueCollection() {
		// nothing to do
	}
	
	public AttributeValueCollection(T... attributeValues) {
		this.attributeValues.addAll(Arrays.asList(attributeValues));
	}
	
	public AttributeValueCollection(Collection<T> attributeValues) {
		this.attributeValues.addAll(attributeValues);
	}
	
	/*************************
	 * HELPER METHODS
	 *************************/
	
	/**
	 * Returns the collection of attributes in this AttributesCollection as 
	 * cached attributes.
	 * 
	 * @return
	 */
	public Collection<CachedAttribute> asCachedAttributes() {
		List<CachedAttribute> result = new LinkedList<CachedAttribute>();
		for(AttributeValue av: this.getAttributeValues()) {
			result.add(av.toCachedAttribute());
		}
		return result;
	}

}
