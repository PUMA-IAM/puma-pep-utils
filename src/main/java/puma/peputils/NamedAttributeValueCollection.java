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

import puma.peputils.attributes.AttributeValue;


/**
 * Just an abstract superclass for all classes that require an id and a collection
 * of attribute values, like Subject, Object and Action.
 * 
 * @author Maarten Decat
 *
 */
public abstract class NamedAttributeValueCollection<T extends AttributeValue> extends AttributeValueCollection<T> {
	
	private String id;

	public String getId() {
		return id;
	}
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public NamedAttributeValueCollection(String id) {
		super();
		this.id = id;
		// IMPORTANT: Java does not let me instantiate T here, although every subclass of
		// AttributeValue provides a non-abstract constructor. Therefore: add the correct
		// attribute in the subclasses!
		this.addIdAttribute(id);
	}
	
	public NamedAttributeValueCollection(String id, T... attributeValues) {
		this(id);
		this.attributeValues.addAll(Arrays.asList(attributeValues));
	}
	
	public NamedAttributeValueCollection(String id, Collection<T> attributeValues) {
		this(id);
		this.attributeValues.addAll(attributeValues);
	}
	
	protected abstract void addIdAttribute(String id);

}
