package com.balietek.exceptions;

public class ResourceNoFoundException extends Exception{
    
    private static final long serialVersionUID = 1L;
    private String resourceName;
	private String fieldName;
	private Object fieldValue;

    public ResourceNoFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("Aucun %s avec %s : '%s'", resourceName,fieldName,fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
}
