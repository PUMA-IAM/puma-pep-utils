package puma.peputils.attributes;

import java.util.Date;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class EnvironmentAttributeValue extends AttributeValue {
	
	private static final String prefix = "environment";
	
	private static final String addPrefix(String s) {
		return prefix + ":" + s;
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	public EnvironmentAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public EnvironmentAttributeValue(String id, Integer value) {
		super(addPrefix(id), value);
	}
	
	public EnvironmentAttributeValue(String id, Date value) {
		super(addPrefix(id), value);
	}
	
	public EnvironmentAttributeValue(String id, String value) {
		super(addPrefix(id), value);
	}
	
	public EnvironmentAttributeValue(String id, Boolean value) {
		super(addPrefix(id), value);
	}

}
