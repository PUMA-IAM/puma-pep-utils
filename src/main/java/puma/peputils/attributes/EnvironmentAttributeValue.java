package puma.peputils.attributes;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * Class representing an environment attribute.
 *  
 * @author Maarten Decat
 *
 */
public class EnvironmentAttributeValue extends AttributeValue {
	
	public static final String prefix = "environment";
	
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
	
	public EnvironmentAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public EnvironmentAttributeValue(String id, DataType dataType) {
		super(addPrefix(id), dataType);
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
