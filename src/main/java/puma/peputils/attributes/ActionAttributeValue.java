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
