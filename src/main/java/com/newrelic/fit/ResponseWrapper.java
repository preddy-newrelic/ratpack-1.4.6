package com.newrelic.fit;

import com.newrelic.api.agent.HeaderType;

import ratpack.http.Response;

public class ResponseWrapper implements com.newrelic.api.agent.Response {

	private Response response = null;

	public ResponseWrapper(Response response_Instrument) {
		this.response  = response_Instrument;
	}

	@Override
	public HeaderType getHeaderType() {
		return HeaderType.HTTP;
	}

	@Override
	public void setHeader(String name, String value) {
		response.getHeaders().set(name, value);
	}

	@Override
	public String getContentType() {
		return response.getHeaders().get("Content-Type");
	}

	@Override
	public int getStatus() throws Exception {
		return response.getStatus().getCode();
	}

	@Override
	public String getStatusMessage() throws Exception {
		return response.getStatus().getMessage();
	}

}
