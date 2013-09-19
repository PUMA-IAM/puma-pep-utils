package puma.peputils.attributes;

import java.net.URI;

import com.sun.xacml.attr.BooleanAttribute;
import com.sun.xacml.attr.DateTimeAttribute;
import com.sun.xacml.attr.IntegerAttribute;
import com.sun.xacml.attr.StringAttribute;

public enum DataType {
	
	String(StringAttribute.identifier, StringAttribute.identifierURI),
	Integer(IntegerAttribute.identifier, IntegerAttribute.identifierURI),
	DateTime(DateTimeAttribute.identifier, DateTimeAttribute.identifierURI),
	Boolean(BooleanAttribute.identifier, BooleanAttribute.identifierURI);
	
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
