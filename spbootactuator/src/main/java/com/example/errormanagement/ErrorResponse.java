package com.example.errormanagement;

public class ErrorResponse {
private Integer statusCode;
private String statusMethod;
public Integer getStatusCode() {
	return statusCode;
}
public void setStatusCode(Integer statusCode) {
	this.statusCode = statusCode;
}
public String getStatusMethod() {
	return statusMethod;
}
public void setStatusMethod(String statusMethod) {
	this.statusMethod = statusMethod;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((statusCode == null) ? 0 : statusCode.hashCode());
	result = prime * result + ((statusMethod == null) ? 0 : statusMethod.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	
	ErrorResponse other = (ErrorResponse) obj;
	
	if (statusCode == null) {
		if (other.statusCode != null)
			return false;
	} else if (!statusCode.equals(other.statusCode))
		return false;
	
	if (statusMethod == null) {
		if (other.statusMethod != null)
			return false;
	} else if (!statusMethod.equals(other.statusMethod))
		return false;
	return true;
	
}

}
