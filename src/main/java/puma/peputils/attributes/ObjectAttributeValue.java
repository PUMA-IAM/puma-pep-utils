package puma.peputils.attributes;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class ObjectAttributeValue extends AttributeValue {
	
	public static final String prefix = "object";
	
	private static final String addPrefix(String s) {
		return prefix + ":" + s;
	}

	@Override
	public String getIdWithoutPrefix() {
		return StringUtils.removeStart(this.getId(), prefix + ":");
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	public ObjectAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public ObjectAttributeValue(String id, DataType dataType) {
		super(addPrefix(id), dataType);
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
