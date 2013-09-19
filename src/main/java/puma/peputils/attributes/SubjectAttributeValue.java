package puma.peputils.attributes;

import java.util.Date;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class SubjectAttributeValue extends AttributeValue {
	
	private static final String prefix = "subject";
	
	private static final String addPrefix(String s) {
		return prefix + ":" + s;
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	public SubjectAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public SubjectAttributeValue(String id, Integer value) {
		super(addPrefix(id), value);
	}
	
	public SubjectAttributeValue(String id, Date value) {
		super(addPrefix(id), value);
	}
	
	public SubjectAttributeValue(String id, String value) {
		super(addPrefix(id), value);
	}
	
	public SubjectAttributeValue(String id, Boolean value) {
		super(addPrefix(id), value);
	}

}
