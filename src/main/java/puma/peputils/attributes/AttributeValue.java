package puma.peputils.attributes;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

import com.sun.xacml.attr.BagAttribute;
import com.sun.xacml.attr.BooleanAttribute;
import com.sun.xacml.attr.DateTimeAttribute;
import com.sun.xacml.attr.IntegerAttribute;
import com.sun.xacml.attr.StringAttribute;
import com.sun.xacml.ctx.CachedAttribute;

/**
 * Class used for representing a simple attribute value. A
 * 
 * @author Maarten Decat
 */
public abstract class AttributeValue {
	
	private DataType dataType;
	
	public DataType getDataType() {
		return dataType;
	}
	
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	
	private String id;
	
	protected void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public abstract String getIdWithoutPrefix();

	private Collection<Object> values; 

	public Collection<Object> getValues() {
		return values;
	}
	
	/***********************
	 * CONSTRUCTORS
	 ***********************/
	
	/**
	 * Default constructor for sub-classes only.
	 * Needed if the id should be calculated before calling super().
	 */
	protected AttributeValue() {
		this.values = new LinkedList<Object>();
	}
	
	public AttributeValue(String id) {
		this();
		this.id = id;
	}
	
	public AttributeValue(String id, DataType dataType) {
		this(id);
		this.dataType = dataType;
	}
	
	public AttributeValue(String id, Integer value) {
		this(id, DataType.Integer);
		this.addValue(value);
	}
	
	public AttributeValue(String id, Date value) {
		this(id, DataType.DateTime);
		this.addValue(value);
	}
	
	public AttributeValue(String id, String value) {
		this(id, DataType.String);
		this.addValue(value);
	}
	
	public AttributeValue(String id, Boolean value) {
		this(id, DataType.Boolean);
		this.addValue(value);
	}
	
	/**********************
	 * ADDING ATTRIBUTES
	 **********************/
	
	public void addValue(Integer value) {
		// make sure that all values are the same
		if(this.dataType == null) {
			// if there are no values yet, then set the type of this AttributeValue
			this.dataType = DataType.Integer;
		} else if(this.dataType != DataType.Integer) {
			// if this AttributeValue already had a type, check that its the same
			throw new IllegalArgumentException("Expected " + this.dataType + ", but received " + DataType.Integer);
		}
		this.values.add(value);
	}
	
	public void addValue(String value) {
		// make sure that all values are the same
		if(this.dataType == null) {
			// if there are no values yet, then set the type of this AttributeValue
			this.dataType = DataType.String;
		} else if(this.dataType != DataType.String) {
			// if this AttributeValue already had a type, check that its the same
			throw new IllegalArgumentException("Expected " + this.dataType + ", but received " + DataType.String);
		}
		this.values.add(value);
	}
	
	public void addValue(Date value) {
		// make sure that all values are the same
		if(this.dataType == null) {
			// if there are no values yet, then set the type of this AttributeValue
			this.dataType = DataType.DateTime;
		} else if(this.dataType != DataType.DateTime) {
			// if this AttributeValue already had a type, check that its the same
			throw new IllegalArgumentException("Expected " + this.dataType + ", but received " + DataType.DateTime);
		}
		this.values.add(value);
	}
	
	public void addValue(Boolean value) {
		// make sure that all values are the same
		if(this.dataType == null) {
			// if there are no values yet, then set the type of this AttributeValue
			this.dataType = DataType.Boolean;
		} else if(this.dataType != DataType.Boolean) {
			// if this AttributeValue already had a type, check that its the same
			throw new IllegalArgumentException("Expected " + this.dataType + ", but received " + DataType.Boolean);
		}
		this.values.add(value);
	}
	
	/*********************
	 * SOME CONVERSIONS
	 *********************/
	
	public CachedAttribute toCachedAttribute() {
		Collection<com.sun.xacml.attr.AttributeValue> convertedValues = new LinkedList<com.sun.xacml.attr.AttributeValue>();
		for(Object obj: this.values) {
			if(this.dataType == DataType.Boolean) {
				Boolean v = (Boolean) obj;
				convertedValues.add(BooleanAttribute.getInstance(v.booleanValue()));
			} else if(this.dataType == DataType.String) {
				String v = (String) obj;
				convertedValues.add(new StringAttribute(v));
			} else if(this.dataType == DataType.Integer) {
				Integer v = (Integer) obj;
				convertedValues.add(new IntegerAttribute(v.longValue()));
			} else if(this.dataType == DataType.DateTime) {
				Date v = (Date) obj;
				convertedValues.add(new DateTimeAttribute(v));
			}
		}
		BagAttribute values = new BagAttribute(this.dataType.getXACMLTypeURI(), convertedValues);
		return new CachedAttribute(this.dataType.getXACMLType(), this.id, values);
	}

}
