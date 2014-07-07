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

import java.net.URI;

import com.sun.xacml.attr.BooleanAttribute;
import com.sun.xacml.attr.DateTimeAttribute;
import com.sun.xacml.attr.DoubleAttribute;
import com.sun.xacml.attr.IntegerAttribute;
import com.sun.xacml.attr.StringAttribute;

public enum DataType {
	
	String(StringAttribute.identifier, StringAttribute.identifierURI),
	Integer(IntegerAttribute.identifier, IntegerAttribute.identifierURI),
	DateTime(DateTimeAttribute.identifier, DateTimeAttribute.identifierURI),
	Boolean(BooleanAttribute.identifier, BooleanAttribute.identifierURI),
	Double(DoubleAttribute.identifier, DoubleAttribute.identifierURI);
	
	private String xacmlType;
	
	private URI xacmlTypeURI;
	
	private DataType(String xacmlType, URI xacmlTypeURI) {
		this.xacmlType = xacmlType;
		this.xacmlTypeURI = xacmlTypeURI;
	}
	
	public String getXACMLType() {
		return this.xacmlType;
	}
	
	public URI getXACMLTypeURI() {
		return this.xacmlTypeURI;
	}

}
