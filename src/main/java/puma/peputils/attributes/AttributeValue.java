/*******************************************************************************
 * Copyright 2014 KU Leuven Research and Developement - iMinds - Distrinet 
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *    
 *    Administrative Contact: dnet-project-office@cs.kuleuven.be
 *    Technical Contact: maarten.decat@cs.kuleuven.be
 *    Author: maarten.decat@cs.kuleuven.be
 ******************************************************************************/
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
 * Class used for representing a simple attribute value.
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
	
	private Multiplicity multiplicity;
	
	public Multiplicity getMultiplicity() {
		return multiplicity;
	}
	
	public void setMultiplicity(Multiplicity multiplicity) {
		this.multiplicity = multiplicity;
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
	
	public AttributeValue(String id, Multiplicity multiplicity) {
		this();
		this.id = id;
		this.multiplicity = multiplicity;
	}
	
	public AttributeValue(String id, Multiplicity multiplicity, DataType dataType) {
		this(id, multiplicity);
		this.dataType = dataType;
	}
	
	public AttributeValue(String id, Multiplicity multiplicity, Integer value) {
		this(id, multiplicity, DataType.Integer);
		this.addValue(value);
	}
	
	public AttributeValue(String id, Multiplicity multiplicity, Date value) {
		this(id, multiplicity, DataType.DateTime);
		this.addValue(value);
	}
	
	public AttributeValue(String id, Multiplicity multiplicity, String value) {
		this(id, multiplicity, DataType.String);
		this.addValue(value);
	}
	
	public AttributeValue(String id, Multiplicity multiplicity, Boolean value) {
		this(id, multiplicity, DataType.Boolean);
		this.addValue(value);
	}
	
	/**********************
	 * ADDING ATTRIBUTES
	 **********************/
	
	public void addValue(Integer value) {
		// an AttributeValue with multiplicity ATOMIC should have only (exactly) one value
		if(this.multiplicity == Multiplicity.ATOMIC && !this.values.isEmpty())
			throw new IllegalStateException("This atomic attribute already has a value.");
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
		// an AttributeValue with multiplicity ATOMIC should have only (exactly) one value
		if(this.multiplicity == Multiplicity.ATOMIC && !this.values.isEmpty())
			throw new IllegalStateException("This atomic attribute already has a value.");
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
		// an AttributeValue with multiplicity ATOMIC should have only (exactly) one value
		if(this.multiplicity == Multiplicity.ATOMIC && !this.values.isEmpty())
			throw new IllegalStateException("This atomic attribute already has a value.");
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
		// an AttributeValue with multiplicity ATOMIC should have only (exactly) one value
		if(this.multiplicity == Multiplicity.ATOMIC && !this.values.isEmpty())
			throw new IllegalStateException("This atomic attribute already has a value.");
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
	
	public void addValue(Double value) {
		// an AttributeValue with multiplicity ATOMIC should have only (exactly) one value
		if(this.multiplicity == Multiplicity.ATOMIC && !this.values.isEmpty())
			throw new IllegalStateException("This atomic attribute already has a value.");
		// make sure that all values are the same
		if(this.dataType == null) {
			// if there are no values yet, then set the type of this AttributeValue
			this.dataType = DataType.Double;
		} else if(this.dataType != DataType.Double) {
			// if this AttributeValue already had a type, check that its the same
			throw new IllegalArgumentException("Expected " + this.dataType + ", but received " + DataType.Double);
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
