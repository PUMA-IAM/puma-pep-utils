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

import java.util.Collection;

import puma.peputils.attributes.Multiplicity;
import puma.peputils.attributes.ObjectAttributeValue;


/**
 * Class representing an object for use in the queries to the PEP.
 * An object has an id and possible some attributes attached.
 * 
 * @author Maarten Decat
 *
 */
public class Object extends NamedAttributeValueCollection<ObjectAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Object(String id) {
		super(id);
	}
	
	public Object(String id, ObjectAttributeValue... attributeValues) {
		super(id, attributeValues);
	}
	
	public Object(String id, Collection<ObjectAttributeValue> attributeValues) {
		super(id, attributeValues);
	}

	@Override
	protected void addIdAttribute(String id) {
		this.addAttributeValue(new ObjectAttributeValue("id", Multiplicity.ATOMIC, id));
	}

}
