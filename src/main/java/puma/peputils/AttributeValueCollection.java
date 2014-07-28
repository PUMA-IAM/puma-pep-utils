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
package puma.peputils;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import puma.peputils.attributes.AttributeValue;

import com.sun.xacml.ctx.CachedAttribute;


/**
 * Just an abstract superclass for all classes that require a collection
 * of attribute values, like Subject, Object and Action and Environment.
 * 
 * @author Maarten Decat
 *
 */
public class AttributeValueCollection<T extends AttributeValue> {
	
	protected Collection<T> attributeValues = new LinkedList<T>();

	public Collection<T> getAttributeValues() {
		return attributeValues;
	}
	
	public void addAttributeValue(T value) {
		this.attributeValues.add(value);
	}
	
	/**
	 * Returns the attribute with given attribute id. Returns null if no
	 * such attribute exits.
	 * 
	 * Modifying the returned attribute affects the attribute in this attribute
	 * collection.
	 */
	public T getAttributeValue(String id) {
		for(T attributeValue: getAttributeValues()) {
			if(attributeValue.getId().equals(id)) {
				return attributeValue;
			}
		}
		return null;
	}
	
	public void removeAttributeValue(String id) {
		for (T attributeValue: getAttributeValues()) {
			if (attributeValue.getId().equals(id)) {
				this.attributeValues.remove(attributeValue);
			}
		}
	}
	
	public void removeAttributeValue(T attributeValue) {
		if (this.attributeValues.contains(attributeValue)) {
			this.attributeValues.remove(attributeValue);
		}
	}
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public AttributeValueCollection() {
		// nothing to do
	}
	
	public AttributeValueCollection(T... attributeValues) {
		this.attributeValues.addAll(Arrays.asList(attributeValues));
	}
	
	public AttributeValueCollection(Collection<T> attributeValues) {
		this.attributeValues.addAll(attributeValues);
	}
	
	/*************************
	 * HELPER METHODS
	 *************************/
	
	/**
	 * Returns the collection of attributes in this AttributesCollection as 
	 * cached attributes.
	 * 
	 * @return
	 */
	public Collection<CachedAttribute> asCachedAttributes() {
		List<CachedAttribute> result = new LinkedList<CachedAttribute>();
		for(AttributeValue av: this.getAttributeValues()) {
			result.add(av.toCachedAttribute());
		}
		return result;
	}

}
