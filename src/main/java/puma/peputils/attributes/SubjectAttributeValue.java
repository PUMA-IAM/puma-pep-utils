package puma.peputils.attributes;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Class representing a subject attribute.
 *  
 * @author Maarten Decat
 *
 */
public class SubjectAttributeValue extends AttributeValue {
	
	public static final String prefix = "subject";
	
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
	
	public SubjectAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public SubjectAttributeValue(String id, DataType dataType) {
		super(addPrefix(id), dataType);
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
