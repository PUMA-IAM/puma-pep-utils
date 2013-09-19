package puma.peputils.attributes;

import java.util.Date;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class ActionAttributeValue extends AttributeValue {
	
	private static final String prefix = "action";
	
	private static final String addPrefix(String s) {
		return prefix + ":" + s;
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	public ActionAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public ActionAttributeValue(String id, Integer value) {
		super(addPrefix(id), value);
	}
	
	public ActionAttributeValue(String id, Date value) {
		super(addPrefix(id), value);
	}
	
	public ActionAttributeValue(String id, String value) {
		super(addPrefix(id), value);
	}
	
	public ActionAttributeValue(String id, Boolean value) {
		super(addPrefix(id), value);
	}

}
