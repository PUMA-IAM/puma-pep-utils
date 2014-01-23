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
