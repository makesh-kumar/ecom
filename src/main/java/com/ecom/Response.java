package com.ecom;

public class Response 
{
	private String name;
	private String type;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "ErrorResponse [name=" + name + ", type=" + type + "]";
	}
	
	

}
