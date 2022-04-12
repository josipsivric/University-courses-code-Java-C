package hr.fer.zemris.java.webserver;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class RequestContext {

	private OutputStream outputStream;
	private Charset charset;
	
	public String encoding = "UTF-8";
	public int statusCode = 200;
	public String statusText = "OK";
	public  String mimeType = "text/html";
	
	private Map<String,String> parameters;
	private Map<String,String> persistentParameters;
	private List<RCCookie> outputCookies;
	
	private boolean headerGenerated = false;
	
	public RequestContext(OutputStream outputStream,
			Map<String, String> parameters,
			Map<String, String> persistentParameters,
			List<RCCookie> outputCookies) {
		if(outputStream == null) {
			System.err.println("OutputStream must be defined!");
			System.exit(-1);
		} else
			this.outputStream = outputStream;
		if(parameters != null)
			this.parameters = parameters;
		if(persistentParameters != null)
			this.persistentParameters = persistentParameters;
		if(outputCookies != null)
			this.outputCookies = outputCookies;
	}
	
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getParameter(String name) {
		if(parameters.containsKey(name))
			return parameters.get(name);
		else
			return null;
	}
	
	public String getPersistentParameter(String name) {
		if(persistentParameters.containsKey(name))
			return persistentParameters.get(name);
		else
			return null;
	}
	
	public void setPersistentParameter(String name, String value) {
		persistentParameters.put(name, value);
	}
	
	public RequestContext write(byte[] data) throws IOException {
		return null;
		
	}
	
	public RequestContext write(String text) throws IOException {
		return null;
		
	}
	
	
	public static class RCCookie {
		
		private String name;
		private String value;
		private String domain;
		private String path;
		
		private Integer maxAge;
		
		public RCCookie(String name, String value, String domain, String path, Integer maxAge) {
			super();
			this.name = name;
			this.value = value;
			this.domain = domain;
			this.path = path;
			this.maxAge = maxAge;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}

		public String getDomain() {
			return domain;
		}

		public String getPath() {
			return path;
		}

		public Integer getMaxAge() {
			return maxAge;
		}
	}
	
	
}
