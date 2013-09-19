package puma.peputils.attributes;

import java.util.Date;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class ObjectAttributeValue extends AttributeValue {
	
	private static final String prefix = "object";
	
	private static final String addPrefix(String s) {
		return prefix + ":" + s;
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	public ObjectAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public ObjectAttributeValue(String id, Integer value) {
		super(addPrefix(id), value);
	}
	
	public ObjectAttributeValue(String id, Date value) {
		super(addPrefix(id), value);
	}
	
	public ObjectAttributeValue(String id, String value) {
		super(addPrefix(id), value);
	}
	
	public ObjectAttributeValue(String id, Boolean value) {
		super(addPrefix(id), value);
	}

}
