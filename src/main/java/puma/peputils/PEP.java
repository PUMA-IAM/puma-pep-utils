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

/**
 * Interface for all PEPs. A PEP provides only one method: 
 * 	
 * 	isAuthorized(subject, object, action, environment)
 * 
 * 
 * @author Maarten Decat
 *
 */
public interface PEP {
	
	/**
	 * This is the only method which should be needed to get an access control decision:
	 * this method will return whether the given subject is allowed to do the given action
	 * on the given object in the given environment.
	 * The subject, object, action and environment are all just collections of attributes,
	 * the subject, object and action  
	 * 
	 * @param subject
	 * @param object
	 * @param action
	 * @param environment
	 * @return
	 */
	public boolean isAuthorized(Subject subject, Object object, Action action, Environment environment);

}
