package com.excellenceict.eprescription.util;

public final class UrlConstraint {
	private UrlConstraint() {};
	
	private static final String VERSION = "/v1";
	private static final String API = "/api";
	
	public static class ApiManager {
		public static final String ROOT = VERSION+API+"/doctmate";
		public static final String CREATE = VERSION+API+"/create";
		public static final String UPDATE = VERSION+API+"/update/{id}";
		
		}
}
