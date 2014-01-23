package puma.peputils.attributes;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;


/**
 * Class representing an action attribute.
 *  
 * @author Maarten Decat
 *
 */
public class ActionAttributeValue extends AttributeValue {
	
	public static final String prefix = "action";
	
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
	
	public ActionAttributeValue(String id) {
		super(addPrefix(id));
	}
	
	public ActionAttributeValue(String id, DataType dataType) {
		super(addPrefix(id), dataType);
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
