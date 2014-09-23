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
import puma.peputils.attributes.SubjectAttributeValue;


/**
 * Class representing a subject for use in the queries to the PEP.
 * A subject has an id and possible some attributes attached.
 * 
 * @author Maarten Decat
 *
 */
public class Subject extends NamedAttributeValueCollection<SubjectAttributeValue> {
	
	/**************************
	 * CONSTRUCTORS
	 **************************/
	
	public Subject(String id) {
		super(id);
	}
	
	public Subject(String id, SubjectAttributeValue... attributeValues) {
		super(id, attributeValues);
	}
	
	public Subject(String id, Collection<SubjectAttributeValue> attributeValues) {
		super(id, attributeValues);
	}

	@Override
	protected void addIdAttribute(String id) {
		this.addAttributeValue(new SubjectAttributeValue("id", Multiplicity.ATOMIC, id));
	}

}
